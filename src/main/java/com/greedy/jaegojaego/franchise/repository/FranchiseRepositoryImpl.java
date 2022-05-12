package com.greedy.jaegojaego.franchise.repository;

import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.franchise.entity.QFranchiseInfo;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static com.greedy.jaegojaego.franchise.entity.QFranchiseInfo.franchiseInfo;
import static org.springframework.util.StringUtils.hasText;

public class FranchiseRepositoryImpl extends QuerydslRepositorySupport implements FranchiseRepositoryCustom {

    private JPAQueryFactory queryFactory;
//    private final EntityManager em;

    public FranchiseRepositoryImpl(EntityManager em) {
        super(FranchiseInfo.class);
        this.queryFactory = new JPAQueryFactory(em);
//        this.em = em;
    }

    @Override
    @Transactional
    public FranchiseInfo updateFranchise(FranchiseInfo franchise) {

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

        if(hasText(franchise.getAddress())) {
            updateBuilder.set(franchiseInfo.address, franchise.getAddress());
        }

        if(hasText(franchise.getRepresentativeName())) {
            updateBuilder.set(franchiseInfo.representativeName, franchise.getRepresentativeName());
        }

        if(hasText(String.valueOf(franchise.getWritedMemberNo()))) {
            updateBuilder.set(franchiseInfo.writedMemberNo, franchise.getWritedMemberNo());
        }

        if(hasText(String.valueOf(franchise.getSupervisorNo()))) {
            updateBuilder.set(franchiseInfo.supervisorNo, franchise.getSupervisorNo());
        }

        if(hasText(franchise.getBusinessRegistrationNo())) {
            updateBuilder.set(franchiseInfo.businessRegistrationNo, franchise.getBusinessRegistrationNo());
        }

        if(hasText(franchise.getBankAccountNo())) {
            updateBuilder.set(franchiseInfo.bankAccountNo, franchise.getBankAccountNo());
        }

        if(hasText(franchise.getBranchName())) {
            updateBuilder.set(franchiseInfo.branchName, franchise.getBranchName());
        }

//        queryFactory
//                .insert(franchiseContractUpdatedRecord)
//                        .values(franchise.getFranchiseContractStartedDate(), franchise.getFranchiseContractExpiredDate(), franchise.getFranchiseContractStatus(), franchise.getMemberNo())
//                                .execute();

        updateBuilder
                .where(franchiseInfo.memberNo.eq(franchise.getMemberNo()))
                .execute();

//        InsertClause<JPAInsertClause> insertBuilder = new JPAInsertClause(em, franchiseContractUpdatedRecord);
//
//        if(hasText(String.valueOf(franchiseContractUpdatedRecord.franchiseContractStartedDate))) {
//            insertBuilder.set(franchiseContractUpdatedRecord.franchiseContractStartedDate, franchise.getFranchiseContractStartedDate());
//        }
//
//        if(hasText(String.valueOf(franchiseContractUpdatedRecord.franchiseContractExpiredDate))) {
//            insertBuilder.set(franchiseContractUpdatedRecord.franchiseContractExpiredDate, franchise.getFranchiseContractExpiredDate());
//        }
//
//        if(hasText(String.valueOf(franchiseContractUpdatedRecord.franchiseContractStatus))) {
//            insertBuilder.set(franchiseContractUpdatedRecord.franchiseContractStatus, franchise.getFranchiseContractStatus());
//        }
//
//        if(hasText(String.valueOf(franchiseContractUpdatedRecord.franchiseRepresentativeNo))) {
//            insertBuilder.set(franchiseContractUpdatedRecord.franchiseRepresentativeNo, franchise.getMemberNo());
//        }
//
//            insertBuilder
//                    .execute();

        return franchise;
    }

    @Override
    public List<FranchiseInfo> searchFranchise(String searchWord) {

        if(searchWord != null && searchWord != "") {
            return queryFactory
                    .select(new QFranchiseInfo(
                            franchiseInfo))
                    .from(franchiseInfo)
                    .where(
                        franchiseInfo.memberRemoveStatus.eq("Y")
                        .or(memberIdContatins(searchWord))
                        .or(franchiseNameContatains(searchWord))
                        .or(franchisePhoneNumberContains(searchWord))
                        .or(franchiseAddressContains(searchWord))
                        .or(franchiseSupervisorContains(searchWord))
                    )
                    .orderBy(franchiseInfo.branchName.asc())
                    .fetch();
        }
        else {
            return queryFactory
                    .select(new QFranchiseInfo(
                            franchiseInfo))
                    .from(franchiseInfo)
                    .where(
                        franchiseInfo.memberRemoveStatus.eq("Y"),
                        memberIdContatins(searchWord),
                        franchiseNameContatains(searchWord),
                        franchisePhoneNumberContains(searchWord),
                        franchiseAddressContains(searchWord),
                        franchiseSupervisorContains(searchWord)
                    )
                    .orderBy(franchiseInfo.branchName.asc())
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

    @Override
    public List<FranchiseInfo> searchRemovedFranchise(String searchWord) {

        if(searchWord != null && searchWord != "") {
            return queryFactory
                    .select(new QFranchiseInfo(
                            franchiseInfo))
                    .from(franchiseInfo)
                    .where(
                            franchiseInfo.memberRemoveStatus.eq("N")
                            .or(memberIdContatins(searchWord))
                            .or(franchiseNameContatains(searchWord))
                            .or(franchisePhoneNumberContains(searchWord))
                            .or(franchiseAddressContains(searchWord))
                            .or(franchiseSupervisorContains(searchWord))
                    )
                    .orderBy(franchiseInfo.branchName.asc())
                    .fetch();
        }
        else {
            return queryFactory
                    .select(new QFranchiseInfo(
                            franchiseInfo))
                    .from(franchiseInfo)
                    .where(
                            franchiseInfo.memberRemoveStatus.eq("N"),
                            memberIdContatins(searchWord),
                            franchiseNameContatains(searchWord),
                            franchisePhoneNumberContains(searchWord),
                            franchiseAddressContains(searchWord),
                            franchiseSupervisorContains(searchWord)
                    )
                    .orderBy(franchiseInfo.branchName.asc())
                    .fetch();
        }
    }
}
