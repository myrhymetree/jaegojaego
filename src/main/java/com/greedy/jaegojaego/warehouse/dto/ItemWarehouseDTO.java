package com.greedy.jaegojaego.warehouse.dto;

public class ItemWarehouseDTO {

    private int itemWarehouseNo;
    private String itemWarehouseDivision;
    private int itemWarehouseAmount;
    private int itemWarehouseRealAmount;
    private int itemInfoNo;
    private int inWarehouseDivisionNo;
    private int outWarehouseDivisionNo;
    private String itemWarehouseQualityStatus;

    public ItemWarehouseDTO() {}

    public ItemWarehouseDTO(int itemWarehouseNo, String itemWarehouseDivision, int itemWarehouseAmount, int itemWarehouseRealAmount, int itemInfoNo, int inWarehouseDivisionNo, int outWarehouseDivisionNo, String itemWarehouseQualityStatus) {
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
        return "ItemWarehouseDTO{" +
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
