package com.greedy.jaegojaego.order.order.model.repository;

import com.greedy.jaegojaego.order.order.model.entitiy.OrderApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderApplicationRepository extends JpaRepository<OrderApplication, Integer> {

    @Query(value = "SELECT A.ORDER_APPLICATION_NO " +
            "         FROM ORDER_APPLICATION A " +
            "        WHERE ROWNUM < ?1 " +
            "        ORDER BY A.ORDER_APPLICATION_NO DESC", nativeQuery = true)
    List<Integer> selectRecentOrderApplication(int size);

    @Query(value = "SELECT A.CLIENT_NO " +
            "         FROM ORDER_APPLICATION A " +
            "        WHERE ROWNUM < ?1 " +
            "        ORDER BY A.ORDER_APPLICATION_NO DESC", nativeQuery = true)
    List<Integer> selectRecentOrderApplicationClient(int size);
}
