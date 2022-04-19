package com.greedy.jaegojaego.order.model.dto;

import com.greedy.jaegojaego.client.dto.OrderClientDTO;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderApplicationDTO {

    private CompanyOrderHistoryDTO companyOrderHistory;
    private int orderApplicationNo;
    private OrderClientDTO client;
    private List<OrderApplicationItemDTO> orderApplicationItemList;

    @Override
    public String toString() {
        return "OrderApplicationDTO{" +
                "orderApplicationNo=" + orderApplicationNo +
                ", client=" + client +
                ", orderApplicationItemList=" + orderApplicationItemList +
                '}';
    }
}
