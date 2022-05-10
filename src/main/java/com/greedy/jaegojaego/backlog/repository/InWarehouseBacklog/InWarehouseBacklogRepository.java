package com.greedy.jaegojaego.backlog.repository.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogInWarehouse;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogItemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 * Class : InWarehouseBacklogRepository
 * Comment : BacklogInWarehouse Entity관련 메소드를 모아놓은 Repository입니다.
 * History
 * 2022/05/02 (이소현) InWarehouseBacklogRepository 기본 설정 작성, 입고 백로그 목록 조회
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see BacklogInWarehouse , BacklogService, BacklogInWarehouseDTO
 * */
@Repository
public interface InWarehouseBacklogRepository extends JpaRepository<BacklogInWarehouse, Integer> {


    @Query(
            value = "SELECT * " +
                    "  FROM IN_WAREHOUSE A " +
                    " WHERE A.ITEM_INFO_NO = :itemInfoNo " +
                    "   AND A.IN_WAREHOUSE_STATUS = '입고 완료'", nativeQuery = true
    )
    List<BacklogInWarehouse> findBacklogInWarehouseBySelectBox(int itemInfoNo);
}
