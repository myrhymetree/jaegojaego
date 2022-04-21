package com.greedy.jaegojaego.warehouse.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemWarehouseDTO {

    private int itemWarehouseNo;
    private String itemWarehouseDivision;
    private int itemWarehouseAmount;
    private int itemWarehouseRealAmount;
    private int itemInfoNo;
    private int inWarehouseDivisionNo;
    private int outWarehouseDivisionNo;
    private String itemWarehouseQualityStatus;

}
