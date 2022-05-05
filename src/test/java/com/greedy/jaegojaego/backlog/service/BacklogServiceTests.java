package com.greedy.jaegojaego.backlog.service;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogInWarehouseDTO;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogInWarehouse;
import com.greedy.jaegojaego.backlog.entity.InWarehouseBacklog.BacklogItemInfo;
import com.greedy.jaegojaego.backlog.repository.BacklogItemInfoRepository;
import com.greedy.jaegojaego.backlog.repository.InWarehouseBacklogRepository;
import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.menu.repository.MenuMaterialRepository;
import com.greedy.jaegojaego.menu.repository.MenuRepository;
import com.greedy.jaegojaego.menu.repository.RawMaterialRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JaegojaegoApplication.class})
@SpringBootTest
public class BacklogServiceTests {

    @Autowired
    private BacklogItemInfoRepository backlogItemInfoRepository;

    @Autowired
    private InWarehouseBacklogRepository inWarehouseBacklogRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    @DisplayName("서비스 입고 백로그 목록 조회 테스트")
    public void selectInWarehouseBacklogListTests() {

        //given

        //when
        List<BacklogInWarehouse> inWarehouseBacklogList = inWarehouseBacklogRepository.findAll();

        //then
        assertNotNull(inWarehouseBacklogList);
    }

    @Test
    @DisplayName("서비스 입고 입고 자재 카테고리 불러오기 테스트")
    public void selectItemInfoForInWarehouseTests() {

        //given

        //when
        List<BacklogItemInfo> ItemInfoList = backlogItemInfoRepository.findAll();

        //then
        assertNotNull(ItemInfoList);

    }

    @Test
    @DisplayName("서비스 셀렉트 박스 선택시 특정 입고 목록 리스트 조회 테스트")
    public void findBacklogInWarehouseBySelectBoxTests() {

        //given
        int itemInfoNo = 1;

        //when
        List<BacklogInWarehouse> findBacklogInWarehouseBySelectBox = inWarehouseBacklogRepository.findBacklogInWarehouseBySelectBox(itemInfoNo);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        //then
        assertNotNull(findBacklogInWarehouseBySelectBox);
    }
}

