package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_INFO")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_MATERIALS_SEQ_GENERATOR",
        sequenceName = "ITEM_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutWarehouseMaterials {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_MATERIALS_SEQ_GENERATOR"
    )
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Column(name = "ITEM_INFO_ITEM_SERIAL_NO")
    private String itemInfoItemSerialNo;

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @ManyToOne
    @JoinColumn(name = "MATERIAL_CATEGORY_NO")
    private OutWarehouseMaterialCategory materialCategoryNo;

    @Column(name = "ITEM_INFO_STATUS_YN")
    private String itemInfoStatusYN;
}
