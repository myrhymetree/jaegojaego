package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "outWarehouseFranchiseInfo")
@Table(name = "FRANCHISE INFO")
@PrimaryKeyJoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
public class OutWarehouseFranchiseInfo extends OutWarehouseMember {

    @Column(name = "FRANCHISE_BRANCH_NAME")
    private String franchiseName;

    @Column(name = "FRANCHISE_ADDRESS")
    private String franchiseAddress;

    public OutWarehouseFranchiseInfo() {}

    public OutWarehouseFranchiseInfo(String franchiseName, String franchiseAddress) {
        this.franchiseName = franchiseName;
        this.franchiseAddress = franchiseAddress;
    }

    public OutWarehouseFranchiseInfo(int memberNo, String officeDivision, String memberDivision, String franchiseName, String franchiseAddress) {
        super(memberNo, officeDivision, memberDivision);
        this.franchiseName = franchiseName;
        this.franchiseAddress = franchiseAddress;
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
                "franchiseName='" + franchiseName + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                '}';
    }
}
