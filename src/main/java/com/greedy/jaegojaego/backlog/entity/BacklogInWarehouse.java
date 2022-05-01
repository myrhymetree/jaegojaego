package com.greedy.jaegojaego.backlog.entity;

import com.greedy.jaegojaego.backlog.dto.BacklogClientDTO;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "BacklogInWarehouseEntity")
@Table(name = "IN_WAREHOUSE")
public class BacklogInWarehouse {

    @Id
    @Column(name = "IN_WAREHOUSE_NO")
    private int inwarehouseNo;

    @Column(name = "IN_WAREHOUSE_DIVISION_ITEM")
    private int inwarehouseDivisionItem;    //입고 물품 구분(혹시모르니)

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private BacklogClient clientNo;

    @Column(name = "IN_WAREHOUSE_WORKING_STATUS_NAME")
    private String inwarehouseWorkingStatusName;

    @Column(name = "IN_WAREHOUSE_WORKING_FINISHED_DATE")
    private Date inwarehouseWorkingFinishedDate;

    public BacklogInWarehouse() {}

    public BacklogInWarehouse(int inwarehouseNo, int inwarehouseDivisionItem, BacklogClient clientNo, String inwarehouseWorkingStatusName, Date inwarehouseWorkingFinishedDate) {
        this.inwarehouseNo = inwarehouseNo;
        this.inwarehouseDivisionItem = inwarehouseDivisionItem;
        this.clientNo = clientNo;
        this.inwarehouseWorkingStatusName = inwarehouseWorkingStatusName;
        this.inwarehouseWorkingFinishedDate = inwarehouseWorkingFinishedDate;
    }

    public int getInwarehouseNo() {
        return inwarehouseNo;
    }

    public void setInwarehouseNo(int inwarehouseNo) {
        this.inwarehouseNo = inwarehouseNo;
    }

    public int getInwarehouseDivisionItem() {
        return inwarehouseDivisionItem;
    }

    public void setInwarehouseDivisionItem(int inwarehouseDivisionItem) {
        this.inwarehouseDivisionItem = inwarehouseDivisionItem;
    }

    public BacklogClient getClientNo() {
        return clientNo;
    }

    public void setClientNo(BacklogClient clientNo) {
        this.clientNo = clientNo;
    }

    public String getInwarehouseWorkingStatusName() {
        return inwarehouseWorkingStatusName;
    }

    public void setInwarehouseWorkingStatusName(String inwarehouseWorkingStatusName) {
        this.inwarehouseWorkingStatusName = inwarehouseWorkingStatusName;
    }

    public Date getInwarehouseWorkingFinishedDate() {
        return inwarehouseWorkingFinishedDate;
    }

    public void setInwarehouseWorkingFinishedDate(Date inwarehouseWorkingFinishedDate) {
        this.inwarehouseWorkingFinishedDate = inwarehouseWorkingFinishedDate;
    }

    @Override
    public String toString() {
        return "BacklogInWarehouse{" +
                "inwarehouseNo=" + inwarehouseNo +
                ", inwarehouseDivisionItem=" + inwarehouseDivisionItem +
                ", clientNo=" + clientNo +
                ", inwarehouseWorkingStatusName='" + inwarehouseWorkingStatusName + '\'' +
                ", inwarehouseWorkingFinishedDate=" + inwarehouseWorkingFinishedDate +
                '}';
    }
}
