package com.greedy.jaegojaego.warehouse.dto;

import com.greedy.jaegojaego.warehouse.entity.WarehouseCompanyOrderHistory;
import lombok.*;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseDTO {

    private int warehouseNo;
    private java.sql.Date warehouseManuDate;
//    private int warehouseDivisionNo;
    private int warehouseDivisionItem;
    private WarehouseCompanyOrderHistory orderHistoryNo;
    private int issueNo;                                    //추후 타입 수정 예정!!
    private int clientNo;
    private String warehouseWorkingName;
    private java.sql.Date warehouseWorkingDate;

    @Override
    public String toString() {
        return "WarehouseDTO{" +
                "warehouseNo=" + warehouseNo +
                ", warehouseManuDate=" + warehouseManuDate +
                ", warehouseDivisionItem=" + warehouseDivisionItem +
                ", orderHistoryNo=" + orderHistoryNo +
                ", issueNo=" + issueNo +
                ", clientNo=" + clientNo +
                ", warehouseWorkingName='" + warehouseWorkingName + '\'' +
                ", warehouseWorkingDate=" + warehouseWorkingDate +
                '}';
    }
}
