package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import static com.greedy.jaegojaego.franchise.entity.QFranchiseInfo.franchiseInfo;

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

        if(StringUtils.hasText(franchise.getMemberPwd())) {
            updateBuilder.set(franchiseInfo.memberPwd, franchise.getMemberPwd());
        }

        if(StringUtils.hasText(franchise.getRepresentativeEmail())) {
            updateBuilder.set(franchiseInfo.representativeEmail, franchise.getRepresentativeEmail());
        }

        if(StringUtils.hasText(franchise.getPhone())) {
            updateBuilder.set(franchiseInfo.phone, franchise.getPhone());
        }

        if(StringUtils.hasText(franchise.getRepresentativePhone())) {
            updateBuilder.set(franchiseInfo.representativePhone, franchise.getRepresentativePhone());
        }

        updateBuilder
                .where(franchiseInfo.memberNo.eq(franchise.getMemberNo()))
                .execute();
    }

}
