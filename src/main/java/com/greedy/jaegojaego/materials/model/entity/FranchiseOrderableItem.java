package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FranchiseOrderableItem")
@Table(name = "FRANCHISE_ORDERABLE_ITEM")
public class FranchiseOrderableItem {

    @Id
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Column(name = "FRANCHISE_ORDERABLE_ITEM_PRICE")
    private int orderAmount;

    public FranchiseOrderableItem() {
    }

    public FranchiseOrderableItem(int itemInfoNo, int orderAmount) {
        this.itemInfoNo = itemInfoNo;
        this.orderAmount = orderAmount;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "FranchiseOrderableItem{" +
                "itemInfoNo=" + itemInfoNo +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
