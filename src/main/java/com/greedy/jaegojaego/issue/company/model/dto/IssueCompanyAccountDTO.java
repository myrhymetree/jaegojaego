package com.greedy.jaegojaego.issue.company.model.dto;

import com.greedy.jaegojaego.issue.department.model.dto.IssueDepartmentDTO;
import com.greedy.jaegojaego.order.department.model.entity.OrderDepartment;

public class IssueCompanyAccountDTO {

    private int memberNo;
    private String memberName;
    private String email;
    private String cellphone;
    private IssueDepartmentDTO Department;
    private String PhoneNumber;

    public IssueCompanyAccountDTO() {
    }

    public IssueCompanyAccountDTO(int memberNo, String memberName, String email, String cellphone, IssueDepartmentDTO department, String phoneNumber) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.email = email;
        this.cellphone = cellphone;
        Department = department;
        PhoneNumber = phoneNumber;
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

    public IssueDepartmentDTO getDepartment() {
        return Department;
    }

    public void setDepartment(IssueDepartmentDTO department) {
        Department = department;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "IssueCompanyAccountDTO{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", Department=" + Department +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}
