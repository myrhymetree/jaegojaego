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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = { JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JpaConfiguration.class })
public class MenuServiceTests {

    @Autowired
    private MenuRepository menuRepository;
    private RawMaterialRepository rawMaterialRepository;

    @Test
    @DisplayName("목록 상세조회 서비스 테스트")
    public void selectOneMenu() {

        //given
        int menuNo = 1;

        //when
        List<String> stringList = rawMaterialRepository.selectStringList(menuNo);
        List<Integer> intList = rawMaterialRepository.selectintList(menuNo);

        List<RawMaterial> rawMaterialList = new ArrayList<>();
        for(int i = 0;  i < stringList.size(); i++) {

            RawMaterial rawMaterial = new RawMaterial();

            rawMaterial.setRawMaterialName(stringList.get(i));
            rawMaterial.setRawMaterialCapacity(intList.get(i));

            rawMaterialList.add(rawMaterial);
        }

        //then
        assertNotNull(rawMaterialList);
    }


}
