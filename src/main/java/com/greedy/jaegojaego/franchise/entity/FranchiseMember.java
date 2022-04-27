package com.greedy.jaegojaego.franchise.entity;

import com.greedy.jaegojaego.member.model.entity.MemberRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "FranchiseMember")
@Table(name = "MEMBER")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class FranchiseMember implements Serializable{

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR"
    )
    @Column(name = "MEMBER_NO")
    private Integer memberNo;

    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "MEMBER_PWD")
    private String memberPwd;

    @Column(name = "MEMBER_PWD_UPDATE_DATE")
    private LocalDateTime memberPwdUpdateDate;

    @Column(name = "MEMBER_PWD_INIT_STATUS", columnDefinition = "varchar2(1) default 'N'")
    private String memberPwdInitStatus;

    @Column(name = "MEMBER_CREATED_DATE")
    private LocalDateTime memberCreatedDate;

    @Column(name = "MEMBER_REMOVED_DATE")
    private LocalDateTime memberRemovedDate;

    @Column(name = "MEMBER_REMOVE_STATUS")
    private String memberRemoveStatus;

    @Column(name = "FRANCHISE_DIVISION")
    private String franchiseDivision;

    @Column(name = "OFFICE_DIVISION")
    private String officeDivision;

    @Column(name = "MEMBER_DIVISION")
    private String memberDivision;

    @JoinColumn(name = "MEMBER_NO", insertable = false, updatable = false)
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<MemberRole> memberRoleList;

//    @OneToOne
//    @JoinColumn(name = "MEMBER_NO")
//    private MemberRole memberRole;

    public FranchiseMember() {}

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
                ", memberRoleList=" + memberRoleList +
                '}';
    }
}
