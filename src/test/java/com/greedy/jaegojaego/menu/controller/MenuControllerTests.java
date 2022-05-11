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
import org.springframework.security.core.Authentication;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.ExpectedCount.never;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JaegojaegoApplication.class})
@AutoConfigureMockMvc
public class MenuControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MenuService menuService;

    @Test
    @DisplayName("컨트롤러 메뉴 상세 조회 테스트")
    public void selectOneMenu() throws Exception {

        mockMvc.perform(get("/menu/selectonemenu").param("menuNo", "1"))
                .andExpect(status().isOk())
                .andDo(print());
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
        menu.setMenuNo(120);
        menu.setMenuName("테스트용 메뉴5");
        menu.setMenuPrice(35000);
        menu.setMenuOrderableStatus("Y");
        
        MenuMaterialsDTO menuMaterial = new MenuMaterialsDTO();
        menuMaterial.setItemInfoName("지로스팅 로스팅 원두 1kg");
        String[] materialNameAndCapacityList = {"지로스팅 로스팅 원두 1kg/80g", "지로스팅 로스팅 원두 1kg/60g"};
        //when
        menuService.registMenu(menu, menuMaterial, materialNameAndCapacityList);

        //then

    }

    @Test
    @DisplayName("컨트롤러 메뉴 수정 테스트")
    public void modifyMenu() {

        //given
        MenuDTO menu = new MenuDTO();
        menu.setMenuNo(226);
        menu.setMenuName("테스트용 메뉴6");
        menu.setMenuPrice(35000);
        menu.setMenuOrderableStatus("Y");

        MenuMaterialsDTO menuMaterials = new MenuMaterialsDTO();
        menuMaterials.setItemInfoName("지로스팅 로스팅 원두 1kg");
        String[] materialNameAndCapacityList = {"지로스팅 로스팅 원두 1kg/80g", "지로스팅 로스팅 원두 1kg/60g"};

        //when
        menuService.modifyMenu(menu, menuMaterials, materialNameAndCapacityList);

        //then

    }

    @Test
    @DisplayName("컨트롤러 메뉴 탈퇴 테스트")
    public void deleteMenu() {

        //given
        int menuNo = 226;

        //when
        menuService.deleteMenu(menuNo);

        //then
    }

}
