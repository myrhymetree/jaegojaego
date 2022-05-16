package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseItemAmount;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseItemAmountPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : OutWarehouseDetailRepository
 * Comment : 재고 총수량 조회 및 수정 로직 처리 메소드를 모아둔 Repository입니다.
 * History
 * 2022/05/12 (이태준) 재고 총수량 조회 로직
 * </pre>
 * @version 1.0
 * @author 이태준
 * */
@Repository
public interface OutWarehouseItemAmountRepository extends JpaRepository<OutWarehouseItemAmount, Integer> {

    /**
     * findByItemInfoNo : 재고 정보 조회
     * @param outWarehouseItemAmountPk : 재고 수량 엔티티 pk 데이터
     * @return 재고 정보
     */
    OutWarehouseItemAmount findByItemInfoNo(OutWarehouseItemAmountPk outWarehouseItemAmountPk);
}
