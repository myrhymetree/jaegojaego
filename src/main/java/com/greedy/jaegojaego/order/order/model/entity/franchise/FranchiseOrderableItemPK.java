package com.greedy.jaegojaego.order.order.model.entity.franchise;

import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class FranchiseOrderableItemPK implements Serializable {

    @OneToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OrderItemInfo orderItemInfo;

    public FranchiseOrderableItemPK() {
    }

    public FranchiseOrderableItemPK(OrderItemInfo orderItemInfo) {
        this.orderItemInfo = orderItemInfo;
    }

    public OrderItemInfo getOrderItemInfo() {
        return orderItemInfo;
    }

    public void setOrderItemInfo(OrderItemInfo orderItemInfo) {
        this.orderItemInfo = orderItemInfo;
    }

    @Override
    public String toString() {
        return "FranchiseOrderableItemPK{" +
                "orderItemInfo=" + orderItemInfo +
                '}';
    }
}
