package com.greedy.jaegojaego.client.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Client_Contract_Info")
@Table(name = "CLIENT_CONTRACT_INFO")
@SequenceGenerator(
        name = "CLIENT_CONTRACT_INFO_SEQ_GENERATOR",
        sequenceName = "SEQ_CLIENT_CONTRACT_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
public class ClientContractInfo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CLIENT_CONTRACT_INFO_SEQ_GENERATOR"
    )
    @Column(name = "CLIENT_CONTRACT_INFO_NO")
    private int clientContractInfoNo;

    @Column(name = "CLIENT_CONTRACT_INFO_STARTDATE")
    private Date ClientContractInfoStartdate;

    @Column(name = "CLIENT_CONTRACT_INFO_ENDDATE")
    private Date ClientContractInfoEnddate;

    @Column(name = "CLIENT_CONTRACT_INFO_STATUS")
    private String ClientContractInfoStatus;

    @Column(name = "CLIENT_NO")
    private int clientNo;

    public ClientContractInfo(int clientContractInfoNo, Date clientContractInfoStartdate, Date clientContractInfoEnddate, String clientContractInfoStatus, int clientNo) {
        this.clientContractInfoNo = clientContractInfoNo;
        ClientContractInfoStartdate = clientContractInfoStartdate;
        ClientContractInfoEnddate = clientContractInfoEnddate;
        ClientContractInfoStatus = clientContractInfoStatus;
        this.clientNo = clientNo;
    }

    public ClientContractInfo() {

    }

    public int getClientContractInfoNo() {
        return clientContractInfoNo;
    }

    public void setClientContractInfoNo(int clientContractInfoNo) {
        this.clientContractInfoNo = clientContractInfoNo;
    }

    public Date getClientContractInfoStartdate() {
        return ClientContractInfoStartdate;
    }

    public void setClientContractInfoStartdate(Date clientContractInfoStartdate) {
        ClientContractInfoStartdate = clientContractInfoStartdate;
    }

    public Date getClientContractInfoEnddate() {
        return ClientContractInfoEnddate;
    }

    public void setClientContractInfoEnddate(Date clientContractInfoEnddate) {
        ClientContractInfoEnddate = clientContractInfoEnddate;
    }

    public String getClientContractInfoStatus() {
        return ClientContractInfoStatus;
    }

    public void setClientContractInfoStatus(String clientContractInfoStatus) {
        ClientContractInfoStatus = clientContractInfoStatus;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    @Override
    public String toString() {
        return "ClientContractInfo{" +
                "clientContractInfoNo=" + clientContractInfoNo +
                ", ClientContractInfoStartdate=" + ClientContractInfoStartdate +
                ", ClientContractInfoEnddate=" + ClientContractInfoEnddate +
                ", ClientContractInfoStatus='" + ClientContractInfoStatus + '\'' +
                ", clientNo=" + clientNo +
                '}';
    }
}
