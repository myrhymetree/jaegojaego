package com.greedy.jaegojaego.order.order.model.dto.franchise;

public class FranchiseOrderItemDTO {

    private int franchiseOrderItemAmount;
    private FranchiseOrderableItemDTO franchiseOrderableItem;

    public FranchiseOrderItemDTO() {
    }

    public FranchiseOrderItemDTO(int franchiseOrderItemAmount, FranchiseOrderableItemDTO franchiseOrderableItem) {
        this.franchiseOrderItemAmount = franchiseOrderItemAmount;
        this.franchiseOrderableItem = franchiseOrderableItem;
    }

    public int getFranchiseOrderItemAmount() {
        return franchiseOrderItemAmount;
    }

    public void setFranchiseOrderItemAmount(int franchiseOrderItemAmount) {
        this.franchiseOrderItemAmount = franchiseOrderItemAmount;
    }

    public FranchiseOrderableItemDTO getFranchiseOrderableItem() {
        return franchiseOrderableItem;
    }

    public void setFranchiseOrderableItem(FranchiseOrderableItemDTO franchiseOrderableItem) {
        this.franchiseOrderableItem = franchiseOrderableItem;
    }

    @Override
    public String toString() {
        return "FranchiseOrderItemDTO{" +
                "franchiseOrderItemAmount=" + franchiseOrderItemAmount +
                ", franchiseOrderableItem=" + franchiseOrderableItem +
                '}';
    }
}
