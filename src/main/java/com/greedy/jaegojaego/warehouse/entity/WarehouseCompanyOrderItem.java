package com.greedy.jaegojaego.warehouse.entity;

import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "warehouseCompanyOrderItem")
@Table(name = "COMPANY_ORDER_ITEM")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseCompanyOrderItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OrderItemInfo orderItemInfo;

    @Id
    @ManyToOne
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private WarehouseCompanyOrderHistory companyOrderHistory;

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
