package com.greedy.jaegojaego.client.model.dto;

import com.greedy.jaegojaego.client.model.entity.ClientBusinessItem;
import com.greedy.jaegojaego.client.model.entity.ClientBusinessType;
import com.greedy.jaegojaego.client.model.entity.ClientContractInfo;
import com.greedy.jaegojaego.client.model.entity.ClientMember;
import lombok.Data;

import java.util.Date;
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
    private ClientContractInfoDTO clientContractInfo;

}
