package com.greedy.jaegojaego.outWarehouse.model.dto;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseStatusHistory;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseStatusHistoryId;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OutWarehouseListDTO {

    private int outWarehouseNo;
    private String franchiseBranchName;
    private String franchiseAddress;
    private String outWarehouseWorkingStatusName;
    private Date outWarehouseWorkingFinishedDate;
    private int outWarehouseTotalOutItemAmount;
}
