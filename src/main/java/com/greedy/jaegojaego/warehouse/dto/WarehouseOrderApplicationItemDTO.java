package com.greedy.jaegojaego.warehouse.dto;

import com.greedy.jaegojaego.order.client.model.dto.OrderClientContractItemDTO;
import com.greedy.jaegojaego.order.order.model.dto.OrderApplicationDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseOrderApplicationItemDTO {

    private OrderApplicationDTO orderApplication;
    private int orderApplicationItemAmount;
    private OrderClientContractItemDTO clientContractItem;

    @Override
    public String toString() {
        return "OrderApplicationItemDTO{" +
                "orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", clientContractItem=" + clientContractItem +
                '}';
    }
}
