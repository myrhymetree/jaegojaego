package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "outWarehouseFranchiseIssue")
@Table(name = "FRANCHISE_ISSUE")
public class OutWarehouseFranchiseIssue {

    @Id
    @Column(name = "FRANCHISE_ISSUE_NO")
    private int franchiseIssueNo;

    @Column(name = "FRANCHISE_ISSUE_STATUS_FINISH_DATE")
    private Date franchiseIssueStatusFinishDate;

    @Column(name = "FRANCHISE_ISSUE_STATUS")
    private String franchiseIssueStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FRANCHISE_ISSUE_PRESENTER")
    private OutWarehouseMember franchiseIssuePresenter;

    public OutWarehouseFranchiseIssue() {}

    public OutWarehouseFranchiseIssue(int franchiseIssueNo, Date franchiseIssueStatusFinishDate, String franchiseIssueStatus, OutWarehouseMember franchiseIssuePresenter) {
        this.franchiseIssueNo = franchiseIssueNo;
        this.franchiseIssueStatusFinishDate = franchiseIssueStatusFinishDate;
        this.franchiseIssueStatus = franchiseIssueStatus;
        this.franchiseIssuePresenter = franchiseIssuePresenter;
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

    public OutWarehouseMember getFranchiseIssuePresenter() {
        return franchiseIssuePresenter;
    }

    public void setFranchiseIssuePresenter(OutWarehouseMember franchiseIssuePresenter) {
        this.franchiseIssuePresenter = franchiseIssuePresenter;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseIssue{" +
                "franchiseIssueNo=" + franchiseIssueNo +
                ", franchiseIssueStatusFinishDate=" + franchiseIssueStatusFinishDate +
                ", franchiseIssueStatus='" + franchiseIssueStatus + '\'' +
                ", franchiseIssuePresenter=" + franchiseIssuePresenter +
                '}';
    }
}
