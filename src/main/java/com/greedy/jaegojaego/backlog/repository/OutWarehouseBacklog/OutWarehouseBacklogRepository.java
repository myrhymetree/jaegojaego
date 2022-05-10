package com.greedy.jaegojaego.backlog.repository.OutWarehouseBacklog;

import com.greedy.jaegojaego.backlog.entity.OutWarehouseBacklog.OutWarehouseBacklog;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface OutWarehouseBacklogRepository extends JpaRepository<OutWarehouseBacklog,Integer> {

    @Query( //필요한 애들만 select하게(부적접한열나옴 ㄱㄷ)
            value = "SELECT * " +
                    "  FROM COMPANY_ISSUE_RELEASE_BACKLOG A " +
                    "  JOIN OUT_WAREHOUSE B ON(A.OUT_WAREHOUSE_DIVISION_NO = B.OUT_WAREHOUSE_NO) " +
                    "  JOIN FRANCHISE_ISSUE C ON(C.FRANCHISE_ISSUE_NO = B.FRANCHISE_ISSUE_NO) " +
                    "  JOIN ISSUE_ITEM D ON(D.FRANCHISE_ISSUE_NO = C.FRANCHISE_ISSUE_NO) " +
                    "  JOIN ITEM_INFO E ON(D.ITEM_INFO_NO = E.ITEM_INFO_NO) " +
                    " WHERE E.ITEM_INFO_NO = :itemInfoNo " , nativeQuery = true
    )
    List<OutWarehouseBacklog> findBacklogOutWarehouseBySelectBox(int itemInfoNo);

//    @Override
//    @EntityGraph(attributePaths = {"test"})
//    List<OutWarehouseBacklog> findAll();

}
