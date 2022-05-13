package com.greedy.jaegojaego.franchise.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * <pre>
 * Class : FranchiseInfoUpdatedRecord
 * Comment : FRANCHISE_INFO_UPDATED_RECORD 테이블과 대응할 엔티티
 *
 * History
 * 2022. 5. 13.  (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Builder
@SequenceGenerator(
        name = "FRANCHISE_INFO_UPDATED_RECORD_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_UPDATED_INFO_NO",
        initialValue = 1,
        allocationSize = 1
)
@Entity(name = "FranchiseInfoUpdatedRecord")
@Table(name = "FRANCHISE_INFO_UPDATED_RECORD")
public class FranchiseInfoUpdatedRecord {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FRANCHISE_INFO_UPDATED_RECORD_SEQ_GENERATOR"
    )
    @Column(name = "FRANCHISE_UPDATED_INFO_NO")
    private Integer franchiseUpdatedInfoNo;

    @Column(name = "INFO_WRITE_MEMBER_NO")
    private Integer infoWriteMemberNo;

    @Column(name = "FRANCHISE_UPDATED_DATE")
    private LocalDateTime franchiseUpdatedDate;

    @Column(name = "FRANCHISE_REPRESENTATIVE_NO")
    private Integer franchiseRepresentativeNo;

    public FranchiseInfoUpdatedRecord() {}

    public FranchiseInfoUpdatedRecord(Integer franchiseUpdatedInfoNo, Integer infoWriteMemberNo, LocalDateTime franchiseUpdatedDate, Integer franchiseRepresentativeNo) {
        this.franchiseUpdatedInfoNo = franchiseUpdatedInfoNo;
        this.infoWriteMemberNo = infoWriteMemberNo;
        this.franchiseUpdatedDate = franchiseUpdatedDate;
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public Integer getFranchiseUpdatedInfoNo() {
        return franchiseUpdatedInfoNo;
    }

    public void setFranchiseUpdatedInfoNo(Integer franchiseUpdatedInfoNo) {
        this.franchiseUpdatedInfoNo = franchiseUpdatedInfoNo;
    }

    public Integer getInfoWriteMemberNo() {
        return infoWriteMemberNo;
    }

    public void setInfoWriteMemberNo(Integer infoWriteMemberNo) {
        this.infoWriteMemberNo = infoWriteMemberNo;
    }

    public LocalDateTime getFranchiseUpdatedDate() {
        return franchiseUpdatedDate;
    }

    public void setFranchiseUpdatedDate(LocalDateTime franchiseUpdatedDate) {
        this.franchiseUpdatedDate = franchiseUpdatedDate;
    }

    public Integer getFranchiseRepresentativeNo() {
        return franchiseRepresentativeNo;
    }

    public void setFranchiseRepresentativeNo(Integer franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    @Override
    public String toString() {
        return "FranchiseInfoUpdatedRecord{" +
                "franchiseUpdatedInfoNo=" + franchiseUpdatedInfoNo +
                ", infoWriteMemberNo=" + infoWriteMemberNo +
                ", franchiseUpdatedDate=" + franchiseUpdatedDate +
                ", franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                '}';
    }
}
