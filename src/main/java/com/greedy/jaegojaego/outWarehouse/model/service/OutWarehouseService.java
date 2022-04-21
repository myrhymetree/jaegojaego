package com.greedy.jaegojaego.outWarehouse.model.service;

import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseDetailListDTO;
import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseListDTO;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouse;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseFranchiseInfo;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouseItem;
import com.greedy.jaegojaego.outWarehouse.model.repository.OutWarehouseDetailRespository;
import com.greedy.jaegojaego.outWarehouse.model.repository.OutWarehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private final OutWarehouseDetailRespository outWarehouseDetailRespository;
    private final ModelMapper modelMapper;

    @Autowired
    public OutWarehouseService(OutWarehouseRepository outWarehouseRepository, OutWarehouseDetailRespository outWarehouseDetailRespository, ModelMapper modelMapper) {
        this.outWarehouseRepository = outWarehouseRepository;
        this.outWarehouseDetailRespository = outWarehouseDetailRespository;
        this.modelMapper = modelMapper;
    }

    /**
     * @return
     */
    @Transactional
    public List<OutWarehouseListDTO> findOutWarehouseList() {

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        List<OutWarehouse> outWarehouseList = outWarehouseRepository.findOutWarehouseList();

        return outWarehouseList.stream().map(outWarehouse -> modelMapper.map(outWarehouse, OutWarehouseListDTO.class)).collect(Collectors.toList());
    }

    /**
     * @param outWarehouseNo
     * @return
     */
    @Transactional
    public List<OutWarehouseDetailListDTO> findOutItemsList(int outWarehouseNo) {

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        List<OutWarehouseItem> outWarehouseItemList = outWarehouseDetailRespository.findByOutWarehouseNo(outWarehouseNo);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        outWarehouseItemList.forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        return outWarehouseItemList.stream().map(outWarehouseItem -> modelMapper.map(outWarehouseItem, OutWarehouseDetailListDTO.class)).collect(Collectors.toList());
    }
}
