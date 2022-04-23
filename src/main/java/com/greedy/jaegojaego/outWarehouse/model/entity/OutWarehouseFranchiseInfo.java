package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "OutWarehouseFranchiseInfo")
@Table(name = "FRANCHISE_INFO")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_FRANCHISE_INFO_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_REPRESENTATIVE_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OutWarehouseFranchiseInfo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_FRANCHISE_INFO_SEQ_GENERATOR"
    )
    @Column(name = "FRANCHISE_REPRESENTATIVE_NO")
    private int franchiseRepresentativeNo;

    @Column(name = "FRANCHISE_BRANCH_NAME")
    private String franchiseBranchName;

    @Column(name = "FRANCHISE_ADDRESS")
    private String franchiseAddress;

    public OutWarehouseFranchiseInfo() {}

    public OutWarehouseFranchiseInfo(int franchiseRepresentativeNo, String franchiseBranchName, String franchiseAddress) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
        this.franchiseBranchName = franchiseBranchName;
        this.franchiseAddress = franchiseAddress;
    }

    public int getFranchiseRepresentativeNo() {
        return franchiseRepresentativeNo;
    }

    public String getFranchiseBranchName() {
        return franchiseBranchName;
    }

    public String getFranchiseAddress() {
        return franchiseAddress;
    }

    public void setFranchiseRepresentativeNo(int franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public void setFranchiseBranchName(String franchiseBranchName) {
        this.franchiseBranchName = franchiseBranchName;
    }

    public void setFranchiseAddress(String franchiseAddress) {
        this.franchiseAddress = franchiseAddress;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseInfo{" +
                "franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                ", franchiseBranchName='" + franchiseBranchName + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                '}';
    }
}
