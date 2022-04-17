package com.greedy.jaegojaego.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

    @GetMapping("/list")
    public ModelAndView warehouseList(ModelAndView mv) {

        mv.setViewName("/warehouse/warehouseList");

        return mv;
    }

    @GetMapping("/detail")
    public ModelAndView warehouseDetail(ModelAndView mv) {

        mv.setViewName("/warehouse/warehouseDetail");

        return mv;
    }

    @GetMapping("/raw")
    public ModelAndView warehouseRaw(ModelAndView mv) {

        mv.setViewName("/warehouse/warehouseRaw");

        return mv;
    }

    @GetMapping("/manufacture")
    public ModelAndView warehouseManufacture(ModelAndView mv) {

        mv.setViewName("/warehouse/warehouseManufacture");

        return mv;
    }

    @GetMapping("/quality")
    public ModelAndView warehouseQuality(ModelAndView mv) {

        mv.setViewName("/warehouse/warehouseQuality");

        return mv;
    }

}
