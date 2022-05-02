package com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogCompanyOrderHistoryDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogInWarehouseHistoryDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogItemWarehouseDTO;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "BacklogInWarehouseEntity")
@Table(name = "IN_WAREHOUSE")
public class BacklogInWarehouse { /* 입고 */

    @Id
    @Column(name = "IN_WAREHOUSE_NO")
    private int inWarehouseNo;

    @Column(name = "IN_WAREHOUSE_DIVISION_ITEM")
    private int inwarehouseDivisionItem;    //입고 물품 구분(혹시모르니)

    @Column(name = "IN_WAREHOUSE_WORKING_FINISHED_DATE")
    private Date inwarehouseWorkingFinishedDate;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private BacklogCompanyOrderHistory companyOrderHistoryNo;

    @JoinColumn(name = "IN_WAREHOUSE_NO")
    @OneToMany
    private List<BacklogItemWarehouse> backlogItemWarehouseList;

    @JoinColumn(name = "IN_WAREHOUSE_NO")
    @OneToMany
    private List<BacklogInWarehouseHistory> backlogInWarehouseHistoryList;

    public BacklogInWarehouse() {}

    public BacklogInWarehouse(int inWarehouseNo, int inwarehouseDivisionItem, Date inwarehouseWorkingFinishedDate, BacklogCompanyOrderHistory companyOrderHistoryNo, List<BacklogItemWarehouse> backlogItemWarehouseList, List<BacklogInWarehouseHistory> backlogInWarehouseHistoryList) {
        this.inWarehouseNo = inWarehouseNo;
        this.inwarehouseDivisionItem = inwarehouseDivisionItem;
        this.inwarehouseWorkingFinishedDate = inwarehouseWorkingFinishedDate;
        this.companyOrderHistoryNo = companyOrderHistoryNo;
        this.backlogItemWarehouseList = backlogItemWarehouseList;
        this.backlogInWarehouseHistoryList = backlogInWarehouseHistoryList;
    }

    public int getInWarehouseNo() {
        return inWarehouseNo;
    }

    public void setInWarehouseNo(int inWarehouseNo) {
        this.inWarehouseNo = inWarehouseNo;
    }

    public int getInwarehouseDivisionItem() {
        return inwarehouseDivisionItem;
    }

    public void setInwarehouseDivisionItem(int inwarehouseDivisionItem) {
        this.inwarehouseDivisionItem = inwarehouseDivisionItem;
    }

    public Date getInwarehouseWorkingFinishedDate() {
        return inwarehouseWorkingFinishedDate;
    }

    public void setInwarehouseWorkingFinishedDate(Date inwarehouseWorkingFinishedDate) {
        this.inwarehouseWorkingFinishedDate = inwarehouseWorkingFinishedDate;
    }

    public BacklogCompanyOrderHistory getCompanyOrderHistoryNo() {
        return companyOrderHistoryNo;
    }

    public void setCompanyOrderHistoryNo(BacklogCompanyOrderHistory companyOrderHistoryNo) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
    }

    public List<BacklogItemWarehouse> getBacklogItemWarehouseList() {
        return backlogItemWarehouseList;
    }

    public void setBacklogItemWarehouseList(List<BacklogItemWarehouse> backlogItemWarehouseList) {
        this.backlogItemWarehouseList = backlogItemWarehouseList;
    }

    public List<BacklogInWarehouseHistory> getBacklogInWarehouseHistoryList() {
        return backlogInWarehouseHistoryList;
    }

    public void setBacklogInWarehouseHistoryList(List<BacklogInWarehouseHistory> backlogInWarehouseHistoryList) {
        this.backlogInWarehouseHistoryList = backlogInWarehouseHistoryList;
    }

    @Override
    public String toString() {
        return "BacklogInWarehouse{" +
                "inWarehouseNo=" + inWarehouseNo +
                ", inwarehouseDivisionItem=" + inwarehouseDivisionItem +
                ", inwarehouseWorkingFinishedDate=" + inwarehouseWorkingFinishedDate +
                ", companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", backlogItemWarehouseList=" + backlogItemWarehouseList +
                ", backlogInWarehouseHistoryList=" + backlogInWarehouseHistoryList +
                '}';
    }
}
