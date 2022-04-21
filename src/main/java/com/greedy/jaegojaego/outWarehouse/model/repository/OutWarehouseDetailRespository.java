package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutWarehouseDetailRespository extends JpaRepository<OutWarehouseItem, Integer> {

    @Query(value = "SELECT a, b, c, d, e " +
            "         FROM OutWarehouseItem a " +
            "         JOIN a.outWarehouseNo b " +
            "         JOIN a.itemWarehouseNo c " +
            "         JOIN b.franchiseRepresentativeNo d " +
            "         JOIN c.itemInfoNo e " +
            "         JOIN e.materialCategoryNo f")
    List<OutWarehouseItem> findByOutWarehouseNo(int outWarehouseNo);
}
