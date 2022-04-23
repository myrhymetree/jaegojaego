package com.greedy.jaegojaego.client.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Client_Business_Item_Division")
@Table(name = "CLIENT_BUSINESS_ITEM_DIVISION")
public class ClientBusinessItemDivision implements Serializable {


    @Id
    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private Client clientNo;

    @Id
    @ManyToOne
    @JoinColumn(name = "CLIENT_BUSINESS_ITEM_NO")
    private ClientBusinessItem clientBusinessItemNo;

    public ClientBusinessItemDivision(Client clientNo, ClientBusinessItem clientBusinessItemNo) {
        this.clientNo = clientNo;
        this.clientBusinessItemNo = clientBusinessItemNo;
    }

    public ClientBusinessItemDivision() {

    }

    public Client getClientNo() {
        return clientNo;
    }

    public void setClientNo(Client clientNo) {
        this.clientNo = clientNo;
    }

    public ClientBusinessItem getClientBusinessItemNo() {
        return clientBusinessItemNo;
    }

    public void setClientBusinessItemNo(ClientBusinessItem clientBusinessItemNo) {
        this.clientBusinessItemNo = clientBusinessItemNo;
    }

    @Override
    public String toString() {
        return "ClientBusinessItemDivision{" +
                "clientNo=" + clientNo +
                ", clientBusinessItemNo=" + clientBusinessItemNo +
                '}';
    }
}

