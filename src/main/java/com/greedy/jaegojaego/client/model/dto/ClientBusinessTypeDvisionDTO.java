package com.greedy.jaegojaego.client.model.dto;

public class ClientBusinessTypeDvisionDTO {

    private int clientBusinessTypeNo;
    private int clientNo;

    public ClientBusinessTypeDvisionDTO(int clientBusinessTypeNo, int clientNo) {
        this.clientBusinessTypeNo = clientBusinessTypeNo;
        this.clientNo = clientNo;
    }

    public int getClientBusinessTypeNo() {
        return clientBusinessTypeNo;
    }

    public void setClientBusinessTypeNo(int clientBusinessTypeNo) {
        this.clientBusinessTypeNo = clientBusinessTypeNo;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    @Override
    public String toString() {
        return "ClientBusinessTypeDevisionDTO{" +
                "clientBusinessTypeNo=" + clientBusinessTypeNo +
                ", clientNo=" + clientNo +
                '}';
    }
}
