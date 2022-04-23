package com.greedy.jaegojaego.outWarehouse.model.dto;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseStatusHistory;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseStatusHistoryId;
import lombok.*;

import java.sql.Date;
import java.util.List;

public class OutWarehouseListDTO {

    private int outWarehouseNo;
    private String franchiseBranchName;
    private String franchiseAddress;
    private String outWarehouseWorkingStatusName;
    private Date outWarehouseWorkingFinishedDate;
    private int outWarehouseTotalOutItemAmount;

    public OutWarehouseListDTO() {}

    public OutWarehouseListDTO(int outWarehouseNo, String franchiseBranchName, String franchiseAddress, String outWarehouseWorkingStatusName, Date outWarehouseWorkingFinishedDate, int outWarehouseTotalOutItemAmount) {
        this.outWarehouseNo = outWarehouseNo;
        this.franchiseBranchName = franchiseBranchName;
        this.franchiseAddress = franchiseAddress;
        this.outWarehouseWorkingStatusName = outWarehouseWorkingStatusName;
        this.outWarehouseWorkingFinishedDate = outWarehouseWorkingFinishedDate;
        this.outWarehouseTotalOutItemAmount = outWarehouseTotalOutItemAmount;
    }

    public int getOutWarehouseNo() {
        return outWarehouseNo;
    }

    public String getFranchiseBranchName() {
        return franchiseBranchName;
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

    public void setFranchiseBranchName(String franchiseBranchName) {
        this.franchiseBranchName = franchiseBranchName;
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
                ", franchiseBranchName='" + franchiseBranchName + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                ", outWarehouseWorkingStatusName='" + outWarehouseWorkingStatusName + '\'' +
                ", outWarehouseWorkingFinishedDate=" + outWarehouseWorkingFinishedDate +
                ", outWarehouseTotalOutItemAmount=" + outWarehouseTotalOutItemAmount +
                '}';
    }
}
