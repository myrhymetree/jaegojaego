package com.greedy.jaegojaego.materials.model.dto;

import com.greedy.jaegojaego.materials.model.entity.ClientPK;

public class ClientContractItemDTO {

    private ClientPKDTO clientPK;
    private String clientItemName;
    private int clientPrice;
    private String clientName;
    private String clientEmail;
    private int clientPhone;
    private int registrationNo;
    private int clientNo;
    private int clientInfoNo;

    public ClientContractItemDTO() {
    }

    public ClientContractItemDTO(ClientPKDTO clientPK, String clientItemName, int clientPrice, String clientName, String clientEmail, int clientPhone, int registrationNo, int clientNo, int clientInfoNo) {
        this.clientPK = clientPK;
        this.clientItemName = clientItemName;
        this.clientPrice = clientPrice;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
        this.registrationNo = registrationNo;
        this.clientNo = clientNo;
        this.clientInfoNo = clientInfoNo;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public int getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(int clientPhone) {
        this.clientPhone = clientPhone;
    }

    public int getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(int registrationNo) {
        this.registrationNo = registrationNo;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public int getClientInfoNo() {
        return clientInfoNo;
    }

    public void setClientInfoNo(int clientInfoNo) {
        this.clientInfoNo = clientInfoNo;
    }

    @Override
    public String toString() {
        return "ClientContractItemDTO{" +
                "clientPK=" + clientPK +
                ", clientItemName='" + clientItemName + '\'' +
                ", clientPrice=" + clientPrice +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientPhone=" + clientPhone +
                ", registrationNo=" + registrationNo +
                ", clientNo=" + clientNo +
                ", clientInfoNo=" + clientInfoNo +
                '}';
    }
}
