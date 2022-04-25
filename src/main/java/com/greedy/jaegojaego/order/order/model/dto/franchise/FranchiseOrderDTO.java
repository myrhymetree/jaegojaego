package com.greedy.jaegojaego.order.order.model.dto.franchise;

import com.greedy.jaegojaego.order.franchise.model.dto.OrderFranchiseInfoDTO;

import java.sql.Date;
import java.util.List;

public class FranchiseOrderDTO {

    private int franchiseOrderNo;
    private java.sql.Date franchiseOrderApplicationDate;
    private int franchiseOrderOrderNumber;
    private OrderFranchiseInfoDTO orderFranchiseInfo;
    private List<FranchiseOrderItemDTO> franchiseOrderItemList;
    private List<FranchiseOrderStatusHistoryDTO> franchiseOrderStatusHistoryList;

    public FranchiseOrderDTO() {
    }

    public FranchiseOrderDTO(int franchiseOrderNo, Date franchiseOrderApplicationDate, int franchiseOrderOrderNumber, OrderFranchiseInfoDTO orderFranchiseInfo, List<FranchiseOrderItemDTO> franchiseOrderItemList, List<FranchiseOrderStatusHistoryDTO> franchiseOrderStatusHistoryList) {
        this.franchiseOrderNo = franchiseOrderNo;
        this.franchiseOrderApplicationDate = franchiseOrderApplicationDate;
        this.franchiseOrderOrderNumber = franchiseOrderOrderNumber;
        this.orderFranchiseInfo = orderFranchiseInfo;
        this.franchiseOrderItemList = franchiseOrderItemList;
        this.franchiseOrderStatusHistoryList = franchiseOrderStatusHistoryList;
    }

    public int getFranchiseOrderNo() {
        return franchiseOrderNo;
    }

    public void setFranchiseOrderNo(int franchiseOrderNo) {
        this.franchiseOrderNo = franchiseOrderNo;
    }

    public Date getFranchiseOrderApplicationDate() {
        return franchiseOrderApplicationDate;
    }

    public void setFranchiseOrderApplicationDate(Date franchiseOrderApplicationDate) {
        this.franchiseOrderApplicationDate = franchiseOrderApplicationDate;
    }

    public int getFranchiseOrderOrderNumber() {
        return franchiseOrderOrderNumber;
    }

    public void setFranchiseOrderOrderNumber(int franchiseOrderOrderNumber) {
        this.franchiseOrderOrderNumber = franchiseOrderOrderNumber;
    }

    public OrderFranchiseInfoDTO getOrderFranchiseInfo() {
        return orderFranchiseInfo;
    }

    public void setOrderFranchiseInfo(OrderFranchiseInfoDTO orderFranchiseInfo) {
        this.orderFranchiseInfo = orderFranchiseInfo;
    }

    public List<FranchiseOrderItemDTO> getFranchiseOrderItemList() {
        return franchiseOrderItemList;
    }

    public void setFranchiseOrderItemList(List<FranchiseOrderItemDTO> franchiseOrderItemList) {
        this.franchiseOrderItemList = franchiseOrderItemList;
    }

    public List<FranchiseOrderStatusHistoryDTO> getFranchiseOrderStatusHistoryList() {
        return franchiseOrderStatusHistoryList;
    }

    public void setFranchiseOrderStatusHistoryList(List<FranchiseOrderStatusHistoryDTO> franchiseOrderStatusHistoryList) {
        this.franchiseOrderStatusHistoryList = franchiseOrderStatusHistoryList;
    }

    @Override
    public String toString() {
        return "FranchiseOrderDTO{" +
                "franchiseOrderNo=" + franchiseOrderNo +
                ", franchiseOrderApplicationDate=" + franchiseOrderApplicationDate +
                ", franchiseOrderOrderNumber=" + franchiseOrderOrderNumber +
                ", orderFranchiseInfo=" + orderFranchiseInfo +
                ", franchiseOrderItemList=" + franchiseOrderItemList +
                ", franchiseOrderStatusHistoryList=" + franchiseOrderStatusHistoryList +
                '}';
    }
}
