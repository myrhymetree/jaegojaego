package com.greedy.jaegojaego.menu.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class RawMaterialPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "FINISHED_PRODUCT_MENU_NO")
    private Menu menuNoforRaw;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private MenuFranchiseOrderableItem itemInfoNo;

    public RawMaterialPK() {}

    public RawMaterialPK(Menu menuNoforRaw, MenuFranchiseOrderableItem itemInfoNo) {
        this.menuNoforRaw = menuNoforRaw;
        this.itemInfoNo = itemInfoNo;
    }

    public Menu getMenuNoforRaw() {
        return menuNoforRaw;
    }

    public void setMenuNoforRaw(Menu menuNoforRaw) {
        this.menuNoforRaw = menuNoforRaw;
    }

    public MenuFranchiseOrderableItem getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(MenuFranchiseOrderableItem itemInfoNo) {
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
