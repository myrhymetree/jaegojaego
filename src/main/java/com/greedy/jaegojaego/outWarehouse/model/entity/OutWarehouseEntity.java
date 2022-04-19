package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "OutWarehouse")
@Table(name = "OUT_WAREHOUSE")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_SEQ_GENERATOR",
        sequenceName = "SEQ_OUT_WAREHOUSE_DIVISION_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutWarehouseEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_SEQ_GENERATOR"
    )
    @Column(name = "OUT_WAREHOUSE_DIVISION_NO")
    private int outWarehouseDivisionNo;

    @Column(name = "OUT_WAREHOUSE_NO")
    private int outWarehouseNo;

    @Column(name = "OUT_WAREHOUSE_DIVISION")
    private int outWarehouseDivision;

    @Column(name = "FRANCHISE_REPRESENTATIVE_NO")
    private int franchiseRepresentativeNo;

    @Column(name = "FRANCHISE_ORDER_NO")
    private int franchiseOrderNo;

    @Column(name = "FRANCHISE_ISSUE_NO")
    private int franchiseIssueNo;

//    미완성. 아직 어떤 테이블들이랑 연결해줘야할지 잘 모름. 연결해야할게 많아서 기능하나하나 할때마다 추가
}
