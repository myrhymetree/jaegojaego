package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "outWarehouseFranchiseOrder")
@Table(name = "FRANCHISE_ORDER")
public class OutWarehouseFranchiseOrder {

    @Id
    @Column(name = "FRANCHISE_ORDER_NO")
    private int franchiseOrderNo;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private OutWarehouseMember memberNo;

    public OutWarehouseFranchiseOrder() {}

    public OutWarehouseFranchiseOrder(int franchiseOrderNo, OutWarehouseMember memberNo) {
        this.franchiseOrderNo = franchiseOrderNo;
        this.memberNo = memberNo;
    }

    public int getFranchiseOrderNo() {
        return franchiseOrderNo;
    }

    public void setFranchiseOrderNo(int franchiseOrderNo) {
        this.franchiseOrderNo = franchiseOrderNo;
    }

    public OutWarehouseMember getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(OutWarehouseMember memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseOrder{" +
                "franchiseOrderNo=" + franchiseOrderNo +
                ", memberNo=" + memberNo +
                '}';
    }
}
