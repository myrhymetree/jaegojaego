package com.greedy.jaegojaego.outWarehouse.model.entity;
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
public class OutWarehouse {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_SEQ_GENERATOR"
    )
    @Column(name = "OUT_WAREHOUSE_NO")
    private int outWarehouseNo;

//    @Column(name = "FRANCHISE_BRANCH_NAME")
//    private String franchiseBranchName;
//
//    @Column(name = "FRANCHISE_ADDRESS")
//    private String franchiseAddress;

    @Column(name = "OUT_WAREHOUSE_WORKING_STATUS_NAME")
    private String outWarehouseWorkingStatusName;

    @Column(name = "OUT_WAREHOUSE_WORKING_FINISHED_DATE")
    private Date outWarehouseWorkingFinishedDate;

    @Column(name = "OUT_WAREHOUSE_TOTAL_OUT_ITEM_AMOUNT")
    private int outWarehouseTotalOutItemAmount;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private OutWarehouseFranchiseInfo franchiseRepresentativeNo;

//    @ManyToOne
//    @JoinColumn(name = "FRANCHISE_ORDER_NO")
//    private OutWarehouseFranchiseOrder franchiseOrderNo;
//
//    @ManyToOne
//    @JoinColumn(name = "FRANCHISE_ISSUE_NO")
//    private OutWarehouseFranchiseIssue franchiseIssueNo;

    public OutWarehouse() {}

    public OutWarehouse(int outWarehouseNo, String franchiseBranchName, String franchiseAddress, String outWarehouseWorkingStatusName, Date outWarehouseWorkingFinishedDate, int outWarehouseTotalOutItemAmount, OutWarehouseFranchiseInfo franchiseRepresentativeNo) {
        this.outWarehouseNo = outWarehouseNo;
//        this.franchiseBranchName = franchiseBranchName;
//        this.franchiseAddress = franchiseAddress;
        this.outWarehouseWorkingStatusName = outWarehouseWorkingStatusName;
        this.outWarehouseWorkingFinishedDate = outWarehouseWorkingFinishedDate;
        this.outWarehouseTotalOutItemAmount = outWarehouseTotalOutItemAmount;
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public int getOutWarehouseNo() {
        return outWarehouseNo;
    }

//    public String getFranchiseBranchName() {
//        return franchiseBranchName;
//    }
//
//    public String getFranchiseAddress() {
//        return franchiseAddress;
//    }

    public String getOutWarehouseWorkingStatusName() {
        return outWarehouseWorkingStatusName;
    }

    public Date getOutWarehouseWorkingFinishedDate() {
        return outWarehouseWorkingFinishedDate;
    }

    public int getOutWarehouseTotalOutItemAmount() {
        return outWarehouseTotalOutItemAmount;
    }

    public OutWarehouseFranchiseInfo getFranchiseRepresentativeNo() {
        return franchiseRepresentativeNo;
    }

    public void setOutWarehouseNo(int outWarehouseNo) {
        this.outWarehouseNo = outWarehouseNo;
    }

//    public void setFranchiseBranchName(String franchiseBranchName) {
//        this.franchiseBranchName = franchiseBranchName;
//    }
//
//    public void setFranchiseAddress(String franchiseAddress) {
//        this.franchiseAddress = franchiseAddress;
//    }

    public void setOutWarehouseWorkingStatusName(String outWarehouseWorkingStatusName) {
        this.outWarehouseWorkingStatusName = outWarehouseWorkingStatusName;
    }

    public void setOutWarehouseWorkingFinishedDate(Date outWarehouseWorkingFinishedDate) {
        this.outWarehouseWorkingFinishedDate = outWarehouseWorkingFinishedDate;
    }

    public void setOutWarehouseTotalOutItemAmount(int outWarehouseTotalOutItemAmount) {
        this.outWarehouseTotalOutItemAmount = outWarehouseTotalOutItemAmount;
    }

    public void setFranchiseRepresentativeNo(OutWarehouseFranchiseInfo franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    @Override
    public String toString() {
        return "OutWarehouse{" +
                "outWarehouseNo=" + outWarehouseNo +
//                ", franchiseBranchName='" + franchiseBranchName + '\'' +
//                ", franchiseAddress='" + franchiseAddress + '\'' +
                ", outWarehouseWorkingStatusName='" + outWarehouseWorkingStatusName + '\'' +
                ", outWarehouseWorkingFinishedDate=" + outWarehouseWorkingFinishedDate +
                ", outWarehouseTotalOutItemAmount=" + outWarehouseTotalOutItemAmount +
                ", franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                '}';
    }
}
