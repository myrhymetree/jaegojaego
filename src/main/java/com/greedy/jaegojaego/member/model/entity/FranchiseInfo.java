package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "FranchiseInfo")
@Table(name = "FRANCHISE_INFO")
public class FranchiseInfo {

    @Id
    @Column(name = "FRANCHISE_REPRESENTATIVE_NO")
    private int representativeNo;

    @Column(name = "FRANCHISE_REPRESENTATIVE_NAME")
    private String representativeName;

    @Column(name = "FRANCHISE_REPRESENTATIVE_PHONE")
    private String representativePhone;

    @Column(name = "FRANCHISE_REPRESENTATIVE_EMAIL")
    private String representativeEmail;

    @Column(name = "FRANCHISE_BRANCH_NAME")
    private String branchName;

    @Column(name = "FRANCHISE_BUSINESS_REGISTRATION_NO")
    private String businessRegistrationNo;

    @Column(name = "FRANCHISE_ADDRESS")
    private String address;

    @JoinColumn(name = "REGISTRATION_ATTACHMENT_NO")
    private int registrationAttachmentNo;
    
    @JoinColumn(name = "CONTRACT_ATTACHMENT_NO")
    private int contractAttachmentNo;

    @JoinColumn(name = "BANK_ACCOUNT_ATTACHMENT_NO")
    private int bankAccountAttachmentNo;

    @Column(name = "BANK_ACCOUNT_NO")
    private String bankAccountNo;

    @JoinColumn(name = "HEAD_OFFICE_SUPERVISOR_NO")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Member supervisorNo;


    @JoinColumn(name = "HEAD_OFFICE_WRITED_MEMBER")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Member writedMember;

    @Column(name = "FRANCHISE_PHONE")
    private String phone;

    @Override
    public String toString() {
        return "FranchiseInfo{" +
                "representativeNo=" + representativeNo +
//                ", representativeName='" + representativeName + '\'' +
//                ", representativePhone=" + representativePhone +
//                ", representativeEmail='" + representativeEmail + '\'' +
                ", branchName='" + branchName + '\'' +
//                ", businessRegistrationNo=" + businessRegistrationNo +
                ", address='" + address + '\'' +
//                ", registrationAttachmentNo=" + registrationAttachmentNo +
//                ", contractAttachmentNo=" + contractAttachmentNo +
//                ", bankAccountAttachmentNo=" + bankAccountAttachmentNo +
//                ", bankAccountNo=" + bankAccountNo +
//                ", supervisorNo=" + supervisorNo +
//                ", writedMember=" + writedMember +
//                ", phone=" + phone +
                '}';
    }
}
