package com.greedy.jaegojaego.materials.model.dto;

public class MaterialDTO {

    private int itemInfoNo;
    private FranchiseOrderableItemDTO franchiseOrderableItem;
    private String itemInfoName;
    private String itemSerialNo;
    private MaterialsCategoryDTO materialsCategory;
    private String itemStatus;
    private Integer subdivisionUnit;
    private String subdivisionYN;

    public MaterialDTO() {
    }

    public MaterialDTO(int itemInfoNo, FranchiseOrderableItemDTO franchiseOrderableItem, String itemInfoName, String itemSerialNo, MaterialsCategoryDTO materialsCategory, String itemStatus, Integer subdivisionUnit, String subdivisionYN) {
        this.itemInfoNo = itemInfoNo;
        this.franchiseOrderableItem = franchiseOrderableItem;
        this.itemInfoName = itemInfoName;
        this.itemSerialNo = itemSerialNo;
        this.materialsCategory = materialsCategory;
        this.itemStatus = itemStatus;
        this.subdivisionUnit = subdivisionUnit;
        this.subdivisionYN = subdivisionYN;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public FranchiseOrderableItemDTO getFranchiseOrderableItem() {
        return franchiseOrderableItem;
    }

    public void setFranchiseOrderableItem(FranchiseOrderableItemDTO franchiseOrderableItem) {
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

    public MaterialsCategoryDTO getMaterialsCategory() {
        return materialsCategory;
    }

    public void setMaterialsCategory(MaterialsCategoryDTO materialsCategory) {
        this.materialsCategory = materialsCategory;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
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

    @Override
    public String toString() {
        return "MaterialDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", franchiseOrderableItem=" + franchiseOrderableItem +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemSerialNo='" + itemSerialNo + '\'' +
                ", materialsCategory=" + materialsCategory +
                ", itemStatus='" + itemStatus + '\'' +
                ", subdivisionUnit=" + subdivisionUnit +
                ", subdivisionYN='" + subdivisionYN + '\'' +
                '}';
    }
}
