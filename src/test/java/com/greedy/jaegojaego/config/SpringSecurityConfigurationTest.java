package com.greedy.jaegojaego.config;

import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringSecurityConfigurationTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /* 아이디 조회 테스트 */
    @Test
    public void testReadById() {

        Member result = memberRepository.findMemberByMemberId("admin");
        System.out.println("result = " + result);

        assertEquals("admin", result.getMemberId());
    }

    /* 비빌번호 인코딩 테스트 */
    @Test
    public void passwordEncoder() {
        
        String password = "0000";
        
        String enPw = passwordEncoder.encode(password);

        System.out.println("enPw = " + enPw);
        
        boolean matchResult = passwordEncoder.matches(password, enPw);

        System.out.println("matchResult = " + matchResult);

        assertTrue(matchResult);
    }


}