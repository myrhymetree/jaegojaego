package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class OutWarehouseFranchiseAccountPk implements Serializable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FRANCHISE_MANAGER_NO")
    private OutWarehouseMember franchiseManagerNo;

    public OutWarehouseFranchiseAccountPk() {}

    public OutWarehouseFranchiseAccountPk(OutWarehouseMember franchiseManagerNo) {
        this.franchiseManagerNo = franchiseManagerNo;
    }

    public OutWarehouseMember getFranchiseManagerNo() {
        return franchiseManagerNo;
    }

    public void setFranchiseManagerNo(OutWarehouseMember franchiseManagerNo) {
        this.franchiseManagerNo = franchiseManagerNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseAccountPk{" +
                "franchiseManagerNo=" + franchiseManagerNo +
                '}';
    }
}
