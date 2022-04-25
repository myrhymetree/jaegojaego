package com.greedy.jaegojaego.menu.controller;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.menu.dto.MenuDTO;
import com.greedy.jaegojaego.menu.dto.MenuMaterialsDTO;
import com.greedy.jaegojaego.menu.dto.RawMaterialDTO;
import com.greedy.jaegojaego.menu.entity.MenuMaterial;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.ExpectedCount.never;

@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JaegojaegoApplication.class})
@AutoConfigureMockMvc //Builder없이 MockMvc 주입받을수 있음 ㄷㄷ;
public class MenuControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MenuService menuService;


    @Test
    @DisplayName("메뉴관리 이동 및 목록 조회 테스트")
    public void moveMenu() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/menu/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("컨트롤러 메뉴 상세 조회 테스트")
    public void selectOneMenu() {

        //given
        int menuNo = 1;

        //when
        List<RawMaterialDTO> rawMaterialList = menuService.selectOneMenu(menuNo);

        //then
        assertNotNull(rawMaterialList);
    }

    @Test
    @DisplayName("컨트롤러 상세조회용 카테고리 조회 테스트")
    public void selectCategoryForSelectOneMenu() {

        //given

        //when
        List<MenuMaterialsDTO> menuMaterialList =  menuService.findRawMaterialList();

        //then
        assertNotNull(menuMaterialList);
    }

    @Test
    @DisplayName("컨트롤러 메뉴 등록 테스트")
    public void registMenu() {

        //given
        MenuDTO menu = new MenuDTO();
        menu.setMenuNo(100);
        menu.setMenuName("테스트용 메뉴4");
        menu.setMenuOrderableStatus("Y");
        
        MenuMaterialsDTO menuMaterial = new MenuMaterialsDTO();
        menuMaterial.setItemInfoName("지로스팅 로스팅 원두 1kg");
        String materialNameAndCapacityList = "지로스팅 로스팅 원두 1kg/80g,";
        //when
        menuService.registMenu(menu, menuMaterial, materialNameAndCapacityList);

        //then

    }


}
