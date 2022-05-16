package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;

@Entity(name = "outWarehouseCompanyAccount")
@Table(name= "COMPANY_ACCOUNT")
public class OutWarehouseCompanyAccount {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    public OutWarehouseCompanyAccount() {}

    public OutWarehouseCompanyAccount(int memberNo, String memberName) {
        this.memberNo = memberNo;
        this.memberName = memberName;
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

    @Override
    public String toString() {
        return "OutWarehouseCompanyAccount{" +
                "memberNo=" + memberNo +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}
