package com.greedy.jaegojaego.backlog.repository.InWarehouseBacklog;

import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogClient;
import com.greedy.jaegojaego.menu.entity.MenuMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : BacklogClientRepository
 * Comment : BacklogClient Entity관련 메소드를 모아놓은 Repository입니다.
 * History
 * 2022/05/05 (이소현) BacklogClientRepository 기본 설정 작성, 입고 백로그 목록 조회
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see BacklogClient , BacklogService, BacklogClientDTO
 * */
@Repository
public interface BacklogClientRepository extends JpaRepository<BacklogClient, Integer> {


}
