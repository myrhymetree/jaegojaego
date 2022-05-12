package com.greedy.jaegojaego.warehouse.service;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.order.order.model.entity.company.CompanyOrderHistory;
import com.greedy.jaegojaego.warehouse.entity.*;
import com.greedy.jaegojaego.warehouse.repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JaegojaegoApplication.class})
public class WarehouseServiceTests {

    @Autowired
    private  WarehouseRepository warehouseRepository;

    @Autowired
    private WarehouseCompanyOrderRepository warehouseCompanyOrderRepository;

    @Autowired
    private WarehouseItemAmountRepository warehouseItemAmountRepository;

    @Autowired
    private WarehouseItemChangeHistoryRepository warehouseItemChangeHistoryRepository;

    @Autowired
    private WarehouseOrderApplicationItemRepository warehouseOrderApplicationItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    @DisplayName("입고 목록 조회용")
    public void findAllWarehouseList() {

        //given

        //when
        List<Warehouse> warehouseList = warehouseRepository.findAll();

        //then
        assertNotNull(warehouseList);
    }

    @Test
    @DisplayName("입고 상태 수정용 + 재고 변동사항 등록용 + 재고 수량 수정용")
    public void modifyStatus() {

        //given
        String status = "입고 대기";
        int warehouseNo = 1;
        int warehouseAmount = 200;

        //when
        /* 입고 정보 수정용 */
        Warehouse warehouse = warehouseRepository.findByWarehouseNo(warehouseNo);
        warehouse.setWarehouseStatus(status);
        warehouse.setWarehouseCompleteDate(new Date(System.currentTimeMillis()));

        /* 수정 후 변동 내역 table 추가용 생성 */
        WarehouseItemChangeHistory itemChangeHistory = new WarehouseItemChangeHistory();

        itemChangeHistory.setItemInfoNo(warehouse.getItemInfoNo());                 //물품 정보 불러오기
        itemChangeHistory.setItemChangeDivision(1);                                 //1 = 입고, 증가
        itemChangeHistory.setWarehouseNo(warehouse);                                //입고 정보 불러오기
        itemChangeHistory.setItemChangeAmount(warehouse.getWarehouseAmount());      //입고된 수량
        itemChangeHistory.setWarehouseStatus(warehouse.getWarehouseStatus());       //입고 완료 정보 넣어주기

        /* 추가 후 재고 관리 table 수량 수정용 */
        /* 기존의 수량[warehouseAmount] + 새로 들어온 수량[getItemChangeAmount()] 를 더해서 update */
        int amount = warehouseAmount + (itemChangeHistory.getItemChangeAmount());

        /* 재고 table 수량 수정용 생성 */
        WarehouseItemAmount itemAmountList = new WarehouseItemAmount();

        /* 수량 update 중첩 처리를 위해 위해 위에서 선언한 amount를 대입 */
        itemAmountList.setWarehouseItemInfoNo(itemChangeHistory.getItemInfoNo().getItemInfoNo());
        itemAmountList.setWarehouseItemAmount(amount);

        /* 입고 정보 수정 적용 */
        warehouseRepository.save(warehouse);
        /* 변동 내역 table 추가 적용 */
        warehouseItemChangeHistoryRepository.save(itemChangeHistory);
        /* 추가 후 재고 관리 table 수량 수정 적용 */
        warehouseItemAmountRepository.save(itemAmountList);

        //then
        assertNotNull(warehouseRepository);
        assertNotNull(warehouseItemChangeHistoryRepository);
        assertNotNull(warehouseItemAmountRepository);
    }

    @Test
    @DisplayName("발주 승인 완료 목록 조회용")
    public void findAllCompanyOrderList() {

        //given

        //when
        List<WarehouseCompanyOrderHistory> warehouseCompanyOrderList = warehouseCompanyOrderRepository.findAll();

        //then
        assertNotNull(warehouseCompanyOrderList);
    }

