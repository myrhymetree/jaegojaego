package com.greedy.jaegojaego.warehouse.dto;

import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;
import com.greedy.jaegojaego.order.order.model.dto.CompanyOrderHistoryDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseCompanyOrderItemDTO {

    private OrderItemInfoDTO itemInfo;
    private CompanyOrderHistoryDTO companyOrderHistory;
    private int companyOrderItemAmount;

    @Override
    public String toString() {
        return "CompanyOrderItemDTO{" +
                "itemInfo=" + itemInfo +
                ", companyOrderItemAmount=" + companyOrderItemAmount +
                '}';
    }
}
