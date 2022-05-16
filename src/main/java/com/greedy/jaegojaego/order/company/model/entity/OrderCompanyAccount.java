package com.greedy.jaegojaego.order.company.model.entity;

import com.greedy.jaegojaego.order.department.model.entity.OrderDepartment;
import lombok.*;

import javax.persistence.*;

@Entity(name = "orderCompanyAccount")
@Table(name = "COMPANY_ACCOUNT")
public class OrderCompanyAccount {

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
    private OrderDepartment orderDepartment;

    @Column(name = "OFFICE_PHONE_NUMBER")
    private String officePhoneNumber;

    @Column(name = "COMPANY_ADDESS")
    private String companyAddress;

    public OrderCompanyAccount() {
    }

    public OrderCompanyAccount(int memberNo, String memberName, String email, String cellphone, OrderDepartment orderDepartment, String officePhoneNumber, String companyAddress) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.email = email;
        this.cellphone = cellphone;
        this.orderDepartment = orderDepartment;
        this.officePhoneNumber = officePhoneNumber;
        this.companyAddress = companyAddress;
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

    public OrderDepartment getOrderDepartment() {
        return orderDepartment;
    }

    public void setOrderDepartment(OrderDepartment orderDepartment) {
        this.orderDepartment = orderDepartment;
    }

    public String getOfficePhoneNumber() {
        return officePhoneNumber;
    }

    public void setOfficePhoneNumber(String officePhoneNumber) {
        this.officePhoneNumber = officePhoneNumber;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Override
    public String toString() {
        return "OrderCompanyAccount{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", orderDepartment=" + orderDepartment +
                ", officePhoneNumber='" + officePhoneNumber + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                '}';
    }
}
