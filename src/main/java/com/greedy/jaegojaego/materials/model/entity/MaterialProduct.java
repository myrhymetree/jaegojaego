package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.*;

@Entity(name = "materialProduct")
@Table(name = "ITEM_INFO")
public class MaterialProduct {

    @Id
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_INFO_NO")
    private FranchiseOrderableItem franchiseOrderableItem;

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @Column(name = "ITEM_INFO_ITEM_SERIAL_NO")
    private String itemSerialNo;

    @Column(name = "MATERIAL_CATEGORY_NO")
    private int materialCategory;

    @Column(name = "SUBDIVISION_UNIT")
    private Integer subdivisionUnit;

    @Column(name = "SUBDIVISION_YN")
    private String subdivisionYN;

    @Column(name = "ITEM_INFO_STATUS_YN")
    private String itemStatus;

    public MaterialProduct() {
    }

    public MaterialProduct(int itemInfoNo, FranchiseOrderableItem franchiseOrderableItem, String itemInfoName, String itemSerialNo, int materialCategory, Integer subdivisionUnit, String subdivisionYN, String itemStatus) {
        this.itemInfoNo = itemInfoNo;
        this.franchiseOrderableItem = franchiseOrderableItem;
        this.itemInfoName = itemInfoName;
        this.itemSerialNo = itemSerialNo;
        this.materialCategory = materialCategory;
        this.subdivisionUnit = subdivisionUnit;
        this.subdivisionYN = subdivisionYN;
        this.itemStatus = itemStatus;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public FranchiseOrderableItem getFranchiseOrderableItem() {
        return franchiseOrderableItem;
    }

    public void setFranchiseOrderableItem(FranchiseOrderableItem franchiseOrderableItem) {
        this.franchiseOrderableItem = franchiseOrderableItem;
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

    public int getMaterialCategory() {
        return materialCategory;
    }

    public void setMaterialCategory(int materialCategory) {
        this.materialCategory = materialCategory;
    }

    public Integer getSubdivisionUnit() {
        return subdivisionUnit;
    }

    public void setSubdivisionUnit(Integer subdivisionUnit) {
        this.subdivisionUnit = subdivisionUnit;
    }

    public String getSubdivisionYN() {
        return subdivisionYN;
    }

    public void setSubdivisionYN(String subdivisionYN) {
        this.subdivisionYN = subdivisionYN;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Override
    public String toString() {
        return "MaterialProduct{" +
                "itemInfoNo=" + itemInfoNo +
                ", franchiseOrderableItem=" + franchiseOrderableItem +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemSerialNo='" + itemSerialNo + '\'' +
                ", materialCategory=" + materialCategory +
                ", subdivisionUnit=" + subdivisionUnit +
                ", subdivisionYN='" + subdivisionYN + '\'' +
                ", itemStatus='" + itemStatus + '\'' +
                '}';
    }
}
