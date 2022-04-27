package com.greedy.jaegojaego.order.order.model.dto.franchise;

import com.greedy.jaegojaego.order.company.model.dto.OrderCompanyAccountDTO;

import java.sql.Date;

public class FranchiseOrderStatusHistoryDTO {

    private int franchiseOrderStatusHistoryNo;
    private int franchiseOrderNo;
    private java.sql.Date franchiseOrderStatusHistoryDate;
    private String franchiseOrderStatus;
    private OrderCompanyAccountDTO orderCompanyAccount;

    public FranchiseOrderStatusHistoryDTO() {
    }

    public FranchiseOrderStatusHistoryDTO(int franchiseOrderStatusHistoryNo, int franchiseOrderNo, Date franchiseOrderStatusHistoryDate, String franchiseOrderStatus, OrderCompanyAccountDTO orderCompanyAccount) {
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

    public OrderCompanyAccountDTO getOrderCompanyAccount() {
        return orderCompanyAccount;
    }

    public void setOrderCompanyAccount(OrderCompanyAccountDTO orderCompanyAccount) {
        this.orderCompanyAccount = orderCompanyAccount;
    }

    @Override
    public String toString() {
        return "FranchiseOrderStatusHistoryDTO{" +
                "franchiseOrderStatusHistoryNo=" + franchiseOrderStatusHistoryNo +
                ", franchiseOrderNo=" + franchiseOrderNo +
                ", franchiseOrderStatusHistoryDate=" + franchiseOrderStatusHistoryDate +
                ", franchiseOrderStatus='" + franchiseOrderStatus + '\'' +
                ", orderCompanyAccount=" + orderCompanyAccount +
                '}';
    }
}
