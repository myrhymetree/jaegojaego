package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.*;

@Entity(name = "MaterialsCategory")
@Table(name = "MATERIAL_CATEGORY")
@SequenceGenerator(
        name = "CATEGORY_NO_SEQ_GENERATOR",
        sequenceName = "MATERIAL_CATEGORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class MaterialsCategory {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CATEGORY_NO_SEQ_GENERATOR"
    )
    @Column(name = "MATERIAL_CATEGORY_NO")
    private int materialCategoryNo;

    @Column(name = "MATERIAL_CATEGORY_NAME")
    private String materialCategoryName;

    public MaterialsCategory() {
    }

    public MaterialsCategory(int materialCategoryNo, String materialCategoryName) {
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
        return "MaterialsCategory{" +
                "materialCategoryNo=" + materialCategoryNo +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
