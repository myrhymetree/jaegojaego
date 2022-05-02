package com.greedy.jaegojaego.order.warehouse.repository;

import com.greedy.jaegojaego.order.warehouse.entity.OrderItemWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemWarehouseRepository extends JpaRepository<OrderItemWarehouse, Integer> {

    @Query(value = "SELECT A.ITEM_WAREHOUSE_ADDRESS " +
            "         FROM ITEM_WAREHOUSE A " +
            "        WHERE ROWNUM < 2 " +
            "          AND A.ITEM_WAREHOUSE_DIVISION = '가공 전 창고'", nativeQuery = true)
    String selectItemWarehouseAddress();
}
