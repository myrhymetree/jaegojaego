package com.greedy.jaegojaego.order.order.model.entitiy;

import com.greedy.jaegojaego.order.client.model.entity.OrderClient;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "orderApplication")
@Table(name = "ORDER_APPLICATION")
@SequenceGenerator(
        name = "ORDER_APPLICATION_SEQ_GENERATOR",
        sequenceName = "ORDER_APPLICATION_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OrderApplication {

    @Id
    @Column(name = "ORDER_APPLICATION_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ORDER_APPLICATION_SEQ_GENERATOR"
    )
    private int orderApplicationNo;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private CompanyOrderHistory companyOrderHistory;

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private OrderClient orderClient;

    @OneToMany
    @JoinColumn(name = "ORDER_APPLICATION_NO")
    private List<OrderApplicationItem> orderApplicationItemList;

    public OrderApplication() {
    }

    public OrderApplication(int orderApplicationNo, CompanyOrderHistory companyOrderHistory, OrderClient orderClient, List<OrderApplicationItem> orderApplicationItemList) {
        this.orderApplicationNo = orderApplicationNo;
        this.companyOrderHistory = companyOrderHistory;
        this.orderClient = orderClient;
        this.orderApplicationItemList = orderApplicationItemList;
    }

    public int getOrderApplicationNo() {
        return orderApplicationNo;
    }

    public void setOrderApplicationNo(int orderApplicationNo) {
        this.orderApplicationNo = orderApplicationNo;
    }

    public CompanyOrderHistory getCompanyOrderHistory() {
        return companyOrderHistory;
    }

    public void setCompanyOrderHistory(CompanyOrderHistory companyOrderHistory) {
        this.companyOrderHistory = companyOrderHistory;
    }

    public OrderClient getOrderClient() {
        return orderClient;
    }

    public void setOrderClient(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    public List<OrderApplicationItem> getOrderApplicationItemList() {
        return orderApplicationItemList;
    }

    public void setOrderApplicationItemList(List<OrderApplicationItem> orderApplicationItemList) {
        this.orderApplicationItemList = orderApplicationItemList;
    }

    @Override
    public String toString() {
        return "OrderApplication{" +
                "CompanyOrderHistoryNo" + companyOrderHistory.getCompanyOrderHistoryNo() +
                "orderApplicationNo=" + orderApplicationNo +
                ", client=" + orderClient +
                ", orderApplicationList=" + orderApplicationItemList +
                '}';
    }
}
