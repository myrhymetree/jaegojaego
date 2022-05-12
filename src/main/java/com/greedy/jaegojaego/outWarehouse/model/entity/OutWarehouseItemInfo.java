package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;

@Entity(name = "outWarehouseItemInfo")
@Table(name = "ITEM_INFO")
public class OutWarehouseItemInfo {

    @Id
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @Column(name = "ITEM_INFO_ITEM_SERIAL_NO")
    private String itemInfoSerialNo;

    @ManyToOne
    @JoinColumn(name = "MATERIAL_CATEGORY_NO")
    private OutWarehouseMaterialCategory materialCategoryNo;

    public OutWarehouseItemInfo() {}

    public OutWarehouseItemInfo(int itemInfoNo, String itemInfoName, String itemInfoSerialNo, OutWarehouseMaterialCategory materialCategoryNo) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemInfoSerialNo = itemInfoSerialNo;
        this.materialCategoryNo = materialCategoryNo;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public String getItemInfoName() {
        return itemInfoName;
    }

    public void setItemInfoName(String itemInfoName) {
        this.itemInfoName = itemInfoName;
    }

    public String getItemInfoSerialNo() {
        return itemInfoSerialNo;
    }

    public void setItemInfoSerialNo(String itemInfoSerialNo) {
        this.itemInfoSerialNo = itemInfoSerialNo;
    }

    public OutWarehouseMaterialCategory getMaterialCategoryNo() {
        return materialCategoryNo;
    }

    public void setMaterialCategoryNo(OutWarehouseMaterialCategory materialCategoryNo) {
        this.materialCategoryNo = materialCategoryNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseItemInfo{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoSerialNo='" + itemInfoSerialNo + '\'' +
                ", materialCategoryNo=" + materialCategoryNo +
                '}';
    }
}
