package com.greedy.jaegojaego.issue.issue.model.entity;

import com.greedy.jaegojaego.member.model.entity.Member;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "franchiseIssueHistory")
@Table(name = "FRANCHISE_ISSUE_HISTORY")
@SequenceGenerator(
        name = "FRANCHISE_ISSUE_HISTORY_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_ISSUE_HISTORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class IssueHistory {

    @Id
    @Column(name = "FRANCHISE_ISSUE_HISTORY_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FRANCHISE_ISSUE_HISTORY_SEQ_GENERATOR"
    )
    private int franchiseIssueHistoryNo;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ISSUE_NO")
    private Issue issue;

    @Column(name = "FRANCHISE_ISSUE_HISTORY_STATUS")
    private String franchiseIssueHistoryStatus;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ISSUE_HISTORY_COMPLETER")
    private Member franchiseIssueHistoryCompleter;

    @Column(name = "FRANCHISE_ISSUE_HISTORY_DATE")
    private java.sql.Date franchiseIssueHistoryDate;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ISSUE_HISTORY_UPDATE_MEMBER")
    private Member franchiseIssueHistoryUpdateMember;

    public IssueHistory() {
    }

    public IssueHistory(int franchiseIssueHistoryNo, Issue issue, String franchiseIssueHistoryStatus, Member franchiseIssueHistoryCompleter, Date franchiseIssueHistoryDate, Member franchiseIssueHistoryUpdateMember) {
        this.franchiseIssueHistoryNo = franchiseIssueHistoryNo;
        this.issue = issue;
        this.franchiseIssueHistoryStatus = franchiseIssueHistoryStatus;
        this.franchiseIssueHistoryCompleter = franchiseIssueHistoryCompleter;
        this.franchiseIssueHistoryDate = franchiseIssueHistoryDate;
        this.franchiseIssueHistoryUpdateMember = franchiseIssueHistoryUpdateMember;
    }

    public int getFranchiseIssueHistoryNo() {
        return franchiseIssueHistoryNo;
    }

    public void setFranchiseIssueHistoryNo(int franchiseIssueHistoryNo) {
        this.franchiseIssueHistoryNo = franchiseIssueHistoryNo;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public String getFranchiseIssueHistoryStatus() {
        return franchiseIssueHistoryStatus;
    }

    public void setFranchiseIssueHistoryStatus(String franchiseIssueHistoryStatus) {
        this.franchiseIssueHistoryStatus = franchiseIssueHistoryStatus;
    }

    public Member getFranchiseIssueHistoryCompleter() {
        return franchiseIssueHistoryCompleter;
    }

    public void setFranchiseIssueHistoryCompleter(Member franchiseIssueHistoryCompleter) {
        this.franchiseIssueHistoryCompleter = franchiseIssueHistoryCompleter;
    }

    public Date getFranchiseIssueHistoryDate() {
        return franchiseIssueHistoryDate;
    }

    public void setFranchiseIssueHistoryDate(Date franchiseIssueHistoryDate) {
        this.franchiseIssueHistoryDate = franchiseIssueHistoryDate;
    }

    public Member getFranchiseIssueHistoryUpdateMember() {
        return franchiseIssueHistoryUpdateMember;
    }

    public void setFranchiseIssueHistoryUpdateMember(Member franchiseIssueHistoryUpdateMember) {
        this.franchiseIssueHistoryUpdateMember = franchiseIssueHistoryUpdateMember;
    }

    @Override
    public String toString() {
        return "IssueHistory{" +
                "franchiseIssueHistoryNo=" + franchiseIssueHistoryNo +
                ", issue=" + issue +
                ", franchiseIssueHistoryStatus='" + franchiseIssueHistoryStatus + '\'' +
                ", franchiseIssueHistoryCompleter=" + franchiseIssueHistoryCompleter +
                ", franchiseIssueHistoryDate=" + franchiseIssueHistoryDate +
                ", franchiseIssueHistoryUpdateMember=" + franchiseIssueHistoryUpdateMember +
                '}';
    }
}
