package com.greedy.jaegojaego.backlog.entity.OutWarehouseBacklog;

import com.greedy.jaegojaego.backlog.dto.OutWarehouseBacklog.OutBacklogIssueItemDTO;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "OutBacklogFranchiseIssueEntity")
@Table(name = "FRANCHISE_ISSUE")
public class OutBacklogFranchiseIssue {

    @Id
    @Column(name = "FRANCHISE_ISSUE_NO")
    private int issueNo;

    @Column(name = "FRANCHISE_ISSUE_TITLE")
    private String issueTitle;

    @Column(name = "FRANCHISE_ISSUE_CREATED_DATE")
    private Date issueCreatedDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "FRANCHISE_ISSUE_NO")
    private List<OutBacklogIssueItem> issueItemDTOList; //OneToMany

    public OutBacklogFranchiseIssue() {}

    public OutBacklogFranchiseIssue(int issueNo, String issueTitle, Date issueCreatedDate, List<OutBacklogIssueItem> issueItemDTOList) {
        this.issueNo = issueNo;
        this.issueTitle = issueTitle;
        this.issueCreatedDate = issueCreatedDate;
        this.issueItemDTOList = issueItemDTOList;
    }

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public Date getIssueCreatedDate() {
        return issueCreatedDate;
    }

    public void setIssueCreatedDate(Date issueCreatedDate) {
        this.issueCreatedDate = issueCreatedDate;
    }

    public List<OutBacklogIssueItem> getIssueItemDTOList() {
        return issueItemDTOList;
    }

    public void setIssueItemDTOList(List<OutBacklogIssueItem> issueItemDTOList) {
        this.issueItemDTOList = issueItemDTOList;
    }

    @Override
    public String toString() {
        return "OutBacklogFranchiseIssue{" +
                "issueNo=" + issueNo +
                ", issueTitle='" + issueTitle + '\'' +
                ", issueCreatedDate=" + issueCreatedDate +
                ", issueItemDTOList=" + issueItemDTOList +
                '}';
    }
}
