package com.greedy.jaegojaego.issue.outWarehouse.model.dto;

import com.greedy.jaegojaego.issue.franchise.model.dto.IssueFranchiseInfoDTO;
import com.greedy.jaegojaego.issue.issue.model.entity.Issue;
import com.greedy.jaegojaego.order.order.model.dto.franchise.FranchiseOrderDTO;

import java.sql.Date;

public class IssueOutWarehouseDTO {

    private int issueOutWarehouseNo;
    private IssueFranchiseInfoDTO issueFranchiseInfo;
    private FranchiseOrderDTO franchiseOrder;
    private Issue issue;
    private java.sql.Date issueOutWarehouseWorkingFinishedDate;
    private String issueOutWarehouseWorkingStatusName;

    public IssueOutWarehouseDTO() {
    }

    public IssueOutWarehouseDTO(int issueOutWarehouseNo, IssueFranchiseInfoDTO issueFranchiseInfo, FranchiseOrderDTO franchiseOrder, Issue issue, Date issueOutWarehouseWorkingFinishedDate, String issueOutWarehouseWorkingStatusName) {
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

    public IssueFranchiseInfoDTO getIssueFranchiseInfo() {
        return issueFranchiseInfo;
    }

    public void setIssueFranchiseInfo(IssueFranchiseInfoDTO issueFranchiseInfo) {
        this.issueFranchiseInfo = issueFranchiseInfo;
    }

    public FranchiseOrderDTO getFranchiseOrder() {
        return franchiseOrder;
    }

    public void setFranchiseOrder(FranchiseOrderDTO franchiseOrder) {
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
        return "IssueOutWarehouseDTO{" +
                "issueOutWarehouseNo=" + issueOutWarehouseNo +
                ", issueFranchiseInfo=" + issueFranchiseInfo +
                ", issueOutWarehouseWorkingFinishedDate=" + issueOutWarehouseWorkingFinishedDate +
                ", issueOutWarehouseWorkingStatusName='" + issueOutWarehouseWorkingStatusName + '\'' +
                '}';
    }
}
