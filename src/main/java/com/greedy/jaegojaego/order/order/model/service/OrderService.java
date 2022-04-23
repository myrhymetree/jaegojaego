package com.greedy.jaegojaego.order.order.model.service;

import com.greedy.jaegojaego.order.client.model.dto.OrderClientContractItemDTO;
import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;
import com.greedy.jaegojaego.order.client.model.repository.OrderClientContractItemRepository;
import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;
import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
import com.greedy.jaegojaego.order.item.model.repository.OrderItemInfoRepository;
import com.greedy.jaegojaego.order.order.model.dto.CompanyOrderHistoryDTO;
import com.greedy.jaegojaego.order.order.model.dto.OrderApplicationDTO;
import com.greedy.jaegojaego.order.order.model.entitiy.CompanyOrderHistory;
import com.greedy.jaegojaego.order.order.model.entitiy.CompanyOrderItem;
import com.greedy.jaegojaego.order.order.model.entitiy.OrderApplication;
import com.greedy.jaegojaego.order.order.model.repository.CompanyOrderHistoryRepository;
import com.greedy.jaegojaego.order.order.model.repository.CompanyOrderItemRepository;
import com.greedy.jaegojaego.order.warehouse.repository.OrderItemWarehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final CompanyOrderHistoryRepository companyOrderHistoryRepository;
    private final ModelMapper modelMapper;
    private final OrderItemWarehouseRepository orderItemWarehouseRepository;
    private final OrderItemInfoRepository orderItemInfoRepository;
    private final OrderClientContractItemRepository orderClientContractItemRepository;
    private final CompanyOrderItemRepository companyOrderItemRepository;

    @Autowired
    public OrderService(CompanyOrderHistoryRepository companyOrderHistoryRepository, ModelMapper modelMapper
            , OrderItemWarehouseRepository orderItemWarehouseRepository, OrderItemInfoRepository orderItemInfoRepository
            , OrderClientContractItemRepository orderClientContractItemRepository, CompanyOrderItemRepository companyOrderItemRepository) {

        this.companyOrderHistoryRepository = companyOrderHistoryRepository;
        this.modelMapper = modelMapper;
        this.orderItemWarehouseRepository = orderItemWarehouseRepository;
        this.orderItemInfoRepository = orderItemInfoRepository;
        this.orderClientContractItemRepository = orderClientContractItemRepository;
        this.companyOrderItemRepository = companyOrderItemRepository;
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

    //트랜잭션 x`
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

    public List<OrderItemInfoDTO> selectOrderItemInfoList(String searchItem) {

        List<OrderItemInfo> orderItemInfoList = orderItemInfoRepository.selectByItemInfoNameContaining(searchItem);

        return orderItemInfoList.stream().map(orderItemInfo -> modelMapper.map(orderItemInfo, OrderItemInfoDTO.class)).collect(Collectors.toList());
    }

    public List<OrderClientContractItemDTO> selectClientContractItemList(int itemInfoNo) {

        List<OrderClientContractItem> orderClientContractItemList = orderClientContractItemRepository.selectClientContractItemList(itemInfoNo);

        return orderClientContractItemList.stream().map(orderClientContractItem -> modelMapper.map(orderClientContractItem, OrderClientContractItemDTO.class)).collect(Collectors.toList());
    }

//    @Transactional
    public void insertCompanyOrder(String[] itemAmount, String[] clientItemNo, String[] itemInfoNo, int memberNo) {

        Map<Integer, Integer> orderItemInfo = new HashMap<>();
        List<Integer> clientNoList = new ArrayList<>();

        for(String item : itemInfoNo) {
            if(!orderItemInfo.containsKey(Integer.parseInt(item))){
                orderItemInfo.put(Integer.parseInt(item), 0);
            }
        }

        Iterator<Integer> iter = orderItemInfo.keySet().iterator();

        while(iter.hasNext()) {

            int key = iter.next();

            for(int i = 0; i < itemInfoNo.length; i++) {

                if(key == Integer.parseInt(itemInfoNo[i])) {
                    orderItemInfo.put(key, orderItemInfo.get(key) + Integer.parseInt(itemAmount[i]));
                }

            }
        }


        OrderCompanyAccount companyAccount = new OrderCompanyAccount();
        companyAccount.setMemberNo(memberNo);

        CompanyOrderHistory companyOrderHistory = new CompanyOrderHistory();
        companyOrderHistory.setCompanyOrderHistoryCreatedDate(new Date(System.currentTimeMillis()));
        companyOrderHistory.setOrderCompanyAccount(companyAccount);

        companyOrderHistoryRepository.save(companyOrderHistory);

        iter = orderItemInfo.keySet().iterator();

        while(iter.hasNext()) {

            int key = iter.next();

            companyOrderItemRepository.insertCompanyOrderItem(key, orderItemInfo.get(key));

        }
    }
}
