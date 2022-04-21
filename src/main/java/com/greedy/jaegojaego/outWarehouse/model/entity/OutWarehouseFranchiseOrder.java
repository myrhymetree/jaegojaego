package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "OutWarehouseFranchiseOrder")
@Table(name = "FRANCHISE_ORDER")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_FRANCHISE_ORDER_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_ORDER_NO",
        initialValue = 1,
        allocationSize = 1
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutWarehouseFranchiseOrder {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_FRANCHISE_ORDER_SEQ_GENERATOR"
    )
    @Column(name = "FRANCHISE_ORDER_NO")
    private int franchiseOrderNo;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private OutWarehouseFranchiseInfo franchiseRepresentativeNo;

}
