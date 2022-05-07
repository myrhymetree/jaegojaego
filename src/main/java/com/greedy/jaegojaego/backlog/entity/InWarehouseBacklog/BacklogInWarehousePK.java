package com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BacklogInWarehousePK implements Serializable {

    @Column(name = "IN_WAREHOUSE_NO")
    private int inWarehouseNo;

    @Column(name = "IN_WAREHOUSE_STATUS")
    private String inWarehouseStatus;    //입고 처리 상태 //pk

    public BacklogInWarehousePK() {}

    public BacklogInWarehousePK(int inWarehouseNo, String inWarehouseStatus) {
        this.inWarehouseNo = inWarehouseNo;
        this.inWarehouseStatus = inWarehouseStatus;
    }

    public int getInWarehouseNo() {
        return inWarehouseNo;
    }

    public void setInWarehouseNo(int inWarehouseNo) {
        this.inWarehouseNo = inWarehouseNo;
    }

    public String getInWarehouseStatus() {
        return inWarehouseStatus;
    }

    public void setInWarehouseStatus(String inWarehouseStatus) {
        this.inWarehouseStatus = inWarehouseStatus;
    }

    @Override
    public String toString() {
        return "BacklogInWarehousePK{" +
                "inWarehouseNo=" + inWarehouseNo +
                ", inWarehouseStatus='" + inWarehouseStatus + '\'' +
                '}';
    }
}
