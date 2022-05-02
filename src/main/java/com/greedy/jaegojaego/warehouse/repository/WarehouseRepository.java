package com.greedy.jaegojaego.warehouse.repository;

import com.greedy.jaegojaego.warehouse.dto.WarehouseInItemDTO;
import com.greedy.jaegojaego.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
//    Warehouse findAllRawList();

    @Query(value = "SELECT a FROM warehouse a ORDER BY a.warehouseNo DESC")
    List<Warehouse> findAll();

    Warehouse findByWarehouseNo(int warehouseNo);
}
