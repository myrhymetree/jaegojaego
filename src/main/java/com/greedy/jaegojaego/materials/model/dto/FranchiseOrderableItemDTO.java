package com.greedy.jaegojaego.materials.model.dto;

public class FranchiseOrderableItemDTO {

    private int itemInfoNo;         //자재번호
    private int itemPrice;                //자재 가격

    public FranchiseOrderableItemDTO() {
    }

    public FranchiseOrderableItemDTO(int itemInfoNo, int itemPrice) {
        this.itemInfoNo = itemInfoNo;
        this.itemPrice = itemPrice;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "FranchiseOrderableItemDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
