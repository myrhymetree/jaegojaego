package com.greedy.jaegojaego.warehouse.repository;

import com.greedy.jaegojaego.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : WarehouseRepository
 * Comment : 입고 내역 Entity관련 Method를 다루는 Repository입니다.
 * History
 * 2022/05/05 (석원탁) WarehouseRepository 기본 설정 작성
 * 2022/05/08 (석원탁) 입고 완료 처리 시 입고 table 정보 수정
 * </pre>
 * @version 2
 * @author 석원탁
 * */
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    Warehouse findByWarehouseNo(int warehouseNo);
}
