package com.greedy.jaegojaego.order.model.entitiy;

import com.greedy.jaegojaego.client.entity.OrderClientContractItem;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "OrderApplicationItem")
@Table(name = "ORDER_APPLICATION_ITEM")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderApplicationItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ORDER_APPLICATION_NO")
    private OrderApplication orderApplication;

    @Column(name = "CLIENT_CONTRACT_ITEM_NO")
    private int orderClientContractItemNo;

    @Column(name = "ORDER_APPLICATION_ITEM_AMOUNT")
    private int orderApplicationItemAmount;

    @Id
    @ManyToOne
    @JoinColumn(name = "CLIENT_CONTRACT_ITEM_NO")
    private OrderClientContractItem orderClientContractItem;

    @Override
    public String toString() {
        return "OrderApplicationItem{" +
                "orderClientContractItemNo=" + orderClientContractItemNo +
                ", orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", orderClientContractItem=" + orderClientContractItem +
                '}';
    }
}
