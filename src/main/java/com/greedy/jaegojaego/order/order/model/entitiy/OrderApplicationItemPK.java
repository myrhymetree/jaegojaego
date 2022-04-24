package com.greedy.jaegojaego.order.order.model.entitiy;

import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class OrderApplicationItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ORDER_APPLICATION_NO")
    private OrderApplication orderApplication;

    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_ITEM_NO")
    private OrderClientContractItem orderClientContractItem;

    public OrderApplicationItemPK() {
    }

    public OrderApplication getOrderApplication() {
        return orderApplication;
    }

    public void setOrderApplication(OrderApplication orderApplication) {
        this.orderApplication = orderApplication;
    }

    public OrderClientContractItem getOrderClientContractItem() {
        return orderClientContractItem;
    }

    public void setOrderClientContractItem(OrderClientContractItem orderClientContractItem) {
        this.orderClientContractItem = orderClientContractItem;
    }

    @Override
    public String toString() {
        return "OrderApplicationItemPK{" +
                "orderApplication=" + orderApplication +
                ", orderClientContractItem=" + orderClientContractItem +
                '}';
    }
}
