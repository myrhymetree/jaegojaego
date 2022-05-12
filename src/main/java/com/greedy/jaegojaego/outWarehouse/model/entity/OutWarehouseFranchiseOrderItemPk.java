package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class OutWarehouseFranchiseOrderItemPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ORDER_NO")
    private OutWarehouseFranchiseOrder franchiseOrderNo;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OutWarehouseItemInfo itemInfoNo;

    public OutWarehouseFranchiseOrderItemPk() {}

    public OutWarehouseFranchiseOrderItemPk(OutWarehouseFranchiseOrder franchiseOrderNo, OutWarehouseItemInfo itemInfoNo) {
        this.franchiseOrderNo = franchiseOrderNo;
        this.itemInfoNo = itemInfoNo;
    }

    public OutWarehouseFranchiseOrder getFranchiseOrderNo() {
        return franchiseOrderNo;
    }

    public void setFranchiseOrderNo(OutWarehouseFranchiseOrder franchiseOrderNo) {
        this.franchiseOrderNo = franchiseOrderNo;
    }

    public OutWarehouseItemInfo getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(OutWarehouseItemInfo itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseOrderItemPk{" +
                "franchiseOrderNo=" + franchiseOrderNo +
                ", itemInfoNo=" + itemInfoNo +
                '}';
    }
}
