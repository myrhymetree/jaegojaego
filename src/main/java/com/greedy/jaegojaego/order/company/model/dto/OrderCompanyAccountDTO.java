package com.greedy.jaegojaego.order.company.model.dto;

import com.greedy.jaegojaego.order.department.model.entity.OrderDepartment;
import lombok.*;

public class OrderCompanyAccountDTO {

    private int memberNo;
    private String memberName;
    private String email;
    private String cellphone;
    private OrderDepartment orderDepartment;
    private String officePhoneNumber;

    public OrderCompanyAccountDTO() {
    }

    public OrderCompanyAccountDTO(int memberNo, String memberName, String email, String cellphone, OrderDepartment orderDepartment, String officePhoneNumber) {
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

    @Override
    public String toString() {
        return "OrderCompanyAccountDTO{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", orderDepartment=" + orderDepartment +
                ", officePhoneNumber='" + officePhoneNumber + '\'' +
                '}';
    }
}
