package com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog;


import java.sql.Date;

public class BacklogInWarehouseDTO {
    /* 입고 (내역) DTO */

    private int inWarehouseNo; //pk
    private String inWarehouseStatus;    //입고 처리 상태 //pk
    private int inWarehouseAmount;   //입고 수량
    private Date inWarehouseDate; //입고 처리 날짜
    private BacklogClientDTO clientNoForInWarehouse; //거래처 번호 fk
    private BacklogItemInfoDTO itemInfoNoForInWarehouse; //자재번호fk 인데 필요없을수도
    private Date inWarehouseCompleteDate;

    public BacklogInWarehouseDTO() {}

    public BacklogInWarehouseDTO(int inWarehouseNo, String inWarehouseStatus, int inWarehouseAmount, Date inWarehouseDate, BacklogClientDTO clientNoForInWarehouse, BacklogItemInfoDTO itemInfoNoForInWarehouse, Date inWarehouseCompleteDate) {
        this.inWarehouseNo = inWarehouseNo;
        this.inWarehouseStatus = inWarehouseStatus;
        this.inWarehouseAmount = inWarehouseAmount;
        this.inWarehouseDate = inWarehouseDate;
        this.clientNoForInWarehouse = clientNoForInWarehouse;
        this.itemInfoNoForInWarehouse = itemInfoNoForInWarehouse;
        this.inWarehouseCompleteDate = inWarehouseCompleteDate;
    }

    public int getInWarehouseNo() {
        return inWarehouseNo;
    }

    public void setInWarehouseNo(int inWarehouseNo) {
        this.inWarehouseNo = inWarehouseNo;
    }

    public String getInWarehouseStatus() {
        return inWarehouseStatus;
    }

    public void setInWarehouseStatus(String inWarehouseStatus) {
        this.inWarehouseStatus = inWarehouseStatus;
    }

    public int getInWarehouseAmount() {
        return inWarehouseAmount;
    }

    public void setInWarehouseAmount(int inWarehouseAmount) {
        this.inWarehouseAmount = inWarehouseAmount;
    }

    public Date getInWarehouseDate() {
        return inWarehouseDate;
    }

    public void setInWarehouseDate(Date inWarehouseDate) {
        this.inWarehouseDate = inWarehouseDate;
    }

    public BacklogClientDTO getClientNoForInWarehouse() {
        return clientNoForInWarehouse;
    }

    public void setClientNoForInWarehouse(BacklogClientDTO clientNoForInWarehouse) {
        this.clientNoForInWarehouse = clientNoForInWarehouse;
    }

    public BacklogItemInfoDTO getItemInfoNoForInWarehouse() {
        return itemInfoNoForInWarehouse;
    }

    public void setItemInfoNoForInWarehouse(BacklogItemInfoDTO itemInfoNoForInWarehouse) {
        this.itemInfoNoForInWarehouse = itemInfoNoForInWarehouse;
    }

    public Date getInWarehouseCompleteDate() {
        return inWarehouseCompleteDate;
    }

    public void setInWarehouseCompleteDate(Date inWarehouseCompleteDate) {
        this.inWarehouseCompleteDate = inWarehouseCompleteDate;
    }

    @Override
    public String toString() {
        return "BacklogInWarehouseDTO{" +
                "inWarehouseNo=" + inWarehouseNo +
                ", inWarehouseStatus='" + inWarehouseStatus + '\'' +
                ", inWarehouseAmount=" + inWarehouseAmount +
                ", inWarehouseDate=" + inWarehouseDate +
                ", clientNoForInWarehouse=" + clientNoForInWarehouse +
                ", itemInfoNoForInWarehouse=" + itemInfoNoForInWarehouse +
                ", inWarehouseCompleteDate=" + inWarehouseCompleteDate +
                '}';
    }
}
