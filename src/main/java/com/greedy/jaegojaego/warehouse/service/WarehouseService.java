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

/**
 * <pre>
 * Class : WarehouseService
 * Comment : 입고 관련 Method를 모아놓은 Service입니다.
 * History
 * 2022/05/04 (석원탁) WarehouseService 기본 설정 작성
 * 2022/05/04 (석원탁) 입고 목록 조회
 * 2022/05/05 (석원탁) 본사 발주 "완료" 상태 목록 조회
 * 2022/05/08 (석원탁) 본사 발주 "완료" 물품별 상세 조회
 * 2022/05/06 (석원탁) 입고 완료 처리 시 입고 table 정보 수정
 * 2022/05/07 (석원탁) 재고 목록 조회
 * 2022/05/05 (석원탁) 본사 발주 "완료" 정보를 입고 목록에 등록
 * 2022/05/08 (석원탁) 입고 완료 처리 시 입고 table 정보 수정 + 이력 table 등록
 * 2022/05/09 (석원탁) 재고 변동 내역 정보 조회
 * 2022/05/10 (석원탁) 재고 변동 내역 정보 등록
 * 2022/05/11 (석원탁) 입고 완료 처리 시 입고 table 정보 수정 + 이력 table 등록 + 재고 수량 수정
 * </pre>
 * @version 11
 * @author 석원탁
 */
@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseCompanyOrderRepository warehouseCompanyOrderRepository;
    private final WarehouseItemAmountRepository warehouseItemAmountRepository;
    private final WarehouseItemChangeHistoryRepository warehouseItemChangeHistoryRepository;
    private final WarehouseOrderApplicationItemRepository warehouseOrderApplicationItemRepository;
    private final ModelMapper modelMapper;

    /* Repository 의존성 주입 */
    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository, WarehouseCompanyOrderRepository warehouseCompanyOrderRepository, WarehouseItemAmountRepository warehouseItemAmountRepository, WarehouseItemChangeHistoryRepository warehouseItemChangeHistoryRepository, WarehouseOrderApplicationItemRepository warehouseOrderApplicationItemRepository, ModelMapper modelMapper) {
        this.warehouseRepository = warehouseRepository;
        this.warehouseCompanyOrderRepository = warehouseCompanyOrderRepository;
        this.warehouseItemAmountRepository = warehouseItemAmountRepository;
        this.warehouseItemChangeHistoryRepository = warehouseItemChangeHistoryRepository;
        this.warehouseOrderApplicationItemRepository = warehouseOrderApplicationItemRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findAllWarehouseList : 입고 목록 조회용
     * @ return : 입고 물품 정보
     */
    public List<WarehouseDTO> findAllWarehouseList() {

        List<Warehouse> warehouseList = warehouseRepository.findAll();

        return warehouseList.stream().map(warehouse -> modelMapper.map(warehouse, WarehouseDTO.class)).collect(Collectors.toList());
    }

    /**
     * modifyStatus : 입고 상태 수정용 + 재고 변동사항 등록용 + 재고 수량 수정용
     * @ param status : view에서 요청 받은 입고 상태 정보
     * @ param warehouseNo : view에서 요청 받은 입고 번호
     * @ param warehouseAmount : view에서 요청 받은 입고 수량
     */
    public void modifyStatus(String status, int warehouseNo, int warehouseAmount) {

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
    }

    /**
     * findAllCompanyOrderList : 발주 승인 "완료" 목록 조회용
     * @ return : 본사 발주 정보
     */
    public List<WarehouseCompanyOrderHistoryDTO> findAllCompanyOrderList() {

        List<WarehouseCompanyOrderHistory> warehouseCompanyOrderList = warehouseCompanyOrderRepository.findAll(Sort.by(Sort.Direction.DESC, "companyOrderHistoryNo"));

        return warehouseCompanyOrderList.stream().map(companyOrder -> modelMapper.map(companyOrder, WarehouseCompanyOrderHistoryDTO.class)).collect(Collectors.toList());
    }

    /**
     * findOrderHistoryByCompanyOrderHistoryNo :발주 "완료" 상세 조회용
     * @ return : 본사 발주 물품별 상세 정보
     */
    public WarehouseCompanyOrderHistoryDTO findOrderHistoryByCompanyOrderHistoryNo(int companyOrderHistoryNo) {

        WarehouseCompanyOrderHistory orderHistory = warehouseCompanyOrderRepository.findById(companyOrderHistoryNo).get();

        return modelMapper.map(orderHistory, WarehouseCompanyOrderHistoryDTO.class);
    }

    /**
     * registCompleteItem : 발주 상세 목록에서 제품을 입고 목록에 등록용
     * @ param completeItemInfoNo : view에서 요청 받은 아이템 정보
     * @ param orderApplicationNo : view에서 요청 받은 발주 신청서 번호
     * @ param clientNo : view에서 요청 받은 거래처 번호
     * @ param clientContractItemNo : view에서 요청 받은 거래처 판매 계약 상품 번호
     * @ param companyAmount : view에서 요청 받은 발주 수량
     */
    @Transactional
    public void registCompleteItem(int completeItemInfoNo, int orderApplicationNo, int clientNo, int clientContractItemNo, int companyAmount) {

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
    }

    /**
     * findAllItemAmount : 재고 관리 목록 조회용
     * @ return : 재고 수량 정보
     */
    public List<WarehouseItemAmountDTO> findAllItemAmount() {

        List<WarehouseItemAmount> warehouseItemAmount = warehouseItemAmountRepository.findAll();

        return warehouseItemAmount.stream().map(warehouseItemAmountList -> modelMapper.map(warehouseItemAmountList, WarehouseItemAmountDTO.class)).collect(Collectors.toList());
    }

    /**
     * findChangeHistoryByItemInfoNo : 재고 변동 내역 조회용
     * @ return : 재고 변동 내역 정보
     */
    public List<WarehouseItemChangeHistoryDTO> findChangeHistoryByItemInfoNo() {

        List<WarehouseItemChangeHistory> changeHistory = warehouseItemChangeHistoryRepository.findAll();

        return changeHistory.stream().map(changeHistoryList -> modelMapper.map(changeHistoryList, WarehouseItemChangeHistoryDTO.class)).collect(Collectors.toList());
    }
}
