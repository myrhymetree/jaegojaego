package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "outWarehouseFranchiseAccount")
@Table(name = "FRANCHISE_ACCOUNT")
public class OutWarehouseFranchiseAccount implements Serializable{

//    @Id
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "FRANCHISE_MANAGER_NO")
//    private OutWarehouseMember franchiseManagerNo;

    @EmbeddedId
    private OutWarehouseFranchiseAccountPk franchiseManagerNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REPRESENTATIVE_NO")
    private OutWarehouseFranchiseInfo franchiseRepresentativeNo;

    public OutWarehouseFranchiseAccount() {}

    public OutWarehouseFranchiseAccount(OutWarehouseFranchiseAccountPk franchiseManagerNo, OutWarehouseFranchiseInfo franchiseRepresentativeNo) {
        this.franchiseManagerNo = franchiseManagerNo;
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public OutWarehouseFranchiseAccountPk getFranchiseManagerNo() {
        return franchiseManagerNo;
    }

    public void setFranchiseManagerNo(OutWarehouseFranchiseAccountPk franchiseManagerNo) {
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
        return "OutWarehouseFranchiseAccount{" +
                "franchiseManagerNo=" + franchiseManagerNo +
                ", franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                '}';
    }
}
