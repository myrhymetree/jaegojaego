package com.greedy.jaegojaego.backlog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "BacklogClientEntity")
@Table(name = "CLIENT")
public class BacklogClient {

    @Id
    @Column(name = "CLIENT_NO")
    private int clientNo;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    public BacklogClient() {}

    public BacklogClient(int clientNo, String clientName) {
        this.clientNo = clientNo;
        this.clientName = clientName;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "BacklogClient{" +
                "clientNo=" + clientNo +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
