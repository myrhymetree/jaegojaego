package com.greedy.jaegojaego.order.order.model.dto;


import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;
import lombok.*;

public class CompanyOrderItemDTO {

    private OrderItemInfoDTO itemInfo;
    private CompanyOrderHistoryDTO companyOrderHistory;
    private int companyOrderItemAmount;

    public CompanyOrderItemDTO() {
    }

    public CompanyOrderItemDTO(OrderItemInfoDTO itemInfo, CompanyOrderHistoryDTO companyOrderHistory, int companyOrderItemAmount) {
        this.itemInfo = itemInfo;
        this.companyOrderHistory = companyOrderHistory;
        this.companyOrderItemAmount = companyOrderItemAmount;
    }

    public OrderItemInfoDTO getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(OrderItemInfoDTO itemInfo) {
        this.itemInfo = itemInfo;
    }

    public CompanyOrderHistoryDTO getCompanyOrderHistory() {
        return companyOrderHistory;
    }

    public void setCompanyOrderHistory(CompanyOrderHistoryDTO companyOrderHistory) {
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
        return "CompanyOrderItemDTO{" +
                "companyOrderHistoryNo=" + companyOrderHistory.getCompanyOrderHistoryNo() +
                ", itemInfo=" + itemInfo +
                ", companyOrderItemAmount=" + companyOrderItemAmount +
                '}';
    }
}
