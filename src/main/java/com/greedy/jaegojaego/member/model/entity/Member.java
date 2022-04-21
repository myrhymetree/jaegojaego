package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
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

//    @ElementCollection(fetch = FetchType.LAZY)
//    @Builder.Default
//    private Set<MemberRole> roleSet = new HashSet<>();

//    public void addMemberRole(MemberRole memberRole) {
//        roleSet.add(memberRole);
//    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR"
    )
    @Column(name = "MEMBER_NO")
    private Integer memberNo;
    //int를 지양하는 이유 : int는 0을 담을 수 있기 때문이다, Integer는 보통 10억바이트 정도만 담을 수 있기때문에 보통은 Long이 권장됨
    //데이터가 많이 쌓여있을 때 Integer -> Long으로 바꾸면 여러 문제가 생길 수 있다

    @OneToOne
    @JoinColumn(name = "MEMBER_NO")
    private EmployeeInfo employeeInfo;

    @Column(name = "MEMBER_ID")
    private String memberId;        //id라고 명시를 해줘야 쿼리문을 쓰는게 아닌 자동으로 jpa가 취급해줌

    @Column(name = "MEMBER_PWD")
    private String memberPwd;

    @Column(name = "MEMBER_PWD_UPDATE_DATE")
    private java.sql.Date memberPwdUpdateDate;

    @Column(name = "MEMBER_PWD_INIT_STATUS")
    private String memberPwdInitStatus;

    //    @Temporal(TemporalType.TIMESTAMP)     //LocalDateTime(java8부터 지원)을 사용하기 때문에 사용할 필요없음, Temporal 사용이유 : DB에 시간, 날짜를 저장하기 위해서
    @Column(name = "MEMBER_CREATED_DATE")
    private LocalDateTime memberCreatedDate;

//    @Temporal(TemporalType.TIMESTAMP)
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
