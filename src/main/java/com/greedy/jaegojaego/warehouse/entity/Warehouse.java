package com.greedy.jaegojaego.warehouse.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/** 새로 고쳐줌 */
@Entity(name = "warehouse")
@Table(name = "IN_WAREHOUSE")
@SequenceGenerator(
        name = "IN_WAREHOUSE_SEQ_GENERATOR",
        sequenceName = "IN_WAREHOUSE_NO",
        initialValue = 1,
        allocationSize = 1
)
public class Warehouse {

    @Id
    @Column(name = "IN_WAREHOUSE_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "IN_WAREHOUSE_SEQ_GENERATOR"
    )
    private int warehouseNo;

    @Column(name = "IN_WAREHOUSE_AMOUNT")
    private int warehouseAmount;

    @Column(name = "IN_WAREHOUSE_STATUS")
    private String warehouseStatus;

    @Column(name = "IN_WAREHOUSE_DATE")
    private java.sql.Date warehouseDate;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ORDER_APPLICATION_NO"),
            @JoinColumn(name = "CLIENT_CONTRACT_ITEM_NO")
    })
    private WarehouseOrderApplicationItem orderApplicationItemPK;

//    @ManyToOne
//    @JoinColumn(name = "CLIENT_CONTRACT_ITEM_NO")
//    private WarehouseOrderApplicationItem clientContractItemNo;

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private WarehouseItemInfo itemInfoNo;

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private WarehouseClient clientNo;

    @Column(name = "IN_WAREHOUSE_COMPLETE_DATE")
    private java.sql.Date warehouseCompleteDate;

    public Warehouse() {}

    public Warehouse(int warehouseNo, int warehouseAmount, String warehouseStatus, Date warehouseDate, WarehouseOrderApplicationItem orderApplicationItemPK, WarehouseItemInfo itemInfoNo, WarehouseClient clientNo, Date warehouseCompleteDate) {
        this.warehouseNo = warehouseNo;
        this.warehouseAmount = warehouseAmount;
        this.warehouseStatus = warehouseStatus;
        this.warehouseDate = warehouseDate;
        this.orderApplicationItemPK = orderApplicationItemPK;
        this.itemInfoNo = itemInfoNo;
        this.clientNo = clientNo;
        this.warehouseCompleteDate = warehouseCompleteDate;
    }

    public int getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(int warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public int getWarehouseAmount() {
        return warehouseAmount;
    }

    public void setWarehouseAmount(int warehouseAmount) {
        this.warehouseAmount = warehouseAmount;
    }

    public String getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(String warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    public Date getWarehouseDate() {
        return warehouseDate;
    }

    public void setWarehouseDate(Date warehouseDate) {
        this.warehouseDate = warehouseDate;
    }

    public WarehouseOrderApplicationItem getOrderApplicationItemPK() {
        return orderApplicationItemPK;
    }

    public void setOrderApplicationItemPK(WarehouseOrderApplicationItem orderApplicationItemPK) {
        this.orderApplicationItemPK = orderApplicationItemPK;
    }

    public WarehouseItemInfo getItemInfoNo() {
        return itemInfoNo;
    }

    public void setItemInfoNo(WarehouseItemInfo itemInfoNo) {
        this.itemInfoNo = itemInfoNo;
    }

    public WarehouseClient getClientNo() {
        return clientNo;
    }

    public void setClientNo(WarehouseClient clientNo) {
        this.clientNo = clientNo;
    }

    public Date getWarehouseCompleteDate() {
        return warehouseCompleteDate;
    }

    public void setWarehouseCompleteDate(Date warehouseCompleteDate) {
        this.warehouseCompleteDate = warehouseCompleteDate;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseNo=" + warehouseNo +
                ", warehouseAmount=" + warehouseAmount +
                ", warehouseStatus='" + warehouseStatus + '\'' +
                ", warehouseDate=" + warehouseDate +
                ", orderApplicationItemPK=" + orderApplicationItemPK +
                ", itemInfoNo=" + itemInfoNo +
                ", clientNo=" + clientNo +
                ", warehouseCompleteDate=" + warehouseCompleteDate +
                '}';
    }
}
