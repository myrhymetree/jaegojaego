package com.greedy.jaegojaego.member.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


/**
 * <pre>
 * Class : Member
 * Comment : MEMBER 테이블과 대응할 엔티티, 계정 테이블이다.
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Entity(name = "Member")
@Table(name = "MEMBER")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_NO",
        initialValue = 1,
        allocationSize = 1
)
@SuperBuilder
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)     //상속매핑의 join전략을 사용한다.
@DynamicUpdate
@DynamicInsert
public class Member {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR"
    )
    @Column(name = "MEMBER_NO")
    private Integer memberNo;

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

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MEMBER_NO")
    private List<PasswordUpdatedRecord> passwordUpdatedRecords;

    public Member() {}

    public Member(Integer memberNo, String memberId, String memberPwd, LocalDateTime memberPwdUpdateDate, String memberPwdInitStatus, LocalDateTime memberCreatedDate, LocalDateTime memberRemovedDate, String memberRemoveStatus, String officeDivision, String memberDivision, List<MemberRole> memberRoleList, List<PasswordUpdatedRecord> passwordUpdatedRecords) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberPwdUpdateDate = memberPwdUpdateDate;
        this.memberPwdInitStatus = memberPwdInitStatus;
        this.memberCreatedDate = memberCreatedDate;
        this.memberRemovedDate = memberRemovedDate;
        this.memberRemoveStatus = memberRemoveStatus;
        this.officeDivision = officeDivision;
        this.memberDivision = memberDivision;
        this.memberRoleList = memberRoleList;
        this.passwordUpdatedRecords = passwordUpdatedRecords;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public LocalDateTime getMemberPwdUpdateDate() {
        return memberPwdUpdateDate;
    }

    public void setMemberPwdUpdateDate(LocalDateTime memberPwdUpdateDate) {
        this.memberPwdUpdateDate = memberPwdUpdateDate;
    }

    public String getMemberPwdInitStatus() {
        return memberPwdInitStatus;
    }

    public void setMemberPwdInitStatus(String memberPwdInitStatus) {
        this.memberPwdInitStatus = memberPwdInitStatus;
    }

    public LocalDateTime getMemberCreatedDate() {
        return memberCreatedDate;
    }

    public void setMemberCreatedDate(LocalDateTime memberCreatedDate) {
        this.memberCreatedDate = memberCreatedDate;
    }

    public LocalDateTime getMemberRemovedDate() {
        return memberRemovedDate;
    }

    public void setMemberRemovedDate(LocalDateTime memberRemovedDate) {
        this.memberRemovedDate = memberRemovedDate;
    }

    public String getMemberRemoveStatus() {
        return memberRemoveStatus;
    }

    public void setMemberRemoveStatus(String memberRemoveStatus) {
        this.memberRemoveStatus = memberRemoveStatus;
    }

    public String getOfficeDivision() {
        return officeDivision;
    }

    public void setOfficeDivision(String officeDivision) {
        this.officeDivision = officeDivision;
    }

    public String getMemberDivision() {
        return memberDivision;
    }

    public void setMemberDivision(String memberDivision) {
        this.memberDivision = memberDivision;
    }

    public List<MemberRole> getMemberRoleList() {
        return memberRoleList;
    }

    public void setMemberRoleList(List<MemberRole> memberRoleList) {
        this.memberRoleList = memberRoleList;
    }

    public List<PasswordUpdatedRecord> getPasswordUpdatedRecords() {
        return passwordUpdatedRecords;
    }

    public void setPasswordUpdatedRecords(List<PasswordUpdatedRecord> passwordUpdatedRecords) {
        this.passwordUpdatedRecords = passwordUpdatedRecords;
    }

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
