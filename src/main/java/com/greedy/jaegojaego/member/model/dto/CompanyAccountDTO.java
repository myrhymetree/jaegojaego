package com.greedy.jaegojaego.member.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CompanyAccountDTO {

    private Integer memberNo;
    private String memberName;
    private String memberEmail;
    private String memberCellPhone;
    private String officePhoneNumber;

    private DepartmentDTO departmentDTO;
}
