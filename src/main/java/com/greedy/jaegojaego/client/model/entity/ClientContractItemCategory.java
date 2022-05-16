package com.greedy.jaegojaego.client.model.entity;

import javax.persistence.*;

@Entity(name = "Client_Contract_Item_category")
@Table(name = "CLIENT_CONTRACT_ITEM_CATEGORY")
@SequenceGenerator(
        name = "CLIENT_CONTRACT_ITEM_CATEGORY_SEQ_GENERATOR",
        sequenceName = "SEQ_CLIENT_CONTRACT_ITEM_CATEGORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class ClientContractItemCategory {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_CONTRACT_ITEM_CATEGORY_SEQ_GENERATOR"
    )
    @Column(name = "CLIENT_CONTRACT_ITEM_CATEGORY_NO")
    private int clientContractItemCategoryNo;

    @Column(name = "CLIENT_CONTRACT_ITEM_CATEGORY_NAME")
    private String clientContractItemCategoryName;

    public ClientContractItemCategory(int clientContractItemCategoryNo, String clientContractItemCategoryName) {
        this.clientContractItemCategoryNo = clientContractItemCategoryNo;
        this.clientContractItemCategoryName = clientContractItemCategoryName;
    }

    public ClientContractItemCategory() {

    }

    public int getClientContractItemCategoryNo() {
        return clientContractItemCategoryNo;
    }

    public void setClientContractItemCategoryNo(int clientContractItemCategoryNo) {
        this.clientContractItemCategoryNo = clientContractItemCategoryNo;
    }

    public String getClientContractItemCategoryName() {
        return clientContractItemCategoryName;
    }

    public void setClientContractItemCategoryName(String clientContractItemCategoryName) {
        this.clientContractItemCategoryName = clientContractItemCategoryName;
    }

    @Override
    public String toString() {
        return "ClientContractItemCategory{" +
                "clientContractItemCategoryNo=" + clientContractItemCategoryNo +
                ", clientContractItemCategoryName='" + clientContractItemCategoryName + '\'' +
                '}';
    }
}
