package com.greedy.jaegojaego.warehouse.dto;

import com.greedy.jaegojaego.warehouse.entity.ItemWarehouse;
import com.greedy.jaegojaego.warehouse.entity.WarehouseCompanyOrderHistory;
import com.greedy.jaegojaego.warehouse.entity.WarehouseStatusHistory;

import java.sql.Date;

public class WarehouseDTO {

    private int warehouseNo;
    private java.sql.Date warehouseManuDate;
//    private int warehouseDivisionNo;
    private int warehouseDivisionItem;
    private WarehouseCompanyOrderHistory orderHistoryNo;
    private Integer issueNo;                                    //추후 타입 수정 예정!!
    private WarehouseClientDTO clientNo;
    private String warehouseWorkingName;
    private java.sql.Date warehouseWorkingDate;
//    private ItemWarehouse warehouseItemWarehouse;
//    private WarehouseStatusHistory warehouseStatusHistory;

    public WarehouseDTO() {}

    public WarehouseDTO(int warehouseNo, Date warehouseManuDate, int warehouseDivisionItem, WarehouseCompanyOrderHistory orderHistoryNo, Integer issueNo, WarehouseClientDTO clientNo, String warehouseWorkingName, Date warehouseWorkingDate) {
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

    public WarehouseCompanyOrderHistory getOrderHistoryNo() {
        return orderHistoryNo;
    }

    public void setOrderHistoryNo(WarehouseCompanyOrderHistory orderHistoryNo) {
        this.orderHistoryNo = orderHistoryNo;
    }

    public Integer getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(Integer issueNo) {
        this.issueNo = issueNo;
    }

    public WarehouseClientDTO getClientNo() {
        return clientNo;
    }

    public void setClientNo(WarehouseClientDTO clientNo) {
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
        return "WarehouseDTO{" +
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
