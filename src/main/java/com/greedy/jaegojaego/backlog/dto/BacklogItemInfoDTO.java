package com.greedy.jaegojaego.backlog.dto;

public class BacklogItemInfoDTO {
    private int itemInfoNo;
    private String itemInfoName;
    private String itemInfoItemSerialNo;
    private String subdivisionYN; //자재가공유무

    public BacklogItemInfoDTO() {}

    public BacklogItemInfoDTO(int itemInfoNo, String itemInfoName, String itemInfoItemSerialNo, String subdivisionYN) {
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
        return "BacklogItemInfoDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoItemSerialNo='" + itemInfoItemSerialNo + '\'' +
                ", subdivisionYN='" + subdivisionYN + '\'' +
                '}';
    }
}
