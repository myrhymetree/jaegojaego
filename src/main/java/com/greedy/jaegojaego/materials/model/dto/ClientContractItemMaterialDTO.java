package com.greedy.jaegojaego.materials.model.dto;

public class ClientContractItemMaterialDTO {

    private int clientItemNo;
    private Integer itemInfoNo;
    private String clientItemName;
    private int clientPrice;
    private ClientContractInfoJoinDTO clientContractInfoJoin;

    public ClientContractItemMaterialDTO() {
    }

    public ClientContractItemMaterialDTO(int clientItemNo, Integer itemInfoNo, String clientItemName, int clientPrice, ClientContractInfoJoinDTO clientContractInfoJoin) {
        this.clientItemNo = clientItemNo;
        this.itemInfoNo = itemInfoNo;
        this.clientItemName = clientItemName;
        this.clientPrice = clientPrice;
        this.clientContractInfoJoin = clientContractInfoJoin;
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

    public String getClientItemName() {
        return clientItemName;
    }

    public void setClientItemName(String clientItemName) {
        this.clientItemName = clientItemName;
    }

    public int getClientPrice() {
        return clientPrice;
    }

    public void setClientPrice(int clientPrice) {
        this.clientPrice = clientPrice;
    }

    public ClientContractInfoJoinDTO getClientContractInfoJoin() {
        return clientContractInfoJoin;
    }

    public void setClientContractInfoJoin(ClientContractInfoJoinDTO clientContractInfoJoin) {
        this.clientContractInfoJoin = clientContractInfoJoin;
    }

    @Override
    public String toString() {
        return "ClientContractItemDTO2{" +
                "clientItemNo=" + clientItemNo +
                ", itemInfoNo=" + itemInfoNo +
                ", clientItemName='" + clientItemName + '\'' +
                ", clientPrice=" + clientPrice +
                ", clientContractInfoJoin=" + clientContractInfoJoin +
                '}';
    }
}
