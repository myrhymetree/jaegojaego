package com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;

import javax.persistence.*;
import java.util.List;

@Entity(name = "BacklogItemInfoEntity")
@Table(name = "ITEM_INFO")
public class BacklogItemInfo {

    @Id
    @Column(name = "ITEM_INFO_NO")
    private int itemInfoNo;

    @Column(name = "ITEM_INFO_NAME")
    private String itemInfoName;

    @Column(name = "ITEM_INFO_ITEM_SERIAL_NO")
    private String itemInfoItemSerialNo;

//    @OneToMany
//    @Column(name = "ITEM_INFO_NO")
//    private List<BacklogClientContractItem> clientContractItemList;

    public BacklogItemInfo() {}

    public BacklogItemInfo(int itemInfoNo, String itemInfoName, String itemInfoItemSerialNo) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
    }

    public int getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(int itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public String getItemInfoName() {
        return itemInfoName;
    }

    public void setItemInfoName(String itemInfoName) {
        this.itemInfoName = itemInfoName;
    }

    public String getItemInfoItemSerialNo() {
        return itemInfoItemSerialNo;
    }

    public void setItemInfoItemSerialNo(String itemInfoItemSerialNo) {
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
    }

    @Override
    public String toString() {
        return "BacklogItemInfo{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoItemSerialNo='" + itemInfoItemSerialNo + '\'' +
                '}';
    }
}
