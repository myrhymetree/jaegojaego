package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseItemChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : OutWarehouseItemChangeHistoryRepository
 * Comment : 재고 변동내역 추가 로직을 처리하기 위한 메소드를 모아둔 Repository입니다.
 * History
 * 2022/05/14 (이태준) 재고 변동 내역 추가 로직
 * </pre>
 * @version 1.0
 * @author 이태준
 * */
@Repository
public interface OutWarehouseItemChangeHistoryRepository extends JpaRepository<OutWarehouseItemChangeHistory, Integer> {
}
