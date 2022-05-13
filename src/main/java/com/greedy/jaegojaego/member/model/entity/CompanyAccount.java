package com.greedy.jaegojaego.member.model.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <pre>
 * Class : CompanyAccount
 * Comment : COMPANY_ACCOUNT 테이블과 대응할 엔티티, MEMBER 테이블과 슈퍼타입-서브타입 관게로 이루어짐
 *           본사 계정에 대한 모든 추가 정보가 기재된 테이블이다.
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Setter
@Getter
@Entity(name = "CompanyAccount")
@EqualsAndHashCode
@Table(name = "COMPANY_ACCOUNT")
@DynamicUpdate
@DynamicInsert
@NamedEntityGraph(name = "Department.all", attributeNodes = @NamedAttributeNode("department"))
@PrimaryKeyJoinColumn(name = "MEMBER_NO")
public class CompanyAccount extends Member {

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_EMAIL")
    private String memberEmail;

    @Column(name = "MEMBER_CELLPHONE")
    private String memberCellPhone;

    @Column(name = "OFFICE_PHONE_NUMBER")
    private String officePhoneNumber;

    @Column(name = "MEMBER_DEPARTMENT")
    private Integer departmentNo;

    @Column(name = "COMPANY_ADDESS")
    private String companyAddress;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "MEMBER_DEPARTMENT", insertable = false, updatable = false)
    private Department department;

    public CompanyAccount() {}

    public CompanyAccount(Integer memberNo, String memberId, String memberPwd, LocalDateTime memberPwdUpdateDate, String memberPwdInitStatus, LocalDateTime memberCreatedDate, LocalDateTime memberRemovedDate, String memberRemoveStatus, String officeDivision, String memberDivision, List<MemberRole> memberRoleList, List<PasswordUpdatedRecord> passwordUpdatedRecords, String memberName, String memberEmail, String memberCellPhone, String officePhoneNumber, Integer departmentNo, String companyAddress, Department department) {
        super(memberNo, memberId, memberPwd, memberPwdUpdateDate, memberPwdInitStatus, memberCreatedDate, memberRemovedDate, memberRemoveStatus, officeDivision, memberDivision, memberRoleList, passwordUpdatedRecords);
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberCellPhone = memberCellPhone;
        this.officePhoneNumber = officePhoneNumber;
        this.departmentNo = departmentNo;
        this.companyAddress = companyAddress;
        this.department = department;
    }

    @Override
    public String toString() {
        return "CompanyAccount{" +
                "memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberCellPhone='" + memberCellPhone + '\'' +
                ", officePhoneNumber='" + officePhoneNumber + '\'' +
                ", departmentNo=" + departmentNo +
                ", companyAddress='" + companyAddress + '\'' +
                ", department=" + department +
                '}';
    }
}
