package com.greedy.jaegojaego.order.order.model.entitiy;

<<<<<<< HEAD:src/main/java/com/greedy/jaegojaego/order/model/entitiy/CompanyOrderItem.java
=======
import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
>>>>>>> origin/feature/order:src/main/java/com/greedy/jaegojaego/order/order/model/entitiy/CompanyOrderItem.java
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "CompanyOrderItem")
@Table(name = "COMPANY_ORDER_ITEM")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyOrderItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OrderItemInfo orderItemInfo;

    @Id
    @ManyToOne
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private CompanyOrderHistory companyOrderHistory;

    @Column(name = "COMPANY_ORDER_ITEM_AMOUNT")
    private int companyOrderItemAmount;

    @Override
    public String toString() {
        return "CompanyOrderItem{" +
                "itemInfo=" + orderItemInfo +
                ", companyOrderItemAmount=" + companyOrderItemAmount +
                '}';
    }
}
