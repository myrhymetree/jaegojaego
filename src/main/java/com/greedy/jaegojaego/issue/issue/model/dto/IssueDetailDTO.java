package com.greedy.jaegojaego.issue.issue.model.dto;

import com.greedy.jaegojaego.issue.company.model.dto.IssueCompanyAccountDTO;
import com.greedy.jaegojaego.issue.franchise.model.dto.IssueFranchiseAccountDTO;
import com.greedy.jaegojaego.issue.franchise.model.dto.IssueFranchiseInfoDTO;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;

import java.sql.Date;
import java.util.List;

public class IssueDetailDTO {

    private int franchiseIssueNo;
    private String franchiseIssueTitle;
    private String franchiseIssueBody;
    private java.sql.Date franchiseIssueCreatedDate;
    private java.sql.Date franchiseIssueStatusFinishDate;
    private String franchiseIssueStatus;
    private IssueCompanyAccountDTO franchiseIssueCompleter;
    private MemberDTO franchiseIssuePresenter;
    private IssueFranchiseInfoDTO issueFranchiseInfo;
    private IssueFranchiseAccountDTO issueFranchiseAccount;
    private List<IssueItemDTO> issueItemList;
    private List<String> issueFileList;

    public IssueDetailDTO() {
    }

    public IssueDetailDTO(int franchiseIssueNo, String franchiseIssueTitle, String franchiseIssueBody, Date franchiseIssueCreatedDate, Date franchiseIssueStatusFinishDate, String franchiseIssueStatus, IssueCompanyAccountDTO franchiseIssueCompleter, MemberDTO franchiseIssuePresenter, IssueFranchiseInfoDTO issueFranchiseInfo, IssueFranchiseAccountDTO issueFranchiseAccount, List<IssueItemDTO> issueItemList, List<String> issueFileList) {
        this.franchiseIssueNo = franchiseIssueNo;
        this.franchiseIssueTitle = franchiseIssueTitle;
        this.franchiseIssueBody = franchiseIssueBody;
        this.franchiseIssueCreatedDate = franchiseIssueCreatedDate;
        this.franchiseIssueStatusFinishDate = franchiseIssueStatusFinishDate;
        this.franchiseIssueStatus = franchiseIssueStatus;
        this.franchiseIssueCompleter = franchiseIssueCompleter;
        this.franchiseIssuePresenter = franchiseIssuePresenter;
        this.issueFranchiseInfo = issueFranchiseInfo;
        this.issueFranchiseAccount = issueFranchiseAccount;
        this.issueItemList = issueItemList;
        this.issueFileList = issueFileList;
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

    public IssueFranchiseInfoDTO getIssueFranchiseInfo() {
        return issueFranchiseInfo;
    }

    public void setIssueFranchiseInfo(IssueFranchiseInfoDTO issueFranchiseInfo) {
        this.issueFranchiseInfo = issueFranchiseInfo;
    }

    public IssueFranchiseAccountDTO getIssueFranchiseAccount() {
        return issueFranchiseAccount;
    }

    public void setIssueFranchiseAccount(IssueFranchiseAccountDTO issueFranchiseAccount) {
        this.issueFranchiseAccount = issueFranchiseAccount;
    }

    public List<IssueItemDTO> getIssueItemList() {
        return issueItemList;
    }

    public void setIssueItemList(List<IssueItemDTO> issueItemList) {
        this.issueItemList = issueItemList;
    }

    public List<String> getIssueFileList() {
        return issueFileList;
    }

    public void setIssueFileList(List<String> issueFileList) {
        this.issueFileList = issueFileList;
    }

    @Override
    public String toString() {
        return "IssueDetailDTO{" +
                "franchiseIssueNo=" + franchiseIssueNo +
                ", franchiseIssueTitle='" + franchiseIssueTitle + '\'' +
                ", franchiseIssueBody='" + franchiseIssueBody + '\'' +
                ", franchiseIssueCreatedDate=" + franchiseIssueCreatedDate +
                ", franchiseIssueStatusFinishDate=" + franchiseIssueStatusFinishDate +
                ", franchiseIssueStatus='" + franchiseIssueStatus + '\'' +
                ", franchiseIssueCompleter=" + franchiseIssueCompleter +
                ", franchiseIssuePresenter=" + franchiseIssuePresenter +
                ", issueFranchiseInfo=" + issueFranchiseInfo +
                ", issueFranchiseAccount=" + issueFranchiseAccount +
                ", issueItemList=" + issueItemList +
                ", issueFileList=" + issueFileList +
                '}';
    }
}
