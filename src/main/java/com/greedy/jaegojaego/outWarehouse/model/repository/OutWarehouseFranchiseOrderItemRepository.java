package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrderItem;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : OutWarehouseFranchiseOrderItemRepository
 * Comment : 가맹점 발주 신청 물품 정보 조회 로직 처리 메소드를 모아둔 Repository입니다.
 * History
 * 2022/05/12 (이태준) 가맹점 발주 신청 물품 정보 조회 로직
 * </pre>
 * @version 1.0
 * @author 이태준
 * */
@Repository
public interface OutWarehouseFranchiseOrderItemRepository extends JpaRepository<OutWarehouseFranchiseOrderItem, Integer> {

    /**
     * findByFranchiseOrderItemPk : 가맹점 발주 신청 물품 목록 조회
     * @param franchiseOrderNo : 가맹점 발주 번호
     * @return 가맹점 발주 신청 물품 목록
     */
    @Query(value = "SELECT A.FRANCHISE_ORDER_NO, A.ITEM_INFO_NO, A.FRANCHISE_ORDER_ITEM_AMOUNT " +
            "         FROM FRANCHISE_ORDER_ITEM A " +
            "        WHERE A.FRANCHISE_ORDER_NO = :franchiseOrderNo", nativeQuery = true)
    List<OutWarehouseFranchiseOrderItem> findByFranchiseOrderItemPk(int franchiseOrderNo);
}
