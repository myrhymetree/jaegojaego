package com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;

import javax.persistence.*;

@Entity(name = "InWarehouseBacklogEntity")
@Table(name = "COMPANY_IN_WAREHOUSE_ITEM_BACKLOG")
//한번 시퀀스 번호 만들어보자 왜 0이 나오는 지 부터 생각하자,, + 그냥 상태쪽에 다 입고대기만 넣어놓고 (띄우는거 먼저 생각하자)
public class InWarehouseBacklog { /* 입고 백로그! */
    
    @Id
    @Column(name = "COMPANY_IN_WAREHOUSE_ITEM_BACKLOG_NO")
    private int inWarehouseBacklogNo;

    @ManyToOne
    @JoinColumn(name = "IN_WAREHOUSE_DIVISION_NO")
    private BacklogInWarehouse inWarehouseDivisionNo;

    public InWarehouseBacklog() {}

    public InWarehouseBacklog(int inWarehouseBacklogNo, BacklogInWarehouse inWarehouseDivisionNo) {
        this.inWarehouseBacklogNo = inWarehouseBacklogNo;
        this.inWarehouseDivisionNo = inWarehouseDivisionNo;
    }

    public int getInWarehouseBacklogNo() {
        return inWarehouseBacklogNo;
    }

    public void setInWarehouseBacklogNo(int inWarehouseBacklogNo) {
        this.inWarehouseBacklogNo = inWarehouseBacklogNo;
    }

    public BacklogInWarehouse getInWarehouseDivisionNo() {
        return inWarehouseDivisionNo;
    }

    public void setInWarehouseDivisionNo(BacklogInWarehouse inWarehouseDivisionNo) {
        this.inWarehouseDivisionNo = inWarehouseDivisionNo;
    }

    @Override
    public String toString() {
        return "InWarehouseBacklog{" +
                "inWarehouseBacklogNo=" + inWarehouseBacklogNo +
                ", inWarehouseDivisionNo=" + inWarehouseDivisionNo +
                '}';
    }
}
