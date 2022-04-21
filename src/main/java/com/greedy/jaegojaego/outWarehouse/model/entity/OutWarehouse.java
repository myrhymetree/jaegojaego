package com.greedy.jaegojaego.outWarehouse.model.entity;

import com.greedy.jaegojaego.member.model.entity.FranchiseInfo;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "OutWarehouse")
@Table(name = "OUT_WAREHOUSE")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_SEQ_GENERATOR",
        sequenceName = "OUT_WAREHOUSE_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutWarehouse {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_SEQ_GENERATOR"
    )
    @Column(name = "OUT_WAREHOUSE_NO")
    private int outWarehouseNo;

    @Column(name = "FRANCHISE_BRANCH_NAME")
    private String franchiseBranchName;

    @Column(name = "FRANCHISE_ADDRESS")
    private String franchiseAddress;

    @Column(name = "OUT_WAREHOUSE_WORKING_STATUS_NAME")
    private String outWarehouseWorkingStatusName;

    @Column(name = "OUT_WAREHOUSE_WORKING_FINISHED_DATE")
    private Date outWarehouseWorkingFinishedDate;

    @Column(name = "OUT_WAREHOUSE_TOTAL_OUT_ITEM_AMOUNT")
    private int outWarehouseTotalOutItemAmount;

//    @Column(name = "OUT_WAREHOUSE_DIVISION")
//    private int outWarehouseDivision;

//    @ManyToOne
//    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
//    private OutWarehouseFranchiseInfo franchiseRepresentativeNo;
//
//    @OneToMany(mappedBy = "outWarehouseDivisionNo")
//    private List<OutWarehouseStatusHistory> outWarehouseStatusHistoryList;

//    @ManyToOne
//    @JoinColumn(name = "FRANCHISE_ORDER_NO")
//    private OutWarehouseFranchiseOrder franchiseOrderNo;
//
//    @ManyToOne
//    @JoinColumn(name = "FRANCHISE_ISSUE_NO")
//    private OutWarehouseFranchiseIssue franchiseIssueNo;

    @Override
    public String toString() {
        return "OutWarehouse{" +
                "outWarehouseNo=" + outWarehouseNo +
                ", franchiseBranchName='" + franchiseBranchName + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                ", outWarehouseWorkingStatusName='" + outWarehouseWorkingStatusName + '\'' +
                ", outWarehouseWorkingFinishedDate=" + outWarehouseWorkingFinishedDate +
                ", outWarehouseTotalItemAmount=" + outWarehouseTotalOutItemAmount +
                '}';
    }
}
