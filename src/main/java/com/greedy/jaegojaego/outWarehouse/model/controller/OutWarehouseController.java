package com.greedy.jaegojaego.outWarehouse.model.controller;

import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseDetailListDTO;
import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseFranchiseOrderListDTO;
import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseListDTO;
import com.greedy.jaegojaego.outWarehouse.model.service.OutWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
 * <pre>
 * Class : OutWarehouseController
 * History
 * 2022/04/18 (이태준) 처음 작성
 * 2022/04/21 (이태준) 출고 목록 조회 기능, 출고 상세조회 기능
 * </pre>
 * @version 1
 * @author 이태준
 * */
@Controller
@RequestMapping("/outwarehouse")
public class OutWarehouseController {

    private final OutWarehouseService outWarehouseService;

    @Autowired
    public OutWarehouseController(OutWarehouseService outWarehouseService) {
        this.outWarehouseService = outWarehouseService;
    }

    /**
     * findOutwarehouseList : 출고 목록 조회
     * @param mv : 출고 목록 정보와 화면 경로 정보를 담은 객체
     * @return : 출고 목록, 화면 경로
     */
    @GetMapping("/list")
    public ModelAndView findOutWarehouseList(ModelAndView mv) {

        List<OutWarehouseListDTO> outWarehouseList = outWarehouseService.findOutWarehouseList();

        for(OutWarehouseListDTO list : outWarehouseList) {
            System.out.println("list : " + list);
        }

        int outWarehouseDataCnt = outWarehouseList.size();
        int outWarehouseCompletedCnt = 0;

        for(int i = 0; i < outWarehouseDataCnt; i++) {
            if("출고완료".equals(outWarehouseList.get(i).getOutWarehouseWorkingStatusName())) {
                outWarehouseCompletedCnt++;
            }
        }

//        System.out.println(outWarehouseDataCnt);
//        System.out.println(outWarehouseCompletedCnt);

        mv.addObject("outWarehouseList", outWarehouseList);
        mv.addObject("outWarehouseDataCnt", outWarehouseDataCnt);
        mv.addObject("outWarehouseCompletedCnt", outWarehouseCompletedCnt);
        mv.setViewName("/outWarehouse/list");

        return mv;
    }

    /**
     * @param mv
     * @param outWarehouseNo
     * @return
     */
    @GetMapping("/detail/{outWarehouseNo}")
    public ModelAndView selectOutWarehouseDetail(ModelAndView mv, @PathVariable int outWarehouseNo) {

//        System.out.println("출고 번호 : " + outWarehouseNo);

        int No = 0;
        int itemListCnt;
        List<OutWarehouseDetailListDTO> outWarehouseDetailList = outWarehouseService.findOutItemsList(outWarehouseNo);
        itemListCnt = outWarehouseDetailList.size();

        for(OutWarehouseDetailListDTO detailList : outWarehouseDetailList) {
            System.out.println("detailList = " + detailList);
        }

        mv.addObject("No", No);
        mv.addObject("itemListCnt", itemListCnt);
        mv.addObject("outWarehouseDetailList", outWarehouseDetailList);
        mv.setViewName("/outWarehouse/detail");
        return mv;
    }

    /**
     * @return
     */
    @GetMapping("/orderlist")
    @ResponseBody
    public List<OutWarehouseFranchiseOrderListDTO> selectOrderList() {

        List<OutWarehouseFranchiseOrderListDTO> outWarehouseOrderList = outWarehouseService.findAllOrderList();
//        outWarehouseOrderList.forEach(System.out::println);

        return outWarehouseOrderList;
    }

    /**
     * @param mv
     * @param data
     */
    @PostMapping(value = "/insertorderdata")
    @ResponseBody
    public void insertOutWarehouseData(ModelAndView mv, @RequestBody Map<String, Object> data) {

//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
//        System.out.println(data);
//        System.out.println(data.get("orderNums"));
//        System.out.println(data.get("representativeNums"));
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
        List<Integer> orderNums = (List<Integer>) data.get("orderNums");
        List<Integer> representativeNums = (List<Integer>) data.get("representativeNums");
        String sDate = (String) data.get("today");

        Date today = Date.valueOf(sDate);

//        System.out.println(orderNums);
//        System.out.println(representativeNums);
//        System.out.println(today);

        outWarehouseService.insertOrderData(orderNums, representativeNums, today);
    }


    /**
     * @param outWarehouseStatus
     */
    @PostMapping("/modify")
    @ResponseBody
    public void modifyOutWarehouseStatus(@RequestBody Map<String, Object> outWarehouseStatus) {

        System.out.println("this is outWarehouseStatus : " + outWarehouseStatus.get("outWarehouseStatus"));
        System.out.println(outWarehouseStatus.get("outWarehouseNo"));

        int outWarehouseNo = (int) outWarehouseStatus.get("outWarehouseNo");
        String status = (String) outWarehouseStatus.get("outWarehouseStatus");

        outWarehouseService.modifyStatus(status, outWarehouseNo);
    }

//    @GetMapping("/history")
//    public ModelAndView selectOutWarehouseHistory(ModelAndView mv) {
//
//    }
}
