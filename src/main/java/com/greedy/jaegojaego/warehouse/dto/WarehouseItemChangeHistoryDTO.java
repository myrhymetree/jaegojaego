package com.greedy.jaegojaego.warehouse.dto;

public class WarehouseItemChangeHistoryDTO {

    private int itemChangeHistoryNo;
    private WarehouseItemInfoDTO itemInfoNo;
    private int itemChangeDivision;
    private int itemChangeAmount;
    private Integer itemDecrementReasonNo;
    private String outWarehouseDivisionNo;
    private WarehouseDTO warehouseNo;
    private String warehouseStatus;

    public WarehouseItemChangeHistoryDTO() {}

    public WarehouseItemChangeHistoryDTO(int itemChangeHistoryNo, WarehouseItemInfoDTO itemInfoNo, int itemChangeDivision, int itemChangeAmount, Integer itemDecrementReasonNo, String outWarehouseDivisionNo, WarehouseDTO warehouseNo, String warehouseStatus) {
        this.itemChangeHistoryNo = itemChangeHistoryNo;
        this.itemInfoNo = itemInfoNo;
        this.itemChangeDivision = itemChangeDivision;
        this.itemChangeAmount = itemChangeAmount;
        this.itemDecrementReasonNo = itemDecrementReasonNo;
        this.outWarehouseDivisionNo = outWarehouseDivisionNo;
        this.warehouseNo = warehouseNo;
        this.warehouseStatus = warehouseStatus;
    }

    public int getItemChangeHistoryNo() {
        return itemChangeHistoryNo;
    }

    public void setItemChangeHistoryNo(int itemChangeHistoryNo) {
        this.itemChangeHistoryNo = itemChangeHistoryNo;
    }

    public WarehouseItemInfoDTO getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(WarehouseItemInfoDTO itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public int getItemChangeDivision() {
        return itemChangeDivision;
    }

    public void setItemChangeDivision(int itemChangeDivision) {
        this.itemChangeDivision = itemChangeDivision;
    }

    public int getItemChangeAmount() {
        return itemChangeAmount;
    }

    public void setItemChangeAmount(int itemChangeAmount) {
        this.itemChangeAmount = itemChangeAmount;
    }

    public Integer getItemDecrementReasonNo() {
        return itemDecrementReasonNo;
    }

    public void setItemDecrementReasonNo(Integer itemDecrementReasonNo) {
        this.itemDecrementReasonNo = itemDecrementReasonNo;
    }

    public String getOutWarehouseDivisionNo() {
        return outWarehouseDivisionNo;
    }

    public void setOutWarehouseDivisionNo(String outWarehouseDivisionNo) {
        this.outWarehouseDivisionNo = outWarehouseDivisionNo;
    }

    public WarehouseDTO getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(WarehouseDTO warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public String getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(String warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    @Override
    public String toString() {
        return "WarehouseItemChangeHistoryDTO{" +
                "itemChangeHistoryNo=" + itemChangeHistoryNo +
                ", itemInfoNo=" + itemInfoNo +
                ", itemChangeDivision=" + itemChangeDivision +
                ", itemChangeAmount=" + itemChangeAmount +
                ", itemDecrementReasonNo=" + itemDecrementReasonNo +
                ", outWarehouseDivisionNo='" + outWarehouseDivisionNo + '\'' +
                ", warehouseNo=" + warehouseNo +
                ", warehouseStatus='" + warehouseStatus + '\'' +
                '}';
    }
}
