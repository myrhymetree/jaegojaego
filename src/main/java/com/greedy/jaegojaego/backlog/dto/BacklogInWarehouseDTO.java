package com.greedy.jaegojaego.backlog.dto;

import java.sql.Date;

public class BacklogInWarehouseDTO {
    /* 입고 DTO */
    private int inwarehouseNo;
    private int inwarehouseDivisionItem;    //입고 물품 구분(혹시모르니)
    private BacklogClientDTO clientNo;
    private String inwarehouseWorkingStatusName;
    private Date inwarehouseWorkingFinishedDate; // sql or util ?

    public BacklogInWarehouseDTO() {}

    public BacklogInWarehouseDTO(int inwarehouseNo, int inwarehouseDivisionItem, BacklogClientDTO clientNo, String inwarehouseWorkingStatusName, Date inwarehouseWorkingFinishedDate) {
        this.inwarehouseNo = inwarehouseNo;
        this.inwarehouseDivisionItem = inwarehouseDivisionItem;
        this.clientNo = clientNo;
        this.inwarehouseWorkingStatusName = inwarehouseWorkingStatusName;
        this.inwarehouseWorkingFinishedDate = inwarehouseWorkingFinishedDate;
    }

    public int getInwarehouseNo() {
        return inwarehouseNo;
    }

    public void setInwarehouseNo(int inwarehouseNo) {
        this.inwarehouseNo = inwarehouseNo;
    }

    public int getInwarehouseDivisionItem() {
        return inwarehouseDivisionItem;
    }

    public void setInwarehouseDivisionItem(int inwarehouseDivisionItem) {
        this.inwarehouseDivisionItem = inwarehouseDivisionItem;
    }

    public BacklogClientDTO getClientNo() {
        return clientNo;
    }

    public void setClientNo(BacklogClientDTO clientNo) {
        this.clientNo = clientNo;
    }

    public String getInwarehouseWorkingStatusName() {
        return inwarehouseWorkingStatusName;
    }

    public void setInwarehouseWorkingStatusName(String inwarehouseWorkingStatusName) {
        this.inwarehouseWorkingStatusName = inwarehouseWorkingStatusName;
    }

    public Date getInwarehouseWorkingFinishedDate() {
        return inwarehouseWorkingFinishedDate;
    }

    public void setInwarehouseWorkingFinishedDate(Date inwarehouseWorkingFinishedDate) {
        this.inwarehouseWorkingFinishedDate = inwarehouseWorkingFinishedDate;
    }

    @Override
    public String toString() {
        return "BacklogInWarehouseDTO{" +
                "inwarehouseNo=" + inwarehouseNo +
                ", inwarehouseDivisionItem=" + inwarehouseDivisionItem +
                ", clientNo=" + clientNo +
                ", inwarehouseWorkingStatusName='" + inwarehouseWorkingStatusName + '\'' +
                ", inwarehouseWorkingFinishedDate=" + inwarehouseWorkingFinishedDate +
                '}';
    }
}
