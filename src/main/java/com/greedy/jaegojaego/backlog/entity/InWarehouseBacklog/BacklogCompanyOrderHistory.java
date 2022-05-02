package com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogOrderApplicationDTO;

import javax.persistence.*;
import java.util.List;

@Entity(name = "BacklogCompanyOrderHistoryEntity")
@Table(name = "COMPANY_ORDER_HISTORY")
public class BacklogCompanyOrderHistory {

    @Id
    @Column(name = "COMPANY_ORDER_HISTORY_NO")
    private int companyOrderHistoryNo; //본사 발주 내역 번호

    @OneToMany
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private List<BacklogOrderApplication> backlogOrderApplicationList;

    public BacklogCompanyOrderHistory() {}

    public BacklogCompanyOrderHistory(int companyOrderHistoryNo, List<BacklogOrderApplication> backlogOrderApplicationList) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
        this.backlogOrderApplicationList = backlogOrderApplicationList;
    }

    public int getCompanyOrderHistoryNo() {
        return companyOrderHistoryNo;
    }

    public void setCompanyOrderHistoryNo(int companyOrderHistoryNo) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
    }

    public List<BacklogOrderApplication> getBacklogOrderApplicationList() {
        return backlogOrderApplicationList;
    }

    public void setBacklogOrderApplicationList(List<BacklogOrderApplication> backlogOrderApplicationList) {
        this.backlogOrderApplicationList = backlogOrderApplicationList;
    }

    @Override
    public String toString() {
        return "BacklogCompanyOrderHistory{" +
                "companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", backlogOrderApplicationList=" + backlogOrderApplicationList +
                '}';
    }
}
