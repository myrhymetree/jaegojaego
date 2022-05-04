package com.greedy.jaegojaego.issue.issue.model.dto;

import com.greedy.jaegojaego.issue.outWarehouse.model.dto.IssueOutWarehouseDTO;
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;

public class IssueItemDTO {

    private int franchiseIssueNo;
    private IssueDTO issue;
    private int issueItemAmount;
    private OrderItemInfoDTO orderItemInfoDTO;
    private IssueOutWarehouseDTO issueOutWarehouse;

    public IssueItemDTO() {
    }

    public IssueItemDTO(int franchiseIssueNo, IssueDTO issue, int issueItemAmount, OrderItemInfoDTO orderItemInfoDTO, IssueOutWarehouseDTO issueOutWarehouse) {
        this.franchiseIssueNo = franchiseIssueNo;
        this.issue = issue;
        this.issueItemAmount = issueItemAmount;
        this.orderItemInfoDTO = orderItemInfoDTO;
        this.issueOutWarehouse = issueOutWarehouse;
    }

    public int getFranchiseIssueNo() {
        return franchiseIssueNo;
    }

    public void setFranchiseIssueNo(int franchiseIssueNo) {
        this.franchiseIssueNo = franchiseIssueNo;
    }

    public IssueDTO getIssue() {
        return issue;
    }

    public void setIssue(IssueDTO issue) {
        this.issue = issue;
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

    public IssueOutWarehouseDTO getIssueOutWarehouse() {
        return issueOutWarehouse;
    }

    public void setIssueOutWarehouse(IssueOutWarehouseDTO issueOutWarehouse) {
        this.issueOutWarehouse = issueOutWarehouse;
    }

    @Override
    public String toString() {
        return "IssueItemDTO{" +
                "franchiseIssueNo=" + franchiseIssueNo +
                ", issueItemAmount=" + issueItemAmount +
                ", orderItemInfoDTO=" + orderItemInfoDTO +
                ", issueOutWarehouse=" + issueOutWarehouse +
                '}';
    }
}
