package com.greedy.jaegojaego.warehouse.dto;

public class WarehouseItemInfoDTO {

    private int itemInfoNo;
    private String itemInfoName;
    private String itemInfoItemSerialNo;
    private WarehouseMaterialCategoryDTO materialCategory;
    private String itemInfoStatusYn;

    public WarehouseItemInfoDTO() {}

    public WarehouseItemInfoDTO(int itemInfoNo, String itemInfoName, String itemInfoItemSerialNo, WarehouseMaterialCategoryDTO materialCategory, String itemInfoStatusYn) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
        this.materialCategory = materialCategory;
        this.itemInfoStatusYn = itemInfoStatusYn;
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

    public String getItemInfoItemSerialNo() {
        return itemInfoItemSerialNo;
    }

    public void setItemInfoItemSerialNo(String itemInfoItemSerialNo) {
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
    }

    public WarehouseMaterialCategoryDTO getMaterialCategory() {
        return materialCategory;
    }

    public void setMaterialCategory(WarehouseMaterialCategoryDTO materialCategory) {
        this.materialCategory = materialCategory;
    }

    public String getItemInfoStatusYn() {
        return itemInfoStatusYn;
    }

    public void setItemInfoStatusYn(String itemInfoStatusYn) {
        this.itemInfoStatusYn = itemInfoStatusYn;
    }

    @Override
    public String toString() {
        return "WarehouseItemInfoDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoItemSerialNo='" + itemInfoItemSerialNo + '\'' +
                ", materialCategory=" + materialCategory +
                ", itemInfoStatusYn='" + itemInfoStatusYn + '\'' +
                '}';
    }
}
