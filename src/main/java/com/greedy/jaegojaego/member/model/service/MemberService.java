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
import org.modelmapper.convention.MatchingStrategies;
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

/**
 * <pre>
 * Class : MemberService
 * Comment : 본사 직원 계정 관련 서비스 메소드를 모아놓은 Service 클래스 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 *
 * @author 박성준
 * @version 1.0
 */
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

    /**
     * strictModelMapper : modelMapper Strict 전략을 이용하기 위한 private 메소드
     * @return modelMapper : 매핑 전략을 사용하기 위한 modelMapper 객체 반환
     *
     * @author 박성준
     */
    private ModelMapper strictModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    /**
     * Instantiates a new Member service.
     *
     * @param memberRepository                the member repository
     * @param departmentRepository            the department repository
     * @param memberRoleRepository            the member role repository
     * @param companyAccountRepository        the company account repository
     * @param franchiseRepository             the franchise repository
     * @param franchiseAccountRepository      the franchise account repository
     * @param passwordUpdatedRecordRepository the password updated record repository
     * @param modelMappper                    the model mappper
     * @param passwordEncoder                 the password encoder
     */
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

    /**
     * 본사 계정 정보 조회 메소드
     *
     * @param memberId 본사 계정 아이디
     * @return the member dto 본사 계정 정보 반환
     */
    public MemberDTO findMemberById(String memberId) {

        String status = "Y";

        Member member = memberRepository.findMemberByMemberId(memberId);

        return modelMappper.map(member, MemberDTO.class);
    }

    /**
     * 본사 계정 등록 메소드
     *
     * @param newMember 본사 신규 계정 정보
     */
    @Transactional
    public void registNewMember(CompanyAccountDTO newMember) {

//        Department department = departmentRepository.findByDepartmentNo(newMember.getDepartment().getDepartmentNo());
//
//        DepartmentDTO departmentDTO = modelMappper.map(department, DepartmentDTO.class);
//
//        newMember.setDepartment(departmentDTO);

        CompanyAccount member = modelMappper.map(newMember, CompanyAccount.class);

        CompanyAccount registedMember = memberRepository.save(member);

        MemberRolePK memberRolePK  = new MemberRolePK();
        memberRolePK.setAuthorityCode(2);
        memberRolePK.setMemberNo(registedMember.getMemberNo());
        MemberRole memberRole = new MemberRole();
        memberRole.setMemberRolePK(memberRolePK);

        memberRoleRepository.save(memberRole);

    }

    /**
     * 본사 부서 목록 조회 메소드
     *
     * @return the list 본사 부서 목록 반환
     */
    public List<DepartmentDTO> findDepartmentAll() {

        List<Department> departmentList = departmentRepository.findAll();

        return departmentList.stream().map(department -> modelMappper.map(department, DepartmentDTO.class)).collect(Collectors.toList());
    }

    /**
     * 아이디 중복체크 메소드
     *
     * @param memberId 중복 여부를 체크할 아이디
     * @return the boolean 결과 값(true/false)
     */
    public boolean duplicationCheckId(String memberId) {

        boolean status = memberRepository.existsByMemberId(memberId);

        return status;
    }

    /**
     * 본사 직원 계정 목록 조회 메소드
     *
     * @param searchWord 검색어
     * @return the member list dto 본사 직원 계정 목록 반환
     */
    public MemberListDTO findMemberList(String searchWord) {

        /* 본사 직원 계정 목록 조회 */
        List<CompanyAccount> memberList = companyAccountRepository.searchMembers(searchWord);
        List<CompanyAccountDTO> memberDTOList =  memberList.stream().map(member -> modelMappper.map(member, CompanyAccountDTO.class)).collect(Collectors.toList());

        /* 삭제된 본사 직원 계정 목록 조회 */
        List<CompanyAccount> removedMemberList = companyAccountRepository.searchRemovedMember(searchWord);
        List<CompanyAccountDTO> removedMembers = removedMemberList.stream().map(removedMember -> modelMappper.map(removedMember, CompanyAccountDTO.class)).collect(Collectors.toList());

        /* 컨트롤러에 인자 하나로 전달하기 위해서 DTO타입을 생성해서 담아줌 */
        MemberListDTO memberListDTO = new MemberListDTO();
        memberListDTO.setMembers(memberDTOList);
        memberListDTO.setRemovedMembers(removedMembers);

        return memberListDTO;

    }

    /**
     * 로그인한 계정 정보(개인정보) 조회 메소드
     *
     * @param customUser 로그인한 계정 정보
     * @return the object 본사, 가맹점, 직원, 대표자 여부에 따른 서로 다른 계정정보 반환
     */
    public Object findLoginMemberInfo(CustomUser customUser) {

        Integer memberNo = customUser.getMemberNo();
        String memberDivision = customUser.getMemberDivision();
        String officeDivision = customUser.getOfficeDivision();

        if(customUser.getMemberDivision().equals("본사")) {

            CompanyAccount companyAccount = companyAccountRepository.findAllByMemberNoAndMemberDivision(memberNo, memberDivision);

            CompanyAccountDTO loginMember = strictModelMapper().map(companyAccount, CompanyAccountDTO.class);

            return loginMember;

        } else if(memberDivision.equals("가맹점") && officeDivision.equals("대표자") ) {

            FranchiseInfo franchiseInfo = franchiseRepository.findAllByMemberNoAndMemberDivisionAndOfficeDivision(memberNo, memberDivision, officeDivision);

            FranchiseInfoDTO loginMember = strictModelMapper().map(franchiseInfo, FranchiseInfoDTO.class);

            return loginMember;

        } else {        // 가맹점 직원

            FranchiseAccount franchiseAccount = franchiseAccountRepository.findAllByMemberNoAndMemberDivisionAndOfficeDivision(memberNo, memberDivision, officeDivision);

            FranchiseAccountDTO loginMember = modelMappper.map(franchiseAccount, FranchiseAccountDTO.class);

            return loginMember;
        }
    }

    /**
     * 로그인한 계정의 정보 수정
     *
     * @param member 수정할 계정 정보
     */
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

    /**
     * 본사 직원 계정 상세조회 메소드.
     *
     * @param memberNo 조회할 계정 번호
     * @return the company account dto 상세조회한 계정 정보
     */
    public CompanyAccountDTO findMemberDetailInfo(Integer memberNo) {

        CompanyAccount memberDetailInfo =  companyAccountRepository.findByMemberNo(memberNo);

        return modelMappper.map(memberDetailInfo, CompanyAccountDTO.class);
    }

    /**
     * 본사직원 계정목록 수정 메소드
     *
     * @param member 수정할 본사직원의 정보
     */
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


    /**
     * 본사직원 계정 삭제 메소드
     *
     * @param memberNo 삭제할 계정 번호
     * @return the string 리다이렉트할 뷰를 나타내기 위한 조건 값 반환
     */
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

    /**
     * 삭제된 본사 직원 계정 복구 메소드
     *
     * @param memberNo 복구할 본사 직원 계정 번호
     * @return the string 리다이렉트할 뷰를 나타내기 위한 조건 값 반환
     */
    @Transactional
    public String restoreMember(Integer memberNo) {

        Member member = memberRepository.findMemberByMemberNo(memberNo);

        member.setMemberRemoveStatus("Y");
        member.setMemberRemovedDate(null);

        memberRepository.save(member);

        String result = member.getOfficeDivision();

        return result;
    }

    /**
     * 가맹계약팀 본사 직원 목록 조회 메소드.
     *
     * @return the list 가맹계약팀 본사직원 목록 반환
     */
    public List<CompanyAccountDTO> findSuperVisor() {

        List<CompanyAccount> supervisors = companyAccountRepository.findSupervisorByDepartment_DepartmentNo(2);

        return supervisors.stream().map(supervisor -> modelMappper.map(supervisor, CompanyAccountDTO.class)).collect(Collectors.toList());
    }
}