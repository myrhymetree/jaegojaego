//package com.greedy.jaegojaego.outWarehouse.model.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.sql.Date;
//
//@Entity(name = "OutWarehouseExpandsOutWarehouseStatusHistory")
//@Table(name = "OUT_WAREHOUSE")
//@SecondaryTable(
//        name = "OUT_WAREHOUSE_STATUS_HISTORY",
//        pkJoinColumns = {
//                @PrimaryKeyJoinColumn(name = "OUT_WAREHOUSE_DIVISION_NO"),
////                @PrimaryKeyJoinColumn(name = "OUT_WAREHOUSE_STATUS_HISTORY_NO")
//        }
//)
//@SequenceGenerators({
//        @SequenceGenerator(
//                name = "OUT_WAREHOUSE_SEQ_GENERATOR",
//                sequenceName = "OUT_WAREHOUSE_DIVISION_NO",
//                initialValue = 1,
//                allocationSize = 1
//        ),
//        @SequenceGenerator(
//                name = "OUT_WAREHOUSE_STATUS_HISTORY_SEQ_GENERATOR",
//                sequenceName = "OUT_WAREHOUSE_STATUS_HISTORY_NO",
//                initialValue = 1,
//                allocationSize = 1
//        )
//})
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class OutWarehouseExpandsOutWarehouseStatusHistory {
//
//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "OUT_WAREHOUSE_SEQ_GENERATOR"
//    )
//    @Column(name = "OUT_WAREHOUSE_DIVISION_NO")
//    private int outWarehouseDivisionNo;
//
//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "OUT_WAREHOUSE_STATUS_HISTORY_SEQ_GENERATOR"
//    )
//    @Column(
//            table = "OUT_WAREHOUSE_STATUS_HISTORY",
//            name = "OUT_WAREHOUSE_STATUS_HISTORY_NO"
//    )
//    private OutWarehouseStatusHistory outWarehouseStatusHistoryNo;
//
//    @Column(name = "OUT_WAREHOUSE_NO")
//    private int outWarehouseNo;
//
//    @Column(name = "OUT_WAREHOUSE_DIVISION")
//    private int outWarehouseDivision;
//
//    @ManyToOne
//    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
//    private OutWarehouseFranchiseInfo franchiseRepresentativeNo;
//
//    @Column(name = "OUT_WAREHOUSE_STATUS_NAME")
//    private String outWarehouseStatusName;
//
//    @Column(name = "OUT_WAREHOUSE_STATUS_DATE")
//    private Date outWarehouseStatusDate;
//
//    @Column(name = "OUT_WAREHOUSE_STATUS_AMOUNT")
//    private int outWarehouseStatusAmount;
//
//    @Override
//    public String toString() {
//        return "OutWarehouse{" +
//                "outWarehouseDivisionNo=" + outWarehouseDivisionNo +
//                ", outWarehouseStatusHistoryNo=" + outWarehouseStatusHistoryNo +
//                ", outWarehouseNo=" + outWarehouseNo +
//                ", outWarehouseDivision=" + outWarehouseDivision +
//                ", franchiseRepresentativeNo=" + franchiseRepresentativeNo +
//                ", outWarehouseStatusName='" + outWarehouseStatusName + '\'' +
//                ", outWarehouseStatusDate=" + outWarehouseStatusDate +
//                ", outWarehouseStatusAmount=" + outWarehouseStatusAmount +
//                '}';
//    }
//}
