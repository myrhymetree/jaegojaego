package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutWarehouseFranchiseOrderRepository extends JpaRepository<OutWarehouseFranchiseOrder, Integer> {

    @Query(value = "SELECT A.FRANCHISE_ORDER_NO, A.MEMBER_NO " +
            "         FROM FRANCHISE_ORDER A " +
            "        WHERE A.FRANCHISE_ORDER_STATUS = 'COMPLETE'", nativeQuery = true)
    List<OutWarehouseFranchiseOrder> getFranchiseOrderListByStatus(String franchiseOrderStatus);
}
