package com.greedy.jaegojaego.order.order.model.dto;


import com.greedy.jaegojaego.order.company.model.dto.OrderCompanyAccountDTO;
import lombok.*;

import java.sql.Date;
import java.util.List;

public class CompanyOrderHistoryDTO {

    private int companyOrderHistoryNo;
    private java.sql.Date companyOrderHistoryCreatedDate;
    private OrderCompanyAccountDTO companyAccount;
    private List<CompanyOrderItemDTO> companyOrderItemList;
    private List<OrderApplicationDTO> orderApplicationList;

    public CompanyOrderHistoryDTO() {}

    public CompanyOrderHistoryDTO(int companyOrderHistoryNo, Date companyOrderHistoryCreatedDate, OrderCompanyAccountDTO companyAccount, List<CompanyOrderItemDTO> companyOrderItemList, List<OrderApplicationDTO> orderApplicationList) {
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

    public OrderCompanyAccountDTO getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(OrderCompanyAccountDTO companyAccount) {
        this.companyAccount = companyAccount;
    }

    public List<CompanyOrderItemDTO> getCompanyOrderItemList() {
        return companyOrderItemList;
    }

    public void setCompanyOrderItemList(List<CompanyOrderItemDTO> companyOrderItemList) {
        this.companyOrderItemList = companyOrderItemList;
    }

    public List<OrderApplicationDTO> getOrderApplicationList() {
        return orderApplicationList;
    }

    public void setOrderApplicationList(List<OrderApplicationDTO> orderApplicationList) {
        this.orderApplicationList = orderApplicationList;
    }

    @Override
    public String toString() {
        return "CompanyOrderHistoryDTO{" +
                "companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", companyOrderHistoryCreatedDate=" + companyOrderHistoryCreatedDate +
                ", companyAccount=" + companyAccount +
                ", companyOrderItemList=" + companyOrderItemList +
                ", orderApplicationList=" + orderApplicationList +
                '}';
    }
}
