package com.greedy.jaegojaego.warehouse.dto;

import com.greedy.jaegojaego.warehouse.entity.WarehouseItemInfo;

public class ItemWarehouseDTO {

    private int itemWarehouseNo;
    private String itemWarehouseDivision;
    private int itemWarehouseAmount;
    private int itemWarehouseRealAmount;
    private WarehouseItemInfo itemInfoNo;
    private WarehouseDTO inWarehouseNo;
    private int outWarehouseNo;
    private String itemWarehouseQualityStatus;

    public ItemWarehouseDTO() {}

    public ItemWarehouseDTO(int itemWarehouseNo, String itemWarehouseDivision, int itemWarehouseAmount, int itemWarehouseRealAmount, WarehouseItemInfo itemInfoNo, WarehouseDTO inWarehouseNo, int outWarehouseNo, String itemWarehouseQualityStatus) {
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

    public WarehouseDTO getInWarehouseNo() {
        return inWarehouseNo;
    }

    public void setInWarehouseNo(WarehouseDTO inWarehouseNo) {
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
        return "ItemWarehouseDTO{" +
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
