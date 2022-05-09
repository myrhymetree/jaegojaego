package com.greedy.jaegojaego.client.model.dto;

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
    private ClientMemberDTO clientMemberNo;
    private Date clientCreatedDate;
    private String clientPaymentMethod;
    private String clientAddress;


}
