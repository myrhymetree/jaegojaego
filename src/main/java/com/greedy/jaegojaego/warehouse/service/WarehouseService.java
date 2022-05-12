package com.greedy.jaegojaego.warehouse.service;

import com.greedy.jaegojaego.warehouse.dto.*;
import com.greedy.jaegojaego.warehouse.entity.*;
import com.greedy.jaegojaego.warehouse.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseCompanyOrderRepository warehouseCompanyOrderRepository;
    private final WarehouseItemAmountRepository warehouseItemAmountRepository;
    private final WarehouseItemChangeHistoryRepository warehouseItemChangeHistoryRepository;
    private final WarehouseOrderApplicationRepository warehouseOrderApplicationRepository;
    private final WarehouseOrderApplicationItemRepository warehouseOrderApplicationItemRepository;
    private final ModelMapper modelMapper;

    /* Repository 의존성 주입 */
    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository, WarehouseCompanyOrderRepository warehouseCompanyOrderRepository, WarehouseItemAmountRepository warehouseItemAmountRepository, WarehouseItemChangeHistoryRepository warehouseItemChangeHistoryRepository, WarehouseOrderApplicationRepository warehouseOrderApplicationRepository, WarehouseOrderApplicationItemRepository warehouseOrderApplicationItemRepository, ModelMapper modelMapper) {
        this.warehouseRepository = warehouseRepository;
        this.warehouseCompanyOrderRepository = warehouseCompanyOrderRepository;
        this.warehouseItemAmountRepository = warehouseItemAmountRepository;
        this.warehouseItemChangeHistoryRepository = warehouseItemChangeHistoryRepository;
        this.warehouseOrderApplicationRepository = warehouseOrderApplicationRepository;
        this.warehouseOrderApplicationItemRepository = warehouseOrderApplicationItemRepository;
        this.modelMapper = modelMapper;
    }

    /** 입고 목록 조회용  */
    public List<WarehouseDTO> findAllWarehouseList() {

        List<Warehouse> warehouseList = warehouseRepository.findAll();

        return warehouseList.stream().map(warehouse -> modelMapper.map(warehouse, WarehouseDTO.class)).collect(Collectors.toList());
    }

    /** 입고 상태 수정용 + 재고 변동사항 등록용 + 재고 수량 수정용 */
    public void modifyStatus(String status, int warehouseNo, int warehouseAmount) {

        /* 입고 정보 수정용 */
        Warehouse warehouse = warehouseRepository.findByWarehouseNo(warehouseNo);
        warehouse.setWarehouseStatus(status);
        warehouse.setWarehouseCompleteDate(new Date(System.currentTimeMillis()));

        /* 수정 후 변동 내역 table 추가용 */
        WarehouseItemChangeHistory itemChangeHistory = new WarehouseItemChangeHistory();

        itemChangeHistory.setItemInfoNo(warehouse.getItemInfoNo());                 //물품 정보 불러오기
        itemChangeHistory.setItemChangeDivision(1);                                 //1 = 입고, 증가
        itemChangeHistory.setWarehouseNo(warehouse);                                //입고 정보 불러오기
        itemChangeHistory.setItemChangeAmount(warehouse.getWarehouseAmount());      //입고된 수량
        itemChangeHistory.setWarehouseStatus(warehouse.getWarehouseStatus());       //입고 완료 정보 넣어주기
//        itemChangeHistory.setItemDecrementReasonNo();                             //감소 사유 아직 필요 x
//        itemChangeHistory.setOutWarehouseDivisionNo();                            //출고 번호 구분 필요 x

        /* 추가 후 재고 관리 table 수량 수정용 */

        int amount = warehouseAmount + (itemChangeHistory.getItemChangeAmount());

        WarehouseItemAmount itemAmountList = new WarehouseItemAmount();

        itemAmountList.setWarehouseItemInfoNo(itemChangeHistory.getItemInfoNo().getItemInfoNo());
        itemAmountList.setWarehouseItemAmount(amount);

        /* 입고 정보 수정 적용 */
        warehouseRepository.save(warehouse);
        /* 변동 내역 table 추가 적용 */
        warehouseItemChangeHistoryRepository.save(itemChangeHistory);
        /* 추가 후 재고 관리 table 수량 수정 적용 */
        warehouseItemAmountRepository.save(itemAmountList);
    }

    /** 발주 승인 "완료" 목록 조회용 */
    public List<WarehouseCompanyOrderHistoryDTO> selectCompanyOrderList() {

        List<WarehouseCompanyOrderHistory> warehouseCompanyOrderList = warehouseCompanyOrderRepository.findAll(Sort.by(Sort.Direction.DESC, "companyOrderHistoryNo"));

        return warehouseCompanyOrderList.stream().map(companyOrder -> modelMapper.map(companyOrder, WarehouseCompanyOrderHistoryDTO.class)).collect(Collectors.toList());
    }

    /** 발주 "완료" 상세 조회용 */
    public WarehouseCompanyOrderHistoryDTO findOrderHistoryByCompanyOrderHistoryNo(int companyOrderHistoryNo) {

        WarehouseCompanyOrderHistory orderHistory = warehouseCompanyOrderRepository.findById(companyOrderHistoryNo).get();

        return modelMapper.map(orderHistory, WarehouseCompanyOrderHistoryDTO.class);
    }

    /** 발주 상세 목록에서 제품을 입고 목록에 등록용 */
    @Transactional
    public void registCompleteItem(int completeItemInfoNo, int orderApplicationNo, int clientNo, int clientContractItemNo, int companyAmount) {

        Warehouse warehouse = new Warehouse();

        WarehouseItemInfo warehouseItemInfo = new WarehouseItemInfo();
        WarehouseClient warehouseClient = new WarehouseClient();

        warehouseItemInfo.setItemInfoNo(completeItemInfoNo);
        warehouseClient.setClientNo(clientNo);

        System.out.println("====================================================================================");
        System.out.println("service warehouseClient = " + warehouseClient);
        System.out.println("====================================================================================");

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

        /* pk 묶음 */
        WarehouseOrderApplicationItemPK warehouseOrderApplicationItemPK = new WarehouseOrderApplicationItemPK();
        /* pk1 */
        WarehouseOrderApplication warehouseOrderApplication = new WarehouseOrderApplication();
        /* pk2 */
        WarehouseClientContractItem warehouseClientContractItem = new WarehouseClientContractItem();

        warehouseOrderApplication.setOrderApplicationNo(orderApplicationNo);
        warehouseClientContractItem.setClientContractItemNo(clientContractItemNo);

        warehouseOrderApplicationItemPK.setOrderApplication(warehouseOrderApplication);
        warehouseOrderApplicationItemPK.setOrderClientContractItem(warehouseClientContractItem);

        orderApplicationItem.setOrderApplicationItemPK(warehouseOrderApplicationItemPK);
        orderApplicationItem.setOrderApplicationItemAmount(companyAmount);
        orderApplicationItem.setOrderApplicationItemYN("Y");

        /* 입고 table 추가용 */
        warehouseRepository.save(warehouse);
        /* 상태 변경용 */
        warehouseOrderApplicationItemRepository.save(orderApplicationItem);
    }


    /** 재고 관리 목록 조회용 */
    public List<WarehouseItemAmountDTO> findAllItemAmount() {

        List<WarehouseItemAmount> warehouseItemAmount = warehouseItemAmountRepository.findAll();

        return warehouseItemAmount.stream().map(warehouseItemAmountList -> modelMapper.map(warehouseItemAmountList, WarehouseItemAmountDTO.class)).collect(Collectors.toList());
    }

    /** 재고 관리 상세 조회용 */
    public List<WarehouseItemChangeHistoryDTO> findChangeHistoryByItemInfoNo() {

        List<WarehouseItemChangeHistory> changeHistory = warehouseItemChangeHistoryRepository.findAll();

        return changeHistory.stream().map(changeHistoryList -> modelMapper.map(changeHistoryList, WarehouseItemChangeHistoryDTO.class)).collect(Collectors.toList());
    }
}
