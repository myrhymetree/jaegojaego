package com.greedy.jaegojaego.warehouse.dto;

public class WarehouseMaterialCategoryDTO {

    private int materialCategoryNo;
    private String materialCategoryName;

    public WarehouseMaterialCategoryDTO() {}

    public WarehouseMaterialCategoryDTO(int materialCategoryNo, String materialCategoryName) {
        this.materialCategoryNo = materialCategoryNo;
        this.materialCategoryName = materialCategoryName;
    }

    public int getMaterialCategoryNo() {
        return materialCategoryNo;
    }

    public void setMaterialCategoryNo(int materialCategoryNo) {
        this.materialCategoryNo = materialCategoryNo;
    }

    public String getMaterialCategoryName() {
        return materialCategoryName;
    }

    public void setMaterialCategoryName(String materialCategoryName) {
        this.materialCategoryName = materialCategoryName;
    }

    @Override
    public String toString() {
        return "WarehouseMaterialCategoryDTO{" +
                "materialCategoryNo=" + materialCategoryNo +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
