package com.greedy.jaegojaego.warehouse.dto;

import java.sql.Date;

public class WarehouseHistoryDTO {

    private String warehouseStatusName;
    private java.sql.Date warehouseHistoryDate;
    private int warehouseDivisionNo;
    private int warehouseStatusAmount;
    private int warehouseStatusHistoryNo;

    public WarehouseHistoryDTO() {}

    public WarehouseHistoryDTO(String warehouseStatusName, Date warehouseHistoryDate, int warehouseDivisionNo, int warehouseStatusAmount, int warehouseStatusHistoryNo) {
        this.warehouseStatusName = warehouseStatusName;
        this.warehouseHistoryDate = warehouseHistoryDate;
        this.warehouseDivisionNo = warehouseDivisionNo;
        this.warehouseStatusAmount = warehouseStatusAmount;
        this.warehouseStatusHistoryNo = warehouseStatusHistoryNo;
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

    public int getWarehouseDivisionNo() {
        return warehouseDivisionNo;
    }

    public void setWarehouseDivisionNo(int warehouseDivisionNo) {
        this.warehouseDivisionNo = warehouseDivisionNo;
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

    @Override
    public String toString() {
        return "WarehouseHistoryDTO{" +
                "warehouseStatusName='" + warehouseStatusName + '\'' +
                ", warehouseHistoryDate=" + warehouseHistoryDate +
                ", warehouseDivisionNo=" + warehouseDivisionNo +
                ", warehouseStatusAmount=" + warehouseStatusAmount +
                ", warehouseStatusHistoryNo=" + warehouseStatusHistoryNo +
                '}';
    }
}
