package com.greedy.jaegojaego.warehouse.dto;

import java.sql.Date;

public class WarehouseDTO {

    private int warehouseNo;
    private java.sql.Date warehouseManuDate;
    private int warehouseDivisionNo;
    private int warehouseDivisionItem;
    private int orderHistoryNo;
    private int issueNo;
    private int clientNo;

    public WarehouseDTO() {}

    public WarehouseDTO(int warehouseNo, Date warehouseManuDate, int warehouseDivisionNo, int warehouseDivisionItem, int orderHistoryNo, int issueNo, int clientNo) {
        this.warehouseNo = warehouseNo;
        this.warehouseManuDate = warehouseManuDate;
        this.warehouseDivisionNo = warehouseDivisionNo;
        this.warehouseDivisionItem = warehouseDivisionItem;
        this.orderHistoryNo = orderHistoryNo;
        this.issueNo = issueNo;
        this.clientNo = clientNo;
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

    public int getWarehouseDivisionNo() {
        return warehouseDivisionNo;
    }

    public void setWarehouseDivisionNo(int warehouseDivisionNo) {
        this.warehouseDivisionNo = warehouseDivisionNo;
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

    @Override
    public String toString() {
        return "WarehouseDTO{" +
                "warehouseNo=" + warehouseNo +
                ", warehouseManuDate=" + warehouseManuDate +
                ", warehouseDivisionNo=" + warehouseDivisionNo +
                ", warehouseDivisionItem=" + warehouseDivisionItem +
                ", orderHistoryNo=" + orderHistoryNo +
                ", issueNo=" + issueNo +
                ", clientNo=" + clientNo +
                '}';
    }
}
