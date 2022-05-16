package com.greedy.jaegojaego.order.order.model.repository.company;

import com.greedy.jaegojaego.order.order.model.entity.company.OrderApplicationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderApplicationItemRepository extends JpaRepository<OrderApplicationItem, Integer> {

    @Query(value = "SELECT * " +
            "         FROM ORDER_APPLICATION_ITEM A " +
            "        WHERE A.ORDER_APPLICATION_NO = ?1 ", nativeQuery = true)
    List<OrderApplicationItem> findByOrderApplicationNo(int orderApplicationNo);
}
