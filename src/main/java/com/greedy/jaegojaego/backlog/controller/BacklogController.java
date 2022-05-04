package com.greedy.jaegojaego.backlog.controller;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogInWarehouseDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogItemInfoDTO;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogInWarehouse;
import com.greedy.jaegojaego.backlog.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <pre>
 * Class : BacklogController
 * Comment : Backlog관련 메소드를 모아놓은 Controller입니다.
 * History
 * 2022/05/01 (이소현) 백로그 관련 초기 설정
 * 2022/05/02 (이소현) 입고 백로그 목록 조회
 * 2022/05/03 (이소현) 입고 백로그 목록 조회
 * 2022/05/04 (이소현) 입고 백로그 목록 조회
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see BacklogService, InWarehouseBacklogRepository, InWarehouseBacklogRepository 등
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
    public ModelAndView backlogPage(ModelAndView mv) {
       List<BacklogInWarehouseDTO> inWarehouseBacklogList = backlogService.selectInWarehouseBacklogList();

       mv.addObject("inWarehouseBacklogList", inWarehouseBacklogList);
       mv.setViewName("backlog/backlogList");

       return mv;
   }

   @GetMapping(value = "iteminfolist", produces = "application/json; charset=UTF-8")
   @ResponseBody
   public List<BacklogItemInfoDTO> findItemInfoList() {

        return backlogService.findItemInfoList();
   }

}
