package com.greedy.jaegojaego.backlog.dto.OutWarehouseBacklog;

import java.sql.Date;
import java.util.List;

public class OutBacklogFranchiseIssueDTO {
    private int issueNo;
    private String issueTitle;
    private Date issueCreatedDate;
    private List<OutBacklogIssueItemDTO> issueItemDTOList; //OneToMany

    public OutBacklogFranchiseIssueDTO() {}

    public OutBacklogFranchiseIssueDTO(int issueNo, String issueTitle, Date issueCreatedDate, List<OutBacklogIssueItemDTO> issueItemDTOList) {
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

    public List<OutBacklogIssueItemDTO> getIssueItemDTOList() {
        return issueItemDTOList;
    }

    public void setIssueItemDTOList(List<OutBacklogIssueItemDTO> issueItemDTOList) {
        this.issueItemDTOList = issueItemDTOList;
    }

    @Override
    public String toString() {
        return "OutBacklogFranchiseIssueDTO{" +
                "issueNo=" + issueNo +
                ", issueTitle='" + issueTitle + '\'' +
                ", issueCreatedDate=" + issueCreatedDate +
                ", issueItemDTOList=" + issueItemDTOList +
                '}';
    }
}
