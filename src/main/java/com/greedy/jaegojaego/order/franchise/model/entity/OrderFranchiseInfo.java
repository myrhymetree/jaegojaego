package com.greedy.jaegojaego.order.franchise.model.entity;

import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "orderFranchiseInfo")
@Table(name = "FRANCHISE_INFO")
public class OrderFranchiseInfo implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private Member member;

    @Column(name = "FRANCHISE_REPRESENTATIVE_NAME")
    private String franchiseRepresentativeName;

    @Column(name = "FRANCHISE_REPRESENTATIVE_PHONE")
    private String franchiseRepresentativePhone;

    @Column(name = "FRANCHISE_REPRESENTATIVE_EMAIL")
    private String franchiseRepresentativeEmail;

    @Column(name = "FRANCHISE_BRANCH_NAME")
    private String franchiseBranchName;

    @Column(name = "FRANCHISE_BUSINESS_REGISTRATION_NO")
    private String franchiseBusinessRegistartionNo;

    @Column(name = "FRANCHISE_ADDRESS")
    private String franchiseAddress;

    @Column(name = "BANK_ACCOUNT_NO")
    private String bankAccountNo;

    @ManyToOne
    @JoinColumn(name = "HEAD_OFFICE_SUPERVISOR_NO")
    private OrderCompanyAccount headOfficeSupervisor;

    @ManyToOne
    @JoinColumn(name = "HEAD_OFFICE_WRITED_MEMBER_NO")
    private OrderCompanyAccount headOfficeWritedMember;

    @Column(name = "FRANCHISE_PHONE")
    private String franchisePhone;

    public OrderFranchiseInfo() {
    }

    public OrderFranchiseInfo(Member member, String franchiseRepresentativeName, String franchiseRepresentativePhone, String franchiseRepresentativeEmail, String franchiseBranchName, String franchiseBusinessRegistartionNo, String franchiseAddress, String bankAccountNo, OrderCompanyAccount headOfficeSupervisor, OrderCompanyAccount headOfficeWritedMember, String franchisePhone) {
        this.member = member;
        this.franchiseRepresentativeName = franchiseRepresentativeName;
        this.franchiseRepresentativePhone = franchiseRepresentativePhone;
        this.franchiseRepresentativeEmail = franchiseRepresentativeEmail;
        this.franchiseBranchName = franchiseBranchName;
        this.franchiseBusinessRegistartionNo = franchiseBusinessRegistartionNo;
        this.franchiseAddress = franchiseAddress;
        this.bankAccountNo = bankAccountNo;
        this.headOfficeSupervisor = headOfficeSupervisor;
        this.headOfficeWritedMember = headOfficeWritedMember;
        this.franchisePhone = franchisePhone;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public String getFranchiseBusinessRegistartionNo() {
        return franchiseBusinessRegistartionNo;
    }

    public void setFranchiseBusinessRegistartionNo(String franchiseBusinessRegistartionNo) {
        this.franchiseBusinessRegistartionNo = franchiseBusinessRegistartionNo;
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
        return "FranchiseInfo{" +
                "member=" + member +
                ", franchiseRepresentativeName='" + franchiseRepresentativeName + '\'' +
                ", franchiseRepresentativePhone='" + franchiseRepresentativePhone + '\'' +
                ", franchiseRepresentativeEmail='" + franchiseRepresentativeEmail + '\'' +
                ", franchiseBranchName='" + franchiseBranchName + '\'' +
                ", franchiseBusinessRegistartionNo='" + franchiseBusinessRegistartionNo + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                ", bankAccountNo='" + bankAccountNo + '\'' +
                ", headOfficeSupervisor=" + headOfficeSupervisor +
                ", headOfficeWritedMember=" + headOfficeWritedMember +
                ", franchisePhone='" + franchisePhone + '\'' +
                '}';
    }
}
