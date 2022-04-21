package com.greedy.jaegojaego.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class departmentDTO {

    private Integer departmentNo;
    private String departmentName;

    @Override
    public String toString() {
        return "departmentDTO{" +
                "departmentNo=" + departmentNo +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
