package com.greedy.jaegojaego.warehouse.repository;

import com.greedy.jaegojaego.warehouse.entity.WarehouseItemChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : WarehouseItemChangeHistoryRepository
 * Comment : 재고 변동 내역 Entity관련 Method를 다루는 Repository입니다.
 * History
 * 2022/05/05 (석원탁) WarehouseItemChangeHistoryRepository 기본 설정 작성
 * </pre>
 * @version 1
 * @author 석원탁
 * */
@Repository
public interface WarehouseItemChangeHistoryRepository extends JpaRepository<WarehouseItemChangeHistory, Integer> {


}
