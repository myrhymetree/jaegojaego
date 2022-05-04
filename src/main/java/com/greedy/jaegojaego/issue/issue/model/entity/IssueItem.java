package com.greedy.jaegojaego.issue.issue.model.entity;

import com.greedy.jaegojaego.issue.outWarehouse.model.entity.IssueOutWarehouse;
import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;

import javax.persistence.*;

@Entity(name = "issueItem")
@Table(name = "ISSUE_ITEM")
@SequenceGenerator(
        name = "ISSUE_ITEM_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_ISSUE_ITEM_NO",
        initialValue = 1,
        allocationSize = 1
)
public class IssueItem {

    @Id
    @Column(name = "FRANCHISE_ISSUE_ITEM_NO")
    private int franchiseIssueNo;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ISSUE_NO")
    private Issue issue;

    @Column(name = "ISSUE_ITEM_AMOUNT")
    private int issueItemAmount;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OrderItemInfo orderItemInfoDTO;

    @ManyToOne
    @JoinColumn(name = "OUT_WAREHOUSE_NO")
    private IssueOutWarehouse issueOutWarehouse;

    public IssueItem() {
    }

    public IssueItem(int franchiseIssueNo, Issue issue, int issueItemAmount, OrderItemInfo orderItemInfoDTO, IssueOutWarehouse issueOutWarehouse) {
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

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public int getIssueItemAmount() {
        return issueItemAmount;
    }

    public void setIssueItemAmount(int issueItemAmount) {
        this.issueItemAmount = issueItemAmount;
    }

    public OrderItemInfo getOrderItemInfoDTO() {
        return orderItemInfoDTO;
    }

    public void setOrderItemInfoDTO(OrderItemInfo orderItemInfoDTO) {
        this.orderItemInfoDTO = orderItemInfoDTO;
    }

    public IssueOutWarehouse getIssueOutWarehouse() {
        return issueOutWarehouse;
    }

    public void setIssueOutWarehouse(IssueOutWarehouse issueOutWarehouse) {
        this.issueOutWarehouse = issueOutWarehouse;
    }

    @Override
    public String toString() {
        return "IssueItem{" +
                "franchiseIssueNo=" + franchiseIssueNo +
                ", issueItemAmount=" + issueItemAmount +
                ", orderItemInfoDTO=" + orderItemInfoDTO +
                '}';
    }
}
