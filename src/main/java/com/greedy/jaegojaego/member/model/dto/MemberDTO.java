package com.greedy.jaegojaego.member.model.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberDTO {

    private int memberNo;
    private String memberId;
    private String memberPwd;
    private java.sql.Date memberPwdUpdateDate;
    private String memberPwdInitStatus;
    private java.sql.Date memberCreatedDate;
    private java.sql.Date memberRemovedDate;
    private String memberRemoveStatus;
    private String franchiseDivision;
    private String officeDivision;
    private String memberDivision;

    private List<AuthorityDTO> authorityDTOList;
}
