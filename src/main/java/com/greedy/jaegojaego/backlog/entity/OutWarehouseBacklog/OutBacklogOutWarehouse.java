package com.greedy.jaegojaego.backlog.entity.OutWarehouseBacklog;

import com.greedy.jaegojaego.backlog.dto.OutWarehouseBacklog.OutBacklogFranchiseIssueDTO;

import javax.persistence.*;

@Entity(name = "OutBacklogOutWarehouseEntity")
@Table(name = "OUT_WAREHOUSE")
public class OutBacklogOutWarehouse {

    @Id
    @Column(name = "OUT_WAREHOUSE_NO")
    private int outWarehouseNo;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ISSUE_NO")
    private OutBacklogFranchiseIssue issueNoForBacklog;

    public OutBacklogOutWarehouse() {}

    public OutBacklogOutWarehouse(int outWarehouseNo, OutBacklogFranchiseIssue issueNoForBacklog) {
        this.outWarehouseNo = outWarehouseNo;
        this.issueNoForBacklog = issueNoForBacklog;
    }

    public int getOutWarehouseNo() {
        return outWarehouseNo;
    }

    public void setOutWarehouseNo(int outWarehouseNo) {
        this.outWarehouseNo = outWarehouseNo;
    }

    public OutBacklogFranchiseIssue getIssueNoForBacklog() {
        return issueNoForBacklog;
    }

    public void setIssueNoForBacklog(OutBacklogFranchiseIssue issueNoForBacklog) {
        this.issueNoForBacklog = issueNoForBacklog;
    }

    @Override
    public String toString() {
        return "OutBacklogOutWarehouse{" +
                "outWarehouseNo=" + outWarehouseNo +
                ", issueNoForBacklog=" + issueNoForBacklog +
                '}';
    }
}
