package com.greedy.jaegojaego.order.order.model.service;

import com.greedy.jaegojaego.order.order.model.dto.CompanyOrderHistoryDTO;
import com.greedy.jaegojaego.order.order.model.entitiy.CompanyOrderHistory;
import com.greedy.jaegojaego.order.order.model.repository.CompanyOrderHistoryRepository;
import com.greedy.jaegojaego.order.order.model.repository.OrderApplicationItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final CompanyOrderHistoryRepository companyOrderHistoryRepository;
    private final ModelMapper modelMapper;
    private final OrderApplicationItemRepository orderApplicationItemRepository;

    @Autowired
    public OrderService(CompanyOrderHistoryRepository companyOrderHistoryRepository, ModelMapper modelMapper, OrderApplicationItemRepository orderApplicationItemRepository) {
        this.companyOrderHistoryRepository = companyOrderHistoryRepository;
        this.modelMapper = modelMapper;
        this.orderApplicationItemRepository = orderApplicationItemRepository;
    }

    public List<CompanyOrderHistoryDTO> selectCompanyOrderList() {

        List<CompanyOrderHistory> companyOrderHistoryList = companyOrderHistoryRepository.findAll();

        return companyOrderHistoryList.stream().map(companyOrder -> modelMapper.map(companyOrder, CompanyOrderHistoryDTO.class)).collect(Collectors.toList());

    }
}
