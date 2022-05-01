package com.greedy.jaegojaego.backlog.controller;

import com.greedy.jaegojaego.backlog.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * Class : BacklogController
 * Comment : Backlog관련 메소드를 모아놓은 Controller입니다.
 * History
 * 2022/05/01 (이소현) 백로그 관련 초기 설정
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see BacklogService, BacklogRepository, BacklogRepository 등
 */
@Controller
@RequestMapping("backlog")
public class BacklogController {

    private final BacklogService backlogService;

    @Autowired
    public BacklogController(BacklogService backlogService) {
        this.backlogService = backlogService;
    }


   @GetMapping("list")
    public String backlogPage() {

       return "backlog/backlogList";
   }

}
