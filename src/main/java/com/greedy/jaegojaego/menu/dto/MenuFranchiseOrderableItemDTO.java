package com.greedy.jaegojaego.menu.dto;

public class MenuFranchiseOrderableItemDTO {

    private MenuMaterialManufactureDTO itemInfoNo;
    private int franchiseOrderableItemPrice;

    public MenuFranchiseOrderableItemDTO() {}

    public MenuFranchiseOrderableItemDTO(MenuMaterialManufactureDTO itemInfoNo, int franchiseOrderableItemPrice) {
        this.itemInfoNo = itemInfoNo;
        this.franchiseOrderableItemPrice = franchiseOrderableItemPrice;
    }

    public MenuMaterialManufactureDTO getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(MenuMaterialManufactureDTO itemInfoNo) {
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
