package com.greedy.jaegojaego.member.model.service;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import com.greedy.jaegojaego.member.model.entity.Department;
import com.greedy.jaegojaego.member.model.repository.CompanyAccountRepository;
import com.greedy.jaegojaego.member.model.repository.DepartmentRepository;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;


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

    @Test
    public void initTest() {

    }

    @Test
    public void 계정생성() {

        Department department = departmentRepository.findByDepartmentNo(1);

        /* 상속관계에 의해서 자식 객체로 부모객체에 데이터를 입력할 수 있다. */
        CompanyAccount companyAccount = new CompanyAccount();
        companyAccount.setDepatment(department);
        companyAccount.setMemberName("박성준");
        companyAccount.setMemberId("블라블라3");
        companyAccount.setMemberPwd(passwordEncoder.encode("0000"));
        companyAccount.setMemberPwdInitStatus("Y");
        companyAccount.setMemberCreatedDate(LocalDateTime.now());
        companyAccount.setMemberRemoveStatus("Y");
        companyAccount.setOfficeDivision("직원");
        companyAccount.setMemberDivision("본사");
        companyAccount.setOfficePhoneNumber("02-0000-0001");

        companyAccountRepository.save(companyAccount);
    }
}