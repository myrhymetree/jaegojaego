package com.greedy.jaegojaego.outWarehouse.model.service;

import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseDetailListDTO;
import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseFranchiseOrderListDTO;
import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseListDTO;
import com.greedy.jaegojaego.outWarehouse.model.entity.*;
import com.greedy.jaegojaego.outWarehouse.model.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : OutWarehouseService
 * Comment : 출고 관련 로직을 처리하기 위한 메소드를 모아둔 Service입니다.
 * History
 * 2022/04/21 (이태준) 출고 목록 조회 로직 생성
 * 2022/04/21 (이태준) 출고 목록 조회 기능, 출고 상세조회 기능
 * 2022/04/25 (이태준) 출고 상세정보 수정 기능
 * 2022/04/27 (이태준) 출고 기능 삭제 및 재작성
 * 2022/04/30 (이태준) 출고 발주 목록 조회 기능
 * 2022/05/01 (이태준) 출고 목록 조회 기능, 출고 상세조회 기능
 * 2022/05/03 (이태준) 출고 발주 목록 조회 기능 재작성
 * 2022/05/10 (이태준) 출고 발주 목록 조회 기능
 * 2022/05/11 (이태준) 출고 데이터 삽입 기능, 가맹점 발주상태 수정 기능
 * 2022/05/12 (이태준) 출고 데이터 수정 기능
 * </pre>
 * @version 1.1
 * @author 이태준
 * */
@Service
public class OutWarehouseService {

