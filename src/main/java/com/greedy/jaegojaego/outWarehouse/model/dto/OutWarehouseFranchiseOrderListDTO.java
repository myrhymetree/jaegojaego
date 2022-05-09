package com.greedy.jaegojaego.outWarehouse.model.dto;

public class OutWarehouseFranchiseOrderListDTO {

    private int franchiseOrderNo;
    private int memberNo;
    private String franchiseName;
    private String franchiseAddress;

    public OutWarehouseFranchiseOrderListDTO() {}

    public OutWarehouseFranchiseOrderListDTO(int franchiseOrderNo, int memberNo, String franchiseName, String franchiseAddress) {
        this.franchiseOrderNo = franchiseOrderNo;
        this.memberNo = memberNo;
        this.franchiseName = franchiseName;
        this.franchiseAddress = franchiseAddress;
    }

    public int getFranchiseOrderNo() {
        return franchiseOrderNo;
    }

    public void setFranchiseOrderNo(int franchiseOrderNo) {
        this.franchiseOrderNo = franchiseOrderNo;
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

    @Override
    public String toString() {
        return "OutWarehouseFranchiseOrderListDTO{" +
                "franchiseOrderNo=" + franchiseOrderNo +
                ", memberNo=" + memberNo +
                ", franchiseName='" + franchiseName + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                '}';
    }
}
