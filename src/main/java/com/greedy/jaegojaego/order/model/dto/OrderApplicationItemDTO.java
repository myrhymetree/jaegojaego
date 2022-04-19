package com.greedy.jaegojaego.order.model.dto;


import com.greedy.jaegojaego.client.dto.OrderClientContractItemDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderApplicationItemDTO {

    private OrderApplicationDTO orderApplication;
    private int clientContractItemNo;
    private int orderApplicationItemAmount;
    private OrderClientContractItemDTO clientContractItem;

    @Override
    public String toString() {
        return "OrderApplicationItemDTO{" +
                "clientContractItemNo=" + clientContractItemNo +
                ", orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", clientContractItem=" + clientContractItem +
                '}';
    }
}
