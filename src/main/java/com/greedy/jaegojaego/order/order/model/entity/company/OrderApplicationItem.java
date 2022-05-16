package com.greedy.jaegojaego.order.order.model.entity.company;


import javax.persistence.*;

@Entity(name = "orderApplicationItem")
@Table(name = "ORDER_APPLICATION_ITEM")
public class OrderApplicationItem {

    @EmbeddedId
    private OrderApplicationItemPK orderApplicationItemPK;

    @Column(name = "ORDER_APPLICATION_ITEM_AMOUNT")
    private int orderApplicationItemAmount;

    public OrderApplicationItem() {
    }

    public OrderApplicationItem(OrderApplicationItemPK orderApplicationItemPK, int orderApplicationItemAmount) {
        this.orderApplicationItemPK = orderApplicationItemPK;
        this.orderApplicationItemAmount = orderApplicationItemAmount;
    }

    public OrderApplicationItemPK getOrderApplicationItemPK() {
        return orderApplicationItemPK;
    }

    public void setOrderApplicationItemPK(OrderApplicationItemPK orderApplicationItemPK) {
        this.orderApplicationItemPK = orderApplicationItemPK;
    }

    public int getOrderApplicationItemAmount() {
        return orderApplicationItemAmount;
    }

    public void setOrderApplicationItemAmount(int orderApplicationItemAmount) {
        this.orderApplicationItemAmount = orderApplicationItemAmount;
    }

    @Override
    public String toString() {
        return "OrderApplicationItem{" +
                "orderApplicationItemPK=" + orderApplicationItemPK +
                ", orderApplicationItemAmount=" + orderApplicationItemAmount +
                '}';
    }
}
