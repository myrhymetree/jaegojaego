package com.greedy.jaegojaego.warehouse.controller;

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
    public ModelAndView warehouseList(ModelAndView mv) {

        List<WarehouseDTO> warehouseList = warehouseService.findAllWarehouseList();

        System.out.println("warehouseList = " + warehouseList);

        for (WarehouseDTO list : warehouseList) {
            System.out.println("list : " + list);
        }

        int itemCnt;
        itemCnt = warehouseList.size();

        mv.addObject("itemCnt", itemCnt);
        mv.addObject("warehouseList", warehouseList);
        mv.setViewName("/warehouse/warehouseList");

        return mv;
    }

    /** 입고 상태 수정용 + 재고 변동사항 등록용 */
    @PostMapping("/modify")
    public ModelAndView modifyWarehouseStatus(ModelAndView mv, @RequestBody Map<String, Object> warehouseStatus) {

        int warehouseNo = (int) warehouseStatus.get("warehouseNo");
        String status = (String) warehouseStatus.get("warehouseStatus");

        warehouseService.modifyStatus(status, warehouseNo);

        System.out.println("controller status = " + status);

        mv.setViewName("redirect:/warehouse/list");

        return mv;
    }

    /** 발주 승인 "완료" 목록 조회용 */
    @GetMapping("/complete")
    public ModelAndView warehouseCompleteList(ModelAndView mv) {

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
    public ModelAndView warehouseCompleteDetail(ModelAndView mv, @PathVariable int companyOrderHistoryNo) {

        WarehouseCompanyOrderHistoryDTO orderHistory = warehouseService.findOrderHistoryByCompanyOrderHistoryNo(companyOrderHistoryNo);
//        WarehouseOrderApplicationDTO orderHistory = warehouseService.findOrderHistoryByCompanyOrderHistoryNo(companyOrderHistoryNo);

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

                completeDetail.add(completeItem);
            }
        }

        System.out.println("===================================================================================================================");
        completeDetail.forEach(System.out::println);
        System.out.println("===================================================================================================================");


        System.out.println("controller orderHistory = " + orderHistory);

        /* view상단 박스에 갯수를 기입 */
        int itemCnt = 0;
        itemCnt = completeDetail.size();
        /* No를 카운트 하주기 위한 것 */
        int No = 0;

        mv.addObject("No", No);
        mv.addObject("itemCnt", itemCnt);
        mv.addObject("completeDetail", completeDetail);
        mv.addObject("orderHistory", orderHistory);
        mv.setViewName("/warehouse/warehouseCompleteDetail");

        return mv;
    }

    /** 발주 상세 목록에서 제품을 입고 목록에 등록용 */
    @GetMapping("/complete/regist")
    public ModelAndView warehouseRegist(ModelAndView mv, HttpServletRequest request) {
//      html쪽에서 정보를 받아오기..
        int orderNo = Integer.parseInt(request.getParameter("warehouseOrderHistoryNo"));
        int completeItemInfoNo = Integer.parseInt(request.getParameter("completeItemNo"));
        int orderApplicationNo = Integer.parseInt(request.getParameter("orderApplicationNo"));
        int clientNo = Integer.parseInt(request.getParameter("clientNo"));


//        WarehouseDTO completeItem = new WarehouseDTO();

//        completeItem.setItemInfoNo();
//        completeItem.setClientNo(clientNo);
//        completeItem.setWarehouseAmount();

        warehouseService.registCompleteItem(orderNo, completeItemInfoNo, orderApplicationNo, clientNo);

        mv.setViewName("redirect:/warehouse/list");

        return mv;
    }

    /** 재고 관리 목록 조회용 */
    @GetMapping("/item")
    public ModelAndView warehouseItemAmountList(ModelAndView mv) {

        List<WarehouseItemAmountDTO> warehouseItemAmount = warehouseService.findAllItemAmount();

        System.out.println("controller warehouseItemAmount = " + warehouseItemAmount);

        /* view상단 박스에 갯수를 기입 */
        int itemCnt = 0;
        itemCnt = warehouseItemAmount.size();
        /* No를 카운트 하주기 위한 것 */
        int No = 0;

        mv.addObject("No", No);
        mv.addObject("itemCnt", itemCnt);
        mv.addObject("warehouseItemAmount", warehouseItemAmount);
        mv.setViewName("/warehouse/warehouseItemList");

        return mv;
    }

    /** 재고 관리 상세 조회용 */
    @GetMapping("/change")
    public ModelAndView warehouseChangeDetail(ModelAndView mv) {

        List<WarehouseItemChangeHistoryDTO> changeHistory = warehouseService.findChangeHistoryByItemInfoNo();

        System.out.println("controller changeHistory = " + changeHistory);

        /* view상단 박스에 갯수를 기입 */
        int itemCnt = 0;
        itemCnt = changeHistory.size();
        /* No를 카운트 하주기 위한 것 */
        int No = 0;

        mv.addObject("No", No);
        mv.addObject("itemCnt", itemCnt);
        mv.addObject("changeHistory", changeHistory);
        mv.setViewName("/warehouse/warehouseChangeHistory");

        return mv;
    }









