package com.greedy.jaegojaego.materials.model.entity;

import javax.persistence.*;

@Entity(name = "materialsClientUpdateMaterial")
@Table(name = "CLIENT_CONTRACT_ITEM")
public class ClientMaterialUpdate {

    @Id
    @Column(name = "CLIENT_CONTRACT_ITEM_NO")
    private int clientItemNo;

    @Column(name = "ITEM_INFO_NO")
    private Integer itemInfoNo;

    public ClientMaterialUpdate() {
    }

    public ClientMaterialUpdate(int clientItemNo, Integer itemInfoNo) {
        this.clientItemNo = clientItemNo;
        this.itemInfoNo = itemInfoNo;
    }

    public int getClientItemNo() {
        return clientItemNo;
    }

    public void setClientItemNo(int clientItemNo) {
        this.clientItemNo = clientItemNo;
    }

    public Integer getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(Integer itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "ClientMaterialUpdate{" +
                "clientItemNo=" + clientItemNo +
                ", itemInfoNo=" + itemInfoNo +
                '}';
    }
}
