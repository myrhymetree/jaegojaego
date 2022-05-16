package com.greedy.jaegojaego.client.model.entity;

import javax.persistence.*;

@Entity(name = "Client_Item_Info")
@Table(name = "ITEM_INFO")
public class ClientItemInfo {
        @Id
        @Column(name = "ITEM_INFO_NO")
        private int itemInfoNo;

    public ClientItemInfo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public ClientItemInfo() {

    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "ClientItemInfo{" +
                "itemInfoNo=" + itemInfoNo +
                '}';
    }
}
