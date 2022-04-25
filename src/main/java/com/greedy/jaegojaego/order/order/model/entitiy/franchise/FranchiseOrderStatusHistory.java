package com.greedy.jaegojaego.order.order.model.entitiy.franchise;

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
    private int franchiseOrderStatusHitoryNo;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ORDER_NO")
    private FranchiseOrder franchiseOrder;

    @Column(name = "FRANCHISE_ORDER_STATUS_HISTORY_DATE")
    private java.sql.Date franchiseOrderStatusHistoryDate;

    @Column(name = "FRANCHISE_ORDER_STATUS")
    private String franchiseOrderStatus;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private OrderCompanyAccount orderCompanyAccount;

    @Column(name = "FRANCHISE_ORDER_STATUS_REJECTION_CONTENT")
    private String franchiseOrderStatusRejectionContent;

    public FranchiseOrderStatusHistory() {
    }

    public FranchiseOrderStatusHistory(int franchiseOrderStatusHitoryNo, FranchiseOrder franchiseOrder, Date franchiseOrderStatusHistoryDate, String franchiseOrderStatus, OrderCompanyAccount orderCompanyAccount, String franchiseOrderStatusRejectionContent) {
        this.franchiseOrderStatusHitoryNo = franchiseOrderStatusHitoryNo;
        this.franchiseOrder = franchiseOrder;
        this.franchiseOrderStatusHistoryDate = franchiseOrderStatusHistoryDate;
        this.franchiseOrderStatus = franchiseOrderStatus;
        this.orderCompanyAccount = orderCompanyAccount;
        this.franchiseOrderStatusRejectionContent = franchiseOrderStatusRejectionContent;
    }

    public int getFranchiseOrderStatusHitoryNo() {
        return franchiseOrderStatusHitoryNo;
    }

    public void setFranchiseOrderStatusHitoryNo(int franchiseOrderStatusHitoryNo) {
        this.franchiseOrderStatusHitoryNo = franchiseOrderStatusHitoryNo;
    }

    public FranchiseOrder getFranchiseOrder() {
        return franchiseOrder;
    }

    public void setFranchiseOrder(FranchiseOrder franchiseOrder) {
        this.franchiseOrder = franchiseOrder;
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

    public String getFranchiseOrderStatusRejectionContent() {
        return franchiseOrderStatusRejectionContent;
    }

    public void setFranchiseOrderStatusRejectionContent(String franchiseOrderStatusRejectionContent) {
        this.franchiseOrderStatusRejectionContent = franchiseOrderStatusRejectionContent;
    }

    @Override
    public String toString() {
        return "FranchiseOrderStatusHistory{" +
                "franchiseOrderStatusHitoryNo=" + franchiseOrderStatusHitoryNo +
                ", franchiseOrderStatusHistoryDate=" + franchiseOrderStatusHistoryDate +
                ", franchiseOrderStatus='" + franchiseOrderStatus + '\'' +
                ", orderCompanyAccount=" + orderCompanyAccount +
                ", franchiseOrderStatusRejectionContent='" + franchiseOrderStatusRejectionContent + '\'' +
                '}';
    }
}
