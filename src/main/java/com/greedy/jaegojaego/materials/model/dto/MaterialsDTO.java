package com.greedy.jaegojaego.materials.model.dto;

public class MaterialsDTO {

    private int itemInfoNo;
    private String itemInfoName;
    private String itemSerialNo;
    private MaterialsCategoryDTO materialsCategory;
    private String itemStatus;
    private Integer subdivisionUnit;
    private String subdivisionYN;
    private int itemPrice;

    public MaterialsDTO() {
    }

    public MaterialsDTO(int itemInfoNo, String itemInfoName, String itemSerialNo, MaterialsCategoryDTO materialsCategory, String itemStatus, Integer subdivisionUnit, String subdivisionYN, int itemPrice) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemSerialNo = itemSerialNo;
        this.materialsCategory = materialsCategory;
        this.itemStatus = itemStatus;
        this.subdivisionUnit = subdivisionUnit;
        this.subdivisionYN = subdivisionYN;
        this.itemPrice = itemPrice;
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

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "MaterialsDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemSerialNo='" + itemSerialNo + '\'' +
                ", materialsCategory=" + materialsCategory +
                ", itemStatus='" + itemStatus + '\'' +
                ", subdivisionUnit=" + subdivisionUnit +
                ", subdivisionYN='" + subdivisionYN + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }


}
