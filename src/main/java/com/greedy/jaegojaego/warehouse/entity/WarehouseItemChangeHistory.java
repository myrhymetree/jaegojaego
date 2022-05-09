package com.greedy.jaegojaego.warehouse.entity;

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

    @Column(name = "OUT_WAREHOUSE_DIVISION_NO")
    private String outWarehouseDivisionNo;

    @ManyToOne
    @JoinColumn(name = "IN_WAREHOUSE_NO")
    private Warehouse warehouseNo;

    @Column(name = "IN_WAREHOUSE_STATUS")
    private String warehouseStatus;

    public WarehouseItemChangeHistory() {}

    public WarehouseItemChangeHistory(int itemChangeHistoryNo, WarehouseItemInfo itemInfoNo, int itemChangeDivision, int itemChangeAmount, Integer itemDecrementReasonNo, String outWarehouseDivisionNo, Warehouse warehouseNo, String warehouseStatus) {
        this.itemChangeHistoryNo = itemChangeHistoryNo;
        this.itemInfoNo = itemInfoNo;
        this.itemChangeDivision = itemChangeDivision;
        this.itemChangeAmount = itemChangeAmount;
        this.itemDecrementReasonNo = itemDecrementReasonNo;
        this.outWarehouseDivisionNo = outWarehouseDivisionNo;
        this.warehouseNo = warehouseNo;
        this.warehouseStatus = warehouseStatus;
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

    public String getOutWarehouseDivisionNo() {
        return outWarehouseDivisionNo;
    }

    public void setOutWarehouseDivisionNo(String outWarehouseDivisionNo) {
        this.outWarehouseDivisionNo = outWarehouseDivisionNo;
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

    @Override
    public String toString() {
        return "WarehouseItemChangeHistory{" +
                "itemChangeHistoryNo=" + itemChangeHistoryNo +
                ", itemInfoNo=" + itemInfoNo +
                ", itemChangeDivision=" + itemChangeDivision +
                ", itemChangeAmount=" + itemChangeAmount +
                ", itemDecrementReasonNo=" + itemDecrementReasonNo +
                ", outWarehouseDivisionNo='" + outWarehouseDivisionNo + '\'' +
                ", warehouseNo=" + warehouseNo +
                ", warehouseStatus='" + warehouseStatus + '\'' +
                '}';
    }
}
