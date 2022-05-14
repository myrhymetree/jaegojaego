package com.greedy.jaegojaego.materials.model.dto;

public class MaterialItemAmountDTO {

    private int itemInfoNo;

    public MaterialItemAmountDTO() {
    }

    public MaterialItemAmountDTO(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "MaterialItemAmountDTO{" +
                "itemInfoNo=" + itemInfoNo +
                '}';
    }
}
