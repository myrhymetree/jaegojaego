package com.greedy.jaegojaego.warehouse.dto;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseHistoryDTO {

    private String warehouseStatusName;
    private java.sql.Date warehouseHistoryDate;
    private int warehouseDivisionNo;
    private int warehouseStatusAmount;
    private int warehouseStatusHistoryNo;

    @Override
    public String toString() {
        return "WarehouseHistoryDTO{" +
                "warehouseStatusName='" + warehouseStatusName + '\'' +
                ", warehouseHistoryDate=" + warehouseHistoryDate +
                ", warehouseDivisionNo=" + warehouseDivisionNo +
                ", warehouseStatusAmount=" + warehouseStatusAmount +
                ", warehouseStatusHistoryNo=" + warehouseStatusHistoryNo +
                '}';
    }
}
