package com.greedy.jaegojaego.order.order.model.entity.franchise;

import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "franchiseOrderableItem")
@Table(name = "FRANCHISE_ORDERABLE_ITEM")
public class FranchiseOrderableItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OrderItemInfo orderItemInfo;

    @Column(name = "FRANCHISE_ORDERABLE_ITEM_PRICE")
    private int franchiseOrderableItemPrice;

    public FranchiseOrderableItem() {
    }

    public FranchiseOrderableItem(OrderItemInfo orderItemInfo, int franchiseOrderableItemPrice) {
        this.orderItemInfo = orderItemInfo;
        this.franchiseOrderableItemPrice = franchiseOrderableItemPrice;
    }

    public OrderItemInfo getOrderItemInfo() {
        return orderItemInfo;
    }

    public void setOrderItemInfo(OrderItemInfo orderItemInfo) {
        this.orderItemInfo = orderItemInfo;
    }

    public int getFranchiseOrderableItemPrice() {
        return franchiseOrderableItemPrice;
    }

    public void setFranchiseOrderableItemPrice(int franchiseOrderableItemPrice) {
        this.franchiseOrderableItemPrice = franchiseOrderableItemPrice;
    }

    @Override
    public String toString() {
        return "FranchiseOrderableItem{" +
                "orderItemInfo=" + orderItemInfo +
                ", franchiseOrderableItemPrice=" + franchiseOrderableItemPrice +
                '}';
    }
}
