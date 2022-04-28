package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "MaterialsClient")
@Table(name = "CLIENT")
public class Client {

    @Id
    @Column(name = "CLIENT_NO")
    private int clientNo;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "CLIENT_REPRESENTATIVE_EMAIL")
    private String clientEmail;

    @Column(name = "CLIENT_REPRESENTATIVE_PHONE")
    private int clientPhone;

    @Column(name = "CLIENT_CERTIFICATE_OF_BUSINESS_REGISTRATION_NO")
    private int registrationNo;

    public Client() {
    }

    public Client(int clientNo, String clientName, String clientEmail, int clientPhone, int registrationNo) {
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

    @Override
    public String toString() {
        return "Client{" +
                "clientNo=" + clientNo +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientPhone=" + clientPhone +
                ", registrationNo=" + registrationNo +
                '}';
    }
}
