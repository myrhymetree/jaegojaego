package com.greedy.jaegojaego.backlog.repository;

import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogItemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogItemInfoRepository extends JpaRepository<BacklogItemInfo, Integer> {
}
