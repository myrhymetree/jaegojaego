package com.greedy.jaegojaego.client.model.dto;

import com.greedy.jaegojaego.client.model.entity.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ClientDTO {

    private int clientNo;
    private String clientName;
    private String clientCbrNo;
    private String clientRepresentativeName;
    private String clientRepresentativePhone;
    private String clientRepresentativeEmail;
    private ClientMember clientMemberNo;
    private Date clientCreatedDate;
    private String clientPaymentMethod;
    private String clientAddress;
    private ClientBusinessType clientBusinessTypeNo;
    private ClientBusinessItem clientBusinessItemNo;
//    private ClientContractInfoDTO clientContractInfo;
    private List<ClientCbrDTO> clientCbrList;

}
