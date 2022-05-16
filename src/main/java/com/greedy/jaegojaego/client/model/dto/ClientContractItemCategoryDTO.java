package com.greedy.jaegojaego.client.model.dto;

public class ClientContractItemCategoryDTO {

    private int clientContractItemCategoryNo;
    private String clientContractItemCategoryName;

    public ClientContractItemCategoryDTO(){}

    public ClientContractItemCategoryDTO(int clientContractItemCategoryNo, String clientContractItemCategoryName) {
        this.clientContractItemCategoryNo = clientContractItemCategoryNo;
        this.clientContractItemCategoryName = clientContractItemCategoryName;
    }

    public int getClientContractItemCategoryNo() {
        return clientContractItemCategoryNo;
    }

    public void setClientContractItemCategoryNo(int clientContractItemCategoryNo) {
        this.clientContractItemCategoryNo = clientContractItemCategoryNo;
    }

    public String getClientContractItemCategoryName() {
        return clientContractItemCategoryName;
    }

    public void setClientContractItemCategoryName(String clientContractItemCategoryName) {
        this.clientContractItemCategoryName = clientContractItemCategoryName;
    }

    @Override
    public String toString() {
        return "ClientContractItemCategoryDTO{" +
                "clientContractItemCategoryNo=" + clientContractItemCategoryNo +
                ", clientContractItemCategoryName='" + clientContractItemCategoryName + '\'' +
                '}';
    }
}
