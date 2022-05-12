package com.greedy.jaegojaego.backlog.repository.OutWarehouseBacklog;

import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogInWarehouse;
import com.greedy.jaegojaego.backlog.entity.OutWarehouseBacklog.OutWarehouseBacklog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Class : OutWarehouseBacklogRepository
 * Comment : OutWarehouseBacklog Entity관련 메소드를 모아놓은 Repository입니다.
 * History
 * 2022/05/08 (이소현) OutWarehouseBacklogRepository 기본 설정 작성, 출고 백로그 조회
 * </pre>
 * @version 1
 * @author 이소현
 * */
@Repository
public interface OutWarehouseBacklogRepository extends JpaRepository<OutWarehouseBacklog,Integer> {

    @Query(
            value = "SELECT * " +
                    "  FROM COMPANY_ISSUE_RELEASE_BACKLOG A " +
                    "  JOIN OUT_WAREHOUSE B ON(A.OUT_WAREHOUSE_DIVISION_NO = B.OUT_WAREHOUSE_NO) " +
                    "  JOIN FRANCHISE_ISSUE C ON(C.FRANCHISE_ISSUE_NO = B.FRANCHISE_ISSUE_NO) " +
                    "  JOIN ISSUE_ITEM D ON(D.FRANCHISE_ISSUE_NO = C.FRANCHISE_ISSUE_NO) " +
                    "  JOIN ITEM_INFO E ON(D.ITEM_INFO_NO = E.ITEM_INFO_NO) " +
                    " WHERE E.ITEM_INFO_NO = :itemInfoNo " , nativeQuery = true
    )
    List<OutWarehouseBacklog> findBacklogOutWarehouseBySelectBox(int itemInfoNo);

}
