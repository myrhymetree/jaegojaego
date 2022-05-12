package com.greedy.jaegojaego.warehouse.repository;

import com.greedy.jaegojaego.warehouse.entity.WarehouseItemChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseItemChangeHistoryRepository extends JpaRepository<WarehouseItemChangeHistory, Integer> {


}
