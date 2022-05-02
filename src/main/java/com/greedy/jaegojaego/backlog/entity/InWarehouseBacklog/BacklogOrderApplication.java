package com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogClientDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogCompanyOrderHistoryDTO;

import javax.persistence.*;

@Entity(name = "BacklogOrderApplicationEntity")
@Table(name = "ORDER_APPLICATION")
public class BacklogOrderApplication {

    @Id
    @Column(name = "ORDER_APPLICATION_NO")
    private int orderApplicationNo; //pk

    @ManyToOne
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private BacklogCompanyOrderHistory companyOrderHistoryNo;

    @ManyToOne
    @JoinColumn(name = "CLIENT_NO")
    private BacklogClient clientNoForOrderApplication;

    public BacklogOrderApplication() {}

    public BacklogOrderApplication(int orderApplicationNo, BacklogCompanyOrderHistory companyOrderHistoryNo, BacklogClient clientNoForOrderApplication) {
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

    public BacklogCompanyOrderHistory getCompanyOrderHistoryNo() {
        return companyOrderHistoryNo;
    }

    public void setCompanyOrderHistoryNo(BacklogCompanyOrderHistory companyOrderHistoryNo) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
    }

    public BacklogClient getClientNoForOrderApplication() {
        return clientNoForOrderApplication;
    }

    public void setClientNoForOrderApplication(BacklogClient clientNoForOrderApplication) {
        this.clientNoForOrderApplication = clientNoForOrderApplication;
    }

    @Override
    public String toString() {
        return "BacklogOrderApplication{" +
                "orderApplicationNo=" + orderApplicationNo +
//                ", companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", clientNoForOrderApplication=" + clientNoForOrderApplication +
                '}';
    }
}
