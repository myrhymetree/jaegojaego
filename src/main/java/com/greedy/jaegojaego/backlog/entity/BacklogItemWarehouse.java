package com.greedy.jaegojaego.backlog.entity;

import com.greedy.jaegojaego.backlog.dto.BacklogInWarehouseDTO;
import com.greedy.jaegojaego.backlog.dto.BacklogItemInfoDTO;

import javax.persistence.*;

@Entity(name = "BacklogItemWarehouseEntity")
@Table(name = "ITEM_WAREHOUSE")
public class BacklogItemWarehouse {

    @Id
    @Column(name = "ITEM_WAREHOUSE_NO")
    private int itemWarehouseNo;

    @Column(name = "ITEM_WAREHOUSE_DIVISION")
    private String itemWarehouseDivision;

    @Column(name = "ITEM_WAREHOUSE_AMOUNT")
    private int itemWarehouseAmount;

    @Column(name = "ITEM_WAREHOUSE_REAL_AMOUNT")
    private int itemWarehouseRealAmount;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private BacklogItemInfo itemInfoNo;

    @ManyToOne
    @JoinColumn(name = "IN_WAREHOUSE_NO")
    private BacklogInWarehouse inwarehouseNo;

    public BacklogItemWarehouse() {}

    public BacklogItemWarehouse(int itemWarehouseNo, String itemWarehouseDivision, int itemWarehouseAmount, int itemWarehouseRealAmount, BacklogItemInfo itemInfoNo, BacklogInWarehouse inwarehouseNo) {
        this.itemWarehouseNo = itemWarehouseNo;
        this.itemWarehouseDivision = itemWarehouseDivision;
        this.itemWarehouseAmount = itemWarehouseAmount;
        this.itemWarehouseRealAmount = itemWarehouseRealAmount;
        this.itemInfoNo = itemInfoNo;
        this.inwarehouseNo = inwarehouseNo;
    }

    public int getItemWarehouseNo() {
        return itemWarehouseNo;
    }

    public void setItemWarehouseNo(int itemWarehouseNo) {
        this.itemWarehouseNo = itemWarehouseNo;
    }

    public String getItemWarehouseDivision() {
        return itemWarehouseDivision;
    }

    public void setItemWarehouseDivision(String itemWarehouseDivision) {
        this.itemWarehouseDivision = itemWarehouseDivision;
    }

    public int getItemWarehouseAmount() {
        return itemWarehouseAmount;
    }

    public void setItemWarehouseAmount(int itemWarehouseAmount) {
        this.itemWarehouseAmount = itemWarehouseAmount;
    }

    public int getItemWarehouseRealAmount() {
        return itemWarehouseRealAmount;
    }

    public void setItemWarehouseRealAmount(int itemWarehouseRealAmount) {
        this.itemWarehouseRealAmount = itemWarehouseRealAmount;
    }

    public BacklogItemInfo getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(BacklogItemInfo itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public BacklogInWarehouse getInwarehouseNo() {
        return inwarehouseNo;
    }

    public void setInwarehouseNo(BacklogInWarehouse inwarehouseNo) {
        this.inwarehouseNo = inwarehouseNo;
    }

    @Override
    public String toString() {
        return "BacklogItemWarehouse{" +
                "itemWarehouseNo=" + itemWarehouseNo +
                ", itemWarehouseDivision='" + itemWarehouseDivision + '\'' +
                ", itemWarehouseAmount=" + itemWarehouseAmount +
                ", itemWarehouseRealAmount=" + itemWarehouseRealAmount +
                ", itemInfoNo=" + itemInfoNo +
                ", inwarehouseNo=" + inwarehouseNo +
                '}';
    }
}
