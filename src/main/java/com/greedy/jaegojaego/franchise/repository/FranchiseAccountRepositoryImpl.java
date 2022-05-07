package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import static com.greedy.jaegojaego.franchise.entity.QFranchiseAccount.franchiseAccount;

public class FranchiseAccountRepositoryImpl extends QuerydslRepositorySupport implements FranchiseAccountRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public FranchiseAccountRepositoryImpl(EntityManager em) {
        super(FranchiseAccount.class);
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    @Transactional
    public void updateManager(FranchiseAccount manager) {

        UpdateClause<JPAUpdateClause> updateBuilder = update(franchiseAccount);

        if(StringUtils.hasText(manager.getMemberPwd())) {
            updateBuilder.set(franchiseAccount.memberPwd, manager.getMemberPwd());
        }

        if(StringUtils.hasText(manager.getManagerEmail())) {
            updateBuilder.set(franchiseAccount.managerEmail, manager.getManagerEmail());
        }

        if(StringUtils.hasText(manager.getManagerPhone())) {
            updateBuilder.set(franchiseAccount.managerPhone, manager.getManagerPhone());
        }

        updateBuilder
                .where(franchiseAccount.memberNo.eq(manager.getMemberNo()))
                .execute();
    }
}
