package com.greedy.jaegojaego.order.order.model.repository.company;

import com.greedy.jaegojaego.order.order.model.entity.company.CompanyOrderItem;
import com.greedy.jaegojaego.order.order.model.entity.company.CompanyOrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyOrderItemRepository extends JpaRepository<CompanyOrderItem, CompanyOrderItemPK> {

    @Query(value = "SELECT * " +
            "         FROM COMPANY_ORDER_ITEM A " +
            "        WHERE A.COMPANY_ORDER_HISTORY_NO = ?1 ", nativeQuery = true)
    List<CompanyOrderItem> findByCompanyOrderHistoryNo(int companyOrderHistoryNo);
}
