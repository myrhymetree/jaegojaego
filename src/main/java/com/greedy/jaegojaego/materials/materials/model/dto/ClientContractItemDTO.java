package com.greedy.jaegojaego.materials.model.dto;

public class ClientContractItemDTO {

    private int clientNo;
    private int itemInfoNo;
    private String clientName;
    private int clientPrice;

    public ClientContractItemDTO() {
    }

    public ClientContractItemDTO(int clientNo, int itemInfoNo, String clientName, int clientPrice) {
        this.clientNo = clientNo;
        this.itemInfoNo = itemInfoNo;
        this.clientName = clientName;
        this.clientPrice = clientPrice;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientPrice() {
        return clientPrice;
    }

    public void setClientPrice(int clientPrice) {
        this.clientPrice = clientPrice;
    }

    @Override
    public String toString() {
        return "ClientContractItemDTO{" +
                "clientNo=" + clientNo +
                ", itemInfoNo=" + itemInfoNo +
                ", clientName='" + clientName + '\'' +
                ", clientPrice=" + clientPrice +
                '}';
    }
}
