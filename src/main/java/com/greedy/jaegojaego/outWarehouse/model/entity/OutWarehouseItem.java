package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "OutWarehouseItem")
@Table(name = "OUT_WAREHOUSE_ITEM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(OutWarehouseItemId.class)
public class OutWarehouseItem {

    @Id
    @ManyToOne
    @JoinColumn(name = "OUT_WAREHOUSE_DIVISION_NO")
    private OutWarehouse outWarehouseDivisionNo;

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_WAREHOUSE_NO")
    private OutWarehouseItemWarehouse itemWarehouseNo;

    @Column(name = "OUT_WAREHOUSE_ITEM_AMOUNT")
    private int outWarehouseItemAmount;
}
