package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * Class : MemberRolePK
 * Comment : 복합키 매핑을 위한 임베디드 타입의 엔티티 클래스
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@EqualsAndHashCode
@Embeddable
public class MemberRolePK implements Serializable {

    @Column(name = "MEMBER_NO")
    private Integer memberNo;

    @Column(name = "AUTHORITY_CODE")
    private Integer authorityCode;

    public MemberRolePK() {}

    public MemberRolePK(Integer memberNo, Integer authorityCode) {
        this.memberNo = memberNo;
        this.authorityCode = authorityCode;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(Integer authorityCode) {
        this.authorityCode = authorityCode;
    }

    @Override
    public String toString() {
        return "MemberRolePK{" +
                "memberNo=" + memberNo +
                ", authorityCode=" + authorityCode +
                '}';
    }
}
