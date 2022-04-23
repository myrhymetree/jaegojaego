package com.greedy.jaegojaego.warehouse.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "warehouseMaterialCategory")
@Table(name = "MATERIAL_CATEGORY")
@SequenceGenerator(
        name = "MATERIAL_CATEGORY_SEQ_GENERATOR",
        sequenceName = "COMPANY_ORDER_HISTORY_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Override
    public String toString() {
        return "OrderMaterialCategory{" +
                "materialCategoryNo=" + materialCategoryNo +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
