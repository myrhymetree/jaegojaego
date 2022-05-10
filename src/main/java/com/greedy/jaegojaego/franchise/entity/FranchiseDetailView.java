package com.greedy.jaegojaego.franchise.entity;

import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import com.greedy.jaegojaego.member.model.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "FRANCHISE_INFO_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_REPRESENTATIVE_NO",
        initialValue = 1,
        allocationSize = 1
)
@Entity(name = "FranchiseDetailView")
@Table(name = "FRANCHISE_INFO")
@PrimaryKeyJoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
public class FranchiseDetailView extends Member {

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

    @JoinColumn(name = "HEAD_OFFICE_WRITED_MEMBER_NO", updatable = false, insertable = false)
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private CompanyAccount writer;

    @JoinColumn(name = "HEAD_OFFICE_SUPERVISOR_NO", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private CompanyAccount supervisor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private List<FranchiseAttachmentFile> franchiseAttachmentFiles;

    @Transient
    private FranchiseContractUpdatedRecord franchiseContractUpdatedRecord;

}
