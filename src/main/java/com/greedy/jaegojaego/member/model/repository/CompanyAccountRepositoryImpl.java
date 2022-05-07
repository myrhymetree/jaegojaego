package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.dto.MemberSearchCondition;
import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import com.greedy.jaegojaego.member.model.entity.QCompanyAccount;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.StringUtils.*;
import static com.greedy.jaegojaego.member.model.entity.QCompanyAccount.companyAccount;
import static com.greedy.jaegojaego.member.model.entity.QDepartment.department;

public class CompanyAccountRepositoryImpl extends QuerydslRepositorySupport implements CompanyAccountRepositoryCustom{

//    private final JPAQueryFactory queryFactory;
//
//    public CompanyAccountRepositoryImpl(EntityManager entityManager) {
//        this.queryFactory = new JPAQueryFactory(entityManager);
//    }

    private final JPAQueryFactory queryFactory;

    public CompanyAccountRepositoryImpl(EntityManager em) {
        super(CompanyAccount.class);
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<CompanyAccount> searchMembers(String searchWord) {

        if(searchWord != null && searchWord != "") {
            return queryFactory
                    .select(new QCompanyAccount(
                            companyAccount))
                    .from(companyAccount)
                    .where(
                            memberIdContains(searchWord)
                            .or(memberNameContains(searchWord))
                            .or( departmentNameContains(searchWord))
                    )
                    .fetch();
        }
        else {
            return queryFactory
                    .select(new QCompanyAccount(
                            companyAccount))
                    .from(companyAccount)
                    .where(
                            memberIdContains(searchWord),
                            memberNameContains(searchWord),
                            departmentNameContains(searchWord)
                    )
                    .fetch();
        }

    }

    @Override
    @Transactional
    public void updateMember(CompanyAccount member) {

        UpdateClause<JPAUpdateClause> updateBuilder = update(companyAccount);

        if(StringUtils.hasText(member.getMemberPwd())) {
            updateBuilder.set(companyAccount.memberPwd, member.getMemberPwd());
        }

        if(StringUtils.hasText(member.getMemberEmail())) {
            updateBuilder.set(companyAccount.memberEmail, member.getMemberEmail());
        }

        if(StringUtils.hasText(member.getMemberCellPhone())) {
            updateBuilder.set(companyAccount.memberCellPhone, member.getMemberCellPhone());
        }

        if(StringUtils.hasText(member.getOfficePhoneNumber())) {
            updateBuilder.set(companyAccount.officePhoneNumber, member.getOfficePhoneNumber());
        }

        updateBuilder
                .where(companyAccount.memberNo.eq(member.getMemberNo()))
                .execute();
    }

    private BooleanExpression memberIdContains(String memberId) {
        return hasText(memberId) ? companyAccount.memberId.contains(memberId) : null;
    }

    private BooleanExpression memberNameContains(String memberName) {
        return hasText(memberName) ? companyAccount.memberName.contains(memberName) : null;
    }

    private BooleanExpression departmentNameContains(String departmentName) {
        return hasText(departmentName) ? department.departmentName.contains(departmentName) : null;
    }

}
