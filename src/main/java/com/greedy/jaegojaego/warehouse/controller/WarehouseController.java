package com.greedy.jaegojaego.warehouse.controller;

import com.greedy.jaegojaego.warehouse.dto.WarehouseDTO;
import com.greedy.jaegojaego.warehouse.entity.Warehouse;
import com.greedy.jaegojaego.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
        
        for(WarehouseDTO list : warehouseList) {
            System.out.println("list : " + list);
        }

        mv.addObject("warehouseList", warehouseList);
        mv.setViewName("/warehouse/warehouseList");

        return mv;
    }

    /* 입고, 입하 상세보기용 */
    @GetMapping("/detail")
    public ModelAndView warehouseDetail(ModelAndView mv) {

        mv.setViewName("/warehouse/warehouseDetail");

        return mv;
    }

    /* 가공 대기 창고 목록 조회용 */
    @GetMapping("/raw")
    public ModelAndView warehouseRawList(ModelAndView mv) {

        mv.setViewName("/warehouse/warehouseRaw");

        return mv;
    }

    /* 가공 완성 창고 목록 조회용 */
    @GetMapping("/manufacture")
    public ModelAndView warehouseManufactureList(ModelAndView mv) {

        mv.setViewName("/warehouse/warehouseManufacture");

        return mv;
    }

    /* 불량 물품 창고 목록 조회용 */
    @GetMapping("/quality")
    public ModelAndView warehouseQualityList(ModelAndView mv) {

        mv.setViewName("/warehouse/warehouseQuality");

        return mv;
    }

}
