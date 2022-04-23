package com.greedy.jaegojaego.client.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Client_Contract_Item_category_Intergrated")
@Table(name = "CLIENT_CONTRACT_ITEM_CATEGORY_INTERGRATED")
public class ClientItemCategoryIntergrated implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private Client clientNo;

    @Id
    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_ITEM_CATEGORY_NO")
    private ClientBusinessType clientContractItemCategoryNo;

    public ClientItemCategoryIntergrated(Client clientNo, ClientBusinessType clientContractItemCategoryNo) {
        this.clientNo = clientNo;
        this.clientContractItemCategoryNo = clientContractItemCategoryNo;
    }

    public ClientItemCategoryIntergrated() {

    }

    public Client getClientNo() {
        return clientNo;
    }

    public void setClientNo(Client clientNo) {
        this.clientNo = clientNo;
    }

    public ClientBusinessType getClientContractItemCategoryNo() {
        return clientContractItemCategoryNo;
    }

    public void setClientContractItemCategoryNo(ClientBusinessType clientContractItemCategoryNo) {
        this.clientContractItemCategoryNo = clientContractItemCategoryNo;
    }

    @Override
    public String toString() {
        return "ClientItemCategoryIntergrated{" +
                "clientNo=" + clientNo +
                ", clientContractItemCategoryNo=" + clientContractItemCategoryNo +
                '}';
    }
}

