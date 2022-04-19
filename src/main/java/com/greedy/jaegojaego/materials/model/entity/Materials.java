package com.greedy.jaegojaego.materials.model.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity(name = "Materials")
@Table(name = "ITEM_INFO")
@SequenceGenerator(
        name = "ITEM_SEQ_GENERATOR",
        sequenceName = "ITEM_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
public class Materials {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_SEQ_GENERATOR"
    )
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @Column(name = "ITEM_INFO_ITEM_SERIAL_NO")
    private String itemSerialNo;

    @ManyToOne
    @JoinColumn(name = "MATERIAL_CATEGORY_NO")
    private MaterialsCategory materialCategory;

    @Column(name = "ITEM_INFO_STATUS_YN")
    private String itemStatus;

    public Materials() {
    }

    public Materials(int itemInfoNo, String itemInfoName, String itemSerialNo, MaterialsCategory materialCategory, String itemStatus) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemSerialNo = itemSerialNo;
        this.materialCategory = materialCategory;
        this.itemStatus = itemStatus;
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

    public String getItemSerialNo() {
        return itemSerialNo;
    }

    public void setItemSerialNo(String itemSerialNo) {
        this.itemSerialNo = itemSerialNo;
    }

    public MaterialsCategory getMaterialCategory() {
        return materialCategory;
    }

    public void setMaterialCategory(MaterialsCategory materialCategory) {
        this.materialCategory = materialCategory;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemSerialNo='" + itemSerialNo + '\'' +
                ", materialCategory=" + materialCategory +
                ", itemStatus='" + itemStatus + '\'' +
                '}';
    }
}
