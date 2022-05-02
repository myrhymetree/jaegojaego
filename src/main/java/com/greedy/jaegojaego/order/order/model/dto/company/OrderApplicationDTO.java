package com.greedy.jaegojaego.order.order.model.dto.company;


import com.greedy.jaegojaego.order.client.model.dto.OrderClientDTO;

import java.util.List;

public class OrderApplicationDTO {

    private CompanyOrderHistoryDTO companyOrderHistory;
    private int orderApplicationNo;
    private OrderClientDTO client;
    private List<OrderApplicationItemDTO> orderApplicationItemList;

    public OrderApplicationDTO() {
    }

    public OrderApplicationDTO(CompanyOrderHistoryDTO companyOrderHistory, int orderApplicationNo, OrderClientDTO client, List<OrderApplicationItemDTO> orderApplicationItemList) {
        this.companyOrderHistory = companyOrderHistory;
        this.orderApplicationNo = orderApplicationNo;
        this.client = client;
        this.orderApplicationItemList = orderApplicationItemList;
    }

    public CompanyOrderHistoryDTO getCompanyOrderHistory() {
        return companyOrderHistory;
    }

    public void setCompanyOrderHistory(CompanyOrderHistoryDTO companyOrderHistory) {
        this.companyOrderHistory = companyOrderHistory;
    }

    public int getOrderApplicationNo() {
        return orderApplicationNo;
    }

    public void setOrderApplicationNo(int orderApplicationNo) {
        this.orderApplicationNo = orderApplicationNo;
    }

    public OrderClientDTO getClient() {
        return client;
    }

    public void setClient(OrderClientDTO client) {
        this.client = client;
    }

    public List<OrderApplicationItemDTO> getOrderApplicationItemList() {
        return orderApplicationItemList;
    }

    public void setOrderApplicationItemList(List<OrderApplicationItemDTO> orderApplicationItemList) {
        this.orderApplicationItemList = orderApplicationItemList;
    }

    @Override
    public String toString() {
        return "OrderApplicationDTO{" +
                "CompanyOrderHistoryNo=" + companyOrderHistory.getCompanyOrderHistoryNo() +
                ", orderApplicationNo=" + orderApplicationNo +
                ", client=" + client +
                ", orderApplicationItemList=" + orderApplicationItemList +
                '}';
    }
}
