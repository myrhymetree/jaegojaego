package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class OutWarehouseItemAmountPk implements Serializable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_INFO_NO")
    private OutWarehouseItemInfo itemInfoNo;

    public OutWarehouseItemAmountPk() {}

    public OutWarehouseItemAmountPk(OutWarehouseItemInfo itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public OutWarehouseItemInfo getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(OutWarehouseItemInfo itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseItemAmountPk{" +
                "itemInfoNo=" + itemInfoNo +
                '}';
    }
}
