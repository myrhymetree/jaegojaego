package com.greedy.jaegojaego.order.order.model.dto.franchise;

public class FranchiseOrderDetailDTO {

    private String itemName;
    private int itemPrice;
    private int itemAmount;

    public FranchiseOrderDetailDTO() {
    }

    public FranchiseOrderDetailDTO(String itemName, int itemPrice, int itemAmount) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAmount = itemAmount;
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
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemAmount=" + itemAmount +
                '}';
    }
}
