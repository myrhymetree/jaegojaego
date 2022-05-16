package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;

/**
 * <pre>
 * Class : MemberRole
 * Comment : MEMBER_ROLE 테이블과 대응할 엔티티, 계정별 권한 테이블이다.
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Builder
@Entity(name = "MemberRole")
@Table(name = "MEMBER_ROLE")
@Embeddable
public class MemberRole {

    @EmbeddedId
    private MemberRolePK memberRolePK;

    @JoinColumn(name = "AUTHORITY_CODE", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Authority authority;

    public MemberRole() {}

    public MemberRole(MemberRolePK memberRolePK, Authority authority) {
        this.memberRolePK = memberRolePK;
        this.authority = authority;
    }

    public MemberRolePK getMemberRolePK() {
        return memberRolePK;
    }

    public void setMemberRolePK(MemberRolePK memberRolePK) {
        this.memberRolePK = memberRolePK;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "MemberRole{" +
                "memberRolePK=" + memberRolePK +
                ", authority=" + authority +
                '}';
    }
}
