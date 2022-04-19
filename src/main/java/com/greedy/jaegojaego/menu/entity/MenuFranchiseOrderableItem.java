package com.greedy.jaegojaego.menu.entity;

import com.greedy.jaegojaego.menu.dto.MenuFranchiseOrderableItemDTO;
import com.greedy.jaegojaego.menu.dto.MenuMaterialsDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "menuFranchiseOrderableItem")
@Table(name = "TBL_FRANCHISE_ORDERABLE_ITEM")
public class MenuFranchiseOrderableItem implements Serializable {

    //얘가 pk/fk
    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private MenuMaterial menuMaterialsNo;

    @Column(name = "FRANCHISE_ORDERABLE_ITEM_PRICE")
    private int franchiseOrderableItemPrice;

    public MenuFranchiseOrderableItem() {}

    public MenuFranchiseOrderableItem(MenuMaterial menuMaterialsNo, int franchiseOrderableItemPrice) {
        this.menuMaterialsNo = menuMaterialsNo;
        this.franchiseOrderableItemPrice = franchiseOrderableItemPrice;
    }

    public MenuMaterial getMenuMaterialsNo() {
        return menuMaterialsNo;
    }

    public void setMenuMaterialsNo(MenuMaterial menuMaterialsNo) {
        this.menuMaterialsNo = menuMaterialsNo;
    }

    public int getFranchiseOrderableItemPrice() {
        return franchiseOrderableItemPrice;
    }

    public void setFranchiseOrderableItemPrice(int franchiseOrderableItemPrice) {
        this.franchiseOrderableItemPrice = franchiseOrderableItemPrice;
    }

    @Override
    public String toString() {
        return "MenuFranchiseOrderableItem{" +
                "menuMaterialsNo=" + menuMaterialsNo +
                ", franchiseOrderableItemPrice=" + franchiseOrderableItemPrice +
                '}';
    }
}
