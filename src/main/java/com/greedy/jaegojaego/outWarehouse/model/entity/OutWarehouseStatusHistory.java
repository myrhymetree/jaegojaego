package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "OutWarehouseStatusHistory")
@Table(name = "OUT_WAREHOUSE_STATUS_HISTORY")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_STATUS_HISTORY_SEQ_GENERATOR",
        sequenceName = "OUT_WAREHOUSE_STATUS_HISTORY_NO"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(OutWarehouseStatusHistoryId.class)
public class OutWarehouseStatusHistory {

    @Id
    @Column(name = "OUT_WAREHOUSE_STATUS_HISTORY_NO")
    private int outWarehouseStatusHistoryNo;

    @Id
    @ManyToOne
    @JoinColumn(name = "OUT_WAREHOUSE_DIVISION_NO")
    private OutWarehouse outWarehouseDivisionNo;

    @Column(name = "OUT_WAREHOUSE_STATUS_NAME")
    private String outWarehouseStatusName;

    @Column(name = "OUT_WAREHOUSE_STATUS_DATE")
    private Date outWarehouseStatusDate;

    @Column(name = "OUT_WAREHOUSE_STATUS_AMOUNT")
    private int outWarehouseStatusAmount;

    @Override
    public String toString() {
        return "OutWarehouseStatusHistory{" +
                "outWarehouseStatusHistoryNo=" + outWarehouseStatusHistoryNo +
//                ", outWarehouseDivisionNo=" + outWarehouseDivisionNo +
                ", outWarehouseStatusName='" + outWarehouseStatusName + '\'' +
                ", outWarehouseStatusDate=" + outWarehouseStatusDate +
                ", outWarehouseStatusAmount=" + outWarehouseStatusAmount +
                '}';
    }
}
