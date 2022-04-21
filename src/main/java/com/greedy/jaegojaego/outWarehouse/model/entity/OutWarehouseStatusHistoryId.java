package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import java.io.Serializable;

public class OutWarehouseStatusHistoryId implements Serializable {

    private int outWarehouseStatusHistoryNo;
    private OutWarehouse outWarehouseDivisionNo;

    public OutWarehouseStatusHistoryId() {}

    public OutWarehouseStatusHistoryId(int outWarehouseStatusHistoryNo, OutWarehouse outWarehouseDivisionNo) {
        this.outWarehouseStatusHistoryNo = outWarehouseStatusHistoryNo;
        this.outWarehouseDivisionNo = outWarehouseDivisionNo;
    }

    public int getOutWarehouseStatusHistoryNo() {
        return outWarehouseStatusHistoryNo;
    }

    public OutWarehouse getOutWarehouseDivisionNo() {
        return outWarehouseDivisionNo;
    }

    public void setOutWarehouseStatusHistoryNo(int outWarehouseStatusHistoryNo) {
        this.outWarehouseStatusHistoryNo = outWarehouseStatusHistoryNo;
    }

    public void setOutWarehouseDivisionNo(OutWarehouse outWarehouseDivisionNo) {
        this.outWarehouseDivisionNo = outWarehouseDivisionNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseStatusHistoryId{" +
                "outWarehouseStatusHistoryNo=" + outWarehouseStatusHistoryNo +
                ", outWarehouseDivisionNo=" + outWarehouseDivisionNo +
                '}';
    }
}
