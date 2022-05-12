package com.greedy.jaegojaego.warehouse.controller;

import com.google.gson.Gson;
import com.greedy.jaegojaego.warehouse.dto.*;
import com.greedy.jaegojaego.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    /* 의존성 주입 */
    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    /** 입고 목록 조회용  */
    @GetMapping("/list")
    public ModelAndView selectWarehouseList(ModelAndView mv) {

        List<WarehouseDTO> warehouseList = warehouseService.findAllWarehouseList();

        int itemCnt;
        itemCnt = warehouseList.size();

        mv.addObject("itemCnt", itemCnt);
        mv.addObject("warehouseList", warehouseList);
        mv.setViewName("/warehouse/warehouseList");

        return mv;
    }

    /** 입고 상태 수정용 + 재고 변동사항 등록용 + 재고 수량 수정용 */
    @PostMapping(value = "/modify", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String modifyWarehouseStatus(HttpServletRequest request) {

        int modifyWarehouseNo = Integer.parseInt(request.getParameter("warehouseNo"));
        String modifyStatus = request.getParameter("warehouseStatus");
        int warehouseAmount = Integer.parseInt(request.getParameter("warehouseAmount"));

        warehouseService.modifyStatus(modifyStatus, modifyWarehouseNo, warehouseAmount);

        System.out.println("controller status = " + modifyWarehouseNo);

        Gson gson = new Gson();

        return gson.toJson("success");
    }

    /** 발주 승인 "완료" 목록 조회용 */
    @GetMapping("/complete")
    public ModelAndView selectWarehouseCompleteList(ModelAndView mv) {

        List<WarehouseCompanyOrderHistoryDTO> warehouseCompanyOrderList = warehouseService.selectCompanyOrderList();

        System.out.println("controller warehouseCompanyOrderList : " + warehouseCompanyOrderList);

        int itemCnt;
        itemCnt = warehouseCompanyOrderList.size();

        mv.addObject("itemCnt", itemCnt);
        mv.addObject("warehouseCompanyOrderList", warehouseCompanyOrderList);
        mv.setViewName("/warehouse/warehouseCompleteList");

        return mv;
    }

    /** 발주 승인 "완료" 상세 조회용 */
    @GetMapping("/complete/detail/{companyOrderHistoryNo}")
    public ModelAndView selectWarehouseCompleteDetail(ModelAndView mv, @PathVariable int companyOrderHistoryNo) {

        WarehouseCompanyOrderHistoryDTO orderHistory = warehouseService.findOrderHistoryByCompanyOrderHistoryNo(companyOrderHistoryNo);

        /* 상세보기를 위한 발주 정보담은 DTO 확인용 */
        List<WarehouseCompleteDetailDTO> completeDetail = new ArrayList<>(companyOrderHistoryNo);
//
        for(int i = 0; i < orderHistory.getOrderApplicationList().size(); i++) {

            for(int j = 0; j < orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().size(); j++) {

                WarehouseCompleteDetailDTO completeItem = new WarehouseCompleteDetailDTO();

                completeItem.setCompleteItemCategoryNo(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getOrderItemInfo().getMaterialCategory().getMaterialCategoryNo());
                completeItem.setCompleteItemCategoryName(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getOrderItemInfo().getMaterialCategory().getMaterialCategoryName());
                completeItem.setCompleteItemSerialNo(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getOrderItemInfo().getItemInfoItemSerialNo());
                completeItem.setCompleteItemName(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getOrderItemInfo().getItemInfoName());
                completeItem.setCompleteItemInfoNo(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getOrderItemInfo().getItemInfoNo());
                completeItem.setCompanyAmount(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getOrderApplicationItemAmount());

                completeItem.setClientName(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getClientContractInfo().getOrderClient().getClientName());
                completeItem.setClientNo(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getClientContractInfo().getOrderClient().getClientNo());

                completeItem.setOrderApplicationNo(orderHistory.getOrderApplicationList().get(i).getOrderApplicationNo());

                completeItem.setCompanyOrderHistoryCreatedDate(orderHistory.getCompanyOrderHistoryCreatedDate());

                completeItem.setCompanyOrderHistoryNo(orderHistory.getCompanyOrderHistoryNo());

                completeItem.setClientContractItemNo(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getClientContractItemNo());

                completeItem.setOrderApplicationItemYN(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getOrderApplicationItemYN());

                completeDetail.add(completeItem);
            }
        }

        /* view상단 박스에 갯수를 기입 */
        int itemCnt = 0;
        itemCnt = completeDetail.size();

        mv.addObject("itemCnt", itemCnt);
        mv.addObject("completeDetail", completeDetail);
        mv.addObject("orderHistory", orderHistory);
        mv.setViewName("/warehouse/warehouseCompleteDetail");

        return mv;
    }

    /** 발주 상세 목록에서 제품을 입고 목록에 등록용 */
    @PostMapping(value = "/complete/regist", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String registWarehouseCompleteItem(HttpServletRequest request) {

        int completeItemInfoNo = Integer.parseInt(request.getParameter("completeItemInfoNo"));
        int orderApplicationNo = Integer.parseInt(request.getParameter("orderApplicationNo"));
        int clientNo = Integer.parseInt(request.getParameter("clientNo"));
        int clientContractItemNo = Integer.parseInt(request.getParameter("clientContractItemNo"));
        int companyAmount = Integer.parseInt(request.getParameter("companyAmount"));

        warehouseService.registCompleteItem(completeItemInfoNo, orderApplicationNo, clientNo, clientContractItemNo, companyAmount);

        System.out.println("companyAmount = " + companyAmount);

        Gson gson = new Gson();

        return gson.toJson("success");
    }

    /** 재고 관리 목록 조회용 */
    @GetMapping("/item")
    public ModelAndView warehouseItemAmountList(ModelAndView mv) {

        List<WarehouseItemAmountDTO> warehouseItemAmount = warehouseService.findAllItemAmount();

        /* view상단 박스에 갯수를 기입 */
        int itemCnt = 0;
        itemCnt = warehouseItemAmount.size();

        mv.addObject("itemCnt", itemCnt);
        mv.addObject("warehouseItemAmount", warehouseItemAmount);
        mv.setViewName("/warehouse/warehouseItemList");

        return mv;
    }

    /** 재고 관리 상세 조회용 */
    @GetMapping("/change")
    public ModelAndView warehouseChangeDetail(ModelAndView mv) {

        List<WarehouseItemChangeHistoryDTO> changeHistory = warehouseService.findChangeHistoryByItemInfoNo();

        /* view상단 박스에 갯수를 기입 */
        int itemCnt = 0;
        itemCnt = changeHistory.size();

        mv.addObject("itemCnt", itemCnt);
        mv.addObject("changeHistory", changeHistory);
        mv.setViewName("/warehouse/warehouseChangeHistory");

        return mv;
    }

}
