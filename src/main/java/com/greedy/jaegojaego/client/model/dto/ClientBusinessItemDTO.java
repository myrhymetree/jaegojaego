package com.greedy.jaegojaego.client.model.dto;

public class ClientBusinessItemDTO {

    private int clientBusinessItemNo;
    private String clientBusinessItemName;

    public ClientBusinessItemDTO(){}

    public ClientBusinessItemDTO(int clientBusinessItemNo, String clientBusinessItemName) {
        this.clientBusinessItemNo = clientBusinessItemNo;
        this.clientBusinessItemName = clientBusinessItemName;
    }

    public int getClientBusinessItemNo() {
        return clientBusinessItemNo;
    }

    public void setClientBusinessItemNo(int clientBusinessItemNo) {
        this.clientBusinessItemNo = clientBusinessItemNo;
    }

    public String getClientBusinessItemName() {
        return clientBusinessItemName;
    }

    public void setClientBusinessItemName(String clientBusinessItemName) {
        this.clientBusinessItemName = clientBusinessItemName;
    }

    @Override
    public String toString() {
        return "ClientBusinessItemDTO{" +
                "clientBusinessItemNo=" + clientBusinessItemNo +
                ", clientBusinessItemName='" + clientBusinessItemName + '\'' +
                '}';
    }
}
