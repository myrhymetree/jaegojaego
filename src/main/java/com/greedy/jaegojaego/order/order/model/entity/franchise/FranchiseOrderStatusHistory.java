package com.greedy.jaegojaego.order.order.model.entity.franchise;

import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "franchiseOrderStatusHistoy")
@Table(name = "FRANCHISE_ORDER_STATUS_HISTORY")
@SequenceGenerator(
        name = "FRANCHISE_ORDER_STATUS_HISTORY_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_ORDER_STATUS_HISTORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class FranchiseOrderStatusHistory {

    @Id
    @Column(name = "FRANCHISE_ORDER_STATUS_HISTORY_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FRANCHISE_ORDER_STATUS_HISTORY_SEQ_GENERATOR"
    )
    private int franchiseOrderStatusHistoryNo;

    @Column(name = "FRANCHISE_ORDER_NO")
    private int franchiseOrderNo;

    @Column(name = "FRANCHISE_ORDER_STATUS_HISTORY_DATE")
    private java.sql.Date franchiseOrderStatusHistoryDate;

    @Column(name = "FRANCHISE_ORDER_STATUS")
    private String franchiseOrderStatus;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private OrderCompanyAccount orderCompanyAccount;

    public FranchiseOrderStatusHistory() {
    }

    public FranchiseOrderStatusHistory(int franchiseOrderStatusHistoryNo, int franchiseOrderNo, Date franchiseOrderStatusHistoryDate, String franchiseOrderStatus, OrderCompanyAccount orderCompanyAccount) {
        this.franchiseOrderStatusHistoryNo = franchiseOrderStatusHistoryNo;
        this.franchiseOrderNo = franchiseOrderNo;
        this.franchiseOrderStatusHistoryDate = franchiseOrderStatusHistoryDate;
        this.franchiseOrderStatus = franchiseOrderStatus;
        this.orderCompanyAccount = orderCompanyAccount;
    }

    public int getFranchiseOrderStatusHistoryNo() {
        return franchiseOrderStatusHistoryNo;
    }

    public void setFranchiseOrderStatusHistoryNo(int franchiseOrderStatusHistoryNo) {
        this.franchiseOrderStatusHistoryNo = franchiseOrderStatusHistoryNo;
    }

    public int getFranchiseOrderNo() {
        return franchiseOrderNo;
    }

    public void setFranchiseOrderNo(int franchiseOrderNo) {
        this.franchiseOrderNo = franchiseOrderNo;
    }

    public Date getFranchiseOrderStatusHistoryDate() {
        return franchiseOrderStatusHistoryDate;
    }

    public void setFranchiseOrderStatusHistoryDate(Date franchiseOrderStatusHistoryDate) {
        this.franchiseOrderStatusHistoryDate = franchiseOrderStatusHistoryDate;
    }

    public String getFranchiseOrderStatus() {
        return franchiseOrderStatus;
    }

    public void setFranchiseOrderStatus(String franchiseOrderStatus) {
        this.franchiseOrderStatus = franchiseOrderStatus;
    }

    public OrderCompanyAccount getOrderCompanyAccount() {
        return orderCompanyAccount;
    }

    public void setOrderCompanyAccount(OrderCompanyAccount orderCompanyAccount) {
        this.orderCompanyAccount = orderCompanyAccount;
    }

    @Override
    public String toString() {
        return "FranchiseOrderStatusHistory{" +
                "franchiseOrderStatusHistoryNo=" + franchiseOrderStatusHistoryNo +
                ", franchiseOrderNo=" + franchiseOrderNo +
                ", franchiseOrderStatusHistoryDate=" + franchiseOrderStatusHistoryDate +
                ", franchiseOrderStatus='" + franchiseOrderStatus + '\'' +
                ", orderCompanyAccount=" + orderCompanyAccount +
                '}';
    }
}
