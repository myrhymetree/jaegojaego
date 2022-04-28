package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.*;

@Entity(name = "MaterialsClientItem")
@Table(name = "CLIENT_CONTRACT_ITEM")
public class ClientContractItem {

    @EmbeddedId
    private ClientPK clientPK;

    @Column(name = "CLIENT_CONTRACT_ITEM_NAME")
    private String clientItemName;

    @Column(name = "CLIENT_CONTRACT_ITEM_SUPPLY_PRICE")
    private int clientPrice;

    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_INFO_NO")
    private ClientContractInfoJoin clientContractInfoJoin;

    public ClientContractItem() {
    }

    public ClientContractItem(ClientPK clientPK, String clientItemName, int clientPrice, ClientContractInfoJoin clientContractInfoJoin) {
        this.clientPK = clientPK;
        this.clientItemName = clientItemName;
        this.clientPrice = clientPrice;
        this.clientContractInfoJoin = clientContractInfoJoin;
    }

    public ClientPK getClientPK() {
        return clientPK;
    }

    public void setClientPK(ClientPK clientPK) {
        this.clientPK = clientPK;
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
        return "ClientContractItem{" +
                "clientPK=" + clientPK +
                ", clientItemName='" + clientItemName + '\'' +
                ", clientPrice=" + clientPrice +
                ", clientContractInfoJoin=" + clientContractInfoJoin +
                '}';
    }
}
