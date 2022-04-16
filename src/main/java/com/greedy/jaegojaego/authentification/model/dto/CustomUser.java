package com.greedy.jaegojaego.authentification.model.dto;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {

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

    public CustomUser(MemberDTO member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getMemberId(), member.getMemberPwd(), authorities);

        setDetails(member);
    }

    private void setDetails(MemberDTO member) {
        this.memberNo = member.getMemberNo();
        this.memberId = member.getMemberId();
        this.memberPwd = member.getMemberPwd();
        this.memberPwdUpdateDate = member.getMemberPwdUpdateDate();
        this.memberPwdInitStatus = member.getMemberPwdInitStatus();
        this.memberCreatedDate = member.getMemberCreatedDate();
        this.memberRemovedDate = member.getMemberRemovedDate();
        this.franchiseDivision = member.getFranchiseDivision();
        this.officeDivision = member.getOfficeDivision();
        this.memberDivision = member.getMemberDivision();
    }
}
