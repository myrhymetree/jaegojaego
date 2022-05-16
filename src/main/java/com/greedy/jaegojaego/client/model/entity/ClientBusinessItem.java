package com.greedy.jaegojaego.client.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Client_Business_Item")
@Table(name = "CLIENT_BUSINESS_ITEM")
@SequenceGenerator(
        name = "CLIENT_BUSINESS_ITEM_SEQ_GENERATOR",
        sequenceName = "SEQ_CLIENT_BUSINESS_ITEM_NO",
        initialValue = 1,
        allocationSize = 1
)
public class ClientBusinessItem {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_BUSINESS_ITEM_SEQ_GENERATOR"
    )
    @Column(name = "CLIENT_BUSINESS_ITEM_NO")
    private int clientBusinessItemNo;

    @Column(name = "CLIENT_BUSINESS_ITEM_NAME")
    private String clientBusinessItemName;

    public ClientBusinessItem(int clientBusinessItemNo, String clientBusinessItemName) {
        this.clientBusinessItemNo = clientBusinessItemNo;
        this.clientBusinessItemName = clientBusinessItemName;
    }

    public ClientBusinessItem() {

    }

    public int getClientBusinessItemNo() {
        return clientBusinessItemNo;
    }

    public void setClientBusinessItemNo(int clientBusinessItemNo) {
        this.clientBusinessItemNo = clientBusinessItemNo;
    }

    public String getClientBusinessItemName() {
        return clientBusinessItemName;
    }

    public void setClientBusinessItemName(String clientBusinessItemName) {
        this.clientBusinessItemName = clientBusinessItemName;
    }

    @Override
    public String toString() {
        return "ClientBusinessItem{" +
                "clientBusinessItemNo=" + clientBusinessItemNo +
                ", clientBusinessItemName='" + clientBusinessItemName + '\'' +
                '}';
    }
}
