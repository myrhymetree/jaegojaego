package com.greedy.jaegojaego.warehouse.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "warehouseItemInfo")
@Table(name = "ITEM_INFO")
@SequenceGenerator(
        name = "ITEM_INFO_SEQ_GENERATOR",
        sequenceName = "ITEM_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseItemInfo {

    @Id
    @Column(name = "ITEM_INFO_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_INFO_SEQ_GENERATOR"
    )
    private int itemInfoNo;

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @Column(name = "ITEM_INFO_ITEM_SERIAL_NO")
    private String itemInfoItemSerialNo;

    @ManyToOne
    @JoinColumn(name = "MATERIAL_CATEGORY_NO")
    private WarehouseMaterialCategory warehouseMaterialCategory;

    @Column(name = "ITEM_INFO_STATUS_YN")
    private String itemInfoStatusYn;

    @Override
    public String toString() {
        return "ItemInfo{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoItemSerialNo='" + itemInfoItemSerialNo + '\'' +
                ", materialCategory=" + warehouseMaterialCategory +
                ", itemInfoStatusYn='" + itemInfoStatusYn + '\'' +
                '}';
    }
}
