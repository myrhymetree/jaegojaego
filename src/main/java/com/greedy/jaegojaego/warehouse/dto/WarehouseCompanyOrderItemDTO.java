package com.greedy.jaegojaego.warehouse.dto;

public class WarehouseCompanyOrderItemDTO {

    private WarehouseItemInfoDTO itemInfo;
    private WarehouseCompanyOrderHistoryDTO companyOrderHistory;
    private int companyOrderItemAmount;

    public WarehouseCompanyOrderItemDTO() {}

    public WarehouseCompanyOrderItemDTO(WarehouseItemInfoDTO itemInfo, WarehouseCompanyOrderHistoryDTO companyOrderHistory, int companyOrderItemAmount) {
        this.itemInfo = itemInfo;
        this.companyOrderHistory = companyOrderHistory;
        this.companyOrderItemAmount = companyOrderItemAmount;
    }

    public WarehouseItemInfoDTO getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(WarehouseItemInfoDTO itemInfo) {
        this.itemInfo = itemInfo;
    }

    public WarehouseCompanyOrderHistoryDTO getCompanyOrderHistory() {
        return companyOrderHistory;
    }

    public void setCompanyOrderHistory(WarehouseCompanyOrderHistoryDTO companyOrderHistory) {
        this.companyOrderHistory = companyOrderHistory;
    }

    public int getCompanyOrderItemAmount() {
        return companyOrderItemAmount;
    }

    public void setCompanyOrderItemAmount(int companyOrderItemAmount) {
        this.companyOrderItemAmount = companyOrderItemAmount;
    }

    @Override
    public String toString() {
        return "WarehouseCompanyOrderItemDTO{" +
                "itemInfo=" + itemInfo +
                ", companyOrderHistory=" + companyOrderHistory +
                ", companyOrderItemAmount=" + companyOrderItemAmount +
                '}';
    }
}
