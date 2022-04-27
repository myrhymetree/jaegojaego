package com.greedy.jaegojaego.client.model.dto;

public class ClientBusinessTypeDTO {

    private int clientBusinessTypeNo;
    private String clientBusinessTypeName;

    public ClientBusinessTypeDTO(){}

    public ClientBusinessTypeDTO(int clientBusinessTypeNo, String clientBusinessTypeName) {
        this.clientBusinessTypeNo = clientBusinessTypeNo;
        this.clientBusinessTypeName = clientBusinessTypeName;
    }

    public int getClientBusinessTypeNo() {
        return clientBusinessTypeNo;
    }

    public void setClientBusinessTypeNo(int clientBusinessTypeNo) {
        this.clientBusinessTypeNo = clientBusinessTypeNo;
    }

    public String getClientBusinessTypeName() {
        return clientBusinessTypeName;
    }

    public void setClientBusinessTypeName(String clientBusinessTypeName) {
        this.clientBusinessTypeName = clientBusinessTypeName;
    }

    @Override
    public String toString() {
        return "ClientBusinessTypeDTO{" +
                "clientBusinessTypeNo=" + clientBusinessTypeNo +
                ", clientBusinessTypeName='" + clientBusinessTypeName + '\'' +
                '}';
    }
}
