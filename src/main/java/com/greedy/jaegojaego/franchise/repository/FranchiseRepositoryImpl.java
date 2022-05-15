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


/**
 * <pre>
 * Class : FranchiseRepositoryImpl
 * Comment : FranchiseRepositoryCustom의 구현 클래스이며, QuerydslRepositorySupport 기능 및 Querydsl을 이용한 동적 쿼리를 작성하기 위한 클래스 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 *
 * @author 박성준
 * @version 1.0
 */
public class FranchiseRepositoryImpl extends QuerydslRepositorySupport implements FranchiseRepositoryCustom {

    private JPAQueryFactory queryFactory;

    /* queryFactory 기능을 이용하기 위해서 생성자에 주입함 */
    public FranchiseRepositoryImpl(EntityManager em) {
        super(FranchiseInfo.class);
        this.queryFactory = new JPAQueryFactory(em);
    }


    /**
     * 가맹점 대표자 계정 정보 수정 메소드
     *
     * @param franchise 가맹점 대표자 계정 정보
     * @author 박성준
     */
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

        if((StringUtils.hasText(String.valueOf(franchise.getSupervisorNo())))) {
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

        updateBuilder
                .where(franchiseInfo.memberNo.eq(franchise.getMemberNo()))
                .execute();

        return franchise;
    }

    /**
     * 검색조건에 따른 가맹점 대표자 계정 목록 조회 메소드
     *
     * @param searchWord 검색어
     * @author 박성준
     */
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
                        .and(franchiseInfo.memberRemoveStatus.eq("Y"))
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

    /**
     * 가맹점 대표자 아이디 존재 여부에 따라 값을 반환하는 메소드
     * comment : 해당 아이디값이 있으면 해당 아이디 값을 반환하고, 아니면 null을 반환한다.
     * @param memberId 아이디
     * @author 박성준
     */
    private BooleanExpression memberIdContatins(String memberId) {
        return hasText(memberId) ? franchiseInfo.memberId.contains(memberId) : null;
    }

    /**
     * 가맹점 명 존재 여부에 따라 값을 반환하는 메소드
     * comment : 해당 이름이 있으면 해당 이름 값을 반환하고, 아니면 null을 반환한다.
     * @param franchiseName 가맹점 명
     * @author 박성준
     */
    private BooleanExpression franchiseNameContatains(String franchiseName) {
        return hasText(franchiseName) ? franchiseInfo.branchName.contains(franchiseName) : null;
    }

    /**
     * 가맹점 전화번호 존재 여부에 따라 값을 반환하는 메소드
     * comment : 해당 전화번호 값이 있으면 해당 값을 반환하고, 아니면 null을 반환한다.
     * @param phoneNumber 전화번호
     * @author 박성준
     */
    private BooleanExpression franchisePhoneNumberContains(String phoneNumber) {
        return hasText(phoneNumber) ? franchiseInfo.phone.contains(phoneNumber) : null;
    }

    /**
     * 가맹점 주소 값 존재 여부에 따라 값을 반환하는 메소드
     * comment : 해당 주소 값이 있으면 해당 값을 반환하고, 아니면 null을 반환한다.
     * @param address 주소
     * @author 박성준
     */
    private BooleanExpression franchiseAddressContains(String address) {
        return hasText(address) ? franchiseInfo.address.contains(address) : null;
    }

    /**
     * 가맹점 본사 담당직원 존재 여부에 따라 값을 반환하는 메소드
     * comment : 해당 담당직원이 있으면 해당 값을 반환하고, 아니면 null을 반환한다.
     * @param supervisor 본사 담당자
     * @author 박성준
     */
    private BooleanExpression franchiseSupervisorContains(String supervisor) {
        return hasText(supervisor) ? franchiseInfo.supervisor.memberName.contains(supervisor) : null;
    }

    /**
     * 검색조건에 따른 삭제된 가맹점 대표자 계정 목록 조회 메소드
     *
     * @param searchWord 검색어
     * @author 박성준
     */
    @Override
    public List<FranchiseInfo> searchRemovedFranchise(String searchWord) {

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
                            .and(franchiseInfo.memberRemoveStatus.eq("N"))
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
