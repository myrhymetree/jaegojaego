package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouse;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutWarehouseRepository extends JpaRepository<OutWarehouse, Integer> {

    @Query(value = "SELECT a, b FROM OutWarehouse a JOIN a.franchiseRepresentativeNo b ORDER BY a.outWarehouseNo DESC")
//    @Query(value = "SELECT a.outWarehouseNo, a.outWarehouseWorkingFinishedDate, a.outWarehouseWorkingStatusName, a.outWarehouseTotalOutItemAmount, " +
//            "              b.franchiseBranchName, b.franchiseAddress, b.franchiseRepresentativeNo\n" +
//            "         FROM OutWarehouse a\n" +
//            "         JOIN a.franchiseRepresentativeNo b")
    List<OutWarehouse> findOutWarehouseList();

    List<OutWarehouseItem> findItemListByOutWarehouseNo(int outWarehouseNo);
}
