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

    @Column(name = "FRANCHISE_ORDER_OUT_YN")
    private String franchiseOrderOutYn;

    public OutWarehouseFranchiseOrder() {}

    public OutWarehouseFranchiseOrder(int franchiseOrderNo, OutWarehouseMember memberNo, String franchiseOrderOutYn) {
        this.franchiseOrderNo = franchiseOrderNo;
        this.memberNo = memberNo;
        this.franchiseOrderOutYn = franchiseOrderOutYn;
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

    public String getFranchiseOrderOutYn() {
        return franchiseOrderOutYn;
    }

    public void setFranchiseOrderOutYn(String franchiseOrderOutYn) {
        this.franchiseOrderOutYn = franchiseOrderOutYn;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseOrder{" +
                "franchiseOrderNo=" + franchiseOrderNo +
                ", memberNo=" + memberNo +
                ", franchiseOrderOutYn='" + franchiseOrderOutYn + '\'' +
                '}';
    }
}
