package com.greedy.jaegojaego.warehouse.dto;

import java.sql.Date;
import java.util.List;

public class WarehouseCompanyOrderHistoryDTO {

    private int companyOrderHistoryNo;
    private java.sql.Date companyOrderHistoryCreatedDate;
    private int companyAccount;
    private List<WarehouseCompanyOrderItemDTO> companyOrderItemList;
    private List<WarehouseOrderApplicationDTO> orderApplicationList;
    private String companyOrderHistoryStatus;
    private java.sql.Date companyOrderHistoryStatusDate;

    public WarehouseCompanyOrderHistoryDTO() {}

    public WarehouseCompanyOrderHistoryDTO(int companyOrderHistoryNo, Date companyOrderHistoryCreatedDate, int companyAccount, List<WarehouseCompanyOrderItemDTO> companyOrderItemList, List<WarehouseOrderApplicationDTO> orderApplicationList, String companyOrderHistoryStatus, Date companyOrderHistoryStatusDate) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
        this.companyOrderHistoryCreatedDate = companyOrderHistoryCreatedDate;
        this.companyAccount = companyAccount;
        this.companyOrderItemList = companyOrderItemList;
        this.orderApplicationList = orderApplicationList;
        this.companyOrderHistoryStatus = companyOrderHistoryStatus;
        this.companyOrderHistoryStatusDate = companyOrderHistoryStatusDate;
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

    public List<WarehouseCompanyOrderItemDTO> getCompanyOrderItemList() {
        return companyOrderItemList;
    }

    public void setCompanyOrderItemList(List<WarehouseCompanyOrderItemDTO> companyOrderItemList) {
        this.companyOrderItemList = companyOrderItemList;
    }

    public List<WarehouseOrderApplicationDTO> getOrderApplicationList() {
        return orderApplicationList;
    }

    public void setOrderApplicationList(List<WarehouseOrderApplicationDTO> orderApplicationList) {
        this.orderApplicationList = orderApplicationList;
    }

    public String getCompanyOrderHistoryStatus() {
        return companyOrderHistoryStatus;
    }

    public void setCompanyOrderHistoryStatus(String companyOrderHistoryStatus) {
        this.companyOrderHistoryStatus = companyOrderHistoryStatus;
    }

    public Date getCompanyOrderHistoryStatusDate() {
        return companyOrderHistoryStatusDate;
    }

    public void setCompanyOrderHistoryStatusDate(Date companyOrderHistoryStatusDate) {
        this.companyOrderHistoryStatusDate = companyOrderHistoryStatusDate;
    }

    @Override
    public String toString() {
        return "WarehouseCompanyOrderHistoryDTO{" +
                "companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", companyOrderHistoryCreatedDate=" + companyOrderHistoryCreatedDate +
                ", companyAccount=" + companyAccount +
                ", companyOrderItemList=" + companyOrderItemList +
                ", orderApplicationList=" + orderApplicationList +
                ", companyOrderHistoryStatus='" + companyOrderHistoryStatus + '\'' +
                ", companyOrderHistoryStatusDate=" + companyOrderHistoryStatusDate +
                '}';
    }
}
