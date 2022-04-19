package com.greedy.jaegojaego.warehouse.service;

import com.greedy.jaegojaego.warehouse.dto.WarehouseDTO;
import com.greedy.jaegojaego.warehouse.entity.Warehouse;
import com.greedy.jaegojaego.warehouse.repository.WarehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository, ModelMapper modelMapper) {
        this.warehouseRepository = warehouseRepository;
        this.modelMapper = modelMapper;
    }

    public List<WarehouseDTO> findAllWarehouseList() {

        List<Warehouse> warehouseList = warehouseRepository.findAll();

        return warehouseList.stream().map(warehouse -> modelMapper.map(warehouse, WarehouseDTO.class)).collect(Collectors.toList());
    }

}