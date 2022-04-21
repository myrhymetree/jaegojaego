package com.greedy.jaegojaego.outWarehouse.model.service;

import com.greedy.jaegojaego.outWarehouse.model.dto.OutWarehouseListDTO;
import com.greedy.jaegojaego.outWarehouse.model.entity.OutWarehouse;
import com.greedy.jaegojaego.outWarehouse.model.repository.OutWarehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OutWarehouseService {

    private final OutWarehouseRepository outWarehouseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OutWarehouseService(OutWarehouseRepository outWarehouseRepository, ModelMapper modelMapper) {
        this.outWarehouseRepository = outWarehouseRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public List<OutWarehouseListDTO> findOutWarehouseList() {

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        List<OutWarehouse> outWarehouseList = outWarehouseRepository.findOutWarehouseList();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        outWarehouseList.forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        return outWarehouseList.stream().map(outWarehouse -> modelMapper.map(outWarehouse, OutWarehouseListDTO.class)).collect(Collectors.toList());
    }
}
