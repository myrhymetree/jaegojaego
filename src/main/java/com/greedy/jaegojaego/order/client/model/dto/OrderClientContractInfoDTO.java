package com.greedy.jaegojaego.order.client.model.dto;

import lombok.*;

import java.sql.Date;

public class OrderClientContractInfoDTO {

    private int clientContractInfoNo;
    private java.sql.Date clientContractInfoStartDate;
    private java.sql.Date clientContractInfoEndDate;
    private String clientContractInfoStatus;
    private int clientNo;

    public OrderClientContractInfoDTO() {
    }

    public OrderClientContractInfoDTO(int clientContractInfoNo, Date clientContractInfoStartDate, Date clientContractInfoEndDate, String clientContractInfoStatus, int clientNo) {
        this.clientContractInfoNo = clientContractInfoNo;
        this.clientContractInfoStartDate = clientContractInfoStartDate;
        this.clientContractInfoEndDate = clientContractInfoEndDate;
        this.clientContractInfoStatus = clientContractInfoStatus;
        this.clientNo = clientNo;
    }

    public int getClientContractInfoNo() {
        return clientContractInfoNo;
    }

    public void setClientContractInfoNo(int clientContractInfoNo) {
        this.clientContractInfoNo = clientContractInfoNo;
    }

    public Date getClientContractInfoStartDate() {
        return clientContractInfoStartDate;
    }

    public void setClientContractInfoStartDate(Date clientContractInfoStartDate) {
        this.clientContractInfoStartDate = clientContractInfoStartDate;
    }

    public Date getClientContractInfoEndDate() {
        return clientContractInfoEndDate;
    }

    public void setClientContractInfoEndDate(Date clientContractInfoEndDate) {
        this.clientContractInfoEndDate = clientContractInfoEndDate;
    }

    public String getClientContractInfoStatus() {
        return clientContractInfoStatus;
    }

    public void setClientContractInfoStatus(String clientContractInfoStatus) {
        this.clientContractInfoStatus = clientContractInfoStatus;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    @Override
    public String toString() {
        return "ClientContractInfoDTO{" +
                "clientContractInfoNo=" + clientContractInfoNo +
                ", clientContractInfoStartDate=" + clientContractInfoStartDate +
                ", clientContractInfoEndDate=" + clientContractInfoEndDate +
                ", clientContractInfoStatus='" + clientContractInfoStatus + '\'' +
                ", clientNo=" + clientNo +
                '}';
    }
}
