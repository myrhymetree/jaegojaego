package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.*;

@Entity(name = "MaterialsClientItemMaterial")
@Table(name = "CLIENT_CONTRACT_ITEM")
public class ClientContractItemMaterial {

    @Id
    @Column(name = "CLIENT_CONTRACT_ITEM_NO")
    private int clientItemNo;

    @Column(name = "ITEM_INFO_NO")
    private Integer itemInfoNo;

    @Column(name = "CLIENT_CONTRACT_ITEM_NAME")
    private String clientItemName;

    @Column(name = "CLIENT_CONTRACT_ITEM_SUPPLY_PRICE")
    private int clientPrice;

    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_INFO_NO")
    private ClientContractInfoJoin clientContractInfoJoin;

    public ClientContractItemMaterial() {
    }

    public ClientContractItemMaterial(int clientItemNo, Integer itemInfoNo, String clientItemName, int clientPrice, ClientContractInfoJoin clientContractInfoJoin) {
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

    public ClientContractInfoJoin getClientContractInfoJoin() {
        return clientContractInfoJoin;
    }

    public void setClientContractInfoJoin(ClientContractInfoJoin clientContractInfoJoin) {
        this.clientContractInfoJoin = clientContractInfoJoin;
    }

    @Override
    public String toString() {
        return "ClientContractItem2{" +
                "clientItemNo=" + clientItemNo +
                ", itemInfoNo=" + itemInfoNo +
                ", clientItemName='" + clientItemName + '\'' +
                ", clientPrice=" + clientPrice +
                ", clientContractInfoJoin=" + clientContractInfoJoin +
                '}';
    }
}
