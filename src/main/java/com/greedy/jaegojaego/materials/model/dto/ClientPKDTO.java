package com.greedy.jaegojaego.materials.model.dto;

public class ClientPKDTO {

    private int clientItemNo;
    private int itemInfoNo;

    public ClientPKDTO() {
    }

    public ClientPKDTO(int clientItemNo, int itemInfoNo) {
        this.clientItemNo = clientItemNo;
        this.itemInfoNo = itemInfoNo;
    }

    public int getClientItemNo() {
        return clientItemNo;
    }

    public void setClientItemNo(int clientItemNo) {
        this.clientItemNo = clientItemNo;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "ClientPKDTO{" +
                "clientItemNo=" + clientItemNo +
                ", itemInfoNo=" + itemInfoNo +
                '}';
    }
}
