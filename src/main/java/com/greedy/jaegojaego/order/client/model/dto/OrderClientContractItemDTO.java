package com.greedy.jaegojaego.order.client.model.dto;

import com.greedy.jaegojaego.order.company.model.dto.OrderCompanyAccountDTO;
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;
import lombok.*;

import java.sql.Date;

public class OrderClientContractItemDTO {

    private int clientContractItemNo;
    private String clientContractItemName;
    private int clientContractItemSupplyPrice;
    private OrderCompanyAccountDTO companyAccount;
    private java.sql.Date clientContractItemCreatedDate;
    private OrderClientContractInfoDTO clientContractInfo;
    private OrderItemInfoDTO orderItemInfo;

    public OrderClientContractItemDTO() {
    }

    public OrderClientContractItemDTO(int clientContractItemNo, String clientContractItemName, int clientContractItemSupplyPrice, OrderCompanyAccountDTO companyAccount, Date clientContractItemCreatedDate, OrderClientContractInfoDTO clientContractInfo, OrderItemInfoDTO orderItemInfo) {
        this.clientContractItemNo = clientContractItemNo;
        this.clientContractItemName = clientContractItemName;
        this.clientContractItemSupplyPrice = clientContractItemSupplyPrice;
        this.companyAccount = companyAccount;
        this.clientContractItemCreatedDate = clientContractItemCreatedDate;
        this.clientContractInfo = clientContractInfo;
        this.orderItemInfo = orderItemInfo;
    }

    public int getClientContractItemNo() {
        return clientContractItemNo;
    }

    public void setClientContractItemNo(int clientContractItemNo) {
        this.clientContractItemNo = clientContractItemNo;
    }

    public String getClientContractItemName() {
        return clientContractItemName;
    }

    public void setClientContractItemName(String clientContractItemName) {
        this.clientContractItemName = clientContractItemName;
    }

    public int getClientContractItemSupplyPrice() {
        return clientContractItemSupplyPrice;
    }

    public void setClientContractItemSupplyPrice(int clientContractItemSupplyPrice) {
        this.clientContractItemSupplyPrice = clientContractItemSupplyPrice;
    }

    public OrderCompanyAccountDTO getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(OrderCompanyAccountDTO companyAccount) {
        this.companyAccount = companyAccount;
    }

    public Date getClientContractItemCreatedDate() {
        return clientContractItemCreatedDate;
    }

    public void setClientContractItemCreatedDate(Date clientContractItemCreatedDate) {
        this.clientContractItemCreatedDate = clientContractItemCreatedDate;
    }

    public OrderClientContractInfoDTO getClientContractInfo() {
        return clientContractInfo;
    }

    public void setClientContractInfo(OrderClientContractInfoDTO clientContractInfo) {
        this.clientContractInfo = clientContractInfo;
    }

    public OrderItemInfoDTO getOrderItemInfo() {
        return orderItemInfo;
    }

    public void setOrderItemInfo(OrderItemInfoDTO orderItemInfo) {
        this.orderItemInfo = orderItemInfo;
    }

    @Override
    public String toString() {
        return "ClientContractItemDTO{" +
                "clientContractItemNo=" + clientContractItemNo +
                ", clientContractItemName='" + clientContractItemName + '\'' +
                ", clientContractItemSupplyPrice=" + clientContractItemSupplyPrice +
                ", companyAccount=" + companyAccount +
                ", clientContractItemCreatedDate=" + clientContractItemCreatedDate +
                ", clientContractInfo=" + clientContractInfo +
                ", itemInfo=" + orderItemInfo +
                '}';
    }
}
