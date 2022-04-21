package com.greedy.jaegojaego.warehouse.dto;

import com.greedy.jaegojaego.order.client.model.dto.OrderClientDTO;
import com.greedy.jaegojaego.order.order.model.dto.CompanyOrderHistoryDTO;
import com.greedy.jaegojaego.order.order.model.dto.OrderApplicationItemDTO;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseOrderApplicationDTO {

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
