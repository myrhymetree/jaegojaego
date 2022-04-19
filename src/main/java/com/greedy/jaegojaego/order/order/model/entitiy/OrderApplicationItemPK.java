package com.greedy.jaegojaego.order.order.model.entitiy;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderApplicationItemPK implements Serializable {

    private int orderApplicationNo;
    private int clientContractItemNo;

    @Override
    public String toString() {
        return "OrderApplicationItemPK{" +
                "orderApplicationNo=" + orderApplicationNo +
                ", clientContractItemNo=" + clientContractItemNo +
                '}';
    }
}
