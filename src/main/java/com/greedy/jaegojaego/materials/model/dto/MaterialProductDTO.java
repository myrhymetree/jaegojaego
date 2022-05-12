package com.greedy.jaegojaego.materials.model.dto;

import com.greedy.jaegojaego.materials.model.entity.FranchiseOrderableItem;

import javax.persistence.*;

public class MaterialProductDTO {

    private int itemInfoNo;

    private FranchiseOrderableItem franchiseOrderableItem;

    private String itemInfoName;

    private String itemSerialNo;

    private int materialCategory;

    private Integer subdivisionUnit;

    private String subdivisionYN;

    private String itemStatus;

    public MaterialProductDTO() {
    }

    public MaterialProductDTO(int itemInfoNo, FranchiseOrderableItem franchiseOrderableItem, String itemInfoName, String itemSerialNo, int materialCategory, Integer subdivisionUnit, String subdivisionYN, String itemStatus) {
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
        return "MaterialProductDTO{" +
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
