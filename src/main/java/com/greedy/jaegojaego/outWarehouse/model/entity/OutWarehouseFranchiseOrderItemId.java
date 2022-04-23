package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import java.io.Serializable;

public class OutWarehouseFranchiseOrderItemId implements Serializable {

    private OutWarehouseFranchiseOrder franchiseOrderNo;
    private OutWarehouseFranchiseOrderableItem itemInfoNo;

    public OutWarehouseFranchiseOrderItemId() {}

    public OutWarehouseFranchiseOrderItemId(OutWarehouseFranchiseOrder franchiseOrderNo, OutWarehouseFranchiseOrderableItem itemInfoNo) {
        this.franchiseOrderNo = franchiseOrderNo;
        this.itemInfoNo = itemInfoNo;
    }

    public OutWarehouseFranchiseOrder getFranchiseOrderNo() {
        return franchiseOrderNo;
    }

    public OutWarehouseFranchiseOrderableItem getItemInfoNo() {
        return itemInfoNo;
    }

    public void setFranchiseOrderNo(OutWarehouseFranchiseOrder franchiseOrderNo) {
        this.franchiseOrderNo = franchiseOrderNo;
    }

    public void setItemInfoNo(OutWarehouseFranchiseOrderableItem itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseOrderItemId{" +
                "franchiseOrderNo=" + franchiseOrderNo +
                ", itemInfoNo=" + itemInfoNo +
                '}';
    }
}
