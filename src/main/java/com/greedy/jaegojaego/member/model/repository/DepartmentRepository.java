package com.greedy.jaegojaego.member.model.repository;

import com.greedy.jaegojaego.member.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    //    @Query("SELECT a.departmentNo, a.departmentName FROM Department a")
    @Query(value = "SELECT A.DEPARTMENT_NO, A.DEPARTMENT_NAME FROM DEPARTMENT A",
            nativeQuery = true)
    List<Department> findAll();

    Department findByDepartmentNo(int departmentNo);
}
