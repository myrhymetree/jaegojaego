package com.greedy.jaegojaego.order.order.model.entitiy.company;

import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CompanyOrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OrderItemInfo orderItemInfo;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private CompanyOrderHistory companyOrderHistory;

    public CompanyOrderItemPK() {
    }

    public CompanyOrderItemPK(OrderItemInfo orderItemInfo, CompanyOrderHistory companyOrderHistory) {
        this.orderItemInfo = orderItemInfo;
        this.companyOrderHistory = companyOrderHistory;
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

    @Override
    public String toString() {
        return "CompanyOrderItemPK{" +
                "orderItemInfo=" + orderItemInfo +
                ", companyOrderHistory=" + companyOrderHistory +
                '}';
    }
}
