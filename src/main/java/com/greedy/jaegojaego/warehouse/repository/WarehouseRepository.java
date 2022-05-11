package com.greedy.jaegojaego.warehouse.repository;

import com.greedy.jaegojaego.warehouse.dto.WarehouseInItemDTO;
import com.greedy.jaegojaego.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    Warehouse findByWarehouseNo(int warehouseNo);

    @Query(value = "SELECT * " +
            "         FROM IN_WAREHOUSE A ", nativeQuery = true)
    List<Warehouse> selectAllList();

//    @Query(value = "SELECT a FROM warehouse a ORDER BY a.warehouseNo DESC")
//    List<Warehouse> findAll();
//
//    Warehouse findByWarehouseNo(int warehouseNo);

//    void save(Warehouse warehouse, WarehouseStatusHistory warehouseStatusHistory);
}
