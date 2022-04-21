package com.greedy.jaegojaego.menu.controller;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.menu.service.MenuService;
import org.junit.Before;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = { JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JpaConfiguration.class })
@AutoConfigureMockMvc //Builder없이 MockMvc 주입받을수 있음 ㄷㄷ;
public class MenuControllerTests {

    @Autowired
    private MockMvc mockMvc;
    private MenuService menuService;
    private MenuController menuController;

    @Test
    @DisplayName("메뉴 목록 조회 테스트")
    public void moveMenu() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/menu/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());

    }


}
