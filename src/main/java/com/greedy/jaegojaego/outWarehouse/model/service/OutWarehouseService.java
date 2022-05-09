package com.greedy.jaegojaego.outWarehouse.model.service;

import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseFranchiseOrderListDTO;
import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseListDTO;
import com.greedy.jaegojaego.outWarehouse.model.entity.*;
import com.greedy.jaegojaego.outWarehouse.model.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 * <pre>
 * Class : OutWarehouseService
 * History
 * 2022/04/21 (이태준) 처음 작성
 * 2022/04/21 (이태준) 출고 목록 조회 기능, 출고 상세조회 기능
 * </pre>
 * @version 1
 * @author 이태준
 * */
@Service
public class OutWarehouseService {

    private final OutWarehouseRepository outWarehouseRepository;
    //    private final OutWarehouseDetailRespository outWarehouseDetailRespository;
    private final OutWarehouseFranchiseOrderRepository outWarehouseFranchiseOrderRepository;
    private final OutWarehouseMemberRepository outWarehouseMemberRepository;
    private final OutWarehouseFranchiseInfoRepository outWarehouseFranchiseInfoRepository;
    private final OutWarehouseFranchiseAccountRepository outWarehouseFranchiseAccountRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OutWarehouseService(OutWarehouseRepository outWarehouseRepository, OutWarehouseFranchiseOrderRepository outWarehouseFranchiseOrderRepository,
                               OutWarehouseMemberRepository outWarehouseMemberRepository, OutWarehouseFranchiseInfoRepository outWarehouseFranchiseInfoRepository,
                               OutWarehouseFranchiseAccountRepository outWarehouseFranchiseAccountRepository, ModelMapper modelMapper) {
        this.outWarehouseRepository = outWarehouseRepository;
//        this.outWarehouseDetailRespository = outWarehouseDetailRespository;
        this.outWarehouseFranchiseOrderRepository = outWarehouseFranchiseOrderRepository;
        this.outWarehouseMemberRepository = outWarehouseMemberRepository;
        this.outWarehouseFranchiseInfoRepository = outWarehouseFranchiseInfoRepository;
        this.outWarehouseFranchiseAccountRepository = outWarehouseFranchiseAccountRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * @return
     */
    @Transactional
    public List<OutWarehouseListDTO> findOutWarehouseList() {

//        modelMapper.getConfiguration().setAmbiguityIgnored(true);
//        List<OutWarehouse> outWarehouseList = outWarehouseRepository.findOutWarehouseList();
//
//        return outWarehouseList.stream().map(outWarehouse -> modelMapper.map(outWarehouse, OutWarehouseListDTO.class)).collect(Collectors.toList());
        return null;
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

            System.out.println("memberInfo : " + memberInfo);
//            System.out.println(memberInfo.getMemberDivision());
//            System.out.println(memberInfo.getMemberDivision().getClass().getName());
//            System.out.println(memberInfo.getOfficeDivision());
//            System.out.println(memberInfo.getOfficeDivision().getClass().getName());

            if("가맹점".equals(memberInfo.getMemberDivision()) && "대표자".equals(memberInfo.getOfficeDivision())) {
                System.out.println("여긴오니????????????????");

                OutWarehouseFranchiseInfoPk pkParam = new OutWarehouseFranchiseInfoPk();
                pkParam.setFranchiseRepresentativeNo(memberInfo);

                OutWarehouseFranchiseInfo franchiseInfo = outWarehouseFranchiseInfoRepository.getFranchiseInfo(pkParam);

                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                System.out.println(franchiseInfo);
                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

                dto.setFranchiseName(franchiseInfo.getFranchiseName());
                dto.setFranchiseAddress(franchiseInfo.getFranchiseAddress());

                System.out.println("????????????????????????");
                System.out.println(dto);
                System.out.println("????????????????????????");
            } else if("가맹점".equals(memberInfo.getMemberDivision()) && "직원".equals(memberInfo.getOfficeDivision())) {
                System.out.println("이쪽도 와??????????????????");

                OutWarehouseFranchiseAccountPk accountPkParam = new OutWarehouseFranchiseAccountPk();
                accountPkParam.setFranchiseManagerNo(memberInfo);

                OutWarehouseFranchiseAccount franchiseAccountInfo = outWarehouseFranchiseAccountRepository.getRepresentativeNo(accountPkParam);
                dto.setFranchiseName(franchiseAccountInfo.getFranchiseRepresentativeNo().getFranchiseName());
                dto.setFranchiseAddress(franchiseAccountInfo.getFranchiseRepresentativeNo().getFranchiseAddress());

                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println(dto);
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            }

            list.add(dto);
        }

//        List<OutWarehouseFranchiseOrder> outWarehouseFranchiseOrderList = outWarehouseFranchiseOrderRepository.findAllFranchiseOrderList();

//        return outWarehouseFranchiseOrderList.stream().map(outWarehouseFranchiseOrder -> modelMapper.map(outWarehouseFranchiseOrder, OutWarehouseFranchiseOrderListDTO.class)).collect(Collectors.toList());
        return list;
    }

    /**
     * @param outWarehouseNo
     * @return
     */
//    @Transactional
//    public List<OutWarehouseDetailListDTO> findOutItemsList(int outWarehouseNo) {
//
//        modelMapper.getConfiguration().setAmbiguityIgnored(true);
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
//            outWarehouseDetail.setFranchiseBranchName(outWarehouseItemList.get(i).getOutWarehouseNo().getFranchiseRepresentativeNo().getFranchiseBranchName());
//            outWarehouseDetail.setFranchiseAddress(outWarehouseItemList.get(i).getOutWarehouseNo().getFranchiseRepresentativeNo().getFranchiseAddress());
//            outWarehouseDetail.setOutWarehouseWorkingStatusName(outWarehouseItemList.get(i).getOutWarehouseNo().getOutWarehouseWorkingStatusName());
//            outWarehouseDetail.setOutWarehouseWorkingFinishedDate(outWarehouseItemList.get(i).getOutWarehouseNo().getOutWarehouseWorkingFinishedDate());
//
//            outWarehouseDetailList.add(outWarehouseDetail);
//        }
//
//        return outWarehouseDetailList;
//    }

    /**
     * @param status
     * @param outWarehouseNo
     */
//    public void modifyStatus(String status, int outWarehouseNo) {
//
//        OutWarehouse outWarehouse = outWarehouseRepository.findByOutWarehouseNo(outWarehouseNo);
//        outWarehouse.setOutWarehouseWorkingStatusName(status);
//
//        outWarehouseRepository.save(outWarehouse);
//    }
}
