package com.greedy.jaegojaego.order.order.model.entity.company;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "companyOrderItem")
@Table(name = "COMPANY_ORDER_ITEM")
public class CompanyOrderItem implements Serializable {

    @EmbeddedId
    private CompanyOrderItemPK companyOrderItemPK;

    @Column(name = "COMPANY_ORDER_ITEM_AMOUNT")
    private int companyOrderItemAmount;

    public CompanyOrderItem() {
    }

    public CompanyOrderItem(CompanyOrderItemPK companyOrderItemPK, int companyOrderItemAmount) {
        this.companyOrderItemPK = companyOrderItemPK;
        this.companyOrderItemAmount = companyOrderItemAmount;
    }

    public CompanyOrderItemPK getCompanyOrderItemPK() {
        return companyOrderItemPK;
    }

    public void setCompanyOrderItemPK(CompanyOrderItemPK companyOrderItemPK) {
        this.companyOrderItemPK = companyOrderItemPK;
    }

    public int getCompanyOrderItemAmount() {
        return companyOrderItemAmount;
    }

    public void setCompanyOrderItemAmount(int companyOrderItemAmount) {
        this.companyOrderItemAmount = companyOrderItemAmount;
    }

    @Override
    public String toString() {
        return "CompanyOrderItem{" +
                "companyOrderItemPK=" + companyOrderItemPK +
                ", companyOrderItemAmount=" + companyOrderItemAmount +
                '}';
    }
}
