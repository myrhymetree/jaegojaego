package com.greedy.jaegojaego.warehouse.entity;

import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;
import com.greedy.jaegojaego.order.order.model.entity.company.OrderApplication;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class WarehouseOrderApplicationItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ORDER_APPLICATION_NO")
    private WarehouseOrderApplication orderApplication;

    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_ITEM_NO")
    private WarehouseOrderApplication orderClientContractItem;

    public WarehouseOrderApplicationItemPK() {
    }

    public WarehouseOrderApplicationItemPK(WarehouseOrderApplication orderApplication, WarehouseOrderApplication orderClientContractItem) {
        this.orderApplication = orderApplication;
        this.orderClientContractItem = orderClientContractItem;
    }

    public WarehouseOrderApplication getOrderApplication() {
        return orderApplication;
    }

    public void setOrderApplication(WarehouseOrderApplication orderApplication) {
        this.orderApplication = orderApplication;
    }

    public WarehouseOrderApplication getOrderClientContractItem() {
        return orderClientContractItem;
    }

    public void setOrderClientContractItem(WarehouseOrderApplication orderClientContractItem) {
        this.orderClientContractItem = orderClientContractItem;
    }

    @Override
    public String toString() {
        return "WarehouseOrderApplicationItemPK{" +
                "orderApplication=" + orderApplication +
                ", orderClientContractItem=" + orderClientContractItem +
                '}';
    }
}
