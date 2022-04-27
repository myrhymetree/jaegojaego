package com.greedy.jaegojaego.order.warehouse.entity.entitiy;


import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "companyOrderHistory")
@Table(name = "COMPANY_ORDER_HISTORY")
@SequenceGenerator(
        name = "COMPANY_ORDER_HISTORY_SEQ_GENERATOR",
        sequenceName = "COMPANY_ORDER_HISTORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class CompanyOrderHistory {

    @Id
    @Column(name = "COMPANY_ORDER_HISTORY_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "COMPANY_ORDER_HISTORY_SEQ_GENERATOR"
    )
    private int companyOrderHistoryNo;

    @Column(name = "COMPANY_ORDER_HISTORY_CREATED_DATE")
    private java.sql.Date companyOrderHistoryCreatedDate;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private OrderCompanyAccount orderCompanyAccount;

    @OneToMany
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private List<CompanyOrderItem> companyOrderItemList;

    @OneToMany
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private List<OrderApplication> orderApplicationList;

    public CompanyOrderHistory() {
    }

    public CompanyOrderHistory(int companyOrderHistoryNo, Date companyOrderHistoryCreatedDate, OrderCompanyAccount orderCompanyAccount, List<CompanyOrderItem> companyOrderItemList, List<OrderApplication> orderApplicationList) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
        this.companyOrderHistoryCreatedDate = companyOrderHistoryCreatedDate;
        this.orderCompanyAccount = orderCompanyAccount;
        this.companyOrderItemList = companyOrderItemList;
        this.orderApplicationList = orderApplicationList;
    }

    public int getCompanyOrderHistoryNo() {
        return companyOrderHistoryNo;
    }

    public void setCompanyOrderHistoryNo(int companyOrderHistoryNo) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
    }

    public Date getCompanyOrderHistoryCreatedDate() {
        return companyOrderHistoryCreatedDate;
    }

    public void setCompanyOrderHistoryCreatedDate(Date companyOrderHistoryCreatedDate) {
        this.companyOrderHistoryCreatedDate = companyOrderHistoryCreatedDate;
    }

    public OrderCompanyAccount getOrderCompanyAccount() {
        return orderCompanyAccount;
    }

    public void setOrderCompanyAccount(OrderCompanyAccount orderCompanyAccount) {
        this.orderCompanyAccount = orderCompanyAccount;
    }

    public List<CompanyOrderItem> getCompanyOrderItemList() {
        return companyOrderItemList;
    }

    public void setCompanyOrderItemList(List<CompanyOrderItem> companyOrderItemList) {
        this.companyOrderItemList = companyOrderItemList;
    }

    public List<OrderApplication> getOrderApplicationList() {
        return orderApplicationList;
    }

    public void setOrderApplicationList(List<OrderApplication> orderApplicationList) {
        this.orderApplicationList = orderApplicationList;
    }

    @Override
    public String toString() {
        return "CompanyOrderHistory{" +
                "companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", companyOrderHistoryCreatedDate=" + companyOrderHistoryCreatedDate +
                ", companyAccount=" + orderCompanyAccount +
                ", companyOrderItemList=" + companyOrderItemList +
                ", orderApplicationList=" + orderApplicationList +
                '}';
    }
}
