package com.greedy.jaegojaego.order.order.model.entitiy;

<<<<<<< HEAD:src/main/java/com/greedy/jaegojaego/order/model/entitiy/OrderApplicationItem.java
=======
import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;
>>>>>>> origin/feature/order:src/main/java/com/greedy/jaegojaego/order/order/model/entitiy/OrderApplicationItem.java
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
/*@IdClass(OrderApplicationItemPK.class)*/
public class OrderApplicationItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ORDER_APPLICATION_NO")
    private OrderApplication orderApplication;

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