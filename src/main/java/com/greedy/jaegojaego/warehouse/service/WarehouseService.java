package com.greedy.jaegojaego.warehouse.service;

import com.greedy.jaegojaego.warehouse.dto.ItemWarehouseDTO;
import com.greedy.jaegojaego.warehouse.dto.WarehouseDTO;
import com.greedy.jaegojaego.warehouse.dto.WarehouseStatusHistoryDTO;
import com.greedy.jaegojaego.warehouse.entity.ItemWarehouse;
import com.greedy.jaegojaego.warehouse.entity.Warehouse;
import com.greedy.jaegojaego.warehouse.entity.WarehouseStatusHistory;
import com.greedy.jaegojaego.warehouse.repository.ItemWarehouseRepository;
import com.greedy.jaegojaego.warehouse.repository.WarehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final ItemWarehouseRepository itemWarehouseRepository;
    private final ModelMapper modelMapper;

    /* Repository 의존성 주입 */
    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository, ItemWarehouseRepository itemwarehouseRepository, ItemWarehouseRepository itemWarehouseRepository, ModelMapper modelMapper) {
        this.warehouseRepository = warehouseRepository;
        this.itemWarehouseRepository = itemWarehouseRepository;
        this.modelMapper = modelMapper;
    }

    /* 입고, 입하 상태 모곩 조회용 */
    public List<WarehouseDTO> findAllWarehouseList() {

        List<Warehouse> warehouseList = warehouseRepository.findAll();

        return warehouseList.stream().map(warehouse -> modelMapper.map(warehouse, WarehouseDTO.class)).collect(Collectors.toList());
//        return null;
    }

    /* 입고, 입하 상태 상세 조회용 */
    public WarehouseDTO findWarehouseByWarehouseNo(int warehouseNo) {

        Warehouse warehouseDetailNo = warehouseRepository.findById(warehouseNo).get();

        System.out.println("Service warehouseDetailNo = " + warehouseDetailNo);

        return modelMapper.map(warehouseDetailNo, WarehouseDTO.class);
    }

    /* 가공 대기 창고 목록 조회용 */
//    public List<WarehouseStatusHistoryDTO> findAllRawList() {
//
//        List<WarehouseStatusHistory> itemRawList = itemWarehouseRepository.findAll();
//
//        return itemRawList.stream().map(warehouse -> modelMapper.map(warehouse, WarehouseStatusHistoryDTO.class)).collect(Collectors.toList());
//        return null;
//    }
    public List<WarehouseDTO> findAllRawList() {

        List<Warehouse> itemRawList = warehouseRepository.findAll();

        return itemRawList.stream().map(warehouse -> modelMapper.map(warehouse, WarehouseDTO.class)).collect(Collectors.toList());
//        return null;
    }

    /* 가공 완성 창고 목록 조회용 */
    public List<ItemWarehouseDTO> findAllManuList() {

        List<ItemWarehouse> itemManuList = itemWarehouseRepository.findAll();

        return itemManuList.stream().map(warehouse -> modelMapper.map(warehouse, ItemWarehouseDTO.class)).collect(Collectors.toList());
    }
}
