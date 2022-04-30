package com.greedy.jaegojaego.menu.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class RawMaterialPK implements Serializable {

    @JoinColumn(name = "FINISHED_PRODUCT_MENU_NO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menuNoforRaw;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_INFO_NO")
    private MenuMaterial itemInfoNo;

    public RawMaterialPK() {}

    public RawMaterialPK(Menu menuNoforRaw, MenuMaterial itemInfoNo) {
        this.menuNoforRaw = menuNoforRaw;
        this.itemInfoNo = itemInfoNo;
    }

    public Menu getMenuNoforRaw() {
        return menuNoforRaw;
    }

    public void setMenuNoforRaw(Menu menuNoforRaw) {
        this.menuNoforRaw = menuNoforRaw;
    }

    public MenuMaterial getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(MenuMaterial itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "RawMaterialPK{" +
                "menuNoforRaw=" + menuNoforRaw +
                ", itemInfoNo=" + itemInfoNo +
                '}';
    }
}
