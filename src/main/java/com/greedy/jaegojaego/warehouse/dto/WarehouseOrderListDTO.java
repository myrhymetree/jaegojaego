package com.greedy.jaegojaego.warehouse.dto;

import com.greedy.jaegojaego.warehouse.entity.WarehouseCompanyOrderHistory;

import java.sql.Date;

public class WarehouseOrderListDTO {

    private int warehouseNo;
    private java.sql.Date warehouseManuDate;
    private int warehouseDivisionItem;
    private int orderHistoryNo;
    private int issueNo;
    private int clientNo;
    private String warehouseWorkingName;
    private java.sql.Date warehouseWorkingDate;

    public WarehouseOrderListDTO() {}

    public WarehouseOrderListDTO(int warehouseNo, Date warehouseManuDate, int warehouseDivisionItem, int orderHistoryNo, int issueNo, int clientNo, String warehouseWorkingName, Date warehouseWorkingDate) {
        this.warehouseNo = warehouseNo;
        this.warehouseManuDate = warehouseManuDate;
        this.warehouseDivisionItem = warehouseDivisionItem;
        this.orderHistoryNo = orderHistoryNo;
        this.issueNo = issueNo;
        this.clientNo = clientNo;
        this.warehouseWorkingName = warehouseWorkingName;
        this.warehouseWorkingDate = warehouseWorkingDate;
    }

    public int getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(int warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public Date getWarehouseManuDate() {
        return warehouseManuDate;
    }

    public void setWarehouseManuDate(Date warehouseManuDate) {
        this.warehouseManuDate = warehouseManuDate;
    }

    public int getWarehouseDivisionItem() {
        return warehouseDivisionItem;
    }

    public void setWarehouseDivisionItem(int warehouseDivisionItem) {
        this.warehouseDivisionItem = warehouseDivisionItem;
    }

    public int getOrderHistoryNo() {
        return orderHistoryNo;
    }

    public void setOrderHistoryNo(int orderHistoryNo) {
        this.orderHistoryNo = orderHistoryNo;
    }

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public String getWarehouseWorkingName() {
        return warehouseWorkingName;
    }

    public void setWarehouseWorkingName(String warehouseWorkingName) {
        this.warehouseWorkingName = warehouseWorkingName;
    }

    public Date getWarehouseWorkingDate() {
        return warehouseWorkingDate;
    }

    public void setWarehouseWorkingDate(Date warehouseWorkingDate) {
        this.warehouseWorkingDate = warehouseWorkingDate;
    }

    @Override
    public String toString() {
        return "WarehouseOrderListDTO{" +
                "warehouseNo=" + warehouseNo +
                ", warehouseManuDate=" + warehouseManuDate +
                ", warehouseDivisionItem=" + warehouseDivisionItem +
                ", orderHistoryNo=" + orderHistoryNo +
                ", issueNo=" + issueNo +
                ", clientNo=" + clientNo +
                ", warehouseWorkingName='" + warehouseWorkingName + '\'' +
                ", warehouseWorkingDate=" + warehouseWorkingDate +
                '}';
    }
}
