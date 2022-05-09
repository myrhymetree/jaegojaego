package com.greedy.jaegojaego.client.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Client_Contract_Info")
@Table(name = "CLIENT_CONTRACT_INFO")
@SequenceGenerator(
        name = "CLIENT_CONTRACT_INFO_SEQ_GENERATOR",
        sequenceName = "CLIENT_CONTRACT_INFO_NO",
        initialValue = 50,
        allocationSize = 1
)
@Data
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

    @JoinColumn(name = "CLIENT_NO")
    @ManyToOne
    private Client client;
}
