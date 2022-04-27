package com.greedy.jaegojaego.franchise.entity;

import com.greedy.jaegojaego.member.model.entity.Member;
import lombok.*;

import javax.naming.Name;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@SequenceGenerator(
        name = "FRANCHISE_INFO_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_REPRESENTATIVE_NO",
        initialValue = 1,
        allocationSize = 1
)
@Entity(name = "FranchiseInfo")
@Table(name = "FRANCHISE_INFO")
@PrimaryKeyJoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
//@DiscriminatorValue(value = "가맹점")
public class FranchiseInfo extends Member {

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

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private List<FranchiseAttachmentFile> franchiseAttachmentFiles;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private List<FranchiseContractUpdatedRecord> franchiseContractUpdatedRecords;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private List<FranchiseInfoUpdatedRecord> franchiseInfoUpdatedRecords;
}
