package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "outWarehouseFranchiseInfo")
@Table(name = "FRANCHISE INFO")
public class OutWarehouseFranchiseInfo implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private OutWarehouseMember franchiseRepresenetativeNo;

    @Column(name = "FRANCHISE_BRANCH_NAME")
    private String franchiseName;

    @Column(name = "FRANCHISE_ADDRESS")
    private String franchiseAddress;

    public OutWarehouseFranchiseInfo() {}

    public OutWarehouseFranchiseInfo(OutWarehouseMember franchiseRepresenetativeNo, String franchiseName, String franchiseAddress) {
        this.franchiseRepresenetativeNo = franchiseRepresenetativeNo;
        this.franchiseName = franchiseName;
        this.franchiseAddress = franchiseAddress;
    }

    public OutWarehouseMember getFranchiseRepresenetativeNo() {
        return franchiseRepresenetativeNo;
    }

    public void setFranchiseRepresenetativeNo(OutWarehouseMember franchiseRepresenetativeNo) {
        this.franchiseRepresenetativeNo = franchiseRepresenetativeNo;
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
                "franchiseRepresenetativeNo=" + franchiseRepresenetativeNo +
                ", franchiseName='" + franchiseName + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                '}';
    }
}
