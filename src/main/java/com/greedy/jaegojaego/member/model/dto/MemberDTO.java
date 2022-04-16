package com.greedy.jaegojaego.member.model.dto;

import lombok.*;

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
    private String nickname;
    private String phone;
    private String email;
    private String address;
    private java.sql.Date enrollDate;
    private String memberRole;
    private String memberStatus;

}
