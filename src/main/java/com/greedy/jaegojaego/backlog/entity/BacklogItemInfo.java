package com.greedy.jaegojaego.backlog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(name = "SUBDIVISION_YN")
    private String subdivisionYN;

    public BacklogItemInfo() {}

    public BacklogItemInfo(int itemInfoNo, String itemInfoName, String itemInfoItemSerialNo, String subdivisionYN) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemInfoItemSerialNo = itemInfoItemSerialNo;
        this.subdivisionYN = subdivisionYN;
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

    public String getSubdivisionYN() {
        return subdivisionYN;
    }

    public void setSubdivisionYN(String subdivisionYN) {
        this.subdivisionYN = subdivisionYN;
    }

    @Override
    public String toString() {
        return "BacklogItemInfo{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoItemSerialNo='" + itemInfoItemSerialNo + '\'' +
                ", subdivisionYN='" + subdivisionYN + '\'' +
                '}';
    }
}