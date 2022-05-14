package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "materialItemAmount")
@Table(name = "ITEM_AMOUNT")
public class MaterialItemAmount {

    @Id
    @Column(name="ITEM_INFO_NO")
    private int itemInfoNo;

    public MaterialItemAmount() {
    }

    public MaterialItemAmount(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "MaterialItemAmount{" +
                "itemInfoNo=" + itemInfoNo +
                '}';
    }
}
