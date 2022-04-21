package com.greedy.jaegojaego.outWarehouse.model.controller;

import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseListDTO;
import com.greedy.jaegojaego.outWarehouse.model.service.OutWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/outwarehouse")
public class OutWarehouseController {

    private final OutWarehouseService outWarehouseService;

    @Autowired
    public OutWarehouseController(OutWarehouseService outWarehouseService) {
        this.outWarehouseService = outWarehouseService;
    }

    @GetMapping("/list")
    public ModelAndView findOutWarehouseList(ModelAndView mv) {

        List<OutWarehouseListDTO> outWarehouseList = outWarehouseService.findOutWarehouseList();

        for(OutWarehouseListDTO list : outWarehouseList) {
            System.out.println("list : " + list);
        }

        mv.addObject("outWarehouseList", outWarehouseList);
        mv.setViewName("/outWarehouse/list");

        return mv;
    }

    @GetMapping("/detail/{outWarehouseNo}")
    public ModelAndView selectOutWarehouseDetail(ModelAndView mv, @PathVariable int outWarehouseNo) {

        mv.setViewName("/outWarehouse/detail");

        return mv;
    }
}
