package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrderItem;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutWarehouseFranchiseOrderItemRepository extends JpaRepository<OutWarehouseFranchiseOrderItem, Integer> {

    @Query(value = "SELECT A.FRANCHISE_ORDER_NO, A.ITEM_INFO_NO, A.FRANCHISE_ORDER_ITEM_AMOUNT " +
            "         FROM FRANCHISE_ORDER_ITEM A " +
            "        WHERE A.FRANCHISE_ORDER_NO = :franchiseOrderNo", nativeQuery = true)
    List<OutWarehouseFranchiseOrderItem> findByFranchiseOrderItemPk(int franchiseOrderNo);

//    List<OutWarehouseFranchiseOrderItemPk> findByFranchiseOrderNo(int franchiseOrderNo);
}
