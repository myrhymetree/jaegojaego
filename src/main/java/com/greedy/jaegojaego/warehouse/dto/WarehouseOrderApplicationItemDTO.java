package com.greedy.jaegojaego.warehouse.dto;

public class WarehouseOrderApplicationItemDTO {

    private WarehouseOrderApplicationDTO orderApplication;
    private int orderApplicationItemAmount;
    private int clientContractItem;

    public WarehouseOrderApplicationItemDTO() {}

    public WarehouseOrderApplicationItemDTO(WarehouseOrderApplicationDTO orderApplication, int orderApplicationItemAmount, int clientContractItem) {
        this.orderApplication = orderApplication;
        this.orderApplicationItemAmount = orderApplicationItemAmount;
        this.clientContractItem = clientContractItem;
    }

    public WarehouseOrderApplicationDTO getOrderApplication() {
        return orderApplication;
    }

    public void setOrderApplication(WarehouseOrderApplicationDTO orderApplication) {
        this.orderApplication = orderApplication;
    }

    public int getOrderApplicationItemAmount() {
        return orderApplicationItemAmount;
    }

    public void setOrderApplicationItemAmount(int orderApplicationItemAmount) {
        this.orderApplicationItemAmount = orderApplicationItemAmount;
    }

    public int getClientContractItem() {
        return clientContractItem;
    }

    public void setClientContractItem(int clientContractItem) {
        this.clientContractItem = clientContractItem;
    }

    @Override
    public String toString() {
        return "WarehouseOrderApplicationItemDTO{" +
//                "orderApplication=" + orderApplication +
                ", orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", clientContractItem=" + clientContractItem +
                '}';
    }
}
