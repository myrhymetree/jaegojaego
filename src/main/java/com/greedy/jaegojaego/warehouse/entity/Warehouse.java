package com.greedy.jaegojaego.warehouse.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "warehouse")
@Table(name = "IN_WAREHOUSE")
//@SequenceGenerator(
//        name = "IN_WAREHOUSE_SEQ_GENERATOR",
//        sequenceName = "IN_WAREHOUSE_NO",
//        initialValue = 1,
//        allocationSize = 1
//)
public class Warehouse {

    @Id
    @Column(name = "IN_WAREHOUSE_NO")
    private int warehouseNo;

    @Column(name = "IN_WAREHOUSE_MANUFACTURE_DATE")
    private java.sql.Date warehouseManuDate;

//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "IN_WAREHOUSE_SEQ_GENERATOR"
//    )
//    @Column(name = "IN_WAREHOUSE_DIVISION_NO")
//    private int warehouseDivisionNo;

    @Column(name = "IN_WAREHOUSE_DIVISION_ITEM")
    private int warehouseDivisionItem;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private WarehouseCompanyOrderHistory orderHistoryNo;

    @Column(name = "FRANCHISE_ISSUE_NO")
    private int issueNo;

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private WarehouseClient clientNo;

    @OneToMany
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private List<WarehouseCompanyOrderItem> companyOrderItemList;

    @OneToMany
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private List<WarehouseOrderApplication> orderApplicationList;

    @OneToMany
    @JoinColumn(name = "IN_WAREHOUSE_NO")
    private List<WarehouseStatusHistory> warehouseStatusHistory;

    @Column(name = "IN_WAREHOUSE_WORKING_STATUS_NAME")
    private String warehouseWorkingName;

    @Column(name = "IN_WAREHOUSE_WORKING_FINISHED_DATE")
    private java.sql.Date warehouseWorkingDate;

    public Warehouse() {}

    public Warehouse(int warehouseNo, Date warehouseManuDate, int warehouseDivisionItem, WarehouseCompanyOrderHistory orderHistoryNo, int issueNo, WarehouseClient clientNo, List<WarehouseCompanyOrderItem> companyOrderItemList, List<WarehouseOrderApplication> orderApplicationList, List<WarehouseStatusHistory> warehouseStatusHistory, String warehouseWorkingName, Date warehouseWorkingDate) {
        this.warehouseNo = warehouseNo;
        this.warehouseManuDate = warehouseManuDate;
        this.warehouseDivisionItem = warehouseDivisionItem;
        this.orderHistoryNo = orderHistoryNo;
        this.issueNo = issueNo;
        this.clientNo = clientNo;
        this.companyOrderItemList = companyOrderItemList;
        this.orderApplicationList = orderApplicationList;
        this.warehouseStatusHistory = warehouseStatusHistory;
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

    public WarehouseCompanyOrderHistory getOrderHistoryNo() {
        return orderHistoryNo;
    }

    public void setOrderHistoryNo(WarehouseCompanyOrderHistory orderHistoryNo) {
        this.orderHistoryNo = orderHistoryNo;
    }

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }

    public WarehouseClient getClientNo() {
        return clientNo;
    }

    public void setClientNo(WarehouseClient clientNo) {
        this.clientNo = clientNo;
    }

    public List<WarehouseCompanyOrderItem> getCompanyOrderItemList() {
        return companyOrderItemList;
    }

    public void setCompanyOrderItemList(List<WarehouseCompanyOrderItem> companyOrderItemList) {
        this.companyOrderItemList = companyOrderItemList;
    }

    public List<WarehouseOrderApplication> getOrderApplicationList() {
        return orderApplicationList;
    }

    public void setOrderApplicationList(List<WarehouseOrderApplication> orderApplicationList) {
        this.orderApplicationList = orderApplicationList;
    }

    public List<WarehouseStatusHistory> getWarehouseStatusHistory() {
        return warehouseStatusHistory;
    }

    public void setWarehouseStatusHistory(List<WarehouseStatusHistory> warehouseStatusHistory) {
        this.warehouseStatusHistory = warehouseStatusHistory;
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
        return "Warehouse{" +
                "warehouseNo=" + warehouseNo +
                ", warehouseManuDate=" + warehouseManuDate +
                ", warehouseDivisionItem=" + warehouseDivisionItem +
                ", orderHistoryNo=" + orderHistoryNo +
                ", issueNo=" + issueNo +
                ", clientNo=" + clientNo +
                ", companyOrderItemList=" + companyOrderItemList +
                ", orderApplicationList=" + orderApplicationList +
                ", warehouseStatusHistory=" + warehouseStatusHistory +
                ", warehouseWorkingName='" + warehouseWorkingName + '\'' +
                ", warehouseWorkingDate=" + warehouseWorkingDate +
                '}';
    }
}
