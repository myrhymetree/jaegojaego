package com.greedy.jaegojaego.order.franchise.model.dto;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.entity.Member;

public class OrderFranchiseAccountDTO {

    private Integer franchiseManagerNo;
    private String managerName;
    private String managerPhone;
    private String managerEmail;
    private OrderFranchiseInfoDTO franchiseInfo;

    public OrderFranchiseAccountDTO() {
    }

    public OrderFranchiseAccountDTO(Integer franchiseManagerNo, String managerName, String managerPhone, String managerEmail, OrderFranchiseInfoDTO franchiseInfo) {
        this.franchiseManagerNo = franchiseManagerNo;
        this.managerName = managerName;
        this.managerPhone = managerPhone;
        this.managerEmail = managerEmail;
        this.franchiseInfo = franchiseInfo;
    }

    public Integer getFranchiseManagerNo() {
        return franchiseManagerNo;
    }

    public void setFranchiseManagerNo(Integer franchiseManagerNo) {
        this.franchiseManagerNo = franchiseManagerNo;
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
        return "OrderFranchiseAccountDTO{" +
                "franchiseManagerNo=" + franchiseManagerNo +
                ", managerName='" + managerName + '\'' +
                ", managerPhone='" + managerPhone + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", franchiseInfo=" + franchiseInfo +
                '}';
    }
}
