package com.greedy.jaegojaego.issue.franchise.model.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity(name = "issueFranchiseAccount")
@Table(name = "FRANCHISE_ACCOUNT")
@EqualsAndHashCode
public class IssueFranchiseAccount {

    @Id
    @Column(name = "FRANCHISE_MANAGER_NO")
    private Integer franchiseManagerNo;

    @Column(name = "MANAGER_NAME")
    private String managerName;

    @Column(name = "MANAGER_PHONE")
    private String managerPhone;

    @Column(name = "MANAGER_EMAIL")
    private String managerEmail;

    @ManyToOne
    @JoinColumn(name = "REPRESENTATIVE_NO")
    private IssueFranchiseInfo franchiseInfo;

    public IssueFranchiseAccount() {
    }

    public IssueFranchiseAccount(Integer franchiseManagerNo, String managerName, String managerPhone, String managerEmail, IssueFranchiseInfo franchiseInfo) {
        this.franchiseManagerNo = franchiseManagerNo;
        this.managerName = managerName;
        this.managerPhone = managerPhone;
        this.managerEmail = managerEmail;
        this.franchiseInfo = franchiseInfo;
    }

    public Integer getFranchiseManagerNo() {
        return franchiseManagerNo;
    }

    public void setFranchiseManagerNo(Integer franchiseManagerNo) {
        this.franchiseManagerNo = franchiseManagerNo;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public IssueFranchiseInfo getFranchiseInfo() {
        return franchiseInfo;
    }

    public void setFranchiseInfo(IssueFranchiseInfo franchiseInfo) {
        this.franchiseInfo = franchiseInfo;
    }

    @Override
    public String toString() {
        return "OrderFranchiseAccount{" +
                "franchiseManagerNo=" + franchiseManagerNo +
                ", managerName='" + managerName + '\'' +
                ", managerPhone='" + managerPhone + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", franchiseInfo=" + franchiseInfo +
                '}';
    }
}
