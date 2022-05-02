package com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogInWarehouseDTO;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "BacklogInWarehouseHistoryEntity")
@Table(name = "IN_WAREHOUSE_STATUS_HISTORY")
public class BacklogInWarehouseHistory {

    @EmbeddedId
    private BacklogInWarehouseHistoryPK backlogInWarehouseHistoryPK;

    @Column(name = "IN_WAREHOUSE_STATUS_HISTORY_DATE")
    private Date inWarehouseStatusHistoryDate;

    @Column(name = "IN_WAREHOUSE_STATUS_AMOUNT")
    private int inWarehouseStatusAmount;

    @Column(name = "IN_WAREHOUSE_STATUS_NAME")
    private String inWarehouseStatusName;

    public BacklogInWarehouseHistory() {}

    public BacklogInWarehouseHistory(BacklogInWarehouseHistoryPK backlogInWarehouseHistoryPK, Date inWarehouseStatusHistoryDate, int inWarehouseStatusAmount, String inWarehouseStatusName) {
        this.backlogInWarehouseHistoryPK = backlogInWarehouseHistoryPK;
        this.inWarehouseStatusHistoryDate = inWarehouseStatusHistoryDate;
        this.inWarehouseStatusAmount = inWarehouseStatusAmount;
        this.inWarehouseStatusName = inWarehouseStatusName;
    }

    public BacklogInWarehouseHistoryPK getBacklogInWarehouseHistoryPK() {
        return backlogInWarehouseHistoryPK;
    }

    public void setBacklogInWarehouseHistoryPK(BacklogInWarehouseHistoryPK backlogInWarehouseHistoryPK) {
        this.backlogInWarehouseHistoryPK = backlogInWarehouseHistoryPK;
    }

    public Date getInWarehouseStatusHistoryDate() {
        return inWarehouseStatusHistoryDate;
    }

    public void setInWarehouseStatusHistoryDate(Date inWarehouseStatusHistoryDate) {
        this.inWarehouseStatusHistoryDate = inWarehouseStatusHistoryDate;
    }

    public int getInWarehouseStatusAmount() {
        return inWarehouseStatusAmount;
    }

    public void setInWarehouseStatusAmount(int inWarehouseStatusAmount) {
        this.inWarehouseStatusAmount = inWarehouseStatusAmount;
    }

    public String getInWarehouseStatusName() {
        return inWarehouseStatusName;
    }

    public void setInWarehouseStatusName(String inWarehouseStatusName) {
        this.inWarehouseStatusName = inWarehouseStatusName;
    }

    @Override
    public String toString() {
        return "BacklogInWarehouseHistory{" +
                "backlogInWarehouseHistoryPK=" + backlogInWarehouseHistoryPK +
                ", inWarehouseStatusHistoryDate=" + inWarehouseStatusHistoryDate +
                ", inWarehouseStatusAmount=" + inWarehouseStatusAmount +
                ", inWarehouseStatusName='" + inWarehouseStatusName + '\'' +
                '}';
    }
}
