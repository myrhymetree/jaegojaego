package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "outWarehouseFranchiseInfo")
@Table(name = "FRANCHISE_INFO")
public class OutWarehouseFranchiseInfo implements Serializable{

//    @Id
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
//    private OutWarehouseMember

//    @Id
//    @Column(name = "FRANCHISE_REPRESENTATIVE_NO")
//    private int franchiseRepresentativeNo;

    @EmbeddedId
    private OutWarehouseFranchiseInfoPk franchiseRepresentativeNo;

    @Column(name = "FRANCHISE_BRANCH_NAME")
    private String franchiseName;

    @Column(name = "FRANCHISE_ADDRESS")
    private String franchiseAddress;

    public OutWarehouseFranchiseInfo() {}

    public OutWarehouseFranchiseInfo(OutWarehouseFranchiseInfoPk franchiseRepresentativeNo, String franchiseName, String franchiseAddress) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
        this.franchiseName = franchiseName;
        this.franchiseAddress = franchiseAddress;
    }

    public OutWarehouseFranchiseInfoPk getFranchiseRepresentativeNo() {
        return franchiseRepresentativeNo;
    }

    public void setFranchiseRepresentativeNo(OutWarehouseFranchiseInfoPk franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public String getFranchiseName() {
        return franchiseName;
    }

    public void setFranchiseName(String franchiseName) {
        this.franchiseName = franchiseName;
    }

    public String getFranchiseAddress() {
        return franchiseAddress;
    }

    public void setFranchiseAddress(String franchiseAddress) {
        this.franchiseAddress = franchiseAddress;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseInfo{" +
                "franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                ", franchiseName='" + franchiseName + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                '}';
    }
}
