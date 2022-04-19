package com.greedy.jaegojaego.menu.dto;

public class MenuMaterialsDTO {

    private int itemInfoNo;
    private String itemInfoName;
    private String itemInfoSerialNo;
    private String itemInfoStatus;
    private MenuMaterialsCategoryDTO menuMaterialsCategoryNo;

    public MenuMaterialsDTO() {}

    public MenuMaterialsDTO(int itemInfoNo, String itemInfoName, String itemInfoSerialNo, String itemInfoStatus, MenuMaterialsCategoryDTO menuMaterialsCategoryNo) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemInfoSerialNo = itemInfoSerialNo;
        this.itemInfoStatus = itemInfoStatus;
        this.menuMaterialsCategoryNo = menuMaterialsCategoryNo;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public String getItemInfoName() {
        return itemInfoName;
    }

    public void setItemInfoName(String itemInfoName) {
        this.itemInfoName = itemInfoName;
    }

    public String getItemInfoSerialNo() {
        return itemInfoSerialNo;
    }

    public void setItemInfoSerialNo(String itemInfoSerialNo) {
        this.itemInfoSerialNo = itemInfoSerialNo;
    }

    public String getItemInfoStatus() {
        return itemInfoStatus;
    }

    public void setItemInfoStatus(String itemInfoStatus) {
        this.itemInfoStatus = itemInfoStatus;
    }

    public MenuMaterialsCategoryDTO getMenuMaterialsCategoryNo() {
        return menuMaterialsCategoryNo;
    }

    public void setMenuMaterialsCategoryNo(MenuMaterialsCategoryDTO menuMaterialsCategoryNo) {
        this.menuMaterialsCategoryNo = menuMaterialsCategoryNo;
    }

    @Override
    public String toString() {
        return "MenuMaterialsDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoSerialNo='" + itemInfoSerialNo + '\'' +
                ", itemInfoStatus='" + itemInfoStatus + '\'' +
                ", menuMaterialsCategoryNo=" + menuMaterialsCategoryNo +
                '}';
    }
}
