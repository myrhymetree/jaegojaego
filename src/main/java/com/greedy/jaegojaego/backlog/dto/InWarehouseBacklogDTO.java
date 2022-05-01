package com.greedy.jaegojaego.backlog.dto;

public class InWarehouseBacklogDTO {
    /* 입고 백로그 */
    private int inwarehouseBacklogNo;
    private BacklogInWarehouseDTO inWarehouseNo;

    public InWarehouseBacklogDTO() {}

    public InWarehouseBacklogDTO(int inwarehouseBacklogNo, BacklogInWarehouseDTO inWarehouseNo) {
        this.inwarehouseBacklogNo = inwarehouseBacklogNo;
        this.inWarehouseNo = inWarehouseNo;
    }

    public int getInwarehouseBacklogNo() {
        return inwarehouseBacklogNo;
    }

    public void setInwarehouseBacklogNo(int inwarehouseBacklogNo) {
        this.inwarehouseBacklogNo = inwarehouseBacklogNo;
    }

    public BacklogInWarehouseDTO getInWarehouseNo() {
        return inWarehouseNo;
    }

    public void setInWarehouseNo(BacklogInWarehouseDTO inWarehouseNo) {
        this.inWarehouseNo = inWarehouseNo;
    }

    @Override
    public String toString() {
        return "InWarehouseBacklogDTO{" +
                "inwarehouseBacklogNo=" + inwarehouseBacklogNo +
                ", inWarehouseNo=" + inWarehouseNo +
                '}';
    }
}
