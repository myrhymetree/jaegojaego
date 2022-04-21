package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "OutWarehouseMaterialCategory")
@Table(name = "MATERIAL_CATEGORY")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_MATERIAL_CATEGORY_SEQ_GENERATOR",
        sequenceName = "MATERIAL_CATEGORY_NO",
        initialValue = 1,
        allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutWarehouseMaterialCategory {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_MATERIAL_CATEGORY_SEQ_GENERATOR"
    )
    @Column(name = "MATERIAL_CATEGORY_NO")
    private int materialCategoryNo;

    @Column(name = "MATERIAL_CATEGORY_NAME")
    private String materialCategoryName;

    @Override
    public String toString() {
        return "OutWarehouseMaterialCategory{" +
                "materialCategoryNo=" + materialCategoryNo +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
