package com.greedy.jaegojaego.order.client.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderClientContractInfoDTO {

    private int clientContractInfoNo;
    private java.sql.Date clientContractInfoStartDate;
    private java.sql.Date clientContractInfoEndDate;
    private String clientContractInfoStatus;
    private int clientNo;

    @Override
    public String toString() {
        return "ClientContractInfoDTO{" +
                "clientContractInfoNo=" + clientContractInfoNo +
                ", clientContractInfoStartDate=" + clientContractInfoStartDate +
                ", clientContractInfoEndDate=" + clientContractInfoEndDate +
                ", clientContractInfoStatus='" + clientContractInfoStatus + '\'' +
                ", clientNo=" + clientNo +
                '}';
    }
}
