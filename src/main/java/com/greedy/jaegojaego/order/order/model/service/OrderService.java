package com.greedy.jaegojaego.order.order.model.service;

import com.greedy.jaegojaego.order.client.model.dto.OrderClientContractItemDTO;
import com.greedy.jaegojaego.order.client.model.entity.OrderClient;
import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;
import com.greedy.jaegojaego.order.client.model.repository.OrderClientContractItemRepository;
import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;
import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
import com.greedy.jaegojaego.order.item.model.repository.OrderItemInfoRepository;
import com.greedy.jaegojaego.order.order.model.dto.CompanyOrderHistoryDTO;
import com.greedy.jaegojaego.order.order.model.dto.OrderApplicationDTO;
import com.greedy.jaegojaego.order.order.model.entitiy.*;
import com.greedy.jaegojaego.order.order.model.repository.CompanyOrderHistoryRepository;
import com.greedy.jaegojaego.order.order.model.repository.CompanyOrderItemRepository;
import com.greedy.jaegojaego.order.order.model.repository.OrderApplicationItemRepository;
import com.greedy.jaegojaego.order.order.model.repository.OrderApplicationRepository;
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
    private final OrderApplicationRepository orderApplicationRepository;
    private final OrderApplicationItemRepository orderApplicationItemRepository;

    @Autowired
    public OrderService(CompanyOrderHistoryRepository companyOrderHistoryRepository, ModelMapper modelMapper
            , OrderItemWarehouseRepository orderItemWarehouseRepository, OrderItemInfoRepository orderItemInfoRepository
            , OrderClientContractItemRepository orderClientContractItemRepository, CompanyOrderItemRepository companyOrderItemRepository
            , OrderApplicationRepository orderApplicationRepository, OrderApplicationItemRepository orderApplicationItemRepository) {

        this.companyOrderHistoryRepository = companyOrderHistoryRepository;
        this.modelMapper = modelMapper;
        this.orderItemWarehouseRepository = orderItemWarehouseRepository;
        this.orderItemInfoRepository = orderItemInfoRepository;
        this.orderClientContractItemRepository = orderClientContractItemRepository;
        this.companyOrderItemRepository = companyOrderItemRepository;
        this.orderApplicationRepository = orderApplicationRepository;
        this.orderApplicationItemRepository = orderApplicationItemRepository;
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

    @Transactional
    public void insertCompanyOrder(String[] itemAmount, String[] clientItemNo, String[] itemInfoNo, int memberNo, String[] clientNo) {

        Map<Integer, Integer> orderItemInfo = new HashMap<>();
        List<Integer> clientList = new ArrayList<>();

        for(String item : itemInfoNo) {
            if(!orderItemInfo.containsKey(Integer.parseInt(item))){
                orderItemInfo.put(Integer.parseInt(item), 0);
            }
        }

        for(String client : clientNo) {
            if(!clientList.contains(Integer.parseInt(client))) {
                clientList.add(Integer.parseInt(client));
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

        insertCompanyOrderHistory(memberNo);

        int companyOrderHistoryNo = companyOrderHistoryRepository.selectRecentHistoryNo();

        iter = orderItemInfo.keySet().iterator();

        while(iter.hasNext()) {

            int key = iter.next();

            insertCompanyOrderItem(companyOrderHistoryNo, key, orderItemInfo.get(key));

        }

        insertOrderApplication(companyOrderHistoryNo, clientList);

        insertOrderApplicationItem(clientList, clientItemNo, clientNo, itemAmount);
    }

    private void insertCompanyOrderHistory(int memberNo) {

        OrderCompanyAccount companyAccount = new OrderCompanyAccount();
        companyAccount.setMemberNo(memberNo);

        CompanyOrderHistory companyOrderHistory = new CompanyOrderHistory();
        companyOrderHistory.setCompanyOrderHistoryCreatedDate(new Date(System.currentTimeMillis()));
        companyOrderHistory.setOrderCompanyAccount(companyAccount);

        companyOrderHistoryRepository.save(companyOrderHistory);

    }

    private void insertCompanyOrderItem(int companyOrderHistoryNo, int itemIntoNo, int itemAmount) {

        CompanyOrderHistory companyOrderHistory = new CompanyOrderHistory();

        companyOrderHistory.setCompanyOrderHistoryNo(companyOrderHistoryNo);
        OrderItemInfo newOrderItemInfo = new OrderItemInfo();
        newOrderItemInfo.setItemInfoNo(itemIntoNo);

        CompanyOrderItemPK companyOrderItemPK = new CompanyOrderItemPK();
        companyOrderItemPK.setCompanyOrderHistory(companyOrderHistory);
        companyOrderItemPK.setOrderItemInfo(newOrderItemInfo);

        CompanyOrderItem companyOrderItem = new CompanyOrderItem();
        companyOrderItem.setCompanyOrderItemPK(companyOrderItemPK);
        companyOrderItem.setCompanyOrderItemAmount(itemAmount);

        companyOrderItemRepository.save(companyOrderItem);

    }

    private void insertOrderApplication(int companyOrderHistoryNo, List<Integer> clientList) {

        CompanyOrderHistory companyOrderHistory = new CompanyOrderHistory();
        companyOrderHistory.setCompanyOrderHistoryNo(companyOrderHistoryNo);

        for(int i = 0; i < clientList.size(); i++) {

            OrderClient orderClient = new OrderClient();
            orderClient.setClientNo(clientList.get(i));

            OrderApplication orderApplication = new OrderApplication();
            orderApplication.setOrderClient(orderClient);
            orderApplication.setCompanyOrderHistory(companyOrderHistory);

            orderApplicationRepository.save(orderApplication);
        }

    }

    private void insertOrderApplicationItem(List<Integer> clientList, String[] clientItemNo, String[] clientNo, String[] itemAmount) {

        List<Integer> orderApplicationNo = orderApplicationRepository.selectRecentOrderApplication(clientList.size() + 1);
        List<Integer> orderApplicationClientNo = orderApplicationRepository.selectRecentOrderApplicationClient(clientList.size() + 1);

        for(int i = 0; i < itemAmount.length; i++) {
            System.out.println(clientNo[i] + " : " + clientItemNo[i] + " : " + itemAmount[i]);
        }

        for(int i = 0; i < orderApplicationNo.size(); i++) {
            System.out.println(orderApplicationClientNo.get(i) + " : " + orderApplicationNo.get(i));
        }

        for(int i = 0; i < clientItemNo.length; i++) {

            for(int j = 0; j < orderApplicationClientNo.size(); j++) {

                OrderApplication orderApplication = new OrderApplication();
                OrderClientContractItem orderClientContractItem = new OrderClientContractItem();
                OrderApplicationItemPK orderApplicationItemPK = new OrderApplicationItemPK();

                if(Integer.parseInt(clientNo[i]) == orderApplicationClientNo.get(j)) {
                    orderApplication.setOrderApplicationNo(orderApplicationNo.get(j));
                    orderApplicationItemPK.setOrderApplication(orderApplication);

                    orderClientContractItem.setClientContractItemNo(Integer.parseInt(clientItemNo[i]));
                    orderApplicationItemPK.setOrderClientContractItem(orderClientContractItem);

                    System.out.println("발주 신청서 번호 : " + orderApplication.getOrderApplicationNo());
                    System.out.println("발주 거래처 판매 물품 번호 : " + orderClientContractItem.getClientContractItemNo());
                    System.out.println("수량 : " + itemAmount[i]);

                    System.out.println("orderApplicationItemPK = " + orderApplicationItemPK);

                    OrderApplicationItem orderApplicationItem = new OrderApplicationItem();
                    orderApplicationItem.setOrderApplicationItemPK(orderApplicationItemPK);
                    orderApplicationItem.setOrderApplicationItemAmount(Integer.parseInt(itemAmount[i]));

                    orderApplicationItemRepository.save(orderApplicationItem);
                }
            }

        }

    }

}
