package com.greedy.jaegojaego.order.order.model.service;

import com.greedy.jaegojaego.order.order.model.dto.CompanyOrderHistoryDTO;
import com.greedy.jaegojaego.order.order.model.dto.OrderApplicationDTO;
import com.greedy.jaegojaego.order.order.model.entitiy.CompanyOrderHistory;
import com.greedy.jaegojaego.order.order.model.entitiy.OrderApplication;
import com.greedy.jaegojaego.order.order.model.entitiy.OrderApplicationItem;
import com.greedy.jaegojaego.order.order.model.repository.CompanyOrderHistoryRepository;
import com.greedy.jaegojaego.order.warehouse.repository.OrderItemWarehouseRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final CompanyOrderHistoryRepository companyOrderHistoryRepository;
    private final ModelMapper modelMapper;
    private final OrderItemWarehouseRepository orderItemWarehouseRepository;

    @Autowired
    public OrderService(CompanyOrderHistoryRepository companyOrderHistoryRepository, ModelMapper modelMapper, OrderItemWarehouseRepository orderItemWarehouseRepository) {
        this.companyOrderHistoryRepository = companyOrderHistoryRepository;
        this.modelMapper = modelMapper;
        this.orderItemWarehouseRepository = orderItemWarehouseRepository;

    }

    public List<CompanyOrderHistoryDTO> selectCompanyOrderList() {

        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        List<CompanyOrderHistory> companyOrderHistoryList = companyOrderHistoryRepository.findAll(Sort.by(Sort.Direction.DESC, "companyOrderHistoryNo"));

        return companyOrderHistoryList.stream().map(companyOrder -> modelMapper.map(companyOrder, CompanyOrderHistoryDTO.class)).collect(Collectors.toList());

    }

    public CompanyOrderHistoryDTO selectCompanyOrderHistoryDetail(int companyOrderHistoryNo) {

        CompanyOrderHistory companyOrderHistory = companyOrderHistoryRepository.findById(companyOrderHistoryNo).get();

        return modelMapper.map(companyOrderHistory, CompanyOrderHistoryDTO.class);
    }

    public List<OrderApplicationDTO> selectOrderApplicationDetail(int companyOrderHistoryNo, int clientNo) {

        CompanyOrderHistory companyOrderHistory = companyOrderHistoryRepository.findById(companyOrderHistoryNo).get();
        String warehouseAddress = orderItemWarehouseRepository.selectItemWarehouseAddress();

        List<OrderApplication> orderApplicationList = new ArrayList<>();

        companyOrderHistory.getOrderCompanyAccount().setEmail(warehouseAddress);

        for(int i = 0; i < companyOrderHistory.getOrderApplicationList().size(); i++) {

            if(clientNo == companyOrderHistory.getOrderApplicationList().get(i).getOrderClient().getClientNo()) {

                orderApplicationList.add(companyOrderHistory.getOrderApplicationList().get(i));
            }
        }

        return orderApplicationList.stream().map(orderApplication -> modelMapper.map(orderApplication, OrderApplicationDTO.class)).collect(Collectors.toList());
    }
}
