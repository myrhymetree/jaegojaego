package com.greedy.jaegojaego.client.model.entity;

import com.greedy.jaegojaego.member.model.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Client_Contract_Item")
@Table(name = "CLIENT_CONTRACT_ITEM")
@SequenceGenerator(
        name = "CLIENT_CONTRACT_ITEM_SEQ_GENERATOR",
        sequenceName = "CLIENT_CONTRACT_ITEM_NO",
        initialValue = 1,
        allocationSize = 1
)
@Data
public class ClientContractItem {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_CONTRACT_ITEM_SEQ_GENERATOR"
    )
    @Column(name = "CLIENT_CONTRACT_ITEM_NO")
    private int clientContractItemNo;

    @Column(name = "CLIENT_CONTRACT_ITEM_NAME")
    private String clientContractItemName;

    @Column(name = "CLIENT_CONTRACT_ITEM_SUPPLY_PRICE")
    private int clientContractItemSupplyPrice;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private Member memberNo;

    @Column(name = "CLIENT_CONTRACT_ITEM_CREATED_DATE")
    private Date clientContractItemCreatedDate;

    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_INFO_NO")
    private ClientContractInfo clientContractInfoNo;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private ClientItemInfo itemInfoNo;


}
