package com.greedy.jaegojaego.materials.model.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity(name = "MaterialsClient")
@Table(name = "CLIENT_CONTRACT_ITEM")
public class ClientContractItem {

    @EmbeddedId
    private ClientPK clientPK;

    @Column(name = "CLIENT_CONTRACT_ITEM_NAME")
    private String clientName;

    @Column(name = "CLIENT_CONTRACT_ITEM_SUPPLY_PRICE")
    private int clientPrice;

    public ClientContractItem() {
    }

    public ClientContractItem(ClientPK clientPK, String clientName, int clientPrice) {
        this.clientPK = clientPK;
        this.clientName = clientName;
        this.clientPrice = clientPrice;
    }

    public ClientPK getClientPK() {
        return clientPK;
    }

    public void setClientPK(ClientPK clientPK) {
        this.clientPK = clientPK;
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
        return "ClientContractItem{" +
                "clientPK=" + clientPK +
                ", clientName='" + clientName + '\'' +
                ", clientPrice=" + clientPrice +
                '}';
    }
}
