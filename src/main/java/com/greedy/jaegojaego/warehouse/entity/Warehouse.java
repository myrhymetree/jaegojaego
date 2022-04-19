package com.greedy.jaegojaego.warehouse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity(name = "Warehouse")
@Table(name = "IN_WAREHOUSE")
public class Warehouse {

    @Id
    @Column(name = "IN_WAREHOUSE_NO")
    private int warehouseNo;

    @Column(name = "IN_WAREHOUSE_MANUFACTURE_DATE")
    private java.sql.Date warehouseManuDate;

    @Column(name = "IN_WAREHOUSE_DIVISION_NO")
    private int warehouseDivisionNo;

    @Column(name = "IN_WAREHOUSE_DIVISION_ITEM")
    private int warehouseDivisionItem;

    @Column(name = "COMPANY_ORDER_HISTORY_NO")
    private int orderHistoryNo;

    @Column(name = "FRANCHISE_ISSUE_NO")
    private int issueNo;

    @Column(name = "CLIENT_NO")
    private int clientNo;

    public Warehouse() {}

    public Warehouse(int warehouseNo, Date warehouseManuDate, int warehouseDivisionNo, int warehouseDivisionItem, int orderHistoryNo, int issueNo, int clientNo) {
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
        return "Warehouse{" +
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
