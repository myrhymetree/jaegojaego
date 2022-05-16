package com.greedy.jaegojaego.warehouse.entity;

import javax.persistence.*;

@Entity(name = "warehouseItemInfo")
@Table(name = "ITEM_INFO")
@SequenceGenerator(
        name = "ITEM_INFO_SEQ_GENERATOR",
        sequenceName = "ITEM_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
public class WarehouseItemInfo {

    @Id
    @Column(name = "ITEM_INFO_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_INFO_SEQ_GENERATOR"
    )
    private int itemInfoNo;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ITEM_INFO_NO")
    private WarehouseItemAmount warehouseItemAmount;

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @Column(name = "ITEM_INFO_ITEM_SERIAL_NO")
    private String itemInfoItemSerialNo;

    @ManyToOne
    @JoinColumn(name = "MATERIAL_CATEGORY_NO")
    private WarehouseMaterialCategory warehouseMaterialCategory;

    @Column(name = "ITEM_INFO_STATUS_YN")
    private String itemInfoStatusYn;

    public WarehouseItemInfo() {}

    public WarehouseItemInfo(int itemInfoNo, WarehouseItemAmount warehouseItemAmount, String itemInfoName, String itemInfoItemSerialNo, WarehouseMaterialCategory warehouseMaterialCategory, String itemInfoStatusYn) {
        this.itemInfoNo = itemInfoNo;
        this.warehouseItemAmount = warehouseItemAmount;
        this.itemInfoName = itemInfoName;
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
        this.warehouseMaterialCategory = warehouseMaterialCategory;
        this.itemInfoStatusYn = itemInfoStatusYn;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public WarehouseItemAmount getWarehouseItemAmount() {
        return warehouseItemAmount;
    }

    public void setWarehouseItemAmount(WarehouseItemAmount warehouseItemAmount) {
        this.warehouseItemAmount = warehouseItemAmount;
    }

    public String getItemInfoName() {
        return itemInfoName;
    }

    public void setItemInfoName(String itemInfoName) {
        this.itemInfoName = itemInfoName;
    }

    public String getItemInfoItemSerialNo() {
        return itemInfoItemSerialNo;
    }

    public void setItemInfoItemSerialNo(String itemInfoItemSerialNo) {
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
    }

    public WarehouseMaterialCategory getWarehouseMaterialCategory() {
        return warehouseMaterialCategory;
    }

    public void setWarehouseMaterialCategory(WarehouseMaterialCategory warehouseMaterialCategory) {
        this.warehouseMaterialCategory = warehouseMaterialCategory;
    }

    public String getItemInfoStatusYn() {
        return itemInfoStatusYn;
    }

    public void setItemInfoStatusYn(String itemInfoStatusYn) {
        this.itemInfoStatusYn = itemInfoStatusYn;
    }

    @Override
    public String toString() {
        return "WarehouseItemInfo{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoItemSerialNo='" + itemInfoItemSerialNo + '\'' +
                ", warehouseMaterialCategory=" + warehouseMaterialCategory +
                ", itemInfoStatusYn='" + itemInfoStatusYn + '\'' +
//                ", subdivisionUnit='" + subdivisionUnit + '\'' +
//                ", subdivisionYn=" + subdivisionYn +
                '}';
    }
}
