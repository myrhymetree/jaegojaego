package com.greedy.jaegojaego.menu.dto;

public class MenuFranchiseOrderableItemDTO {

    private MenuMaterialsDTO itemInfoNo;
    private int franchiseOrderableItemPrice;

    public MenuFranchiseOrderableItemDTO() {}

    public MenuFranchiseOrderableItemDTO(MenuMaterialsDTO itemInfoNo, int franchiseOrderableItemPrice) {
        this.itemInfoNo = itemInfoNo;
        this.franchiseOrderableItemPrice = franchiseOrderableItemPrice;
    }

    public MenuMaterialsDTO getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(MenuMaterialsDTO itemInfoNo) {
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
        return "MenuFranchiseOrderableItemDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", franchiseOrderableItemPrice=" + franchiseOrderableItemPrice +
                '}';
    }
}
