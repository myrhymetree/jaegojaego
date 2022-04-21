package com.greedy.jaegojaego.member.model.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class NewMemberDTO {

    private int memberNo;
    private String memberId;
    private String memberPwd;

    private String franchiseDivision;
    private String officeDivision;
    private String memberDivision;

    private CompanyAccountDTO companyAccountDTO;
    private List<AuthorityDTO> authorityDTOList;

}
