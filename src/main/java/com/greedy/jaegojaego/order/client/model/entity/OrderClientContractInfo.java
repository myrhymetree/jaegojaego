package com.greedy.jaegojaego.order.client.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "orderClientContractInfo")
@Table(name = "CLIENT_CONTRACT_INFO")
@SequenceGenerator(
        name = "CLIENT_CONTRACT_INFO_SEQ_GENERATOR",
        sequenceName = "CLIENT_CONTRACT_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderClientContractInfo {

    @Id
    @Column(name = "CLIENT_CONTRACT_INFO_NO")
    private int clientContractInfoNo;

    @Column(name = "CLIENT_CONTRACT_INFO_STARTDATE")
    private java.sql.Date clientContractInfoStartDate;

    @Column(name = "CLIENT_CONTRACT_INFO_ENDDATE")
    private java.sql.Date clientContractInfoEndDate;

    @Column(name = "CLIENT_CONTRACT_INFO_STATUS")
    private String clientContractInfoStatus;

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private OrderClient orderClient;

    @Override
    public String toString() {
        return "ClientContractInfo{" +
                "clientContractInfoNo=" + clientContractInfoNo +
                ", clientContractInfoStartDate=" + clientContractInfoStartDate +
                ", clientContractInfoEndDate=" + clientContractInfoEndDate +
                ", clientContractInfoStatus='" + clientContractInfoStatus + '\'' +
                ", client=" + orderClient +
                '}';
    }
}
