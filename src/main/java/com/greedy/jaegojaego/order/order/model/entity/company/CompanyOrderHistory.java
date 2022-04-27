package com.greedy.jaegojaego.order.order.model.entity.company;


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

    @Column(name = "COMPANY_ORDER_HISTORY_STATUS")
    private String companyOrderHistoryStaus;

    @Column(name = "COMPANY_ORDER_HISTORY_STATUS_DATE")
    private java.sql.Date companyOrderHistoryStatusDate;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_STATUS_UPDATE_MEMBER")
    private OrderCompanyAccount companyOrderUpdateMember;

    public CompanyOrderHistory() {
    }

    public CompanyOrderHistory(int companyOrderHistoryNo, Date companyOrderHistoryCreatedDate, OrderCompanyAccount orderCompanyAccount, List<CompanyOrderItem> companyOrderItemList, List<OrderApplication> orderApplicationList, String companyOrderHistoryStaus, Date companyOrderHistoryStatusDate, OrderCompanyAccount companyOrderUpdateMember) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
        this.companyOrderHistoryCreatedDate = companyOrderHistoryCreatedDate;
        this.orderCompanyAccount = orderCompanyAccount;
        this.companyOrderItemList = companyOrderItemList;
        this.orderApplicationList = orderApplicationList;
        this.companyOrderHistoryStaus = companyOrderHistoryStaus;
        this.companyOrderHistoryStatusDate = companyOrderHistoryStatusDate;
        this.companyOrderUpdateMember = companyOrderUpdateMember;
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

    public String getCompanyOrderHistoryStaus() {
        return companyOrderHistoryStaus;
    }

    public void setCompanyOrderHistoryStaus(String companyOrderHistoryStaus) {
        this.companyOrderHistoryStaus = companyOrderHistoryStaus;
    }

    public Date getCompanyOrderHistoryStatusDate() {
        return companyOrderHistoryStatusDate;
    }

    public void setCompanyOrderHistoryStatusDate(Date companyOrderHistoryStatusDate) {
        this.companyOrderHistoryStatusDate = companyOrderHistoryStatusDate;
    }

    public OrderCompanyAccount getCompanyOrderUpdateMember() {
        return companyOrderUpdateMember;
    }

    public void setCompanyOrderUpdateMember(OrderCompanyAccount companyOrderUpdateMember) {
        this.companyOrderUpdateMember = companyOrderUpdateMember;
    }

    @Override
    public String toString() {
        return "CompanyOrderHistory{" +
                "companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", companyOrderHistoryCreatedDate=" + companyOrderHistoryCreatedDate +
                ", orderCompanyAccount=" + orderCompanyAccount +
                ", companyOrderItemList=" + companyOrderItemList +
                ", orderApplicationList=" + orderApplicationList +
                ", companyOrderHistoryStaus='" + companyOrderHistoryStaus + '\'' +
                ", companyOrderHistoryStatusDate=" + companyOrderHistoryStatusDate +
                ", companyOrderUpdateMember=" + companyOrderUpdateMember +
                '}';
    }
}
