package com.greedy.jaegojaego.backlog.repository.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogInWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
