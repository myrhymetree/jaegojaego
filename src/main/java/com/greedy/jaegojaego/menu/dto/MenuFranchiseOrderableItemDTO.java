package com.greedy.jaegojaego.menu.dto;

public class MenuFranchiseOrderableItemDTO {

    private MenuMaterialsDTO menuMaterialsDTO;
    private int franchiseOrderableItemPrice;

    public MenuFranchiseOrderableItemDTO() {}

    public MenuFranchiseOrderableItemDTO(MenuMaterialsDTO menuMaterialsDTO, int franchiseOrderableItemPrice) {
        this.menuMaterialsDTO = menuMaterialsDTO;
        this.franchiseOrderableItemPrice = franchiseOrderableItemPrice;
    }

    public MenuMaterialsDTO getMenuMaterialsDTO() {
        return menuMaterialsDTO;
    }

    public void setMenuMaterialsDTO(MenuMaterialsDTO menuMaterialsDTO) {
        this.menuMaterialsDTO = menuMaterialsDTO;
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
                "menuMaterialsDTO=" + menuMaterialsDTO +
                ", franchiseOrderableItemPrice=" + franchiseOrderableItemPrice +
                '}';
    }
}
