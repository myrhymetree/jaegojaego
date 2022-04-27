package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.MemberSearchCondition;
import com.greedy.jaegojaego.member.model.dto.QCompanyAccountDTO;
import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import com.greedy.jaegojaego.member.model.entity.QCompanyAccount;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static org.springframework.util.StringUtils.*;
import static com.greedy.jaegojaego.member.model.entity.QCompanyAccount.companyAccount;
import static com.greedy.jaegojaego.member.model.entity.QDepartment.department;

public class CompanyAccountRepositoryImpl implements CompanyAccountRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public CompanyAccountRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<CompanyAccount> searchMembers(MemberSearchCondition condition) {

//        return queryFactory
//                .select(new QCompanyAccount(
//                        companyAccount))
//                .from(companyAccount)
//                .where(
//                        memberIdEq(condition.getMemberId())
//                        .and(memberNameEq(condition.getMemberName()))
//                        .and(departmentNameEq(condition.getDepaartmentName()))
//                )
//                .fetch();

        return queryFactory
                .select(new QCompanyAccount(
                        companyAccount))
                .from(companyAccount)
                .where(
                        memberIdEq(condition.getMemberId()),
                        memberNameEq(condition.getMemberName()),
                        departmentNameEq(condition.getDepaartmentName())
                )
                .fetch();

//        return queryFactory
//                .select(new QCompanyAccount(
//                        companyAccount))
//                .from(companyAccount)
//                .where(
//                        allcontains(condition.getMemberId(), condition.getMemberName(), condition.getDepaartmentName())
//                )
//                .fetch();
//
    }

    private BooleanExpression memberIdEq(String memberId) {
        return hasText(memberId) ? companyAccount.memberId.contains(memberId) : null;
    }

    private BooleanExpression memberNameEq(String memberName) {
        return hasText(memberName) ? companyAccount.memberName.contains(memberName) : null;
    }

    private BooleanExpression departmentNameEq(String departmentName) {
        return hasText(departmentName) ? department.departmentName.contains(departmentName) : null;
    }

    private BooleanExpression allcontains(String memberId, String memberName, String departmentName) {
        return memberIdEq(memberId).or(memberNameEq(memberName)).or(departmentNameEq(departmentName));
    }
}
