package com.greedy.jaegojaego.menu.entity;

import javax.persistence.*;

@Entity(name = "menuMaterialsCategory")
@Table(name = "TBL_MATERIAL_CATEGORY")
@SequenceGenerator(
        name = "MENUMATERIALCATEGORY_SEQ_GENERATOR",
        sequenceName = "SEQ_MENUMATERIALCATEGORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class MenuMaterialsCategory {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MENUMATERIALCATEGORY_SEQ_GENERATOR"
    )
    @Column(name = "MATERIAL_CATEGORY_NO")
    private int materialCategoryCode;

    @Column(name = "MATERIAL_CATEGORY_NAME")
    private String materialCategoryName;

    public MenuMaterialsCategory() {}

    public MenuMaterialsCategory(int materialCategoryCode, String materialCategoryName) {
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
        return "MenuMaterialsCategory{" +
                "materialCategoryCode=" + materialCategoryCode +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
