package com.greedy.jaegojaego.order.order.model.repository;

import com.greedy.jaegojaego.order.order.model.entitiy.CompanyOrderItem;
import com.greedy.jaegojaego.order.order.model.entitiy.CompanyOrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyOrderItemRepository extends JpaRepository<CompanyOrderItem, CompanyOrderItemPK> {

    @Query(value = "INSERT " +
            "         INTO COMPANY_ORDER_ITEM A " +
            "       ( " +
            "         A.COMPANY_ORDER_ITEM_AMOUNT " +
            "       , A.COMPANY_ORDER_HISTORY_NO " +
            "       , A.ITEM_INFO_NO" +
            "       ) " +
            "       VALUES " +
            "       ( " +
            "         ?2 " +
            "       , ?3 " +
            "       , ?1 " +
            "       )", nativeQuery = true
    )
    void insertCompanyOrderItem(int itemNo, Integer itemAmount, int companyOrderHistoryNo);
}
