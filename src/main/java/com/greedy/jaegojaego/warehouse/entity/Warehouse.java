package com.greedy.jaegojaego.warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "warehouse")
@Table(name = "IN_WAREHOUSE")
@SequenceGenerator(
        name = "IN_WAREHOUSE_SEQ_GENERATOR",
        sequenceName = "IN_WAREHOUSE_NO",
        initialValue = 1,
        allocationSize = 1
)
@AllArgsConstructor
@Getter
@Setter
public class Warehouse {

    @Id
    @Column(name = "IN_WAREHOUSE_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "IN_WAREHOUSE_SEQ_GENERATOR"
    )
    private int warehouseNo;

    @Column(name = "IN_WAREHOUSE_AMOUNT")
    private int warehouseAmount;

    @Column(name = "IN_WAREHOUSE_STATUS")
    private String warehouseStatus;

    @Column(name = "IN_WAREHOUSE_DATE")
    private java.sql.Date warehouseDate;

    @Column(name = "ORDER_APPLICATION_NO")
    private int orderApplication;

    @Column(name = "CLIENT_CONTRACT_ITEM_NO")
    private int clientContractItem;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private WarehouseItemInfo itemInfoNo;

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private WarehouseClient clientNo;

    @Column(name = "IN_WAREHOUSE_COMPLETE_DATE")
    private java.sql.Date warehouseCompleteDate;

    public Warehouse() {}

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseNo=" + warehouseNo +
                ", warehouseAmount=" + warehouseAmount +
                ", warehouseStatus='" + warehouseStatus + '\'' +
                ", warehouseDate=" + warehouseDate +
                ", orderApplication=" + orderApplication +
                ", clientContractItem=" + clientContractItem +
                ", itemInfoNo=" + itemInfoNo +
                ", clientNo=" + clientNo +
                ", warehouseCompleteDate=" + warehouseCompleteDate +
                '}';
    }
}
