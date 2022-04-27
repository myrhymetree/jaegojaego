package com.greedy.jaegojaego.order.order.model.dto.franchise;

import com.greedy.jaegojaego.order.company.model.dto.OrderCompanyAccountDTO;

import java.sql.Date;

public class FranchiseOrderStatusHistoryDTO {

    private int franchiseOrderStatusHistoryNo;
    private FranchiseOrderDTO franchiseOrder;
    private java.sql.Date franchiseOrderStatusHistoryDate;
    private String franchiseOrderStatus;
    private OrderCompanyAccountDTO orderCompanyAccount;
    private String franchiseOrderStatusRejectionContent;

    public FranchiseOrderStatusHistoryDTO() {
    }

    public FranchiseOrderStatusHistoryDTO(int franchiseOrderStatusHistoryNo, FranchiseOrderDTO franchiseOrder, Date franchiseOrderStatusHistoryDate, String franchiseOrderStatus, OrderCompanyAccountDTO orderCompanyAccount, String franchiseOrderStatusRejectionContent) {
        this.franchiseOrderStatusHistoryNo = franchiseOrderStatusHistoryNo;
        this.franchiseOrder = franchiseOrder;
        this.franchiseOrderStatusHistoryDate = franchiseOrderStatusHistoryDate;
        this.franchiseOrderStatus = franchiseOrderStatus;
        this.orderCompanyAccount = orderCompanyAccount;
        this.franchiseOrderStatusRejectionContent = franchiseOrderStatusRejectionContent;
    }

    public int getFranchiseOrderStatusHistoryNo() {
        return franchiseOrderStatusHistoryNo;
    }

    public void setFranchiseOrderStatusHistoryNo(int franchiseOrderStatusHistoryNo) {
        this.franchiseOrderStatusHistoryNo = franchiseOrderStatusHistoryNo;
    }

    public FranchiseOrderDTO getFranchiseOrder() {
        return franchiseOrder;
    }

    public void setFranchiseOrder(FranchiseOrderDTO franchiseOrder) {
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

    public OrderCompanyAccountDTO getOrderCompanyAccount() {
        return orderCompanyAccount;
    }

    public void setOrderCompanyAccount(OrderCompanyAccountDTO orderCompanyAccount) {
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
        return "FranchiseOrderStatusHistoryDTO{" +
                "franchiseOrderStatusHistoryNo=" + franchiseOrderStatusHistoryNo +
                ", franchiseOrderStatusHistoryDate=" + franchiseOrderStatusHistoryDate +
                ", franchiseOrderStatus='" + franchiseOrderStatus + '\'' +
                ", orderCompanyAccount=" + orderCompanyAccount +
                ", franchiseOrderStatusRejectionContent='" + franchiseOrderStatusRejectionContent + '\'' +
                '}';
    }
}
