package com.greedy.jaegojaego.order.model.dto;

import com.greedy.jaegojaego.item.model.dto.OrderItemInfoDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyOrderItemDTO {

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