package com.greedy.jaegojaego.issue.company.model.entity;

import com.greedy.jaegojaego.issue.department.model.entity.IssueDepartment;
import com.greedy.jaegojaego.order.department.model.entity.OrderDepartment;

import javax.persistence.*;

@Entity(name = "issueCompanyAccount")
@Table(name = "COMPANY_ACCOUNT")
public class IssueCompanyAccount {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_EMAIL")
    private String email;

    @Column(name = "MEMBER_CELLPHONE")
    private String cellphone;

    @ManyToOne
    @JoinColumn(name = "MEMBER_DEPARTMENT")
    private IssueDepartment orderDepartment;

    @Column(name = "OFFICE_PHONE_NUMBER")
    private String officePhoneNumber;

    public IssueCompanyAccount() {
    }

    public IssueCompanyAccount(int memberNo, String memberName, String email, String cellphone, IssueDepartment orderDepartment, String officePhoneNumber) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.email = email;
        this.cellphone = cellphone;
        this.orderDepartment = orderDepartment;
        this.officePhoneNumber = officePhoneNumber;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public IssueDepartment getOrderDepartment() {
        return orderDepartment;
    }

    public void setOrderDepartment(IssueDepartment orderDepartment) {
        this.orderDepartment = orderDepartment;
    }

    public String getOfficePhoneNumber() {
        return officePhoneNumber;
    }

    public void setOfficePhoneNumber(String officePhoneNumber) {
        this.officePhoneNumber = officePhoneNumber;
    }

    @Override
    public String toString() {
        return "IssueCompanyAccount{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", orderDepartment=" + orderDepartment +
                ", officePhoneNumber='" + officePhoneNumber + '\'' +
                '}';
    }
}
