package com.greedy.jaegojaego.client.model.dto;

import java.util.Date;

public class ClientMemoDTO {

    private int clientMemoNo;
    private String clientMemoBody;
    private String clientMemoWriter;
    private Date clientMemoWritedDate;
    private int clientNo;
    private ClientDTO client;

    public ClientMemoDTO(){}

    public ClientMemoDTO(int clientMemoNo, String clientMemoBody, String clientMemoWriter, Date clientMemoWritedDate, int clientNo, ClientDTO client) {
        this.clientMemoNo = clientMemoNo;
        this.clientMemoBody = clientMemoBody;
        this.clientMemoWriter = clientMemoWriter;
        this.clientMemoWritedDate = clientMemoWritedDate;
        this.clientNo = clientNo;
        this.client = client;
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

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ClientMemoDTO{" +
                "clientMemoNo=" + clientMemoNo +
                ", clientMemoBody='" + clientMemoBody + '\'' +
                ", clientMemoWriter='" + clientMemoWriter + '\'' +
                ", clientMemoWritedDate=" + clientMemoWritedDate +
                ", clientNo=" + clientNo +
                ", client=" + client +
                '}';
    }
}
