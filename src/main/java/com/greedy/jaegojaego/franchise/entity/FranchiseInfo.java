package com.greedy.jaegojaego.franchise.entity;

import com.greedy.jaegojaego.member.model.entity.Member;
import lombok.*;

import javax.naming.Name;
import javax.persistence.*;
import java.time.LocalDateTime;
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

    @Column(name = "FRANCHISE_BRANCH_NAME", unique = true)
    private String branchName;

    @Column(name = "FRANCHISE_BUSINESS_REGISTRATION_NO")
    private String businessRegistrationNo;

    @Column(name = "FRANCHISE_ADDRESS")
    private String address;

    @Column(name = "BANK_ACCOUNT_NO")
    private String bankAccountNo;

    @Column(name = "HEAD_OFFICE_SUPERVISOR_NO")
    private Integer supervisorNo;

    @Column(name = "HEAD_OFFICE_WRITED_MEMBER_NO")
    private Integer writedMemberNo;

    @Column(name = "FRANCHISE_PHONE")
    private String phone;

    @JoinColumn(name = "HEAD_OFFICE_SUPERVISOR_NO", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member supervisor;

    @JoinColumn(name = "HEAD_OFFICE_WRITED_MEMBER_NO",insertable = false,  updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member writedMember;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private List<FranchiseAttachmentFile> franchiseAttachmentFiles;

    @OneToMany(mappedBy = "franchiseInfo")
    private List<FranchiseContractUpdatedRecord> franchiseContractUpdatedRecords;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO", insertable = false)
    private List<FranchiseInfoUpdatedRecord> franchiseInfoUpdatedRecords;

    @Transient
    private LocalDateTime franchiseContractStartedDate;

    @Transient
    private LocalDateTime franchiseContractExpiredDate;

    @Transient
    private String franchiseContractStatus;
}
