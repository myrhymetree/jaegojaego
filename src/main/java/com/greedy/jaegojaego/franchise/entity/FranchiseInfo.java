package com.greedy.jaegojaego.franchise.entity;

import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.member.model.entity.MemberRole;
import com.greedy.jaegojaego.member.model.entity.PasswordUpdatedRecord;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.naming.Name;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <pre>
 * Class : FranchiseInfo
 * Comment : FRANCHISE_INFO 테이블과 대응할 엔티티, MEMBER 테이블과 슈퍼타입-서브타입 관게로 이루어짐
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@SuperBuilder
@DynamicUpdate
@DynamicInsert
@SequenceGenerator(
        name = "FRANCHISE_INFO_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_REPRESENTATIVE_NO",
        initialValue = 1,
        allocationSize = 1
)
@Entity(name = "FranchiseInfo")
@Table(name = "FRANCHISE_INFO")
@PrimaryKeyJoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CompanyAccount supervisor;

    @JoinColumn(name = "HEAD_OFFICE_WRITED_MEMBER_NO",insertable = false,  updatable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Member writedMember;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private List<FranchiseAttachmentFile> franchiseAttachmentFiles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private List<FranchiseContractUpdatedRecord> franchiseContractUpdatedRecords;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO", insertable = false)
    private List<FranchiseInfoUpdatedRecord> franchiseInfoUpdatedRecords;

    @OneToMany(mappedBy = "franchiseInfo")
    private List<FranchiseAccount> franchiseAccounts;

    @Transient
    private LocalDateTime franchiseContractStartedDate;

    @Transient
    private LocalDateTime franchiseContractExpiredDate;

    @Transient
    private String franchiseContractStatus;

    public FranchiseInfo() {}

    public FranchiseInfo(Integer memberNo, String memberId, String memberPwd, LocalDateTime memberPwdUpdateDate, String memberPwdInitStatus, LocalDateTime memberCreatedDate, LocalDateTime memberRemovedDate, String memberRemoveStatus, String officeDivision, String memberDivision, List<MemberRole> memberRoleList, List<PasswordUpdatedRecord> passwordUpdatedRecords, String representativeName, String representativePhone, String representativeEmail, String branchName, String businessRegistrationNo, String address, String bankAccountNo, Integer supervisorNo, Integer writedMemberNo, String phone, CompanyAccount supervisor, Member writedMember, List<FranchiseAttachmentFile> franchiseAttachmentFiles, List<FranchiseContractUpdatedRecord> franchiseContractUpdatedRecords, List<FranchiseInfoUpdatedRecord> franchiseInfoUpdatedRecords, List<FranchiseAccount> franchiseAccounts, LocalDateTime franchiseContractStartedDate, LocalDateTime franchiseContractExpiredDate, String franchiseContractStatus) {
        super(memberNo, memberId, memberPwd, memberPwdUpdateDate, memberPwdInitStatus, memberCreatedDate, memberRemovedDate, memberRemoveStatus, officeDivision, memberDivision, memberRoleList, passwordUpdatedRecords);
        this.representativeName = representativeName;
        this.representativePhone = representativePhone;
        this.representativeEmail = representativeEmail;
        this.branchName = branchName;
        this.businessRegistrationNo = businessRegistrationNo;
        this.address = address;
        this.bankAccountNo = bankAccountNo;
        this.supervisorNo = supervisorNo;
        this.writedMemberNo = writedMemberNo;
        this.phone = phone;
        this.supervisor = supervisor;
        this.writedMember = writedMember;
        this.franchiseAttachmentFiles = franchiseAttachmentFiles;
        this.franchiseContractUpdatedRecords = franchiseContractUpdatedRecords;
        this.franchiseInfoUpdatedRecords = franchiseInfoUpdatedRecords;
        this.franchiseAccounts = franchiseAccounts;
        this.franchiseContractStartedDate = franchiseContractStartedDate;
        this.franchiseContractExpiredDate = franchiseContractExpiredDate;
        this.franchiseContractStatus = franchiseContractStatus;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getRepresentativePhone() {
        return representativePhone;
    }

    public void setRepresentativePhone(String representativePhone) {
        this.representativePhone = representativePhone;
    }

    public String getRepresentativeEmail() {
        return representativeEmail;
    }

    public void setRepresentativeEmail(String representativeEmail) {
        this.representativeEmail = representativeEmail;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBusinessRegistrationNo() {
        return businessRegistrationNo;
    }

    public void setBusinessRegistrationNo(String businessRegistrationNo) {
        this.businessRegistrationNo = businessRegistrationNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public Integer getSupervisorNo() {
        return supervisorNo;
    }

    public void setSupervisorNo(Integer supervisorNo) {
        this.supervisorNo = supervisorNo;
    }

    public Integer getWritedMemberNo() {
        return writedMemberNo;
    }

    public void setWritedMemberNo(Integer writedMemberNo) {
        this.writedMemberNo = writedMemberNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CompanyAccount getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(CompanyAccount supervisor) {
        this.supervisor = supervisor;
    }

    public Member getWritedMember() {
        return writedMember;
    }

    public void setWritedMember(Member writedMember) {
        this.writedMember = writedMember;
    }

    public List<FranchiseAttachmentFile> getFranchiseAttachmentFiles() {
        return franchiseAttachmentFiles;
    }

    public void setFranchiseAttachmentFiles(List<FranchiseAttachmentFile> franchiseAttachmentFiles) {
        this.franchiseAttachmentFiles = franchiseAttachmentFiles;
    }

    public List<FranchiseContractUpdatedRecord> getFranchiseContractUpdatedRecords() {
        return franchiseContractUpdatedRecords;
    }

    public void setFranchiseContractUpdatedRecords(List<FranchiseContractUpdatedRecord> franchiseContractUpdatedRecords) {
        this.franchiseContractUpdatedRecords = franchiseContractUpdatedRecords;
    }

    public List<FranchiseInfoUpdatedRecord> getFranchiseInfoUpdatedRecords() {
        return franchiseInfoUpdatedRecords;
    }

    public void setFranchiseInfoUpdatedRecords(List<FranchiseInfoUpdatedRecord> franchiseInfoUpdatedRecords) {
        this.franchiseInfoUpdatedRecords = franchiseInfoUpdatedRecords;
    }

    public List<FranchiseAccount> getFranchiseAccounts() {
        return franchiseAccounts;
    }

    public void setFranchiseAccounts(List<FranchiseAccount> franchiseAccounts) {
        this.franchiseAccounts = franchiseAccounts;
    }

    public LocalDateTime getFranchiseContractStartedDate() {
        return franchiseContractStartedDate;
    }

    public void setFranchiseContractStartedDate(LocalDateTime franchiseContractStartedDate) {
        this.franchiseContractStartedDate = franchiseContractStartedDate;
    }

    public LocalDateTime getFranchiseContractExpiredDate() {
        return franchiseContractExpiredDate;
    }

    public void setFranchiseContractExpiredDate(LocalDateTime franchiseContractExpiredDate) {
        this.franchiseContractExpiredDate = franchiseContractExpiredDate;
    }

    public String getFranchiseContractStatus() {
        return franchiseContractStatus;
    }

    public void setFranchiseContractStatus(String franchiseContractStatus) {
        this.franchiseContractStatus = franchiseContractStatus;
    }

    @Override
    public String toString() {
        return "FranchiseInfo{" +
                "representativeName='" + representativeName + '\'' +
                ", representativePhone='" + representativePhone + '\'' +
                ", representativeEmail='" + representativeEmail + '\'' +
                ", branchName='" + branchName + '\'' +
                ", businessRegistrationNo='" + businessRegistrationNo + '\'' +
                ", address='" + address + '\'' +
                ", bankAccountNo='" + bankAccountNo + '\'' +
                ", supervisorNo=" + supervisorNo +
                ", writedMemberNo=" + writedMemberNo +
                ", phone='" + phone + '\'' +
                ", supervisor=" + supervisor +
                ", writedMember=" + writedMember +
                ", franchiseAttachmentFiles=" + franchiseAttachmentFiles +
                ", franchiseContractUpdatedRecords=" + franchiseContractUpdatedRecords +
                ", franchiseInfoUpdatedRecords=" + franchiseInfoUpdatedRecords +
                ", franchiseAccounts=" + franchiseAccounts +
                '}';
    }
}
