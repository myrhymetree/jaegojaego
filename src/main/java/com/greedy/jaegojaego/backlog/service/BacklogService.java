package com.greedy.jaegojaego.backlog.service;

import com.greedy.jaegojaego.backlog.repository.BacklogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * Class : BacklogService
 * Comment : Backlog관련 메소드를 모아놓은 Service입니다.
 * History
 * 2022/05/01 (이소현) BacklogService 기본 설정 작성
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see BacklogRepository , BacklogController
 * */
@Service
public class BacklogService {

    private final BacklogRepository backlogRepository;

    @Autowired
    public BacklogService(BacklogRepository backlogRepository) {
        this.backlogRepository = backlogRepository;
    }
}
