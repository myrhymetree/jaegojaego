package com.greedy.jaegojaego.franchise.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@SequenceGenerator(
        name = "FRANCHISE_CONTRACT_UPDATED_RECORD_GENERATOR",
        sequenceName = "FRANCHISE_CONTRACT_UPDATE_NO",
        initialValue = 1,
        allocationSize = 1
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "FranchiseContractUpdatedRecord")
@Table(name = "FRANCHISE_CONTRACT_UPDATE_RECORD")
public class FranchiseContractUpdatedRecord {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FRANCHISE_CONTRACT_UPDATED_RECORD_GENERATOR"
    )
    @Column(name = "FRANCHISE_CONTRACT_UPDATE_NO")
    private Integer franchiseContractUpdateNo;

    @Column(name = "FRANCHISE_CONTRACT_STARTED_DATE")
    private LocalDateTime franchiseContractStartedDate;

    @Column(name = "FRANCHISE_CONTRACT_EXPIRED_DATE")
    private LocalDateTime franchiseContractExpiredDate;

    @Column(name = "FRANCHISE_CONTRACT_STATUS")
    private String franchiseContractStatus;

    @Column(name = "FRANCHISE_REPRESENTATIVE_NO")
    private Integer franchiseRepresentativeNo;

    @Override
    public String toString() {
        return "FranchiseContractUpdatedRecord{" +
                "franchiseContractUpdateNo=" + franchiseContractUpdateNo +
                ", franchiseContractStartedDate=" + franchiseContractStartedDate +
                ", franchiseContractExpiredDate=" + franchiseContractExpiredDate +
                ", franchiseContractStatus='" + franchiseContractStatus + '\'' +
                ", franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                '}';
    }
}
