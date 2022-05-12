package com.greedy.jaegojaego.materials.model.dto;

public class MaterialFileCategoryDTO {

    private int fileCategoryNo;
    private String categoryName;

    public MaterialFileCategoryDTO() {
    }

    public MaterialFileCategoryDTO(int fileCategoryNo, String categoryName) {
        this.fileCategoryNo = fileCategoryNo;
        this.categoryName = categoryName;
    }

    public int getFileCategoryNo() {
        return fileCategoryNo;
    }

    public void setFileCategoryNo(int fileCategoryNo) {
        this.fileCategoryNo = fileCategoryNo;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "FileCategoryDTO{" +
                "fileCategoryNo=" + fileCategoryNo +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
