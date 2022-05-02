package com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog;

import java.sql.Date;
import java.util.List;

public class BacklogInWarehouseDTO {
    /* 입고 DTO */
    private int inWarehouseNo; //입고 번호(pk)
    private int inwarehouseDivisionItem;    //입고 물품 구분(혹시모르니)
    private BacklogCompanyOrderHistoryDTO companyOrderHistoryNo; //본사 발주내역번호(fk) -> 거래처 들고오기 위한 용
    private List<BacklogItemWarehouseDTO> backlogItemWarehouseList;
    private List<BacklogInWarehouseHistoryDTO> backlogInWarehouseHistoryList;

    public BacklogInWarehouseDTO() {}

    public BacklogInWarehouseDTO(int inWarehouseNo, int inwarehouseDivisionItem, BacklogCompanyOrderHistoryDTO companyOrderHistoryNo, List<BacklogItemWarehouseDTO> backlogItemWarehouseList, List<BacklogInWarehouseHistoryDTO> backlogInWarehouseHistoryList) {
        this.inWarehouseNo = inWarehouseNo;
        this.inwarehouseDivisionItem = inwarehouseDivisionItem;
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

    public BacklogCompanyOrderHistoryDTO getCompanyOrderHistoryNo() {
        return companyOrderHistoryNo;
    }

    public void setCompanyOrderHistoryNo(BacklogCompanyOrderHistoryDTO companyOrderHistoryNo) {
        this.companyOrderHistoryNo = companyOrderHistoryNo;
    }

    public List<BacklogItemWarehouseDTO> getBacklogItemWarehouseList() {
        return backlogItemWarehouseList;
    }

    public void setBacklogItemWarehouseList(List<BacklogItemWarehouseDTO> backlogItemWarehouseList) {
        this.backlogItemWarehouseList = backlogItemWarehouseList;
    }

    public List<BacklogInWarehouseHistoryDTO> getBacklogInWarehouseHistoryList() {
        return backlogInWarehouseHistoryList;
    }

    public void setBacklogInWarehouseHistoryList(List<BacklogInWarehouseHistoryDTO> backlogInWarehouseHistoryList) {
        this.backlogInWarehouseHistoryList = backlogInWarehouseHistoryList;
    }

    @Override
    public String toString() {
        return "BacklogInWarehouseDTO{" +
                "inWarehouseNo=" + inWarehouseNo +
                ", inwarehouseDivisionItem=" + inwarehouseDivisionItem +
                ", companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", backlogItemWarehouseList=" + backlogItemWarehouseList +
                ", backlogInWarehouseHistoryList=" + backlogInWarehouseHistoryList +
                '}';
    }
}
