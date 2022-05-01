package com.greedy.jaegojaego.backlog.entity;

import com.greedy.jaegojaego.backlog.dto.BacklogInWarehouseDTO;

import javax.persistence.*;

@Entity(name = "InWarehouseBacklogEntity")
@Table(name = "COMPANY_IN_WAREHOUSE_ITEM_BACKLOG")
public class InWarehouseBacklog { /* 입고 백로그! */
    
    @Id
    @Column(name = "COMPANY_IN_WAREHOUSE_ITEM_BACKLOG_NO")
    private int inwarehouseBacklogNo;

    @ManyToOne
    @JoinColumn(name = "IN_WAREHOUSE_DIVISION_NO")
    private BacklogInWarehouse inWarehouseNo;

    public InWarehouseBacklog() {}

    public InWarehouseBacklog(int inwarehouseBacklogNo, BacklogInWarehouse inWarehouseNo) {
        this.inwarehouseBacklogNo = inwarehouseBacklogNo;
        this.inWarehouseNo = inWarehouseNo;
    }

    public int getInwarehouseBacklogNo() {
        return inwarehouseBacklogNo;
    }

    public void setInwarehouseBacklogNo(int inwarehouseBacklogNo) {
        this.inwarehouseBacklogNo = inwarehouseBacklogNo;
    }

    public BacklogInWarehouse getInWarehouseNo() {
        return inWarehouseNo;
    }

    public void setInWarehouseNo(BacklogInWarehouse inWarehouseNo) {
        this.inWarehouseNo = inWarehouseNo;
    }

    @Override
    public String toString() {
        return "InWarehouseBacklog{" +
                "inwarehouseBacklogNo=" + inwarehouseBacklogNo +
                ", inWarehouseNo=" + inWarehouseNo +
                '}';
    }
}
