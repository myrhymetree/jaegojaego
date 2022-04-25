package com.greedy.jaegojaego.order.order.model.entitiy.franchise;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "franchiseOrderItem")
@Table(name = "FRANCHISE_ORDER_ITEM")
public class FranchiseOrderItem implements Serializable {

    @EmbeddedId
    private FranchiseOrderItemPK franchiseOrderItem;

    @Column(name = "FRANCHISE_ORDER_ITEM_AMOUNT")
    private int franchiseOrderItemAmount;

    public FranchiseOrderItem() {
    }

    public FranchiseOrderItem(FranchiseOrderItemPK franchiseOrderItem, int franchiseOrderItemAmount) {
        this.franchiseOrderItem = franchiseOrderItem;
        this.franchiseOrderItemAmount = franchiseOrderItemAmount;
    }

    public FranchiseOrderItemPK getFranchiseOrderItem() {
        return franchiseOrderItem;
    }

    public void setFranchiseOrderItem(FranchiseOrderItemPK franchiseOrderItem) {
        this.franchiseOrderItem = franchiseOrderItem;
    }

    public int getFranchiseOrderItemAmount() {
        return franchiseOrderItemAmount;
    }

    public void setFranchiseOrderItemAmount(int franchiseOrderItemAmount) {
        this.franchiseOrderItemAmount = franchiseOrderItemAmount;
    }

    @Override
    public String toString() {
        return "FranchiseOrderItem{" +
                "franchiseOrderItem=" + franchiseOrderItem +
                ", franchiseOrderItemAmount=" + franchiseOrderItemAmount +
                '}';
    }
}
