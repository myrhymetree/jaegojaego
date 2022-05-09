package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class OutWarehouseFranchiseInfoPk implements Serializable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private OutWarehouseMember franchiseRepresentativeNo;

    public OutWarehouseFranchiseInfoPk() {}

    public OutWarehouseFranchiseInfoPk(OutWarehouseMember franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public OutWarehouseMember getFranchiseRepresentativeNo() {
        return franchiseRepresentativeNo;
    }

    public void setFranchiseRepresentativeNo(OutWarehouseMember franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseInfoPk{" +
                "franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                '}';
    }
}
