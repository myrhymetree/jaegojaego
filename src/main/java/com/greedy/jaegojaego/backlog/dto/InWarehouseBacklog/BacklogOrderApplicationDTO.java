package com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogClient;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogOrderApplication;

public class BacklogOrderApplicationDTO {
    private int orderApplicationNo; //pk
    private BacklogCompanyOrderHistoryDTO companyOrderHistoryNo;
    private BacklogClientDTO clientNoForOrderApplication;

    public BacklogOrderApplicationDTO() {}

    public BacklogOrderApplicationDTO(int orderApplicationNo, BacklogCompanyOrderHistoryDTO companyOrderHistoryNo, BacklogClientDTO clientNoForOrderApplication) {
        this.orderApplicationNo = orderApplicationNo;
        this.companyOrderHistoryNo = companyOrderHistoryNo;
        this.clientNoForOrderApplication = clientNoForOrderApplication;
    }

    public int getOrderApplicationNo() {
        return orderApplicationNo;
    }

    public void setOrderApplicationNo(int orderApplicationNo) {
        this.orderApplicationNo = orderApplicationNo;
    }

    public BacklogCompanyOrderHistoryDTO getCompanyOrderHistoryNo() {
        return companyOrderHistoryNo;
    }

    public void setCompanyOrderHistoryNo(BacklogCompanyOrderHistoryDTO companyOrderHistoryNo) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
    }

    public BacklogClientDTO getClientNoForOrderApplication() {
        return clientNoForOrderApplication;
    }

    public void setClientNoForOrderApplication(BacklogClientDTO clientNoForOrderApplication) {
        this.clientNoForOrderApplication = clientNoForOrderApplication;
    }

    @Override
    public String toString() {
        return "BacklogOrderApplicationDTO{" +
                "orderApplicationNo=" + orderApplicationNo +
//                ", companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", clientNoForOrderApplication=" + clientNoForOrderApplication +
                '}';
    }
}

