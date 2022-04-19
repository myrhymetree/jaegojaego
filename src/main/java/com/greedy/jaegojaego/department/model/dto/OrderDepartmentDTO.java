package com.greedy.jaegojaego.department.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDepartmentDTO {

    private int deptNo;
    private String deptName;

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
