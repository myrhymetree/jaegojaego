package com.greedy.jaegojaego.warehouse.entity;

import javax.persistence.*;

@Entity(name = "warehouseMaterialCategory")
@Table(name = "MATERIAL_CATEGORY")
@SequenceGenerator(
        name = "MATERIAL_CATEGORY_SEQ_GENERATOR",
        sequenceName = "COMPANY_ORDER_HISTORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class WarehouseMaterialCategory {

    @Id
    @Column(name = "MATERIAL_CATEGORY_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MATERIAL_CATEGORY_SEQ_GENERATOR"
    )
    private int materialCategoryNo;

    @Column(name = "MATERIAL_CATEGORY_NAME")
    private String materialCategoryName;

    public WarehouseMaterialCategory() {}

    public WarehouseMaterialCategory(int materialCategoryNo, String materialCategoryName) {
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
        return "OrderMaterialCategory{" +
                "materialCategoryNo=" + materialCategoryNo +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
