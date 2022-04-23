package com.greedy.jaegojaego.client.model.dto;

public class ClientMemberDTO {

    private int clientMemberNo;
    private String clientMemberName;

    public ClientMemberDTO(){}

    public ClientMemberDTO(int clientMemberNo, String clientMemberName) {
        this.clientMemberNo = clientMemberNo;
        this.clientMemberName = clientMemberName;
    }

    public int getClientMemberNo() {
        return clientMemberNo;
    }

    public void setClientMemberNo(int clientMemberNo) {
        this.clientMemberNo = clientMemberNo;
    }

    public String getClientMemberName() {
        return clientMemberName;
    }

    public void setClientMemberName(String clientMemberName) {
        this.clientMemberName = clientMemberName;
    }

    @Override
    public String toString() {
        return "ClientMemberDTO{" +
                "clientMemberNo=" + clientMemberNo +
                ", clientMemberName='" + clientMemberName + '\'' +
                '}';
    }
}
