package com.greedy.jaegojaego.order.order.model.entity.franchise;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class FranchiseOrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ORDER_NO")
    private FranchiseOrder franchiseOrder;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private FranchiseOrderableItem franchiseOrderableItem;

    public FranchiseOrderItemPK() {
    }

    public FranchiseOrderItemPK(FranchiseOrder franchiseOrder, FranchiseOrderableItem franchiseOrderableItem) {
        this.franchiseOrder = franchiseOrder;
        this.franchiseOrderableItem = franchiseOrderableItem;
    }

    public FranchiseOrder getFranchiseOrder() {
        return franchiseOrder;
    }

    public void setFranchiseOrder(FranchiseOrder franchiseOrder) {
        this.franchiseOrder = franchiseOrder;
    }

    public FranchiseOrderableItem getFranchiseOrderableItem() {
        return franchiseOrderableItem;
    }

    public void setFranchiseOrderableItem(FranchiseOrderableItem franchiseOrderableItem) {
        this.franchiseOrderableItem = franchiseOrderableItem;
    }

    @Override
    public String toString() {
        return "FranchiseOrderItemPK{" +
                "franchiseOrderableItem=" + franchiseOrderableItem +
                '}';
    }
}
