package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "FranchiseOrderableItem")
@Table(name = "FRANCHISE_ORDERABLE_ITEM")
public class FranchiseOrderableItem {

    @Id
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Column(name = "FRANCHISE_ORDERABLE_ITEM_PRICE")
    private int itemPrice;

    public FranchiseOrderableItem() {
    }

    public FranchiseOrderableItem(int itemInfoNo, int itemPrice) {
        this.itemInfoNo = itemInfoNo;
        this.itemPrice = itemPrice;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }


}
