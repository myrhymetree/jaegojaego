package com.greedy.jaegojaego.order.client.model.repository;

import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderClientContractItemRepository extends JpaRepository<OrderClientContractItem, Integer> {

    @Query(value = "SELECT * " +
            "         FROM CLIENT_CONTRACT_ITEM A " +
            "         JOIN ITEM_INFO B ON (A.ITEM_INFO_NO = B.ITEM_INFO_NO) " +
            "        WHERE A.ITEM_INFO_NO = ?1", nativeQuery = true)
    List<OrderClientContractItem> selectClientContractItemList(int itemInfoNo);

}
