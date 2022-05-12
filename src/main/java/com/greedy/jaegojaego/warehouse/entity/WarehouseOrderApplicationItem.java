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
public class WarehouseOrderApplicationItem {

    @EmbeddedId
    private WarehouseOrderApplicationItemPK orderApplicationItemPK;

//    @Id
//    @ManyToOne
//    @JoinColumn(name = "ORDER_APPLICATION_NO")
//    private WarehouseOrderApplication orderApplicationNo;


//    @Id
//    @ManyToOne
//    @JoinColumn(name = "CLIENT_CONTRACT_ITEM_NO")
//    private WarehouseOrderApplication clientContractItemNo;

    @Column(name = "ORDER_APPLICATION_ITEM_AMOUNT")
    private int orderApplicationItemAmount;

    @Column(name = "ORDER_APPLICATION_IN_YN")
    private String orderApplicationItemYN;


    @Override
    public String toString() {
        return "WarehouseOrderApplicationItem{" +
                "orderApplicationItemPK=" + orderApplicationItemPK +
                ", orderApplicationItemAmount=" + orderApplicationItemAmount +
                ", orderApplicationItemYN='" + orderApplicationItemYN + '\'' +
                '}';
    }
}
