package com.greedy.jaegojaego.backlog.dto.OutWarehouseBacklog;

public class OutBacklogOutWarehouseDTO { //출고
    private int outWarehouseNo;
    private OutBacklogFranchiseIssueDTO issueNoForBacklog;

    public OutBacklogOutWarehouseDTO() {}

    public OutBacklogOutWarehouseDTO(int outWarehouseNo, OutBacklogFranchiseIssueDTO issueNoForBacklog) {
        this.outWarehouseNo = outWarehouseNo;
        this.issueNoForBacklog = issueNoForBacklog;
    }

    public int getOutWarehouseNo() {
        return outWarehouseNo;
    }

    public void setOutWarehouseNo(int outWarehouseNo) {
        this.outWarehouseNo = outWarehouseNo;
    }

    public OutBacklogFranchiseIssueDTO getIssueNoForBacklog() {
        return issueNoForBacklog;
    }

    public void setIssueNoForBacklog(OutBacklogFranchiseIssueDTO issueNoForBacklog) {
        this.issueNoForBacklog = issueNoForBacklog;
    }

    @Override
    public String toString() {
        return "OutBacklogOutWarehouseDTO{" +
                "outWarehouseNo=" + outWarehouseNo +
                ", issueNoForBacklog=" + issueNoForBacklog +
                '}';
    }
}
