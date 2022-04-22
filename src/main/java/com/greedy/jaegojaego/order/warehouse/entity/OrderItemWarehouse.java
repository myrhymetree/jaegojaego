package com.greedy.jaegojaego.order.warehouse.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "orderItemWarehouse")
@Table(name = "ITEM_WAREHOUSE")
@SequenceGenerator(
        name = "ITEM_WAREHOUSE_SEQ_GENERATOR",
        sequenceName = "ITEM_WAREHOUSE_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OrderItemWarehouse implements Serializable {

    @Id
    @Column(name = "ITEM_WAREHOUSE_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITEM_WAREHOUSE_SEQ_GENERATOR"
    )
    private int orderItemWarehouseNo;

    @Column(name = "ITEM_WAREHOUSE_QUALITY_STATUS")
    private String orderItemWarehouseQualityStatus;

    @Column(name = "ITEM_WAREHOUSE_ADDRESS")
    private String orderItemWarehouseAddress;

    public OrderItemWarehouse() {}

    public OrderItemWarehouse(int orderItemWarehouseNo, String orderItemWarehouseQualityStatus, String orderItemWarehouseAddress) {
        this.orderItemWarehouseNo = orderItemWarehouseNo;
        this.orderItemWarehouseQualityStatus = orderItemWarehouseQualityStatus;
        this.orderItemWarehouseAddress = orderItemWarehouseAddress;
    }

    public int getOrderItemWarehouseNo() {
        return orderItemWarehouseNo;
    }

    public void setOrderItemWarehouseNo(int orderItemWarehouseNo) {
        this.orderItemWarehouseNo = orderItemWarehouseNo;
    }

    public String getOrderItemWarehouseQualityStatus() {
        return orderItemWarehouseQualityStatus;
    }

    public void setOrderItemWarehouseQualityStatus(String orderItemWarehouseQualityStatus) {
        this.orderItemWarehouseQualityStatus = orderItemWarehouseQualityStatus;
    }

    public String getOrderItemWarehouseAddress() {
        return orderItemWarehouseAddress;
    }

    public void setOrderItemWarehouseAddress(String orderItemWarehouseAddress) {
        this.orderItemWarehouseAddress = orderItemWarehouseAddress;
    }

    @Override
    public String toString() {
        return "OrderItemWarehouse{" +
                "orderItemWarehouseNo=" + orderItemWarehouseNo +
                ", orderItemWarehouseQualityStatus='" + orderItemWarehouseQualityStatus + '\'' +
                ", orderItemWarehouseAddress='" + orderItemWarehouseAddress + '\'' +
                '}';
    }
}
