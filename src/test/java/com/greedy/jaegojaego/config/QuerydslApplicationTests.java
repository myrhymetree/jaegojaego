package com.greedy.jaegojaego.config;

import com.greedy.jaegojaego.member.model.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.time.LocalDateTime;

import static com.greedy.jaegojaego.member.model.entity.QCompanyAccount.companyAccount;
import static com.greedy.jaegojaego.member.model.entity.QMember.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class QuerydslApplicationTests {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory;

    @BeforeEach
    public void before() {
        queryFactory = new JPAQueryFactory(em);
    }
//    @Test
//    void contextLoads() {
//        Hello hello = new Hello();
//        em.persist(hello);
//
//        JPAQueryFactory query = new JPAQueryFactory(em);
//        QHello qHello = new QHello("h");
//
//
//        //ctrl alt v
//        Hello result = query
//                .selectFrom(qHello)
//                .fetchOne();
//
//        assertThat(result).isEqualTo(hello);
//        assertThat(result.getId()).isEqualTo(hello.getId());
//    }

    @Test
    public void startQuerydsl() {

        /* 별칭을 주는 방식 */
//        QMember m = new QMember("m");

        /* 기본 인스턴스 사용 방식*/
        QMember m = member;

//        Member findMember = queryFactory
//                .select(m)
//                .from(m)
//                .where(m.memberId.eq("admin"))
//                .fetchOne();

        Member findMember = queryFactory
                .select(member)
                .from(member)
                .where(member.memberId.eq("admin"))
                .fetchOne();

        assertThat(findMember.getMemberId()).isEqualTo("admin");

    }

    @Test
    public void search() {
        QCompanyAccount m = companyAccount;

        CompanyAccount findMember = queryFactory
                .selectFrom(QCompanyAccount.companyAccount)
                .where(QCompanyAccount.companyAccount.memberId.eq("admin")
                        .and(QCompanyAccount.companyAccount.memberName.eq("tester")))
                .fetchOne();

        assertThat(findMember.getMemberId()).isEqualTo("admin");
    }
}
