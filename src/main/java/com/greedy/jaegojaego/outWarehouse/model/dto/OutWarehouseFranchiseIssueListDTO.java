package com.greedy.jaegojaego.outWarehouse.model.dto;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseCompanyAccount;

import java.sql.Date;

public class OutWarehouseFranchiseIssueListDTO {

    private int franchiseIssueNo;
    private Date franchiseIssueStatusFinishDate;
    private String franchiseIssueStatus;
    private int memberNo;
    private String franchiseName;
    private String franchiseAddress;
    private int franchiseRepresentativeNo;

    public OutWarehouseFranchiseIssueListDTO() {}

    public OutWarehouseFranchiseIssueListDTO(int franchiseIssueNo, Date franchiseIssueStatusFinishDate, String franchiseIssueStatus, int memberNo, String franchiseName, String franchiseAddress, int franchiseRepresentativeNo) {
        this.franchiseIssueNo = franchiseIssueNo;
        this.franchiseIssueStatusFinishDate = franchiseIssueStatusFinishDate;
        this.franchiseIssueStatus = franchiseIssueStatus;
        this.memberNo = memberNo;
        this.franchiseName = franchiseName;
        this.franchiseAddress = franchiseAddress;
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public int getFranchiseIssueNo() {
        return franchiseIssueNo;
    }

    public void setFranchiseIssueNo(int franchiseIssueNo) {
        this.franchiseIssueNo = franchiseIssueNo;
    }

    public Date getFranchiseIssueStatusFinishDate() {
        return franchiseIssueStatusFinishDate;
    }

    public void setFranchiseIssueStatusFinishDate(Date franchiseIssueStatusFinishDate) {
        this.franchiseIssueStatusFinishDate = franchiseIssueStatusFinishDate;
    }

    public String getFranchiseIssueStatus() {
        return franchiseIssueStatus;
    }

    public void setFranchiseIssueStatus(String franchiseIssueStatus) {
        this.franchiseIssueStatus = franchiseIssueStatus;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getFranchiseName() {
        return franchiseName;
    }

    public void setFranchiseName(String franchiseName) {
        this.franchiseName = franchiseName;
    }

    public String getFranchiseAddress() {
        return franchiseAddress;
    }

    public void setFranchiseAddress(String franchiseAddress) {
        this.franchiseAddress = franchiseAddress;
    }

    public int getFranchiseRepresentativeNo() {
        return franchiseRepresentativeNo;
    }

    public void setFranchiseRepresentativeNo(int franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseIssueListDTO{" +
                "franchiseIssueNo=" + franchiseIssueNo +
                ", franchiseIssueStatusFinishDate=" + franchiseIssueStatusFinishDate +
                ", franchiseIssueStatus='" + franchiseIssueStatus + '\'' +
                ", memberNo=" + memberNo +
                ", franchiseName='" + franchiseName + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                ", franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                '}';
    }
}
