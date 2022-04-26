package com.greedy.jaegojaego.franchise.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity(name = "FranchiseContractUpdatedRecord")
@Table(name = "FRANCHISE_CONTRACT_UPDATE_RECORD")
public class FranchiseContractUpdatedRecord {

    @Id
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
}
