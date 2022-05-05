package com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity(name = "BacklogInWarehouseEntity")
@Table(name = "IN_WAREHOUSE")
public class BacklogInWarehouse implements Serializable { /* 입고 */

    @EmbeddedId
    private BacklogInWarehousePK backlogInWarehousePK;

    @Column(name = "IN_WAREHOUSE_AMOUNT")
    private int inWarehouseAmount;   //입고 수량


    @Column(name = "IN_WAREHOUSE_DATE")
    private Date inWarehouseDate; //입고 처리 날짜

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private BacklogClient clientNoForInWarehouse; //거래처 번호 fk
//    private BacklogOrderApplicationItemDTO orderApplicationNoForInWarehouse; //본사발주신청서 번호 fk (ㄱㄷ)

    @ManyToOne
    @JoinColumn(name = "ITEM_INFO_NO")
    private BacklogItemInfo itemInfoNoForInWarehouse; //자재번호fk 인데 필요없을수도

    @Column(name = "IN_WAREHOUSE_COMPLETE_DATE")
    private Date inWarehouseCompleteDate;

//    @ManyToOne
//    @JoinColumn(name = "CLIENT_CONTRACT_ITEM_NO")
//    private BacklogClientContractItem clientContractItemNoForInWarehouse; //거래처 판매 계약상품 번호 fk

    public BacklogInWarehouse() {}

    public BacklogInWarehouse(BacklogInWarehousePK backlogInWarehousePK, int inWarehouseAmount, Date inWarehouseDate, BacklogClient clientNoForInWarehouse, BacklogItemInfo itemInfoNoForInWarehouse, Date inWarehouseCompleteDate) {
        this.backlogInWarehousePK = backlogInWarehousePK;
        this.inWarehouseAmount = inWarehouseAmount;
        this.inWarehouseDate = inWarehouseDate;
        this.clientNoForInWarehouse = clientNoForInWarehouse;
        this.itemInfoNoForInWarehouse = itemInfoNoForInWarehouse;
        this.inWarehouseCompleteDate = inWarehouseCompleteDate;
    }

    public BacklogInWarehousePK getBacklogInWarehousePK() {
        return backlogInWarehousePK;
    }

    public void setBacklogInWarehousePK(BacklogInWarehousePK backlogInWarehousePK) {
        this.backlogInWarehousePK = backlogInWarehousePK;
    }

    public int getInWarehouseAmount() {
        return inWarehouseAmount;
    }

    public void setInWarehouseAmount(int inWarehouseAmount) {
        this.inWarehouseAmount = inWarehouseAmount;
    }

    public Date getInWarehouseDate() {
        return inWarehouseDate;
    }

    public void setInWarehouseDate(Date inWarehouseDate) {
        this.inWarehouseDate = inWarehouseDate;
    }

    public BacklogClient getClientNoForInWarehouse() {
        return clientNoForInWarehouse;
    }

    public void setClientNoForInWarehouse(BacklogClient clientNoForInWarehouse) {
        this.clientNoForInWarehouse = clientNoForInWarehouse;
    }

    public BacklogItemInfo getItemInfoNoForInWarehouse() {
        return itemInfoNoForInWarehouse;
    }

    public void setItemInfoNoForInWarehouse(BacklogItemInfo itemInfoNoForInWarehouse) {
        this.itemInfoNoForInWarehouse = itemInfoNoForInWarehouse;
    }

    public Date getInWarehouseCompleteDate() {
        return inWarehouseCompleteDate;
    }

    public void setInWarehouseCompleteDate(Date inWarehouseCompleteDate) {
        this.inWarehouseCompleteDate = inWarehouseCompleteDate;
    }

    @Override
    public String toString() {
        return "BacklogInWarehouse{" +
                "backlogInWarehousePK=" + backlogInWarehousePK +
                ", inWarehouseAmount=" + inWarehouseAmount +
                ", inWarehouseDate=" + inWarehouseDate +
                ", clientNoForInWarehouse=" + clientNoForInWarehouse +
                ", itemInfoNoForInWarehouse=" + itemInfoNoForInWarehouse +
                ", inWarehouseCompleteDate=" + inWarehouseCompleteDate +
                '}';
    }
}
