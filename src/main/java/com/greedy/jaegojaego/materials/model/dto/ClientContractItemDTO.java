package com.greedy.jaegojaego.materials.model.dto;

import com.greedy.jaegojaego.materials.model.entity.ClientContractInfoJoin;
import com.greedy.jaegojaego.materials.model.entity.ClientPK;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ClientContractItemDTO {

    private ClientPKDTO clientPKDTO;
    private String clientItemName;
    private int clientPrice;
    private ClientContractInfoJoinDTO clientContractInfoJoinDTO;
    private ClientDTO clientDTO;

    public ClientContractItemDTO() {
    }

    public ClientContractItemDTO(ClientPKDTO clientPKDTO, String clientItemName, int clientPrice, ClientContractInfoJoinDTO clientContractInfoJoinDTO, ClientDTO clientDTO) {
        this.clientPKDTO = clientPKDTO;
        this.clientItemName = clientItemName;
        this.clientPrice = clientPrice;
        this.clientContractInfoJoinDTO = clientContractInfoJoinDTO;
        this.clientDTO = clientDTO;
    }

    public ClientPKDTO getClientPKDTO() {
        return clientPKDTO;
    }

    public void setClientPKDTO(ClientPKDTO clientPKDTO) {
        this.clientPKDTO = clientPKDTO;
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

    public ClientContractInfoJoinDTO getClientContractInfoJoinDTO() {
        return clientContractInfoJoinDTO;
    }

    public void setClientContractInfoJoinDTO(ClientContractInfoJoinDTO clientContractInfoJoinDTO) {
        this.clientContractInfoJoinDTO = clientContractInfoJoinDTO;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    @Override
    public String toString() {
        return "ClientContractItemDTO{" +
                "clientPKDTO=" + clientPKDTO +
                ", clientItemName='" + clientItemName + '\'' +
                ", clientPrice=" + clientPrice +
                ", clientContractInfoJoinDTO=" + clientContractInfoJoinDTO +
                ", clientDTO=" + clientDTO +
                '}';
    }
}
