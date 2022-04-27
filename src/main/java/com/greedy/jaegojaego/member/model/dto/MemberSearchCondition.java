package com.greedy.jaegojaego.member.model.dto;

import lombok.Data;

@Data
public class MemberSearchCondition {

    //회원아이디, 회원이름, 팀명

    private String memberId;
    private String memberName;
    private String depaartmentName;
}
