package com.greedy.jaegojaego.client.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Client_Business_Type")
@Table(name = "CLIENT_BUSINESS_TYPE")
@SequenceGenerator(
        name = "CLIENT_BUSINESS_TYPE_SEQ_GENERATOR",
        sequenceName = "SEQ_CLIENT_BUSINESS_TYPE_NO",
        initialValue = 1,
        allocationSize = 1
)
public class ClientBusinessType {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_BUSINESS_TYPE_SEQ_GENERATOR"
    )
    @Column(name = "CLIENT_BUSINESS_TYPE_NO")
    private int clientBusinessTypeNo;

    @Column(name = "CLIENT_BUSINESS_TYPE_NAME")
    private String clientBusinessTypeName;

    public ClientBusinessType(int clientBusinessTypeNo, String clientBusinessTypeName) {
        this.clientBusinessTypeNo = clientBusinessTypeNo;
        this.clientBusinessTypeName = clientBusinessTypeName;
    }

    public ClientBusinessType() {

    }

    public int getClientBusinessTypeNo() {
        return clientBusinessTypeNo;
    }

    public void setClientBusinessTypeNo(int clientBusinessTypeNo) {
        this.clientBusinessTypeNo = clientBusinessTypeNo;
    }

    public String getClientBusinessTypeName() {
        return clientBusinessTypeName;
    }

    public void setClientBusinessTypeName(String clientBusinessTypeName) {
        this.clientBusinessTypeName = clientBusinessTypeName;
    }

    @Override
    public String toString() {
        return "ClientBusinessType{" +
                "clientBusinessTypeNo=" + clientBusinessTypeNo +
                ", clientBusinessTypeName='" + clientBusinessTypeName + '\'' +
                '}';
    }
}
