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

/**
 * <pre>
 * Class : OutWarehouseControlller
 * Comment : 출고 관련 데이터를 view에서 받아서 service로 보내거나 view로 반환하는 메소드를 모아둔 Controller입니다.
 * History
 * 2022/04/21 (이태준) 출고 화면 이동경로 설정
 * 2022/04/21 (이태준) 출고 목록 조회 기능, 출고 상세조회 기능
 * 2022/04/25 (이태준) 출고 상세정보 조회 및 정보 수정 기능
 * 2022/04/27 (이태준) 테이블 수정으로 코드 재작성
 * 2022/04/30 (이태준) 출고 목록 데이터 조회 기능
 * 2022/05/01 (이태준) 출고 발주 목록 조회 기능
 * 2022/05/03 (이태준) 출고 발주 목록 조회 수정
 * 2022/05/10 (이태준) 출고 발주 목록 조회 기능 및 출고 데이터 삽입
 * 2022/05/11 (이태준) 출고 데이터 삽입 기능, 가맹점 발주상태 수정 기능
 * 2022/05/12 (이태준) 출고 목록 조회 기능, 출고 데이터 수정 기능, 재고 데이터 수정 기능
 * </pre>
 * @version 1.1
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
     * @param mv : 컨트롤러에서 처리한 결과와 전달할 값을 응답할 화면에 전달하기 위한 객체
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

        mv.addObject("outWarehouseList", outWarehouseList);
        mv.addObject("outWarehouseDataCnt", outWarehouseDataCnt);
        mv.addObject("outWarehouseCompletedCnt", outWarehouseCompletedCnt);
        mv.setViewName("/outWarehouse/list");

        return mv;
    }

    /**
     * selectOutWarehouseDetail : 선택한 출고 처리할 데이터 목록의 상세정보 조회
     * @param mv : 컨트롤러에서 처리한 결과와 전달할 값을 응답할 화면에 전달하기 위한 객체
     * @param outWarehouseNo : 선택한 데이터의 출고번호
     * @return : 선택한 출고 상세정보, 화면 경로
     */
    @GetMapping("/detail/{outWarehouseNo}")
    public ModelAndView selectOutWarehouseDetail(ModelAndView mv, @PathVariable int outWarehouseNo) {

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
     * selectOrderList : 승인 완료된 가맹점 발주 목록 조회
     * @return : 승인 완료된 가맹점 발주 목록
     */
    @GetMapping("/orderlist")
    @ResponseBody
    public List<OutWarehouseFranchiseOrderListDTO> selectOrderList() {

        List<OutWarehouseFranchiseOrderListDTO> outWarehouseOrderList = outWarehouseService.findAllOrderList();

        return outWarehouseOrderList;
    }

    /**
     * insertOutWarehouseData : 출고 테이블에 데이터 삽입
     * @param mv : 컨트롤러에서 처리한 결과와 전달할 값을 응답할 화면에 전달하기 위한 객체
     * @param data : 화면에서 비동기 처리로 넘겨주는 데이터를 받기 위한 Map형태의 변수
     */
    @PostMapping(value = "/insertorderdata")
    @ResponseBody
    public void insertOutWarehouseData(ModelAndView mv, @RequestBody Map<String, Object> data) {

        List<Integer> orderNums = (List<Integer>) data.get("orderNums");
        List<Integer> representativeNums = (List<Integer>) data.get("representativeNums");
        String sDate = (String) data.get("today");

        Date today = Date.valueOf(sDate);

        outWarehouseService.insertOrderData(orderNums, representativeNums, today);
    }


    /**
     * modifyOutWarehouseStatus : 출고 처리상태 정보 수정
     * @param outWarehouseStatus : 화면에서 비동기 처리로 넘긴 처리상태 데이터
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
