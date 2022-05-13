package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : CompanyAccountRepository
 * Comment : 본사 직원 계정 Spring-data JPA 공통 레포지토리 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Repository
public interface CompanyAccountRepository extends JpaRepository<CompanyAccount, Integer>, CompanyAccountRepositoryCustom {

    /* 본사 직원 계정 목록 조회 메소드 */
    List<CompanyAccount> findAll();

    /* 로그인한 본사 직원 계정 정보 조회 매소드 */
    @EntityGraph(attributePaths = {"department"}, type = EntityGraph.EntityGraphType.LOAD)
    CompanyAccount findAllByMemberNoAndMemberDivision(Integer memberNo, String memberDivision);

    /* 본사 직원 계정 조회 메소드 */
    CompanyAccount findByMemberNo(Integer memberNo);

    /* 가맹계약팀 본사 직원 목록 조회 메소드 */
    @EntityGraph(attributePaths = {"department"}, type = EntityGraph.EntityGraphType.FETCH)
    List<CompanyAccount> findSupervisorByDepartment_DepartmentNo(Integer departmentNo);
}
