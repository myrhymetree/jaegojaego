package com.greedy.jaegojaego.order.order.model.dto.company;


import com.greedy.jaegojaego.order.company.model.dto.OrderCompanyAccountDTO;

import java.sql.Date;
import java.util.List;

public class CompanyOrderHistoryDTO {

    private int companyOrderHistoryNo;
    private java.sql.Date companyOrderHistoryCreatedDate;
    private OrderCompanyAccountDTO companyAccount;
    private List<CompanyOrderItemDTO> companyOrderItemList;
    private List<OrderApplicationDTO> orderApplicationList;
    private String companyOrderHistoryStaus;
    private java.sql.Date companyOrderHistoryStatusDate;
    private OrderCompanyAccountDTO companyOrderUpdateMember;

    public CompanyOrderHistoryDTO() {
    }

    public CompanyOrderHistoryDTO(int companyOrderHistoryNo, Date companyOrderHistoryCreatedDate, OrderCompanyAccountDTO companyAccount, List<CompanyOrderItemDTO> companyOrderItemList, List<OrderApplicationDTO> orderApplicationList, String companyOrderHistoryStaus, Date companyOrderHistoryStatusDate, OrderCompanyAccountDTO companyOrderUpdateMember) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
        this.companyOrderHistoryCreatedDate = companyOrderHistoryCreatedDate;
        this.companyAccount = companyAccount;
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

    public OrderCompanyAccountDTO getCompanyOrderUpdateMember() {
        return companyOrderUpdateMember;
    }

    public void setCompanyOrderUpdateMember(OrderCompanyAccountDTO companyOrderUpdateMember) {
        this.companyOrderUpdateMember = companyOrderUpdateMember;
    }

    @Override
    public String toString() {
        return "CompanyOrderHistoryDTO{" +
                "companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", companyOrderHistoryCreatedDate=" + companyOrderHistoryCreatedDate +
                ", companyAccount=" + companyAccount +
                ", companyOrderItemList=" + companyOrderItemList +
                ", orderApplicationList=" + orderApplicationList +
                ", companyOrderHistoryStaus='" + companyOrderHistoryStaus + '\'' +
                ", companyOrderHistoryStatusDate=" + companyOrderHistoryStatusDate +
                ", companyOrderUpdateMember=" + companyOrderUpdateMember +
                '}';
    }
}
