package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "OutWarehouseFranchiseInfo")
@Table(name = "FRANCHISE_INFO")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_FRANCHISE_INFO_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_REPRESENTATIVE_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutWarehouseFranchiseInfo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_FRANCHISE_INFO_SEQ_GENERATOR"
    )
    @Column(name = "FRANCHISE_REPRESENTATIVE_NO")
    private int franchiseRepresentativeNo;

    @Column(name = "FRANCHISE_BRANCH_NAME")
    private String franchiseBranchName;

    @Column(name = "FRANCHISE_ADDRESS")
    private String franchiseAddress;

    @Override
    public String toString() {
        return "OutWarehouseFranchiseInfo{" +
                "franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                ", franchiseBranchName='" + franchiseBranchName + '\'' +
                ", franchiseAddress='" + franchiseAddress + '\'' +
                '}';
    }
}
