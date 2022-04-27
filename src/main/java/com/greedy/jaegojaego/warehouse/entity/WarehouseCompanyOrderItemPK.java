//package com.greedy.jaegojaego.warehouse.entity;
//
//import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
//
//import javax.persistence.Embeddable;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import java.io.Serializable;
//
//@Embeddable
//public class WarehouseCompanyOrderItemPK implements Serializable {
//
//    @ManyToOne
//    @JoinColumn(name = "ITEM_INFO_NO")
//    private WarehouseItemInfo warehouseItemInfo;
//
//    @ManyToOne
//    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
//    private WarehouseCompanyOrderHistory warehouseCompanyOrderHistory;
//
//    public WarehouseCompanyOrderItemPK() {}
//
//    public WarehouseCompanyOrderItemPK(WarehouseItemInfo warehouseItemInfo, WarehouseCompanyOrderHistory warehouseCompanyOrderHistory) {
//        this.warehouseItemInfo = warehouseItemInfo;
//        this.warehouseCompanyOrderHistory = warehouseCompanyOrderHistory;
//    }
//
//    public WarehouseItemInfo getWarehouseItemInfo() {
//        return warehouseItemInfo;
//    }
//
//    public void setWarehouseItemInfo(WarehouseItemInfo warehouseItemInfo) {
//        this.warehouseItemInfo = warehouseItemInfo;
//    }
//
//    public WarehouseCompanyOrderHistory getWarehouseCompanyOrderHistory() {
//        return warehouseCompanyOrderHistory;
//    }
//
//    public void setWarehouseCompanyOrderHistory(WarehouseCompanyOrderHistory warehouseCompanyOrderHistory) {
//        this.warehouseCompanyOrderHistory = warehouseCompanyOrderHistory;
//    }
//
//    @Override
//    public String toString() {
//        return "WarehouseCompanyOrderItemPK{" +
//                "warehouseItemInfo=" + warehouseItemInfo +
//                ", warehouseCompanyOrderHistory=" + warehouseCompanyOrderHistory +
//                '}';
//    }
//}
