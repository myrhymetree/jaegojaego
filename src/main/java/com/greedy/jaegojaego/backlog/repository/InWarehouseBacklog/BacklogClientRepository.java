package com.greedy.jaegojaego.backlog.repository.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogClientRepository extends JpaRepository<BacklogClient, Integer> {


}
