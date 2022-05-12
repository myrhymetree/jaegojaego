package com.greedy.jaegojaego.outWarehouse.model.dto;

import java.sql.Date;

public class OutWarehouseListDTO {

    private int outWarehouseNo;
    private String franchiseName;
    private String franchiseAddress;
    private String outWarehouseWorkingStatusName;
    private Date outWarehouseWorkingFinishedDate;
    private int outWarehouseTotalOutItemAmount;

    public OutWarehouseListDTO() {}

    public OutWarehouseListDTO(int outWarehouseNo, String franchiseName, String franchiseAddress, String outWarehouseWorkingStatusName, Date outWarehouseWorkingFinishedDate, int outWarehouseTotalOutItemAmount) {
        this.outWarehouseNo = outWarehouseNo;
        this.franchiseName = franchiseName;
        this.franchiseAddress = franchiseAddress;
        this.outWarehouseWorkingStatusName = outWarehouseWorkingStatusName;
        this.outWarehouseWorkingFinishedDate = outWarehouseWorkingFinishedDate;
        this.outWarehouseTotalOutItemAmount = outWarehouseTotalOutItemAmount;
    }

    public int getOutWarehouseNo() {
        return outWarehouseNo;
    }

    public String getFranchiseName() {
        return franchiseName;
    }

    public String getFranchiseAddress() {
        return franchiseAddress;
    }

    public String getOutWarehouseWorkingStatusName() {
        return outWarehouseWorkingStatusName;
    }

    public Date getOutWarehouseWorkingFinishedDate() {
        return outWarehouseWorkingFinishedDate;
    }

    public int getOutWarehouseTotalOutItemAmount() {
        return outWarehouseTotalOutItemAmount;
    }

    public void setOutWarehouseNo(int outWarehouseNo) {
        this.outWarehouseNo = outWarehouseNo;
    }

    public void setFranchiseName(String franchiseName) {
        this.franchiseName = franchiseName;
    }

    public void setFranchiseAddress(String franchiseAddress) {
        this.franchiseAddress = franchiseAddress;
    }

    public void setOutWarehouseWorkingStatusName(String outWarehouseWorkingStatusName) {
        this.outWarehouseWorkingStatusName = outWarehouseWorkingStatusName;
    }

    public void setOutWarehouseWorkingFinishedDate(Date outWarehouseWorkingFinishedDate) {
        this.outWarehouseWorkingFinishedDate = outWarehouseWorkingFinishedDate;
    }

    public void setOutWarehouseTotalOutItemAmount(int outWarehouseTotalOutItemAmount) {
        this.outWarehouseTotalOutItemAmount = outWarehouseTotalOutItemAmount;
    }

    @Override
    public String toString() {
        return "OutWarehouseListDTO{" +
                "outWarehouseNo=" + outWarehouseNo +
                ", franchiseName='" + franchiseName + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                ", outWarehouseWorkingStatusName='" + outWarehouseWorkingStatusName + '\'' +
                ", outWarehouseWorkingFinishedDate=" + outWarehouseWorkingFinishedDate +
                ", outWarehouseTotalOutItemAmount=" + outWarehouseTotalOutItemAmount +
                '}';
    }
}
