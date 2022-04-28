package com.greedy.jaegojaego.materials.model.dto;

public class MaterialsCategoryDTO {

    private int materialCategoryNo;             //카테고리 번호
    private String materialCategoryName;        //카테고리 이름

    public MaterialsCategoryDTO() {
    }

    public MaterialsCategoryDTO(int materialCategoryNo, String materialCategoryName) {
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
        return "MaterialsCategoryDTO{" +
                "materialCategoryNo=" + materialCategoryNo +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
