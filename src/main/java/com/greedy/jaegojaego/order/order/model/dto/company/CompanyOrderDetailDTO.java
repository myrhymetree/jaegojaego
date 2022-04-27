package com.greedy.jaegojaego.order.order.model.dto.company;

import com.greedy.jaegojaego.order.client.model.dto.OrderClientDTO;

import java.sql.Date;

public class CompanyOrderDetailDTO {

    private String itemName;
    private int itemAmount;
    private int itemPrice;
    private String clientName;
    private int companyOrderHistoryNo;
    private int orderApplicationNo;
    private int clientNo;
    private java.sql.Date orderCreatedDate;

    public CompanyOrderDetailDTO() {}

    public CompanyOrderDetailDTO(String itemName, int itemAmount, int itemPrice, String clientName, int companyOrderHistoryNo, int orderApplicationNo, int clientNo, Date orderCreatedDate) {
        this.itemName = itemName;
        this.itemAmount = itemAmount;
        this.itemPrice = itemPrice;
        this.clientName = clientName;
        this.companyOrderHistoryNo = companyOrderHistoryNo;
        this.orderApplicationNo = orderApplicationNo;
        this.clientNo = clientNo;
        this.orderCreatedDate = orderCreatedDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getCompanyOrderHistoryNo() {
        return companyOrderHistoryNo;
    }

    public void setCompanyOrderHistoryNo(int companyOrderHistoryNo) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
    }

    public int getOrderApplicationNo() {
        return orderApplicationNo;
    }

    public void setOrderApplicationNo(int orderApplicationNo) {
        this.orderApplicationNo = orderApplicationNo;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public Date getOrderCreatedDate() {
        return orderCreatedDate;
    }

    public void setOrderCreatedDate(Date orderCreatedDate) {
        this.orderCreatedDate = orderCreatedDate;
    }

    @Override
    public String toString() {
        return "CompanyOrderDetailDTO{" +
                "itemName='" + itemName + '\'' +
                ", itemAmount=" + itemAmount +
                ", itemPrice=" + itemPrice +
                ", clientName='" + clientName + '\'' +
                ", companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", orderApplicationNo=" + orderApplicationNo +
                ", clientNo=" + clientNo +
                ", orderCreatedDate=" + orderCreatedDate +
                '}';
    }
}
