package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class ClientPK implements Serializable {

    @Column(name = "CLIENT_CONTRACT_ITEM_NO")
    private int clientItemNo;

    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    public ClientPK() {
    }

    public ClientPK(int clientItemNo, int itemInfoNo) {
        this.clientItemNo = clientItemNo;
        this.itemInfoNo = itemInfoNo;
    }

    public int getClientItemNo() {
        return clientItemNo;
    }

    public void setClientItemNo(int clientItemNo) {
        this.clientItemNo = clientItemNo;
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
                "clientItemNo=" + clientItemNo +
                ", itemInfoNo=" + itemInfoNo +
                '}';
    }
}
