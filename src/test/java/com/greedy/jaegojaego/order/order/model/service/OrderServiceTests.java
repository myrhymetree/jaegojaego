package com.greedy.jaegojaego.order.order.model.service;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.order.client.model.entity.OrderClient;
import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;
import com.greedy.jaegojaego.order.client.model.repository.OrderClientContractItemRepository;
import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;
import com.greedy.jaegojaego.order.franchise.model.entity.OrderFranchiseInfo;
import com.greedy.jaegojaego.order.franchise.model.repository.OrderFranchiseInfoRepository;
import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
import com.greedy.jaegojaego.order.item.model.repository.OrderItemInfoRepository;
import com.greedy.jaegojaego.order.order.model.entity.company.*;
import com.greedy.jaegojaego.order.order.model.entity.franchise.*;
import com.greedy.jaegojaego.order.order.model.repository.company.CompanyOrderHistoryRepository;
import com.greedy.jaegojaego.order.order.model.repository.company.CompanyOrderItemRepository;
import com.greedy.jaegojaego.order.order.model.repository.company.OrderApplicationItemRepository;
import com.greedy.jaegojaego.order.order.model.repository.company.OrderApplicationRepository;
import com.greedy.jaegojaego.order.order.model.repository.franchise.FranchiseOrderItemRepository;
import com.greedy.jaegojaego.order.order.model.repository.franchise.FranchiseOrderRepository;
import com.greedy.jaegojaego.order.order.model.repository.franchise.FranchiseOrderStatusHistoryRepository;
import com.greedy.jaegojaego.order.warehouse.repository.OrderItemWarehouseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Autowired
    private FranchiseOrderRepository franchiseOrderRepository;

    @Autowired
    private OrderFranchiseInfoRepository orderFranchiseInfoRepository;

    @Autowired
    private FranchiseOrderStatusHistoryRepository franchiseOrderStatusHistoryRepository;

    @Autowired
    private FranchiseOrderItemRepository franchiseOrderItemRepository;

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
        int companyOrderHistoryNo = 2;

        //when
        CompanyOrderHistory companyOrderHistory = companyOrderHistoryRepository.findById(companyOrderHistoryNo).get();

        //then
        assertNotNull(companyOrderHistory);

    }

    @Test
    @DisplayName("본사 발주 신청서 상세보기 메소드 테스트")
    public void selectOrderApplicationDetail() {

        //given
        int companyOrderHistoryNo = 2;

        //when
        CompanyOrderHistory companyOrderHistory = companyOrderHistoryRepository.findById(companyOrderHistoryNo).get();

        //then
        assertNotNull(companyOrderHistory);

    }

    @Test
    @DisplayName("자재 정보 목록 조회 메소드 테스트")
    public void selectOrderItemInfoList() {

        //given
        String searchItemValue = "빵";

        //when
        List<OrderItemInfo> orderItemInfoList = orderItemInfoRepository.selectByItemInfoNameContainingAndItemInfoStatusYn(searchItemValue, "N");

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
    @Transactional
    public void insertCompanyOrder() {

        //given
        int itemAmount = 1000;
        int clientItemNo = 1;
        int itemInfoNo = 1;
        int memberNo = 2;
        int clientNo = 1;

        //when
        //발주 내역 관련
        OrderCompanyAccount companyAccount = new OrderCompanyAccount();
        companyAccount.setMemberNo(memberNo);

        CompanyOrderHistory companyOrderHistory = new CompanyOrderHistory();
        companyOrderHistory.setCompanyOrderHistoryCreatedDate(new Date(System.currentTimeMillis()));
        companyOrderHistory.setOrderCompanyAccount(companyAccount);
        companyOrderHistory.setCompanyOrderHistoryStaus("BEFORE");

        companyOrderHistoryRepository.save(companyOrderHistory); //발주 내역 생성

        int companyOrderHistoryNo = companyOrderHistoryRepository.selectRecentHistoryNo();

        //발주 내역 물품 관련
        CompanyOrderHistory companyOrderItemTest = new CompanyOrderHistory();

        companyOrderItemTest.setCompanyOrderHistoryNo(companyOrderHistoryNo);
        OrderItemInfo newOrderItemInfo = new OrderItemInfo();
        newOrderItemInfo.setItemInfoNo(itemInfoNo);

        CompanyOrderItemPK companyOrderItemPK = new CompanyOrderItemPK();
        companyOrderItemPK.setCompanyOrderHistory(companyOrderHistory);
        companyOrderItemPK.setOrderItemInfo(newOrderItemInfo);

        CompanyOrderItem companyOrderItem = new CompanyOrderItem();
        companyOrderItem.setCompanyOrderItemPK(companyOrderItemPK);
        companyOrderItem.setCompanyOrderItemAmount(itemAmount);

        companyOrderItemRepository.save(companyOrderItem);       //발주 내역 물품 생성

        //발주 신청서 관련
        CompanyOrderHistory orderApplicationTest = new CompanyOrderHistory();
        orderApplicationTest.setCompanyOrderHistoryNo(companyOrderHistoryNo);

        OrderClient orderClient = new OrderClient();
        orderClient.setClientNo(clientNo);

        OrderApplication orderApplication = new OrderApplication();
        orderApplication.setOrderClient(orderClient);
        orderApplication.setCompanyOrderHistory(orderApplicationTest);

        orderApplicationRepository.save(orderApplication);       //발주 신청서 생성

        //발주 신청서 별 물품 관련

        int orderApplicationNo = orderApplicationRepository.selectRecentOrderApplication(2).get(0);

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

        orderApplicationItemRepository.save(orderApplicationItem);

        //then
        assertNotNull(companyOrderHistoryRepository.findById(companyOrderHistoryNo).get());
        assertNotNull(companyOrderItemRepository.findByCompanyOrderHistoryNo(companyOrderHistoryNo));
        assertNotNull(orderApplicationRepository.findByCompanyOrderHistory_CompanyOrderHistoryNo(companyOrderHistoryNo));
        assertNotNull(orderApplicationItemRepository.findByOrderApplicationNo(orderApplicationNo));
    }

    @Test
    @DisplayName("본사 발주 처리 상태 변경 메소드 테스트")
    @Transactional
    public void updateCompanyOrderHistoryStatus() {

        //given
        int memberNo = 107;
        int companyOrderHistoryNo = 2;
        String orderStatus = "REJECT";

        //when
        OrderCompanyAccount orderCompanyAccount = new OrderCompanyAccount();
        orderCompanyAccount.setMemberNo(memberNo);

        CompanyOrderHistory companyOrderHistory = companyOrderHistoryRepository.findById(companyOrderHistoryNo).get();
        companyOrderHistory.setCompanyOrderHistoryStaus(orderStatus);
        companyOrderHistory.setCompanyOrderUpdateMember(orderCompanyAccount);
        companyOrderHistory.setCompanyOrderHistoryStatusDate(new Date(System.currentTimeMillis()));

        //then
        CompanyOrderHistory checkCompanyOrderHistory = companyOrderHistoryRepository.findById(companyOrderHistoryNo).get();

        assertTrue(orderStatus.equals(checkCompanyOrderHistory.getCompanyOrderHistoryStaus()));

    }

    @Test
    @DisplayName("가맹점 발주 내역 목록 조회 메소드 테스트")
    public void selectFranchiseOrderList() {

        //given
        int memberNo = 107;
        String memberDivision = "본사";
        List<FranchiseOrder> franchiseOrderList = new ArrayList<>();
        List<FranchiseOrder> franchiseOrderListByCompany = new ArrayList<>();

        List<OrderFranchiseInfo> franchiseNoList = new ArrayList<>();

        //when
        if("본사".equals(memberDivision)) {

            franchiseNoList = orderFranchiseInfoRepository.findByHeadOfficeSupervisor_MemberNo(memberNo);

            for(int i = 0; i < franchiseNoList.size(); i++) {

                franchiseOrderList = franchiseOrderRepository.findByMember_MemberNo(franchiseNoList.get(i).getFranchiseRepresentativeNo());

                for(int j = 0; j < franchiseOrderList.size(); j++) {

                    franchiseOrderListByCompany.add(franchiseOrderList.get(j));

                }

            }

        } else if("가맹점".equals(memberDivision)) {

            franchiseOrderList = franchiseOrderRepository.findByMember_MemberNo(memberNo);
        }

        //then
        assertNotNull(franchiseOrderList);

    }

    @Test
    @DisplayName("가맹점 발주 내역 상세 조회 메소드 테스트")
    public void selectFranchiseOrderDetail() {

        //given
        int franchiseOrderNo = 41;

        //when
        FranchiseOrder franchiseOrder = franchiseOrderRepository.findById(franchiseOrderNo).get();

        //then
        assertNotNull(franchiseOrder);
        assertNotNull(franchiseOrder.getFranchiseOrderItemList());

    }

    @Test
    @DisplayName("가맹점 발주 내역 처리 상태 승인완료 변경 메소드 테스트")
    @Transactional
    public void updateFranchiseOrderStatusComplete() {

        //given
        int memberNo = 107;
        int franchiseOrderNo = 21;
        String orderStatus = "COMPLETE";

        //when
        FranchiseOrder franchiseOrder = franchiseOrderRepository.findById(franchiseOrderNo).get();
        franchiseOrder.setFranchiseOrderStatus(orderStatus);
        franchiseOrder.setFranchiseOrderStatusDate(new Date(System.currentTimeMillis()));

        OrderCompanyAccount orderCompanyAccount = new OrderCompanyAccount();
        orderCompanyAccount.setMemberNo(memberNo);

        FranchiseOrderStatusHistory franchiseOrderStatusHistory = new FranchiseOrderStatusHistory();
        franchiseOrderStatusHistory.setFranchiseOrderNo(franchiseOrderNo);
        franchiseOrderStatusHistory.setOrderCompanyAccount(orderCompanyAccount);
        franchiseOrderStatusHistory.setFranchiseOrderStatus(orderStatus);
        franchiseOrderStatusHistory.setFranchiseOrderStatusHistoryDate(new Date(System.currentTimeMillis()));

        franchiseOrderStatusHistoryRepository.save(franchiseOrderStatusHistory);

        //then
        assertTrue("COMPLETE".equals(franchiseOrderRepository.findById(franchiseOrderNo).get().getFranchiseOrderStatus()));
        assertNotNull(franchiseOrderStatusHistoryRepository.findByFranchiseOrderNo(franchiseOrderNo));

    }

    @Test
    @DisplayName("가맹점 발주 내역 처리 상태 승인거절 변경 메소드 테스트")
    @Transactional
    public void updateFranchiseOrderStatusReject() {

        //given
        int memberNo = 107;
        int franchiseOrderNo = 21;
        String orderStatus = "REJECT";
        String rejectMessage = "거부 테스트";

        //when
        FranchiseOrder franchiseOrder = franchiseOrderRepository.findById(franchiseOrderNo).get();
        franchiseOrder.setFranchiseOrderStatus(orderStatus);
        franchiseOrder.setFranchiseOrderStatusDate(new Date(System.currentTimeMillis()));
        franchiseOrder.setFranchiseOrderStatusRejectionContent(rejectMessage);

        OrderCompanyAccount orderCompanyAccount = new OrderCompanyAccount();
        orderCompanyAccount.setMemberNo(memberNo);

        FranchiseOrderStatusHistory franchiseOrderStatusHistory = new FranchiseOrderStatusHistory();
        franchiseOrderStatusHistory.setFranchiseOrderNo(franchiseOrderNo);
        franchiseOrderStatusHistory.setOrderCompanyAccount(orderCompanyAccount);
        franchiseOrderStatusHistory.setFranchiseOrderStatus(orderStatus);
        franchiseOrderStatusHistory.setFranchiseOrderStatusHistoryDate(new Date(System.currentTimeMillis()));

        franchiseOrderStatusHistoryRepository.save(franchiseOrderStatusHistory);

        //then
        assertTrue("REJECT".equals(franchiseOrderRepository.findById(franchiseOrderNo).get().getFranchiseOrderStatus()));
        assertNotNull(franchiseOrderStatusHistoryRepository.findByFranchiseOrderNo(franchiseOrderNo));

    }

    @Test
    @DisplayName("가맹점 발주 거절 사유서 조회 메소드 테스트")
    public void selectRejectContent() {

        //given
        int franchiseOrderNo = 21;

        //when
        FranchiseOrder franchiseOrder = franchiseOrderRepository.findById(franchiseOrderNo).get();

        //then
        assertNotNull(franchiseOrder.getFranchiseOrderStatusRejectionContent());

    }

    @Test
    @DisplayName("본사 발주 내역 수정 메소드 테스트")
    public void updateCompanyOrderHistory() {

        //given
        int itemAmount = 100;
        int clientItemNo = 1;
        int itemInfoNo = 1;
        int clientNo = 1;
        int companyOrderHistoryNo = 221;
        Map<Integer, Integer> orderItemInfo = new HashMap<>();
        List<Integer> clientList = new ArrayList<>();

        orderItemInfo.put(itemInfoNo, itemAmount);
        clientList.add(clientNo);

        List<CompanyOrderItem> deleteCompanyOrderItemList = companyOrderItemRepository.findByCompanyOrderHistoryNo(companyOrderHistoryNo);

        List<OrderApplication> deleteOrderApplicationList = orderApplicationRepository.findByCompanyOrderHistory_CompanyOrderHistoryNo(companyOrderHistoryNo);

        //when
        for(int i = 0; i < deleteOrderApplicationList.size(); i++) {

            List<OrderApplicationItem> deleteOrderApplicationItemList = orderApplicationItemRepository.findByOrderApplicationNo(deleteOrderApplicationList.get(i).getOrderApplicationNo());

            for(int j = 0; j < deleteOrderApplicationItemList.size(); j++) {

                orderApplicationItemRepository.delete(deleteOrderApplicationItemList.get(j));
            }
        }

        for(int i = 0; i < deleteOrderApplicationList.size(); i++) {

            orderApplicationRepository.delete(deleteOrderApplicationList.get(i));

        }

        for(int i = 0; i < deleteCompanyOrderItemList.size(); i++) {
            companyOrderItemRepository.delete(deleteCompanyOrderItemList.get(i));
        }

        //발주 물품 삽입
        CompanyOrderHistory companyOrderHistory = new CompanyOrderHistory();

        companyOrderHistory.setCompanyOrderHistoryNo(companyOrderHistoryNo);
        OrderItemInfo newOrderItemInfo = new OrderItemInfo();
        newOrderItemInfo.setItemInfoNo(itemInfoNo);

        CompanyOrderItemPK companyOrderItemPK = new CompanyOrderItemPK();
        companyOrderItemPK.setCompanyOrderHistory(companyOrderHistory);
        companyOrderItemPK.setOrderItemInfo(newOrderItemInfo);

        CompanyOrderItem companyOrderItem = new CompanyOrderItem();
        companyOrderItem.setCompanyOrderItemPK(companyOrderItemPK);
        companyOrderItem.setCompanyOrderItemAmount(itemAmount);

        companyOrderItemRepository.save(companyOrderItem);

        CompanyOrderHistory orderApplicationcompanyOrderHistory = new CompanyOrderHistory();
        orderApplicationcompanyOrderHistory.setCompanyOrderHistoryNo(companyOrderHistoryNo);

        for(int i = 0; i < clientList.size(); i++) {

            OrderClient orderClient = new OrderClient();
            orderClient.setClientNo(clientList.get(i));

            OrderApplication orderApplication = new OrderApplication();
            orderApplication.setOrderClient(orderClient);
            orderApplication.setCompanyOrderHistory(orderApplicationcompanyOrderHistory);

            orderApplicationRepository.save(orderApplication);
        }

        List<OrderApplication> orderApplicationList = orderApplicationRepository.selectRecentOrderApplicationList(clientList.size() + 1);

        for(int i = 0; i < orderApplicationList.size(); i++) {

            OrderApplication orderApplication = new OrderApplication();
            OrderClientContractItem orderClientContractItem = new OrderClientContractItem();
            OrderApplicationItemPK orderApplicationItemPK = new OrderApplicationItemPK();

            int orderApplicationNumber = orderApplicationList.get(i).getOrderClient().getClientNo();

            if(clientItemNo == orderApplicationNumber) {
                orderApplication.setOrderApplicationNo(orderApplicationList.get(i).getOrderApplicationNo());
                orderApplicationItemPK.setOrderApplication(orderApplication);

                orderClientContractItem.setClientContractItemNo(clientItemNo);
                orderApplicationItemPK.setOrderClientContractItem(orderClientContractItem);

                OrderApplicationItem orderApplicationItem = new OrderApplicationItem();
                orderApplicationItem.setOrderApplicationItemPK(orderApplicationItemPK);
                orderApplicationItem.setOrderApplicationItemAmount(itemAmount);

                orderApplicationItemRepository.save(orderApplicationItem);
            }
        }

        //then
        assertTrue(companyOrderItemRepository.findByCompanyOrderHistoryNo(companyOrderHistoryNo).size() == 1);
        assertTrue(orderApplicationRepository.findByCompanyOrderHistory_CompanyOrderHistoryNo(companyOrderHistoryNo).size() == 1);
        assertTrue(orderApplicationItemRepository.findByOrderApplicationNo(orderApplicationList.get(0).getOrderApplicationNo()).size() == 1);

    }

    @Test
    @DisplayName("가맹점 발주 등록 메소드 테스트")
    public void insertFranchiseOrder() {

        //given
        String orderNumber = "818120220510";
        int itemNo = 1;
        int itemAmount = 100;

        Member member = new Member();
        member.setMemberNo(3);

        FranchiseOrder franchiseOrder = new FranchiseOrder();
        franchiseOrder.setFranchiseOrderApplicationDate(new Date(System.currentTimeMillis()));
        franchiseOrder.setFranchiseOrderOrderNumber(orderNumber);
        franchiseOrder.setFranchiseOrderStatus("BEFORE");
        franchiseOrder.setMember(member);

        //when
        franchiseOrderRepository.save(franchiseOrder);
        int franchiseOrderNo = franchiseOrderRepository.selectSequenceNo();


        FranchiseOrderItem franchiseOrderItem = new FranchiseOrderItem();

        OrderItemInfo orderItemInfo = new OrderItemInfo();
        orderItemInfo.setItemInfoNo(itemNo);

        FranchiseOrderableItemPK franchiseOrderableItemPK = new FranchiseOrderableItemPK();
        franchiseOrderableItemPK.setOrderItemInfo(orderItemInfo);

        FranchiseOrderableItem franchiseOrderableItem = new FranchiseOrderableItem();
        franchiseOrderableItem.setFranchiseOrderableItem(franchiseOrderableItemPK);

        FranchiseOrder itemFranchiseOrder = new FranchiseOrder();
        itemFranchiseOrder.setFranchiseOrderNo(franchiseOrderNo);

        FranchiseOrderItemPK franchiseOrderItemPK = new FranchiseOrderItemPK();
        franchiseOrderItemPK.setFranchiseOrderableItem(franchiseOrderableItem);
        franchiseOrderItemPK.setFranchiseOrder(itemFranchiseOrder);

        franchiseOrderItem.setFranchiseOrderItemAmount(itemAmount);
        franchiseOrderItem.setFranchiseOrderItem(franchiseOrderItemPK);

        franchiseOrderItemRepository.save(franchiseOrderItem);

        FranchiseOrderStatusHistory franchiseOrderStatusHistory = new FranchiseOrderStatusHistory();
        franchiseOrderStatusHistory.setFranchiseOrderNo(franchiseOrderNo);
        franchiseOrderStatusHistory.setFranchiseOrderStatus("BEFORE");
        franchiseOrderStatusHistory.setFranchiseOrderStatusHistoryDate(new Date(System.currentTimeMillis()));

        franchiseOrderStatusHistoryRepository.save(franchiseOrderStatusHistory);

        //then
        assertNotNull(franchiseOrderRepository.findById(franchiseOrderNo));
        assertNotNull(franchiseOrderItemRepository.findByFranchiseOrderItem_FranchiseOrder_FranchiseOrderNo(franchiseOrderNo));
        assertNotNull(franchiseOrderStatusHistoryRepository.findByFranchiseOrderNo(franchiseOrderNo));

    }


}
