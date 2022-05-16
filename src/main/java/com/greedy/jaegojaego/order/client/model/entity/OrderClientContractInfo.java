package com.greedy.jaegojaego.order.client.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "orderClientContractInfo")
@Table(name = "CLIENT_CONTRACT_INFO")
@SequenceGenerator(
        name = "CLIENT_CONTRACT_INFO_SEQ_GENERATOR",
        sequenceName = "CLIENT_CONTRACT_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OrderClientContractInfo {

    @Id
    @Column(name = "CLIENT_CONTRACT_INFO_NO")
    private int clientContractInfoNo;

    @Column(name = "CLIENT_CONTRACT_INFO_STARTDATE")
    private java.sql.Date clientContractInfoStartDate;

    @Column(name = "CLIENT_CONTRACT_INFO_ENDDATE")
    private java.sql.Date clientContractInfoEndDate;

    @Column(name = "CLIENT_CONTRACT_INFO_STATUS")
    private String clientContractInfoStatus;

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private OrderClient orderClient;

    public OrderClientContractInfo() {
    }

    public OrderClientContractInfo(int clientContractInfoNo, Date clientContractInfoStartDate, Date clientContractInfoEndDate, String clientContractInfoStatus, OrderClient orderClient) {
        this.clientContractInfoNo = clientContractInfoNo;
        this.clientContractInfoStartDate = clientContractInfoStartDate;
        this.clientContractInfoEndDate = clientContractInfoEndDate;
        this.clientContractInfoStatus = clientContractInfoStatus;
        this.orderClient = orderClient;
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

    public OrderClient getOrderClient() {
        return orderClient;
    }

    public void setOrderClient(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    @Override
    public String toString() {
        return "ClientContractInfo{" +
                "clientContractInfoNo=" + clientContractInfoNo +
                ", clientContractInfoStartDate=" + clientContractInfoStartDate +
                ", clientContractInfoEndDate=" + clientContractInfoEndDate +
                ", clientContractInfoStatus='" + clientContractInfoStatus + '\'' +
                ", client=" + orderClient +
                '}';
    }
}
