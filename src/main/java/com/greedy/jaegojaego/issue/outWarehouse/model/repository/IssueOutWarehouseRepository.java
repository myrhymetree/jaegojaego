package com.greedy.jaegojaego.issue.outWarehouse.model.repository;

import com.greedy.jaegojaego.issue.outWarehouse.model.entity.IssueOutWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueOutWarehouseRepository extends JpaRepository<IssueOutWarehouse, Integer> {
    IssueOutWarehouse findByFranchiseOrder_FranchiseOrderNoAndIssueOutWarehouseWorkingStatusName(int franchiseOrderNo, String 출고완료);
}
