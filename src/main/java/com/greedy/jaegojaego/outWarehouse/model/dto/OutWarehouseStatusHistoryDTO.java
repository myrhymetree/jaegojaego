package com.greedy.jaegojaego.outWarehouse.model.dto;

import java.sql.Date;

public class OutWarehouseStatusHistoryDTO {

    private int outWarehouseStatusHistoryNo;
    private String outWarehouseStatusName;
    private Date outWarehouseStatusDate;

    public OutWarehouseStatusHistoryDTO() {}

    public OutWarehouseStatusHistoryDTO(int outWarehouseStatusHistoryNo, String outWarehouseStatusName, Date outWarehouseStatusDate) {
        this.outWarehouseStatusHistoryNo = outWarehouseStatusHistoryNo;
        this.outWarehouseStatusName = outWarehouseStatusName;
        this.outWarehouseStatusDate = outWarehouseStatusDate;
    }

    public int getOutWarehouseStatusHistoryNo() {
        return outWarehouseStatusHistoryNo;
    }

    public String getOutWarehouseStatusName() {
        return outWarehouseStatusName;
    }

    public Date getOutWarehouseStatusDate() {
        return outWarehouseStatusDate;
    }

    public void setOutWarehouseStatusHistoryNo(int outWarehouseStatusHistoryNo) {
        this.outWarehouseStatusHistoryNo = outWarehouseStatusHistoryNo;
    }

    public void setOutWarehouseStatusName(String outWarehouseStatusName) {
        this.outWarehouseStatusName = outWarehouseStatusName;
    }

    public void setOutWarehouseStatusDate(Date outWarehouseStatusDate) {
        this.outWarehouseStatusDate = outWarehouseStatusDate;
    }

    @Override
    public String toString() {
        return "OutWarehouseStatusHistoryDTO{" +
                "outWarehouseStatusHistoryNo=" + outWarehouseStatusHistoryNo +
                ", outWarehouseStatusName='" + outWarehouseStatusName + '\'' +
                ", outWarehouseStatusDate=" + outWarehouseStatusDate +
                '}';
    }
}
