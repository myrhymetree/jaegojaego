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

/**
 * <pre>
 * Class : WarehouseController
 * Comment : 입고 관련 Method를 모아놓은 Controller입니다.
 * History
 * 2022/05/04 (석원탁) WarehouseController 기본 설정 작성
 * 2022/05/04 (석원탁) 입고 목록 조회
 * 2022/05/05 (석원탁) 본사 발주 "완료" 상태 목록 조회
 * 2022/05/08 (석원탁) 본사 발주 "완료" 물품별 상세 조회
 * 2022/05/06 (석원탁) 입고 완료 처리 시 입고 table 정보 수정
 * 2022/05/07 (석원탁) 재고 목록 조회
 * 2022/05/05 (석원탁) 본사 발주 "완료" 정보를 입고 목록에 등록
 * 2022/05/08 (석원탁) 입고 완료 처리 시 입고 table 정보 수정 + 이력 table 등록
 * 2022/05/09 (석원탁) 재고 변동 내역 정보 조회
 * 2022/05/10 (석원탁) 재고 변동 내역 정보 등록
 * 2022/05/11 (석원탁) 입고 완료 처리 시 입고 table 정보 수정 + 이력 table 등록 + 재고 수량 수정
 * </pre>
 * @version 11
 * @author 석원탁
 */
