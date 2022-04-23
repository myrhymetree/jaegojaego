package com.greedy.jaegojaego.warehouse.dto;

import java.sql.Date;

public class WarehouseStatusHistoryDTO {

    private String warehouseStatusName;
    private java.sql.Date warehouseHistoryDate;
    private int warehouseStatusAmount;
    private int warehouseStatusHistoryNo;
    private WarehouseDTO warehouseNo;

    public WarehouseStatusHistoryDTO() {}

    public WarehouseStatusHistoryDTO(String warehouseStatusName, Date warehouseHistoryDate, int warehouseStatusAmount, int warehouseStatusHistoryNo, WarehouseDTO warehouseNo) {
        this.warehouseStatusName = warehouseStatusName;
        this.warehouseHistoryDate = warehouseHistoryDate;
        this.warehouseStatusAmount = warehouseStatusAmount;
        this.warehouseStatusHistoryNo = warehouseStatusHistoryNo;
        this.warehouseNo = warehouseNo;
    }

    public String getWarehouseStatusName() {
        return warehouseStatusName;
    }

    public void setWarehouseStatusName(String warehouseStatusName) {
        this.warehouseStatusName = warehouseStatusName;
    }

    public Date getWarehouseHistoryDate() {
        return warehouseHistoryDate;
    }

    public void setWarehouseHistoryDate(Date warehouseHistoryDate) {
        this.warehouseHistoryDate = warehouseHistoryDate;
    }

    public int getWarehouseStatusAmount() {
        return warehouseStatusAmount;
    }

    public void setWarehouseStatusAmount(int warehouseStatusAmount) {
        this.warehouseStatusAmount = warehouseStatusAmount;
    }

    public int getWarehouseStatusHistoryNo() {
        return warehouseStatusHistoryNo;
    }

    public void setWarehouseStatusHistoryNo(int warehouseStatusHistoryNo) {
        this.warehouseStatusHistoryNo = warehouseStatusHistoryNo;
    }

    public WarehouseDTO getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(WarehouseDTO warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    @Override
    public String toString() {
        return "WarehouseStatusHistoryDTO{" +
                "warehouseStatusName='" + warehouseStatusName + '\'' +
                ", warehouseHistoryDate=" + warehouseHistoryDate +
                ", warehouseStatusAmount=" + warehouseStatusAmount +
                ", warehouseStatusHistoryNo=" + warehouseStatusHistoryNo +
                ", warehouseNo=" + warehouseNo +
                '}';
    }
}
