package com.greedy.jaegojaego.backlog.dto.OutWarehouseBacklog;

public class OutBacklogIssueItemDTO {
    private OutBacklogFranchiseIssueDTO issueNoForBacklog;
    private OutBacklogItemInfoDTO itemInfoNoForBacklog;

    public OutBacklogIssueItemDTO() {}

    public OutBacklogIssueItemDTO(OutBacklogFranchiseIssueDTO issueNoForBacklog, OutBacklogItemInfoDTO itemInfoNoForBacklog) {
        this.issueNoForBacklog = issueNoForBacklog;
        this.itemInfoNoForBacklog = itemInfoNoForBacklog;
    }

    public OutBacklogFranchiseIssueDTO getIssueNoForBacklog() {
        return issueNoForBacklog;
    }

    public void setIssueNoForBacklog(OutBacklogFranchiseIssueDTO issueNoForBacklog) {
        this.issueNoForBacklog = issueNoForBacklog;
    }

    public OutBacklogItemInfoDTO getItemInfoNoForBacklog() {
        return itemInfoNoForBacklog;
    }

    public void setItemInfoNoForBacklog(OutBacklogItemInfoDTO itemInfoNoForBacklog) {
        this.itemInfoNoForBacklog = itemInfoNoForBacklog;
    }

    @Override
    public String toString() {
        return "OutBacklogIssueItemDTO{" +
//                "issueNoForBacklog=" + issueNoForBacklog +
                ", itemInfoNoForBacklog=" + itemInfoNoForBacklog +
                '}';
    }
}
