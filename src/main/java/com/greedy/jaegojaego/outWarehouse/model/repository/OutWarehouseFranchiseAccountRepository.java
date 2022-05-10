package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseAccount;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseAccountPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OutWarehouseFranchiseAccountRepository extends JpaRepository<OutWarehouseFranchiseAccount, Integer> {

    @Query(value = "SELECT a FROM outWarehouseFranchiseAccount a WHERE a.franchiseManagerNo = :accountPkParam")
    OutWarehouseFranchiseAccount getRepresentativeNo(OutWarehouseFranchiseAccountPk accountPkParam);
}
