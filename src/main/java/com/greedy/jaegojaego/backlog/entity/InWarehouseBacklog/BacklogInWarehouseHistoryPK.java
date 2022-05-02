package com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BacklogInWarehouseHistoryPK implements Serializable {

    @Column(name = "IN_WAREHOUSE_STATUS_HISTORY_NO")
    private int intWarehouseStatusHistoryNo;

    @ManyToOne
    @JoinColumn(name = "IN_WAREHOUSE_NO")
    private BacklogInWarehouse inWarehouseNoForHistory;

    public BacklogInWarehouseHistoryPK() {}

    public BacklogInWarehouseHistoryPK(int intWarehouseStatusHistoryNo, BacklogInWarehouse inWarehouseNoForHistory) {
        this.intWarehouseStatusHistoryNo = intWarehouseStatusHistoryNo;
        this.inWarehouseNoForHistory = inWarehouseNoForHistory;
    }

    public int getIntWarehouseStatusHistoryNo() {
        return intWarehouseStatusHistoryNo;
    }

    public void setIntWarehouseStatusHistoryNo(int intWarehouseStatusHistoryNo) {
        this.intWarehouseStatusHistoryNo = intWarehouseStatusHistoryNo;
    }

    public BacklogInWarehouse getInWarehouseNoForHistory() {
        return inWarehouseNoForHistory;
    }

    public void setInWarehouseNoForHistory(BacklogInWarehouse inWarehouseNoForHistory) {
        this.inWarehouseNoForHistory = inWarehouseNoForHistory;
    }

    @Override
    public String toString() {
        return "BacklogInWarehouseHistoryPK{" +
                "intWarehouseStatusHistoryNo=" + intWarehouseStatusHistoryNo +
//                ", inWarehouseNoForHistory=" + inWarehouseNoForHistory +
                '}';
    }
}
