package com.greedy.jaegojaego.member.model.service;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.MemberSearchCondition;
import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import com.greedy.jaegojaego.member.model.entity.Department;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.member.model.repository.CompanyAccountRepository;
import com.greedy.jaegojaego.member.model.repository.DepartmentRepository;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
import org.hibernate.annotations.DynamicUpdate;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        List<CompanyAccount> memberList = companyAccountRepository.findAll();

        memberList.forEach(rows -> System.out.println(rows));

        assertNotNull(memberList);
    }
    
    @Test
    public void 검색테스트() {
        
        String searchWord = null;
        
        List<CompanyAccount> companyAccounts = companyAccountRepository.searchMembers(searchWord);

        List<CompanyAccountDTO> companyAccountDTOS =
                companyAccounts.stream().map(companyAccount -> modelMapper.map(companyAccount, CompanyAccountDTO.class)).collect(Collectors.toList());

        companyAccountDTOS.forEach(row -> System.out.println(row));

        assertNotNull(companyAccountDTOS);
    }

    @Test
    public void 로그인한_본사_직원_이름_조회() {

        Member member = new Member();
        member.setMemberNo(1);

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
}