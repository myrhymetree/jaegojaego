package com.greedy.jaegojaego.warehouse.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/** 새로 고쳐줌 */
@Entity(name = "warehouseOrderApplicationItem")
@Table(name = "ORDER_APPLICATION_ITEM")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseOrderApplicationItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ORDER_APPLICATION_NO")
    private WarehouseOrderApplication orderApplicationNo;

    @Column(name = "ORDER_APPLICATION_ITEM_AMOUNT")
    private int orderApplicationItemAmount;

    @Id
    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_ITEM_NO")
    private WarehouseOrderApplication clientContractItemNo;

    @Override
    public String toString() {
        return "WarehouseOrderApplicationItem{" +
                "orderApplicationNo=" + orderApplicationNo +
                ", orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", clientContractItemNo=" + clientContractItemNo +
                '}';
    }
}
