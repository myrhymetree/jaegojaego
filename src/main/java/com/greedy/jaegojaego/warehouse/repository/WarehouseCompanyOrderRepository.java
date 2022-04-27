package com.greedy.jaegojaego.warehouse.repository;

import com.greedy.jaegojaego.warehouse.entity.ItemWarehouse;
import com.greedy.jaegojaego.warehouse.entity.WarehouseCompanyOrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseCompanyOrderRepository extends JpaRepository<WarehouseCompanyOrderHistory, Integer> {
}
