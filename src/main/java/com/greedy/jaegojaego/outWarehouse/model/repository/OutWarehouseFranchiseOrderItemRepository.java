package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrderItem;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutWarehouseFranchiseOrderItemRepository extends JpaRepository<OutWarehouseFranchiseOrderItem, Integer> {

//    List<OutWarehouseFranchiseOrderItemPk> findByFranchiseOrderNo(int franchiseOrderNo);
}
