package com.greedy.jaegojaego.warehouse.entity;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseOrderApplicationItemPK implements Serializable {

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
