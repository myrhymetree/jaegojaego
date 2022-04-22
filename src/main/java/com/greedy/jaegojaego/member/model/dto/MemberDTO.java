package com.greedy.jaegojaego.member.model.dto;

import lombok.*;

import java.time.LocalDateTime;
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
    private LocalDateTime memberPwdUpdateDate;
    private String memberPwdInitStatus;
    private LocalDateTime memberCreatedDate;
    private LocalDateTime memberRemovedDate;
    private String memberRemoveStatus;
    private String franchiseDivision;
    private String officeDivision;
    private String memberDivision;

    private CompanyAccountDTO companyAccountDTO;
    private List<AuthorityDTO> authorityDTOList;
}
