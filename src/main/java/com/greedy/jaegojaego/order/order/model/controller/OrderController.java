package com.greedy.jaegojaego.order.order.model.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.authentification.model.service.AuthenticationService;
import com.greedy.jaegojaego.order.client.model.dto.OrderClientContractItemDTO;
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;
import com.greedy.jaegojaego.order.order.model.dto.company.CompanyOrderDetailDTO;
import com.greedy.jaegojaego.order.order.model.dto.company.CompanyOrderHistoryDTO;
import com.greedy.jaegojaego.order.order.model.dto.company.OrderApplicationDTO;
import com.greedy.jaegojaego.order.order.model.dto.company.OrderApplicationItemDTO;
import com.greedy.jaegojaego.order.order.model.dto.franchise.*;
import com.greedy.jaegojaego.order.order.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <pre>
 * Class : OrderController
 * Comment : 본사, 가맹점 발주(Order)관련 메소드를 모아놓은 Controller 입니다.
 * History
 * 2022/04/19 (박인근) 본사 발주 신청 내역 목록 조회
 * 2022/04/20 (박인근) 본사 발주 신청 내역 목록 조회
 * 2022/04/21 (박인근) 본사 상세 조회, 발주 신청서 거래처 목록 조회
 * 2022/04/23 (박인근) 본사 발주 신청 자재 검색 자동완성, 본사 발주 신청
 * 2022/04/24 (박인근) 본사 발주 신청, 개러처 발주 목록 조회
 * 2022/04/25 (박인근) 거래처 발주 목록 조회
 * 2022/04/26 (박인근) 본사 발주 내역 처리 상태 변경, 거래처 발주 목록 조회, 거래처 발주 상세 조회
 * 2022/04/27 (박인근) 거래처 발주 처리 상태 변경
 * 2022/04/28 (박인근) 거래처 발주 신청 자재 목록 조회, 본사 발주 내역 수정
 * 2022/04/29 (박인근) 거래처 발주 신청 자재 목록 조회
 * 2022/04/30 (박인근) 거래처 발주 신청 자재 목록 조회, 거래처 발주 신청
 * 2022/05/01 (박인근) 거래처 발주 신청, 거래처 발주 거부 사유서 조회
 * </pre>
 * @version 12
 * @author 박인근
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final AuthenticationService authenticationService;

    @Autowired
    public OrderController(OrderService orderService, AuthenticationService authenticationService) {
        this.orderService = orderService;
        this.authenticationService = authenticationService;
    }

    /**
     * selectCompanyOrderList : 전체 발주 목록 조회
     * @param mv : 발주 목록에서 보여줄 정보들과 이동할 페이지의 요청 url을 담을 파라미터
     * @return : 전체 발주 목록
     */
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

    /**
     * selectCompanyOrderDetail : 선택한 프로젝트의 상세 정보
     * @param companyOrderHistoryNo : 상세 조회할 본사 발주 내역 번호
     * @return : 본사 발주 내역 상세 정보
     */
    @GetMapping(value = "/selectcompanyorderdetail", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectCompanyOrderDetail(@RequestParam(value = "companyOrderHistoryNo") String companyOrderHistoryNo) {

        int companyOrderNo = Integer.parseInt(companyOrderHistoryNo);

        CompanyOrderHistoryDTO companyOrderHistory = orderService.selectCompanyOrderHistoryDetail(companyOrderNo);

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

    /**
     * selectOneCompanyOrderApplicationList : 선택한 본사 발주 내역의 거래처 발주 신청서 목록 조회
     * @param companyOrderHistoryNo : 선택한 본사 발주 내역 번호
     * @return : 선택한 본사 내역의 거래처 발주 신청서 목록
     */
    @GetMapping(value ="selectonecompanyorderapplicationlist", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectOneCompanyOrderApplicationList(@RequestParam(value = "companyOrderHistoryNo") String companyOrderHistoryNo) {

        int companyOrderNo = Integer.parseInt(companyOrderHistoryNo);

        CompanyOrderHistoryDTO companyOrderHistory = orderService.selectCompanyOrderHistoryDetail(companyOrderNo);

        List<CompanyOrderDetailDTO> companyOrderDetailList = new ArrayList<>();

        for(int i = 0; i < companyOrderHistory.getOrderApplicationList().size(); i++) {

            CompanyOrderDetailDTO companyOrderDetail = new CompanyOrderDetailDTO();
            companyOrderDetail.setCompanyOrderHistoryNo(companyOrderNo);
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

    /**
     * companyOrderRegist : 본사 발주 신청 view 페이지 이동
     * @param mv :본사 발주 신청 view 페이지 url을 담은 변수
     * @return : 본사 발주 신청 페이지 이동
     */
    @GetMapping("/companyorderregist")
    public ModelAndView companyOrderRegist(ModelAndView mv) {

        mv.setViewName("/order/companyOrderRegist");

        return mv;
    }

    /**
     * registCompanyOrder : 본사 발주 신청
     * @param mv : 본사 발주 내역 발주 신청서 목록과 이동할 요청 url을 담은 변수
     * @param authentication : 로그인한 사용자의 정보
     * @param webRequest : 요청 페이지에서 전달 받은 선택한 자재의 각 자재번호, 신청수량, 거래처 번호, 거래처 판매 계약 물품 번호들을 사용하기 위한 변수
     * @return : 본사 발주 내역 발주 신청서 목록과 본사 발주 내역 발주 신청서 조회 url 로 이동
     */
    @PostMapping("companyorderregist")
    public ModelAndView registCompanyOrder(ModelAndView mv, Authentication authentication, WebRequest webRequest) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        String[] itemAmount = webRequest.getParameterValues("itemAmount");
        String[] clientItemNo = webRequest.getParameterValues("clientItemInfoNo");
        String[] itemInfoNo = webRequest.getParameterValues("itemInfoNo");
        String[] clientNo = webRequest.getParameterValues("clientNo");

        List<CompanyOrderDetailDTO> applicationList = orderService.insertCompanyOrder(itemAmount, clientItemNo, itemInfoNo, customUser.getMemberNo(), clientNo);

        mv.addObject("applicationList", applicationList);
        mv.setViewName("/order/companyApplicationList");

        return mv;
    }

    /**
     * companyOrderApplicationDetail : 본사 발주 내역 발주 신청서 상세 조회
     * @param mv : 본사 발주 내역 발주 신청서 상세 정보와 이동할 요청 url을 담은 변수
     * @param request : 요청 페이지에서 전달 받은 선택한 발주 발주 신청서의 발주 내역 번호, 거래처 번호를 사용하기 위한 변수
     * @return : 본사 발주 내역 발주 신청서 상세 정보와 본사 발주 내역 발주 신청서 상세 조회 url 로 이동
     */
    @GetMapping("companyorderapplicationdetail")
    public ModelAndView companyOrderApplicationDetail(ModelAndView mv, WebRequest request) {

        int companyOrderHistoryNo = Integer.parseInt(request.getParameter("companyOrderHistoryNo"));
        int clientNo = Integer.parseInt(request.getParameter("clientNo"));

        List<OrderApplicationDTO> orderApplicationList = orderService.selectOrderApplicationDetail(companyOrderHistoryNo, clientNo);
        List<OrderApplicationItemDTO> orderApplicationItemList = new ArrayList<>();

        for(int i = 0; i < orderApplicationList.size(); i++) {

            for(int j = 0; j < orderApplicationList.get(i).getOrderApplicationItemList().size(); j++) {

               OrderApplicationItemDTO orderApplicationItem = orderApplicationList.get(i).getOrderApplicationItemList().get(j);
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

    /**
     * searchItems : 본사 발주 신청가능 자재 목록 조회
     * @param request : 요청 페이지에서 전달 받은 사용자가 검색한 내용을 사용하기 위한 변수
     * @return : 검색한 내용이 자재 이름에 포함된 자재 목록
     */
    @GetMapping(value = "/searchitems", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String searchItems(WebRequest request) {

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

    /**
     * selectClientItemList : 선택한 자재의 거래처 목록 조회
     * @param request : 요청 페이지에서 전달 받은 선택한 자재의 자재 번호를 사용하기 위한 변수
     * @return : 선택한 자재에 해당하는 거래처 판매 계약 상품 목록
     */
    @GetMapping(value = "selectclientitemlist", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectClientItemList(WebRequest request) {

        int itemInfoNo = Integer.parseInt(request.getParameter("itemInfoNo"));

        List<OrderClientContractItemDTO> orderClientContractItemList = orderService.selectClientContractItemList(itemInfoNo);

        Gson gson = new Gson();

        return gson.toJson(orderClientContractItemList);
    }

    /**
     * modifyCompanyOrderHistoryStatus : 선택한 본사 발주 내역 처리 상태 변경
     * @param request : 요청 페이지에서 전달 받은 선택한 본사 발주 내역 번호와 변경된 처리 상태값을 사용하기 위한 변수
     * @param authentication : 로그인한 사용자의 정보
     * @return : 상태 변경 성공을 확인
     */
    @GetMapping(value = "modifycompanyorderhistorystatus", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String modifyCompanyOrderHistoryStatus(WebRequest request, Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        int companyOrderHistoryNo = Integer.parseInt(request.getParameter("companyOrderHistoryNo"));
        String orderStatus = request.getParameter("orderStatus");

        orderService.updateCompanyOrderHistoryStatus(customUser.getMemberNo(), companyOrderHistoryNo, orderStatus);

        Gson gson = new Gson();

        return gson.toJson("success");
    }

    /**
     * modifyCompanyOrder : 선택한 본사 발주 내역 수정 페이지 이동
     * @param request : 요청 페이지에서 전달 받은 선택한 본사 발주 내역 번호를 사용하기 위한 변수
     * @param mv : 본사 발주 내역 상세 정보와 이동할 요청 url을 담은 변수
     * @return : 본사 발주 내역 상세 정보와 본사 발주 내역 수정 url 로 이동
     */
    @GetMapping("/modifycompanyorder")
    public ModelAndView modifyCompanyOrder(WebRequest request, ModelAndView mv) {

        int companyOrderHistoryNo = Integer.parseInt(request.getParameter("companyOrderHistoryNo"));

        CompanyOrderHistoryDTO companyOrderHistory = orderService.selectCompanyOrderHistoryDetail(companyOrderHistoryNo);

        mv.addObject("companyOrderHistory", companyOrderHistory);
        mv.setViewName("/order/companyOrderModify");

        return mv;
    }

    /**
     * modifyCompanyOrder : 선택한 본사 발주 내역 수정
     * @param request : 요청 페이지에서 전달 받은 선택한 자재들의 자재 번호, 수량, 거래처 번호, 거래처 물품 번호를 사용하기 위한 변수
     * @param authentication : 로그인한 사용자의 정보
     * @return : 본사 발주 목록 url 로 이동
     */
    @PostMapping("/modifycompanyorder")
    public String modifyCompanyOrder(WebRequest request, Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        String[] itemAmount = request.getParameterValues("itemAmount");
        String[] clientItemNo = request.getParameterValues("clientItemInfoNo");
        String[] itemInfoNo = request.getParameterValues("itemInfoNo");
        String[] clientNo = request.getParameterValues("clientNo");
        int companyOrderHistoryNo = Integer.parseInt(request.getParameter("companyOrderHistoryNo"));

        orderService.updateCompanyOrderHistory(itemAmount, clientItemNo, itemInfoNo, clientNo, companyOrderHistoryNo);

        return "redirect:/order/companyorderlist";
    }

    /**
     * selectFranchiseOrderList : 거래처 발주 내역 목록 조회
     * @param mv : 거래처 발주 목록, 로그인 사용자 정보, 이동할 요청 url 을 담은 변수
     * @param authentication : 로그인한 사용자의 정보
     * @return : 거래처 발주 목록, 로그인 사용자 정보, 거래처 발주 목록 url 로 이동
     */
    @GetMapping("/franchiseorderlist")
    public ModelAndView selectFranchiseOrderList(ModelAndView mv, Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        List<FranchiseOrderListDTO> franchiseOrderList = orderService.selectFranchiseOrderList(customUser.getMemberNo(), customUser.getMemberDivision(), customUser.getOfficeDivision());

        mv.addObject("franchiseOrderList", franchiseOrderList);
        mv.addObject("member", customUser);
        mv.setViewName("/order/franchiseOrderList");

        return mv;
    }

    /**
     * selectFranchiseOrderDetail : 거래처 발주 내역 상세 조회
     * @param request : 요청 페이지에서 전달 받은 거래처 발주 내역 번호를 사용하기 위한 변수
     * @return : 개래처 발주 내역 물품 목록
     */
    @GetMapping(value = "/franchiseorderdetail", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectFranchiseOrderDetail(WebRequest request) {

        int franchiseOrderNo = Integer.parseInt(request.getParameter("franchiseOrderNo"));

        List<FranchiseOrderDetailDTO> franchiseOrderItemList = orderService.selectFranchiseOrderDetail(franchiseOrderNo);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(franchiseOrderItemList);
    }

    /**
     * modifyFranchiseOrderStatus : 거래처 발주 내역 처리 상태 변경
     * @param request : 요청 페이지에서 전달 받은 거래처 발주 내역 번호, 처리 상태를 사용하기 위한 변수
     * @param authentication : 로그인한 사용자의 정보
     * @return : 거래처 발주 내역 처리 상태 변경 성공 확인
     */
    @GetMapping(value = "/modifyfranchiseorderstatus", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String modifyFranchiseOrderStatus(WebRequest request, Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        int franchiseOrderNo = Integer.parseInt(request.getParameter("franchiseOrderNo"));
        String orderStatus = request.getParameter("orderStatus");

        if("REJECT".equals(orderStatus)) {

            String rejectMessage = request.getParameter("rejectMessage");
            orderService.updateFranchiseOrderStatus(customUser.getMemberNo(), franchiseOrderNo, orderStatus, rejectMessage);

        } else {

            orderService.updateFranchiseOrderStatus(customUser.getMemberNo(), franchiseOrderNo, orderStatus);
        }


        Gson gson = new Gson();

        return gson.toJson("success");
    }

    /**
     * franchiseOrderRegist : 거래처 발주 신청 페이지로 이동
     * @param mv : 거래처 발주 신청 가능 물품 목록과 이동할 요청 url 을 담은 변수
     * @return : 거래처 발주 신청 가능 물품 목록과 거래처 발주 신청 url 로 이동
     */
    @GetMapping("/franchiseorderregist")
    public ModelAndView franchiseOrderRegist(ModelAndView mv) {

        List<FranchiseOrderableItemDTO> franchiseOrderableItemList = orderService.selectFranchiseOrderableItemList();

        mv.addObject("itemList", franchiseOrderableItemList);
        mv.setViewName("/order/franchiseOrderRegist");

        return mv;
    }

    /**
     * franchiseOrderRegist : 거래처 발주 신청
     * @param request : 요청 페이지에서 전달 받은 선택한 자재들의 자재 번호, 수량을 사용하기 위한 변수
     * @param authentication : 로그인한 사용자의 정보
     * @return : 거래처 발주 목록 url 로 이동
     */
    @PostMapping("/franchiseorderregist")
    public String franchiseOrderRegist(WebRequest request, Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        String[] itemInfoNoList = request.getParameterValues("itemInfoNo");
        String[] itemAmountList = request.getParameterValues("itemAmount");
        int[] itemInfoNo = new int[itemInfoNoList.length];
        int[] itemAmount = new int[itemAmountList.length];

        for(int i = 0; i < itemInfoNoList.length; i++) {

            itemInfoNo[i] = Integer.parseInt(itemInfoNoList[i]);
            itemAmount[i] = Integer.parseInt(itemAmountList[i]);
        }

        orderService.insertFranchiseOrder(customUser.getMemberNo(), itemInfoNo, itemAmount);

        return "redirect:/order/franchiseorderlist";
    }

    /**
     * selectRejectContent : 거래처 발주 신청
     * @param request : 요청 페이지에서 전달 받은 선택한 거래처 발주의 발주 번호를 사용하기 위한 변수
     * @return : 거래처 발주 목록 url 로 이동
     */
    @GetMapping(value = "/selectrejectcontent", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectRejectContent(WebRequest request) {

        int franchiseOrderNo = Integer.parseInt(request.getParameter("franchiseOrderNo"));

        String rejectContent = orderService.selectRejectContent(franchiseOrderNo);

        Gson gson = new Gson();

        return gson.toJson(rejectContent);
    }

}
