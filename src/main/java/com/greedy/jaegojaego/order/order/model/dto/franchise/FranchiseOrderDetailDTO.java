package com.greedy.jaegojaego.order.order.model.dto.franchise;

public class FranchiseOrderDetailDTO {

    private int itemNo;
    private String itemName;
    private int itemPrice;
    private int itemAmount;

    public FranchiseOrderDetailDTO() {
    }

    public FranchiseOrderDetailDTO(int itemNo, String itemName, int itemPrice, int itemAmount) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAmount = itemAmount;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    @Override
    public String toString() {
        return "FranchiseOrderDetailDTO{" +
                "itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemAmount=" + itemAmount +
                '}';
    }
}
