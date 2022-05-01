package com.greedy.jaegojaego.materials.model.dto;

import com.greedy.jaegojaego.materials.model.entity.ClientContractInfoJoin;
import com.greedy.jaegojaego.materials.model.entity.ClientPK;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ClientContractItemDTO {

    private ClientPKDTO clientPK;
    private String clientItemName;
    private int clientPrice;
    private ClientContractInfoJoinDTO clientContractInfoJoin;

    public ClientContractItemDTO() {
    }

    public ClientContractItemDTO(ClientPKDTO clientPK, String clientItemName, int clientPrice, ClientContractInfoJoinDTO clientContractInfoJoin) {
        this.clientPK = clientPK;
        this.clientItemName = clientItemName;
        this.clientPrice = clientPrice;
        this.clientContractInfoJoin = clientContractInfoJoin;
    }

    public ClientPKDTO getClientPK() {
        return clientPK;
    }

    public void setClientPK(ClientPKDTO clientPK) {
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

    public ClientContractInfoJoinDTO getClientContractInfoJoin() {
        return clientContractInfoJoin;
    }

    public void setClientContractInfoJoin(ClientContractInfoJoinDTO clientContractInfoJoin) {
        this.clientContractInfoJoin = clientContractInfoJoin;
    }

    @Override
    public String toString() {
        return "ClientContractItemDTO{" +
                "clientPK=" + clientPK +
                ", clientItemName='" + clientItemName + '\'' +
                ", clientPrice=" + clientPrice +
                ", clientContractInfoJoin=" + clientContractInfoJoin +
                '}';
    }
}
