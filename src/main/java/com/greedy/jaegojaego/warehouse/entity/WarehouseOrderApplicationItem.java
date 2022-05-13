package com.greedy.jaegojaego.warehouse.entity;


import javax.persistence.*;

@Entity(name = "warehouseOrderApplicationItem")
@Table(name = "ORDER_APPLICATION_ITEM")
public class WarehouseOrderApplicationItem {

    @EmbeddedId
    private WarehouseOrderApplicationItemPK orderApplicationItemPK;

    @Column(name = "ORDER_APPLICATION_ITEM_AMOUNT")
    private int orderApplicationItemAmount;

    @Column(name = "ORDER_APPLICATION_IN_YN")
    private String orderApplicationItemYN;

    public WarehouseOrderApplicationItem() {}

    public WarehouseOrderApplicationItem(WarehouseOrderApplicationItemPK orderApplicationItemPK, int orderApplicationItemAmount, String orderApplicationItemYN) {
        this.orderApplicationItemPK = orderApplicationItemPK;
        this.orderApplicationItemAmount = orderApplicationItemAmount;
        this.orderApplicationItemYN = orderApplicationItemYN;
    }

    public WarehouseOrderApplicationItemPK getOrderApplicationItemPK() {
        return orderApplicationItemPK;
    }

    public void setOrderApplicationItemPK(WarehouseOrderApplicationItemPK orderApplicationItemPK) {
        this.orderApplicationItemPK = orderApplicationItemPK;
    }

    public int getOrderApplicationItemAmount() {
        return orderApplicationItemAmount;
    }

    public void setOrderApplicationItemAmount(int orderApplicationItemAmount) {
        this.orderApplicationItemAmount = orderApplicationItemAmount;
    }

    public String getOrderApplicationItemYN() {
        return orderApplicationItemYN;
    }

    public void setOrderApplicationItemYN(String orderApplicationItemYN) {
        this.orderApplicationItemYN = orderApplicationItemYN;
    }

    @Override
    public String toString() {
        return "WarehouseOrderApplicationItem{" +
                "orderApplicationItemPK=" + orderApplicationItemPK +
                ", orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", orderApplicationItemYN='" + orderApplicationItemYN + '\'' +
                '}';
    }
}
