package com.greedy.jaegojaego.order.order.model.repository.company;

import com.greedy.jaegojaego.order.order.model.entity.company.CompanyOrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyOrderHistoryRepository extends JpaRepository<CompanyOrderHistory, Integer> {

    @Query(value = "SELECT A.COMPANY_ORDER_HISTORY_NO " +
            "         FROM COMPANY_ORDER_HISTORY A " +
            "        WHERE ROWNUM < 2 " +
            "        ORDER BY A.COMPANY_ORDER_HISTORY_NO DESC", nativeQuery = true)
    int selectRecentHistoryNo();
}
