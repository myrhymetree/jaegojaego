package com.greedy.jaegojaego.order.warehouse.entity.entitiy;


import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "orderApplicationItem")
@Table(name = "ORDER_APPLICATION_ITEM")
public class OrderApplicationItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ORDER_APPLICATION_NO")
    private OrderApplication orderApplication;

    @Column(name = "ORDER_APPLICATION_ITEM_AMOUNT")
    private int orderApplicationItemAmount;

    @Id
    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_ITEM_NO")
    private OrderClientContractItem orderClientContractItem;

    public OrderApplicationItem() {
    }

    public OrderApplicationItem(OrderApplication orderApplication, int orderApplicationItemAmount, OrderClientContractItem orderClientContractItem) {
        this.orderApplication = orderApplication;
        this.orderApplicationItemAmount = orderApplicationItemAmount;
        this.orderClientContractItem = orderClientContractItem;
    }

    public OrderApplication getOrderApplication() {
        return orderApplication;
    }

    public void setOrderApplication(OrderApplication orderApplication) {
        this.orderApplication = orderApplication;
    }

    public int getOrderApplicationItemAmount() {
        return orderApplicationItemAmount;
    }

    public void setOrderApplicationItemAmount(int orderApplicationItemAmount) {
        this.orderApplicationItemAmount = orderApplicationItemAmount;
    }

    public OrderClientContractItem getOrderClientContractItem() {
        return orderClientContractItem;
    }

    public void setOrderClientContractItem(OrderClientContractItem orderClientContractItem) {
        this.orderClientContractItem = orderClientContractItem;
    }

    @Override
    public String toString() {
        return "OrderApplicationItem{" +
                "orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", orderClientContractItem=" + orderClientContractItem +
                '}';
    }
}
