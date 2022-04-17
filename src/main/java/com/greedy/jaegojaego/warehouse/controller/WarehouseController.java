package com.greedy.jaegojaego.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    @GetMapping("/warehouseList")
    public ModelAndView warehouseList(ModelAndView mv) {

        mv.setViewName("/warehouse/warehouseList");

        return mv;
    }

    @GetMapping("/warehouseDetail")
    public ModelAndView warehouseDetail(ModelAndView mv) {

        mv.setViewName("/warehouse/warehouseDetail");

        return mv;
    }

}
