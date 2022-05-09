package com.greedy.jaegojaego.member.model.entity;

import com.greedy.jaegojaego.franchise.entity.FranchiseInfoUpdatedRecord;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
        sequenceName = "MEMBER_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)
@DynamicUpdate
@DynamicInsert
//@DiscriminatorColumn(name = "MEMBER_DIVISION")
public class Member {

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

    /* 일대일 정리 :
    * 주 테이블에 외래 키
    * - 주 객체가 대상 객체의 참조를 가지는 것처럼 주 테이블에 외래키를 두고 대상 테이블을 찾음
    * - JPA 매핑 편리
    * 장점 : 주 테이블만 조회해도 대상 테이블의 데이터가 있는지 확인 가능
    * 단점 : 값이 없으면 외래 키에 null 허용 */
//    @OneToOne
//    @JoinColumn(name = "MEMBER_NO")
//    private EmployeeInfo employeeInfo;
//
//    @OneToOne
//    @JoinColumn(name = "MEMBER_NO")
//    private CompanyAccount companyAccount;

    @Column(name = "MEMBER_ID")
    private String memberId;        //id라고 명시를 해줘야 쿼리문을 쓰는게 아닌 자동으로 jpa가 취급해줌

    @Column(name = "MEMBER_PWD")
    private String memberPwd;

    @Column(name = "MEMBER_PWD_UPDATE_DATE")
    private LocalDateTime memberPwdUpdateDate;

    @Column(name = "MEMBER_PWD_INIT_STATUS", columnDefinition = "varchar2(1) default 'N'")
    private String memberPwdInitStatus;

    //    @Temporal(TemporalType.TIMESTAMP)     //LocalDateTime(java8부터 지원)을 사용하기 때문에 사용할 필요없음, Temporal 사용이유 : DB에 시간, 날짜를 저장하기 위해서
    @Column(name = "MEMBER_CREATED_DATE",updatable = false)
    private LocalDateTime memberCreatedDate;

    @Column(name = "MEMBER_REMOVED_DATE")
    private LocalDateTime memberRemovedDate;

    @Column(name = "MEMBER_REMOVE_STATUS")
    private String memberRemoveStatus;

    @Column(name = "OFFICE_DIVISION", updatable = false)
    private String officeDivision;

    @Column(name = "MEMBER_DIVISION", updatable = false)
    private String memberDivision;

    @JoinColumn(name = "MEMBER_NO")
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<MemberRole> memberRoleList;

    @OneToMany(mappedBy = "member")
    private List<PasswordUpdatedRecord> passwordUpdatedRecords;

//    @JoinColumn(name = "MEMBER_NO")
//    @OneToOne(cascade = CascadeType.PERSIST)
//    private MemberRole memberRole;


//    @OneToOne
//    @JoinColumn(name = "MEMBER_NO")
//    private MemberRole memberRole;

    public Member() {}

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
                ", officeDivision='" + officeDivision + '\'' +
                ", memberDivision='" + memberDivision + '\'' +
                ", memberRoleList=" + memberRoleList +
                '}';
    }
}
