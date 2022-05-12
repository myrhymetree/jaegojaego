package com.greedy.jaegojaego.warehouse.entity;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouse;
import com.greedy.jaegojaego.warehouse.dto.WarehouseDTO;
import com.greedy.jaegojaego.warehouse.dto.WarehouseItemChangeHistoryDTO;
import com.greedy.jaegojaego.warehouse.dto.WarehouseItemInfoDTO;

import javax.persistence.*;

@Entity(name = "warehouseItemChangeHistory")
@Table(name = "ITEM_CHANGE_HISTORY")
@SequenceGenerator(
        name = "ITEM_CHANGE_HISTORY_SEQ_GENERATOR",
        sequenceName = "ITEM_CHANGE_HISTORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class WarehouseItemChangeHistory {

    @Id
    @Column(name = "ITEM_CHANGE_HISTORY_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_CHANGE_HISTORY_SEQ_GENERATOR"
    )
    private int itemChangeHistoryNo;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private WarehouseItemInfo itemInfoNo;

    @Column(name = "ITEM_CHANGE_HISTORY_DIVISION")
    private int itemChangeDivision;

    @Column(name = "ITEM_CHANGE_HISTORY_AMOUNT")
    private int itemChangeAmount;

    @Column(name = "ITEM_DECREMENT_REASON_NO")
    private Integer itemDecrementReasonNo;

    @ManyToOne
    @JoinColumn(name = "OUT_WAREHOUSE_NO")
    private OutWarehouse outWarehouseNo;

    @ManyToOne
    @JoinColumn(name = "IN_WAREHOUSE_NO")
    private Warehouse warehouseNo;

    @Column(name = "IN_WAREHOUSE_STATUS")
    private String warehouseStatus;

    @Column(name = "OUT_WAREHOUSE_STATUS")
    private String outWarehouseStatus;

    public WarehouseItemChangeHistory() {}

    public WarehouseItemChangeHistory(int itemChangeHistoryNo, WarehouseItemInfo itemInfoNo, int itemChangeDivision, int itemChangeAmount, Integer itemDecrementReasonNo, OutWarehouse outWarehouseNo, Warehouse warehouseNo, String warehouseStatus, String outWarehouseStatus) {
        this.itemChangeHistoryNo = itemChangeHistoryNo;
        this.itemInfoNo = itemInfoNo;
        this.itemChangeDivision = itemChangeDivision;
        this.itemChangeAmount = itemChangeAmount;
        this.itemDecrementReasonNo = itemDecrementReasonNo;
        this.outWarehouseNo = outWarehouseNo;
        this.warehouseNo = warehouseNo;
        this.warehouseStatus = warehouseStatus;
        this.outWarehouseStatus = outWarehouseStatus;
    }

    public int getItemChangeHistoryNo() {
        return itemChangeHistoryNo;
    }

    public void setItemChangeHistoryNo(int itemChangeHistoryNo) {
        this.itemChangeHistoryNo = itemChangeHistoryNo;
    }

    public WarehouseItemInfo getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(WarehouseItemInfo itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public int getItemChangeDivision() {
        return itemChangeDivision;
    }

    public void setItemChangeDivision(int itemChangeDivision) {
        this.itemChangeDivision = itemChangeDivision;
    }

    public int getItemChangeAmount() {
        return itemChangeAmount;
    }

    public void setItemChangeAmount(int itemChangeAmount) {
        this.itemChangeAmount = itemChangeAmount;
    }

    public Integer getItemDecrementReasonNo() {
        return itemDecrementReasonNo;
    }

    public void setItemDecrementReasonNo(Integer itemDecrementReasonNo) {
        this.itemDecrementReasonNo = itemDecrementReasonNo;
    }

    public OutWarehouse getOutWarehouseNo() {
        return outWarehouseNo;
    }

    public void setOutWarehouseNo(OutWarehouse outWarehouseNo) {
        this.outWarehouseNo = outWarehouseNo;
    }

    public Warehouse getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(Warehouse warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public String getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(String warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    public String getOutWarehouseStatus() {
        return outWarehouseStatus;
    }

    public void setOutWarehouseStatus(String outWarehouseStatus) {
        this.outWarehouseStatus = outWarehouseStatus;
    }

    @Override
    public String toString() {
        return "WarehouseItemChangeHistory{" +
                "itemChangeHistoryNo=" + itemChangeHistoryNo +
                ", itemInfoNo=" + itemInfoNo +
                ", itemChangeDivision=" + itemChangeDivision +
                ", itemChangeAmount=" + itemChangeAmount +
                ", itemDecrementReasonNo=" + itemDecrementReasonNo +
                ", outWarehouseNo=" + outWarehouseNo +
                ", warehouseNo=" + warehouseNo +
                ", warehouseStatus='" + warehouseStatus + '\'' +
                ", outWarehouseStatus='" + outWarehouseStatus + '\'' +
                '}';
    }
}
