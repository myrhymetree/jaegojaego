package com.greedy.jaegojaego.warehouse.dto;

import java.sql.Date;

public class WarehouseCompleteDetailDTO {

    private int companyOrderHistoryNo;                      //발주 번호

    private int clientNo;                                   //거래처 번호
    private String clientName;                              //거래처 명

    private java.sql.Date companyOrderHistoryCreatedDate;   //발주 일시

    private int completeItemInfoNo;                         //아이템 번호
    private int companyAmount;                              //발주 수량
    private int completeItemCategoryNo;                     //카테고리 번호
    private String completeItemCategoryName;                //카테고리 이름
    private String completeItemSerialNo;                    //품번
    private String completeItemName;                        //품명

    private int orderApplicationNo;                         //발주 신청서 번호

    private int clientContractItemNo;                       //거래처 판매 계약 상품 번호

    public WarehouseCompleteDetailDTO(){}

    public WarehouseCompleteDetailDTO(int companyOrderHistoryNo, int clientNo, String clientName, Date companyOrderHistoryCreatedDate, int completeItemInfoNo, int companyAmount, int completeItemCategoryNo, String completeItemCategoryName, String completeItemSerialNo, String completeItemName, int orderApplicationNo, int clientContractItemNo) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
        this.clientNo = clientNo;
        this.clientName = clientName;
        this.companyOrderHistoryCreatedDate = companyOrderHistoryCreatedDate;
        this.completeItemInfoNo = completeItemInfoNo;
        this.companyAmount = companyAmount;
        this.completeItemCategoryNo = completeItemCategoryNo;
        this.completeItemCategoryName = completeItemCategoryName;
        this.completeItemSerialNo = completeItemSerialNo;
        this.completeItemName = completeItemName;
        this.orderApplicationNo = orderApplicationNo;
        this.clientContractItemNo = clientContractItemNo;
    }

    public int getCompanyOrderHistoryNo() {
        return companyOrderHistoryNo;
    }

    public void setCompanyOrderHistoryNo(int companyOrderHistoryNo) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getCompanyOrderHistoryCreatedDate() {
        return companyOrderHistoryCreatedDate;
    }

    public void setCompanyOrderHistoryCreatedDate(Date companyOrderHistoryCreatedDate) {
        this.companyOrderHistoryCreatedDate = companyOrderHistoryCreatedDate;
    }

    public int getCompleteItemInfoNo() {
        return completeItemInfoNo;
    }

    public void setCompleteItemInfoNo(int completeItemInfoNo) {
        this.completeItemInfoNo = completeItemInfoNo;
    }

    public int getCompanyAmount() {
        return companyAmount;
    }

    public void setCompanyAmount(int companyAmount) {
        this.companyAmount = companyAmount;
    }

    public int getCompleteItemCategoryNo() {
        return completeItemCategoryNo;
    }

    public void setCompleteItemCategoryNo(int completeItemCategoryNo) {
        this.completeItemCategoryNo = completeItemCategoryNo;
    }

    public String getCompleteItemCategoryName() {
        return completeItemCategoryName;
    }

    public void setCompleteItemCategoryName(String completeItemCategoryName) {
        this.completeItemCategoryName = completeItemCategoryName;
    }

    public String getCompleteItemSerialNo() {
        return completeItemSerialNo;
    }

    public void setCompleteItemSerialNo(String completeItemSerialNo) {
        this.completeItemSerialNo = completeItemSerialNo;
    }

    public String getCompleteItemName() {
        return completeItemName;
    }

    public void setCompleteItemName(String completeItemName) {
        this.completeItemName = completeItemName;
    }

    public int getOrderApplicationNo() {
        return orderApplicationNo;
    }

    public void setOrderApplicationNo(int orderApplicationNo) {
        this.orderApplicationNo = orderApplicationNo;
    }

    public int getClientContractItemNo() {
        return clientContractItemNo;
    }

    public void setClientContractItemNo(int clientContractItemNo) {
        this.clientContractItemNo = clientContractItemNo;
    }

    @Override
    public String toString() {
        return "WarehouseCompleteDetailDTO{" +
                "companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", clientNo=" + clientNo +
                ", clientName='" + clientName + '\'' +
                ", companyOrderHistoryCreatedDate=" + companyOrderHistoryCreatedDate +
                ", completeItemInfoNo=" + completeItemInfoNo +
                ", companyAmount=" + companyAmount +
                ", completeItemCategoryNo=" + completeItemCategoryNo +
                ", completeItemCategoryName='" + completeItemCategoryName + '\'' +
                ", completeItemSerialNo='" + completeItemSerialNo + '\'' +
                ", completeItemName='" + completeItemName + '\'' +
                ", orderApplicationNo=" + orderApplicationNo +
                ", clientContractItemNo=" + clientContractItemNo +
                '}';
    }
}
