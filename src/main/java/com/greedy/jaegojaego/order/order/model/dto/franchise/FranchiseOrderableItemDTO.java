package com.greedy.jaegojaego.order.order.model.dto.franchise;

import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;

public class FranchiseOrderableItemDTO {

    private OrderItemInfoDTO orderItemInfo;
    private int franchiseOrderableItemPrice;

    public FranchiseOrderableItemDTO() {
    }

    public FranchiseOrderableItemDTO(OrderItemInfoDTO orderItemInfo, int franchiseOrderableItemPrice) {
        this.orderItemInfo = orderItemInfo;
        this.franchiseOrderableItemPrice = franchiseOrderableItemPrice;
    }

    public OrderItemInfoDTO getOrderItemInfo() {
        return orderItemInfo;
    }

    public void setOrderItemInfo(OrderItemInfoDTO orderItemInfo) {
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
        return "FranchiseOrderableItemDTO{" +
                "orderItemInfo=" + orderItemInfo +
                ", franchiseOrderableItemPrice=" + franchiseOrderableItemPrice +
                '}';
    }
}
