package com.greedy.jaegojaego.order.department.model.dto;

import lombok.*;

public class OrderDepartmentDTO {

    private int deptNo;
    private String deptName;

    public OrderDepartmentDTO() {
    }

    public OrderDepartmentDTO(int deptNo, String deptName) {
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
        return "DepartmentDTO{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
