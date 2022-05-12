package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "outWarehouseMaterialCategory")
@Table(name = "MATERIAL_CATEGORY")
public class OutWarehouseMaterialCategory {

    @Id
    @Column(name = "MATERIAL_CATEGORY_NO")
    private int materialCategoryNo;

    @Column(name = "MATERIAL_CATEGORY_NAME")
    private String materialCategoryName;

    public OutWarehouseMaterialCategory() {}

    public OutWarehouseMaterialCategory(int materialCategoryNo, String materialCategoryName) {
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
        return "OutWarehouseMaterialCategory{" +
                "materialCategoryNo=" + materialCategoryNo +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
