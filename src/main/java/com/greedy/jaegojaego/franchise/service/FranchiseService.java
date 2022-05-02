package com.greedy.jaegojaego.franchise.service;

import com.greedy.jaegojaego.franchise.dto.FranchiseAccountDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseContractUpdatedRecordDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseInfoDTO;
import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;
import com.greedy.jaegojaego.franchise.entity.FranchiseContractUpdatedRecord;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.franchise.repository.FranchiseContractRepository;
import com.greedy.jaegojaego.franchise.repository.FranchiseRepository;
import com.greedy.jaegojaego.member.model.entity.MemberRole;
import com.greedy.jaegojaego.member.model.entity.MemberRolePK;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
import com.greedy.jaegojaego.member.model.repository.MemberRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final FranchiseContractRepository franchiseContractRepository;
    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FranchiseService(FranchiseRepository franchiseRepository, FranchiseContractRepository franchiseContractRepository, MemberRepository memberRepository, MemberRoleRepository memberRoleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.franchiseRepository = franchiseRepository;
        this.franchiseContractRepository = franchiseContractRepository;
        this.memberRepository = memberRepository;
        this.memberRoleRepository = memberRoleRepository;
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
}
