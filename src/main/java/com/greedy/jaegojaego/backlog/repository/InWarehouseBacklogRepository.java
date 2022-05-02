package com.greedy.jaegojaego.backlog.repository;

import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.InWarehouseBacklog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InWarehouseBacklogRepository extends JpaRepository<InWarehouseBacklog, Integer> {


//    List<InWarehouseBacklog> findAllByBacklogInWarehouseHistory_inWarehouseStatusName(String inwarehouseStatus);

    @Query(
            value =
            " SELECT C.CLIENT_NAME, F.IN_WAREHOUSE_STATUS_AMOUNT, E.ITEM_INFO_NAME, E.ITEM_INFO_ITEM_SERIAL_NO, F.IN_WAREHOUSE_STATUS_HISTORY_DATE " +
            "   FROM COMPANY_IN_WAREHOUSE_ITEM_BACKLOG A " +
            "   JOIN IN_WAREHOUSE B ON (B.IN_WAREHOUSE_NO = A.IN_WAREHOUSE_DIVISION_NO) " +
            "   JOIN CLIENT C ON (B.CLIENT_NO = C.CLIENT_NO) " +
            "   JOIN ITEM_WAREHOUSE D ON (D.IN_WAREHOUSE_NO = B.IN_WAREHOUSE_NO) " +
            "   JOIN ITEM_INFO E ON (E.ITEM_INFO_NO = D.IN_WAREHOUSE_NO) " +
            "   JOIN IN_WAREHOUSE_STATUS_HISTORY F ON (B.IN_WAREHOUSE_NO = F.IN_WAREHOUSE_NO)" +
            "   WHERE F.IN_WAREHOUSE_STATUS_NAME = '입고 완료' ", nativeQuery = true)
    List<InWarehouseBacklog> selectInWarehouseList();
}
