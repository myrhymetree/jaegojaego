package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseInfo;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseInfoPk;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OutWarehouseFranchiseInfoRepository extends JpaRepository<OutWarehouseFranchiseInfo, Integer> {

    @Query(value = "SELECT a " +
            "         FROM outWarehouseFranchiseInfo a " +
            "        WHERE a.franchiseRepresentativeNo = :pkParam")
    OutWarehouseFranchiseInfo getFranchiseInfo(OutWarehouseFranchiseInfoPk pkParam);
}
