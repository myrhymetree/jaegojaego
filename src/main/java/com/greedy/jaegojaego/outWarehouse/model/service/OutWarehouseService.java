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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : OutWarehouseService
 * Comment : 출고 관련 로직을 처리하기 위한 메소드를 모아둔 Service입니다.
 * History
 * 2022/04/21 (이태준) 처음 작성
 * 2022/04/21 (이태준) 출고 목록 조회 기능, 출고 상세조회 기능
 * 2022/04/25 (이태준) 출고 상세정보 수정 기능
 * 2022/04/27 (이태준) 출고 기능 삭제 및 재작성
 * 2022/04/30 (이태준) 출고 발주 목록 조회 기능
 * 2022/05/01 (이태준) 출고 목록 조회 기능, 출고 상세조회 기능
 * 2022/05/03 (이태준) 출고 발주 목록 조회 기능 재작성
 * 2022/05/10 (이태준) 출고 발주 목록 조회 기능
 * 2022/05/11 (이태준) 출고 데이터 삽입 기능, 가맹점 발주상태 수정 기능
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
    private final ModelMapper modelMapper;

    @Autowired
    public OutWarehouseService(OutWarehouseRepository outWarehouseRepository, OutWarehouseFranchiseOrderRepository outWarehouseFranchiseOrderRepository,
                               OutWarehouseMemberRepository outWarehouseMemberRepository, OutWarehouseFranchiseInfoRepository outWarehouseFranchiseInfoRepository,
                               OutWarehouseFranchiseAccountRepository outWarehouseFranchiseAccountRepository, OutWarehouseDetailRespository outWarehouseDetailRespository,
                               OutWarehouseFranchiseOrderItemRepository outWarehouseFranchiseOrderItemRepository, ModelMapper modelMapper) {
        this.outWarehouseRepository = outWarehouseRepository;
        this.outWarehouseDetailRespository = outWarehouseDetailRespository;
        this.outWarehouseFranchiseOrderRepository = outWarehouseFranchiseOrderRepository;
        this.outWarehouseMemberRepository = outWarehouseMemberRepository;
        this.outWarehouseFranchiseInfoRepository = outWarehouseFranchiseInfoRepository;
        this.outWarehouseFranchiseAccountRepository = outWarehouseFranchiseAccountRepository;
        this.outWarehouseFranchiseOrderItemRepository = outWarehouseFranchiseOrderItemRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * @return 출고 목록 리스트
     */
    @Transactional
    public List<OutWarehouseListDTO> findOutWarehouseList() {

//        modelMapper.getConfiguration().setAmbiguityIgnored(true);
//        List<OutWarehouse> outWarehouseList = outWarehouseRepository.findOutWarehouseList();
//
//        return outWarehouseList.stream().map(outWarehouse -> modelMapper.map(outWarehouse, OutWarehouseListDTO.class)).collect(Collectors.toList());

        List<OutWarehouse> outWarehouseList = outWarehouseRepository.findAll();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(outWarehouseList);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@");

        return outWarehouseList.stream().map(outWarehouse -> modelMapper.map(outWarehouse, OutWarehouseListDTO.class)).collect(Collectors.toList());
    }

    /**
     * @return
     */
    @Transactional
    public List<OutWarehouseFranchiseOrderListDTO> findAllOrderList() {

        String franchiseOrderStatus = "COMPLETE";

        List<OutWarehouseFranchiseOrder> outWarehouseFranchiseOrderList = outWarehouseFranchiseOrderRepository.getFranchiseOrderListByStatus(franchiseOrderStatus);
//        outWarehouseFranchiseOrderList.forEach(System.out::println);
        List<OutWarehouseFranchiseOrderListDTO> list = new ArrayList<>();

        for(int i = 0; i < outWarehouseFranchiseOrderList.size(); i++) {
            OutWarehouseFranchiseOrderListDTO dto = new OutWarehouseFranchiseOrderListDTO();
            dto.setFranchiseOrderNo(outWarehouseFranchiseOrderList.get(i).getFranchiseOrderNo());
            dto.setMemberNo((outWarehouseFranchiseOrderList.get(i).getMemberNo().getMemberNo()));

//            list.add(dto);
            int memberNo = dto.getMemberNo();

            OutWarehouseMember memberInfo = outWarehouseMemberRepository.getMemberInfo(memberNo);

//            System.out.println("memberInfo : " + memberInfo);
//            System.out.println(memberInfo.getMemberDivision());
//            System.out.println(memberInfo.getMemberDivision().getClass().getName());
//            System.out.println(memberInfo.getOfficeDivision());
//            System.out.println(memberInfo.getOfficeDivision().getClass().getName());

            if("가맹점".equals(memberInfo.getMemberDivision()) && "대표자".equals(memberInfo.getOfficeDivision())) {
//                System.out.println("여긴오니????????????????");
                dto.setFranchiseRepresentativeNo(memberNo);

                OutWarehouseFranchiseInfoPk pkParam = new OutWarehouseFranchiseInfoPk();
                pkParam.setFranchiseRepresentativeNo(memberInfo);

                OutWarehouseFranchiseInfo franchiseInfo = outWarehouseFranchiseInfoRepository.getFranchiseInfo(pkParam);

//                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//                System.out.println(franchiseInfo);
//                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

                dto.setFranchiseName(franchiseInfo.getFranchiseName());
                dto.setFranchiseAddress(franchiseInfo.getFranchiseAddress());

//                System.out.println("????????????????????????");
//                System.out.println(dto);
//                System.out.println("????????????????????????");
            } else if("가맹점".equals(memberInfo.getMemberDivision()) && "직원".equals(memberInfo.getOfficeDivision())) {
//                System.out.println("이쪽도 와??????????????????");

                OutWarehouseFranchiseAccountPk accountPkParam = new OutWarehouseFranchiseAccountPk();
                accountPkParam.setFranchiseManagerNo(memberInfo);

                OutWarehouseFranchiseAccount franchiseAccountInfo = outWarehouseFranchiseAccountRepository.getRepresentativeNo(accountPkParam);
                dto.setFranchiseName(franchiseAccountInfo.getFranchiseRepresentativeNo().getFranchiseName());
                dto.setFranchiseAddress(franchiseAccountInfo.getFranchiseRepresentativeNo().getFranchiseAddress());
                dto.setFranchiseRepresentativeNo(franchiseAccountInfo.getFranchiseRepresentativeNo().getFranchiseRepresentativeNo().getFranchiseRepresentativeNo().getMemberNo());

//                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
//                System.out.println(dto);
//                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            }

            list.add(dto);
        }

//        List<OutWarehouseFranchiseOrder> outWarehouseFranchiseOrderList = outWarehouseFranchiseOrderRepository.findAllFranchiseOrderList();

//        return outWarehouseFranchiseOrderList.stream().map(outWarehouseFranchiseOrder -> modelMapper.map(outWarehouseFranchiseOrder, OutWarehouseFranchiseOrderListDTO.class)).collect(Collectors.toList());
        return list;
    }

    /**
     * @param orderNums
     * @param representativeNums
     * @param today
     */
    @Transactional
    public void insertOrderData(List<Integer> orderNums, List<Integer> representativeNums, Date today) {

//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        System.out.println("orderNums from Service : " + orderNums);
//        System.out.println("representativeNums from Service : " +representativeNums);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        OutWarehouse orderInfo = null;

        for(int i = 0; i < orderNums.size(); i++) {
            orderInfo = new OutWarehouse();
            OutWarehouseFranchiseOrder franchiseOrderInfo = outWarehouseFranchiseOrderRepository.findByFranchiseOrderNo(orderNums.get(i));

            OutWarehouseFranchiseInfoPk franchiseInfoPk = new OutWarehouseFranchiseInfoPk();
            OutWarehouseMember memberInfo = outWarehouseMemberRepository.findByMemberNo(representativeNums.get(i));
            franchiseInfoPk.setFranchiseRepresentativeNo(memberInfo);

            OutWarehouseFranchiseInfo franchiseInfo = outWarehouseFranchiseInfoRepository.findByFranchiseRepresentativeNo(franchiseInfoPk);
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!");
//            System.out.println("franchiseOrderInfo from Service : " + franchiseOrderInfo);
//            System.out.println("franchiseInfo from Service : " + franchiseInfo);
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!");

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
     * @param outWarehouseNo
     * @return
     */
    @Transactional
    public List<OutWarehouseDetailListDTO> findOutItemsList(int outWarehouseNo) {

////        modelMapper.getConfiguration().setAmbiguityIgnored(true);
//        List<OutWarehouseItem> outWarehouseItemList = outWarehouseDetailRespository.findByOutWarehouseNo(outWarehouseNo);
//        List<OutWarehouseDetailListDTO> outWarehouseDetailList = new ArrayList<>();
//
////        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
////        outWarehouseItemList.forEach(System.out::println);
////        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//
//        for(int i = 0; i < outWarehouseItemList.size(); i++) {
//            OutWarehouseDetailListDTO outWarehouseDetail = new OutWarehouseDetailListDTO();
//            outWarehouseDetail.setOutWarehouseItemNo(outWarehouseItemList.get(i).getOutWarehouseItemNo());
//            outWarehouseDetail.setOutWarehouseNo((outWarehouseItemList.get(i).getOutWarehouseNo().getOutWarehouseNo()));
//            outWarehouseDetail.setItemInfoItemSerialNo(outWarehouseItemList.get(i).getItemWarehouseNo().getItemInfoNo().getItemInfoItemSerialNo());
//            outWarehouseDetail.setMaterialCategoryName(outWarehouseItemList.get(i).getItemWarehouseNo().getItemInfoNo().getMaterialCategoryNo().getMaterialCategoryName());
//            outWarehouseDetail.setItemInfoName(outWarehouseItemList.get(i).getItemWarehouseNo().getItemInfoNo().getItemInfoName());
//            outWarehouseDetail.setOutWarehouseItemAmount(outWarehouseItemList.get(i).getOutWarehouseItemAmount());
//            outWarehouseDetail.setFranchiseName(outWarehouseItemList.get(i).getOutWarehouseNo().getFranchiseRepresentativeNo().getFranchiseBranchName());
//            outWarehouseDetail.setFranchiseAddress(outWarehouseItemList.get(i).getOutWarehouseNo().getFranchiseRepresentativeNo().getFranchiseAddress());
//            outWarehouseDetail.setOutWarehouseWorkingStatusName(outWarehouseItemList.get(i).getOutWarehouseNo().getOutWarehouseWorkingStatusName());
//            outWarehouseDetail.setOutWarehouseWorkingFinishedDate(outWarehouseItemList.get(i).getOutWarehouseNo().getOutWarehouseWorkingFinishedDate());
//
//            outWarehouseDetailList.add(outWarehouseDetail);
//        }
//
//        return outWarehouseDetailList;

        List<OutWarehouseFranchiseOrderItem> outWarehouseOrderItemList = outWarehouseDetailRespository.findAllFranchiseOrderItemList(outWarehouseNo);
        int franchiseOrderNo;
//        int memberNo;
        OutWarehouse outWarehouseInfo = outWarehouseRepository.findByOutWarehouseNo(outWarehouseNo);

//        System.out.println("^^^^^^^^^^^^^^^^^^^^^^");
//        outWarehouseOrderItemList.forEach(
//                System.out::println
//        );
//        System.out.println("^^^^^^^^^^^^^^^^^^^^^^");

        List<OutWarehouseDetailListDTO> outWarehouseDetailList = new ArrayList<>();

        for(int i = 0; i < outWarehouseOrderItemList.size(); i++) {
            OutWarehouseDetailListDTO dto = new OutWarehouseDetailListDTO();
            franchiseOrderNo = outWarehouseOrderItemList.get(i).getFranchiseOrderItemPk().getFranchiseOrderNo().getFranchiseOrderNo();
            OutWarehouseFranchiseOrder franchiseOrderInfo = outWarehouseFranchiseOrderRepository.findByFranchiseOrderNo(franchiseOrderNo);
//            memberNo = franchiseOrderInfo.getMemberNo().getMemberNo();

            dto.setOutWarehouseNo(outWarehouseNo);
            dto.setOutWarehouseItemNo(outWarehouseOrderItemList.get(i).getFranchiseOrderItemPk().getItemInfoNo().getItemInfoNo());
            dto.setItemInfoItemSerialNo(outWarehouseOrderItemList.get(i).getFranchiseOrderItemPk().getItemInfoNo().getItemInfoSerialNo());
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
     * @param status
     * @param outWarehouseNo
     */
    @Transactional
    public void modifyStatus(String status, int outWarehouseNo) {

        Date finishedDate = new java.sql.Date(System.currentTimeMillis());
//        System.out.println("^v^v^v^v^v^v^v^v^v^v^v^v^v^v");
//        System.out.println(finishedDate);
//        System.out.println("^v^v^v^v^v^v^v^v^v^v^v^v^v^v");

        OutWarehouse outWarehouse = outWarehouseRepository.findByOutWarehouseNo(outWarehouseNo);
        outWarehouse.setOutWarehouseWorkingStatusName(status);
        outWarehouse.setOutWarehouseWorkingFinishedDate(finishedDate);

        int franchiseOrderNo = outWarehouse.getFranchiseOrderNo().getFranchiseOrderNo();
        OutWarehouseFranchiseOrder franchiseOrderInfo = outWarehouseFranchiseOrderRepository.findByFranchiseOrderNo(franchiseOrderNo);
        franchiseOrderInfo.setFranchiseOrderOutYn("Y");



        outWarehouseRepository.save(outWarehouse);
        outWarehouseFranchiseOrderRepository.save(franchiseOrderInfo);
    }
}
