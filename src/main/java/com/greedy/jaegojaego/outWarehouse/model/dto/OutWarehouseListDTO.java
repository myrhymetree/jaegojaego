package com.greedy.jaegojaego.outWarehouse.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OutWarehouseListDTO {

    private int outWarehouseDivisionNo;
    private int outWarehouseNo;
    private int outWarehouseDivision;
    private int franchiseRepresentativeNo;
    private int franchiseOrderNo;
    private int franchiseIssueNo;
}
