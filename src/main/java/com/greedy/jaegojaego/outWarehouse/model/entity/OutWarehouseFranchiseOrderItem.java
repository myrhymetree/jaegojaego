package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "OutWarehouseFranchiseOrderItem")
@Table(name = "FRANCHISE_ORDER_ITEM")
@IdClass(OutWarehouseFranchiseOrderItemId.class)
public class OutWarehouseFranchiseOrderItem {

    @Id
    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ORDER_NO")
    private OutWarehouseFranchiseOrder franchiseOrderNo;

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OutWarehouseFranchiseOrderableItem itemInfoNo;

    @Column(name = "FRANCHISE_ORDER_ITEM_AMOUNT")
    private int franchiseOrderItemAmount;

    public OutWarehouseFranchiseOrderItem() {}

    public OutWarehouseFranchiseOrderItem(OutWarehouseFranchiseOrder franchiseOrderNo, OutWarehouseFranchiseOrderableItem itemInfoNo, int franchiseOrderItemAmount) {
        this.franchiseOrderNo = franchiseOrderNo;
        this.itemInfoNo = itemInfoNo;
        this.franchiseOrderItemAmount = franchiseOrderItemAmount;
    }

    public OutWarehouseFranchiseOrder getFranchiseOrderNo() {
        return franchiseOrderNo;
    }

    public OutWarehouseFranchiseOrderableItem getItemInfoNo() {
        return itemInfoNo;
    }

    public int getFranchiseOrderItemAmount() {
        return franchiseOrderItemAmount;
    }

    public void setFranchiseOrderNo(OutWarehouseFranchiseOrder franchiseOrderNo) {
        this.franchiseOrderNo = franchiseOrderNo;
    }

    public void setItemInfoNo(OutWarehouseFranchiseOrderableItem itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public void setFranchiseOrderItemAmount(int franchiseOrderItemAmount) {
        this.franchiseOrderItemAmount = franchiseOrderItemAmount;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseOrderItem{" +
                "franchiseOrderNo=" + franchiseOrderNo +
                ", itemInfoNo=" + itemInfoNo +
                ", franchiseOrderItemAmount=" + franchiseOrderItemAmount +
                '}';
    }
}
