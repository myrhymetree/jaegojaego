package com.greedy.jaegojaego.order.order.model.dto.franchise;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.order.franchise.model.dto.OrderFranchiseInfoDTO;

import java.sql.Date;
import java.util.List;

public class FranchiseOrderDTO {

    private int franchiseOrderNo;
    private java.sql.Date franchiseOrderApplicationDate;
    private String franchiseOrderOrderNumber;
    private String franchiseOrderStatus;
    private java.sql.Date franchiseOrderStatusDate;
    private String franchiseOrderStatusRejectionContent;
    private List<FranchiseOrderItemDTO> franchiseOrderItemList;
    private List<FranchiseOrderStatusHistoryDTO> franchiseOrderStatusHistoryList;
    private MemberDTO member;

    public FranchiseOrderDTO() {
    }

    public FranchiseOrderDTO(int franchiseOrderNo, Date franchiseOrderApplicationDate, String franchiseOrderOrderNumber, String franchiseOrderStatus, Date franchiseOrderStatusDate, String franchiseOrderStatusRejectionContent, List<FranchiseOrderItemDTO> franchiseOrderItemList, List<FranchiseOrderStatusHistoryDTO> franchiseOrderStatusHistoryList, MemberDTO member) {
        this.franchiseOrderNo = franchiseOrderNo;
        this.franchiseOrderApplicationDate = franchiseOrderApplicationDate;
        this.franchiseOrderOrderNumber = franchiseOrderOrderNumber;
        this.franchiseOrderStatus = franchiseOrderStatus;
        this.franchiseOrderStatusDate = franchiseOrderStatusDate;
        this.franchiseOrderStatusRejectionContent = franchiseOrderStatusRejectionContent;
        this.franchiseOrderItemList = franchiseOrderItemList;
        this.franchiseOrderStatusHistoryList = franchiseOrderStatusHistoryList;
        this.member = member;
    }

    public int getFranchiseOrderNo() {
        return franchiseOrderNo;
    }

    public void setFranchiseOrderNo(int franchiseOrderNo) {
        this.franchiseOrderNo = franchiseOrderNo;
    }

    public Date getFranchiseOrderApplicationDate() {
        return franchiseOrderApplicationDate;
    }

    public void setFranchiseOrderApplicationDate(Date franchiseOrderApplicationDate) {
        this.franchiseOrderApplicationDate = franchiseOrderApplicationDate;
    }

    public String getFranchiseOrderOrderNumber() {
        return franchiseOrderOrderNumber;
    }

    public void setFranchiseOrderOrderNumber(String franchiseOrderOrderNumber) {
        this.franchiseOrderOrderNumber = franchiseOrderOrderNumber;
    }

    public String getFranchiseOrderStatus() {
        return franchiseOrderStatus;
    }

    public void setFranchiseOrderStatus(String franchiseOrderStatus) {
        this.franchiseOrderStatus = franchiseOrderStatus;
    }

    public Date getFranchiseOrderStatusDate() {
        return franchiseOrderStatusDate;
    }

    public void setFranchiseOrderStatusDate(Date franchiseOrderStatusDate) {
        this.franchiseOrderStatusDate = franchiseOrderStatusDate;
    }

    public String getFranchiseOrderStatusRejectionContent() {
        return franchiseOrderStatusRejectionContent;
    }

    public void setFranchiseOrderStatusRejectionContent(String franchiseOrderStatusRejectionContent) {
        this.franchiseOrderStatusRejectionContent = franchiseOrderStatusRejectionContent;
    }

    public List<FranchiseOrderItemDTO> getFranchiseOrderItemList() {
        return franchiseOrderItemList;
    }

    public void setFranchiseOrderItemList(List<FranchiseOrderItemDTO> franchiseOrderItemList) {
        this.franchiseOrderItemList = franchiseOrderItemList;
    }

    public List<FranchiseOrderStatusHistoryDTO> getFranchiseOrderStatusHistoryList() {
        return franchiseOrderStatusHistoryList;
    }

    public void setFranchiseOrderStatusHistoryList(List<FranchiseOrderStatusHistoryDTO> franchiseOrderStatusHistoryList) {
        this.franchiseOrderStatusHistoryList = franchiseOrderStatusHistoryList;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "FranchiseOrderDTO{" +
                "franchiseOrderNo=" + franchiseOrderNo +
                ", franchiseOrderApplicationDate=" + franchiseOrderApplicationDate +
                ", franchiseOrderOrderNumber='" + franchiseOrderOrderNumber + '\'' +
                ", franchiseOrderStatus='" + franchiseOrderStatus + '\'' +
                ", franchiseOrderStatusDate=" + franchiseOrderStatusDate +
                ", franchiseOrderStatusRejectionContent='" + franchiseOrderStatusRejectionContent + '\'' +
                ", franchiseOrderItemList=" + franchiseOrderItemList +
                ", franchiseOrderStatusHistoryList=" + franchiseOrderStatusHistoryList +
                ", member=" + member +
                '}';
    }
}
