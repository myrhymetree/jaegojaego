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

/**
 * <pre>
 * Class : FranchiseAccountRepositoryImpl
 * Comment : FranchiseAccountRepositoryCustom의 구현 클래스이며, QuerydslRepositorySupport 기능 및 Querydsl을 이용한 동적 쿼리를 작성하기 위한 클래스 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 *
 * @author 박성준
 * @version 1.0
 */
public class FranchiseAccountRepositoryImpl extends QuerydslRepositorySupport implements FranchiseAccountRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    /* queryFactory 기능을 이용하기 위해서 생성자에 주입함 */
    public FranchiseAccountRepositoryImpl(EntityManager em) {
        super(FranchiseAccount.class);
        this.queryFactory = new JPAQueryFactory(em);
    }

    /**
     * 가맹점 직원 계정 정보 수정 메소드
     *
     * @param manager 가맹점 직원 계정 정보
     * @author 박성준
     */
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
                .execute();     //쿼리문 실행
    }

    /**
     * 검색조건에 따른 가맹점 직원 계정 목록 조회 메소드
     *
     * @param searchWord 검색어
     * @author 박성준
     */
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

    /**
     * 검색조건에 따른 삭제된 가맹점 직원 계정 목록 조회 메소드
     *
     * @param searchWord 검색어
     * @author 박성준
     */
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

    /**
     * 가맹점 직원 아이디 존재 여부에 따라 값을 반환하는 메소드
     * comment : 해당 아이디값이 있으면 해당 아이디 값을 반환하고, 아니면 null을 반환한다.
     * @param managerId 아이디
     * @author 박성준
     */
    private BooleanExpression managerIdContains(String managerId) {
        return hasText(managerId) ? franchiseAccount.memberId.contains(managerId) : null;
    }

    /**
     * 가맹점 직원 이름 존재 여부에 따라 값을 반환하는 메소드
     * comment : 해당 이름이 있으면 해당 이름 값을 반환하고, 아니면 null을 반환한다.
     * @param managerName 직원 이름
     * @author 박성준
     */
    private BooleanExpression managerNameContains(String managerName) {
        return hasText(managerName) ? franchiseAccount.managerName.contains(managerName) : null;
    }

    /**
     * 가맹점 이름 존재 여부에 따라 값을 반환하는 메소드
     * comment : 해당 아이디값이 있으면 해당 이름 값을 반환하고, 아니면 null을 반환한다.
     * @param franchiseName 가맹점 명
     * @author 박성준
     */
    private BooleanExpression franchiseNameContains(String franchiseName) {
        return hasText(franchiseName) ? franchiseAccount.franchiseInfo.branchName.contains(franchiseName) : null;
    }

    /**
     * 가맹점 전화번호 존재 여부에 따라 값을 반환하는 메소드
     * comment : 해당 전화번호 값이 있으면 해당 전화번호를 반환하고, 아니면 null을 반환한다.
     * @param phoneNumber 가맹점 명
     * @author 박성준
     */
    private BooleanExpression franchisePhoneNumberContains(String phoneNumber) {
        return hasText(phoneNumber) ? franchiseAccount.franchiseInfo.phone.contains(phoneNumber) : null;
    }

}
