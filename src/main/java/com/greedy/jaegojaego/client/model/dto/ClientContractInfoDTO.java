package com.greedy.jaegojaego.client.model.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ClientContractInfoDTO {

    private int clientContractInfoNo;
    private Date clientContractInfoStartDate;
    private Date clientContractInfoEndDate;
    private String clientContractInfoStatus;
    private ClientDTO client;

}
