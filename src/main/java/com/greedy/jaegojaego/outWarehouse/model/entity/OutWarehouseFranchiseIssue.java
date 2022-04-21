package com.greedy.jaegojaego.outWarehouse.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "OutWarehouseFranchiseIssue")
@Table(name = "FRANCHISE_ISSUE")
@SequenceGenerator(
        name = "OUT_WAREHOUSE_FRANCHISE_ISSUE_SEQ_GENERATOR",
        sequenceName = "FRANCHISE_ISSUE_NO",
        initialValue = 1,
        allocationSize = 1
)
public class OutWarehouseFranchiseIssue {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "OUT_WAREHOUSE_FRANCHISE_ISSUE_SEQ_GENERATOR"
    )
    @Column(name = "FRANCHISE_ISSUE_NO")
    private int franchiseIssueNo;

    @Column(name = "FRANCHISE_ISSUE_STATUS")
    private String franchiseIssueStatus;

    @ManyToOne
    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE_NO")
    private OutWarehouseFranchiseInfo franchiseRepresentativeNo;

    public OutWarehouseFranchiseIssue() {}

    public OutWarehouseFranchiseIssue(int franchiseIssueNo, String franchiseIssueStatus, OutWarehouseFranchiseInfo franchiseRepresentativeNo) {
        this.franchiseIssueNo = franchiseIssueNo;
        this.franchiseIssueStatus = franchiseIssueStatus;
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    public int getFranchiseIssueNo() {
        return franchiseIssueNo;
    }

    public String getFranchiseIssueStatus() {
        return franchiseIssueStatus;
    }

    public OutWarehouseFranchiseInfo getFranchiseRepresentativeNo() {
        return franchiseRepresentativeNo;
    }

    public void setFranchiseIssueNo(int franchiseIssueNo) {
        this.franchiseIssueNo = franchiseIssueNo;
    }

    public void setFranchiseIssueStatus(String franchiseIssueStatus) {
        this.franchiseIssueStatus = franchiseIssueStatus;
    }

    public void setFranchiseRepresentativeNo(OutWarehouseFranchiseInfo franchiseRepresentativeNo) {
        this.franchiseRepresentativeNo = franchiseRepresentativeNo;
    }

    @Override
    public String toString() {
        return "OutWarehouseFranchiseIssue{" +
                "franchiseIssueNo=" + franchiseIssueNo +
                ", franchiseIssueStatus='" + franchiseIssueStatus + '\'' +
                ", franchiseRepresentativeNo=" + franchiseRepresentativeNo +
                '}';
    }
}
