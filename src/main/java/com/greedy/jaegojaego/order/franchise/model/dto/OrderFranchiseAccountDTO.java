package com.greedy.jaegojaego.order.franchise.model.dto;

import com.greedy.jaegojaego.member.model.entity.Member;

public class OrderFranchiseAccountDTO {

    private Member member;
    private String managerName;
    private String managerPhone;
    private String managerEmail;
    private OrderFranchiseInfoDTO franchiseInfo;

    public OrderFranchiseAccountDTO() {
    }

    public OrderFranchiseAccountDTO(Member member, String managerName, String managerPhone, String managerEmail, OrderFranchiseInfoDTO franchiseInfo) {
        this.member = member;
        this.managerName = managerName;
        this.managerPhone = managerPhone;
        this.managerEmail = managerEmail;
        this.franchiseInfo = franchiseInfo;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public OrderFranchiseInfoDTO getFranchiseInfo() {
        return franchiseInfo;
    }

    public void setFranchiseInfo(OrderFranchiseInfoDTO franchiseInfo) {
        this.franchiseInfo = franchiseInfo;
    }

    @Override
    public String toString() {
        return "FranchiseAccountDTO{" +
                "member=" + member +
                ", managerName='" + managerName + '\'' +
                ", managerPhone='" + managerPhone + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", franchiseInfo=" + franchiseInfo +
                '}';
    }
}
