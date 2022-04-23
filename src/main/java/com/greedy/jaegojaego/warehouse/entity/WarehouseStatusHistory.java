package com.greedy.jaegojaego.warehouse.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "warehouseStatusHistory")
@Table(name = "IN_WAREHOUSE_STATUS_HISTORY")
@SequenceGenerator(
        name = "IN_WAREHOUSE_STATUS_HISTORY_SEQ_GENERATOR",
        sequenceName = "IN_WAREHOUSE_STATUS_HISTORY_NO"
)
public class WarehouseStatusHistory implements Serializable {

    @Column(name = "IN_WAREHOUSE_STATUS_NAME")
    private String warehouseStatusName;

    @Column(name = "IN_WAREHOUSE_STATUS_HISTORY_DATE")
    private java.sql.Date warehouseHistoryDate;

    @Id
    @ManyToOne
    @JoinColumn(name = "IN_WAREHOUSE_NO")
    private Warehouse warehouseNo;

    @Column(name = "IN_WAREHOUSE_STATUS_AMOUNT")
    private int warehouseStatusAmount;

    @Id
    @Column(name = "IN_WAREHOUSE_STATUS_HISTORY_NO")
    private int warehouseStatusHistoryNo;

    public WarehouseStatusHistory() {}

    public WarehouseStatusHistory(String warehouseStatusName, Date warehouseHistoryDate, Warehouse warehouseNo, int warehouseStatusAmount, int warehouseStatusHistoryNo) {
        this.warehouseStatusName = warehouseStatusName;
        this.warehouseHistoryDate = warehouseHistoryDate;
        this.warehouseNo = warehouseNo;
        this.warehouseStatusAmount = warehouseStatusAmount;
        this.warehouseStatusHistoryNo = warehouseStatusHistoryNo;
    }

    public String getWarehouseStatusName() {
        return warehouseStatusName;
    }

    public void setWarehouseStatusName(String warehouseStatusName) {
        this.warehouseStatusName = warehouseStatusName;
    }

    public Date getWarehouseHistoryDate() {
        return warehouseHistoryDate;
    }

    public void setWarehouseHistoryDate(Date warehouseHistoryDate) {
        this.warehouseHistoryDate = warehouseHistoryDate;
    }

    public Warehouse getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(Warehouse warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public int getWarehouseStatusAmount() {
        return warehouseStatusAmount;
    }

    public void setWarehouseStatusAmount(int warehouseStatusAmount) {
        this.warehouseStatusAmount = warehouseStatusAmount;
    }

    public int getWarehouseStatusHistoryNo() {
        return warehouseStatusHistoryNo;
    }

    public void setWarehouseStatusHistoryNo(int warehouseStatusHistoryNo) {
        this.warehouseStatusHistoryNo = warehouseStatusHistoryNo;
    }

    @Override
    public String toString() {
        return "WarehouseStatusHistory{" +
                "warehouseStatusName='" + warehouseStatusName + '\'' +
                ", warehouseHistoryDate=" + warehouseHistoryDate +
                ", warehouseNo=" + warehouseNo +
                ", warehouseStatusAmount=" + warehouseStatusAmount +
                ", warehouseStatusHistoryNo=" + warehouseStatusHistoryNo +
                '}';
    }
}
