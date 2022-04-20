package com.greedy.jaegojaego.order.order.model.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.order.order.model.dto.CompanyOrderHistoryDTO;
import com.greedy.jaegojaego.order.order.model.dto.CompanyOrderItemDTO;
import com.greedy.jaegojaego.order.order.model.dto.OrderApplicationDTO;
import com.greedy.jaegojaego.order.order.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.*;

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

        List<CompanyOrderHistoryDTO> companyOrderList = orderService.selectCompanyOrderList();

        List<String> orderItemName = new ArrayList<>();
        List<OrderApplicationDTO> orderApplicationList = new ArrayList<>();

        for(int i = 0; i < companyOrderList.size(); i++) {

            String itemName = "";

            for(int j = 0; j < companyOrderList.get(i).getOrderApplicationList().size(); j++) {

                orderApplicationList.add(j, companyOrderList.get(i).getOrderApplicationList().get(j));

            }

            if(companyOrderList.get(i).getCompanyOrderItemList().size() >= 2) {
                itemName += companyOrderList.get(i).getCompanyOrderItemList().get(0).getItemInfo().getItemInfoName() + "외 " + (companyOrderList.get(i).getCompanyOrderItemList().size() - 1) + "개";
            } else if(companyOrderList.get(i).getCompanyOrderItemList().size() == 1) {
                itemName += companyOrderList.get(i).getCompanyOrderItemList().get(0).getItemInfo().getItemInfoName();
            }
            orderItemName.add(i, itemName);

        }

        List<Integer> totalPrice = new ArrayList<>();
        int price = 0;
        int companyOrderHistoryNo = 0;
        int count = 0;

        for(int i = orderApplicationList.size() - 1; i >= 0; i--) {

            if(i == orderApplicationList.size() - 1) {
                companyOrderHistoryNo = orderApplicationList.get(i).getCompanyOrderHistory().getCompanyOrderHistoryNo();
            }

            for(int j = 0; j < orderApplicationList.get(i).getOrderApplicationItemList().size(); j++) {

                if(companyOrderHistoryNo == orderApplicationList.get(i).getCompanyOrderHistory().getCompanyOrderHistoryNo()) {

                    System.out.println("companyOrderHistoryNo = " + companyOrderHistoryNo);

                    price += orderApplicationList.get(i).getOrderApplicationItemList().get(j).getOrderApplicationItemAmount()
                            * orderApplicationList.get(i).getOrderApplicationItemList().get(j).getClientContractItem().getClientContractItemSupplyPrice();

                    if(i == 0) {
                        totalPrice.add(count, price);
                        break;
                    }

                } else {
                    companyOrderHistoryNo = orderApplicationList.get(i).getCompanyOrderHistory().getCompanyOrderHistoryNo();
                    totalPrice.add(count, price);
                    count++;
                    price = 0;
                    price += orderApplicationList.get(i).getOrderApplicationItemList().get(j).getOrderApplicationItemAmount()
                            * orderApplicationList.get(i).getOrderApplicationItemList().get(j).getClientContractItem().getClientContractItemSupplyPrice();
                }

            }

        }

        mv.addObject("itemName", orderItemName);
        mv.addObject("totalPrice", totalPrice);
        mv.addObject("companyOrderList", companyOrderList);
        mv.setViewName("/order/companyOrderList");

        return mv;
    }

    @GetMapping(value = "/selectcompanyorderdetail", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectCompanyOrderDetail(ModelAndView mv, HttpServletRequest request) throws JsonProcessingException {

        int companyOrderHistoryNo = Integer.parseInt(request.getParameter("companyOrderHistoryNo"));

        CompanyOrderHistoryDTO companyOrderHistory = orderService.selectCompanyOrderHistoryDetail(companyOrderHistoryNo);

        Map<Integer, Integer> equalItem = new HashMap<>();

        for(int i = 0; i < companyOrderHistory.getCompanyOrderItemList().size(); i++) {
            equalItem.put(companyOrderHistory.getCompanyOrderItemList().get(i).getItemInfo().getItemInfoNo(), 0);
        }

        int price = 0;

        for(int i = 0; i < companyOrderHistory.getOrderApplicationList().size(); i++) {

            for(int j = 0; j < companyOrderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().size(); j++) {

                int itemNo = companyOrderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getOrderItemInfo().getItemInfoNo();
                price = equalItem.get(itemNo);

                price += companyOrderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getOrderApplicationItemAmount()
                        * companyOrderHistory.getOrderApplicationList().get(i).getOrderApplicationItemList().get(j).getClientContractItem().getClientContractItemSupplyPrice();

                equalItem.put(itemNo, price);

            }

        }

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

//        ObjectMapper objectMapper = new ObjectMapper();
//
//        mv.addObject("equalItem", objectMapper.writeValueAsString(equalItem));
//        mv.addObject("itemInfo", objectMapper.writeValueAsString(companyOrderHistory.getCompanyOrderItemList()));
//        mv.setViewName("jsonView");

        return gson.toJson(equalItem);
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
