package com.greedy.jaegojaego.member.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANY_ACCOUNT")
public class CompanyAccount {

    @Id
    @Column(name = "MEMBER_NO")
    private Integer memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_EMAIL")
    private String memberEmail;

    @Column(name = "MEMBER_CELLPHONE")
    private String memberCellPhone;

    @ManyToOne
    @JoinColumn(name = "MEMBER_DEPARTMENT")
    private Department depatment;
}
