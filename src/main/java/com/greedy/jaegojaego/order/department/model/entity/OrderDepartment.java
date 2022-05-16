package com.greedy.jaegojaego.order.department.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "orderDepartment")
@Table(name = "DEPARTMENT")
@SequenceGenerator(
        name = "DEPARTMENT_SEQ_GENERATOR",
        sequenceName = "DEPARTMENT_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OrderDepartment {

    @Id
    @Column(name = "DEPARTMENT_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "DEPARTMENT_SEQ_GENERATOR"
    )
    private int deptNo;

    @Column(name = "DEPARTMENT_NAME")
    private String deptName;

    public OrderDepartment() {
    }

    public OrderDepartment(int deptNo, String deptName) {
        this.deptNo = deptNo;
        this.deptName = deptName;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
