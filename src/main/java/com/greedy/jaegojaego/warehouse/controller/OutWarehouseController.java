package com.greedy.jaegojaego.warehouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/outwarehouse")
public class OutWarehouseController {

    @GetMapping("/list")
    public String outWarehouseListView() {

        return "/warehouse/outWarehouse/list";
    }
}
