package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FRANCHISE_ORDERABLE_ITEM")
public class OutWarehouseFranchiseOrderableItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OutWarehouseMaterials itemInfoNo;

    public OutWarehouseFranchiseOrderableItem() {}

    public OutWarehouseFranchiseOrderableItem(OutWarehouseMaterials itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public OutWarehouseMaterials getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(OutWarehouseMaterials itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseOrderableItem{" +
                "itemInfoNo=" + itemInfoNo +
                '}';
    }
}
