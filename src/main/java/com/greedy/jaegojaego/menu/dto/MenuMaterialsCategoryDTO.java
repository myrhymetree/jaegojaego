package com.greedy.jaegojaego.menu.dto;

public class MenuMaterialsCategoryDTO {

    private int materialCategoryCode;
    private String materialCategoryName;

    public MenuMaterialsCategoryDTO() {}

    public MenuMaterialsCategoryDTO(int materialCategoryCode, String materialCategoryName) {
        this.materialCategoryCode = materialCategoryCode;
        this.materialCategoryName = materialCategoryName;
    }

    public int getMaterialCategoryCode() {
        return materialCategoryCode;
    }

    public void setMaterialCategoryCode(int materialCategoryCode) {
        this.materialCategoryCode = materialCategoryCode;
    }

    public String getMaterialCategoryName() {
        return materialCategoryName;
    }

    public void setMaterialCategoryName(String materialCategoryName) {
        this.materialCategoryName = materialCategoryName;
    }

    @Override
    public String toString() {
        return "MenuMaterialsCategoryDTO{" +
                "materialCategoryCode=" + materialCategoryCode +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
