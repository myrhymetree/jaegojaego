package com.greedy.jaegojaego.order.order.model.dto.franchise;

public class FranchiseOrderItemDTO {

    private FranchiseOrderDTO franchiseOrder;
    private int franchiseOrderItemAmount;
    private FranchiseOrderableItemDTO franchiseOrderableItem;

    public FranchiseOrderItemDTO() {
    }

    public FranchiseOrderItemDTO(FranchiseOrderDTO franchiseOrder, int franchiseOrderItemAmount, FranchiseOrderableItemDTO franchiseOrderableItem) {
        this.franchiseOrder = franchiseOrder;
        this.franchiseOrderItemAmount = franchiseOrderItemAmount;
        this.franchiseOrderableItem = franchiseOrderableItem;
    }

    public FranchiseOrderDTO getFranchiseOrder() {
        return franchiseOrder;
    }

    public void setFranchiseOrder(FranchiseOrderDTO franchiseOrder) {
        this.franchiseOrder = franchiseOrder;
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
