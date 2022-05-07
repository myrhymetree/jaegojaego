package com.greedy.jaegojaego.warehouse.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "warehouseClientContractItem")
@Table(name = "CLIENT_CONTRACT_ITEM")
@SequenceGenerator(
        name = "CLIENT_CONTRACT_ITEM_SEQ_GENERATOR",
        sequenceName = "CLIENT_CONTRACT_ITEM_NO",
        initialValue = 1,
        allocationSize = 1
)
public class WarehouseClientContractItem {

    @Id
    @Column(name = "CLIENT_CONTRACT_ITEM_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_CONTRACT_ITEM_SEQ_GENERATOR"
    )
    private int clientContractItemNo;

    @Column(name = "CLIENT_CONTRACT_ITEM_NAME")
    private String clientContractItemName;

    @Column(name = "CLIENT_CONTRACT_ITEM_SUPPLY_PRICE")
    private int clientContractItemSupplyPrice;

    @Column(name = "MEMBER_NO")
    private int orderCompanyAccount;

    @Column(name = "CLIENT_CONTRACT_ITEM_CREATED_DATE")
    private java.sql.Date clientContractItemCreatedDate;

    @JoinColumn(name = "CLIENT_CONTRACT_INFO_NO")
    private int orderClientContractInfo;

    @JoinColumn(name = "ITEM_INFO_NO")
    private int orderItemInfo;

    public WarehouseClientContractItem() {}

    public WarehouseClientContractItem(int clientContractItemNo, String clientContractItemName, int clientContractItemSupplyPrice, int orderCompanyAccount, Date clientContractItemCreatedDate, int orderClientContractInfo, int orderItemInfo) {
        this.clientContractItemNo = clientContractItemNo;
        this.clientContractItemName = clientContractItemName;
        this.clientContractItemSupplyPrice = clientContractItemSupplyPrice;
        this.orderCompanyAccount = orderCompanyAccount;
        this.clientContractItemCreatedDate = clientContractItemCreatedDate;
        this.orderClientContractInfo = orderClientContractInfo;
        this.orderItemInfo = orderItemInfo;
    }

    public int getClientContractItemNo() {
        return clientContractItemNo;
    }

    public void setClientContractItemNo(int clientContractItemNo) {
        this.clientContractItemNo = clientContractItemNo;
    }

    public String getClientContractItemName() {
        return clientContractItemName;
    }

    public void setClientContractItemName(String clientContractItemName) {
        this.clientContractItemName = clientContractItemName;
    }

    public int getClientContractItemSupplyPrice() {
        return clientContractItemSupplyPrice;
    }

    public void setClientContractItemSupplyPrice(int clientContractItemSupplyPrice) {
        this.clientContractItemSupplyPrice = clientContractItemSupplyPrice;
    }

    public int getOrderCompanyAccount() {
        return orderCompanyAccount;
    }

    public void setOrderCompanyAccount(int orderCompanyAccount) {
        this.orderCompanyAccount = orderCompanyAccount;
    }

    public Date getClientContractItemCreatedDate() {
        return clientContractItemCreatedDate;
    }

    public void setClientContractItemCreatedDate(Date clientContractItemCreatedDate) {
        this.clientContractItemCreatedDate = clientContractItemCreatedDate;
    }

    public int getOrderClientContractInfo() {
        return orderClientContractInfo;
    }

    public void setOrderClientContractInfo(int orderClientContractInfo) {
        this.orderClientContractInfo = orderClientContractInfo;
    }

    public int getOrderItemInfo() {
        return orderItemInfo;
    }

    public void setOrderItemInfo(int orderItemInfo) {
        this.orderItemInfo = orderItemInfo;
    }

    @Override
    public String toString() {
        return "WarehouseClientContractItem{" +
                "clientContractItemNo=" + clientContractItemNo +
                ", clientContractItemName='" + clientContractItemName + '\'' +
                ", clientContractItemSupplyPrice=" + clientContractItemSupplyPrice +
                ", orderCompanyAccount=" + orderCompanyAccount +
                ", clientContractItemCreatedDate=" + clientContractItemCreatedDate +
                ", orderClientContractInfo=" + orderClientContractInfo +
                ", orderItemInfo=" + orderItemInfo +
                '}';
    }
}
