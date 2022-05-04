package com.greedy.jaegojaego.backlog.repository;

import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogInWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InWarehouseBacklogRepository extends JpaRepository<BacklogInWarehouse, Integer> {

}
