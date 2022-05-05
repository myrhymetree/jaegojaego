package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "outWarehouse")
@Table(name = "OUT_WAREHOUSE")
public class OutWarehouse {

    @Id
    @Column(name = "OUT_WAREHOUSE_NO")
    private int outWarehouseNo;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private OutWarehouseFranchiseInfo franchiseRepresentativeNo;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ORDER_NO")
    private OutWarehouseFranchiseOrder franchiseOrderNo;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ISSUE_NO")
    private OutWarehouseFranchiseIssue franchiseIssueNo;

    @Column(name= "OUT_WAREHOUSE_WORKING_FINISHED_DATE")
    private Date outWarehouseWorkingFinishedDate;

    @Column(name = "OUT_WAREHOUSE_WORKING_STATUS_NAME")
    private String outWarehouseWorkingStatusName;

    public OutWarehouse() {}

    public OutWarehouse(int outWarehouseNo, OutWarehouseFranchiseInfo franchiseRepresentativeNo, OutWarehouseFranchiseOrder franchiseOrderNo, OutWarehouseFranchiseIssue franchiseIssueNo, Date outWarehouseWorkingFinishedDate, String outWarehouseWorkingStatusName) {
        this.outWarehouseNo = outWarehouseNo;
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
        this.franchiseOrderNo = franchiseOrderNo;
        this.franchiseIssueNo = franchiseIssueNo;
        this.outWarehouseWorkingFinishedDate = outWarehouseWorkingFinishedDate;
        this.outWarehouseWorkingStatusName = outWarehouseWorkingStatusName;
    }

    public int getOutWarehouseNo() {
        return outWarehouseNo;
    }

    public void setOutWarehouseNo(int outWarehouseNo) {
        this.outWarehouseNo = outWarehouseNo;
    }

    public OutWarehouseFranchiseInfo getFranchiseRepresentativNo() {
        return franchiseRepresentativeNo;
    }

    public void setFranchiseRepresentativNo(OutWarehouseFranchiseInfo franchiseRepresentativNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativNo;
    }

    public OutWarehouseFranchiseOrder getFranchiseOrderNo() {
        return franchiseOrderNo;
    }

    public void setFranchiseOrderNo(OutWarehouseFranchiseOrder franchiseOrderNo) {
        this.franchiseOrderNo = franchiseOrderNo;
    }

    public OutWarehouseFranchiseIssue getFranchiseIssueNo() {
        return franchiseIssueNo;
    }

    public void setFranchiseIssueNo(OutWarehouseFranchiseIssue franchiseIssueNo) {
        this.franchiseIssueNo = franchiseIssueNo;
    }

    public Date getOutWarehouseWorkingFinishedDate() {
        return outWarehouseWorkingFinishedDate;
    }

    public void setOutWarehouseWorkingFinishedDate(Date outWarehouseWorkingFinishedDate) {
        this.outWarehouseWorkingFinishedDate = outWarehouseWorkingFinishedDate;
    }

    public String getOutWarehouseWorkingStatusName() {
        return outWarehouseWorkingStatusName;
    }

    public void setOutWarehouseWorkingStatusName(String outWarehouseWorkingStatusName) {
        this.outWarehouseWorkingStatusName = outWarehouseWorkingStatusName;
    }

    @Override
    public String toString() {
        return "OutWarehouse{" +
                "outWarehouseNo=" + outWarehouseNo +
                ", franchiseRepresentativNo=" + franchiseRepresentativeNo +
                ", franchiseOrderNo=" + franchiseOrderNo +
                ", franchiseIssueNo=" + franchiseIssueNo +
                ", outWarehouseWorkingFinishedDate=" + outWarehouseWorkingFinishedDate +
                ", outWarehouseWorkingStatusName='" + outWarehouseWorkingStatusName + '\'' +
                '}';
    }
}
