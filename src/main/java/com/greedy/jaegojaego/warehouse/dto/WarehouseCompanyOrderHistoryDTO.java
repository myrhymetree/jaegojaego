package com.greedy.jaegojaego.warehouse.dto;

import com.greedy.jaegojaego.order.company.model.dto.OrderCompanyAccountDTO;
import com.greedy.jaegojaego.order.order.model.dto.CompanyOrderItemDTO;
import com.greedy.jaegojaego.order.order.model.dto.OrderApplicationDTO;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseCompanyOrderHistoryDTO {

    private int companyOrderHistoryNo;
    private java.sql.Date companyOrderHistoryCreatedDate;
    private OrderCompanyAccountDTO companyAccount;
    private List<CompanyOrderItemDTO> companyOrderItemList;
    private List<OrderApplicationDTO> orderApplicationList;

    @Override
    public String toString() {
        return "CompanyOrderHistoryDTO{" +
                "companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", companyOrderHistoryCreatedDate=" + companyOrderHistoryCreatedDate +
                ", companyAccount=" + companyAccount +
                ", companyOrderItemList=" + companyOrderItemList +
                ", orderApplicationList=" + orderApplicationList +
                '}';
    }
}
