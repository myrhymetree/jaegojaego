package com.greedy.jaegojaego.order.order.model.controller;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.order.order.model.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class})
@AutoConfigureMockMvc
public class OrderControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderController orderController;

    @Test
    @DisplayName("본사 발주 내역 목록 조회 및 이동 테스트")
    public void moveCompanyOrderList() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/order/companyorderlist"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("본사 발주 내역 상세 조회 및 이동 테스트")
    public void selectCompanyOrderDetail() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/order/selectcompanyorderdetail")
                .contentType(MediaType.APPLICATION_JSON)
                .param("companyOrderHistoryNo", "2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("본사 발주 내역 발주 신청서 목록 조회 및 비동기 테스트")
    public void selectOneCompanyOrderApplicationList() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/order/selectonecompanyorderapplicationlist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("companyOrderHistoryNo", "2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("본사 발주 신청 페이지 조회 및 이동 테스트")
    public void companyOrderRegist() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/order/companyorderregist"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("본사 발주 신청서 상세 조회 및 이동 테스트")
    public void companyOrderApplicationDetail() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/order/companyorderapplicationdetail")
                        .param("companyOrderHistoryNo", "2").param("clientNo", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("본사 발주 신청 자재 검색 자동완성 비동기 테스트")
    public void searchItems() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/order/searchitems")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("searchValue", "1kg"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("본사 발주 신청 자재 별 거래처 목록 조회 비동기 테스트")
    public void selectClientItemList() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/order/selectclientitemlist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("itemInfoNo", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("거래처 발주 상세 조회 비동기 테스트")
    public void selectFranchiseOrderDetail() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/order/franchiseorderdetail")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("franchiseOrderNo", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("거래처 발주 신청 가능 물품 조회 테스트")
    public void franchiseOrderRegist() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/order/franchiseorderregist"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("거래처 발주 거절 사유서 테스트")
    public void selectRejectContent() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/order/selectrejectcontent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("franchiseOrderNo", "21"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }


}
