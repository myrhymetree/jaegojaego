package com.greedy.jaegojaego.order.model.service;

import com.greedy.jaegojaego.order.model.dto.CompanyOrderHistoryDTO;
import com.greedy.jaegojaego.order.model.entitiy.CompanyOrderHistory;
import com.greedy.jaegojaego.order.model.repository.CompanyOrderHistoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final CompanyOrderHistoryRepository companyOrderHistoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderService(CompanyOrderHistoryRepository companyOrderHistoryRepository, ModelMapper modelMapper) {
        this.companyOrderHistoryRepository = companyOrderHistoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CompanyOrderHistoryDTO> selectCompanyOrderList() {

        List<CompanyOrderHistory> companyOrderHistoryList = companyOrderHistoryRepository.findAll();

        return companyOrderHistoryList.stream().map(companyOrder -> modelMapper.map(companyOrder, CompanyOrderHistoryDTO.class)).collect(Collectors.toList());

    }
}
