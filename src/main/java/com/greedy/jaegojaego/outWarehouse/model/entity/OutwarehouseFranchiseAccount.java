package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "outWarehouseFranchiseAccount")
@Table(name = "FRANCHISE_ACCOUNT")
public class OutwarehouseFranchiseAccount implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "FRANCHISE_MANAGER_NO")
    private OutWarehouseMember franchiseManagerNo;

    @ManyToOne
    @JoinColumn(name = "REPRESENTATIVE_NO")
    private OutWarehouseFranchiseInfo franchiseRepresentativeNo;

    public OutwarehouseFranchiseAccount() {}

    public OutwarehouseFranchiseAccount(OutWarehouseMember franchiseManagerNo, OutWarehouseFranchiseInfo franchiseRepresentativeNo) {
        this.franchiseManagerNo = franchiseManagerNo;
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public OutWarehouseMember getFranchiseManagerNo() {
        return franchiseManagerNo;
    }

    public void setFranchiseManagerNo(OutWarehouseMember franchiseManagerNo) {
        this.franchiseManagerNo = franchiseManagerNo;
    }

    public OutWarehouseFranchiseInfo getFranchiseRepresentativeNo() {
        return franchiseRepresentativeNo;
    }

    public void setFranchiseRepresentativeNo(OutWarehouseFranchiseInfo franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    @Override
    public String toString() {
        return "OutwarehouseFranchiseAccount{" +
                "franchiseManagerNo=" + franchiseManagerNo +
                ", franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                '}';
    }
}
