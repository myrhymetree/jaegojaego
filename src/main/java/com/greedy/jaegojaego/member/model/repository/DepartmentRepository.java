package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : DepartmentRepository
 * Comment : 부서  Spring-data JPA 공통 레포지토리 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    /* 부서 목록 조회 메소드 */
    @Query(value = "SELECT A.DEPARTMENT_NO, A.DEPARTMENT_NAME FROM DEPARTMENT A",
            nativeQuery = true)
    List<Department> findAll();

    /* 부서 조회 메소드 */
    Department findByDepartmentNo(int departmentNo);
}
