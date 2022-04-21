package com.greedy.jaegojaego.menu.dto;


import java.util.List;

public class RawMaterialDTO {

    private MenuDTO menuNoforRaw;
    private MenuFranchiseOrderableItemDTO itemInfoNo; //이게 그냥 Menu뭐시기그것만 하는지 List인지 헷갈리네
    private String rawMaterialName;
    private int rawMaterialCapacity;
                //결국에는 자재명/자재품번(자재내부의 컬럼들 여러개사용해야함) 받아야하잫ㄴ아? 음..일단
//    private List<MenuFranchiseOrderableItemDTO> itemInfoNo;

    public RawMaterialDTO() {}

    public RawMaterialDTO(String rawMaterialName, int rawMaterialCapacity, MenuDTO menuNoforRaw, MenuFranchiseOrderableItemDTO itemInfoNo) {
        this.rawMaterialName = rawMaterialName;
        this.rawMaterialCapacity = rawMaterialCapacity;
        this.menuNoforRaw = menuNoforRaw;
        this.itemInfoNo = itemInfoNo;
    }

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public int getRawMaterialCapacity() {
        return rawMaterialCapacity;
    }

    public void setRawMaterialCapacity(int rawMaterialCapacity) {
        this.rawMaterialCapacity = rawMaterialCapacity;
    }

    public MenuDTO getMenuNoforRaw() {
        return menuNoforRaw;
    }

    public void setMenuNoforRaw(MenuDTO menuNoforRaw) {
        this.menuNoforRaw = menuNoforRaw;
    }

    public MenuFranchiseOrderableItemDTO getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(MenuFranchiseOrderableItemDTO itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "RawMaterialDTO{" +
                "rawMaterialName='" + rawMaterialName + '\'' +
                ", rawMaterialCapacity=" + rawMaterialCapacity +
                ", menuNoforRaw=" + menuNoforRaw +
                ", itemInfoNo=" + itemInfoNo +
                '}';
    }
}
