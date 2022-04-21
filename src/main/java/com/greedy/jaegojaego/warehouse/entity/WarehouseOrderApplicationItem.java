package com.greedy.jaegojaego.warehouse.entity;


import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "warehouseOrderApplicationItem")
@Table(name = "ORDER_APPLICATION_ITEM")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*@IdClass(OrderApplicationItemPK.class)*/
public class WarehouseOrderApplicationItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ORDER_APPLICATION_NO")
    private WarehouseOrderApplication orderApplication;

    @Column(name = "ORDER_APPLICATION_ITEM_AMOUNT")
    private int orderApplicationItemAmount;

    @Column(name = "CLIENT_CONTRACT_ITEM_NO")
    private int orderClientContractItemNo;

    @Id
    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_ITEM_NO")
    private OrderClientContractItem orderClientContractItem;

    @Override
    public String toString() {
        return "OrderApplicationItem{" +
                "orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", orderClientContractItem=" + orderClientContractItem +
                '}';
    }
}
