package com.greedy.jaegojaego.order.order.model.service;

import com.greedy.jaegojaego.order.client.model.dto.OrderClientContractItemDTO;
import com.greedy.jaegojaego.order.client.model.entity.OrderClient;
import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;
import com.greedy.jaegojaego.order.client.model.repository.OrderClientContractItemRepository;
import com.greedy.jaegojaego.order.client.model.repository.OrderClientRepository;
import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;
import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
import com.greedy.jaegojaego.order.item.model.repository.OrderItemInfoRepository;
import com.greedy.jaegojaego.order.order.model.dto.company.CompanyOrderDetailDTO;
import com.greedy.jaegojaego.order.order.model.dto.company.CompanyOrderHistoryDTO;
import com.greedy.jaegojaego.order.order.model.dto.company.OrderApplicationDTO;
import com.greedy.jaegojaego.order.order.model.dto.franchise.FranchiseOrderDTO;
import com.greedy.jaegojaego.order.order.model.dto.franchise.FranchiseOrderDetailDTO;
import com.greedy.jaegojaego.order.order.model.dto.franchise.FranchiseOrderItemDTO;
import com.greedy.jaegojaego.order.order.model.entitiy.company.*;
import com.greedy.jaegojaego.order.order.model.entitiy.franchise.FranchiseOrder;
import com.greedy.jaegojaego.order.order.model.entitiy.franchise.FranchiseOrderItem;
import com.greedy.jaegojaego.order.order.model.entitiy.franchise.FranchiseOrderStatusHistory;
import com.greedy.jaegojaego.order.order.model.repository.company.CompanyOrderHistoryRepository;
import com.greedy.jaegojaego.order.order.model.repository.company.CompanyOrderItemRepository;
import com.greedy.jaegojaego.order.order.model.repository.company.OrderApplicationItemRepository;
import com.greedy.jaegojaego.order.order.model.repository.company.OrderApplicationRepository;
import com.greedy.jaegojaego.order.order.model.repository.franchise.FranchiseOrderRepository;
import com.greedy.jaegojaego.order.order.model.repository.franchise.FranchiseOrderStatusHistoryRepository;
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
    private final OrderClientRepository orderClientRepository;
    private final FranchiseOrderRepository franchiseOrderRepository;
    private final FranchiseOrderStatusHistoryRepository franchiseOrderStatusHistoryRepository;

    @Autowired
    public OrderService(CompanyOrderHistoryRepository companyOrderHistoryRepository, ModelMapper modelMapper
            , OrderItemWarehouseRepository orderItemWarehouseRepository, OrderItemInfoRepository orderItemInfoRepository
            , OrderClientContractItemRepository orderClientContractItemRepository, CompanyOrderItemRepository companyOrderItemRepository
            , OrderApplicationRepository orderApplicationRepository, OrderApplicationItemRepository orderApplicationItemRepository
            , OrderClientRepository orderClientRepository, FranchiseOrderRepository franchiseOrderRepository
            , FranchiseOrderStatusHistoryRepository franchiseOrderStatusHistoryRepository) {

        this.companyOrderHistoryRepository = companyOrderHistoryRepository;
        this.modelMapper = modelMapper;
        this.orderItemWarehouseRepository = orderItemWarehouseRepository;
        this.orderItemInfoRepository = orderItemInfoRepository;
        this.orderClientContractItemRepository = orderClientContractItemRepository;
        this.companyOrderItemRepository = companyOrderItemRepository;
        this.orderApplicationRepository = orderApplicationRepository;
        this.orderApplicationItemRepository = orderApplicationItemRepository;
        this.orderClientRepository = orderClientRepository;
        this.franchiseOrderRepository = franchiseOrderRepository;
        this.franchiseOrderStatusHistoryRepository = franchiseOrderStatusHistoryRepository;
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
    public List<CompanyOrderDetailDTO> insertCompanyOrder(String[] itemAmount, String[] clientItemNo, String[] itemInfoNo, int memberNo, String[] clientNo) {

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

        List<CompanyOrderDetailDTO> companyOrderDetailList = new ArrayList<>();

        for(Integer clientNumber : clientList) {
            CompanyOrderDetailDTO companyOrderDetail = new CompanyOrderDetailDTO();
            companyOrderDetail.setCompanyOrderHistoryNo(companyOrderHistoryNo);

            OrderClient orderClient = orderClientRepository.findById(clientNumber).get();

            companyOrderDetail.setClientName(orderClient.getClientName());
            companyOrderDetail.setClientNo(orderClient.getClientNo());

            companyOrderDetailList.add(companyOrderDetail);
        }

        return companyOrderDetailList;
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

                    OrderApplicationItem orderApplicationItem = new OrderApplicationItem();
                    orderApplicationItem.setOrderApplicationItemPK(orderApplicationItemPK);
                    orderApplicationItem.setOrderApplicationItemAmount(Integer.parseInt(itemAmount[i]));

                    orderApplicationItemRepository.save(orderApplicationItem);
                }
            }

        }

    }

    @Transactional
    public void updateCompanyOrderHistoryStatus(int memberNo, int companyOrderHistoryNo, String orderStatus) {

        OrderCompanyAccount orderCompanyAccount = new OrderCompanyAccount();
        orderCompanyAccount.setMemberNo(memberNo);

        CompanyOrderHistory companyOrderHistory = companyOrderHistoryRepository.findById(companyOrderHistoryNo).get();
        companyOrderHistory.setCompanyOrderHistoryStaus(orderStatus);
        companyOrderHistory.setCompanyOrderUpdateMember(orderCompanyAccount);
        companyOrderHistory.setCompanyOrderHistoryStatusDate(new Date(System.currentTimeMillis()));

    }

    public List<FranchiseOrderDTO> selectFranchiseOrderList(int memberNo, String memberDivision) {

        List<FranchiseOrder> franchiseOrderList = new ArrayList<>();

        if("본사".equals(memberDivision)) {

            franchiseOrderList = franchiseOrderRepository.findByOrderFranchiseInfo_HeadOfficeSupervisor_MemberNo(memberNo);
        } else if("가맹점".equals(memberDivision)) {

            franchiseOrderList = franchiseOrderRepository.findByOrderFranchiseInfo_FranchiseRepresentativeNo(memberNo);
        }

        return franchiseOrderList.stream().map(franchiseOrder -> modelMapper.map(franchiseOrder, FranchiseOrderDTO.class)).collect(Collectors.toList());
    }

    public List<FranchiseOrderDetailDTO> selectFranchiseOrderDetail(int franchiseOrderNo) {

        FranchiseOrder franchiseOrder = franchiseOrderRepository.findById(franchiseOrderNo).get();

        List<FranchiseOrderDetailDTO> franchiseOrderDetailList = new ArrayList<>();

        for(FranchiseOrderItem order : franchiseOrder.getFranchiseOrderItemList()) {

            FranchiseOrderDetailDTO franchiseOrderDetail = new FranchiseOrderDetailDTO();
            franchiseOrderDetail.setItemName(order.getFranchiseOrderItem().getFranchiseOrderableItem().getOrderItemInfo().getItemInfoName());
            franchiseOrderDetail.setItemPrice(order.getFranchiseOrderItem().getFranchiseOrderableItem().getFranchiseOrderableItemPrice());
            franchiseOrderDetail.setItemAmount(order.getFranchiseOrderItemAmount());

            franchiseOrderDetailList.add(franchiseOrderDetail);
        }

        return franchiseOrderDetailList;
    }

    @Transactional
    public void updateFranchiseOrderStatus(int memberNo, int franchiseOrderNo, String orderStatus) {

        FranchiseOrder franchiseOrder = franchiseOrderRepository.findById(franchiseOrderNo).get();
        franchiseOrder.setFranchiseOrderStatus(orderStatus);
        franchiseOrder.setFranchiseOrderStatusDate(new Date(System.currentTimeMillis()));

        OrderCompanyAccount orderCompanyAccount = new OrderCompanyAccount();
        orderCompanyAccount.setMemberNo(memberNo);

        FranchiseOrderStatusHistory franchiseOrderStatusHistory = new FranchiseOrderStatusHistory();
        franchiseOrderStatusHistory.setFranchiseOrderNo(franchiseOrderNo);
        franchiseOrderStatusHistory.setOrderCompanyAccount(orderCompanyAccount);
        franchiseOrderStatusHistory.setFranchiseOrderStatus(orderStatus);
        franchiseOrderStatusHistory.setFranchiseOrderStatusHistoryDate(new Date(System.currentTimeMillis()));

        franchiseOrderStatusHistoryRepository.save(franchiseOrderStatusHistory);

    }
}
