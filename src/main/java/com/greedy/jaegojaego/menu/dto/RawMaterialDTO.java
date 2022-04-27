package com.greedy.jaegojaego.menu.dto;

public class RawMaterialDTO {

    private MenuDTO menuNoforRaw;
    private MenuMaterialsDTO itemInfoNo;
    private String rawMaterialName;
    private String rawMaterialCapacity;

    public RawMaterialDTO() {}

    public RawMaterialDTO(MenuDTO menuNoforRaw, MenuMaterialsDTO itemInfoNo, String rawMaterialName, String rawMaterialCapacity) {
        this.menuNoforRaw = menuNoforRaw;
        this.itemInfoNo = itemInfoNo;
        this.rawMaterialName = rawMaterialName;
        this.rawMaterialCapacity = rawMaterialCapacity;
    }

    public MenuDTO getMenuNoforRaw() {
        return menuNoforRaw;
    }

    public void setMenuNoforRaw(MenuDTO menuNoforRaw) {
        this.menuNoforRaw = menuNoforRaw;
    }

    public MenuMaterialsDTO getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(MenuMaterialsDTO itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public String getRawMaterialCapacity() {
        return rawMaterialCapacity;
    }

    public void setRawMaterialCapacity(String rawMaterialCapacity) {
        this.rawMaterialCapacity = rawMaterialCapacity;
    }

    @Override
    public String toString() {
        return "RawMaterialDTO{" +
                "menuNoforRaw=" + menuNoforRaw +
                ", itemInfoNo=" + itemInfoNo +
                ", rawMaterialName='" + rawMaterialName + '\'' +
                ", rawMaterialCapacity='" + rawMaterialCapacity + '\'' +
                '}';
    }
}
