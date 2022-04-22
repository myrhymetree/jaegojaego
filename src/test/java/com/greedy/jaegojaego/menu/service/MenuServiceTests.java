package com.greedy.jaegojaego.menu.service;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.menu.entity.RawMaterial;
import com.greedy.jaegojaego.menu.repository.MenuRepository;
import com.greedy.jaegojaego.menu.repository.RawMaterialRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JaegojaegoApplication.class})
@SpringBootTest
public class MenuServiceTests {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RawMaterialRepository rawMaterialRepository;


    @Test
    public void initTest() {

    }

    @Test
    @DisplayName("레파지토리 상세조회용 메소드 테스트")
    public void selectOneMenuTest() {
//
//        //given
//        int menuNo = 1;
//
//        //when
//        List<Integer> rawMaterialIntList = rawMaterialRepository.selectintList(menuNo, pageable);
//        List<String> rawMaterialStringList = rawMaterialRepository.selectStringList(menuNo, pageable);
//
//        List<RawMaterial> rawMaterialList = new ArrayList<>();
//        for(int i = 0;  i < rawMaterialStringList.size(); i++) {
//
//            RawMaterial rawMaterial = new RawMaterial();
//
//            rawMaterial.setRawMaterialName(rawMaterialStringList.get(i));
//            rawMaterial.setRawMaterialCapacity(rawMaterialIntList.get(i));
//
//            rawMaterialList.add(rawMaterial);
//        }
//
//        assertNotNull(rawMaterialIntList);
//        assertNotNull(rawMaterialStringList);
//        assertNotNull(rawMaterialList);

    }
}
