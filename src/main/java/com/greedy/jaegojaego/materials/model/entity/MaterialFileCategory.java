package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "materialFileCategory")
@Table(name = "ATTACHMENT_FILE_CATEGORY")
public class MaterialFileCategory {

    @Id
    @Column(name = "ATTACHMENT_FILE_CATEGORY_NO")
    private int fileCategoryNo;

    @Column(name = "ATTACHMENT_FILE_CATEGORY_NAME")
    private String categoryName;

    public MaterialFileCategory() {
    }

    public MaterialFileCategory(int fileCategoryNo, String categoryName) {
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
