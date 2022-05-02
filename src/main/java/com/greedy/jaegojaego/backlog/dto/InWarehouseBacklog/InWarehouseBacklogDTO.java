package com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog;

public class InWarehouseBacklogDTO {
    /* 입고 백로그 DTO */
    private int inWarehouseBacklogNo;
    private BacklogInWarehouseDTO inWarehouseDivisionNo;

    public InWarehouseBacklogDTO() {}

    public InWarehouseBacklogDTO(int inWarehouseBacklogNo, BacklogInWarehouseDTO inWarehouseDivisionNo) {
        this.inWarehouseBacklogNo = inWarehouseBacklogNo;
        this.inWarehouseDivisionNo = inWarehouseDivisionNo;
    }

    public int getInWarehouseBacklogNo() {
        return inWarehouseBacklogNo;
    }

    public void setInWarehouseBacklogNo(int inWarehouseBacklogNo) {
        this.inWarehouseBacklogNo = inWarehouseBacklogNo;
    }

    public BacklogInWarehouseDTO getInWarehouseDivisionNo() {
        return inWarehouseDivisionNo;
    }

    public void setInWarehouseDivisionNo(BacklogInWarehouseDTO inWarehouseDivisionNo) {
        this.inWarehouseDivisionNo = inWarehouseDivisionNo;
    }

    @Override
    public String toString() {
        return "InWarehouseBacklogDTO{" +
                "inWarehouseBacklogNo=" + inWarehouseBacklogNo +
                ", inWarehouseDivisionNo=" + inWarehouseDivisionNo +
                '}';
    }
}
