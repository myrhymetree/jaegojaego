package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_INFO")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_MATERIALS_SEQ_GENERATOR",
        sequenceName = "ITEM_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OutWarehouseMaterials {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_MATERIALS_SEQ_GENERATOR"
    )
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Column(name = "ITEM_INFO_ITEM_SERIAL_NO")
    private String itemInfoItemSerialNo;

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @ManyToOne
    @JoinColumn(name = "MATERIAL_CATEGORY_NO")
    private OutWarehouseMaterialCategory materialCategoryNo;

    @Column(name = "ITEM_INFO_STATUS_YN")
    private String itemInfoStatusYN;

    public OutWarehouseMaterials() {}

    public OutWarehouseMaterials(int itemInfoNo, String itemInfoItemSerialNo, String itemInfoName, OutWarehouseMaterialCategory materialCategoryNo, String itemInfoStatusYN) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
        this.itemInfoName = itemInfoName;
        this.materialCategoryNo = materialCategoryNo;
        this.itemInfoStatusYN = itemInfoStatusYN;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public String getItemInfoItemSerialNo() {
        return itemInfoItemSerialNo;
    }

    public String getItemInfoName() {
        return itemInfoName;
    }

    public OutWarehouseMaterialCategory getMaterialCategoryNo() {
        return materialCategoryNo;
    }

    public String getItemInfoStatusYN() {
        return itemInfoStatusYN;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public void setItemInfoItemSerialNo(String itemInfoItemSerialNo) {
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
    }

    public void setItemInfoName(String itemInfoName) {
        this.itemInfoName = itemInfoName;
    }

    public void setMaterialCategoryNo(OutWarehouseMaterialCategory materialCategoryNo) {
        this.materialCategoryNo = materialCategoryNo;
    }

    public void setItemInfoStatusYN(String itemInfoStatusYN) {
        this.itemInfoStatusYN = itemInfoStatusYN;
    }

    @Override
    public String toString() {
        return "OutWarehouseMaterials{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoItemSerialNo='" + itemInfoItemSerialNo + '\'' +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", materialCategoryNo=" + materialCategoryNo +
                ", itemInfoStatusYN='" + itemInfoStatusYN + '\'' +
                '}';
    }
}
