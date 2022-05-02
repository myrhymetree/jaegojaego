package com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog;

import java.sql.Date;

public class BacklogInWarehouseHistoryDTO {

    private int intWarehouseStatusHistoryNo;
    private BacklogInWarehouseDTO inWarehouseNoForHistory;
    private String inWarehouseStatusName;
    private Date inWarehouseStatusHistoryDate;
    private int inWarehouseStatusAmount;

    public BacklogInWarehouseHistoryDTO () {}

    public BacklogInWarehouseHistoryDTO(int intWarehouseStatusHistoryNo, BacklogInWarehouseDTO inWarehouseNoForHistory, String inWarehouseStatusName, Date inWarehouseStatusHistoryDate, int inWarehouseStatusAmount) {
        this.intWarehouseStatusHistoryNo = intWarehouseStatusHistoryNo;
        this.inWarehouseNoForHistory = inWarehouseNoForHistory;
        this.inWarehouseStatusName = inWarehouseStatusName;
        this.inWarehouseStatusHistoryDate = inWarehouseStatusHistoryDate;
        this.inWarehouseStatusAmount = inWarehouseStatusAmount;
    }

    public int getIntWarehouseStatusHistoryNo() {
        return intWarehouseStatusHistoryNo;
    }

    public void setIntWarehouseStatusHistoryNo(int intWarehouseStatusHistoryNo) {
        this.intWarehouseStatusHistoryNo = intWarehouseStatusHistoryNo;
    }

    public BacklogInWarehouseDTO getInWarehouseNoForHistory() {
        return inWarehouseNoForHistory;
    }

    public void setInWarehouseNoForHistory(BacklogInWarehouseDTO inWarehouseNoForHistory) {
        this.inWarehouseNoForHistory = inWarehouseNoForHistory;
    }

    public String getInWarehouseStatusName() {
        return inWarehouseStatusName;
    }

    public void setInWarehouseStatusName(String inWarehouseStatusName) {
        this.inWarehouseStatusName = inWarehouseStatusName;
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

    @Override
    public String toString() {
        return "BacklogInWarehouseHistoryDTO{" +
                "intWarehouseStatusHistoryNo=" + intWarehouseStatusHistoryNo +
//                ", inWarehouseNoForHistory=" + inWarehouseNoForHistory +
                ", inWarehouseStatusName='" + inWarehouseStatusName + '\'' +
                ", inWarehouseStatusHistoryDate=" + inWarehouseStatusHistoryDate +
                ", inWarehouseStatusAmount=" + inWarehouseStatusAmount +
                '}';
    }
}


