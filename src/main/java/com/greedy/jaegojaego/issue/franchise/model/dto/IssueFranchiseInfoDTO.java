package com.greedy.jaegojaego.issue.franchise.model.dto;

import com.greedy.jaegojaego.issue.company.model.dto.IssueCompanyAccountDTO;
import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;

public class IssueFranchiseInfoDTO {

    private Integer franchiseRepresentativeNo;
    private String franchiseRepresentativeName;
    private String franchiseRepresentativePhone;
    private String franchiseRepresentativeEmail;
    private String franchiseBranchName;
    private String franchiseBusinessRegistrationNo;
    private String franchiseAddress;
    private String bankAccountNo;
    private IssueCompanyAccountDTO headOfficeSupervisor;
    private IssueCompanyAccountDTO headOfficeWritedMember;
    private String franchisePhone;

    public IssueFranchiseInfoDTO() {
    }

    public IssueFranchiseInfoDTO(Integer franchiseRepresentativeNo, String franchiseRepresentativeName, String franchiseRepresentativePhone, String franchiseRepresentativeEmail, String franchiseBranchName, String franchiseBusinessRegistrationNo, String franchiseAddress, String bankAccountNo, IssueCompanyAccountDTO headOfficeSupervisor, IssueCompanyAccountDTO headOfficeWritedMember, String franchisePhone) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
        this.franchiseRepresentativeName = franchiseRepresentativeName;
        this.franchiseRepresentativePhone = franchiseRepresentativePhone;
        this.franchiseRepresentativeEmail = franchiseRepresentativeEmail;
        this.franchiseBranchName = franchiseBranchName;
        this.franchiseBusinessRegistrationNo = franchiseBusinessRegistrationNo;
        this.franchiseAddress = franchiseAddress;
        this.bankAccountNo = bankAccountNo;
        this.headOfficeSupervisor = headOfficeSupervisor;
        this.headOfficeWritedMember = headOfficeWritedMember;
        this.franchisePhone = franchisePhone;
    }

    public Integer getFranchiseRepresentativeNo() {
        return franchiseRepresentativeNo;
    }

    public void setFranchiseRepresentativeNo(Integer franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public String getFranchiseRepresentativeName() {
        return franchiseRepresentativeName;
    }

    public void setFranchiseRepresentativeName(String franchiseRepresentativeName) {
        this.franchiseRepresentativeName = franchiseRepresentativeName;
    }

    public String getFranchiseRepresentativePhone() {
        return franchiseRepresentativePhone;
    }

    public void setFranchiseRepresentativePhone(String franchiseRepresentativePhone) {
        this.franchiseRepresentativePhone = franchiseRepresentativePhone;
    }

    public String getFranchiseRepresentativeEmail() {
        return franchiseRepresentativeEmail;
    }

    public void setFranchiseRepresentativeEmail(String franchiseRepresentativeEmail) {
        this.franchiseRepresentativeEmail = franchiseRepresentativeEmail;
    }

    public String getFranchiseBranchName() {
        return franchiseBranchName;
    }

    public void setFranchiseBranchName(String franchiseBranchName) {
        this.franchiseBranchName = franchiseBranchName;
    }

    public String getFranchiseBusinessRegistrationNo() {
        return franchiseBusinessRegistrationNo;
    }

    public void setFranchiseBusinessRegistrationNo(String franchiseBusinessRegistrationNo) {
        this.franchiseBusinessRegistrationNo = franchiseBusinessRegistrationNo;
    }

    public String getFranchiseAddress() {
        return franchiseAddress;
    }

    public void setFranchiseAddress(String franchiseAddress) {
        this.franchiseAddress = franchiseAddress;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public IssueCompanyAccountDTO getHeadOfficeSupervisor() {
        return headOfficeSupervisor;
    }

    public void setHeadOfficeSupervisor(IssueCompanyAccountDTO headOfficeSupervisor) {
        this.headOfficeSupervisor = headOfficeSupervisor;
    }

    public IssueCompanyAccountDTO getHeadOfficeWritedMember() {
        return headOfficeWritedMember;
    }

    public void setHeadOfficeWritedMember(IssueCompanyAccountDTO headOfficeWritedMember) {
        this.headOfficeWritedMember = headOfficeWritedMember;
    }

    public String getFranchisePhone() {
        return franchisePhone;
    }

    public void setFranchisePhone(String franchisePhone) {
        this.franchisePhone = franchisePhone;
    }

    @Override
    public String toString() {
        return "IssueFranchiseInfoDTO{" +
                "franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                ", franchiseRepresentativeName='" + franchiseRepresentativeName + '\'' +
                ", franchiseRepresentativePhone='" + franchiseRepresentativePhone + '\'' +
                ", franchiseRepresentativeEmail='" + franchiseRepresentativeEmail + '\'' +
                ", franchiseBranchName='" + franchiseBranchName + '\'' +
                ", franchiseBusinessRegistrationNo='" + franchiseBusinessRegistrationNo + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                ", bankAccountNo='" + bankAccountNo + '\'' +
                ", headOfficeSupervisor=" + headOfficeSupervisor +
                ", headOfficeWritedMember=" + headOfficeWritedMember +
                ", franchisePhone='" + franchisePhone + '\'' +
                '}';
    }
}
