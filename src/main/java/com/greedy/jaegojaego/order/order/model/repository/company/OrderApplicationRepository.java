package com.greedy.jaegojaego.order.order.model.repository.company;

import com.greedy.jaegojaego.order.order.model.entity.company.OrderApplication;
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
            "        ORDER BY A.CLIENT_NO DESC", nativeQuery = true)
    List<Integer> selectRecentOrderApplicationClient(int size);

    List<OrderApplication> findByCompanyOrderHistory_CompanyOrderHistoryNo(int companyOrderHistoryNo);

    @Query(value = "SELECT * " +
            "         FROM ORDER_APPLICATION A " +
            "        WHERE ROWNUM < ?1 " +
            "        ORDER BY A.ORDER_APPLICATION_NO DESC", nativeQuery = true)
    List<OrderApplication> selectRecentOrderApplicationList(int size);
}
