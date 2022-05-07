package com.greedy.jaegojaego.franchise.service;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.franchise.dto.FranchiseAccountDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseContractUpdatedRecordDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseInfoDTO;
import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;
import com.greedy.jaegojaego.franchise.entity.FranchiseContractUpdatedRecord;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.franchise.repository.FranchiseAccountRepository;
import com.greedy.jaegojaego.franchise.repository.FranchiseContractRepository;
import com.greedy.jaegojaego.franchise.repository.FranchiseRepository;
import com.greedy.jaegojaego.member.model.entity.MemberRole;
import com.greedy.jaegojaego.member.model.entity.MemberRolePK;
import com.greedy.jaegojaego.member.model.entity.PasswordUpdatedRecord;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
import com.greedy.jaegojaego.member.model.repository.MemberRoleRepository;
import com.greedy.jaegojaego.member.model.repository.PasswordUpdatedRecordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final FranchiseAccountRepository franchiseAccountRepository;
    private final FranchiseContractRepository franchiseContractRepository;
    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final PasswordUpdatedRecordRepository passwordUpdatedRecordRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FranchiseService(FranchiseRepository franchiseRepository, FranchiseAccountRepository franchiseAccountRepository, FranchiseContractRepository franchiseContractRepository, MemberRepository memberRepository, MemberRoleRepository memberRoleRepository, PasswordUpdatedRecordRepository passwordUpdatedRecordRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.franchiseRepository = franchiseRepository;
        this.franchiseAccountRepository = franchiseAccountRepository;
        this.franchiseContractRepository = franchiseContractRepository;
        this.memberRepository = memberRepository;
        this.memberRoleRepository = memberRoleRepository;
        this.passwordUpdatedRecordRepository = passwordUpdatedRecordRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registFranchise(FranchiseInfoDTO franchiseInfo, FranchiseContractUpdatedRecordDTO franchiseContractUpdatedRecordDTO) {

        franchiseInfo.setOfficeDivision("대표자");

        FranchiseInfo franchise = modelMapper.map(franchiseInfo, FranchiseInfo.class);

        FranchiseInfo result = memberRepository.save(franchise);

        MemberRolePK memberRolePK = new MemberRolePK();
        memberRolePK.setAuthorityCode(3);
        memberRolePK.setMemberNo(franchise.getMemberNo());
        MemberRole memberRole = new MemberRole();
        memberRole.setMemberRolePK(memberRolePK);

        memberRoleRepository.save(memberRole);

        franchiseContractUpdatedRecordDTO.setFranchiseRepresentativeNo(result.getMemberNo());

        FranchiseContractUpdatedRecord franchiseContractUpdatedRecord = modelMapper.map(franchiseContractUpdatedRecordDTO, FranchiseContractUpdatedRecord.class);

        franchiseContractRepository.save(franchiseContractUpdatedRecord);
    }

    @Transactional
    public void registManager(FranchiseAccountDTO manager) {

        System.out.println("manager = " + manager);
        
        manager.setMemberPwd(passwordEncoder.encode(manager.getMemberPwd()));
        manager.setMemberCreatedDate(LocalDateTime.now());
        manager.setMemberPwdInitStatus("Y");
        manager.setMemberRemoveStatus("Y");
        manager.setOfficeDivision("직원");
        manager.setMemberDivision("가맹점");

        FranchiseAccount convertedManager = modelMapper.map(manager, FranchiseAccount.class);

        FranchiseAccount result = memberRepository.save(convertedManager);

        MemberRolePK memberRolePK = new MemberRolePK();
        memberRolePK.setAuthorityCode(4);
        memberRolePK.setMemberNo(result.getMemberNo());
        MemberRole memberRole = new MemberRole();
        memberRole.setMemberRolePK(memberRolePK);

        memberRoleRepository.save(memberRole);

    }

    public List<FranchiseInfoDTO> findAllFranchise() {

         List<FranchiseInfo> franchiseInfos = franchiseRepository.findAll();

         return franchiseInfos.stream().map(franchise -> modelMapper.map(franchise, FranchiseInfoDTO.class)).collect(Collectors.toList());

    }

    @Transactional
    public void updateManagerInfo(FranchiseAccountDTO manager) {

        /* 로그인 인증 정보 가져오기 */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        /* entity타입으로 값 변경 */
        FranchiseAccount franchiseAccount = new FranchiseAccount();

        /* 비밀번호가 바뀔경우 변경된 비밀번호와 변경날짜, 변경상태를 넣어준다 */
        if(!manager.getMemberPwd().isEmpty()) {

            /* 비밀번호 변경이력 추가 */
            PasswordUpdatedRecord passwordUpdatedRecord = new PasswordUpdatedRecord();
            passwordUpdatedRecord.setPasswordUpdatedRecordPwd(customUser.getMemberPwd());
            passwordUpdatedRecord.setPasswordUpdatedRecordDate(LocalDateTime.now());
            passwordUpdatedRecord.setMemberNo(customUser.getMemberNo());

            franchiseAccount.setMemberPwd(passwordEncoder.encode(manager.getMemberPwd()));
            franchiseAccount.setMemberPwdUpdateDate(LocalDateTime.now());
            franchiseAccount.setMemberPwdInitStatus("N");

            passwordUpdatedRecordRepository.save(passwordUpdatedRecord);
        }

        franchiseAccount.setMemberNo(customUser.getMemberNo());
        franchiseAccount.setManagerEmail(manager.getManagerEmail());
        franchiseAccount.setManagerPhone(manager.getManagerPhone());

        System.out.println("매니저 번호는 = " + franchiseAccount.getMemberNo());
        System.out.println("franchiseAccount.getMemberPwd() = " + franchiseAccount.getMemberPwd());

        franchiseAccountRepository.updateManager(franchiseAccount);

    }

    @Transactional
    public void updateFranchiseInfo(FranchiseInfoDTO franchiseInfo) {

        /* 로그인 인증 정보 가져오기 */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        /* entity타입으로 값 변경 */
        FranchiseInfo franchise = new FranchiseInfo();

        /* 비밀번호가 바뀔 경우 변경된 비밀번호와 변경 날짜, 변경상태를 넣어준다 */
        if(!franchiseInfo.getMemberPwd().isEmpty()) {
            /* 비밀번호 변경이력 추가 */
            PasswordUpdatedRecord passwordUpdatedRecord = new PasswordUpdatedRecord();
            passwordUpdatedRecord.setPasswordUpdatedRecordPwd(customUser.getMemberPwd());
            passwordUpdatedRecord.setPasswordUpdatedRecordDate(LocalDateTime.now());
            passwordUpdatedRecord.setMemberNo(customUser.getMemberNo());

            franchise.setMemberPwd(passwordEncoder.encode(franchiseInfo.getMemberPwd()));
            franchise.setMemberPwdUpdateDate(LocalDateTime.now());
            franchise.setMemberPwdInitStatus("N");

            passwordUpdatedRecordRepository.save(passwordUpdatedRecord);
        }

        franchise.setMemberNo(customUser.getMemberNo());
        franchise.setRepresentativeEmail(franchiseInfo.getRepresentativeEmail());
        franchise.setRepresentativePhone(franchiseInfo.getRepresentativePhone());
        franchise.setPhone(franchiseInfo.getPhone());

        franchiseRepository.updateFranchise(franchise);
    }
}
