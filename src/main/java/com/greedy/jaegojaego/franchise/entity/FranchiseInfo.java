package com.greedy.jaegojaego.franchise.entity;

import com.greedy.jaegojaego.member.model.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "FranchiseInfo")
@Table(name = "FRANCHISE_INFO")
public class FranchiseInfo extends FranchiseMember {

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

    @Column(name = "BANK_ACCOUNT_NO")
    private String bankAccountNo;

    @JoinColumn(name = "HEAD_OFFICE_SUPERVISOR_NO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member supervisorNo;

    @JoinColumn(name = "HEAD_OFFICE_WRITED_MEMBER_NO", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member writedMemberNo;

    @Column(name = "FRANCHISE_PHONE")
    private String phone;

    @Column(name = "HEAD_OFFICE_WRITED_MEMBER_NO")
    private Integer headOfficeWritedMemberNo;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private List<FranchiseAttachmentFile> franchiseAttachmentFiles;

}
