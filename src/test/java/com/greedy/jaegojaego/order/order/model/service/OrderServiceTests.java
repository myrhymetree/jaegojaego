package com.greedy.jaegojaego.order.order.model.service;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.order.client.model.entity.OrderClient;
import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;
import com.greedy.jaegojaego.order.client.model.repository.OrderClientContractItemRepository;
import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;
import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
import com.greedy.jaegojaego.order.item.model.repository.OrderItemInfoRepository;
<<<<<<< HEAD
import com.greedy.jaegojaego.order.warehouse.entity.entitiy.CompanyOrderHistory;
import com.greedy.jaegojaego.order.order.model.repository.CompanyOrderHistoryRepository;
=======
import com.greedy.jaegojaego.order.order.model.entitiy.company.*;
import com.greedy.jaegojaego.order.order.model.repository.company.CompanyOrderHistoryRepository;
import com.greedy.jaegojaego.order.order.model.repository.company.CompanyOrderItemRepository;
import com.greedy.jaegojaego.order.order.model.repository.company.OrderApplicationItemRepository;
import com.greedy.jaegojaego.order.order.model.repository.company.OrderApplicationRepository;
>>>>>>> develop
import com.greedy.jaegojaego.order.warehouse.repository.OrderItemWarehouseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;
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

    @Autowired
    private CompanyOrderItemRepository companyOrderItemRepository;

    @Autowired
    private OrderApplicationRepository orderApplicationRepository;

    @Autowired
    private OrderApplicationItemRepository orderApplicationItemRepository;

    @Test
    @DisplayName("본사 발주 내역 목록 조회 메소드 테스트")
    public void selectCompanyOrderList() {

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
    public void selectOrderApplicationDetail() {

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
    public void selectOrderItemInfoList() {

        //given
        String searchItemValue = "빵";

        //when
        List<OrderItemInfo> orderItemInfoList = orderItemInfoRepository.selectByItemInfoNameContaining(searchItemValue);

        //then
        assertNotNull(orderItemInfoList);

    }

    @Test
    @DisplayName("거래처 판매 계약 상품 목록 조회 메소드 테스트")
    public void selectClientContractItemList() {

        //given
        int itemInfoNo = 1;

        //when
        List<OrderClientContractItem> orderClientContractItemList = orderClientContractItemRepository.selectClientContractItemList(itemInfoNo);

        //then
        assertNotNull(orderClientContractItemList);

    }

    @Test
    @DisplayName("본사 발주 신청 메소드 테스트")
    public void insertCompanyOrder() {

        //given
        int itemAmount = 1000;
        int clientItemNo = 1;
        int itemInfoNo = 1;
        int memberNo = 2;
        int clientNo = 1;
        int companyOrderHistoryNo = 70;
        int orderApplicationNo = 50;

        //발주 내역 관련
        OrderCompanyAccount companyAccount = new OrderCompanyAccount();
        companyAccount.setMemberNo(memberNo);

        CompanyOrderHistory companyOrderHistory = new CompanyOrderHistory();
        companyOrderHistory.setCompanyOrderHistoryCreatedDate(new Date(System.currentTimeMillis()));
        companyOrderHistory.setOrderCompanyAccount(companyAccount);

        //발주 내역 물품 관련
        CompanyOrderHistory companyOrderItemTest = new CompanyOrderHistory();

        companyOrderItemTest.setCompanyOrderHistoryNo(companyOrderHistoryNo);
        OrderItemInfo newOrderItemInfo = new OrderItemInfo();
        newOrderItemInfo.setItemInfoNo(itemInfoNo);

        CompanyOrderItemPK companyOrderItemPK = new CompanyOrderItemPK();
        companyOrderItemPK.setCompanyOrderHistory(companyOrderItemTest);
        companyOrderItemPK.setOrderItemInfo(newOrderItemInfo);

        CompanyOrderItem companyOrderItem = new CompanyOrderItem();
        companyOrderItem.setCompanyOrderItemPK(companyOrderItemPK);
        companyOrderItem.setCompanyOrderItemAmount(itemAmount);

        //발주 신청서 관련
        CompanyOrderHistory orderApplicationTest = new CompanyOrderHistory();
        companyOrderHistory.setCompanyOrderHistoryNo(companyOrderHistoryNo);

        OrderClient orderClient = new OrderClient();
        orderClient.setClientNo(clientNo);

        OrderApplication orderApplication = new OrderApplication();
        orderApplication.setOrderClient(orderClient);
        orderApplication.setCompanyOrderHistory(orderApplicationTest);

        //발주 신청서 별 물품 관련

        OrderApplication orderApplicationItemTest = new OrderApplication();
        OrderClientContractItem orderClientContractItem = new OrderClientContractItem();
        OrderApplicationItemPK orderApplicationItemPK = new OrderApplicationItemPK();

        orderApplicationItemTest.setOrderApplicationNo(orderApplicationNo);
        orderApplicationItemPK.setOrderApplication(orderApplicationItemTest);

        orderClientContractItem.setClientContractItemNo(clientItemNo);
        orderApplicationItemPK.setOrderClientContractItem(orderClientContractItem);

        OrderApplicationItem orderApplicationItem = new OrderApplicationItem();
        orderApplicationItem.setOrderApplicationItemPK(orderApplicationItemPK);
        orderApplicationItem.setOrderApplicationItemAmount(itemAmount);

        //when
        companyOrderHistoryRepository.save(companyOrderHistory); //발주 내역 생성
        companyOrderItemRepository.save(companyOrderItem);       //발주 내역 물품 생성
        orderApplicationRepository.save(orderApplication);       //발주 신청서 생성
        orderApplicationItemRepository.save(orderApplicationItem);

        //then



    }

}
