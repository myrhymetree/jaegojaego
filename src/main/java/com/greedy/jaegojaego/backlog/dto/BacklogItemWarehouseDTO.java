package com.greedy.jaegojaego.backlog.dto;

public class BacklogItemWarehouseDTO {
    private int itemWarehouseNo;
    private String itemWarehouseDivision;
    private int itemWarehouseAmount;
    private int itemWarehouseRealAmount;
    private BacklogItemInfoDTO itemInfoNo;
    private BacklogInWarehouseDTO inwarehouseNo;

    public BacklogItemWarehouseDTO() {}

    public BacklogItemWarehouseDTO(int itemWarehouseNo, String itemWarehouseDivision, int itemWarehouseAmount, int itemWarehouseRealAmount, BacklogItemInfoDTO itemInfoNo, BacklogInWarehouseDTO inwarehouseNo) {
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

    public BacklogItemInfoDTO getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(BacklogItemInfoDTO itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public BacklogInWarehouseDTO getInwarehouseNo() {
        return inwarehouseNo;
    }

    public void setInwarehouseNo(BacklogInWarehouseDTO inwarehouseNo) {
        this.inwarehouseNo = inwarehouseNo;
    }

    @Override
    public String toString() {
        return "BacklogItemWarehouseDTO{" +
                "itemWarehouseNo=" + itemWarehouseNo +
                ", itemWarehouseDivision='" + itemWarehouseDivision + '\'' +
                ", itemWarehouseAmount=" + itemWarehouseAmount +
                ", itemWarehouseRealAmount=" + itemWarehouseRealAmount +
                ", itemInfoNo=" + itemInfoNo +
                ", inwarehouseNo=" + inwarehouseNo +
                '}';
    }
}

