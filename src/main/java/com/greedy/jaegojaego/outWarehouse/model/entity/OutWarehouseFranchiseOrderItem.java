package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "outWarehouseFranchiseOrderItem")
@Table(name = "FRANCHISE_ORDER_ITEM")
public class OutWarehouseFranchiseOrderItem implements Serializable {

    @EmbeddedId
    private OutWarehouseFranchiseOrderItemPk franchiseOrderItemPk;

    @Column(name = "FRANCHISE_ORDER_ITEM_AMOUNT")
    private int franchiseOrderitemAmount;

    public OutWarehouseFranchiseOrderItem() {}

    public OutWarehouseFranchiseOrderItem(OutWarehouseFranchiseOrderItemPk franchiseOrderItemPk, int franchiseOrderitemAmount) {
        this.franchiseOrderItemPk = franchiseOrderItemPk;
        this.franchiseOrderitemAmount = franchiseOrderitemAmount;
    }

    public OutWarehouseFranchiseOrderItemPk getFranchiseOrderItemPk() {
        return franchiseOrderItemPk;
    }

    public void setFranchiseOrderItemPk(OutWarehouseFranchiseOrderItemPk franchiseOrderItemPk) {
        this.franchiseOrderItemPk = franchiseOrderItemPk;
    }

    public int getFranchiseOrderitemAmount() {
        return franchiseOrderitemAmount;
    }

    public void setFranchiseOrderitemAmount(int franchiseOrderitemAmount) {
        this.franchiseOrderitemAmount = franchiseOrderitemAmount;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseOrderItem{" +
                "franchiseOrderItemPk=" + franchiseOrderItemPk +
                ", franchiseOrderitemAmount=" + franchiseOrderitemAmount +
                '}';
    }
}
