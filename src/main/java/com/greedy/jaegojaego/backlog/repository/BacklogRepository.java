package com.greedy.jaegojaego.backlog.repository;

import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BacklogRepository extends JpaRepository<InWarehouseBacklog, Integer> {
}
