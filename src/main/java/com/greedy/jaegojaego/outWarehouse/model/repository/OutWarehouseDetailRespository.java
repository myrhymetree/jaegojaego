package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : OutWarehouseDetailRepository
 * Comment : 출고 목록 상세정보와 관련 로직 처리 메소드를 모아둔 Repository입니다.
 * History
 * 2022/04/21 (이태준) 출고 상세조회 로직
 * 2022/04/25 (이태준) 출고 상세조회 로직 재작성
 * 2022/05/01 (이태준) 출고 상세조회 로직 마무리
 * </pre>
 * @version 1.1
 * @author 이태준
 * */
@Repository
public interface OutWarehouseDetailRespository extends JpaRepository<OutWarehouseFranchiseOrderItem, Integer> {

    /**
     * findAllFranchiseOrderItemList회 : 가맹점 발주 신청 물품 목록 리스트
     * @param outWarehouseNo : 출고번호
     * @return : 출고할 제품 목록 리스트
     */
    @Query(value = "SELECT A.FRANCHISE_ORDER_NO, A.FRANCHISE_ORDER_ITEM_AMOUNT, " +
            "              B.ITEM_INFO_NO, B.ITEM_INFO_ITEM_SERIAL_NO, B.ITEM_INFO_NAME, " +
            "              C.MATERIAL_CATEGORY_NO, C.MATERIAL_CATEGORY_NAME " +
            "         FROM FRANCHISE_ORDER_ITEM A " +
            "         JOIN ITEM_INFO B ON (A.ITEM_INFO_NO = B.ITEM_INFO_NO) " +
            "         JOIN MATERIAL_CATEGORY C ON (B.MATERIAL_CATEGORY_NO = C.MATERIAL_CATEGORY_NO) " +
            "         JOIN OUT_WAREHOUSE D ON (D.FRANCHISE_ORDER_NO = A.FRANCHISE_ORDER_NO) " +
            "        WHERE D.OUT_WAREHOUSE_NO = :outWarehouseNo", nativeQuery = true)
    List<OutWarehouseFranchiseOrderItem> findAllFranchiseOrderItemList(int outWarehouseNo);
}
