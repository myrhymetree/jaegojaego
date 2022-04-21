package com.greedy.jaegojaego.order.order.model.entitiy;

import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderApplicationItemPK implements Serializable {

    private OrderApplication orderApplication;
    private OrderClientContractItem orderClientContractItem;

    @Override
    public String toString() {
        return "OrderApplicationItemPK{" +
                "orderApplication=" + orderApplication +
                ", orderClientContractItem=" + orderClientContractItem +
                '}';
    }
}
