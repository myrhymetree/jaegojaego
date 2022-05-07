package com.greedy.jaegojaego.member.model.service;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.franchise.dto.FranchiseAccountDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseInfoDTO;
import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.franchise.repository.FranchiseAccountRepository;
import com.greedy.jaegojaego.franchise.repository.FranchiseRepository;
import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.DepartmentDTO;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.dto.MemberSearchCondition;
import com.greedy.jaegojaego.member.model.entity.*;
import com.greedy.jaegojaego.member.model.repository.*;
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
public class MemberService {

    private final MemberRepository memberRepository;
    private final DepartmentRepository departmentRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final CompanyAccountRepository companyAccountRepository;
    private final FranchiseRepository franchiseRepository;
    private final FranchiseAccountRepository franchiseAccountRepository;
    private final PasswordUpdatedRecordRepository passwordUpdatedRecordRepository;
    private final ModelMapper modelMappper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, DepartmentRepository departmentRepository,
                         MemberRoleRepository memberRoleRepository, CompanyAccountRepository companyAccountRepository, FranchiseRepository franchiseRepository, FranchiseAccountRepository franchiseAccountRepository, PasswordUpdatedRecordRepository passwordUpdatedRecordRepository, ModelMapper modelMappper, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.departmentRepository = departmentRepository;
        this.memberRoleRepository = memberRoleRepository;
        this.companyAccountRepository = companyAccountRepository;
        this.franchiseRepository = franchiseRepository;
        this.franchiseAccountRepository = franchiseAccountRepository;
        this.passwordUpdatedRecordRepository = passwordUpdatedRecordRepository;
        this.modelMappper = modelMappper;
        this.passwordEncoder = passwordEncoder;
    }

    public MemberDTO findMemberById(String memberId) {

        Member member = memberRepository.findMemberByMemberId(memberId);

        return modelMappper.map(member, MemberDTO.class);
    }

    @Transactional
    public void registNewMember(CompanyAccountDTO newMember) {

        Department department = departmentRepository.findByDepartmentNo(newMember.getDepartment().getDepartmentNo());

        DepartmentDTO departmentDTO = modelMappper.map(department, DepartmentDTO.class);

        newMember.setDepartment(departmentDTO);

        CompanyAccount member = modelMappper.map(newMember, CompanyAccount.class);

        CompanyAccount registedMember = memberRepository.save(member);

        MemberRolePK memberRolePK  = new MemberRolePK();
        memberRolePK.setAuthorityCode(2);
        memberRolePK.setMemberNo(registedMember.getMemberNo());
        MemberRole memberRole = new MemberRole();
        memberRole.setMemberRolePK(memberRolePK);

        memberRoleRepository.save(memberRole);

//        Member member = new Member();
//        CompanyAccount companyAccount = new CompanyAccount();
//        companyAccount.setMemberNo(modelMappper.map(newMember, Member.class).getMemberNo());
//        memberRepository.save(memberrole);

    }

    public List<DepartmentDTO> findDepartmentAll() {

        List<Department> departmentList = departmentRepository.findAll();

        return departmentList.stream().map(department -> modelMappper.map(department, DepartmentDTO.class)).collect(Collectors.toList());
    }

    public boolean duplicationCheckId(String memberId) {

        boolean status = memberRepository.existsByMemberId(memberId);

        return status;
    }

    public List<CompanyAccountDTO> findMemberList(String searchWord) {

        List<CompanyAccount> memberList = companyAccountRepository.searchMembers(searchWord);

        List<CompanyAccountDTO> memberDTOlist =  memberList.stream().map(member -> modelMappper.map(member, CompanyAccountDTO.class)).collect(Collectors.toList());

        return memberDTOlist;

    }

    public Integer countAll() {

        Integer count = companyAccountRepository.countAllBy();

        return count;
    }

    public Object findLoginMemberInfo(CustomUser customUser) {

        Integer memberNo = customUser.getMemberNo();
        String memberDivision = customUser.getMemberDivision();
        String officeDivision = customUser.getOfficeDivision();

        if(customUser.getMemberDivision().equals("본사")) {

            CompanyAccount companyAccount = companyAccountRepository.findAllByMemberNoAndMemberDivision(memberNo, memberDivision);

            CompanyAccountDTO loginMember = modelMappper.map(companyAccount, CompanyAccountDTO.class);

            return loginMember;

        } else if(memberDivision.equals("가맹점") && officeDivision.equals("대표자") ) {

            FranchiseInfo franchiseInfo = franchiseRepository.findAllByMemberNoAndMemberDivisionAndOfficeDivision(memberNo, memberDivision, officeDivision);

            FranchiseInfoDTO loginMember = modelMappper.map(franchiseInfo, FranchiseInfoDTO.class);

            return loginMember;

        } else {

            FranchiseAccount franchiseAccount = franchiseAccountRepository.findAllByMemberNoAndMemberDivisionAndOfficeDivision(memberNo, memberDivision, officeDivision);

            FranchiseAccountDTO loginMember = modelMappper.map(franchiseAccount, FranchiseAccountDTO.class);

            return loginMember;
        }
    }

    @Transactional
    public void updateLoginMemberInfo(CompanyAccountDTO member) {

        /* 로그인 인증 정보 가져오기 */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        /* entity타입으로 값 변경 */
        CompanyAccount companyAccount = new CompanyAccount();

        if(!member.getMemberPwd().isEmpty()) {

            /* 비밀번호 변경이력 추가 */
            PasswordUpdatedRecord passwordUpdatedRecord = new PasswordUpdatedRecord();
            passwordUpdatedRecord.setPasswordUpdatedRecordPwd(customUser.getMemberPwd());
            passwordUpdatedRecord.setPasswordUpdatedRecordDate(LocalDateTime.now());
            passwordUpdatedRecord.setMemberNo(customUser.getMemberNo());

            companyAccount.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));
            companyAccount.setMemberPwdUpdateDate(LocalDateTime.now());
            companyAccount.setMemberPwdInitStatus("N");

            passwordUpdatedRecordRepository.save(passwordUpdatedRecord);
        }

        companyAccount.setMemberNo(customUser.getMemberNo());
        companyAccount.setMemberEmail(member.getMemberEmail());
        companyAccount.setOfficePhoneNumber(member.getOfficePhoneNumber());
        companyAccount.setMemberCellPhone(member.getMemberCellPhone());

        companyAccountRepository.updateMember(companyAccount);

    }

    public CompanyAccountDTO findMemberDetailInfo(Integer memberNo) {

        CompanyAccount memberDetailInfo =  companyAccountRepository.findByMemberNo(memberNo);

        return modelMappper.map(memberDetailInfo, CompanyAccountDTO.class);
    }
}