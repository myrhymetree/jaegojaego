package com.greedy.jaegojaego.issue.issue.model.entity;

import com.greedy.jaegojaego.issue.company.model.entity.IssueCompanyAccount;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueItemDTO;
import com.greedy.jaegojaego.member.model.entity.Member;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "franchiseIssue")
@Table(name = "FRANCHISE_ISSUE")
@SequenceGenerator(
        name = "ISSUE_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_ISSUE_NO",
        initialValue = 1,
        allocationSize = 1
)
public class Issue {

    @Id
    @Column(name = "FRANCHISE_ISSUE_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ISSUE_SEQ_GENERATOR"
    )
    private int franchiseIssueNo;

    @Column(name = "FRANCHISE_ISSUE_TITLE")
    private String franchiseIssueTitle;

    @Column(name = "FRANCHISE_ISSUE_BODY")
    private String franchiseIssueBody;

    @Column(name = "FRANCHISE_ISSUE_CREATED_DATE")
    private java.sql.Date franchiseIssueCreatedDate;

    @Column(name = "FRANCHISE_ISSUE_STATUS_FINISH_DATE")
    private java.sql.Date franchiseIssueStatusFinishDate;

    @Column(name = "FRANCHISE_ISSUE_STATUS")
    private String franchiseIssueStatus;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ISSUE_COMPLETER")
    private IssueCompanyAccount franchiseIssueCompleter;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ISSUE_PRESENTER")
    private Member franchiseIssuePresenter;

    @OneToMany
    @JoinColumn(name = "FRANCHISE_ISSUE_NO")
    private List<IssueItem> issueItemList;

    public Issue() {
    }

    public Issue(int franchiseIssueNo, String franchiseIssueTitle, String franchiseIssueBody, Date franchiseIssueCreatedDate, Date franchiseIssueStatusFinishDate, String franchiseIssueStatus, IssueCompanyAccount franchiseIssueCompleter, Member franchiseIssuePresenter, List<IssueItem> issueItemList) {
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

    public IssueCompanyAccount getFranchiseIssueCompleter() {
        return franchiseIssueCompleter;
    }

    public void setFranchiseIssueCompleter(IssueCompanyAccount franchiseIssueCompleter) {
        this.franchiseIssueCompleter = franchiseIssueCompleter;
    }

    public Member getFranchiseIssuePresenter() {
        return franchiseIssuePresenter;
    }

    public void setFranchiseIssuePresenter(Member franchiseIssuePresenter) {
        this.franchiseIssuePresenter = franchiseIssuePresenter;
    }

    public List<IssueItem> getIssueItemList() {
        return issueItemList;
    }

    public void setIssueItemList(List<IssueItem> issueItemList) {
        this.issueItemList = issueItemList;
    }

    @Override
    public String toString() {
        return "Issue{" +
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
