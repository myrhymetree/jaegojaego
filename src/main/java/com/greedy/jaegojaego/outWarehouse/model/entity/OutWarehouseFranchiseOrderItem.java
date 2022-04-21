package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "OutWarehouseFranchiseOrderItem")
@Table(name = "FRANCHISE_ORDER_ITEM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(OutWarehouseFranchiseOrderItemId.class)
public class OutWarehouseFranchiseOrderItem {

    @Id
    @ManyToOne
    @JoinColumn(name = "FRANCHISE_ORDER_NO")
    private OutWarehouseFranchiseOrder franchiseOrderNo;

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private OutWarehouseFranchiseOrderableItem itemInfoNo;

    @Column(name = "FRANCHISE_ORDER_ITEM_AMOUNT")
    private int franchiseOrderItemAmount;
}
