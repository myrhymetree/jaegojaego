package com.greedy.jaegojaego.warehouse.entity;

import lombok.*;

import java.io.Serializable;

public class WarehouseStatusHistoryPK implements Serializable {

    private int warehouseStatusHistoryNo;
    private Warehouse warehouseNo;

    public WarehouseStatusHistoryPK() {}

    public WarehouseStatusHistoryPK(int warehouseStatusHistoryNo, Warehouse warehouseNo) {
        this.warehouseStatusHistoryNo = warehouseStatusHistoryNo;
        this.warehouseNo = warehouseNo;
    }

    public int getWarehouseStatusHistoryNo() {
        return warehouseStatusHistoryNo;
    }

    public void setWarehouseStatusHistoryNo(int warehouseStatusHistoryNo) {
        this.warehouseStatusHistoryNo = warehouseStatusHistoryNo;
    }

    public Warehouse getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(Warehouse warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    @Override
    public String toString() {
        return "WarehouseStatusHistoryPK{" +
                "warehouseStatusHistoryNo=" + warehouseStatusHistoryNo +
                ", warehouseNo=" + warehouseNo +
                '}';
    }
}
