package com.greedy.jaegojaego.order.order.model.dto.company;

import com.greedy.jaegojaego.order.client.model.dto.OrderClientContractItemDTO;

public class OrderApplicationItemDTO {

    private OrderApplicationDTO orderApplication;
    private int orderApplicationItemAmount;
    private OrderClientContractItemDTO clientContractItem;

    public OrderApplicationItemDTO() {
    }

    public OrderApplicationItemDTO(OrderApplicationDTO orderApplication, int orderApplicationItemAmount, OrderClientContractItemDTO clientContractItem) {
        this.orderApplication = orderApplication;
        this.orderApplicationItemAmount = orderApplicationItemAmount;
        this.clientContractItem = clientContractItem;
    }

    public OrderApplicationDTO getOrderApplication() {
        return orderApplication;
    }

    public void setOrderApplication(OrderApplicationDTO orderApplication) {
        this.orderApplication = orderApplication;
    }

    public int getOrderApplicationItemAmount() {
        return orderApplicationItemAmount;
    }

    public void setOrderApplicationItemAmount(int orderApplicationItemAmount) {
        this.orderApplicationItemAmount = orderApplicationItemAmount;
    }

    public OrderClientContractItemDTO getClientContractItem() {
        return clientContractItem;
    }

    public void setClientContractItem(OrderClientContractItemDTO clientContractItem) {
        this.clientContractItem = clientContractItem;
    }

    @Override
    public String toString() {
        return "OrderApplicationItemDTO{" +
                "orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", clientContractItem=" + clientContractItem +
                '}';
    }
}
