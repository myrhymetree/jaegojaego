package com.greedy.jaegojaego.menu.entity;

import com.greedy.jaegojaego.menu.dto.MenuFranchiseOrderableItemDTO;
import com.greedy.jaegojaego.menu.dto.MenuMaterialsDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "menuFranchiseOrderableItem")
@Table(name = "FRANCHISE_ORDERABLE_ITEM")
public class MenuFranchiseOrderableItem implements Serializable {

    //얘가 pk/fk
    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private MenuMaterialManufacture itemInfoNo;

    @Column(name = "FRANCHISE_ORDERABLE_ITEM_PRICE")
    private int franchiseOrderableItemPrice;

    public MenuFranchiseOrderableItem() {}

    public MenuFranchiseOrderableItem(MenuMaterialManufacture itemInfoNo, int franchiseOrderableItemPrice) {
        this.itemInfoNo = itemInfoNo;
        this.franchiseOrderableItemPrice = franchiseOrderableItemPrice;
    }

    public MenuMaterialManufacture getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(MenuMaterialManufacture itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
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
                "itemInfoNo=" + itemInfoNo +
                ", franchiseOrderableItemPrice=" + franchiseOrderableItemPrice +
                '}';
    }
}
