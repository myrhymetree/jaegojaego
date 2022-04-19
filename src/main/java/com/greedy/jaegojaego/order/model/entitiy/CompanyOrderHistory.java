package com.greedy.jaegojaego.order.model.entitiy;

import com.greedy.jaegojaego.company.model.entity.OrderCompanyAccount;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "CompanyOrderHistory")
@Table(name = "COMPANY_ORDER_HISTORY")
@SequenceGenerator(
        name = "COMPANY_ORDER_HISTORY_SEQ_GENERATOR",
        sequenceName = "COMPANY_ORDER_HISTORY_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyOrderHistory {

    @Id
    @Column(name = "COMPANY_ORDER_HISTORY_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "COMPANY_ORDER_HISTORY_SEQ_GENERATOR"
    )
    private int companyOrderHistoryNo;

    @Column(name = "COMPANY_ORDER_HISTORY_CREATED_DATE")
    private java.sql.Date companyOrderHistoryCreatedDate;

    @ManyToOne
    @JoinColumn(name = "MEMBER_NO")
    private OrderCompanyAccount orderCompanyAccount;

    @OneToMany
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private List<CompanyOrderItem> companyOrderItemList;

    @OneToMany
    @JoinColumn(name = "COMPANY_ORDER_HISTORY_NO")
    private List<OrderApplication> orderApplicationList;

    @Override
    public String toString() {
        return "CompanyOrderHistory{" +
                "companyOrderHistoryNo=" + companyOrderHistoryNo +
                ", companyOrderHistoryCreatedDate=" + companyOrderHistoryCreatedDate +
                ", companyAccount=" + orderCompanyAccount +
                ", companyOrderItemList=" + companyOrderItemList +
                ", orderApplicationList=" + orderApplicationList +
                '}';
    }
}
