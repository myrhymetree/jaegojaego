package com.greedy.jaegojaego.menu.service;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.menu.dto.MenuDTO;
import com.greedy.jaegojaego.menu.dto.MenuMaterialsDTO;
import com.greedy.jaegojaego.menu.entity.Menu;
import com.greedy.jaegojaego.menu.entity.MenuMaterial;
import com.greedy.jaegojaego.menu.entity.RawMaterial;
import com.greedy.jaegojaego.menu.entity.RawMaterialPK;
import com.greedy.jaegojaego.menu.repository.MenuMaterialRepository;
import com.greedy.jaegojaego.menu.repository.MenuRepository;
import com.greedy.jaegojaego.menu.repository.RawMaterialRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JaegojaegoApplication.class})
@SpringBootTest
public class MenuServiceTests {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    @Autowired
    private MenuMaterialRepository menuMaterialRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {

    }

    @Test
    @DisplayName("레파지토리 상세조회용 메소드 테스트")
    public void selectOneMenuTest() {

        //given
        int menuNo = 1;

        //when
        List<RawMaterial> test = rawMaterialRepository.selectOneMenu(menuNo);

        assertNotNull(test);

    }


    @Test
    @DisplayName("서비스 상세조회용 카테고리 조회 테스트")
    public void selectCategoryForSelectOneMenu() {

        //given

        //when
        List<MenuMaterial> rawMaterialList = menuMaterialRepository.findAll();

        //then
        assertNotNull(rawMaterialList);

    }

    @Test
    @DisplayName("서비스 메뉴 등록 테스트")
    public void menuRegistTest() {

        //given
        MenuDTO menu = new MenuDTO();
        menu.setMenuNo(51);
        menu.setMenuName("테스트용 메뉴4"); //이름 계속 바꿔줘야 성공합니다.
        menu.setMenuPrice(3000);
        menu.setMenuOrderableStatus("Y");

        MenuMaterialsDTO menuMaterial = new MenuMaterialsDTO();
        String menuRawMaterialName = "지로스팅 로스팅 원두 1kg";
        String menuCapacity = "80g";

        //when
        Menu insertMenu = menuRepository.save(modelMapper.map(menu, Menu.class)); //성공시
        Menu menuNo = menuRepository.selectMenuByMenuName(menu.getMenuName()); //메뉴 번호
        MenuMaterial menuInfo = menuMaterialRepository.selectMenuMaterialBymenuName(menuRawMaterialName);

        RawMaterial rawMaterial = new RawMaterial();
        RawMaterialPK rawMaterialPK = new RawMaterialPK();

        rawMaterialPK.setMenuNoforRaw(modelMapper.map(menuNo, Menu.class));
        rawMaterialPK.setItemInfoNo(menuInfo);
        rawMaterial.setRawMaterialCapacity(menuCapacity);
        rawMaterial.setRawMaterialName(menuRawMaterialName);
        rawMaterial.setRawMaterialPK(rawMaterialPK);
        rawMaterialRepository.save(rawMaterial); //제발 되라!

        //then
        assertNotNull(rawMaterialRepository.save(rawMaterial));

    }

    @Test
    @DisplayName("서비스 메뉴 수정 테스트")
    public void menuModifyTest() {

        //given
        MenuDTO menu = new MenuDTO();
        menu.setMenuNo(229);
        menu.setMenuName("테스트용 메뉴4");
        menu.setMenuPrice(2000);
        menu.setMenuOrderableStatus("N");


        MenuMaterialsDTO menuMaterials = new MenuMaterialsDTO();
        String menuRawMaterialName = "지로스팅 로스팅 원두 1kg";
        String menuCapacity = "20g";

        //when
        Menu selectMenu = menuRepository.findById(menu.getMenuNo()).get();
        selectMenu.setMenuName(menu.getMenuName());
        selectMenu.setMenuPrice(menu.getMenuPrice());
        selectMenu.setMenuOrderableStatus(menu.getMenuOrderableStatus());

        Menu modifyMenu = menuRepository.save(selectMenu);

        if (selectMenu != null) {

            Menu menuNo = menuRepository.selectMenuByMenuName(modifyMenu.getMenuName());
            MenuMaterial menuInfoNo = menuMaterialRepository.selectMenuMaterialBymenuName(menuRawMaterialName);
            //then

            RawMaterial rawMaterial = new RawMaterial();
            RawMaterialPK rawMaterialPK = new RawMaterialPK();

            rawMaterialPK.setMenuNoforRaw(menuNo);
            rawMaterialPK.setItemInfoNo(menuInfoNo);
            rawMaterial.setRawMaterialPK(rawMaterialPK);


            rawMaterial.setRawMaterialName(menu.getMenuName());
            rawMaterial.setRawMaterialCapacity(menuCapacity);

            rawMaterialRepository.save(rawMaterial);

            assertNotNull(rawMaterialRepository.save(rawMaterial));
        }

    }

    @Test
    @DisplayName("서비스 메뉴 탈퇴 테스트")
    public void deleteMenu() {

        //given
        int menuNo = 229;

        //when
        menuRepository.deleteById(menuNo);

        //then

    }



}

