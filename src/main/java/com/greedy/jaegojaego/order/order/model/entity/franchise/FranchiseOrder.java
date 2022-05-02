package com.greedy.jaegojaego.order.order.model.entity.franchise;

import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.order.franchise.model.entity.OrderFranchiseInfo;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "franchiseOrder")
@Table(name = "FRANCHISE_ORDER")
@SequenceGenerator(
        name = "FRANCHISE_ORDER_SEQ_GENERATOR",
        sequenceName = "COMPANY_ORDER_HISTORY_NO",
        initialValue = 1,
        allocationSize = 1
)
public class FranchiseOrder {

    @Id
    @Column(name = "FRANCHISE_ORDER_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FRANCHISE_ORDER_SEQ_GENERATOR"
    )
    private int franchiseOrderNo;

    @Column(name = "FRANCHISE_ORDER_APPLICATION_DATE")
    private java.sql.Date franchiseOrderApplicationDate;

    @Column(name = "FRANCHISE_ORDER_ORDER_NUMBER")
    private String franchiseOrderOrderNumber;

    @Column(name = "FRANCHISE_ORDER_STATUS")
    private String franchiseOrderStatus;

    @Column(name = "FRANCHISE_ORDER_STATUS_DATE")
    private java.sql.Date franchiseOrderStatusDate;

    @Column(name = "FRANCHISE_ORDER_STATUS_REJECTION_CONTENT")
    private String franchiseOrderStatusRejectionContent;

    @OneToMany
    @JoinColumn(name = "FRANCHISE_ORDER_NO")
    private List<FranchiseOrderItem> franchiseOrderItemList;

    @OneToMany
    @JoinColumn(name = "FRANCHISE_ORDER_NO")
    private List<FranchiseOrderStatusHistory> franchiseOrderStatusHistoryList;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private Member member;

    public FranchiseOrder() {
    }

    public FranchiseOrder(int franchiseOrderNo, Date franchiseOrderApplicationDate, String franchiseOrderOrderNumber, String franchiseOrderStatus, Date franchiseOrderStatusDate, String franchiseOrderStatusRejectionContent, List<FranchiseOrderItem> franchiseOrderItemList, List<FranchiseOrderStatusHistory> franchiseOrderStatusHistoryList, Member member) {
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

    public List<FranchiseOrderItem> getFranchiseOrderItemList() {
        return franchiseOrderItemList;
    }

    public void setFranchiseOrderItemList(List<FranchiseOrderItem> franchiseOrderItemList) {
        this.franchiseOrderItemList = franchiseOrderItemList;
    }

    public List<FranchiseOrderStatusHistory> getFranchiseOrderStatusHistoryList() {
        return franchiseOrderStatusHistoryList;
    }

    public void setFranchiseOrderStatusHistoryList(List<FranchiseOrderStatusHistory> franchiseOrderStatusHistoryList) {
        this.franchiseOrderStatusHistoryList = franchiseOrderStatusHistoryList;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "FranchiseOrder{" +
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
