package com.greedy.jaegojaego.warehouse.dto;

public class WarehouseOrderApplicationItemDTO {

    private WarehouseOrderApplicationDTO orderApplication;
    private int orderApplicationItemAmount;
    private WarehouseClientContractItemDTO clientContractItem;

    public WarehouseOrderApplicationItemDTO() {}

    public WarehouseOrderApplicationItemDTO(WarehouseOrderApplicationDTO orderApplication, int orderApplicationItemAmount, WarehouseClientContractItemDTO clientContractItem) {
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

    public WarehouseClientContractItemDTO getClientContractItem() {
        return clientContractItem;
    }

    public void setClientContractItem(WarehouseClientContractItemDTO clientContractItem) {
        this.clientContractItem = clientContractItem;
    }

    @Override
    public String toString() {
        return "WarehouseOrderApplicationItemDTO{" +
                "orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", clientContractItem=" + clientContractItem +
                '}';
    }
}
