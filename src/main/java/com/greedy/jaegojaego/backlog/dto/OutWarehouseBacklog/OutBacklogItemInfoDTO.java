package com.greedy.jaegojaego.backlog.dto.OutWarehouseBacklog;

public class OutBacklogItemInfoDTO {
    private int itemInfoNo;
    private String itemInfoName;
    private String itemInfoSerialNo;

    public OutBacklogItemInfoDTO() {}

    public OutBacklogItemInfoDTO(int itemInfoNo, String itemInfoName, String itemInfoSerialNo) {
        this.itemInfoNo = itemInfoNo;
        this.itemInfoName = itemInfoName;
        this.itemInfoSerialNo = itemInfoSerialNo;
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

    public String getItemInfoSerialNo() {
        return itemInfoSerialNo;
    }

    public void setItemInfoSerialNo(String itemInfoSerialNo) {
        this.itemInfoSerialNo = itemInfoSerialNo;
    }

    @Override
    public String toString() {
        return "OutBacklogItemInfoDTO{" +
                "itemInfoNo=" + itemInfoNo +
                ", itemInfoName='" + itemInfoName + '\'' +
                ", itemInfoSerialNo='" + itemInfoSerialNo + '\'' +
                '}';
    }
}
