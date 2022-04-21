package com.greedy.jaegojaego.warehouse.repository;

import com.greedy.jaegojaego.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    List<Warehouse> findAll();
}
