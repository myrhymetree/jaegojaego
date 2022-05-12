package com.greedy.jaegojaego.warehouse.dto;

public class WarehouseOrderApplicationItemDTO {

    private WarehouseOrderApplicationDTO orderApplication;
    private int orderApplicationItemAmount;
    private WarehouseClientContractItemDTO clientContractItem;
    private String orderApplicationItemYN;

    public WarehouseOrderApplicationItemDTO() {}

    public WarehouseOrderApplicationItemDTO(WarehouseOrderApplicationDTO orderApplication, int orderApplicationItemAmount, WarehouseClientContractItemDTO clientContractItem, String orderApplicationItemYN) {
        this.orderApplication = orderApplication;
        this.orderApplicationItemAmount = orderApplicationItemAmount;
        this.clientContractItem = clientContractItem;
        this.orderApplicationItemYN = orderApplicationItemYN;
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

    public String getOrderApplicationItemYN() {
        return orderApplicationItemYN;
    }

    public void setOrderApplicationItemYN(String orderApplicationItemYN) {
        this.orderApplicationItemYN = orderApplicationItemYN;
    }

    @Override
    public String toString() {
        return "WarehouseOrderApplicationItemDTO{" +
                "orderApplication=" + orderApplication +
                ", orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", clientContractItem=" + clientContractItem +
                ", orderApplicationItemYN='" + orderApplicationItemYN + '\'' +
                '}';
    }
}
