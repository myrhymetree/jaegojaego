package com.greedy.jaegojaego.order.order.model.entitiy;

import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "companyOrderItem")
@Table(name = "COMPANY_ORDER_ITEM")
public class CompanyOrderItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OrderItemInfo orderItemInfo;

    @Id
    @ManyToOne
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private CompanyOrderHistory companyOrderHistory;

    @Column(name = "COMPANY_ORDER_ITEM_AMOUNT")
    private int companyOrderItemAmount;

    public CompanyOrderItem() {
    }

    public CompanyOrderItem(OrderItemInfo orderItemInfo, CompanyOrderHistory companyOrderHistory, int companyOrderItemAmount) {
        this.orderItemInfo = orderItemInfo;
        this.companyOrderHistory = companyOrderHistory;
        this.companyOrderItemAmount = companyOrderItemAmount;
    }

    public OrderItemInfo getOrderItemInfo() {
        return orderItemInfo;
    }

    public void setOrderItemInfo(OrderItemInfo orderItemInfo) {
        this.orderItemInfo = orderItemInfo;
    }

    public CompanyOrderHistory getCompanyOrderHistory() {
        return companyOrderHistory;
    }

    public void setCompanyOrderHistory(CompanyOrderHistory companyOrderHistory) {
        this.companyOrderHistory = companyOrderHistory;
    }

    public int getCompanyOrderItemAmount() {
        return companyOrderItemAmount;
    }

    public void setCompanyOrderItemAmount(int companyOrderItemAmount) {
        this.companyOrderItemAmount = companyOrderItemAmount;
    }

    @Override
    public String toString() {
        return "CompanyOrderItem{" +
                "itemInfo=" + orderItemInfo +
                ", companyOrderItemAmount=" + companyOrderItemAmount +
                '}';
    }
}
