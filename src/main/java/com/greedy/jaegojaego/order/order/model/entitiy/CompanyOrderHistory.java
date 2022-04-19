package com.greedy.jaegojaego.order.order.model.entitiy;

<<<<<<< HEAD:src/main/java/com/greedy/jaegojaego/order/model/entitiy/CompanyOrderHistory.java
=======
import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;
>>>>>>> origin/feature/order:src/main/java/com/greedy/jaegojaego/order/order/model/entitiy/CompanyOrderHistory.java
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