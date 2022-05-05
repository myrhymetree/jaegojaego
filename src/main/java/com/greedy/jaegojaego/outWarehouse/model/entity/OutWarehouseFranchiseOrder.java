package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "outWarehouseFranchiseOrder")
@Table(name = "FRANCHISE_ORDER")
public class OutWarehouseFranchiseOrder {

    @Id
    @Column(name = "FRANCHISE_ORDER_NO")
    private int franchiseOrderNo;

    @Column(name = "FRANCHISE_ORDER_STATUS")
    private String franchiseOrderStatus;

    @Column(name = "FRANCHISE_ORDER_STATUS_DATE")
    private Date franchiseOrderStatusDate;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private OutWarehouseMember memberNo;

    public OutWarehouseFranchiseOrder() {}

    public OutWarehouseFranchiseOrder(int franchiseOrderNo, String franchiseOrderStatus, Date franchiseOrderStatusDate) {
        this.franchiseOrderNo = franchiseOrderNo;
        this.franchiseOrderStatus = franchiseOrderStatus;
        this.franchiseOrderStatusDate = franchiseOrderStatusDate;
    }

    public int getFranchiseOrderNo() {
        return franchiseOrderNo;
    }

    public void setFranchiseOrderNo(int franchiseOrderNo) {
        this.franchiseOrderNo = franchiseOrderNo;
    }

    public String getFranchiseOrderStatus() {
        return franchiseOrderStatus;
    }

    public void setFranchiseOrderStatus(String franchiseOrderStatus) {
        this.franchiseOrderStatus = franchiseOrderStatus;
    }

    public Date getFranchiseOrderStatusDate() {
        return franchiseOrderStatusDate;
    }

    public void setFranchiseOrderStatusDate(Date franchiseOrderStatusDate) {
        this.franchiseOrderStatusDate = franchiseOrderStatusDate;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseOrder{" +
                "franchiseOrderNo=" + franchiseOrderNo +
                ", franchiseOrderStatus='" + franchiseOrderStatus + '\'' +
                ", franchiseOrderStatusDate=" + franchiseOrderStatusDate +
                '}';
    }
}
