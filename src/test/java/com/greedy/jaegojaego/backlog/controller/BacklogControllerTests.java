package com.greedy.jaegojaego.backlog.controller;

import com.greedy.jaegojaego.backlog.dto.InWarehouseBacklog.BacklogInWarehouseDTO;
import com.greedy.jaegojaego.backlog.service.BacklogService;
import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.menu.dto.RawMaterialDTO;
import com.greedy.jaegojaego.menu.service.MenuService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JaegojaegoApplication.class})
@AutoConfigureMockMvc
public class BacklogControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BacklogService backlogService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    @DisplayName("백로그관리 이동 및 목록 조회 테스트")
    public void moveBacklog() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/backlog/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("컨트롤러 입고 백로그 목록 조회 테스트")
    public void selectInWarehouseBacklogListTests() {

        //given

        //when
        List<BacklogInWarehouseDTO> inWarehouseBacklogList = backlogService.selectInWarehouseBacklogList();

        //then
        assertNotNull(inWarehouseBacklogList);
    }

    @Test
    @DisplayName("컨트롤러 입고 자재 카테고리 불러오기 테스트")
    public void selectItemInfoForInWarehouseTests() {

        //given

        //when
        backlogService.findItemInfoList();

        //then
        assertNotNull(backlogService.findItemInfoList());
    }

    @Test
    @DisplayName("컨트롤러 셀렉트 박스 선택시 특정 입고 목록 리스트 조회 테스트")
    public void findBacklogInWarehouseBySelectBoxTests() {

        //given
        int itemInfoNo = 1;

        //when

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        List<BacklogInWarehouseDTO> backlogInWarehouseDTOList = backlogService.findBacklogInWarehouseBySelectBox(itemInfoNo).stream().map(backlogInWarehouseDTO -> modelMapper.map(backlogInWarehouseDTO, BacklogInWarehouseDTO.class)).collect(Collectors.toList());

        //then
        assertNotNull(backlogInWarehouseDTOList);
    }


}
