package com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog;

public class BacklogClientContractItemDTO {

    private int clientContractItemNo;   //거래처 판매 계약 상품 번호 pk
    private BacklogItemInfoDTO itemInfoNoForClientContractItem; //자재번호
    private String clientContractItemName; //거래처 판매 계약 상품 상품명

    public BacklogClientContractItemDTO() {}

    public BacklogClientContractItemDTO(int clientContractItemNo, BacklogItemInfoDTO itemInfoNoForClientContractItem, String clientContractItemName) {
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

    public BacklogItemInfoDTO getItemInfoNoForClientContractItem() {
        return itemInfoNoForClientContractItem;
    }

    public void setItemInfoNoForClientContractItem(BacklogItemInfoDTO itemInfoNoForClientContractItem) {
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
        return "BacklogClientContractItemDTO{" +
                "clientContractItemNo=" + clientContractItemNo +
                ", itemInfoNoForClientContractItem=" + itemInfoNoForClientContractItem +
                ", clientContractItemName='" + clientContractItemName + '\'' +
                '}';
    }
}
