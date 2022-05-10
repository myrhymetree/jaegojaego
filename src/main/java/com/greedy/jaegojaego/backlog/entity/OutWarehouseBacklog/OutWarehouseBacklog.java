package com.greedy.jaegojaego.backlog.entity.OutWarehouseBacklog;

import com.greedy.jaegojaego.backlog.dto.OutWarehouseBacklog.OutBacklogOutWarehouseDTO;

import javax.persistence.*;

@Entity(name = "OutWarehouseBacklogEntity")
@Table(name = "COMPANY_ISSUE_RELEASE_BACKLOG")
public class OutWarehouseBacklog {

    @Id
    @Column(name = "COMPANY_ISSUE_RELEASE_BACKLOG_NO")
    private int outWarehouseBacklogNo;

    @ManyToOne
    @JoinColumn(name = "OUT_WAREHOUSE_DIVISION_NO")
    private OutBacklogOutWarehouse outWarehouseNoForBacklog;

    public OutWarehouseBacklog() {}

    public OutWarehouseBacklog(int outWarehouseBacklogNo, OutBacklogOutWarehouse outWarehouseNoForBacklog) {
        this.outWarehouseBacklogNo = outWarehouseBacklogNo;
        this.outWarehouseNoForBacklog = outWarehouseNoForBacklog;
    }

    public int getOutWarehouseBacklogNo() {
        return outWarehouseBacklogNo;
    }

    public void setOutWarehouseBacklogNo(int outWarehouseBacklogNo) {
        this.outWarehouseBacklogNo = outWarehouseBacklogNo;
    }

    public OutBacklogOutWarehouse getOutWarehouseNoForBacklog() {
        return outWarehouseNoForBacklog;
    }

    public void setOutWarehouseNoForBacklog(OutBacklogOutWarehouse outWarehouseNoForBacklog) {
        this.outWarehouseNoForBacklog = outWarehouseNoForBacklog;
    }

    @Override
    public String toString() {
        return "OutWarehouseBacklog{" +
                "outWarehouseBacklogNo=" + outWarehouseBacklogNo +
                ", outWarehouseNoForBacklog=" + outWarehouseNoForBacklog +
                '}';
    }
}
