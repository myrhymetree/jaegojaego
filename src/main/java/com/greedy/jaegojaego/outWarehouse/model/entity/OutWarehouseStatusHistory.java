package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "OutWarehouseStatusHistory")
@Table(name = "OUT_WAREHOUSE_STATUS_HISTORY")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_STATUS_HISTORY_SEQ_GENERATOR",
        sequenceName = "OUT_WAREHOUSE_STATUS_HISTORY_NO"
)
@Getter
@IdClass(OutWarehouseStatusHistoryId.class)
public class OutWarehouseStatusHistory {

    @Id
    @Column(name = "OUT_WAREHOUSE_STATUS_HISTORY_NO")
    private int outWarehouseStatusHistoryNo;

    @Id
    @ManyToOne
    @JoinColumn(name = "OUT_WAREHOUSE_DIVISION_NO")
    private OutWarehouse outWarehouseDivisionNo;

    @Column(name = "OUT_WAREHOUSE_STATUS_NAME")
    private String outWarehouseStatusName;

    @Column(name = "OUT_WAREHOUSE_STATUS_DATE")
    private Date outWarehouseStatusDate;

    @Column(name = "OUT_WAREHOUSE_STATUS_AMOUNT")
    private int outWarehouseStatusAmount;

    public OutWarehouseStatusHistory() {}

    public OutWarehouseStatusHistory(int outWarehouseStatusHistoryNo, OutWarehouse outWarehouseDivisionNo, String outWarehouseStatusName, Date outWarehouseStatusDate, int outWarehouseStatusAmount) {
        this.outWarehouseStatusHistoryNo = outWarehouseStatusHistoryNo;
        this.outWarehouseDivisionNo = outWarehouseDivisionNo;
        this.outWarehouseStatusName = outWarehouseStatusName;
        this.outWarehouseStatusDate = outWarehouseStatusDate;
        this.outWarehouseStatusAmount = outWarehouseStatusAmount;
    }

    public int getOutWarehouseStatusHistoryNo() {
        return outWarehouseStatusHistoryNo;
    }

    public OutWarehouse getOutWarehouseDivisionNo() {
        return outWarehouseDivisionNo;
    }

    public String getOutWarehouseStatusName() {
        return outWarehouseStatusName;
    }

    public Date getOutWarehouseStatusDate() {
        return outWarehouseStatusDate;
    }

    public int getOutWarehouseStatusAmount() {
        return outWarehouseStatusAmount;
    }

    public void setOutWarehouseStatusHistoryNo(int outWarehouseStatusHistoryNo) {
        this.outWarehouseStatusHistoryNo = outWarehouseStatusHistoryNo;
    }

    public void setOutWarehouseDivisionNo(OutWarehouse outWarehouseDivisionNo) {
        this.outWarehouseDivisionNo = outWarehouseDivisionNo;
    }

    public void setOutWarehouseStatusName(String outWarehouseStatusName) {
        this.outWarehouseStatusName = outWarehouseStatusName;
    }

    public void setOutWarehouseStatusDate(Date outWarehouseStatusDate) {
        this.outWarehouseStatusDate = outWarehouseStatusDate;
    }

    public void setOutWarehouseStatusAmount(int outWarehouseStatusAmount) {
        this.outWarehouseStatusAmount = outWarehouseStatusAmount;
    }

    @Override
    public String toString() {
        return "OutWarehouseStatusHistory{" +
                "outWarehouseStatusHistoryNo=" + outWarehouseStatusHistoryNo +
//                ", outWarehouseDivisionNo=" + outWarehouseDivisionNo +
                ", outWarehouseStatusName='" + outWarehouseStatusName + '\'' +
                ", outWarehouseStatusDate=" + outWarehouseStatusDate +
                ", outWarehouseStatusAmount=" + outWarehouseStatusAmount +
                '}';
    }
}
