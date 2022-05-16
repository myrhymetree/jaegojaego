package com.greedy.jaegojaego.warehouse.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "warehouseCompanyOrderItem")
@Table(name = "COMPANY_ORDER_ITEM")
public class WarehouseCompanyOrderItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private WarehouseItemInfo warehouseItemInfo;

    @Id
    @ManyToOne
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private WarehouseCompanyOrderHistory companyOrderHistory;

    @Column(name = "COMPANY_ORDER_ITEM_AMOUNT")
    private int companyOrderItemAmount;

    public WarehouseCompanyOrderItem() {}

    public WarehouseCompanyOrderItem(WarehouseItemInfo warehouseItemInfo, WarehouseCompanyOrderHistory companyOrderHistory, int companyOrderItemAmount) {
        this.warehouseItemInfo = warehouseItemInfo;
        this.companyOrderHistory = companyOrderHistory;
        this.companyOrderItemAmount = companyOrderItemAmount;
    }

    public WarehouseItemInfo getWarehouseItemInfo() {
        return warehouseItemInfo;
    }

    public void setWarehouseItemInfo(WarehouseItemInfo warehouseItemInfo) {
        this.warehouseItemInfo = warehouseItemInfo;
    }

    public WarehouseCompanyOrderHistory getCompanyOrderHistory() {
        return companyOrderHistory;
    }

    public void setCompanyOrderHistory(WarehouseCompanyOrderHistory companyOrderHistory) {
        this.companyOrderHistory = companyOrderHistory;
    }

    public int getCompanyOrderItemAmount() {
        return companyOrderItemAmount;
    }

    public void setCompanyOrderItemAmount(int companyOrderItemAmount) {
        this.companyOrderItemAmount = companyOrderItemAmount;
    }

    @Override
    public String toString() {
        return "WarehouseCompanyOrderItem{" +
                "warehouseItemInfo=" + warehouseItemInfo +
                ", companyOrderHistory=" + companyOrderHistory +
                ", companyOrderItemAmount=" + companyOrderItemAmount +
                '}';
    }
}
