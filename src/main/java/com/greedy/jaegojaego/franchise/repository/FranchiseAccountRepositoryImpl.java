package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;
import com.greedy.jaegojaego.franchise.entity.QFranchiseAccount;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import java.util.List;

import static com.greedy.jaegojaego.franchise.entity.QFranchiseAccount.franchiseAccount;
import static org.springframework.util.StringUtils.hasText;

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

        if(hasText(manager.getMemberPwd())) {
            updateBuilder.set(franchiseAccount.memberPwd, manager.getMemberPwd());
        }

        if(hasText(manager.getManagerEmail())) {
            updateBuilder.set(franchiseAccount.managerEmail, manager.getManagerEmail());
        }

        if(hasText(manager.getManagerPhone())) {
            updateBuilder.set(franchiseAccount.managerPhone, manager.getManagerPhone());
        }

        updateBuilder
                .where(franchiseAccount.memberNo.eq(manager.getMemberNo()))
                .execute();
    }

    @Override
    public List<FranchiseAccount> searchManager(String searchWord) {

        if(searchWord != null && searchWord != "") {
            return queryFactory
                    .select(new QFranchiseAccount(
                            franchiseAccount))
                    .from(franchiseAccount)
                    .where(
                            franchiseAccount.memberRemoveStatus.eq("Y")
                            .or(managerIdContains(searchWord))
                            .or(managerNameContains(searchWord))
                            .or(franchiseNameContains(searchWord))
                            .or(franchisePhoneNumberContains(searchWord))
                    )
                    .orderBy(franchiseAccount.franchiseInfo.branchName.asc())
                    .fetch();
        } else {
            return queryFactory
                    .select(new QFranchiseAccount(
                            franchiseAccount))
                    .from(franchiseAccount)
                    .where(
                        franchiseAccount.memberRemoveStatus.eq("Y"),
                        managerIdContains(searchWord),
                        managerNameContains(searchWord),
                        franchiseNameContains(searchWord),
                        franchisePhoneNumberContains(searchWord)
                    )
                    .orderBy(franchiseAccount.franchiseInfo.branchName.asc())
                    .fetch();
        }

    }

    @Override
    public List<FranchiseAccount> searchRemovedManager(String searchWord) {

        if(searchWord != null && searchWord != "") {
            return queryFactory
                    .select(new QFranchiseAccount(
                            franchiseAccount))
                    .from(franchiseAccount)
                    .where(
                            managerIdContains(searchWord)
                            .or(managerNameContains(searchWord))
                            .or(franchiseNameContains(searchWord))
                            .or(franchisePhoneNumberContains(searchWord))
                            .and(franchiseAccount.memberRemoveStatus.eq("N"))
                    )
                    .orderBy(franchiseAccount.franchiseInfo.branchName.asc())
                    .fetch();
        } else {
            return queryFactory
                    .select(new QFranchiseAccount(
                            franchiseAccount))
                    .from(franchiseAccount)
                    .where(
                            franchiseAccount.memberRemoveStatus.eq("N"),
                            managerIdContains(searchWord),
                            managerNameContains(searchWord),
                            franchiseNameContains(searchWord),
                            franchisePhoneNumberContains(searchWord)
                    )
                    .orderBy(franchiseAccount.franchiseInfo.branchName.asc())
                    .fetch();
        }
    }

    private BooleanExpression managerIdContains(String managerId) {
        return hasText(managerId) ? franchiseAccount.memberId.contains(managerId) : null;
    }

    private BooleanExpression managerNameContains(String managerName) {
        return hasText(managerName) ? franchiseAccount.managerName.contains(managerName) : null;
    }

    private BooleanExpression franchiseNameContains(String franchiseName) {
        return hasText(franchiseName) ? franchiseAccount.franchiseInfo.branchName.contains(franchiseName) : null;
    }

    private BooleanExpression franchisePhoneNumberContains(String phoneNumber) {
        return hasText(phoneNumber) ? franchiseAccount.franchiseInfo.phone.contains(phoneNumber) : null;
    }

}
