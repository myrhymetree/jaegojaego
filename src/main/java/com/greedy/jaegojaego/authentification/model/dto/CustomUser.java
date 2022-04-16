package com.greedy.jaegojaego.authentification.model.dto;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {

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

    public CustomUser(MemberDTO member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getMemberId(), member.getMemberPwd(), authorities);

        setDetails(member);
    }

    private void setDetails(MemberDTO member) {
        this.memberNo = member.getMemberNo();
        this.memberId = member.getMemberId();
        this.memberPwd = member.getMemberPwd();
        this.nickname = member.getNickname();
        this.phone = member.getPhone();
        this.email = member.getEmail();
        this.address = member.getAddress();
        this.enrollDate = member.getEnrollDate();
        this.memberRole = member.getMemberRole();
        this.memberStatus = member.getMemberStatus();
    }
}
