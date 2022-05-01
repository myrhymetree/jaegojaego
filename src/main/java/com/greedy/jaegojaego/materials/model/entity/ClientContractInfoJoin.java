package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.*;

@Entity(name = "MaterialsClientInfo")
@Table(name = "CLIENT_CONTRACT_INFO")
public class ClientContractInfoJoin {

    @Id
    @Column(name = "CLIENT_CONTRACT_INFO_NO")
    private int clientInfoNo;

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private Client client;

    public ClientContractInfoJoin() {
    }

    public ClientContractInfoJoin(int clientInfoNo, Client client) {
        this.clientInfoNo = clientInfoNo;
        this.client = client;
    }

    public int getClientInfoNo() {
        return clientInfoNo;
    }

    public void setClientInfoNo(int clientInfoNo) {
        this.clientInfoNo = clientInfoNo;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ClientContractInfoJoin{" +
                "clientInfoNo=" + clientInfoNo +
                ", client=" + client +
                '}';
    }
}
