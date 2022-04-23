package com.greedy.jaegojaego.warehouse.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "itemWarehouse")
@Table(name = "ITEM_WAREHOUSE")
public class ItemWarehouse implements Serializable {

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
    private WarehouseItemInfo itemInfoNo;

    @ManyToOne
    @JoinColumn(name = "IN_WAREHOUSE_NO")
    private Warehouse inWarehouseNo;

    @Column(name = "OUT_WAREHOUSE_NO")
    private int outWarehouseNo;

    @Column(name = "ITEM_WAREHOUSE_QUALITY_STATUS")
    private String itemWarehouseQualityStatus;

    public ItemWarehouse() {}

    public ItemWarehouse(int itemWarehouseNo, String itemWarehouseDivision, int itemWarehouseAmount, int itemWarehouseRealAmount, WarehouseItemInfo itemInfoNo, Warehouse inWarehouseNo, int outWarehouseNo, String itemWarehouseQualityStatus) {
        this.itemWarehouseNo = itemWarehouseNo;
        this.itemWarehouseDivision = itemWarehouseDivision;
        this.itemWarehouseAmount = itemWarehouseAmount;
        this.itemWarehouseRealAmount = itemWarehouseRealAmount;
        this.itemInfoNo = itemInfoNo;
        this.inWarehouseNo = inWarehouseNo;
        this.outWarehouseNo = outWarehouseNo;
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

    public WarehouseItemInfo getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(WarehouseItemInfo itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public Warehouse getInWarehouseNo() {
        return inWarehouseNo;
    }

    public void setInWarehouseNo(Warehouse inWarehouseNo) {
        this.inWarehouseNo = inWarehouseNo;
    }

    public int getOutWarehouseNo() {
        return outWarehouseNo;
    }

    public void setOutWarehouseNo(int outWarehouseNo) {
        this.outWarehouseNo = outWarehouseNo;
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
                ", inWarehouseNo=" + inWarehouseNo +
                ", outWarehouseNo=" + outWarehouseNo +
                ", itemWarehouseQualityStatus='" + itemWarehouseQualityStatus + '\'' +
                '}';
    }
}
