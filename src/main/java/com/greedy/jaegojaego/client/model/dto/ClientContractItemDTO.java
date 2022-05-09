package com.greedy.jaegojaego.client.model.dto;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.order.client.model.dto.OrderClientContractInfoDTO;
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;
import lombok.Data;

import java.sql.Date;
@Data
public class ClientContractItemDTO {
    private int clientContractItemNo;
    private String clientContractItemName;
    private int clientContractItemSupplyPrice;
    private MemberDTO memberNo;
    private java.sql.Date clientContractItemCreatedDate;
    private ClientContractInfoDTO clientContractInfoNo;

    /*private int clientContractItemNo;
    private String clientContractItemName;
    private int clientContractItemSupplyPrice;
    private MemberDTO memberNo;
    private Date clientContractItemCreatedDate;
    private ClientContractInfoDTO clientContractInfoNo;
    private String clientContractItemCategory;*/
}
