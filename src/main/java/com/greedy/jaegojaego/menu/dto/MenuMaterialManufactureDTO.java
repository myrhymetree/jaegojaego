package com.greedy.jaegojaego.menu.dto;

public class MenuMaterialManufactureDTO {

    private int materialManufactureSubdivisionUnit;
    private MenuMaterialsDTO itemInfoNo;

    public MenuMaterialManufactureDTO() {}

    public MenuMaterialManufactureDTO(int materialManufactureSubdivisionUnit, MenuMaterialsDTO itemInfoNo) {
        this.materialManufactureSubdivisionUnit = materialManufactureSubdivisionUnit;
        this.itemInfoNo = itemInfoNo;
    }

    public int getMaterialManufactureSubdivisionUnit() {
        return materialManufactureSubdivisionUnit;
    }

    public void setMaterialManufactureSubdivisionUnit(int materialManufactureSubdivisionUnit) {
        this.materialManufactureSubdivisionUnit = materialManufactureSubdivisionUnit;
    }

    public MenuMaterialsDTO getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(MenuMaterialsDTO itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "MenuMaterialManufactureDTO{" +
                "materialManufactureSubdivisionUnit=" + materialManufactureSubdivisionUnit +
                ", itemInfoNo=" + itemInfoNo +
                '}';
    }
}
