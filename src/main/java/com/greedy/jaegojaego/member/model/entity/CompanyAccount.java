package com.greedy.jaegojaego.member.model.entity;

import com.greedy.jaegojaego.franchise.entity.FranchiseInfoUpdatedRecord;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CompanyAccount")
@EqualsAndHashCode
@Table(name = "COMPANY_ACCOUNT")
@DynamicUpdate
@NamedEntityGraph(name = "Department.all", attributeNodes = @NamedAttributeNode("department"))
//@DiscriminatorValue("본사")
public class CompanyAccount extends Member {

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_EMAIL")
    private String memberEmail;

    @Column(name = "MEMBER_CELLPHONE")
    private String memberCellPhone;

    @Column(name = "OFFICE_PHONE_NUMBER")
    private String officePhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_DEPARTMENT")
    private Department department;

    @Override
    public String toString() {
        return "CompanyAccount{" +
                "memberNo=" + super.getMemberNo() +
                ", memberId=" + super.getMemberId() +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberCellPhone='" + memberCellPhone + '\'' +
                ", officePhoneNumber='" + officePhoneNumber + '\'' +
                ", department=" + department +
                '}';
    }
}
