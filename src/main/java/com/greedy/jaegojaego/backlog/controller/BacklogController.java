package com.greedy.jaegojaego.backlog.controller;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogClientDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogInWarehouseDTO;
import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogItemInfoDTO;
import com.greedy.jaegojaego.backlog.dto.OutWarehouseBacklog.OutWarehouseBacklogDTO;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogInWarehouse;
import com.greedy.jaegojaego.backlog.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Class : BacklogController
 * Comment : Backlog관련 메소드를 모아놓은 Controller입니다.
 * History
 * 2022/05/01 (이소현) 백로그 관련 초기 설정
 * 2022/05/02 (이소현) 입고 백로그 목록 조회
 * 2022/05/03 (이소현) 입고 백로그 목록 조회
 * 2022/05/04 (이소현) 입고 백로그 목록 조회
 * 2022/05/05 (이소현) 입고 백로그 막대 차트 조회
 * 2022/05/06 (이소현) 입고 백로그 막대 차트 조회
 * 2022/05/07 (이소현) 입고 백로그 원차트 조회
 * 2022/05/08 (이소현) 출고 백로그 조회
 * 2022/05/09 (이소현) 출고 백로그 막대 그래프 조회
 * </pre>
 * @version 9
 * @author 이소현
 */
@Controller
@RequestMapping("backlog")
public class BacklogController {

    private final BacklogService backlogService;

    @Autowired
    public BacklogController(BacklogService backlogService) {
        this.backlogService = backlogService;
    }

    /**
     * selectInWarehouseBacklogList : 입고 백로그 목록 조회
     * @ return : 입고 백로그 목록
     * */
   @GetMapping("list")
    public ModelAndView backlogPage(ModelAndView mv) {
        List<BacklogInWarehouseDTO> inWarehouseBacklogList = backlogService.selectInWarehouseBacklogList();

        mv.addObject("inWarehouseBacklogList", inWarehouseBacklogList);
        mv.setViewName("backlog/backlogList");

        //       mv.setViewName("error/403");
        return mv;
   }

    /**
     * selectOutWarehouseBacklogList : 출고 백로그 목록 조회
     * @ return : 출고 백로그 목록
     * */
   @GetMapping("outwarehouselist")
   public ModelAndView moveOutWarehouseListPage(ModelAndView mv) {
        List<OutWarehouseBacklogDTO> outWarehouseBacklogList = backlogService.selectOutWarehouseBacklogList();

        mv.addObject("outWarehouseBacklogList", outWarehouseBacklogList);
        mv.setViewName("backlog/backlogOutWarehouseList");

        return mv;
   }

    /**
     * findItemInfoList : 자재 목록 조회
     * @ return : 자재 목록
     * */
   @GetMapping(value = "iteminfolist", produces = "application/json; charset=UTF-8")
   @ResponseBody
   public List<BacklogItemInfoDTO> findItemInfoList() {

        return backlogService.findItemInfoList();
   }

    /**
     * findBacklogInWarehouseBySelectBox : 입고 백로그 그래프를 위한 특정 자재 번호에 따른 특정 자재 내용 조회
     * @ param itemInfoNo : 특정 자재 번호
     * @ return : 특정 자재 내용
     * */
   @GetMapping(value = "selectonebackloglist", produces = "application/json; charset=UTF-8")
   @ResponseBody
   public List<BacklogInWarehouseDTO> findBacklogInWarehouseBySelectBox(@RequestParam int itemInfoNo) {

        return backlogService.findBacklogInWarehouseBySelectBox(itemInfoNo);
   }


    /**
     * findBacklogOutWarehouseBySelectBox : 출고 백로그 그래프를 위한 특정 자재 번호에 따른 특정 자재 내용 조회
     * @ param itemInfoNo : 특정 자재 번호
     * @ return : 특정 자재의 이슈발생날짜
     * */
   @GetMapping(value = "selectoneoutwarehousebackloglist", produces = "application/json; charset=UTF-8")
   @ResponseBody
   public List<Date> findBacklogOutWarehouseBySelectBox(@RequestParam int itemInfoNo) {

        return backlogService.findBacklogOutWarehouseBySelectBox(itemInfoNo);
   }

}
