package com.greedy.jaegojaego.backlog.entity.OutWarehouseBacklog;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "OutBacklogIssueItemEntity")
@Table(name = "ISSUE_ITEM")
public class OutBacklogIssueItem implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FRANCHISE_ISSUE_NO")
    private OutBacklogFranchiseIssue issueNoForBacklog;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_INFO_NO")
    private OutBacklogItemInfo itemInfoNoForBacklog;

    public OutBacklogIssueItem() {}

    public OutBacklogIssueItem(OutBacklogFranchiseIssue issueNoForBacklog, OutBacklogItemInfo itemInfoNoForBacklog) {
        this.issueNoForBacklog = issueNoForBacklog;
        this.itemInfoNoForBacklog = itemInfoNoForBacklog;
    }

    public OutBacklogFranchiseIssue getIssueNoForBacklog() {
        return issueNoForBacklog;
    }

    public void setIssueNoForBacklog(OutBacklogFranchiseIssue issueNoForBacklog) {
        this.issueNoForBacklog = issueNoForBacklog;
    }

    public OutBacklogItemInfo getItemInfoNoForBacklog() {
        return itemInfoNoForBacklog;
    }

    public void setItemInfoNoForBacklog(OutBacklogItemInfo itemInfoNoForBacklog) {
        this.itemInfoNoForBacklog = itemInfoNoForBacklog;
    }

    @Override
    public String toString() {
        return "OutBacklogIssueItem{" +
//                "issueNoForBacklog=" + issueNoForBacklog +
                "itemInfoNoForBacklog=" + itemInfoNoForBacklog +
                '}';
    }
}
