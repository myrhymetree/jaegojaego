package com.greedy.jaegojaego.order.order.model.repository;

import com.greedy.jaegojaego.order.order.model.entitiy.CompanyOrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyOrderHistoryRepository extends JpaRepository<CompanyOrderHistory, Integer> {

    @Query(value = "SELECT A.COMPANY_ORDER_HISTORY_NO " +
            "         FROM COMPANY_ORDER_HISTORY A " +
            "        WHERE ROWNUM < 2 " +
            "        ORDER BY A.COMPANY_ORDER_HISTORY_NO DESC", nativeQuery = true)
    int selectRecentHistoryNo();
}
