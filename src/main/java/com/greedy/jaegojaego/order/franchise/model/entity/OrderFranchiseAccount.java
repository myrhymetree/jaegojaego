package com.greedy.jaegojaego.order.franchise.model.entity;

import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.member.model.entity.MemberRole;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "orderFranchiseAccount")
@Table(name = "FRANCHISE_ACCOUNT")
@EqualsAndHashCode
public class OrderFranchiseAccount {

    @Id
    @Column(name = "FRANCHISE_MANAGER_NO")
    private Integer franchiseManagerNo;

    @Column(name = "MANAGER_NAME")
    private String managerName;

    @Column(name = "MANAGER_PHONE")
    private String managerPhone;

    @Column(name = "MANAGER_EMAIL")
    private String managerEmail;

    @ManyToOne
    @JoinColumn(name = "REPRESENTATIVE_NO")
    private OrderFranchiseInfo franchiseInfo;

    public OrderFranchiseAccount() {
    }

    public OrderFranchiseAccount(Integer franchiseManagerNo, String managerName, String managerPhone, String managerEmail, OrderFranchiseInfo franchiseInfo) {
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

    public OrderFranchiseInfo getFranchiseInfo() {
        return franchiseInfo;
    }

    public void setFranchiseInfo(OrderFranchiseInfo franchiseInfo) {
        this.franchiseInfo = franchiseInfo;
    }

    @Override
    public String toString() {
        return "OrderFranchiseAccount{" +
                "franchiseManagerNo=" + franchiseManagerNo +
                ", managerName='" + managerName + '\'' +
                ", managerPhone='" + managerPhone + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", franchiseInfo=" + franchiseInfo +
                '}';
    }
}
