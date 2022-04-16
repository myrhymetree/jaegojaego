package com.greedy.jaegojaego.member.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FranchiseInfo")
@Table(name = "FRANCHISE_INFO")
public class FranchiseInfo {

    @Id
    @Column(name = "FRANCHISE_REPRESENTATIVE_NO")
    private int representativeNo;

    @Column(name = "FRANCHISE_REPRESENTATIVE_NAME")
    private String representativeName;

    @Column(name = "FRANCHISE_REPRESENTATIVE_PHONE")
    private int representativePhone;

    @Column(name = "FRANCHISE_REPRESENTATIVE_EMAIL")
    private String representativeEmail;

    @Column(name = "FRANCHISE_BRANCH_NAME")
    private String branchName;

    @Column(name = "FRANCHISE_BUSINESS_REGISTRATION_NO")
    private int businessRegistrationNo;

    @Column(name = "FRANCHISE_ADDRESS")
    private String address;

    @Column(name = "REGISTRATION_ATTACHMENT_NO")
    private int registrationAttachmentNo;
    

}
