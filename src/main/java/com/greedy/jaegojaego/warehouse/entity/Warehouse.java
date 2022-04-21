package com.greedy.jaegojaego.warehouse.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "warehouse")
@Table(name = "IN_WAREHOUSE")
//@SequenceGenerator(
//        name = "IN_WAREHOUSE_SEQ_GENERATOR",
//        sequenceName = "IN_WAREHOUSE_NO",
//        initialValue = 1,
//        allocationSize = 1
//)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warehouse {

    @Id
    @Column(name = "IN_WAREHOUSE_NO")
    private int warehouseNo;

    @Column(name = "IN_WAREHOUSE_MANUFACTURE_DATE")
    private java.sql.Date warehouseManuDate;

//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "IN_WAREHOUSE_SEQ_GENERATOR"
//    )
//    @Column(name = "IN_WAREHOUSE_DIVISION_NO")
//    private int warehouseDivisionNo;

    @Column(name = "IN_WAREHOUSE_DIVISION_ITEM")
    private int warehouseDivisionItem;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private WarehouseCompanyOrderHistory orderHistoryNo;

    @Column(name = "FRANCHISE_ISSUE_NO")
    private int issueNo;

    @Column(name = "CLIENT_NO")
    private int clientNo;

    @OneToMany
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private List<WarehouseCompanyOrderItem> companyOrderItemList;

    @OneToMany
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private List<WarehouseOrderApplication> orderApplicationList;

    @Column(name = "IN_WAREHOUSE_WORKING_STATUS_NAME")
    private String warehouseWorkingName;

    @Column(name = "IN_WAREHOUSE_WORKING_FINISHED_DATE")
    private java.sql.Date warehouseWorkingDate;

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseNo=" + warehouseNo +
                ", warehouseManuDate=" + warehouseManuDate +
                ", warehouseDivisionItem=" + warehouseDivisionItem +
                ", orderHistoryNo=" + orderHistoryNo +
                ", issueNo=" + issueNo +
                ", clientNo=" + clientNo +
                ", companyOrderItemList=" + companyOrderItemList +
                ", orderApplicationList=" + orderApplicationList +
                ", warehouseWorkingName='" + warehouseWorkingName + '\'' +
                ", warehouseWorkingDate=" + warehouseWorkingDate +
                '}';
    }
}
