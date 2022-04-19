package com.greedy.jaegojaego.company.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCompanyAccountDTO {

    private int memberNo;
    private String memberName;
    private String email;
    private String cellphone;
    private int deptNo;

    @Override
    public String toString() {
        return "CompanyAccountDTO{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", deptNo=" + deptNo +
                '}';
    }
}
