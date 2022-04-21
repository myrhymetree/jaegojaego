package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "OutWarehouseItemWarehouse")
@Table(name = "ITEM_WAREHOUSE")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_ITEM_WAREHOUSE_SEQ_GENERATOR",
        sequenceName = "ITEM_WAREHOUSE_NO",
        initialValue = 1,
        allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutWarehouseItemWarehouse {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_ITEM_WAREHOUSE_SEQ_GENERATOR"
    )
    @Column(name = "ITEM_WAREHOUSE_NO")
    private int itemWarehouseNo;

    @Column(name = "ITEM_WAREHOUSE_DIVISION")
    private String itemWarehouseDivision;

    @Column(name = "ITEM_WAREHOUSE_AMOUNT")
    private int itemWarehouseAmount;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OutWarehouseMaterials itemInfoNo;

    @ManyToOne
    @JoinColumn(name = "OUT_WAREHOUSE_DIVISION_NO")
    private OutWarehouse outWarehouseDivisionNo;

    @Override
    public String toString() {
        return "OutWarehouseItemWarehouse{" +
                "itemWarehouseNo=" + itemWarehouseNo +
                ", itemWarehouseDivision='" + itemWarehouseDivision + '\'' +
                ", itemWarehouseAmount=" + itemWarehouseAmount +
                ", itemInfoNo=" + itemInfoNo +
                ", outWarehouseDivisionNo=" + outWarehouseDivisionNo +
                '}';
    }
}
