package com.greedy.jaegojaego.authentification.model.dto;

import com.greedy.jaegojaego.member.model.dto.AuthorityDTO;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.dto.MemberRoleDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@ToString
public class CustomUser extends User {

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

    private List<AuthorityDTO> authorityList;

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
        this.authorityList = member.getAuthorityDTOList();
    }
}
