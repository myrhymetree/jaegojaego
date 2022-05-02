package com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog;

import java.util.List;

public class BacklogCompanyOrderHistoryDTO {
    /* 본사 발주 내역 DTO */
    private int companyOrderHistoryNo; //본사 발주 내역 번호
    private List<BacklogOrderApplicationDTO> backlogOrderApplicationList;

    public BacklogCompanyOrderHistoryDTO() {}

    public BacklogCompanyOrderHistoryDTO(int companyOrderHistoryNo, List<BacklogOrderApplicationDTO> backlogOrderApplicationList) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
        this.backlogOrderApplicationList = backlogOrderApplicationList;
    }

    public int getCompanyOrderHistoryNo() {
        return companyOrderHistoryNo;
    }

    public void setCompanyOrderHistoryNo(int companyOrderHistoryNo) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
    }

    public List<BacklogOrderApplicationDTO> getBacklogOrderApplicationList() {
        return backlogOrderApplicationList;
    }

    public void setBacklogOrderApplicationList(List<BacklogOrderApplicationDTO> backlogOrderApplicationList) {
        this.backlogOrderApplicationList = backlogOrderApplicationList;
    }

    @Override
    public String toString() {
        return "BacklogCompanyOrderHistoryDTO{" +
                "companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", backlogOrderApplicationList=" + backlogOrderApplicationList +
                '}';
    }
}
