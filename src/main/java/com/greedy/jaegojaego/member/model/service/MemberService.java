package com.greedy.jaegojaego.member.model.service;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.franchise.dto.FranchiseAccountDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseInfoDTO;
import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.franchise.repository.FranchiseAccountRepository;
import com.greedy.jaegojaego.franchise.repository.FranchiseRepository;
import com.greedy.jaegojaego.member.model.dto.*;
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
import java.util.Optional;
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

    public MemberListDTO findMemberList(String searchWord) {

        /* 본사 직원 계정 목록 조회 */
        List<CompanyAccount> memberList = companyAccountRepository.searchMembers(searchWord);
        List<CompanyAccountDTO> memberDTOList =  memberList.stream().map(member -> modelMappper.map(member, CompanyAccountDTO.class)).collect(Collectors.toList());

        /* 삭제된 본사 직원 계정 목록 조회 */
        List<CompanyAccount> removedMemberList = companyAccountRepository.searchRemovedMember(searchWord);
        List<CompanyAccountDTO> removedMembers = removedMemberList.stream().map(removedMember -> modelMappper.map(removedMember, CompanyAccountDTO.class)).collect(Collectors.toList());

        MemberListDTO memberListDTO = new MemberListDTO();
        memberListDTO.setMembers(memberDTOList);
        memberListDTO.setRemovedMembers(removedMembers);

        return memberListDTO;

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

    public void modifyMemberInfo(CompanyAccountDTO member) {

        CompanyAccount companyAccount = new CompanyAccount();

        if(!member.getMemberPwd().isEmpty()) {

            Member memberPwd = memberRepository.findMemberByMemberNo(member.getMemberNo());

            PasswordUpdatedRecord passwordUpdatedRecord = new PasswordUpdatedRecord();
            /* 새로 변경할 비밀번호가 아닌 이전 비빌번호를 내역에 저장함 */
            passwordUpdatedRecord.setPasswordUpdatedRecordPwd(memberPwd.getMemberPwd());
            passwordUpdatedRecord.setPasswordUpdatedRecordDate(LocalDateTime.now());
            passwordUpdatedRecord.setMemberNo(member.getMemberNo());


            /*변경된 비밀번호 사항을 저장해준다.*/
            companyAccount.setMemberPwd(passwordEncoder.encode(member.getMemberPwd()));
            companyAccount.setMemberPwdUpdateDate(LocalDateTime.now());
            /* 관리자가 임의로 지정한 비밀번호이기 때문에 비밀번호 초기화 여부는 Y로 체크해준다. */
            companyAccount.setMemberPwdInitStatus("Y");
        }

        /* entity 타입으로 값 변경 필요 */
        companyAccount.setMemberNo(member.getMemberNo());
        companyAccount.setMemberEmail(member.getMemberEmail());
        companyAccount.setOfficePhoneNumber(member.getOfficePhoneNumber());
        companyAccount.setMemberCellPhone(member.getMemberCellPhone());
        companyAccount.setDepartmentNo(member.getDepartment().getDepartmentNo());

        companyAccountRepository.updateMember(companyAccount);
    }


    @Transactional
    public String removeMember(Integer memberNo) {

        Member member = memberRepository.findMemberByMemberNo(memberNo);

        member.setMemberRemoveStatus("N");
        member.setMemberRemovedDate(LocalDateTime.now());

        memberRepository.save(member);

        /* result 결과에 따라서 뷰를 결정하기 위해 컨트롤러로 리턴 */
        String result = member.getOfficeDivision();

        return result;
    }

    @Transactional
    public String restoreMember(Integer memberNo) {

        Member member = memberRepository.findMemberByMemberNo(memberNo);

        member.setMemberRemoveStatus("Y");
        member.setMemberRemovedDate(null);

        memberRepository.save(member);

        String result = member.getOfficeDivision();

        return result;
    }

    public List<CompanyAccountDTO> findSuperVisor() {

        List<CompanyAccount> supervisors = companyAccountRepository.findSupervisorByDepartment_DepartmentNo(2);

        return supervisors.stream().map(supervisor -> modelMappper.map(supervisor, CompanyAccountDTO.class)).collect(Collectors.toList());
    }
}