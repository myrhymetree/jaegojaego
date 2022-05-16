package com.greedy.jaegojaego.menu.dto;

public class MenuMaterialsDTO {

    private int itemInfoNo;
    private String itemInfoName;
    private String itemInfoSerialNo;
    private String itemInfoStatus;
    private MenuMaterialsCategoryDTO menuMaterialsCategoryNo;
    private Integer subdivisionUnit;
    private String subdivisionYN;

    public MenuMaterialsDTO() {}

    public MenuMaterialsDTO(int itemInfoNo, String itemInfoName, String itemInfoSerialNo, String itemInfoStatus, MenuMaterialsCategoryDTO menuMaterialsCategoryNo, Integer subdivisionUnit, String subdivisionYN) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemInfoSerialNo = itemInfoSerialNo;
        this.itemInfoStatus = itemInfoStatus;
        this.menuMaterialsCategoryNo = menuMaterialsCategoryNo;
        this.subdivisionUnit = subdivisionUnit;
        this.subdivisionYN = subdivisionYN;
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

    public Integer getSubdivisionUnit() {
        return subdivisionUnit;
    }

    public void setSubdivisionUnit(Integer subdivisionUnit) {
        this.subdivisionUnit = subdivisionUnit;
    }

    public String getSubdivisionYN() {
        return subdivisionYN;
    }

    public void setSubdivisionYN(String subdivisionYN) {
        this.subdivisionYN = subdivisionYN;
    }

    @Override
    public String toString() {
        return "MenuMaterialsDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoSerialNo='" + itemInfoSerialNo + '\'' +
                ", itemInfoStatus='" + itemInfoStatus + '\'' +
                ", menuMaterialsCategoryNo=" + menuMaterialsCategoryNo +
                ", subdivisionUnit=" + subdivisionUnit +
                ", subdivisionYN='" + subdivisionYN + '\'' +
                '}';
    }
}
