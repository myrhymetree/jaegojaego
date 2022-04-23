package com.greedy.jaegojaego.client.model.entity;

import com.greedy.jaegojaego.member.model.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Client_Contract_Item")
@Table(name = "CLIENT_CONTRACT_ITEM")
@SequenceGenerator(
        name = "CLIENT_CONTRACT_ITEM_SEQ_GENERATOR",
        sequenceName = "SEQ_CLIENT_CONTRACT_ITEM_NO",
        initialValue = 1,
        allocationSize = 1
)
public class ClientContractItem {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_CONTRACT_ITEM_SEQ_GENERATOR"
    )
    @Column(name = "CLIENT_CONTRACT_ITEM_NO")
    private int ClientContractItemNo;

    @Column(name = "CLIENT_CONTRACT_ITEM_NAME")
    private String ClientContractItemName;

    @Column(name = "CLIENT_CONTRACT_ITEM_SUPPLY_PRICE")
    private int ClientContractItemSupplyPrice;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private Member memberNo;

    @Column(name = "CLIENT_CONTRACT_ITEM_CREATED_DATE")
    private Date ClientContractItemCreatedDate;

    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_INFO_NO")
    private ClientContractInfo clientContractInfoNo;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private ClientItemInfo ItemInfoNo;

    public ClientContractItem(int clientContractItemNo, String clientContractItemName, int clientContractItemSupplyPrice, Member memberNo, Date clientContractItemCreatedDate, ClientContractInfo clientContractInfoNo, ClientItemInfo itemInfoNo) {
        ClientContractItemNo = clientContractItemNo;
        ClientContractItemName = clientContractItemName;
        ClientContractItemSupplyPrice = clientContractItemSupplyPrice;
        this.memberNo = memberNo;
        ClientContractItemCreatedDate = clientContractItemCreatedDate;
        this.clientContractInfoNo = clientContractInfoNo;
        ItemInfoNo = itemInfoNo;
    }

    public ClientContractItem() {

    }

    public int getClientContractItemNo() {
        return ClientContractItemNo;
    }

    public void setClientContractItemNo(int clientContractItemNo) {
        ClientContractItemNo = clientContractItemNo;
    }

    public String getClientContractItemName() {
        return ClientContractItemName;
    }

    public void setClientContractItemName(String clientContractItemName) {
        ClientContractItemName = clientContractItemName;
    }

    public int getClientContractItemSupplyPrice() {
        return ClientContractItemSupplyPrice;
    }

    public void setClientContractItemSupplyPrice(int clientContractItemSupplyPrice) {
        ClientContractItemSupplyPrice = clientContractItemSupplyPrice;
    }

    public Member getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Member memberNo) {
        this.memberNo = memberNo;
    }

    public Date getClientContractItemCreatedDate() {
        return ClientContractItemCreatedDate;
    }

    public void setClientContractItemCreatedDate(Date clientContractItemCreatedDate) {
        ClientContractItemCreatedDate = clientContractItemCreatedDate;
    }

    public ClientContractInfo getClientContractInfoNo() {
        return clientContractInfoNo;
    }

    public void setClientContractInfoNo(ClientContractInfo clientContractInfoNo) {
        this.clientContractInfoNo = clientContractInfoNo;
    }

    public ClientItemInfo getItemInfoNo() {
        return ItemInfoNo;
    }

    public void setItemInfoNo(ClientItemInfo itemInfoNo) {
        ItemInfoNo = itemInfoNo;
    }

    @Override
    public String toString() {
        return "ClientContractItem{" +
                "ClientContractItemNo=" + ClientContractItemNo +
                ", ClientContractItemName='" + ClientContractItemName + '\'' +
                ", ClientContractItemSupplyPrice=" + ClientContractItemSupplyPrice +
                ", memberNo=" + memberNo +
                ", ClientContractItemCreatedDate=" + ClientContractItemCreatedDate +
                ", clientContractInfoNo=" + clientContractInfoNo +
                ", ItemInfoNo=" + ItemInfoNo +
                '}';
    }
}
