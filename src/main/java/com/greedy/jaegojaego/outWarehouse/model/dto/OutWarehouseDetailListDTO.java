package com.greedy.jaegojaego.outWarehouse.model.dto;

import java.sql.Date;

public class OutWarehouseDetailListDTO {

    private int outWarehouseItemNo;
    private int outWarehouseNo;
    private String itemInfoItemSerialNo;
    private String materialCategoryName;
    private String itemInfoName;
    private int outWarehouseItemAmount;
    private String franchiseBranchName;
    private String franchiseAddress;
    private String outWarehouseWorkingStatusName;
    private Date outWarehouseWorkingFinishedDate;

    public OutWarehouseDetailListDTO() {}

    public OutWarehouseDetailListDTO(int outWarehouseItemNo, int outWarehouseNo, String itemInfoItemSerialNo, String materialCategoryName, String itemInfoName, int outWarehouseItemAmount, String franchiseBranchName, String franchiseAddress, String outWarehouseWorkingStatusName, Date outWarehouseWorkingFinishedDate) {
        this.outWarehouseItemNo = outWarehouseItemNo;
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
        this.materialCategoryName = materialCategoryName;
        this.itemInfoName = itemInfoName;
        this.outWarehouseItemAmount = outWarehouseItemAmount;
        this.franchiseBranchName = franchiseBranchName;
        this.franchiseAddress = franchiseAddress;
        this.outWarehouseWorkingStatusName = outWarehouseWorkingStatusName;
        this.outWarehouseWorkingFinishedDate = outWarehouseWorkingFinishedDate;
    }

    public int getOutWarehouseItemNo() {
        return outWarehouseItemNo;
    }

    public int getOutWarehouseNo() {
        return outWarehouseNo;
    }

    public String getItemInfoItemSerialNo() {
        return itemInfoItemSerialNo;
    }

    public String getMaterialCategoryName() {
        return materialCategoryName;
    }

    public String getItemInfoName() {
        return itemInfoName;
    }

    public int getOutWarehouseItemAmount() {
        return outWarehouseItemAmount;
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

    public void setOutWarehouseItemNo(int outWarehouseItemNo) {
        this.outWarehouseItemNo = outWarehouseItemNo;
    }

    public void setOutWarehouseNo(int outWarehouseNo) {
        this.outWarehouseNo = outWarehouseNo;
    }

    public void setItemInfoItemSerialNo(String itemInfoItemSerialNo) {
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
    }

    public void setMaterialCategoryName(String materialCategoryName) {
        this.materialCategoryName = materialCategoryName;
    }

    public void setItemInfoName(String itemInfoName) {
        this.itemInfoName = itemInfoName;
    }

    public void setOutWarehouseItemAmount(int outWarehouseItemAmount) {
        this.outWarehouseItemAmount = outWarehouseItemAmount;
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

    @Override
    public String toString() {
        return "OutWarehouseDetailListDTO{" +
                "outWarehouseItemNo=" + outWarehouseItemNo +
                ", outWarehouseNo=" + outWarehouseNo +
                ", itemInfoItemSerialNo='" + itemInfoItemSerialNo + '\'' +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", outWarehouseItemAmount=" + outWarehouseItemAmount +
                ", franchiseBranchName='" + franchiseBranchName + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                ", outWarehouseWorkingStatusName='" + outWarehouseWorkingStatusName + '\'' +
                ", outWarehouseWorkingFinishedDate=" + outWarehouseWorkingFinishedDate +
                '}';
    }
}
