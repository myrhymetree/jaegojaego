package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "outWarehouseitemAmount")
@Table(name = "ITEM_AMOUNT")
public class OutWarehouseItemAmount implements Serializable {

    @EmbeddedId
    private OutWarehouseItemAmountPk itemInfoNo;

    @Column(name = "ITEM_INFO_TOTAL_AMOUNT")
    private int itemTotalAmount;

    public OutWarehouseItemAmount() {}

    public OutWarehouseItemAmount(OutWarehouseItemAmountPk itemInfoNo, int itemTotalAmount) {
        this.itemInfoNo = itemInfoNo;
        this.itemTotalAmount = itemTotalAmount;
    }

    public OutWarehouseItemAmountPk getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(OutWarehouseItemAmountPk itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public int getItemTotalAmount() {
        return itemTotalAmount;
    }

    public void setItemTotalAmount(int itemTotalAmount) {
        this.itemTotalAmount = itemTotalAmount;
    }

    @Override
    public String toString() {
        return "OutWarehouseItemAmount{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemTotalAmount=" + itemTotalAmount +
                '}';
    }
}
