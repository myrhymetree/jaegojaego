package com.greedy.jaegojaego.warehouse.dto;

import java.util.List;

public class WarehouseOrderApplicationDTO {

    private WarehouseCompanyOrderHistoryDTO companyOrderHistory;
    private int orderApplicationNo;
    private WarehouseClientDTO client;
    private List<WarehouseOrderApplicationItemDTO> orderApplicationItemList;

    public WarehouseOrderApplicationDTO() {}

    public WarehouseCompanyOrderHistoryDTO getCompanyOrderHistory() {
        return companyOrderHistory;
    }

    public void setCompanyOrderHistory(WarehouseCompanyOrderHistoryDTO companyOrderHistory) {
        this.companyOrderHistory = companyOrderHistory;
    }

    public int getOrderApplicationNo() {
        return orderApplicationNo;
    }

    public void setOrderApplicationNo(int orderApplicationNo) {
        this.orderApplicationNo = orderApplicationNo;
    }

    public WarehouseClientDTO getClient() {
        return client;
    }

    public void setClient(WarehouseClientDTO client) {
        this.client = client;
    }

    public List<WarehouseOrderApplicationItemDTO> getOrderApplicationItemList() {
        return orderApplicationItemList;
    }

    public void setOrderApplicationItemList(List<WarehouseOrderApplicationItemDTO> orderApplicationItemList) {
        this.orderApplicationItemList = orderApplicationItemList;
    }

    @Override
    public String toString() {
        return "WarehouseOrderApplicationDTO{" +
//                "companyOrderHistory=" + companyOrderHistory +
                ", orderApplicationNo=" + orderApplicationNo +
//                ", client=" + client +
                ", orderApplicationItemList=" + orderApplicationItemList +
                '}';
    }
}
