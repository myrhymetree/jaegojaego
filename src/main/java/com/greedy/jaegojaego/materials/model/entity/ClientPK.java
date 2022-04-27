package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class ClientPK implements Serializable {

    @Column(name = "CLIENT_CONTRACT_ITEM_NO")
    private int clientNo;

    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    public ClientPK() {
    }

    public ClientPK(int clientNo, int itemInfoNo) {
        this.clientNo = clientNo;
        this.itemInfoNo = itemInfoNo;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "ClientPK{" +
                "clientNo=" + clientNo +
                ", itemInfoNo=" + itemInfoNo +
                '}';
    }
}
