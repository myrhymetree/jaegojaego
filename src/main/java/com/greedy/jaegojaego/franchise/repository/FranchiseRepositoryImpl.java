package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.franchise.entity.QFranchiseInfo;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import java.util.List;

import static com.greedy.jaegojaego.franchise.entity.QFranchiseInfo.franchiseInfo;
import static org.springframework.util.StringUtils.hasText;

public class FranchiseRepositoryImpl extends QuerydslRepositorySupport implements FranchiseRepositoryCustom {

    private JPAQueryFactory queryFactory;

    public FranchiseRepositoryImpl(EntityManager em) {
        super(FranchiseInfo.class);
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    @Transactional
    public void updateFranchise(FranchiseInfo franchise) {

        UpdateClause<JPAUpdateClause> updateBuilder = update(franchiseInfo);

        if(hasText(franchise.getMemberPwd())) {
            updateBuilder.set(franchiseInfo.memberPwd, franchise.getMemberPwd());
        }

        if(hasText(franchise.getRepresentativeEmail())) {
            updateBuilder.set(franchiseInfo.representativeEmail, franchise.getRepresentativeEmail());
        }

        if(hasText(franchise.getPhone())) {
            updateBuilder.set(franchiseInfo.phone, franchise.getPhone());
        }

        if(hasText(franchise.getRepresentativePhone())) {
            updateBuilder.set(franchiseInfo.representativePhone, franchise.getRepresentativePhone());
        }

        updateBuilder
                .where(franchiseInfo.memberNo.eq(franchise.getMemberNo()))
                .execute();
    }

    @Override
    public List<FranchiseInfo> searchFranchise(String searchWord) {

        if(searchWord != null && searchWord != "") {
            return queryFactory
                    .select(new QFranchiseInfo(
                            franchiseInfo))
                    .from(franchiseInfo)
                    .where(
                        memberIdContatins(searchWord)
                        .or(franchiseNameContatains(searchWord))
                        .or(franchisePhoneNumberContains(searchWord))
                        .or(franchiseAddressContains(searchWord))
                        .or(franchiseSupervisorContains(searchWord))
                    )
                    .fetch();
        }
        else {
            return queryFactory
                    .select(new QFranchiseInfo(
                            franchiseInfo))
                    .from(franchiseInfo)
                    .where(
                        memberIdContatins(searchWord),
                        franchiseNameContatains(searchWord),
                        franchisePhoneNumberContains(searchWord),
                        franchiseAddressContains(searchWord),
                        franchiseSupervisorContains(searchWord)
                    )
                    .fetch();
        }

    }

    private BooleanExpression memberIdContatins(String memberId) {
        return hasText(memberId) ? franchiseInfo.memberId.contains(memberId) : null;
    }

    private BooleanExpression franchiseNameContatains(String franchiseName) {
        return hasText(franchiseName) ? franchiseInfo.branchName.contains(franchiseName) : null;
    }

    private BooleanExpression franchisePhoneNumberContains(String phoneNumber) {
        return hasText(phoneNumber) ? franchiseInfo.phone.contains(phoneNumber) : null;
    }

    private BooleanExpression franchiseAddressContains(String address) {
        return hasText(address) ? franchiseInfo.address.contains(address) : null;
    }

    private BooleanExpression franchiseSupervisorContains(String supervisor) {
        return hasText(supervisor) ? franchiseInfo.supervisor.memberName.contains(supervisor) : null;
    }

}
