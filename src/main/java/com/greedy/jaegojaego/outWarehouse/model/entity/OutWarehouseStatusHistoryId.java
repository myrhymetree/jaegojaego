package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OutWarehouseStatusHistoryId implements Serializable {

    private int outWarehouseStatusHistoryNo;
    private OutWarehouse outWarehouseDivisionNo;
}