    @Test
    @DisplayName("발주 완료 상세 조회용")
    public void findOrderHistoryByCompanyOrderHistoryNo() {

        //given
        int companyOrderHistoryNo = 2;

        //when
        WarehouseCompanyOrderHistory orderHistory = warehouseCompanyOrderRepository.findById(companyOrderHistoryNo).get();

        //then
        assertNotNull(orderHistory);
    }

    @Test
    @DisplayName("발주 상세 목록에서 제품을 입고 목록에 등록용")
    public void registCompleteItem() {

        //given
        int completeItemInfoNo = 1;
        int orderApplicationNo = 204;
        int clientNo = 1;
        int clientContractItemNo = 1;
        int companyAmount = 200;

        //when

        Warehouse warehouse = new Warehouse();

        WarehouseItemInfo warehouseItemInfo = new WarehouseItemInfo();
        WarehouseClient warehouseClient = new WarehouseClient();

        warehouseItemInfo.setItemInfoNo(completeItemInfoNo);
        warehouseClient.setClientNo(clientNo);

//        warehouse.setWarehouseNo();                                           //Entity에 시퀀스로 된 것은 자동으로 처리돼서 기입해줄 필요 없다.
        warehouse.setItemInfoNo(warehouseItemInfo);                             //아이템 번호
        warehouse.setClientNo(warehouseClient);                                 //거래처 번호
        warehouse.setOrderApplication(orderApplicationNo);                      //본사 발주 신청서 번호
        warehouse.setClientContractItem(clientContractItemNo);                  //거래처 판매 계약 상품 번호
        warehouse.setWarehouseAmount(companyAmount);                            //입고 수량
        warehouse.setWarehouseStatus("입고 대기");                                //입고 상태
        warehouse.setWarehouseDate(new Date(System.currentTimeMillis()));       //입고 대기 일자

        /* 발주 아이템별 구분 */
        WarehouseOrderApplicationItem orderApplicationItem = new WarehouseOrderApplicationItem();

        /* pk타입에 값 대입을 위한 처리 */
        WarehouseOrderApplicationItemPK warehouseOrderApplicationItemPK = new WarehouseOrderApplicationItemPK();
        WarehouseOrderApplication warehouseOrderApplication = new WarehouseOrderApplication();
        WarehouseClientContractItem warehouseClientContractItem = new WarehouseClientContractItem();

        warehouseOrderApplication.setOrderApplicationNo(orderApplicationNo);
        warehouseClientContractItem.setClientContractItemNo(clientContractItemNo);

        /* pk타입에 대입을 하기 위해 위에서 set 사용하여 값 대입 */
        warehouseOrderApplicationItemPK.setOrderApplication(warehouseOrderApplication);
        warehouseOrderApplicationItemPK.setOrderClientContractItem(warehouseClientContractItem);

        /* 입고 목록에 추가될 시 상태가 'Y'로 변경, 입고 목록에 중복으로 추가 불가능하게 처리 */
        orderApplicationItem.setOrderApplicationItemPK(warehouseOrderApplicationItemPK);
        orderApplicationItem.setOrderApplicationItemAmount(companyAmount);
        orderApplicationItem.setOrderApplicationItemYN("Y");

        /* 입고 table 추가용 */
        warehouseRepository.save(warehouse);
        /* 상태 변경용 */
        warehouseOrderApplicationItemRepository.save(orderApplicationItem);

        //then
        assertNotNull(warehouseRepository);
        assertNotNull(warehouseOrderApplicationItemRepository);
    }

    @Test
    @DisplayName("재고 관리 목록 조회용")
    public void findAllItemAmount() {

        //given

        //when
        List<WarehouseItemAmount> warehouseItemAmount = warehouseItemAmountRepository.findAll();

        //then
        assertNotNull(warehouseItemAmount);
    }

    @Test
    @DisplayName("재고 변동 내역 조회용")
    public void findChangeHistoryByItemInfoNo() {

        //given

        //when
        List<WarehouseItemChangeHistory> changeHistory = warehouseItemChangeHistoryRepository.findAll();

        //then
        assertNotNull(changeHistory);
    }
}
