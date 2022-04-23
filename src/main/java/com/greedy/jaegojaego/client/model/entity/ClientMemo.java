package com.greedy.jaegojaego.client.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Client_Memo")
@Table(name = "CLIENT_MEMO")
@SequenceGenerator(
        name = "CLIENT_MEMO_SEQ_GENERATOR",
        sequenceName = "SEQ_CLIENT_MEMO_NO",
        initialValue = 1,
        allocationSize = 1
)
public class ClientMemo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_MEMO_SEQ_GENERATOR"
    )
    @Column(name = "CLIENT_MEMO_NO")
    private int clientMemoNo;

    @Column(name = "CLIENT_MEMO_BODY")
    private String clientMemoBody;

    @Column(name = "CLIENT_MEMO_WRITER")
    private String clientMemoWriter;

    @Column(name = "CLIENT_MEMO_WRITED_DATE")
    private Date clientMemoWritedDate;

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO", updatable = false, insertable = false)
    private Client client;

    @Column(name = "CLIENT_NO")
    private int clientNo;

    public ClientMemo(int clientMemoNo, String clientMemoBody, String clientMemoWriter, Date clientMemoWritedDate, Client client, int clientNo) {
        this.clientMemoNo = clientMemoNo;
        this.clientMemoBody = clientMemoBody;
        this.clientMemoWriter = clientMemoWriter;
        this.clientMemoWritedDate = clientMemoWritedDate;
        this.client = client;
        this.clientNo = clientNo;
    }

    public ClientMemo() {

    }

    public int getClientMemoNo() {
        return clientMemoNo;
    }

    public void setClientMemoNo(int clientMemoNo) {
        this.clientMemoNo = clientMemoNo;
    }

    public String getClientMemoBody() {
        return clientMemoBody;
    }

    public void setClientMemoBody(String clientMemoBody) {
        this.clientMemoBody = clientMemoBody;
    }

    public String getClientMemoWriter() {
        return clientMemoWriter;
    }

    public void setClientMemoWriter(String clientMemoWriter) {
        this.clientMemoWriter = clientMemoWriter;
    }

    public Date getClientMemoWritedDate() {
        return clientMemoWritedDate;
    }

    public void setClientMemoWritedDate(Date clientMemoWritedDate) {
        this.clientMemoWritedDate = clientMemoWritedDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    @Override
    public String toString() {
        return "ClientMemo{" +
                "clientMemoNo=" + clientMemoNo +
                ", clientMemoBody='" + clientMemoBody + '\'' +
                ", clientMemoWriter='" + clientMemoWriter + '\'' +
                ", clientMemoWritedDate=" + clientMemoWritedDate +
                ", client=" + client +
                ", clientNo=" + clientNo +
                '}';
    }
}
