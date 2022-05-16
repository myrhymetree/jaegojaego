package com.greedy.jaegojaego.order.client.model.entity;

import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;
import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "orderClientContractItem")
@Table(name = "CLIENT_CONTRACT_ITEM")
@SequenceGenerator(
        name = "CLIENT_CONTRACT_ITEM_SEQ_GENERATOR",
        sequenceName = "CLIENT_CONTRACT_ITEM_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OrderClientContractItem {

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

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private OrderCompanyAccount orderCompanyAccount;

    @Column(name = "CLIENT_CONTRACT_ITEM_CREATED_DATE")
    private java.sql.Date clientContractItemCreatedDate;

    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_INFO_NO")
    private OrderClientContractInfo orderClientContractInfo;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OrderItemInfo orderItemInfo;

    public OrderClientContractItem() {
    }

    public OrderClientContractItem(int clientContractItemNo, String clientContractItemName, int clientContractItemSupplyPrice, OrderCompanyAccount orderCompanyAccount, Date clientContractItemCreatedDate, OrderClientContractInfo orderClientContractInfo, OrderItemInfo orderItemInfo) {
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

    public OrderCompanyAccount getOrderCompanyAccount() {
        return orderCompanyAccount;
    }

    public void setOrderCompanyAccount(OrderCompanyAccount orderCompanyAccount) {
        this.orderCompanyAccount = orderCompanyAccount;
    }

    public Date getClientContractItemCreatedDate() {
        return clientContractItemCreatedDate;
    }

    public void setClientContractItemCreatedDate(Date clientContractItemCreatedDate) {
        this.clientContractItemCreatedDate = clientContractItemCreatedDate;
    }

    public OrderClientContractInfo getOrderClientContractInfo() {
        return orderClientContractInfo;
    }

    public void setOrderClientContractInfo(OrderClientContractInfo orderClientContractInfo) {
        this.orderClientContractInfo = orderClientContractInfo;
    }

    public OrderItemInfo getOrderItemInfo() {
        return orderItemInfo;
    }

    public void setOrderItemInfo(OrderItemInfo orderItemInfo) {
        this.orderItemInfo = orderItemInfo;
    }

    @Override
    public String toString() {
        return "ClientContractItem{" +
                "clientContractItemNo=" + clientContractItemNo +
                ", clientContractItemName='" + clientContractItemName + '\'' +
                ", clientContractItemSupplyPrice=" + clientContractItemSupplyPrice +
                ", companyAccount=" + orderCompanyAccount +
                ", clientContractItemCreatedDate=" + clientContractItemCreatedDate +
                ", clientContractInfo=" + orderClientContractInfo +
                '}';
    }
}