    private final OutWarehouseRepository outWarehouseRepository;
    private final OutWarehouseDetailRespository outWarehouseDetailRespository;
    private final OutWarehouseFranchiseOrderRepository outWarehouseFranchiseOrderRepository;
    private final OutWarehouseMemberRepository outWarehouseMemberRepository;
    private final OutWarehouseFranchiseInfoRepository outWarehouseFranchiseInfoRepository;
    private final OutWarehouseFranchiseAccountRepository outWarehouseFranchiseAccountRepository;
    private final OutWarehouseFranchiseOrderItemRepository outWarehouseFranchiseOrderItemRepository;
    private final OutWarehouseItemAmountRepository outWarehouseItemAmountRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OutWarehouseService(OutWarehouseRepository outWarehouseRepository, OutWarehouseFranchiseOrderRepository outWarehouseFranchiseOrderRepository,
                               OutWarehouseMemberRepository outWarehouseMemberRepository, OutWarehouseFranchiseInfoRepository outWarehouseFranchiseInfoRepository,
                               OutWarehouseFranchiseAccountRepository outWarehouseFranchiseAccountRepository, OutWarehouseDetailRespository outWarehouseDetailRespository,
                               OutWarehouseFranchiseOrderItemRepository outWarehouseFranchiseOrderItemRepository, OutWarehouseItemAmountRepository outWarehouseItemAmountRepository,
                               ModelMapper modelMapper) {
        this.outWarehouseRepository = outWarehouseRepository;
        this.outWarehouseDetailRespository = outWarehouseDetailRespository;
        this.outWarehouseFranchiseOrderRepository = outWarehouseFranchiseOrderRepository;
        this.outWarehouseMemberRepository = outWarehouseMemberRepository;
        this.outWarehouseFranchiseInfoRepository = outWarehouseFranchiseInfoRepository;
        this.outWarehouseFranchiseAccountRepository = outWarehouseFranchiseAccountRepository;
        this.outWarehouseFranchiseOrderItemRepository = outWarehouseFranchiseOrderItemRepository;
        this.outWarehouseItemAmountRepository = outWarehouseItemAmountRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findOutWarehouseList : 출고 목록 조회
     * @return : 출고 목록 리스트
     */
    @Transactional
    public List<OutWarehouseListDTO> findOutWarehouseList() {

        List<OutWarehouse> outWarehouseList = outWarehouseRepository.findAll();

        return outWarehouseList.stream().map(outWarehouse -> modelMapper.map(outWarehouse, OutWarehouseListDTO.class)).collect(Collectors.toList());
    }

    /**
     * findAllOrderList : 승인 완료된 가맹점 발주 목록 조회
     * @return : 승인 완료된 가맹점 발주 목록
     */
    @Transactional
    public List<OutWarehouseFranchiseOrderListDTO> findAllOrderList() {

        String franchiseOrderStatus = "COMPLETE";

        List<OutWarehouseFranchiseOrder> outWarehouseFranchiseOrderList = outWarehouseFranchiseOrderRepository.getFranchiseOrderListByStatus(franchiseOrderStatus);
        List<OutWarehouseFranchiseOrderListDTO> list = new ArrayList<>();

        for(int i = 0; i < outWarehouseFranchiseOrderList.size(); i++) {
            OutWarehouseFranchiseOrderListDTO dto = new OutWarehouseFranchiseOrderListDTO();
            dto.setFranchiseOrderNo(outWarehouseFranchiseOrderList.get(i).getFranchiseOrderNo());
            dto.setMemberNo((outWarehouseFranchiseOrderList.get(i).getMemberNo().getMemberNo()));

            int memberNo = dto.getMemberNo();

            OutWarehouseMember memberInfo = outWarehouseMemberRepository.getMemberInfo(memberNo);

            if("가맹점".equals(memberInfo.getMemberDivision()) && "대표자".equals(memberInfo.getOfficeDivision())) {
                dto.setFranchiseRepresentativeNo(memberNo);

                OutWarehouseFranchiseInfoPk pkParam = new OutWarehouseFranchiseInfoPk();
                pkParam.setFranchiseRepresentativeNo(memberInfo);

                OutWarehouseFranchiseInfo franchiseInfo = outWarehouseFranchiseInfoRepository.getFranchiseInfo(pkParam);

                dto.setFranchiseName(franchiseInfo.getFranchiseName());
                dto.setFranchiseAddress(franchiseInfo.getFranchiseAddress());
            } else if("가맹점".equals(memberInfo.getMemberDivision()) && "직원".equals(memberInfo.getOfficeDivision())) {
                OutWarehouseFranchiseAccountPk accountPkParam = new OutWarehouseFranchiseAccountPk();
                accountPkParam.setFranchiseManagerNo(memberInfo);

                OutWarehouseFranchiseAccount franchiseAccountInfo = outWarehouseFranchiseAccountRepository.getRepresentativeNo(accountPkParam);
                dto.setFranchiseName(franchiseAccountInfo.getFranchiseRepresentativeNo().getFranchiseName());
                dto.setFranchiseAddress(franchiseAccountInfo.getFranchiseRepresentativeNo().getFranchiseAddress());
                dto.setFranchiseRepresentativeNo(franchiseAccountInfo.getFranchiseRepresentativeNo().getFranchiseRepresentativeNo().getFranchiseRepresentativeNo().getMemberNo());
            }

            list.add(dto);
        }

        return list;
    }

    /**
     * insertOrderData : 출고 테이블에 출고할 발주 데이터 삽입
     * @param orderNums : 발주 번호 리스트
     * @param representativeNums : 발주 신청 가맹점 대표 번호 리스트
     * @param today : 처리상태 변경 날짜
     */
    @Transactional
    public void insertOrderData(List<Integer> orderNums, List<Integer> representativeNums, Date today) {

        OutWarehouse orderInfo = null;

        for(int i = 0; i < orderNums.size(); i++) {
            orderInfo = new OutWarehouse();
            OutWarehouseFranchiseOrder franchiseOrderInfo = outWarehouseFranchiseOrderRepository.findByFranchiseOrderNo(orderNums.get(i));

            OutWarehouseFranchiseInfoPk franchiseInfoPk = new OutWarehouseFranchiseInfoPk();
            OutWarehouseMember memberInfo = outWarehouseMemberRepository.findByMemberNo(representativeNums.get(i));
            franchiseInfoPk.setFranchiseRepresentativeNo(memberInfo);

            OutWarehouseFranchiseInfo franchiseInfo = outWarehouseFranchiseInfoRepository.findByFranchiseRepresentativeNo(franchiseInfoPk);

            orderInfo.setFranchiseOrderNo(franchiseOrderInfo);
            orderInfo.setFranchiseRepresentativNo(franchiseInfo);
            orderInfo.setOutWarehouseWorkingFinishedDate(today);
            orderInfo.setOutWarehouseWorkingStatusName("출고대기");

            franchiseOrderInfo.setFranchiseOrderOutYn("Y");

            outWarehouseRepository.save(orderInfo);
            outWarehouseFranchiseOrderRepository.save(franchiseOrderInfo);
        }
    }

    /**
     * findOutItemsList
     * @param outWarehouseNo : 출고번호
     * @return : 발주 목록에 담긴 발주 요청 제품 정보 리스트
     */
    @Transactional
    public List<OutWarehouseDetailListDTO> findOutItemsList(int outWarehouseNo) {

        List<OutWarehouseFranchiseOrderItem> outWarehouseOrderItemList = outWarehouseDetailRespository.findAllFranchiseOrderItemList(outWarehouseNo);
        OutWarehouse outWarehouseInfo = outWarehouseRepository.findByOutWarehouseNo(outWarehouseNo);

        List<OutWarehouseDetailListDTO> outWarehouseDetailList = new ArrayList<>();

        for(int i = 0; i < outWarehouseOrderItemList.size(); i++) {
            OutWarehouseDetailListDTO dto = new OutWarehouseDetailListDTO();

            dto.setOutWarehouseNo(outWarehouseNo);
            dto.setOutWarehouseItemNo(outWarehouseOrderItemList.get(i).getFranchiseOrderItemPk().getItemInfoNo().getItemInfoNo());
            dto.setItemInfoItemSerialNo(outWarehouseOrderItemList.get(i).getFranchiseOrderItemPk().getItemInfoNo().getItemSerialNo());
            dto.setItemInfoName(outWarehouseOrderItemList.get(i).getFranchiseOrderItemPk().getItemInfoNo().getItemInfoName());
            dto.setMaterialCategoryName(outWarehouseOrderItemList.get(i).getFranchiseOrderItemPk().getItemInfoNo().getMaterialCategoryNo().getMaterialCategoryName());
            dto.setOutWarehouseItemAmount(outWarehouseOrderItemList.get(i).getFranchiseOrderitemAmount());
            dto.setOutWarehouseWorkingStatusName(outWarehouseInfo.getOutWarehouseWorkingStatusName());
            dto.setOutWarehouseWorkingFinishedDate(outWarehouseInfo.getOutWarehouseWorkingFinishedDate());

            outWarehouseDetailList.add(dto);
        }

        return outWarehouseDetailList;
    }

    /**
     * modifyStatus : 출고 처리상태 및 재고량 데이터 수정, 재고변경이력 테이블 데이터 삽입
     * @param status : 수정 할 출고 처리상태 데이터
     * @param outWarehouseNo : 출고번호
     */
    @Transactional
    public void modifyStatus(String status, int outWarehouseNo) {

        Date finishedDate = new java.sql.Date(System.currentTimeMillis());

        OutWarehouse outWarehouse = outWarehouseRepository.findByOutWarehouseNo(outWarehouseNo);
        outWarehouse.setOutWarehouseWorkingStatusName(status);
        outWarehouse.setOutWarehouseWorkingFinishedDate(finishedDate);

        int franchiseOrderNo = outWarehouse.getFranchiseOrderNo().getFranchiseOrderNo();
        OutWarehouseFranchiseOrder franchiseOrderInfo = outWarehouseFranchiseOrderRepository.findByFranchiseOrderNo(franchiseOrderNo);
        franchiseOrderInfo.setFranchiseOrderOutYn("Y");

        outWarehouseRepository.save(outWarehouse);
        outWarehouseFranchiseOrderRepository.save(franchiseOrderInfo);

        OutWarehouseFranchiseOrderItemPk outWarehouseFranchiseOrderItemPk = new OutWarehouseFranchiseOrderItemPk();
        outWarehouseFranchiseOrderItemPk.setFranchiseOrderNo(franchiseOrderInfo);

        List<OutWarehouseFranchiseOrderItem> outWarehouseFranchiseOrderItemList = outWarehouseFranchiseOrderItemRepository.findByFranchiseOrderItemPk(franchiseOrderNo);

        for(int i = 0; i < outWarehouseFranchiseOrderItemList.size(); i++) {
            int itemOutAmount = outWarehouseFranchiseOrderItemList.get(i).getFranchiseOrderitemAmount();
            int updatedAmount = 0;

            OutWarehouseItemAmountPk outWarehouseItemAmountPk = new OutWarehouseItemAmountPk();
            outWarehouseItemAmountPk.setItemInfoNo(outWarehouseFranchiseOrderItemList.get(i).getFranchiseOrderItemPk().getItemInfoNo());
            OutWarehouseItemAmount outWarehouseItemAmount = outWarehouseItemAmountRepository.findByItemInfoNo(outWarehouseItemAmountPk);

            int totalAmount = outWarehouseItemAmount.getItemTotalAmount();
            updatedAmount = totalAmount - itemOutAmount;

            if(updatedAmount <= 0) {
                updatedAmount = 0;
            }

            outWarehouseItemAmount.setItemTotalAmount(updatedAmount);
            outWarehouseItemAmountRepository.save(outWarehouseItemAmount);


        }
    }
}
