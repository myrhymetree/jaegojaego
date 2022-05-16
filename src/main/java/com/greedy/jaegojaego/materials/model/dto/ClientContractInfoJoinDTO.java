package com.greedy.jaegojaego.materials.model.dto;

public class ClientContractInfoJoinDTO {

    private int clientInfoNo;
    private ClientDTO client;

    public ClientContractInfoJoinDTO() {
    }

    public ClientContractInfoJoinDTO(int clientInfoNo, ClientDTO client) {
        this.clientInfoNo = clientInfoNo;
        this.client = client;
    }

    public int getClientInfoNo() {
        return clientInfoNo;
    }

    public void setClientInfoNo(int clientInfoNo) {
        this.clientInfoNo = clientInfoNo;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ClientContractInfoJoinDTO{" +
                "clientInfoNo=" + clientInfoNo +
                ", client=" + client +
                '}';
    }
}
