package com.greedy.jaegojaego.franchise.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * <pre>
 * Class : FranchiseContractUpdatedRecord
 * Comment : FRANCHISE_CONTRACT_UPDATE_RECORD 테이블과 대응할 엔티티
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@SequenceGenerator(
        name = "FRANCHISE_CONTRACT_UPDATED_RECORD_GENERATOR",
        sequenceName = "FRANCHISE_CONTRACT_UPDATE_NO",
        initialValue = 1,
        allocationSize = 1
)
@Builder
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

    public FranchiseContractUpdatedRecord() {}

    public FranchiseContractUpdatedRecord(Integer franchiseContractUpdateNo, LocalDateTime franchiseContractStartedDate, LocalDateTime franchiseContractExpiredDate, String franchiseContractStatus, Integer franchiseRepresentativeNo) {
        this.franchiseContractUpdateNo = franchiseContractUpdateNo;
        this.franchiseContractStartedDate = franchiseContractStartedDate;
        this.franchiseContractExpiredDate = franchiseContractExpiredDate;
        this.franchiseContractStatus = franchiseContractStatus;
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public Integer getFranchiseContractUpdateNo() {
        return franchiseContractUpdateNo;
    }

    public void setFranchiseContractUpdateNo(Integer franchiseContractUpdateNo) {
        this.franchiseContractUpdateNo = franchiseContractUpdateNo;
    }

    public LocalDateTime getFranchiseContractStartedDate() {
        return franchiseContractStartedDate;
    }

    public void setFranchiseContractStartedDate(LocalDateTime franchiseContractStartedDate) {
        this.franchiseContractStartedDate = franchiseContractStartedDate;
    }

    public LocalDateTime getFranchiseContractExpiredDate() {
        return franchiseContractExpiredDate;
    }

    public void setFranchiseContractExpiredDate(LocalDateTime franchiseContractExpiredDate) {
        this.franchiseContractExpiredDate = franchiseContractExpiredDate;
    }

    public String getFranchiseContractStatus() {
        return franchiseContractStatus;
    }

    public void setFranchiseContractStatus(String franchiseContractStatus) {
        this.franchiseContractStatus = franchiseContractStatus;
    }

    public Integer getFranchiseRepresentativeNo() {
        return franchiseRepresentativeNo;
    }

    public void setFranchiseRepresentativeNo(Integer franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

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
