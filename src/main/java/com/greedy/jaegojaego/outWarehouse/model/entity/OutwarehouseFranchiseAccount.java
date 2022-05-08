package com.greedy.jaegojaego.outWarehouse.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "outWarehouseFranchiseAccount")
@Table(name = "FRANCHISE_ACCOUNT")
@PrimaryKeyJoinColumn(name = "FRNACHISE_MEMBER_NO")
public class OutwarehouseFranchiseAccount extends OutWarehouseMember {

    @ManyToOne
    @JoinColumn(name = "REPRESENTATIVE_NO")
    private OutWarehouseFranchiseInfo franchiseRepresentativeNo;

    public OutwarehouseFranchiseAccount() {}

    public OutwarehouseFranchiseAccount(OutWarehouseFranchiseInfo franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public OutwarehouseFranchiseAccount(int memberNo, String officeDivision, String memberDivision, OutWarehouseFranchiseInfo franchiseRepresentativeNo) {
        super(memberNo, officeDivision, memberDivision);
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
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
                "franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                '}';
    }
}
