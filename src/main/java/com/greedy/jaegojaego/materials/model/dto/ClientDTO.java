package com.greedy.jaegojaego.materials.model.dto;

import javax.persistence.Column;

public class ClientDTO {

    private int clientNo;
    private String clientName;
    private String clientEmail;
    private String clientPhone;
    private String registrationNo;

    public ClientDTO() {
    }

    public ClientDTO(int clientNo, String clientName, String clientEmail, String clientPhone, String registrationNo) {
        this.clientNo = clientNo;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
        this.registrationNo = registrationNo;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
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

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "clientNo=" + clientNo +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                ", registrationNo='" + registrationNo + '\'' +
                '}';
    }
}
