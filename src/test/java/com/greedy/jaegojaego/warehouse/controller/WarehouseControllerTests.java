package com.greedy.jaegojaego.warehouse.controller;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.order.order.model.controller.OrderController;
import com.greedy.jaegojaego.order.order.model.service.OrderService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class})
@AutoConfigureMockMvc
public class WarehouseControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("입고 목록 조회용")
    public void selectWarehouseList() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/warehouse/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("발주 승인 완료 목록 조회용")
    public void selectWarehouseCompleteList() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/warehouse/complete"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("재고 관리 목록 조회용")
    public void warehouseItemAmountList() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/warehouse/item"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("재고 관리 목록 조회용")
    public void warehouseChangeDetail() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/warehouse/change"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
