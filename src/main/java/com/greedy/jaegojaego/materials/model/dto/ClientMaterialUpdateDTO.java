package com.greedy.jaegojaego.materials.model.dto;

public class ClientMaterialUpdateDTO {

    private int clientItemNo;
    private Integer itemInfoNo;

    public ClientMaterialUpdateDTO() {
    }

    public ClientMaterialUpdateDTO(int clientItemNo, Integer itemInfoNo) {
        this.clientItemNo = clientItemNo;
        this.itemInfoNo = itemInfoNo;
    }

    public int getClientItemNo() {
        return clientItemNo;
    }

    public void setClientItemNo(int clientItemNo) {
        this.clientItemNo = clientItemNo;
    }

    public Integer getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(Integer itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "ClientMaterialUpdateDTO{" +
                "clientItemNo=" + clientItemNo +
                ", itemInfoNo=" + itemInfoNo +
                '}';
    }
}
