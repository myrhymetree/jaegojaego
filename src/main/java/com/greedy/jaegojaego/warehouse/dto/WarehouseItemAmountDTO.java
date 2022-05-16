package com.greedy.jaegojaego.warehouse.dto;

import com.greedy.jaegojaego.warehouse.entity.WarehouseItemAmount;
import com.greedy.jaegojaego.warehouse.entity.WarehouseItemInfo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class WarehouseItemAmountDTO {

    private WarehouseItemInfo warehouseItemInfo;
    private int warehouseItemAmount;

    public WarehouseItemAmountDTO() {}

    public WarehouseItemAmountDTO(WarehouseItemInfo warehouseItemInfo, int warehouseItemAmount) {
        this.warehouseItemInfo = warehouseItemInfo;
        this.warehouseItemAmount = warehouseItemAmount;
    }

    public WarehouseItemInfo getWarehouseItemInfo() {
        return warehouseItemInfo;
    }

    public void setWarehouseItemInfo(WarehouseItemInfo warehouseItemInfo) {
        this.warehouseItemInfo = warehouseItemInfo;
    }

    public int getWarehouseItemAmount() {
        return warehouseItemAmount;
    }

    public void setWarehouseItemAmount(int warehouseItemAmount) {
        this.warehouseItemAmount = warehouseItemAmount;
    }

    @Override
    public String toString() {
        return "WarehouseItemAmountDTO{" +
                "warehouseItemInfo=" + warehouseItemInfo +
                ", warehouseItemAmount=" + warehouseItemAmount +
                '}';
    }
}
