package com.greedy.jaegojaego.client.dto;

import com.greedy.jaegojaego.company.model.dto.OrderCompanyAccountDTO;
import com.greedy.jaegojaego.item.model.dto.OrderItemInfoDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderClientContractItemDTO {

    private int clientContractItemNo;
    private String clientContractItemName;
    private int clientContractItemSupplyPrice;
    private OrderCompanyAccountDTO companyAccount;
    private java.sql.Date clientContractItemCreatedDate;
    private OrderClientContractInfoDTO clientContractInfo;
    private OrderItemInfoDTO orderItemInfo;

    @Override
    public String toString() {
        return "ClientContractItemDTO{" +
                "clientContractItemNo=" + clientContractItemNo +
                ", clientContractItemName='" + clientContractItemName + '\'' +
                ", clientContractItemSupplyPrice=" + clientContractItemSupplyPrice +
                ", companyAccount=" + companyAccount +
                ", clientContractItemCreatedDate=" + clientContractItemCreatedDate +
                ", clientContractInfo=" + clientContractInfo +
                ", itemInfo=" + orderItemInfo +
                '}';
    }
}
