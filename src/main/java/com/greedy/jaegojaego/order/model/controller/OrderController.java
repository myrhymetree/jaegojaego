package com.greedy.jaegojaego.order.model.controller;

import com.greedy.jaegojaego.order.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/companyorderlist")
    public ModelAndView selectCompanyOrderList(ModelAndView mv) {

        mv.setViewName("/order/companyOrderList");

        return mv;
    }

    @GetMapping("/franchiseorderlist")
    public ModelAndView selectFranchiseOrderList(ModelAndView mv) {

        mv.setViewName("/order/franchiseOrderList");

        return mv;
    }

    @GetMapping("/companyorderregist")
    public ModelAndView companyOrderRegist(ModelAndView mv) {

        mv.setViewName("/order/companyOrderRegist");

        return mv;
    }

    @PostMapping("companyorderregist")
    public ModelAndView companyOrderApplicationList(ModelAndView mv, Locale locale) {

        mv.setViewName("/order/companyApplicationList");

        return mv;
    }

    @GetMapping("franchiseorderregist")
    public ModelAndView franchiseOrderRegist(ModelAndView mv) {

        mv.setViewName("/order/franchiseOrderRegist");

        return mv;
    }


}
