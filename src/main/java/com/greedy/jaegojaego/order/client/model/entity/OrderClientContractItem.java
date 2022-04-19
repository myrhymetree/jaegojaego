package com.greedy.jaegojaego.order.client.model.entity;

import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;
import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;

import javax.persistence.*;

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
