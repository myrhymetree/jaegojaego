package com.greedy.jaegojaego.issue.outWarehouse.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greedy.jaegojaego.issue.franchise.model.entity.IssueFranchiseInfo;
import com.greedy.jaegojaego.issue.issue.model.entity.Issue;
import com.greedy.jaegojaego.order.order.model.entity.franchise.FranchiseOrder;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "issueOutWarehouse")
@Table(name = "OUT_WAREHOUSE")
@SequenceGenerator(
        name = "ISSUE_OUT_WAREHOUSE_SEQ_GENERATOR",
        sequenceName = "OUT_WAREHOUSE_NO",
        initialValue = 1,
        allocationSize = 1
)
public class IssueOutWarehouse {

    @Id
    @Column(name = "OUT_WAREHOUSE_NO")
    private int issueOutWarehouseNo;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private IssueFranchiseInfo issueFranchiseInfo;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ORDER_NO")
    private FranchiseOrder franchiseOrder;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ISSUE_NO")
    private Issue issue;

    @Column(name = "OUT_WAREHOUSE_WORKING_FINISHED_DATE")
    private java.sql.Date issueOutWarehouseWorkingFinishedDate;

    @Column(name = "OUT_WAREHOUSE_WORKING_STATUS_NAME")
    private String issueOutWarehouseWorkingStatusName;

    public IssueOutWarehouse() {
    }

    public IssueOutWarehouse(int issueOutWarehouseNo, IssueFranchiseInfo issueFranchiseInfo, FranchiseOrder franchiseOrder, Issue issue, Date issueOutWarehouseWorkingFinishedDate, String issueOutWarehouseWorkingStatusName) {
        this.issueOutWarehouseNo = issueOutWarehouseNo;
        this.issueFranchiseInfo = issueFranchiseInfo;
        this.franchiseOrder = franchiseOrder;
        this.issue = issue;
        this.issueOutWarehouseWorkingFinishedDate = issueOutWarehouseWorkingFinishedDate;
        this.issueOutWarehouseWorkingStatusName = issueOutWarehouseWorkingStatusName;
    }

    public int getIssueOutWarehouseNo() {
        return issueOutWarehouseNo;
    }

    public void setIssueOutWarehouseNo(int issueOutWarehouseNo) {
        this.issueOutWarehouseNo = issueOutWarehouseNo;
    }

    public IssueFranchiseInfo getIssueFranchiseInfo() {
        return issueFranchiseInfo;
    }

    public void setIssueFranchiseInfo(IssueFranchiseInfo issueFranchiseInfo) {
        this.issueFranchiseInfo = issueFranchiseInfo;
    }

    public FranchiseOrder getFranchiseOrder() {
        return franchiseOrder;
    }

    public void setFranchiseOrder(FranchiseOrder franchiseOrder) {
        this.franchiseOrder = franchiseOrder;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Date getIssueOutWarehouseWorkingFinishedDate() {
        return issueOutWarehouseWorkingFinishedDate;
    }

    public void setIssueOutWarehouseWorkingFinishedDate(Date issueOutWarehouseWorkingFinishedDate) {
        this.issueOutWarehouseWorkingFinishedDate = issueOutWarehouseWorkingFinishedDate;
    }

    public String getIssueOutWarehouseWorkingStatusName() {
        return issueOutWarehouseWorkingStatusName;
    }

    public void setIssueOutWarehouseWorkingStatusName(String issueOutWarehouseWorkingStatusName) {
        this.issueOutWarehouseWorkingStatusName = issueOutWarehouseWorkingStatusName;
    }

    @Override
    public String toString() {
        return "IssueOutWarehouse{" +
                "issueOutWarehouseNo=" + issueOutWarehouseNo +
                ", issueFranchiseInfo=" + issueFranchiseInfo +
                ", issueOutWarehouseWorkingFinishedDate=" + issueOutWarehouseWorkingFinishedDate +
                ", issueOutWarehouseWorkingStatusName='" + issueOutWarehouseWorkingStatusName + '\'' +
                '}';
    }
}
