package com.greedy.jaegojaego.issue.issue.model.dto;

import com.greedy.jaegojaego.issue.company.model.dto.IssueCompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;

import java.sql.Date;
import java.util.List;

public class IssueDTO {

    private int franchiseIssueNo;
    private String franchiseIssueTitle;
    private String franchiseIssueBody;
    private java.sql.Date franchiseIssueCreatedDate;
    private java.sql.Date franchiseIssueStatusFinishDate;
    private String franchiseIssueStatus;
    private IssueCompanyAccountDTO franchiseIssueCompleter;
    private MemberDTO franchiseIssuePresenter;
    private List<IssueItemDTO> issueItemList;

    public IssueDTO() {
    }

    public IssueDTO(int franchiseIssueNo, String franchiseIssueTitle, String franchiseIssueBody, Date franchiseIssueCreatedDate, Date franchiseIssueStatusFinishDate, String franchiseIssueStatus, IssueCompanyAccountDTO franchiseIssueCompleter, MemberDTO franchiseIssuePresenter, List<IssueItemDTO> issueItemList) {
        this.franchiseIssueNo = franchiseIssueNo;
        this.franchiseIssueTitle = franchiseIssueTitle;
        this.franchiseIssueBody = franchiseIssueBody;
        this.franchiseIssueCreatedDate = franchiseIssueCreatedDate;
        this.franchiseIssueStatusFinishDate = franchiseIssueStatusFinishDate;
        this.franchiseIssueStatus = franchiseIssueStatus;
        this.franchiseIssueCompleter = franchiseIssueCompleter;
        this.franchiseIssuePresenter = franchiseIssuePresenter;
        this.issueItemList = issueItemList;
    }

    public int getFranchiseIssueNo() {
        return franchiseIssueNo;
    }

    public void setFranchiseIssueNo(int franchiseIssueNo) {
        this.franchiseIssueNo = franchiseIssueNo;
    }

    public String getFranchiseIssueTitle() {
        return franchiseIssueTitle;
    }

    public void setFranchiseIssueTitle(String franchiseIssueTitle) {
        this.franchiseIssueTitle = franchiseIssueTitle;
    }

    public String getFranchiseIssueBody() {
        return franchiseIssueBody;
    }

    public void setFranchiseIssueBody(String franchiseIssueBody) {
        this.franchiseIssueBody = franchiseIssueBody;
    }

    public Date getFranchiseIssueCreatedDate() {
        return franchiseIssueCreatedDate;
    }

    public void setFranchiseIssueCreatedDate(Date franchiseIssueCreatedDate) {
        this.franchiseIssueCreatedDate = franchiseIssueCreatedDate;
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

    public IssueCompanyAccountDTO getFranchiseIssueCompleter() {
        return franchiseIssueCompleter;
    }

    public void setFranchiseIssueCompleter(IssueCompanyAccountDTO franchiseIssueCompleter) {
        this.franchiseIssueCompleter = franchiseIssueCompleter;
    }

    public MemberDTO getFranchiseIssuePresenter() {
        return franchiseIssuePresenter;
    }

    public void setFranchiseIssuePresenter(MemberDTO franchiseIssuePresenter) {
        this.franchiseIssuePresenter = franchiseIssuePresenter;
    }

    public List<IssueItemDTO> getIssueItemList() {
        return issueItemList;
    }

    public void setIssueItemList(List<IssueItemDTO> issueItemList) {
        this.issueItemList = issueItemList;
    }

    @Override
    public String toString() {
        return "IssueDTO{" +
                "franchiseIssueNo=" + franchiseIssueNo +
                ", franchiseIssueTitle='" + franchiseIssueTitle + '\'' +
                ", franchiseIssueBody='" + franchiseIssueBody + '\'' +
                ", franchiseIssueCreatedDate=" + franchiseIssueCreatedDate +
                ", franchiseIssueStatusFinishDate=" + franchiseIssueStatusFinishDate +
                ", franchiseIssueStatus='" + franchiseIssueStatus + '\'' +
                ", franchiseIssueCompleter=" + franchiseIssueCompleter +
                ", franchiseIssuePresenter=" + franchiseIssuePresenter +
                ", issueItemList=" + issueItemList +
                '}';
    }
}
