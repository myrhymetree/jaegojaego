package com.greedy.jaegojaego.warehouse.dto;

import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseListDTO;
import com.greedy.jaegojaego.warehouse.entity.Warehouse;
import com.greedy.jaegojaego.warehouse.entity.WarehouseItemInfo;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class WarehouseItemChangeHistoryDTO {

    private int itemChangeHistoryNo;
    private WarehouseItemInfoDTO itemInfoNo;
    private int itemChangeDivision;
    private int itemChangeAmount;
    private Integer itemDecrementReasonNo;
    private OutWarehouseListDTO outWarehouseNo;
    private WarehouseDTO warehouseNo;
    private String warehouseStatus;
    private String outWarehouseStatus;

    public WarehouseItemChangeHistoryDTO() {}

    public WarehouseItemChangeHistoryDTO(int itemChangeHistoryNo, WarehouseItemInfoDTO itemInfoNo, int itemChangeDivision, int itemChangeAmount, Integer itemDecrementReasonNo, OutWarehouseListDTO outWarehouseNo, WarehouseDTO warehouseNo, String warehouseStatus, String outWarehouseStatus) {
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

    public WarehouseItemInfoDTO getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(WarehouseItemInfoDTO itemInfoNo) {
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

    public OutWarehouseListDTO getOutWarehouseNo() {
        return outWarehouseNo;
    }

    public void setOutWarehouseNo(OutWarehouseListDTO outWarehouseNo) {
        this.outWarehouseNo = outWarehouseNo;
    }

    public WarehouseDTO getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(WarehouseDTO warehouseNo) {
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
        return "WarehouseItemChangeHistoryDTO{" +
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
