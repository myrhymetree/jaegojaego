package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "companyAccount")
@Table(name = "COMPANY_ACCOUNT")
public class CompanyAccount extends Member {

    @Id
    @Column(name = "MEMBER_NO")
    private Integer memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_EMAIL")
    private String memberEmail;

    @Column(name = "MEMBER_CELLPHONE")
    private String memberCellPhone;

    @Column(name = "OFFICE_PHONE_NUMBER")
    private String officePhoneNumber;

    @ManyToOne
    @JoinColumn(name = "MEMBER_DEPARTMENT")
    private Department depatment;
}