//    /** 발주 승인 "완료" 목록 불러오기 */
//    @GetMapping("/complete")
//    public ModelAndView warehouseCompleteList(ModelAndView mv, HttpServletRequest request) {
//
//        List<WarehouseCompanyOrderHistoryDTO> warehouseCompanyOrderList = warehouseService.selectCompanyOrderList();
//
//        System.out.println("controller warehouseCompanyOrderList : " + warehouseCompanyOrderList);
//
//        int itemCnt;
//        itemCnt = warehouseCompanyOrderList.size();
//
//        mv.addObject("itemCnt", itemCnt);
//        mv.addObject("warehouseCompanyOrderList", warehouseCompanyOrderList);
//        mv.setViewName("/warehouse/warehouseCompleteList");
//
//        return mv;
//    }
//
//    /** 발주 목록에서 입고,입하 처리 목록 추가용 */
//    @GetMapping("/regist")
//    public ModelAndView warehouseRegist(ModelAndView mv, HttpServletRequest request) {
//
//        int orderNo = Integer.parseInt(request.getParameter("warehouseOrderHistoryNo"));
//
//        warehouseService.registNewOrder(orderNo);
//
//        mv.setViewName("/warehouse/warehouseList");
//
//        return mv;
//    }
//
//    /** 가맹점 이슈 목록 조회 */
//    @GetMapping("/issue")
//    public ModelAndView warehouseIssueList(ModelAndView mv) {
//
//        mv.setViewName("/warehouse/warehouseIssueList");
//
//        return mv;
//    }
//
//    /** 입고, 입하 목록 조회용 */
//    @GetMapping("/list")
//    public ModelAndView warehouseList(ModelAndView mv) {
//
//        List<WarehouseDTO> warehouseList = warehouseService.findAllWarehouseList();
//
//        System.out.println("warehouseList = " + warehouseList);
//
//        for (WarehouseDTO list : warehouseList) {
//            System.out.println("list : " + list);
//        }
//
//        int itemCnt;
//        itemCnt = warehouseList.size();
//
//        mv.addObject("itemCnt", itemCnt);
//        mv.addObject("warehouseList", warehouseList);
//        mv.setViewName("/warehouse/warehouseList");
//
//        return mv;
//    }
//
//    /** 입고, 입하 상세 조회용 */
//    @GetMapping("/detail/{warehouseNo}")
//    public ModelAndView findWarehouseByWarehouseNo(ModelAndView mv, @PathVariable int warehouseNo) {
//
//        WarehouseDTO warehouseDetailNo = warehouseService.findWarehouseByWarehouseNo(warehouseNo);
//
//        System.out.println("Controller warehouseDetailNo = " + warehouseDetailNo);
//
//        /* 상세보기를 위한 발주 정보담은 DTO 확인용 */
//        List<WarehouseInItemDTO> warehouseDetailList = new ArrayList<>();
//
//        for (int i = 0; i < warehouseDetailNo.getOrderHistoryNo().getCompanyOrderItemList().size(); i++) {
//
//            WarehouseInItemDTO warehouseInItem = new WarehouseInItemDTO();
//            warehouseInItem.setWarehouseClientName(warehouseDetailNo.getOrderHistoryNo().getOrderApplicationList().get(i).getOrderClient().getClientName());                                       //거래처 이름 받아오기
//            warehouseInItem.setWarehouseMaterialCategoryName(warehouseDetailNo.getOrderHistoryNo().getCompanyOrderItemList().get(i).getWarehouseItemInfo().getWarehouseMaterialCategory().getMaterialCategoryName());     //품목
//            warehouseInItem.setWarehouseItemInfoItemSerialNo(warehouseDetailNo.getOrderHistoryNo().getCompanyOrderItemList().get(i).getWarehouseItemInfo().getItemInfoItemSerialNo());     //품번
//            warehouseInItem.setWarehouseItemInfoName(warehouseDetailNo.getOrderHistoryNo().getCompanyOrderItemList().get(i).getWarehouseItemInfo().getItemInfoName());           //품명         //품명
//            warehouseInItem.setWarehouseCompanyOrderItemAmount(warehouseDetailNo.getOrderHistoryNo().getCompanyOrderItemList().get(i).getCompanyOrderItemAmount());     //발주 수량
//            warehouseInItem.setWarehouseOrderDate(warehouseDetailNo.getOrderHistoryNo().getCompanyOrderHistoryCreatedDate());               //발주 일시
//            warehouseInItem.setWarehouseNo(warehouseDetailNo.getWarehouseNo());                   //입고 번호
//            warehouseInItem.setWarehouseWorkingStatus(warehouseDetailNo.getWarehouseWorkingName());        //작업상태
//            warehouseInItem.setWarehouseDate(warehouseDetailNo.getWarehouseWorkingDate());                 //작업 처리 일자
////            warehouseInItem.setWarehouseCheckAmount(warehouseDetailNo.getWarehouseStatusHistory().getWarehouseStatusAmount());             //입하 수량
////            warehouseInItem.setWarehouseInAmount(warehouseDetailNo.getWarehouseItemWarehouse().getItemWarehouseAmount());                  //입고 수량
//
////            warehouseInItem.setWarehouseMaterialCategoryName(warehouseDetailNo.getOrderHistoryNo().getCompanyOrderItemList().get(i).getCompanyOrderItemPK().getOrderItemInfo().getOrderMaterialCategory().getMaterialCategoryName());     //품목
//
//
//            warehouseDetailList.add(warehouseInItem);
//        }
//
//        warehouseDetailList.forEach(System.out::println);
//
//        /* view상단 박스에 갯수를 기입 */
//        int itemCnt = 0;
//        itemCnt = warehouseDetailList.size();
//        /* No를 카운트 하주기 위한 것 */
//        int No = 0;
//
//        mv.addObject("No", No);
//        mv.addObject("itemCnt", itemCnt);
//        mv.addObject("warehouseDetailList", warehouseDetailList);
//        mv.addObject("warehouseDetailNo", warehouseDetailNo);
//        mv.setViewName("/warehouse/warehouseDetail");
//
//        return mv;
//    }
//
//    /** 입고,입하 상태 수정용 */
//    @PostMapping("/modify")
//    public ModelAndView modifyWarehouseStatus(ModelAndView mv, @RequestBody Map<String, Object> warehouseStatus) {
//
//        int warehouseNo = (int) warehouseStatus.get("warehouseNo");
//        String status = (String) warehouseStatus.get("warehouseStatus");
//
//        warehouseService.modifyStatus(status, warehouseNo);
//
//        System.out.println("controller status = " + status);
//
//        mv.setViewName("redirect:/warehouse/detail/" + warehouseNo);
//
//        return mv;
//    }

}
