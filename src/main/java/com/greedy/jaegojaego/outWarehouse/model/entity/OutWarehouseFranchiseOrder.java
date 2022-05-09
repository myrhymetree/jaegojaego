package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "outWarehouseFranchiseOrder")
@Table(name = "FRANCHISE_ORDER")
public class OutWarehouseFranchiseOrder {

    @Id
    @Column(name = "FRANCHISE_ORDER_NO")
    private int franchiseOrderNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_NO")
    private OutWarehouseMember memberNo;

//    @Column(name = "FRANCHISE_ORDER_STATUS")
//    private String franchiseOrderStatus;

    public OutWarehouseFranchiseOrder() {}

    public OutWarehouseFranchiseOrder(int franchiseOrderNo, OutWarehouseMember memberNo, String franchiseOrderStatus) {
        this.franchiseOrderNo = franchiseOrderNo;
        this.memberNo = memberNo;
//        this.franchiseOrderStatus = franchiseOrderStatus;
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

//    public String getFranchiseOrderStatus() {
//        return franchiseOrderStatus;
//    }
//
//    public void setFranchiseOrderStatus(String franchiseOrderStatus) {
//        this.franchiseOrderStatus = franchiseOrderStatus;
//    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseOrder{" +
                "franchiseOrderNo=" + franchiseOrderNo +
                ", memberNo=" + memberNo +
//                ", franchiseOrderStatus='" + franchiseOrderStatus + '\'' +
                '}';
    }
}
