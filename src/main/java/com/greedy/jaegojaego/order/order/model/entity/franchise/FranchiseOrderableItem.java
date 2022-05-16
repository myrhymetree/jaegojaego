package com.greedy.jaegojaego.order.order.model.entity.franchise;

import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "franchiseOrderableItem")
@Table(name = "FRANCHISE_ORDERABLE_ITEM")
public class FranchiseOrderableItem implements Serializable {

    @EmbeddedId
    private FranchiseOrderableItemPK franchiseOrderableItem;

    @Column(name = "FRANCHISE_ORDERABLE_ITEM_PRICE")
    private int franchiseOrderableItemPrice;

    public FranchiseOrderableItem() {
    }

    public FranchiseOrderableItem(FranchiseOrderableItemPK franchiseOrderableItem, int franchiseOrderableItemPrice) {
        this.franchiseOrderableItem = franchiseOrderableItem;
        this.franchiseOrderableItemPrice = franchiseOrderableItemPrice;
    }

    public FranchiseOrderableItemPK getFranchiseOrderableItem() {
        return franchiseOrderableItem;
    }

    public void setFranchiseOrderableItem(FranchiseOrderableItemPK franchiseOrderableItem) {
        this.franchiseOrderableItem = franchiseOrderableItem;
    }

    public int getFranchiseOrderableItemPrice() {
        return franchiseOrderableItemPrice;
    }

    public void setFranchiseOrderableItemPrice(int franchiseOrderableItemPrice) {
        this.franchiseOrderableItemPrice = franchiseOrderableItemPrice;
    }

    @Override
    public String toString() {
        return "FranchiseOrderableItem{" +
                "franchiseOrderableItem=" + franchiseOrderableItem +
                ", franchiseOrderableItemPrice=" + franchiseOrderableItemPrice +
                '}';
    }
}
