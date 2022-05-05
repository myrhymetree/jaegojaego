package com.greedy.jaegojaego.outWarehouse.model.controller;

import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseFranchiseOrderListDTO;
import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseListDTO;
import com.greedy.jaegojaego.outWarehouse.model.service.OutWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

//        for(OutWarehouseListDTO list : outWarehouseList) {
//            System.out.println("list : " + list);
//        }

        mv.addObject("outWarehouseList", outWarehouseList);
        mv.setViewName("/outWarehouse/list");

        return mv;
    }

    /**
     * @param mv
     * @param outWarehouseNo
     * @return
     */
//    @GetMapping("/detail/{outWarehouseNo}")
//    public ModelAndView selectOutWarehouseDetail(ModelAndView mv, @PathVariable int outWarehouseNo) {
//
//        System.out.println("출고 번호 : " + outWarehouseNo);
//
//        int No = 0;
//        int itemListCnt;
//        List<OutWarehouseDetailListDTO> outWarehouseDetailList = outWarehouseService.findOutItemsList(outWarehouseNo);
//        itemListCnt = outWarehouseDetailList.size();
//
//        for(OutWarehouseDetailListDTO detailList : outWarehouseDetailList) {
//            System.out.println("detailList = " + detailList);
//        }
//
//        mv.addObject("No", No);
//        mv.addObject("itemListCnt", itemListCnt);
//        mv.addObject("outWarehouseDetailList", outWarehouseDetailList);
//        mv.setViewName("/outWarehouse/detail");
//        return mv;
//    }

//    @GetMapping("/orderlist")
//    public ModelAndView selectOrderList(ModelAndView mv) {
//
//        // 모든 발주 list 가져와서 담을 변수 만들고 mv에 담아서 화면에 보내준다.
//
//        mv.setViewName("redirect:/outWarehouse/list");
//
//        return mv;
//    }

    @GetMapping("/getorderlist")
    public ModelAndView getOrderList(ModelAndView mv) {

        List<OutWarehouseFranchiseOrderListDTO> outWarehouseOrderList = outWarehouseService.findAllOrderList();

        mv.addObject("outWarehouseOrderList", outWarehouseOrderList);
        mv.setViewName("/outWarehouse/list");

        return mv;
    }

    /**
     * @param mv
     * @param outWarehouseStatus
     * @return
     */
//    @PostMapping("/modify")
//    public ModelAndView modifyOutWarehouseStatus(ModelAndView mv, @RequestBody Map<String, Object> outWarehouseStatus) {
//
////        System.out.println("this is outWarehouseStatus : " + outWarehouseStatus.get("outWarehouseStatus"));
////        System.out.println(outWarehouseStatus.get("outWarehouseNo"));
//
//        int outWarehouseNo = (int) outWarehouseStatus.get("outWarehouseNo");
//        String status = (String) outWarehouseStatus.get("outWarehouseStatus");
//
//        outWarehouseService.modifyStatus(status, outWarehouseNo);
//
//        mv.setViewName("redirect:/outwarehouse/detail/" + outWarehouseNo);
//
//        return mv;
//    }

//    @GetMapping("/history")
//    public ModelAndView selectOutWarehouseHistory(ModelAndView mv) {
//
//    }
}
