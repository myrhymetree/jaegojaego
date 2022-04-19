package com.greedy.jaegojaego.outWarehouse.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/outwarehouse")
public class OutWarehouseController {

    @GetMapping("/list")
    public ModelAndView selectOutWarehouseList(ModelAndView mv) {

//        List<OutWarehouseListDTO> outWarehouseList =

        mv.setViewName("/outWarehouse/list");

        return mv;
    }

    @GetMapping("/detail")
    public ModelAndView selectOutWarehouseDetail(ModelAndView mv) {

        mv.setViewName("/outWarehouse/detail");

        return mv;
    }
}
