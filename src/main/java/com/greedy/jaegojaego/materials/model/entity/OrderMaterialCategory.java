package com.greedy.jaegojaego.materials.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "materialCategory")
@Table(name = "MATERIAL_CATEGORY")
@SequenceGenerator(
        name = "MATERIAL_CATEGORY_SEQ_GENERATOR",
        sequenceName = "MATERIAL_CATEGORY_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderMaterialCategory {

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
        return "MaterialCategory{" +
                "materialCategoryNo=" + materialCategoryNo +
                ", materialCategoryName='" + materialCategoryName + '\'' +
                '}';
    }
}
