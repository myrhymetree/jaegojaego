package com.greedy.jaegojaego.order.order.model.service;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;
import com.greedy.jaegojaego.order.client.model.repository.OrderClientContractItemRepository;
import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
import com.greedy.jaegojaego.order.item.model.repository.OrderItemInfoRepository;
import com.greedy.jaegojaego.order.order.model.entitiy.CompanyOrderHistory;
import com.greedy.jaegojaego.order.order.model.repository.CompanyOrderHistoryRepository;
import com.greedy.jaegojaego.order.warehouse.repository.OrderItemWarehouseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JaegojaegoApplication.class})
@AutoConfigureMockMvc
public class OrderServiceTests {

    @Autowired
    private CompanyOrderHistoryRepository companyOrderHistoryRepository;

    @Autowired
    private OrderItemWarehouseRepository orderItemWarehouseRepository;

    @Autowired
    private OrderItemInfoRepository orderItemInfoRepository;

    @Autowired
    private OrderClientContractItemRepository orderClientContractItemRepository;

    @Test
    @DisplayName("본사 발주 내역 목록 조회 메소드 테스트")
    void selectCompanyOrderList() {

        //given
        String orderData = "companyOrderHistoryNo";

        //when
        List<CompanyOrderHistory> companyOrderHistoryList = companyOrderHistoryRepository.findAll(Sort.by(Sort.Direction.DESC, orderData));


        //then
        assertNotNull(companyOrderHistoryList);

    }

    @Test
    @DisplayName("본사 발주 내역 상세 조회 메소드 테스트")
    public void selectCompanyOrderHistoryDetail() {

        //given
        int companyOrderHistoryNo = 1;

        //when
        CompanyOrderHistory companyOrderHistory = companyOrderHistoryRepository.findById(companyOrderHistoryNo).get();

        //then
        assertNotNull(companyOrderHistory);

    }

    @Test
    @DisplayName("본사 발주 신청서 상세보기 및 창고 주소 조회 메소드 테스트")
    void selectOrderApplicationDetail() {

        //given
        int companyOrderHistoryNo = 1;

        //when
        CompanyOrderHistory companyOrderHistory = companyOrderHistoryRepository.findById(companyOrderHistoryNo).get();
        String warehouseAddress = orderItemWarehouseRepository.selectItemWarehouseAddress();

        //then
        assertNotNull(companyOrderHistory);
        assertNotNull(warehouseAddress);

    }

    @Test
    @DisplayName("자재 정보 목록 조회 메소드 테스트")
    void selectOrderItemInfoList() {

        //given
        String searchItemValue = "빵";

        //when
        List<OrderItemInfo> orderItemInfoList = orderItemInfoRepository.selectByItemInfoNameContaining(searchItemValue);

        //then
        assertNotNull(orderItemInfoList);

    }

    @Test
    @DisplayName("거래처 판매 계약 상품 목록 조회 메소드 테스트")
    void selectClientContractItemList() {

        //given
        int itemInfoNo = 1;

        //when
        List<OrderClientContractItem> orderClientContractItemList = orderClientContractItemRepository.selectClientContractItemList(itemInfoNo);

        //then
        assertNotNull(orderClientContractItemList);

    }

}
