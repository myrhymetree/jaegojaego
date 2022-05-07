package com.greedy.jaegojaego.warehouse.dto;

import com.greedy.jaegojaego.order.client.model.dto.OrderClientContractInfoDTO;
import com.greedy.jaegojaego.order.company.model.dto.OrderCompanyAccountDTO;
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;

import java.sql.Date;

public class WarehouseClientContractItemDTO {

    private int clientContractItemNo;
    private String clientContractItemName;
    private int clientContractItemSupplyPrice;
    private int companyAccount;
    private java.sql.Date clientContractItemCreatedDate;
//    private OrderClientContractInfoDTO clientContractInfo;
    private int clientContractInfo;
//    private WarehouseItemInfoDTO orderItemInfo;
    private int orderItemInfo;

    public WarehouseClientContractItemDTO() {}

    public WarehouseClientContractItemDTO(int clientContractItemNo, String clientContractItemName, int clientContractItemSupplyPrice, int companyAccount, Date clientContractItemCreatedDate, int clientContractInfo, int orderItemInfo) {
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

    public int getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(int companyAccount) {
        this.companyAccount = companyAccount;
    }

    public Date getClientContractItemCreatedDate() {
        return clientContractItemCreatedDate;
    }

    public void setClientContractItemCreatedDate(Date clientContractItemCreatedDate) {
        this.clientContractItemCreatedDate = clientContractItemCreatedDate;
    }

    public int getClientContractInfo() {
        return clientContractInfo;
    }

    public void setClientContractInfo(int clientContractInfo) {
        this.clientContractInfo = clientContractInfo;
    }

    public int getOrderItemInfo() {
        return orderItemInfo;
    }

    public void setOrderItemInfo(int orderItemInfo) {
        this.orderItemInfo = orderItemInfo;
    }

    @Override
    public String toString() {
        return "WarehouseClientContractItemDTO{" +
                "clientContractItemNo=" + clientContractItemNo +
                ", clientContractItemName='" + clientContractItemName + '\'' +
                ", clientContractItemSupplyPrice=" + clientContractItemSupplyPrice +
                ", companyAccount=" + companyAccount +
                ", clientContractItemCreatedDate=" + clientContractItemCreatedDate +
                ", clientContractInfo=" + clientContractInfo +
                ", orderItemInfo=" + orderItemInfo +
                '}';
    }
}
