package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutWarehouseFranchiseOrderRepository extends JpaRepository<OutWarehouseFranchiseOrder, Integer> {

    @Query(value = "SELECT a, b FROM outWarehouseFranchiseOrder a" +
            "         JOIN a.memberNo b")
    List<OutWarehouseFranchiseOrder> findAllMemberInfo();

//    List<OutWarehouseFranchiseOrder> findAllFranchiseOrderList();
}