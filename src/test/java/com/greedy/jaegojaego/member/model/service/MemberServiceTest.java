package com.greedy.jaegojaego.member.model.service;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import com.greedy.jaegojaego.member.model.entity.Department;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.member.model.repository.CompanyAccountRepository;
import com.greedy.jaegojaego.member.model.repository.DepartmentRepository;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JaegojaegoApplication.class})
@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private CompanyAccountRepository companyAccountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {

    }

    @Test
    @Transactional
    public void 본사직원_계정생성() {

        Department department = departmentRepository.findByDepartmentNo(1);

        /* 상속관계에 의해서 자식 객체로 부모객체에 데이터를 입력할 수 있다. */
        CompanyAccount companyAccount = new CompanyAccount();
        companyAccount.setDepartment(department);
        companyAccount.setMemberName("박성준");
        companyAccount.setMemberId("블라블라8");
        companyAccount.setMemberPwd(passwordEncoder.encode("0000"));
        companyAccount.setMemberPwdInitStatus("Y");
        companyAccount.setMemberCreatedDate(LocalDateTime.now());
        companyAccount.setMemberRemoveStatus("Y");
        companyAccount.setOfficeDivision("직원");
        companyAccount.setMemberDivision("본사");
        companyAccount.setOfficePhoneNumber("02-0000-0001");
        companyAccount.setMemberCellPhone("01090000000");
        companyAccount.setMemberEmail("dfdfdlk@jaegojaego.com");

        companyAccountRepository.save(companyAccount);

        assertEquals("블라블라8", companyAccount.getMemberId());
    }

    @Test
    public void 계정목록조회() {

        //지연로딩때문에 메소드를 따로 만들어줘야함
        List<CompanyAccount> memberList = companyAccountRepository.findAll();

        memberList.forEach(rows -> System.out.println(rows));

        assertNotNull(memberList);
    }

    @PersistenceUnit
    EntityManagerFactory emf;
    
    @Test
    public void 검색테스트() {
        
        String searchWord = null;
        
        List<CompanyAccount> companyAccounts = companyAccountRepository.searchMembers(searchWord);

        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(companyAccounts.get(0).getDepartment());

        assertTrue(loaded);

        System.out.println("companyAccounts = " + companyAccounts);

        List<CompanyAccountDTO> companyAccountDTOS =
                companyAccounts.stream().map(companyAccount -> modelMapper.map(companyAccount, CompanyAccountDTO.class)).collect(Collectors.toList());

        companyAccountDTOS.forEach(row -> System.out.println(row));

        assertNotNull(companyAccountDTOS);
    }

    @Test
    public void 로그인한_본사_직원_이름_조회() {

        Member member = new Member();
        member.setMemberNo(1);
        member.setMemberDivision("본사");

        CompanyAccount companyAccount = companyAccountRepository.findAllByMemberNoAndMemberDivision(member.getMemberNo(), member.getMemberDivision());

        assertEquals("tester", companyAccount.getMemberName());
        assertEquals("물류팀", companyAccount.getDepartment().getDepartmentName());
    }

    @Test
    @Transactional
    public void 로그인한_본사_관리자_및_직원_정보_수정() {

        CompanyAccount member = new CompanyAccount();
        member.setMemberNo(191);
        member.setMemberCellPhone("010-1111-1111");
        member.setOfficePhoneNumber("02-1111-1111");
        member.setMemberEmail("waitingPark@jaegojaego.com");

        CompanyAccount companyAccount = companyAccountRepository.save(member);

        assertEquals(member.getMemberCellPhone(), companyAccount.getMemberCellPhone());
        assertEquals(member.getOfficePhoneNumber(), companyAccount.getOfficePhoneNumber());
        assertEquals(member.getMemberEmail(), companyAccount.getMemberEmail());
    }

    @Test
    public void 계정_아이디로_해당_회원_정보_찾기() {

        CompanyAccount member = companyAccountRepository.findByMemberNo(70);

        assertEquals(70, member.getMemberNo());
    }

    @Test
    public void 계정_번호로_비밀번호_찾기() {

        Integer memberNo = 1;

        Member member = memberRepository.findMemberByMemberNo(memberNo);
        System.out.println("pwd = " + member.getMemberPwd());
        
        assertNotNull(member.getMemberPwd());
    }

    @Test
    public void 가맹사업팀_멤버_조회하기() {

        Integer departmentNo = 2;

        List<CompanyAccount> list = companyAccountRepository.findSupervisorByDepartment_DepartmentNo(departmentNo);

        System.out.println("부서 별 담당 사원 리스트");
        list.forEach(member -> System.out.println(member));

        assertNotNull(list);
    }

    @Test
    public void 로그인_테스트() {

        String id = "dfdffddf";
        String status = "Y";

        Member result = memberRepository.findMemberByMemberIdAndMemberRemoveStatus(id, status);

        assertEquals(id, result.getMemberId());
    }

//    @Test
//    @Transactional
//    public void 본사_직원_계정_정보_수정_테스트() {
//
//        CompanyAccount companyAccount = new CompanyAccount();
//        companyAccount.setMemberNo(10);
//        companyAccount.setMemberName("장덕철");
//        companyAccount.setMemberCellPhone(null);
//        companyAccount.setMemberCellPhone(null);
//        companyAccount.setDepartmentNo(2);
//
//        companyAccountRepository.updateMember(companyAccount);
//    }
}