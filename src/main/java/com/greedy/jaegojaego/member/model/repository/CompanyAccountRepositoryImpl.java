package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import com.greedy.jaegojaego.member.model.entity.QCompanyAccount;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static org.springframework.util.StringUtils.*;
import static com.greedy.jaegojaego.member.model.entity.QCompanyAccount.companyAccount;
import static com.greedy.jaegojaego.member.model.entity.QDepartment.department;

/**
 * <pre>
 * Class : CompanyAccountRepositoryImpl
 * Comment : CompanyAccountRepositoryCustom 구현 클래스이며, QuerydslRepositorySupport 기능 및 Querydsl을 이용한 동적 쿼리를 작성하기 위한 클래스 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 *
 * @author 박성준
 * @version 1.0
 */
public class CompanyAccountRepositoryImpl extends QuerydslRepositorySupport implements CompanyAccountRepositoryCustom{


    private final JPAQueryFactory queryFactory;

    /* queryFactory 기능을 이용하기 위해서 생성자에 주입함 */
    public CompanyAccountRepositoryImpl(EntityManager em) {
        super(CompanyAccount.class);
        this.queryFactory = new JPAQueryFactory(em);
    }

    /**
     * 검색조건에 따른 본사 직원 계정 목록 조회 메소드
     *
     * @param searchWord 검색어
     * @author 박성준
     */
    @Override
    public List<CompanyAccount> searchMembers(String searchWord) {

        if(searchWord != null && searchWord != "") {
            return queryFactory
                    .select(new QCompanyAccount(
                            companyAccount))
                    .from(companyAccount)
                    .join(companyAccount.department, department).fetchJoin()        // 직원과 부서를 같이 한번에 보여주기 위해서 즉시로딩을 이용하기 위해 패치조인 사용
                    .where(
                            memberIdContains(searchWord)
                            .or(memberNameContains(searchWord))
                            .or( departmentNameContains(searchWord))
                            .and(companyAccount.memberRemoveStatus.eq("Y"))

                    )
                    .orderBy(companyAccount.memberNo.asc())
                    .fetch();
        }
        else {
            return queryFactory
                    .select(new QCompanyAccount(
                            companyAccount))
                    .from(companyAccount)
                    .join(companyAccount.department, department).fetchJoin()
                    .where(
                            memberIdContains(searchWord),
                            memberNameContains(searchWord),
                            departmentNameContains(searchWord),
                            companyAccount.memberRemoveStatus.eq("Y")
                    )
                    .orderBy(companyAccount.memberNo.asc())
                    .fetch();
        }
    }

    /**
     * 본사 직원 아이디 존재 여부에 따라 값을 반환하는 메소드
     * comment : 해당 아이디값이 있으면 해당 아이디 값을 반환하고, 아니면 null을 반환한다.
     * @param memberId 직원 아이디
     * @author 박성준
     */
    private BooleanExpression memberIdContains(String memberId) {
        return hasText(memberId) ? companyAccount.memberId.contains(memberId) : null;
    }

    /**
     * 본사 직원 이름 존재 여부에 따라 값을 반환하는 메소드
     * comment : 해당 이름이 있으면 해당 이름 값을 반환하고, 아니면 null을 반환한다.
     * @param memberName 직원 이름
     * @author 박성준
     */
    private BooleanExpression memberNameContains(String memberName) {
        return hasText(memberName) ? companyAccount.memberName.contains(memberName) : null;
    }

    /**
     * 본사 부서 이름 존재 여부에 따라 값을 반환하는 메소드
     * comment : 해당 이름이 있으면 해당 이름 값을 반환하고, 아니면 null을 반환한다.
     * @param departmentName 부서 이름
     * @author 박성준
     */
    private BooleanExpression departmentNameContains(String departmentName) {
        return hasText(departmentName) ? department.departmentName.contains(departmentName) : null;
    }

    /**
     * 본사 직원 계정 정보 수정 메소드
     *
     * @param member 본사 직원 계정 정보
     * @author 박성준
     */
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

        if(StringUtils.hasText(String.valueOf(member.getDepartmentNo()))) {
            updateBuilder.set(companyAccount.departmentNo, member.getDepartmentNo());
        }

//        if(String.valueOf(member.getDepartment().getDepartmentNo()).isEmpty()) {
//            updateBuilder.set(companyAccount.department.departmentNo, member.getDepartment().getDepartmentNo());
//        }

        updateBuilder
                .where(companyAccount.memberNo.eq(member.getMemberNo()))
                .execute();
    }

    /**
     * 검색조건에 따른 삭제된 본사 직원 계정 목록 조회 메소드
     *
     * @param searchWord 검색어
     * @author 박성준
     */
    @Override
    public List<CompanyAccount> searchRemovedMembers(String searchWord) {

        if(searchWord != null && searchWord != "") {
            return queryFactory
                    .select(new QCompanyAccount(
                            companyAccount))
                    .from(companyAccount)
                    .join(companyAccount.department, department).fetchJoin()
                    .where(
                            memberIdContains(searchWord)
                            .or(memberNameContains(searchWord))
                            .or( departmentNameContains(searchWord))
                            .and(companyAccount.memberRemoveStatus.eq("N"))

                    )
                    .orderBy(companyAccount.memberNo.asc())
                    .fetch();
        }
        else {
            return queryFactory
                    .select(new QCompanyAccount(
                            companyAccount))
                    .from(companyAccount)
                    .join(companyAccount.department, department).fetchJoin()
                    .where(
                            memberIdContains(searchWord),
                            memberNameContains(searchWord),
                            departmentNameContains(searchWord),
                            companyAccount.memberRemoveStatus.eq("N")
                    )
                    .orderBy(companyAccount.memberNo.asc())
                    .fetch();
        }
    }
}
