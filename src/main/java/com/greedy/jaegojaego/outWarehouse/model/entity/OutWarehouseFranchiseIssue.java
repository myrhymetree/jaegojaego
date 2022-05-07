package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "outWarehouseFranchiseIssue")
@Table(name = "FRANCHISE_ISSUE")
public class OutWarehouseFranchiseIssue {

    @Id
    @Column(name = "FRANCHISE_ISSUE_NO")
    private int franchiseIssueNo;

    @Column(name = "FANCHISE_ISSUE_STATUS_FINISH_DATE")
    private Date franchiseIssueStatusFinishDate;

    @Column(name = "FRANCHISE_ISSUE_STATUS")
    private String franchiseIssueStatus;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ISSUE_COMPLETER")
    private OutWarehouseCompanyAccount franchiseIssueCompleterNo;

    public OutWarehouseFranchiseIssue() {}

    public OutWarehouseFranchiseIssue(int franchiseIssueNo, Date franchiseIssueStatusFinishDate, String franchiseIssueStatus, OutWarehouseCompanyAccount franchiseIssueCompleterNo) {
        this.franchiseIssueNo = franchiseIssueNo;
        this.franchiseIssueStatusFinishDate = franchiseIssueStatusFinishDate;
        this.franchiseIssueStatus = franchiseIssueStatus;
        this.franchiseIssueCompleterNo = franchiseIssueCompleterNo;
    }

    public int getFranchiseIssueNo() {
        return franchiseIssueNo;
    }

    public void setFranchiseIssueNo(int franchiseIssueNo) {
        this.franchiseIssueNo = franchiseIssueNo;
    }

    public Date getFranchiseIssueStatusFinishDate() {
        return franchiseIssueStatusFinishDate;
    }

    public void setFranchiseIssueStatusFinishDate(Date franchiseIssueStatusFinishDate) {
        this.franchiseIssueStatusFinishDate = franchiseIssueStatusFinishDate;
    }

    public String getFranchiseIssueStatus() {
        return franchiseIssueStatus;
    }

    public void setFranchiseIssueStatus(String franchiseIssueStatus) {
        this.franchiseIssueStatus = franchiseIssueStatus;
    }

    public OutWarehouseCompanyAccount getFranchiseIssueCompleterNo() {
        return franchiseIssueCompleterNo;
    }

    public void setFranchiseIssueCompleterNo(OutWarehouseCompanyAccount franchiseIssueCompleterNo) {
        this.franchiseIssueCompleterNo = franchiseIssueCompleterNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseIssue{" +
                "franchiseIssueNo=" + franchiseIssueNo +
                ", franchiseIssueStatusFinishDate=" + franchiseIssueStatusFinishDate +
                ", franchiseIssueStatus='" + franchiseIssueStatus + '\'' +
                ", franchiseIssueCompleterNo=" + franchiseIssueCompleterNo +
                '}';
    }
}
