package com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogClientContractItem;

import java.util.List;

public class BacklogItemInfoDTO {
    private int itemInfoNo;
    private String itemInfoName;
    private String itemInfoItemSerialNo;
//    private List<BacklogClientContractItem> clientContractItemList;

    public BacklogItemInfoDTO() {}

    public BacklogItemInfoDTO(int itemInfoNo, String itemInfoName, String itemInfoItemSerialNo) {
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
        return "BacklogItemInfoDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoItemSerialNo='" + itemInfoItemSerialNo + '\'' +
                '}';
    }
}
