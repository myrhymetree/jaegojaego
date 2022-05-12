package com.greedy.jaegojaego.warehouse.entity;

import com.greedy.jaegojaego.order.client.model.entity.OrderClient;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "warehouseOrderApplication")
@Table(name = "ORDER_APPLICATION")
@SequenceGenerator(
        name = "ORDER_APPLICATION_SEQ_GENERATOR",
        sequenceName = "ORDER_APPLICATION_NO",
        initialValue = 1,
        allocationSize = 1
)
public class WarehouseOrderApplication {

    @Id
    @Column(name = "ORDER_APPLICATION_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ORDER_APPLICATION_SEQ_GENERATOR"
    )
    private Integer orderApplicationNo;

//    @ManyToOne
//    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
//    private WarehouseCompanyOrderHistory companyOrderHistory;

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private WarehouseClient orderClient;

    @OneToMany
    @JoinColumn(name = "ORDER_APPLICATION_NO")
    private List<WarehouseOrderApplicationItem> orderApplicationItemList;

    public WarehouseOrderApplication() {}

    public WarehouseOrderApplication(Integer orderApplicationNo, WarehouseClient orderClient, List<WarehouseOrderApplicationItem> orderApplicationItemList) {
        this.orderApplicationNo = orderApplicationNo;
        this.orderClient = orderClient;
        this.orderApplicationItemList = orderApplicationItemList;
    }

    public Integer getOrderApplicationNo() {
        return orderApplicationNo;
    }

    public void setOrderApplicationNo(Integer orderApplicationNo) {
        this.orderApplicationNo = orderApplicationNo;
    }

    public WarehouseClient getOrderClient() {
        return orderClient;
    }

    public void setOrderClient(WarehouseClient orderClient) {
        this.orderClient = orderClient;
    }

    public List<WarehouseOrderApplicationItem> getOrderApplicationItemList() {
        return orderApplicationItemList;
    }

    public void setOrderApplicationItemList(List<WarehouseOrderApplicationItem> orderApplicationItemList) {
        this.orderApplicationItemList = orderApplicationItemList;
    }

    @Override
    public String toString() {
        return "WarehouseOrderApplication{" +
                "orderApplicationNo=" + orderApplicationNo +
                ", orderClient=" + orderClient +
                ", orderApplicationItemList=" + orderApplicationItemList +
                '}';
    }
}
