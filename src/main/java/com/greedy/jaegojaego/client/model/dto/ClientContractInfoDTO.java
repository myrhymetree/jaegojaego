package com.greedy.jaegojaego.client.model.dto;

import java.sql.Date;

public class ClientContractInfoDTO {

    private int clientContractInfoNo;
    private Date clientContractInfoStartDate;
    private Date clientContractInfoEndDate;
    private String clientContractInfoStatus;
    private int clientNo;

    public ClientContractInfoDTO(int clientContractInfoNo, Date clientContractInfoStartDate, Date clientContractInfoEndDate, String clientContractInfoStatus, int clientNo) {
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

    public java.sql.Date getClientContractInfoStartDate() {
        return clientContractInfoStartDate;
    }

    public void setClientContractInfoStartDate(Date clientContractInfoStartDate) {
        this.clientContractInfoStartDate = clientContractInfoStartDate;
    }

    public java.sql.Date getClientContractInfoEndDate() {
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
