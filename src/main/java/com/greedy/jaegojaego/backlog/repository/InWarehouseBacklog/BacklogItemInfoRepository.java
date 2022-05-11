package com.greedy.jaegojaego.backlog.repository.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogClient;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogItemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : BacklogItemInfoRepository
 * Comment : BacklogItemInfo Entity관련 메소드를 모아놓은 Repository입니다.
 * History
 * 2022/05/05 (이소현) BacklogItemInfoRepository 기본 설정 작성, 입고 백로그 목록 조회
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see BacklogItemInfo , BacklogService, BacklogItemInfoDTO
 * */
@Repository
public interface BacklogItemInfoRepository extends JpaRepository<BacklogItemInfo, Integer> {
}