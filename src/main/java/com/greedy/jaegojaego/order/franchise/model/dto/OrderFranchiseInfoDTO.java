package com.greedy.jaegojaego.order.franchise.model.dto;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;

public class OrderFranchiseInfoDTO {

    private Integer franchiseRepresentativeNo;
    private String franchiseRepresentativeName;
    private String franchiseRepresentativePhone;
    private String franchiseRepresentativeEmail;
    private String franchiseBranchName;
    private String franchiseBusinessRegistrationNo;
    private String franchiseAddress;
    private String bankAccountNo;
    private OrderCompanyAccount headOfficeSupervisor;
    private OrderCompanyAccount headOfficeWritedMember;
    private String franchisePhone;

    public OrderFranchiseInfoDTO() {
    }

    public OrderFranchiseInfoDTO(Integer franchiseRepresentativeNo, String franchiseRepresentativeName, String franchiseRepresentativePhone, String franchiseRepresentativeEmail, String franchiseBranchName, String franchiseBusinessRegistrationNo, String franchiseAddress, String bankAccountNo, OrderCompanyAccount headOfficeSupervisor, OrderCompanyAccount headOfficeWritedMember, String franchisePhone) {
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

    public OrderCompanyAccount getHeadOfficeSupervisor() {
        return headOfficeSupervisor;
    }

    public void setHeadOfficeSupervisor(OrderCompanyAccount headOfficeSupervisor) {
        this.headOfficeSupervisor = headOfficeSupervisor;
    }

    public OrderCompanyAccount getHeadOfficeWritedMember() {
        return headOfficeWritedMember;
    }

    public void setHeadOfficeWritedMember(OrderCompanyAccount headOfficeWritedMember) {
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
        return "OrderFranchiseInfoDTO{" +
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
