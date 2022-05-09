package com.greedy.jaegojaego.issue.issue.model.dto;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;

import java.sql.Date;

public class IssueHistoryDTO {

    private int franchiseIssueHistoryNo;
    private IssueDTO issue;
    private String franchiseIssueHistoryStatus;
    private MemberDTO franchiseIssueHistoryCompleter;
    private java.sql.Date franchiseIssueHistoryDate;
    private MemberDTO franchiseIssueHistoryUpdateMember;

    public IssueHistoryDTO() {
    }

    public IssueHistoryDTO(int franchiseIssueHistoryNo, IssueDTO issue, String franchiseIssueHistoryStatus, MemberDTO franchiseIssueHistoryCompleter, Date franchiseIssueHistoryDate, MemberDTO franchiseIssueHistoryUpdateMember) {
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

    public IssueDTO getIssue() {
        return issue;
    }

    public void setIssue(IssueDTO issue) {
        this.issue = issue;
    }

    public String getFranchiseIssueHistoryStatus() {
        return franchiseIssueHistoryStatus;
    }

    public void setFranchiseIssueHistoryStatus(String franchiseIssueHistoryStatus) {
        this.franchiseIssueHistoryStatus = franchiseIssueHistoryStatus;
    }

    public MemberDTO getFranchiseIssueHistoryCompleter() {
        return franchiseIssueHistoryCompleter;
    }

    public void setFranchiseIssueHistoryCompleter(MemberDTO franchiseIssueHistoryCompleter) {
        this.franchiseIssueHistoryCompleter = franchiseIssueHistoryCompleter;
    }

    public Date getFranchiseIssueHistoryDate() {
        return franchiseIssueHistoryDate;
    }

    public void setFranchiseIssueHistoryDate(Date franchiseIssueHistoryDate) {
        this.franchiseIssueHistoryDate = franchiseIssueHistoryDate;
    }

    public MemberDTO getFranchiseIssueHistoryUpdateMember() {
        return franchiseIssueHistoryUpdateMember;
    }

    public void setFranchiseIssueHistoryUpdateMember(MemberDTO franchiseIssueHistoryUpdateMember) {
        this.franchiseIssueHistoryUpdateMember = franchiseIssueHistoryUpdateMember;
    }

    @Override
    public String toString() {
        return "IssueHistoryDTO{" +
                "franchiseIssueHistoryNo=" + franchiseIssueHistoryNo +
                ", issue=" + issue +
                ", franchiseIssueHistoryStatus='" + franchiseIssueHistoryStatus + '\'' +
                ", franchiseIssueHistoryCompleter=" + franchiseIssueHistoryCompleter +
                ", franchiseIssueHistoryDate=" + franchiseIssueHistoryDate +
                ", franchiseIssueHistoryUpdateMember=" + franchiseIssueHistoryUpdateMember +
                '}';
    }
}
