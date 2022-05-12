package com.greedy.jaegojaego.outWarehouse.model.repository;

import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouse;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : OutWarehouseDetailRepository
 * Comment : 출고 목록 조회 관련 로직 처리 메소드를 모아둔 Repository입니다.
 * History
 * 2022/04/21 (이태준) 출고 목록 조회 로직
 * 2022/04/25 (이태준) 출고 목록 조회 로직 재수정
 * 2022/04/30 (이태준) 출고 목록 조회 로직 마무리
 * </pre>
 * @version 1.1
 * @author 이태준
 * */
@Repository
public interface OutWarehouseRepository extends JpaRepository<OutWarehouse, Integer> {

    /**
     * findByOutWarehouseNo : 출고 목록 조회
     * @param outWarehouseNo : 출고번호
     * @return : 출고 목록
     */
    OutWarehouse findByOutWarehouseNo(int outWarehouseNo);
}
