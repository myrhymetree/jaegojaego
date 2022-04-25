package com.greedy.jaegojaego.order.franchise.model.entity;

import com.greedy.jaegojaego.member.model.entity.Member;
import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "orderFranchiseAccount")
@Table(name = "FRANCHISE_ACCOUNT")
public class OrderFranchiseAccount implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "FRANCHISE_MANAGER_NO")
    private Member member;

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

    public OrderFranchiseAccount(Member member, String managerName, String managerPhone, String managerEmail, OrderFranchiseInfo franchiseInfo) {
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

    public OrderFranchiseInfo getFranchiseInfo() {
        return franchiseInfo;
    }

    public void setFranchiseInfo(OrderFranchiseInfo franchiseInfo) {
        this.franchiseInfo = franchiseInfo;
    }

    @Override
    public String toString() {
        return "OrderFranchiseAccount{" +
                "member=" + member +
                ", managerName='" + managerName + '\'' +
                ", managerPhone='" + managerPhone + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", franchiseInfo=" + franchiseInfo +
                '}';
    }
}
