package com.greedy.jaegojaego.warehouse.dto;

import java.sql.Date;

public class WarehouseDTO {

    private int warehouseNo;                                        //입고 내역 번호
    private int warehouseAmount;                                    //입고 수량
    private String warehouseStatus;                                 //입고 처리 상태
    private java.sql.Date warehouseDate;                            //입고 대기 처리 날짜
    private int orderApplicationNo;                                 //발주 신청서 번호
    private int clientContractItemNo;                               //거래처 판매 계약 상품 번호
    private WarehouseItemInfoDTO itemInfoNo;                        //재고(자재) 번호
    private WarehouseClientDTO clientNo;                            //거래처 번호
    private java.sql.Date warehouseCompleteDate;                    //입고 완료 처리 날짜

    public WarehouseDTO() {}

    public WarehouseDTO(int warehouseNo, int warehouseAmount, String warehouseStatus, Date warehouseDate, int orderApplicationNo, int clientContractItemNo, WarehouseItemInfoDTO itemInfoNo, WarehouseClientDTO clientNo, Date warehouseCompleteDate) {
        this.warehouseNo = warehouseNo;
        this.warehouseAmount = warehouseAmount;
        this.warehouseStatus = warehouseStatus;
        this.warehouseDate = warehouseDate;
        this.orderApplicationNo = orderApplicationNo;
        this.clientContractItemNo = clientContractItemNo;
        this.itemInfoNo = itemInfoNo;
        this.clientNo = clientNo;
        this.warehouseCompleteDate = warehouseCompleteDate;
    }

    public int getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(int warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public int getWarehouseAmount() {
        return warehouseAmount;
    }

    public void setWarehouseAmount(int warehouseAmount) {
        this.warehouseAmount = warehouseAmount;
    }

    public String getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(String warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    public Date getWarehouseDate() {
        return warehouseDate;
    }

    public void setWarehouseDate(Date warehouseDate) {
        this.warehouseDate = warehouseDate;
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

    public WarehouseItemInfoDTO getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(WarehouseItemInfoDTO itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public WarehouseClientDTO getClientNo() {
        return clientNo;
    }

    public void setClientNo(WarehouseClientDTO clientNo) {
        this.clientNo = clientNo;
    }

    public Date getWarehouseCompleteDate() {
        return warehouseCompleteDate;
    }

    public void setWarehouseCompleteDate(Date warehouseCompleteDate) {
        this.warehouseCompleteDate = warehouseCompleteDate;
    }

    @Override
    public String toString() {
        return "WarehouseDTO{" +
                "warehouseNo=" + warehouseNo +
                ", warehouseAmount=" + warehouseAmount +
                ", warehouseStatus='" + warehouseStatus + '\'' +
                ", warehouseDate=" + warehouseDate +
                ", orderApplicationNo=" + orderApplicationNo +
                ", clientContractItemNo=" + clientContractItemNo +
                ", itemInfoNo=" + itemInfoNo +
                ", clientNo=" + clientNo +
                ", warehouseCompleteDate=" + warehouseCompleteDate +
                '}';
    }
}
