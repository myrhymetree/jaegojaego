package com.greedy.jaegojaego.order.order.model.entitiy.franchise;

import com.greedy.jaegojaego.order.franchise.model.entity.OrderFranchiseInfo;

import javax.persistence.*;
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
    private int franchiseOrderOrderNumber;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private OrderFranchiseInfo orderFranchiseInfo;

    @OneToMany
    @JoinColumn(name = "FRANCHISE_ORDER_NO")
    private List<FranchiseOrderItem> franchiseOrderItemList;

    @OneToMany
    @JoinColumn(name = "FRANCHISE_ORDER_NO")
    private List<FranchiseOrderStatusHistory> franchiseOrderStatusHistoryList;


}
