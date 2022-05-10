package com.greedy.jaegojaego.franchise.dto;

import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.entity.CompanyAccount;
import com.greedy.jaegojaego.member.model.entity.Member;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

public class FranchiseInfoDTO extends MemberDTO {

    private String representativeName;
    private String representativePhone;
    private String representativeEmail;
    private String branchName;
    private String businessRegistrationNo;
    private String address;
    private String bankAccountNo;
    private Integer supervisorNo;
    private Integer writedMemberNo;
    private String phone;
    private Integer headOfficeWritedMemberNo;
    private CompanyAccountDTO supervisor;
    private MemberDTO writedMember;
    private List<FranchiseAttachmentFileDTO> franchiseAttachmentFiles;
    private List<FranchiseContractUpdatedRecordDTO> franchiseContractUpdatedRecords;
    private List<FranchiseInfoUpdatedRecordDTO> franchiseInfoUpdatedRecords;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime franchiseContractStartedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime franchiseContractExpiredDate;
    private String franchiseContractStatus;

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

    public Integer getHeadOfficeWritedMemberNo() {
        return headOfficeWritedMemberNo;
    }

    public void setHeadOfficeWritedMemberNo(Integer headOfficeWritedMemberNo) {
        this.headOfficeWritedMemberNo = headOfficeWritedMemberNo;
    }

    public CompanyAccountDTO getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(CompanyAccountDTO supervisor) {
        this.supervisor = supervisor;
    }

    public MemberDTO getWritedMember() {
        return writedMember;
    }

    public void setWritedMember(MemberDTO writedMember) {
        this.writedMember = writedMember;
    }

    public List<FranchiseAttachmentFileDTO> getFranchiseAttachmentFiles() {
        return franchiseAttachmentFiles;
    }

    public void setFranchiseAttachmentFiles(List<FranchiseAttachmentFileDTO> franchiseAttachmentFiles) {
        this.franchiseAttachmentFiles = franchiseAttachmentFiles;
    }

    public List<FranchiseContractUpdatedRecordDTO> getFranchiseContractUpdatedRecords() {
        return franchiseContractUpdatedRecords;
    }

    public void setFranchiseContractUpdatedRecords(List<FranchiseContractUpdatedRecordDTO> franchiseContractUpdatedRecords) {
        this.franchiseContractUpdatedRecords = franchiseContractUpdatedRecords;
    }

    public List<FranchiseInfoUpdatedRecordDTO> getFranchiseInfoUpdatedRecords() {
        return franchiseInfoUpdatedRecords;
    }

    public void setFranchiseInfoUpdatedRecords(List<FranchiseInfoUpdatedRecordDTO> franchiseInfoUpdatedRecords) {
        this.franchiseInfoUpdatedRecords = franchiseInfoUpdatedRecords;
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

    public FranchiseInfoDTO() {}

    public FranchiseInfoDTO(String representativeName, String representativePhone, String representativeEmail, String branchName, String businessRegistrationNo, String address, String bankAccountNo, Integer supervisorNo, Integer writedMemberNo, String phone, Integer headOfficeWritedMemberNo, CompanyAccountDTO supervisor, MemberDTO writedMember, List<FranchiseAttachmentFileDTO> franchiseAttachmentFiles, List<FranchiseContractUpdatedRecordDTO> franchiseContractUpdatedRecords, List<FranchiseInfoUpdatedRecordDTO> franchiseInfoUpdatedRecords, LocalDateTime franchiseContractStartedDate, LocalDateTime franchiseContractExpiredDate, String franchiseContractStatus) {
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
        this.headOfficeWritedMemberNo = headOfficeWritedMemberNo;
        this.supervisor = supervisor;
        this.writedMember = writedMember;
        this.franchiseAttachmentFiles = franchiseAttachmentFiles;
        this.franchiseContractUpdatedRecords = franchiseContractUpdatedRecords;
        this.franchiseInfoUpdatedRecords = franchiseInfoUpdatedRecords;
        this.franchiseContractStartedDate = franchiseContractStartedDate;
        this.franchiseContractExpiredDate = franchiseContractExpiredDate;
        this.franchiseContractStatus = franchiseContractStatus;
    }

    @Override
    public String toString() {
        return "FranchiseInfoDTO{" +
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
                ", headOfficeWritedMemberNo=" + headOfficeWritedMemberNo +
                ", supervisor=" + supervisor +
                ", writedMember=" + writedMember +
                ", franchiseAttachmentFiles=" + franchiseAttachmentFiles +
                ", franchiseContractUpdatedRecords=" + franchiseContractUpdatedRecords +
                ", franchiseInfoUpdatedRecords=" + franchiseInfoUpdatedRecords +
                ", franchiseContractStartedDate=" + franchiseContractStartedDate +
                ", franchiseContractExpiredDate=" + franchiseContractExpiredDate +
                ", franchiseContractStatus='" + franchiseContractStatus + '\'' +
                '}';
    }
}
