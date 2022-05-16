package com.greedy.jaegojaego.warehouse.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@EqualsAndHashCode
@DynamicUpdate
@Entity(name = "warehouseItemAmount")
@Table(name = "ITEM_AMOUNT")
public class WarehouseItemAmount {

    @Id
    @Column(name = "ITEM_INFO_NO")
    private Integer warehouseItemInfoNo;

    @OneToOne(mappedBy = "warehouseItemAmount")
    private WarehouseItemInfo warehouseItemInfo;

    @Column(name = "ITEM_INFO_TOTAL_AMOUNT")
    private int warehouseItemAmount;

    public WarehouseItemAmount() {}

    public WarehouseItemAmount(Integer warehouseItemInfoNo, WarehouseItemInfo warehouseItemInfo, int warehouseItemAmount) {
        this.warehouseItemInfoNo = warehouseItemInfoNo;
        this.warehouseItemInfo = warehouseItemInfo;
        this.warehouseItemAmount = warehouseItemAmount;
    }

    public Integer getWarehouseItemInfoNo() {
        return warehouseItemInfoNo;
    }

    public void setWarehouseItemInfoNo(Integer warehouseItemInfoNo) {
        this.warehouseItemInfoNo = warehouseItemInfoNo;
    }

    public WarehouseItemInfo getWarehouseItemInfo() {
        return warehouseItemInfo;
    }

    public void setWarehouseItemInfo(WarehouseItemInfo warehouseItemInfo) {
        this.warehouseItemInfo = warehouseItemInfo;
    }

    public int getWarehouseItemAmount() {
        return warehouseItemAmount;
    }

    public void setWarehouseItemAmount(int warehouseItemAmount) {
        this.warehouseItemAmount = warehouseItemAmount;
    }

    @Override
    public String toString() {
        return "WarehouseItemAmount{" +
                "warehouseItemInfoNo=" + warehouseItemInfoNo +
                ", warehouseItemInfo=" + warehouseItemInfo +
                ", warehouseItemAmount=" + warehouseItemAmount +
                '}';
    }
}
