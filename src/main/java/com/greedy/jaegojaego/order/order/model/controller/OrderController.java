package com.greedy.jaegojaego.order.order.model.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.authentification.model.service.AuthenticationService;
import com.greedy.jaegojaego.order.client.model.dto.OrderClientContractItemDTO;
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;
import com.greedy.jaegojaego.order.order.model.dto.*;
import com.greedy.jaegojaego.order.order.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final AuthenticationService authenticationService;
    private final MessageSource messageSource;

    @Autowired
    public OrderController(OrderService orderService, AuthenticationService authenticationService, MessageSource messageSource) {
        this.orderService = orderService;
        this.authenticationService = authenticationService;
        this.messageSource= messageSource;
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
    public String selectCompanyOrderDetail(HttpServletRequest request) {

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

        List<CompanyOrderDetailDTO> companyOrderDetailList = new ArrayList<>();

        for(int i = 0; i < companyOrderHistory.getCompanyOrderItemList().size(); i++) {

            CompanyOrderDetailDTO companyOrderDetail = new CompanyOrderDetailDTO();

            for(int key : equalItem.keySet()){

                if(companyOrderHistory.getCompanyOrderItemList().get(i).getItemInfo().getItemInfoNo() == key) {
                    companyOrderDetail.setItemName(companyOrderHistory.getCompanyOrderItemList().get(i).getItemInfo().getItemInfoName());
                    companyOrderDetail.setItemPrice(equalItem.get(key));
                    companyOrderDetail.setItemAmount(companyOrderHistory.getCompanyOrderItemList().get(i).getCompanyOrderItemAmount());
                }

            }

            companyOrderDetailList.add(companyOrderDetail);

        }

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(companyOrderDetailList);
    }

    @GetMapping(value ="selectonecompanyorderapplicationlist", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectOneCompanyOrderApplicationList(HttpServletRequest request) {

        int companyOrderHistoryNo = Integer.parseInt(request.getParameter("companyOrderHistoryNo"));

        CompanyOrderHistoryDTO companyOrderHistory = orderService.selectCompanyOrderHistoryDetail(companyOrderHistoryNo);

        List<CompanyOrderDetailDTO> companyOrderDetailList = new ArrayList<>();

        for(int i = 0; i < companyOrderHistory.getOrderApplicationList().size(); i++) {

            CompanyOrderDetailDTO companyOrderDetail = new CompanyOrderDetailDTO();
            companyOrderDetail.setCompanyOrderHistoryNo(companyOrderHistoryNo);
            companyOrderDetail.setClientName(companyOrderHistory.getOrderApplicationList().get(i).getClient().getClientName());
            companyOrderDetail.setClientNo(companyOrderHistory.getOrderApplicationList().get(i).getClient().getClientNo());

            companyOrderDetailList.add(i, companyOrderDetail);

        }

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(companyOrderDetailList);
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
    public ModelAndView registCompanyOrder(ModelAndView mv, HttpServletRequest request, Authentication authentication) {


        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        String[] itemAmount = request.getParameterValues("itemAmount");
        String[] clientItemNo = request.getParameterValues("clientItemInfoNo");
        String[] itemInfoNo = request.getParameterValues("itemInfoNo");

        orderService.insertCompanyOrder(itemAmount, clientItemNo, itemInfoNo, customUser.getMemberNo());

        mv.setViewName("/order/companyApplicationList");

        return mv;
    }

    @GetMapping("franchiseorderregist")
    public ModelAndView franchiseOrderRegist(ModelAndView mv) {

        mv.setViewName("/order/franchiseOrderRegist");

        return mv;
    }

    @GetMapping("companyorderapplicationdetail")
    public ModelAndView companyOrderApplicationDetail(ModelAndView mv, HttpServletRequest request) {

        int companyOrderHistoryNo = Integer.parseInt(request.getParameter("companyOrderHistoryNo"));
        int clientNo = Integer.parseInt(request.getParameter("clientNo"));

        List<OrderApplicationDTO> orderApplicationList = orderService.selectOrderApplicationDetail(companyOrderHistoryNo, clientNo);
        List<OrderApplicationItemDTO> orderApplicationItemList = new ArrayList<>();

        for(int i = 0; i < orderApplicationList.size(); i++) {

            for(int j = 0; j < orderApplicationList.get(i).getOrderApplicationItemList().size(); j++) {

               OrderApplicationItemDTO orderApplicationItem = new OrderApplicationItemDTO();
               orderApplicationItem = orderApplicationList.get(i).getOrderApplicationItemList().get(j);
               orderApplicationItemList.add(orderApplicationItem);
            }
        }

        CompanyOrderDetailDTO companyOrderDetail = new CompanyOrderDetailDTO();
        companyOrderDetail.setCompanyOrderHistoryNo(orderApplicationList.get(0).getCompanyOrderHistory().getCompanyOrderHistoryNo());
        companyOrderDetail.setClientName(orderApplicationList.get(0).getClient().getClientName());
        companyOrderDetail.setOrderCreatedDate(orderApplicationList.get(0).getCompanyOrderHistory().getCompanyOrderHistoryCreatedDate());

        mv.addObject("orderApplication", orderApplicationList);
        mv.addObject("companyOrderDetail", companyOrderDetail);
        mv.addObject("orderApplicationItemList", orderApplicationItemList);
        mv.setViewName("/order/companyOrderApplication");

        return mv;
    }

    @GetMapping(value = "/searchitems", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String searchItems(HttpServletRequest request) {

        String searchItem = request.getParameter("searchValue");

        List<OrderItemInfoDTO> orderItemInfoList = orderService.selectOrderItemInfoList(searchItem);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(orderItemInfoList);
    }

    @GetMapping(value = "selectclientitemlist", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectClientItemList(HttpServletRequest request) {

        int itemInfoNo = Integer.parseInt(request.getParameter("itemInfoNo"));

        List<OrderClientContractItemDTO> orderClientContractItemList = orderService.selectClientContractItemList(itemInfoNo);

        Gson gson = new Gson();

        return gson.toJson(orderClientContractItemList);
    }

}
