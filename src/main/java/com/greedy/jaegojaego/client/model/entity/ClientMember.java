package com.greedy.jaegojaego.client.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Client_Member")
@Table(name = "COMPANY_ACCOUNT")
public class ClientMember {

    @Id
    @Column(name = "MEMBER_NO")
    private int clientMemberNo;

    @Column(name = "MEMBER_NAME")
    private String clientMemberName;

    public ClientMember(int clientMemberNo, String clientMemberName) {
        this.clientMemberNo = clientMemberNo;
        this.clientMemberName = clientMemberName;
    }

    public ClientMember() {

    }

    public int getClientMemberNo() {
        return clientMemberNo;
    }

    public void setClientMemberNo(int clientMemberNo) {
        this.clientMemberNo = clientMemberNo;
    }

    public String getClientMemberName() {
        return clientMemberName;
    }

    public void setClientMemberName(String clientMemberName) {
        this.clientMemberName = clientMemberName;
    }

    @Override
    public String toString() {
        return "ClientMember{" +
                "clientMemberNo=" + clientMemberNo +
                ", clientMemberName='" + clientMemberName + '\'' +
                '}';
    }
}


