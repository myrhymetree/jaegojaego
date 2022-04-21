package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OutWarehouseItemId implements Serializable {

    private OutWarehouse outWarehouseDivisionNo;
    private OutWarehouseItemWarehouse itemWarehouseNo;
}
