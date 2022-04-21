package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutWarehouseRepository extends JpaRepository<OutWarehouse, Integer> {

    @Query(value = "SELECT A.OUT_WAREHOUSE_NO, A.OUT_WAREHOUSE_WORKING_FINISHED_DATE, A.OUT_WAREHOUSE_WORKING_STATUS_NAME, " +
            "              B.FRANCHISE_BRANCH_NAME, B.FRANCHISE_ADDRESS, " +
            "              A.OUT_WAREHOUSE_TOTAL_OUT_ITEM_AMOUNT\n" +
            "         FROM OUT_WAREHOUSE A\n" +
            "         JOIN FRANCHISE_INFO B ON (A.FRANCHISE_REPRESENTATIVE_NO = B.FRANCHISE_REPRESENTATIVE_NO)\n" +
            "        ORDER BY A.OUT_WAREHOUSE_NO DESC",
            nativeQuery = true)
    List<OutWarehouse> findOutWarehouseList();
}
