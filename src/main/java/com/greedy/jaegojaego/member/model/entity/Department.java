package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;

/**
 * <pre>
 * Class : Department
 * Comment : DEPARTMENT 테이블과 대응할 엔티티,  부서에 대한 테이블이다.
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Builder
@Entity(name = "Department")
@Table(name = "DEPARTMENT")
@SequenceGenerator(
        name = "DEPARTMENT_SEQ_GENERATOR",
        sequenceName = "DEPARTMENT_NO",
        initialValue = 1,
        allocationSize = 1
)
public class Department {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "DEPARTMENT_SEQ_GENERATOR"
    )
    @Column(name = "DEPARTMENT_NO")
    private Integer departmentNo;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    public Department() {}

    public Department(Integer departmentNo, String departmentName) {
        this.departmentNo = departmentNo;
        this.departmentName = departmentName;
    }

    public Integer getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(Integer departmentNo) {
        this.departmentNo = departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentNo=" + departmentNo +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
