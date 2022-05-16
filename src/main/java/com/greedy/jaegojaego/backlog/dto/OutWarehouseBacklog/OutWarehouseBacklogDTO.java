package com.greedy.jaegojaego.backlog.dto.OutWarehouseBacklog;

public class OutWarehouseBacklogDTO { //출고백로그
    private int outWarehouseBacklogNo;
    private OutBacklogOutWarehouseDTO outWarehouseNoForBacklog;

    public OutWarehouseBacklogDTO() {}

    public OutWarehouseBacklogDTO(int outWarehouseBacklogNo, OutBacklogOutWarehouseDTO outWarehouseNoForBacklog) {
        this.outWarehouseBacklogNo = outWarehouseBacklogNo;
        this.outWarehouseNoForBacklog = outWarehouseNoForBacklog;
    }

    public int getOutWarehouseBacklogNo() {
        return outWarehouseBacklogNo;
    }

    public void setOutWarehouseBacklogNo(int outWarehouseBacklogNo) {
        this.outWarehouseBacklogNo = outWarehouseBacklogNo;
    }

    public OutBacklogOutWarehouseDTO getOutWarehouseNoForBacklog() {
        return outWarehouseNoForBacklog;
    }

    public void setOutWarehouseNoForBacklog(OutBacklogOutWarehouseDTO outWarehouseNoForBacklog) {
        this.outWarehouseNoForBacklog = outWarehouseNoForBacklog;
    }

    @Override
    public String toString() {
        return "OutWarehouseBacklogDTO{" +
                "outWarehouseBacklogNo=" + outWarehouseBacklogNo +
                ", outWarehouseNoForBacklog=" + outWarehouseNoForBacklog +
                '}';
    }
}
