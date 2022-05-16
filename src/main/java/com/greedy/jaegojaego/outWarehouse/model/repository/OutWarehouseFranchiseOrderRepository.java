package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : OutWarehouseFranchiseOrderRepository
 * Comment : 가맹점 발주 목록 조회 및 처리상태 수정 로직 처리 메소드를 모아둔 Repository입니다.
 * History
 * 2022/05/11 (이태준) 가맹점 발주 목록 조회 로직
 * </pre>
 * @version 1.1
 * @author 이태준
 * */
@Repository
public interface OutWarehouseFranchiseOrderRepository extends JpaRepository<OutWarehouseFranchiseOrder, Integer> {

    /**
     * getFranchiseOrderListByStatus : 상태에 따른 가맹점 발주 목록 조회
     * @param franchiseOrderStatus : 가맹점 발주 처리상태
     * @return : 가맹점 발주 목록
     */
    @Query(value = "SELECT A.FRANCHISE_ORDER_NO, A.MEMBER_NO, A.FRANCHISE_ORDER_OUT_YN " +
            "         FROM FRANCHISE_ORDER A " +
            "        WHERE A.FRANCHISE_ORDER_STATUS = 'COMPLETE' " +
            "          AND A.FRANCHISE_ORDER_OUT_YN = 'N'", nativeQuery = true)
    List<OutWarehouseFranchiseOrder> getFranchiseOrderListByStatus(String franchiseOrderStatus);

    /**
     * findByFranchiseOrderNo : 가맹점 발주 번호로 발주 정보 조회
     * @param franchiseOrderNo : 가맹점 발주 번호
     * @return : 가맹점 발주 정보
     */
    OutWarehouseFranchiseOrder findByFranchiseOrderNo(int franchiseOrderNo);
}