@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    /* 의존성 주입 */
    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    /**
     * selectWarehouseList : 입고 목록 조회용
     * @ param mv : 입고 물품 정보와 view page url을 담은 변수
     * @ return : 입고 물품 정보와 view page
     */
    @GetMapping("/list")
    public ModelAndView selectWarehouseList(ModelAndView mv) {

        List<WarehouseDTO> warehouseList = warehouseService.findAllWarehouseList();

        /* view상단 박스에 갯수를 기입하기 위함 */
        int itemCnt;
        itemCnt = warehouseList.size();

        mv.addObject("itemCnt", itemCnt);
        mv.addObject("warehouseList", warehouseList);
        mv.setViewName("/warehouse/warehouseList");

        return mv;
    }

    /**
     * modifyWarehouseStatus : 입고 상태 수정용 + 재고 변동사항 등록용 + 재고 수량 수정용
     * @ param request : view에서 요청한 정보를 사용하기위해 담아둔 변수
     * @ return : 요청을 처리 하여 view <script> 내 success 이동
     */
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

    /**
     * selectWarehouseCompleteList : 발주 승인 "완료" 목록 조회용
     * @ param mv : 본사 발주 정보와 view page url을 담은 변수
     * @ return : 본사 발주 정보와 view page
     */
    @GetMapping("/complete")
    public ModelAndView selectWarehouseCompleteList(ModelAndView mv) {

        List<WarehouseCompanyOrderHistoryDTO> warehouseCompanyOrderList = warehouseService.findAllCompanyOrderList();

        System.out.println("controller warehouseCompanyOrderList : " + warehouseCompanyOrderList);

        /* view상단 박스에 갯수를 기입하기 위함 */
        int itemCnt;
        itemCnt = warehouseCompanyOrderList.size();

        mv.addObject("itemCnt", itemCnt);
        mv.addObject("warehouseCompanyOrderList", warehouseCompanyOrderList);
        mv.setViewName("/warehouse/warehouseCompleteList");

        return mv;
    }

    /**
     * selectWarehouseCompleteDetail : 발주 승인 "완료" 상세 조회용
     * @ param mv : 본사 발주 상세 정보와 추가로 필요한 상세 정보, view page url을 담은 변수
     * @ param companyOrderHistoryNo : view에서 요청한 정보를 사용하기위해 담아둔 변수
     * @ return : 본사 발주 상세 정보와 추가로 필요한 상세 정보, view page
     */
    @GetMapping("/complete/detail/{companyOrderHistoryNo}")
    public ModelAndView selectWarehouseCompleteDetail(ModelAndView mv, @PathVariable int companyOrderHistoryNo) {

        WarehouseCompanyOrderHistoryDTO orderHistory = warehouseService.findOrderHistoryByCompanyOrderHistoryNo(companyOrderHistoryNo);

        /* 상세보기를 위한 발주 정보담은 DTO 확인용 */
        List<WarehouseCompleteDetailDTO> completeDetail = new ArrayList<>(companyOrderHistoryNo);

        /*  [하나의 발주에 여러가지 제품. 하나의 제품 안에 여러 거래처]이기에 2중 for문을 사용 */
        for(int i = 0; i < orderHistory.getOrderApplicationList().size(); i++) {

            for(int j = 0; j < orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().size(); j++) {

                /* 상세 정보 시 원하는 정보를 간편하게 불러오기 위해 set을 사용하여 경로를 통해 불러오기 위함 */
                WarehouseCompleteDetailDTO completeItem = new WarehouseCompleteDetailDTO();

                /* item관련 정보 set */
                completeItem.setCompleteItemCategoryNo(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getOrderItemInfo().getMaterialCategory().getMaterialCategoryNo());
                completeItem.setCompleteItemCategoryName(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getOrderItemInfo().getMaterialCategory().getMaterialCategoryName());
                completeItem.setCompleteItemSerialNo(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getOrderItemInfo().getItemInfoItemSerialNo());
                completeItem.setCompleteItemName(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getOrderItemInfo().getItemInfoName());
                completeItem.setCompleteItemInfoNo(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getOrderItemInfo().getItemInfoNo());
                completeItem.setCompanyAmount(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getOrderApplicationItemAmount());

                /* 거래처 관련 정보 set */
                completeItem.setClientName(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getClientContractInfo().getOrderClient().getClientName());
                completeItem.setClientNo(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getClientContractInfo().getOrderClient().getClientNo());
                completeItem.setClientContractItemNo(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getClientContractItemNo());

                /* 본사 발주 관련 정보 set */
                completeItem.setOrderApplicationNo(orderHistory.getOrderApplicationList().get(i).getOrderApplicationNo());
                completeItem.setCompanyOrderHistoryCreatedDate(orderHistory.getCompanyOrderHistoryCreatedDate());
                completeItem.setCompanyOrderHistoryNo(orderHistory.getCompanyOrderHistoryNo());

                /* 입고 목록에 추가 시 'Y'로 변하며 처리가 되었음을 구분하기 위해 추가로 생성! */
                completeItem.setOrderApplicationItemYN(orderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getOrderApplicationItemYN());

                completeDetail.add(completeItem);
            }
        }

        /* view상단 박스에 갯수를 기입하기 위함 */
        int itemCnt = 0;
        itemCnt = completeDetail.size();

        mv.addObject("itemCnt", itemCnt);
        mv.addObject("completeDetail", completeDetail);
        mv.addObject("orderHistory", orderHistory);
        mv.setViewName("/warehouse/warehouseCompleteDetail");

        return mv;
    }

    /**
     * registWarehouseCompleteItem : 발주 상세 목록에서 제품을 입고 목록에 등록용
     * @ param request : view에서 요청한 정보를 사용하기위해 담아둔 변수
     * @ return : 요청을 처리 하여 view <script> 내 success 이동
     */
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

    /**
     * registWarehouseCompleteItem : 재고 관리 목록 조회용
     * @ param mv : 재고 수량 정보와 view page url을 담은 변수
     * @ return : 재고 수량 정보와 view page
     */
    @GetMapping("/item")
    public ModelAndView selectWarehouseItemAmountList(ModelAndView mv) {

        List<WarehouseItemAmountDTO> warehouseItemAmount = warehouseService.findAllItemAmount();

        /* view상단 박스에 갯수를 기입하기 위함 */
        int itemCnt = 0;
        itemCnt = warehouseItemAmount.size();

        mv.addObject("itemCnt", itemCnt);
        mv.addObject("warehouseItemAmount", warehouseItemAmount);
        mv.setViewName("/warehouse/warehouseItemList");

        return mv;
    }

    /**
     * registWarehouseCompleteItem : 재고 변동 내역 조회용
     * @ param mv : 재고 변동 내역과 view page url을 담은 변수
     * @ return : 재고 변동 내역과 view page
     */
    @GetMapping("/change")
    public ModelAndView selectWarehouseChangeDetail(ModelAndView mv) {

        List<WarehouseItemChangeHistoryDTO> changeHistory = warehouseService.findChangeHistoryByItemInfoNo();

        /* view상단 박스에 갯수를 기입하기 위함 */
        int itemCnt = 0;
        itemCnt = changeHistory.size();

        mv.addObject("itemCnt", itemCnt);
        mv.addObject("changeHistory", changeHistory);
        mv.setViewName("/warehouse/warehouseChangeHistory");

        return mv;
    }
}
