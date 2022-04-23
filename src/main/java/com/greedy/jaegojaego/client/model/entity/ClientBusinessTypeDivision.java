package com.greedy.jaegojaego.client.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Client_Business_Type_Division")
@Table(name = "CLIENT_BUSINESS_TYPE_DIVISION")
public class ClientBusinessTypeDivision implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private Client clientNo;

    @Id
    @ManyToOne
    @JoinColumn(name = "CLIENT_BUSINESS_TYPE_NO")
    private ClientBusinessType clientBusinessTypeNo;

    public ClientBusinessTypeDivision(Client clientNo, ClientBusinessType clientBusinessTypeNo) {
        this.clientNo = clientNo;
        this.clientBusinessTypeNo = clientBusinessTypeNo;
    }

    public ClientBusinessTypeDivision() {

    }

    public Client getClientNo() {
        return clientNo;
    }

    public void setClientNo(Client clientNo) {
        this.clientNo = clientNo;
    }

    public ClientBusinessType getClientBusinessTypeNo() {
        return clientBusinessTypeNo;
    }

    public void setClientBusinessTypeNo(ClientBusinessType clientBusinessTypeNo) {
        this.clientBusinessTypeNo = clientBusinessTypeNo;
    }

    @Override
    public String toString() {
        return "ClientBusinessTypeDivision{" +
                "clientNo=" + clientNo +
                ", clientBusinessTypeNo=" + clientBusinessTypeNo +
                '}';
    }
}
