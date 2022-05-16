package com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogClientContractItemDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogItemInfoDTO;

import javax.persistence.*;

@Entity(name = "BacklogClientContractItemEntity")
@Table(name = "CLIENT_CONTRACT_ITEM")
public class BacklogClientContractItem {

    @Id
    @Column(name = "CLIENT_CONTRACT_ITEM_NO")
    private int clientContractItemNo;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private BacklogItemInfo itemInfoNoForClientContractItem;

    @Column(name = "CLIENT_CONTRACT_ITEM_NAME")
    private String clientContractItemName;

    public BacklogClientContractItem() {}

    public BacklogClientContractItem(int clientContractItemNo, BacklogItemInfo itemInfoNoForClientContractItem, String clientContractItemName) {
        this.clientContractItemNo = clientContractItemNo;
        this.itemInfoNoForClientContractItem = itemInfoNoForClientContractItem;
        this.clientContractItemName = clientContractItemName;
    }

    public int getClientContractItemNo() {
        return clientContractItemNo;
    }

    public void setClientContractItemNo(int clientContractItemNo) {
        this.clientContractItemNo = clientContractItemNo;
    }

    public BacklogItemInfo getItemInfoNoForClientContractItem() {
        return itemInfoNoForClientContractItem;
    }

    public void setItemInfoNoForClientContractItem(BacklogItemInfo itemInfoNoForClientContractItem) {
        this.itemInfoNoForClientContractItem = itemInfoNoForClientContractItem;
    }

    public String getClientContractItemName() {
        return clientContractItemName;
    }

    public void setClientContractItemName(String clientContractItemName) {
        this.clientContractItemName = clientContractItemName;
    }

    @Override
    public String toString() {
        return "BacklogClientContractItem{" +
                "clientContractItemNo=" + clientContractItemNo +
                ", itemInfoNoForClientContractItem=" + itemInfoNoForClientContractItem +
                ", clientContractItemName='" + clientContractItemName + '\'' +
                '}';
    }
}
