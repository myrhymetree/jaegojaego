package com.greedy.jaegojaego.warehouse.controller;

import com.greedy.jaegojaego.warehouse.dto.*;
import com.greedy.jaegojaego.warehouse.entity.*;
import com.greedy.jaegojaego.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    /* 입고, 입하 목록 조회용 */
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

    /* 입고, 입하 상세 조회용 */
    @GetMapping("/detail/{warehouseNo}")
    public ModelAndView findWarehouseByWarehouseNo(ModelAndView mv, @PathVariable int warehouseNo) {

        WarehouseDTO warehouseDetailNo = warehouseService.findWarehouseByWarehouseNo(warehouseNo);

        System.out.println("Controller warehouseDetailNo = " + warehouseDetailNo);

        /* 상세보기를 위한 발주 정보담은 DTO 확인용 */
        List<WarehouseInItemDTO> warehouseDetailList = new ArrayList<>();

        for(int i = 0; i < warehouseDetailNo.getOrderHistoryNo().getCompanyOrderItemList().size(); i++) {
            WarehouseInItemDTO warehouseInItem = new WarehouseInItemDTO();
            warehouseInItem.setWarehouseClientName(warehouseDetailNo.getClientNo().getClientName());                                       //거래처 이름 받아오기
            warehouseInItem.setWarehouseMaterialCategoryName(warehouseDetailNo.getOrderHistoryNo().getCompanyOrderItemList().get(i).getWarehouseItemInfo().getWarehouseMaterialCategory().getMaterialCategoryName());     //품목
            warehouseInItem.setWarehouseItemInfoItemSerialNo(warehouseDetailNo.getOrderHistoryNo().getCompanyOrderItemList().get(i).getWarehouseItemInfo().getItemInfoItemSerialNo());     //품번
            warehouseInItem.setWarehouseItemInfoName(warehouseDetailNo.getOrderHistoryNo().getCompanyOrderItemList().get(i).getWarehouseItemInfo().getItemInfoName());           //품명         //품명
            warehouseInItem.setWarehouseCompanyOrderItemAmount(warehouseDetailNo.getOrderHistoryNo().getCompanyOrderItemList().get(i).getCompanyOrderItemAmount());     //발주 수량
            warehouseInItem.setWarehouseOrderDate(warehouseDetailNo.getOrderHistoryNo().getCompanyOrderHistoryCreatedDate());               //발주 일시
            warehouseInItem.setWarehouseNo(warehouseDetailNo.getWarehouseNo());                   //입고 번호
            warehouseInItem.setWarehouseWorkingStatus(warehouseDetailNo.getWarehouseWorkingName());        //작업상태
            warehouseInItem.setWarehouseDate(warehouseDetailNo.getWarehouseWorkingDate());                 //작업 처리 일자
//            warehouseInItem.setWarehouseCheckAmount(warehouseDetailNo.getWarehouseStatusHistory().getWarehouseStatusAmount());             //입하 수량
//            warehouseInItem.setWarehouseInAmount(warehouseDetailNo.getWarehouseItemWarehouse().getItemWarehouseAmount());                  //입고 수량

            warehouseDetailList.add(warehouseInItem);
        }

        warehouseDetailList.forEach(System.out::println);

        /* view상단 박스에 갯수를 기입 */
        int itemCnt = 0;
        itemCnt = warehouseDetailList.size();
        /* No를 카운트 하주기 위한 것 */
        int No = 0;

        mv.addObject("No", No);
        mv.addObject("itemCnt", itemCnt);
        mv.addObject("warehouseDetailList", warehouseDetailList);
        mv.addObject("warehouseDetailNo", warehouseDetailNo);
        mv.setViewName("/warehouse/warehouseDetail");

        return mv;
    }

    /* 가공 대기 창고 목록 조회용 */
    @GetMapping("/raw")
    public ModelAndView warehouseRawList(ModelAndView mv) {

        List<WarehouseDTO> itemRawList = warehouseService.findAllRawList();

        System.out.println("controller itemRawList = " + itemRawList);

        for (WarehouseDTO list : itemRawList) {
            System.out.println("list : " + list);
        }

        mv.addObject("itemRawList", itemRawList);
        mv.setViewName("/warehouse/warehouseRawList");

        return mv;
    }

    /* 가공 완성 창고 목록 조회용 */
    @GetMapping("/manufacture")
    public ModelAndView warehouseManufactureList(ModelAndView mv) {

        List<ItemWarehouseDTO> itemManuList = warehouseService.findAllManuList();

        System.out.println("controller itemManuList = " + itemManuList);

        for (ItemWarehouseDTO list : itemManuList) {
            System.out.println("list : " + list);
        }

        int itemCnt = 0;
        itemCnt = itemManuList.size();

        mv.addObject("itemCnt", itemCnt);
        mv.addObject("itemManuList", itemManuList);
        mv.setViewName("/warehouse/warehouseManufactureList");

        return mv;
    }

    /* 가공 완성 창고 상세 조회용 */
    @GetMapping("/manufacture/{ManuNo}")
    public ModelAndView findWarehouseByManuNo(ModelAndView mv, @PathVariable int ManuNo) {

        mv.setViewName("/warehouse/warehouseManufactureDetail");

        return mv;
    }

    /* 불량 물품 창고 목록 조회용 */
    @GetMapping("/quality")
    public ModelAndView warehouseQualityList(ModelAndView mv) {

        mv.setViewName("/warehouse/warehouseQualityList");

        return mv;
    }
}
