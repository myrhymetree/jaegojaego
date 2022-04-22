package com.greedy.jaegojaego.order.item.model.repository;

import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemInfoRepository extends JpaRepository<OrderItemInfo, Integer> {

    List<OrderItemInfo> findByItemInfoNameContaining(String searchItem);

    @Query(value = "SELECT * " +
            "         FROM ITEM_INFO A " +
            "        WHERE A.ITEM_INFO_NAME LIKE '%' ||  ?1 || '%'", nativeQuery = true)
    List<OrderItemInfo> selectByItemInfoNameContaining(String searchItem);
}
