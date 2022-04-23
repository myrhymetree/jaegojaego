package com.greedy.jaegojaego.warehouse.entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "warehouseCompanyOrderHistory")
@Table(name = "COMPANY_ORDER_HISTORY")
@SequenceGenerator(
        name = "COMPANY_ORDER_HISTORY_SEQ_GENERATOR",
        sequenceName = "COMPANY_ORDER_HISTORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class WarehouseCompanyOrderHistory {

    @Id
    @Column(name = "COMPANY_ORDER_HISTORY_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "COMPANY_ORDER_HISTORY_SEQ_GENERATOR"
    )
    private int companyOrderHistoryNo;

    @Column(name = "COMPANY_ORDER_HISTORY_CREATED_DATE")
    private java.sql.Date companyOrderHistoryCreatedDate;

    @Column(name = "MEMBER_NO")
    private int companyAccount;

    @OneToMany
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private List<WarehouseCompanyOrderItem> companyOrderItemList;

    @OneToMany
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private List<WarehouseOrderApplication> orderApplicationList;

    public WarehouseCompanyOrderHistory() {}

    public WarehouseCompanyOrderHistory(int companyOrderHistoryNo, Date companyOrderHistoryCreatedDate, int companyAccount, List<WarehouseCompanyOrderItem> companyOrderItemList, List<WarehouseOrderApplication> orderApplicationList) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
        this.companyOrderHistoryCreatedDate = companyOrderHistoryCreatedDate;
        this.companyAccount = companyAccount;
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

    public int getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(int companyAccount) {
        this.companyAccount = companyAccount;
    }

    public List<WarehouseCompanyOrderItem> getCompanyOrderItemList() {
        return companyOrderItemList;
    }

    public void setCompanyOrderItemList(List<WarehouseCompanyOrderItem> companyOrderItemList) {
        this.companyOrderItemList = companyOrderItemList;
    }

    public List<WarehouseOrderApplication> getOrderApplicationList() {
        return orderApplicationList;
    }

    public void setOrderApplicationList(List<WarehouseOrderApplication> orderApplicationList) {
        this.orderApplicationList = orderApplicationList;
    }

    @Override
    public String toString() {
        return "WarehouseCompanyOrderHistory{" +
                "companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", companyOrderHistoryCreatedDate=" + companyOrderHistoryCreatedDate +
                ", companyAccount=" + companyAccount +
                ", companyOrderItemList=" + companyOrderItemList +
                ", orderApplicationList=" + orderApplicationList +
                '}';
    }
}
