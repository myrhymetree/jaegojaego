package com.greedy.jaegojaego.franchise.entity;

import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.member.model.entity.MemberRole;
import com.greedy.jaegojaego.member.model.entity.PasswordUpdatedRecord;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <pre>
 * Class : FranchiseDetailView
 * Comment : FRANCHISE_INFO 테이블과 대응할 엔티티
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@SuperBuilder
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

    public FranchiseDetailView() {}

    public FranchiseDetailView(Integer memberNo, String memberId, String memberPwd, LocalDateTime memberPwdUpdateDate, String memberPwdInitStatus, LocalDateTime memberCreatedDate, LocalDateTime memberRemovedDate, String memberRemoveStatus, String officeDivision, String memberDivision, List<MemberRole> memberRoleList, List<PasswordUpdatedRecord> passwordUpdatedRecords, String representativeName, String representativePhone, String representativeEmail, String branchName, String businessRegistrationNo, String address, String bankAccountNo, Integer supervisorNo, Integer writedMemberNo, String phone, CompanyAccount writer, CompanyAccount supervisor, List<FranchiseAttachmentFile> franchiseAttachmentFiles, FranchiseContractUpdatedRecord franchiseContractUpdatedRecord) {
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
        this.writer = writer;
        this.supervisor = supervisor;
        this.franchiseAttachmentFiles = franchiseAttachmentFiles;
        this.franchiseContractUpdatedRecord = franchiseContractUpdatedRecord;
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

    public CompanyAccount getWriter() {
        return writer;
    }

    public void setWriter(CompanyAccount writer) {
        this.writer = writer;
    }

    public CompanyAccount getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(CompanyAccount supervisor) {
        this.supervisor = supervisor;
    }

    public List<FranchiseAttachmentFile> getFranchiseAttachmentFiles() {
        return franchiseAttachmentFiles;
    }

    public void setFranchiseAttachmentFiles(List<FranchiseAttachmentFile> franchiseAttachmentFiles) {
        this.franchiseAttachmentFiles = franchiseAttachmentFiles;
    }

    public FranchiseContractUpdatedRecord getFranchiseContractUpdatedRecord() {
        return franchiseContractUpdatedRecord;
    }

    public void setFranchiseContractUpdatedRecord(FranchiseContractUpdatedRecord franchiseContractUpdatedRecord) {
        this.franchiseContractUpdatedRecord = franchiseContractUpdatedRecord;
    }

    @Override
    public String toString() {
        return "FranchiseDetailView{" +
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
                ", writer=" + writer +
                ", supervisor=" + supervisor +
                ", franchiseAttachmentFiles=" + franchiseAttachmentFiles +
                ", franchiseContractUpdatedRecord=" + franchiseContractUpdatedRecord +
                '}';
    }
}
