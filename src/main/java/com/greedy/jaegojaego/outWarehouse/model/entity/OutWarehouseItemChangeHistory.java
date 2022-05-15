package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;

@Entity(name = "outWarehouseItemChangeHistory")
@Table(name = "ITEM_CHANGE_HISTORY")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_ITEM_CHANGE_HISTORY_SEQ_GENERATOR",
        sequenceName = "ITEM_CHANGE_HISTORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OutWarehouseItemChangeHistory {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_ITEM_CHANGE_HISTORY_SEQ_GENERATOR"
    )
    @Column(name = "ITEM_CHANGE_HISTORY_NO")
    private int itemChangeHistoryNo;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OutWarehouseItemInfo itemInfoNo;

    @Column(name = "ITEM_CHANGE_HISTORY_DIVISION")
    private int itemChangeHistoryDivision;

    @Column(name = "ITEM_CHANGE_HISTORY_AMOUNT")
    private int itemChangeHistoryAmount;

    @ManyToOne
    @JoinColumn(name = "OUT_WAREHOUSE_NO")
    private OutWarehouse outWarehouseNo;

    @Column(name = "OUT_WAREHOUSE_STATUS")
    private String outWarehouseStatus;

    public OutWarehouseItemChangeHistory() {}

    public OutWarehouseItemChangeHistory(int itemChangeHistoryNo, OutWarehouseItemInfo itemInfoNo, int itemChangeHistoryDivision, int itemChangeHistoryAmount, OutWarehouse outWarehouseNo, String outWarehouseStatus) {
        this.itemChangeHistoryNo = itemChangeHistoryNo;
        this.itemInfoNo = itemInfoNo;
        this.itemChangeHistoryDivision = itemChangeHistoryDivision;
        this.itemChangeHistoryAmount = itemChangeHistoryAmount;
        this.outWarehouseNo = outWarehouseNo;
        this.outWarehouseStatus = outWarehouseStatus;
    }

    public int getItemChangeHistoryNo() {
        return itemChangeHistoryNo;
    }

    public void setItemChangeHistoryNo(int itemChangeHistoryNo) {
        this.itemChangeHistoryNo = itemChangeHistoryNo;
    }

    public OutWarehouseItemInfo getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(OutWarehouseItemInfo itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public int getItemChangeHistoryDivision() {
        return itemChangeHistoryDivision;
    }

    public void setItemChangeHistoryDivision(int itemChangeHistoryDivision) {
        this.itemChangeHistoryDivision = itemChangeHistoryDivision;
    }

    public int getItemChangeHistoryAmount() {
        return itemChangeHistoryAmount;
    }

    public void setItemChangeHistoryAmount(int itemChangeHistoryAmount) {
        this.itemChangeHistoryAmount = itemChangeHistoryAmount;
    }

    public OutWarehouse getOutWarehouseNo() {
        return outWarehouseNo;
    }

    public void setOutWarehouseNo(OutWarehouse outWarehouseNo) {
        this.outWarehouseNo = outWarehouseNo;
    }

    public String getOutWarehouseStatus() {
        return outWarehouseStatus;
    }

    public void setOutWarehouseStatus(String outWarehouseStatus) {
        this.outWarehouseStatus = outWarehouseStatus;
    }

    @Override
    public String toString() {
        return "OutWarehouseItemChangeHistory{" +
                "itemChangeHistoryNo=" + itemChangeHistoryNo +
                ", itemInfoNo=" + itemInfoNo +
                ", itemChangeHistoryDivision=" + itemChangeHistoryDivision +
                ", itemChangeHistoryAmount=" + itemChangeHistoryAmount +
                ", outWarehouseNo=" + outWarehouseNo +
                ", outWarehouseStatus='" + outWarehouseStatus + '\'' +
                '}';
    }
}
