package com.greedy.jaegojaego.order.order.model.dto;


import com.greedy.jaegojaego.order.client.model.dto.OrderClientContractItemDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderApplicationItemDTO {

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
