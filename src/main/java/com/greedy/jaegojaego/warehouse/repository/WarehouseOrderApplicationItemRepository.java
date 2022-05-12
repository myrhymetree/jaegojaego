package com.greedy.jaegojaego.warehouse.repository;

import com.greedy.jaegojaego.warehouse.entity.WarehouseOrderApplicationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseOrderApplicationItemRepository extends JpaRepository<WarehouseOrderApplicationItem, Integer> {
}
