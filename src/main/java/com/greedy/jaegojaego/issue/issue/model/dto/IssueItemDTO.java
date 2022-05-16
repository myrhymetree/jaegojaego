package com.greedy.jaegojaego.issue.issue.model.dto;

import com.greedy.jaegojaego.issue.outWarehouse.model.dto.IssueOutWarehouseDTO;
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;

public class IssueItemDTO {

    private int franchiseIssueItemNo;
    private int issueItemAmount;
    private OrderItemInfoDTO orderItemInfoDTO;

    public IssueItemDTO() {
    }

    public IssueItemDTO(int franchiseIssueItemNo, int issueItemAmount, OrderItemInfoDTO orderItemInfoDTO) {
        this.franchiseIssueItemNo = franchiseIssueItemNo;
        this.issueItemAmount = issueItemAmount;
        this.orderItemInfoDTO = orderItemInfoDTO;
    }

    public int getFranchiseIssueItemNo() {
        return franchiseIssueItemNo;
    }

    public void setFranchiseIssueItemNo(int franchiseIssueItemNo) {
        this.franchiseIssueItemNo = franchiseIssueItemNo;
    }

    public int getIssueItemAmount() {
        return issueItemAmount;
    }

    public void setIssueItemAmount(int issueItemAmount) {
        this.issueItemAmount = issueItemAmount;
    }

    public OrderItemInfoDTO getOrderItemInfoDTO() {
        return orderItemInfoDTO;
    }

    public void setOrderItemInfoDTO(OrderItemInfoDTO orderItemInfoDTO) {
        this.orderItemInfoDTO = orderItemInfoDTO;
    }

    @Override
    public String toString() {
        return "IssueItemDTO{" +
                "franchiseIssueItemNo=" + franchiseIssueItemNo +
                ", issueItemAmount=" + issueItemAmount +
                ", orderItemInfoDTO=" + orderItemInfoDTO +
                '}';
    }
}
