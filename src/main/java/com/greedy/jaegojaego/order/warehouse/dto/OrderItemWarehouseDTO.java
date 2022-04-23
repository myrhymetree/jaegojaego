package com.greedy.jaegojaego.order.warehouse.dto;

public class OrderItemWarehouseDTO {

    private int orderItemWarehouseNo;
    private String orderItemWarehouseQualityStatus;
    private String orderItemWarehouseAddress;

    public OrderItemWarehouseDTO() {
    }

    public OrderItemWarehouseDTO(int orderItemWarehouseNo, String orderItemWarehouseQualityStatus, String orderItemWarehouseAddress) {
        this.orderItemWarehouseNo = orderItemWarehouseNo;
        this.orderItemWarehouseQualityStatus = orderItemWarehouseQualityStatus;
        this.orderItemWarehouseAddress = orderItemWarehouseAddress;
    }

    public int getOrderItemWarehouseNo() {
        return orderItemWarehouseNo;
    }

    public void setOrderItemWarehouseNo(int orderItemWarehouseNo) {
        this.orderItemWarehouseNo = orderItemWarehouseNo;
    }

    public String getOrderItemWarehouseQualityStatus() {
        return orderItemWarehouseQualityStatus;
    }

    public void setOrderItemWarehouseQualityStatus(String orderItemWarehouseQualityStatus) {
        this.orderItemWarehouseQualityStatus = orderItemWarehouseQualityStatus;
    }

    public String getOrderItemWarehouseAddress() {
        return orderItemWarehouseAddress;
    }

    public void setOrderItemWarehouseAddress(String orderItemWarehouseAddress) {
        this.orderItemWarehouseAddress = orderItemWarehouseAddress;
    }

    @Override
    public String toString() {
        return "OrderItemWarehouseDTO{" +
                "orderItemWarehouseNo=" + orderItemWarehouseNo +
                ", orderItemWarehouseQualityStatus='" + orderItemWarehouseQualityStatus + '\'' +
                ", orderItemWarehouseAddress='" + orderItemWarehouseAddress + '\'' +
                '}';
    }
}
