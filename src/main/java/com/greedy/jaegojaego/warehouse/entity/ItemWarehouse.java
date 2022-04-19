package com.greedy.jaegojaego.warehouse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ItemWarehouse")
@Table(name = "ITEM_WAREHOUSE")
public class ItemWarehouse {

    @Id
    @Column(name = "ITEM_WAREHOUSE_NO")
    private int itemWarehouseNo;

    @Id
    @Column(name = "ITEM_WAREHOUSE_DIVISION")
    private String itemWarehouseDivision;

    @Id
    @Column(name = "ITEM_WAREHOUSE_AMOUNT")
    private int itemWarehouseAmount;

    @Id
    @Column(name = "ITEM_WAREHOUSE_REAL_AMOUNT")
    private int itemWarehouseRealAmount;

    @Id
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Id
    @Column(name = "IN_WAREHOUSE_DIVISION_NO")
    private int inWarehouseDivisionNo;

    @Id
    @Column(name = "OUT_WAREHOUSE_DIVISION_NO")
    private int outWarehouseDivisionNo;

    @Id
    @Column(name = "ITEM_WAREHOUSE_QUALITY_STATUS")
    private String itemWarehouseQualityStatus;

    public ItemWarehouse() {}

    public ItemWarehouse(int itemWarehouseNo, String itemWarehouseDivision, int itemWarehouseAmount, int itemWarehouseRealAmount, int itemInfoNo, int inWarehouseDivisionNo, int outWarehouseDivisionNo, String itemWarehouseQualityStatus) {
        this.itemWarehouseNo = itemWarehouseNo;
        this.itemWarehouseDivision = itemWarehouseDivision;
        this.itemWarehouseAmount = itemWarehouseAmount;
        this.itemWarehouseRealAmount = itemWarehouseRealAmount;
        this.itemInfoNo = itemInfoNo;
        this.inWarehouseDivisionNo = inWarehouseDivisionNo;
        this.outWarehouseDivisionNo = outWarehouseDivisionNo;
        this.itemWarehouseQualityStatus = itemWarehouseQualityStatus;
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

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public int getInWarehouseDivisionNo() {
        return inWarehouseDivisionNo;
    }

    public void setInWarehouseDivisionNo(int inWarehouseDivisionNo) {
        this.inWarehouseDivisionNo = inWarehouseDivisionNo;
    }

    public int getOutWarehouseDivisionNo() {
        return outWarehouseDivisionNo;
    }

    public void setOutWarehouseDivisionNo(int outWarehouseDivisionNo) {
        this.outWarehouseDivisionNo = outWarehouseDivisionNo;
    }

    public String getItemWarehouseQualityStatus() {
        return itemWarehouseQualityStatus;
    }

    public void setItemWarehouseQualityStatus(String itemWarehouseQualityStatus) {
        this.itemWarehouseQualityStatus = itemWarehouseQualityStatus;
    }

    @Override
    public String toString() {
        return "ItemWarehouse{" +
                "itemWarehouseNo=" + itemWarehouseNo +
                ", itemWarehouseDivision='" + itemWarehouseDivision + '\'' +
                ", itemWarehouseAmount=" + itemWarehouseAmount +
                ", itemWarehouseRealAmount=" + itemWarehouseRealAmount +
                ", itemInfoNo=" + itemInfoNo +
                ", inWarehouseDivisionNo=" + inWarehouseDivisionNo +
                ", outWarehouseDivisionNo=" + outWarehouseDivisionNo +
                ", itemWarehouseQualityStatus='" + itemWarehouseQualityStatus + '\'' +
                '}';
    }
}
