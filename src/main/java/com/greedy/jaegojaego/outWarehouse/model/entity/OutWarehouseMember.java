package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;

@Entity(name = "outWarehouseMember")
@Table(name = "MEMBER")
public class OutWarehouseMember {

    @Id
    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "OFFICE_DIVISION")
    private String officeDivision;

    @Column(name = "MEMBER_DIVISION")
    private String memberDivision;

    public OutWarehouseMember() {}

    public OutWarehouseMember(int memberNo, String officeDivision, String memberDivision) {
        this.memberNo = memberNo;
        this.officeDivision = officeDivision;
        this.memberDivision = memberDivision;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getOfficeDivision() {
        return officeDivision;
    }

    public void setOfficeDivision(String officeDivision) {
        this.officeDivision = officeDivision;
    }

    public String getMemberDivision() {
        return memberDivision;
    }

    public void setMemberDivision(String memberDivision) {
        this.memberDivision = memberDivision;
    }

    @Override
    public String toString() {
        return "OutWarehouseMember{" +
                "memberNo=" + memberNo +
                ", officeDivision='" + officeDivision + '\'' +
                ", memberDivision='" + memberDivision + '\'' +
                '}';
    }
}
