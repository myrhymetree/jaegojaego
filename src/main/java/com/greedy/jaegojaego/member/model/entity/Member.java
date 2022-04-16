package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Member")
@Table(name = "MEMBER")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "SEQ_MEMBER_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member implements Serializable {

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    public void addMemberRole(MemberRole memberRole) {
        roleSet.add(memberRole);
    }

    @EmbeddedId
    private AdminInfo adminInfo;

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR"
    )
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "MEMBER_ID")
    private String memberId;        //id라고 명시를 해줘야 쿼리문을 쓰는게 아닌 자동으로 jpa가 취급해줌

    @Column(name = "MEMBER_PWD")
    private String memberPwd;

    @Column(name = "MEMBER_PWD_UPDATE_DATE")
    private java.sql.Date memberPwdUpdateDate;

    @Column(name = "MEMBER_PWD_INIT_STATUS")
    private String memberPwdInitStatus;

    @Column(name = "MEMBER_CREATED_DATE")
    private java.sql.Date memberCreatedDate;

    @Column(name = "MEMBER_REMOVED_DATE")
    private java.sql.Date memberRemovedDate;

    @Column(name = "MEMBER_REMOVE_STATUS")
    private String memberRemoveStatus;

    @Column(name = "FRANCHISE_DIVISION")
    private String franchiseDivision;

    @Column(name = "OFFICE_DIVISION")
    private String officeDivision;

    @Column(name = "MEMBER_DIVISION")
    private String memberDivision;

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberPwdUpdateDate=" + memberPwdUpdateDate +
                ", memberPwdInitStatus='" + memberPwdInitStatus + '\'' +
                ", memberCreatedDate=" + memberCreatedDate +
                ", memberRemovedDate=" + memberRemovedDate +
                ", memberRemoveStatus='" + memberRemoveStatus + '\'' +
                ", franchiseDivision='" + franchiseDivision + '\'' +
                ", officeDivision='" + officeDivision + '\'' +
                ", memberDivision='" + memberDivision + '\'' +
                '}';
    }
}
