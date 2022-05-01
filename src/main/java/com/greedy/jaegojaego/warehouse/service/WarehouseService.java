package com.greedy.jaegojaego.warehouse.service;

import com.greedy.jaegojaego.warehouse.dto.ItemWarehouseDTO;
import com.greedy.jaegojaego.warehouse.dto.WarehouseCompanyOrderHistoryDTO;
import com.greedy.jaegojaego.warehouse.dto.WarehouseDTO;
import com.greedy.jaegojaego.warehouse.entity.ItemWarehouse;
import com.greedy.jaegojaego.warehouse.entity.Warehouse;
import com.greedy.jaegojaego.warehouse.entity.WarehouseCompanyOrderHistory;
import com.greedy.jaegojaego.warehouse.repository.ItemWarehouseRepository;
import com.greedy.jaegojaego.warehouse.repository.WarehouseCompanyOrderRepository;
import com.greedy.jaegojaego.warehouse.repository.WarehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.querydsl.core.types.Ops.DateTimeOps.SYSDATE;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final ItemWarehouseRepository itemWarehouseRepository;
    private final WarehouseCompanyOrderRepository warehouseCompanyOrderRepository;
    private final ModelMapper modelMapper;

    /* Repository 의존성 주입 */
    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository, ItemWarehouseRepository itemwarehouseRepository, ItemWarehouseRepository itemWarehouseRepository, WarehouseCompanyOrderRepository warehouseCompanyOrderRepository, ModelMapper modelMapper) {
        this.warehouseRepository = warehouseRepository;
        this.itemWarehouseRepository = itemWarehouseRepository;
        this.warehouseCompanyOrderRepository = warehouseCompanyOrderRepository;
        this.modelMapper = modelMapper;
    }

    /* 발주 승인 완료 목록 불러오기 */
    public List<WarehouseCompanyOrderHistoryDTO> selectCompanyOrderList() {

        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        List<WarehouseCompanyOrderHistory> warehouseCompanyOrderList = warehouseCompanyOrderRepository.findAll(Sort.by(Sort.Direction.DESC, "companyOrderHistoryNo"));

        System.out.println("service warehouseCompanyOrderList = " + warehouseCompanyOrderList);

        return warehouseCompanyOrderList.stream().map(companyOrder -> modelMapper.map(companyOrder, WarehouseCompanyOrderHistoryDTO.class)).collect(Collectors.toList());
    }

    /** 입고 목록에 발주 승인 완료된 정보 등록용 */
    @Transactional
    public Object registNewOrder(int orderNo) {

        Warehouse warehouse = new Warehouse();



        WarehouseCompanyOrderHistory orderNoList = new WarehouseCompanyOrderHistory();

        orderNoList.setCompanyOrderHistoryNo(orderNo);      //발주내역Entity에 받아온 값(orderNo) 넣어주기

        warehouse.setOrderHistoryNo(orderNoList);           //입고Entity에 받아온 값 넣은 발주내역Entity 넣어주기
//        warehouse.setWarehouseNo();
        warehouse.setWarehouseManuDate(new Date(System.currentTimeMillis()));
        warehouse.setWarehouseDivisionItem(1);
//        warehouse.setClientNo();
        warehouse.setWarehouseWorkingName("입하 대기");
        warehouse.setWarehouseWorkingDate(new Date(System.currentTimeMillis()));

        System.out.println("service orderNoList = " + orderNoList);
        System.out.println("service warehouse = " + warehouse);

        return warehouseRepository.save(warehouse);
    }

    /** 입고, 입하 상태 목록 조회용 */
    public List<WarehouseDTO> findAllWarehouseList() {

        List<Warehouse> warehouseList = warehouseRepository.findAll();

        return warehouseList.stream().map(warehouse -> modelMapper.map(warehouse, WarehouseDTO.class)).collect(Collectors.toList());
    }

    /** 입고, 입하 상태 상세 조회용 */
    public WarehouseDTO findWarehouseByWarehouseNo(int warehouseNo) {

        Warehouse warehouseDetailNo = warehouseRepository.findById(warehouseNo).get();

        System.out.println("Service warehouseDetailNo = " + warehouseDetailNo);

        return modelMapper.map(warehouseDetailNo, WarehouseDTO.class);
    }

    /** 가공 대기 창고 목록 조회용 */
//    public List<WarehouseStatusHistoryDTO> findAllRawList() {
//
//        List<WarehouseStatusHistory> itemRawList = itemWarehouseRepository.findAll();
//
//        return itemRawList.stream().map(warehouse -> modelMapper.map(warehouse, WarehouseStatusHistoryDTO.class)).collect(Collectors.toList());
//        return null;
//    }
    public List<WarehouseDTO> findAllRawList() {

        List<Warehouse> itemRawList = warehouseRepository.findAll();

        List<WarehouseDTO> rawWarehouseList = new ArrayList<>();

        for(int i = 0; i < itemRawList.size(); i++) {
            WarehouseDTO rawWarehouse = new WarehouseDTO();
//            rawWarehouse.setWarehouseMaterialCategoryName(itemRawList.get(i).getCompanyOrderItemList().get(i).getWarehouseItemInfo().getWarehouseMaterialCategory().getMaterialCategoryName());
//            rawWarehouse.setWarehouseItemInfoName(itemRawList.get(i).getCompanyOrderItemList().get(i).getWarehouseItemInfo().getItemInfoName());
//            rawWarehouse.setWarehouseItemInfoItemSerialNo(itemRawList.get(i).getCompanyOrderItemList().get(i).getWarehouseItemInfo().getItemInfoItemSerialNo());
            rawWarehouse.setWarehouseNo(rawWarehouse.getWarehouseNo());

            rawWarehouseList.add(rawWarehouse);
        }

        return rawWarehouseList;
//        return itemRawList.stream().map(warehouse -> modelMapper.map(warehouse, WarehouseDTO.class)).collect(Collectors.toList());
//        return null;
    }

//    public List<WarehouseDTO> findAllRawList() {
//
//        List<Warehouse> rawItemList = warehouseRepository.findAll();
//
//        System.out.println("Service rawItemList = " + rawItemList);
//
//        return modelMapper.map(rawItemList, WarehouseDTO.class);
//    }
    /** 가공 완성 창고 목록 조회용 */
    public List<ItemWarehouseDTO> findAllManuList() {

        List<ItemWarehouse> itemManuList = itemWarehouseRepository.findAll();

        System.out.println("Service itemManuList = " + itemManuList);

        return itemManuList.stream().map(warehouse -> modelMapper.map(warehouse, ItemWarehouseDTO.class)).collect(Collectors.toList());
    }
}
