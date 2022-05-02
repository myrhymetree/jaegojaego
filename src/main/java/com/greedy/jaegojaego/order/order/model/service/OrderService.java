package com.greedy.jaegojaego.order.order.model.service;

import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.order.client.model.dto.OrderClientContractItemDTO;
import com.greedy.jaegojaego.order.client.model.entity.OrderClient;
import com.greedy.jaegojaego.order.client.model.entity.OrderClientContractItem;
import com.greedy.jaegojaego.order.client.model.repository.OrderClientContractItemRepository;
import com.greedy.jaegojaego.order.client.model.repository.OrderClientRepository;
import com.greedy.jaegojaego.order.company.model.entity.OrderCompanyAccount;
import com.greedy.jaegojaego.order.franchise.model.dto.OrderFranchiseAccountDTO;
import com.greedy.jaegojaego.order.franchise.model.dto.OrderFranchiseInfoDTO;
import com.greedy.jaegojaego.order.franchise.model.entity.OrderFranchiseAccount;
import com.greedy.jaegojaego.order.franchise.model.entity.OrderFranchiseInfo;
import com.greedy.jaegojaego.order.franchise.model.repository.OrderFranchiseAccountRepository;
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;
import com.greedy.jaegojaego.order.item.model.entity.OrderItemInfo;
import com.greedy.jaegojaego.order.item.model.repository.OrderItemInfoRepository;
import com.greedy.jaegojaego.order.order.model.dto.company.CompanyOrderDetailDTO;
import com.greedy.jaegojaego.order.order.model.dto.company.CompanyOrderHistoryDTO;
import com.greedy.jaegojaego.order.order.model.dto.company.OrderApplicationDTO;
import com.greedy.jaegojaego.order.order.model.dto.franchise.FranchiseOrderDTO;
import com.greedy.jaegojaego.order.order.model.dto.franchise.FranchiseOrderDetailDTO;
import com.greedy.jaegojaego.order.order.model.dto.franchise.FranchiseOrderListDTO;
import com.greedy.jaegojaego.order.order.model.dto.franchise.FranchiseOrderableItemDTO;
import com.greedy.jaegojaego.order.order.model.entity.company.*;
import com.greedy.jaegojaego.order.order.model.entity.franchise.*;
import com.greedy.jaegojaego.order.order.model.repository.company.CompanyOrderHistoryRepository;
import com.greedy.jaegojaego.order.order.model.repository.company.CompanyOrderItemRepository;
import com.greedy.jaegojaego.order.order.model.repository.company.OrderApplicationItemRepository;
import com.greedy.jaegojaego.order.order.model.repository.company.OrderApplicationRepository;
import com.greedy.jaegojaego.order.franchise.model.repository.OrderFranchiseInfoRepository;
import com.greedy.jaegojaego.order.order.model.repository.franchise.FranchiseOrderItemRepository;
import com.greedy.jaegojaego.order.order.model.repository.franchise.FranchiseOrderRepository;
import com.greedy.jaegojaego.order.order.model.repository.franchise.FranchiseOrderStatusHistoryRepository;
import com.greedy.jaegojaego.order.order.model.repository.franchise.FranchiseOrderableItemRepository;
import com.greedy.jaegojaego.order.warehouse.repository.OrderItemWarehouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private final FranchiseOrderableItemRepository franchiseOrderableItemRepository;
    private final OrderFranchiseInfoRepository orderFranchiseInfoRepository;
    private final FranchiseOrderItemRepository franchiseOrderItemRepository;
    private final OrderFranchiseAccountRepository orderFranchiseAccountRepository;

    @Autowired
    public OrderService(CompanyOrderHistoryRepository companyOrderHistoryRepository, ModelMapper modelMapper
            , OrderItemWarehouseRepository orderItemWarehouseRepository, OrderItemInfoRepository orderItemInfoRepository
            , OrderClientContractItemRepository orderClientContractItemRepository, CompanyOrderItemRepository companyOrderItemRepository
            , OrderApplicationRepository orderApplicationRepository, OrderApplicationItemRepository orderApplicationItemRepository
            , OrderClientRepository orderClientRepository, FranchiseOrderRepository franchiseOrderRepository
            , FranchiseOrderStatusHistoryRepository franchiseOrderStatusHistoryRepository, FranchiseOrderableItemRepository franchiseOrderableItemRepository
            , OrderFranchiseInfoRepository orderFranchiseInfoRepository, FranchiseOrderItemRepository franchiseOrderItemRepository
            , OrderFranchiseAccountRepository orderFranchiseAccountRepository) {

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
        this.franchiseOrderableItemRepository = franchiseOrderableItemRepository;
        this.orderFranchiseInfoRepository = orderFranchiseInfoRepository;
        this.franchiseOrderItemRepository = franchiseOrderItemRepository;
        this.orderFranchiseAccountRepository = orderFranchiseAccountRepository;
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

        System.out.println("warehouseAddress = " + warehouseAddress);

        List<OrderApplication> orderApplicationList = new ArrayList<>();

        for(int i = 0; i < companyOrderHistory.getOrderApplicationList().size(); i++) {

            if(clientNo == companyOrderHistory.getOrderApplicationList().get(i).getOrderClient().getClientNo()) {

                orderApplicationList.add(companyOrderHistory.getOrderApplicationList().get(i));
            }
        }

        List<OrderApplicationDTO> orderApplicationDTOList = orderApplicationList.stream().map(orderApplication -> modelMapper.map(orderApplication, OrderApplicationDTO.class)).collect(Collectors.toList());

        for(int i = 0; i < orderApplicationDTOList.size(); i++) {
            orderApplicationDTOList.get(i).setOrderApplicationAddress(warehouseAddress);
        }

        return orderApplicationDTOList;
    }

    public List<OrderItemInfoDTO> selectOrderItemInfoList(String searchItem) {

        List<OrderItemInfo> orderItemInfoList = orderItemInfoRepository.selectByItemInfoNameContaining(searchItem);

        return orderItemInfoList.stream().map(orderItemInfo -> modelMapper.map(orderItemInfo, OrderItemInfoDTO.class)).collect(Collectors.toList());
    }

    public List<OrderClientContractItemDTO> selectClientContractItemList(int itemInfoNo) {

        List<OrderClientContractItem> orderClientContractItemList = orderClientContractItemRepository.selectClientContractItemList(itemInfoNo);

        List<OrderClientContractItem> resultClientContractItemList = new ArrayList<>();

        for(int i = 0; i < orderClientContractItemList.size(); i++) {

            if("계약중".equals(orderClientContractItemList.get(i).getOrderClientContractInfo().getClientContractInfoStatus())) {

                resultClientContractItemList.add(orderClientContractItemList.get(i));

            }

        }

        return resultClientContractItemList.stream().map(orderClientContractItem -> modelMapper.map(orderClientContractItem, OrderClientContractItemDTO.class)).collect(Collectors.toList());
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
        companyOrderHistory.setCompanyOrderHistoryStaus("BEFORE");

        companyOrderHistoryRepository.save(companyOrderHistory);

    }

    private void insertCompanyOrderItem(int companyOrderHistoryNo, int itemInfoNo, int itemAmount) {

        CompanyOrderHistory companyOrderHistory = new CompanyOrderHistory();

        companyOrderHistory.setCompanyOrderHistoryNo(companyOrderHistoryNo);
        OrderItemInfo newOrderItemInfo = new OrderItemInfo();
        newOrderItemInfo.setItemInfoNo(itemInfoNo);

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

        List<OrderApplication> orderApplicationList = orderApplicationRepository.selectRecentOrderApplicationList(clientList.size() + 1);


        for(int i = 0; i < clientItemNo.length; i++) {

            for(int j = 0; j < orderApplicationList.size(); j++) {

                OrderApplication orderApplication = new OrderApplication();
                OrderClientContractItem orderClientContractItem = new OrderClientContractItem();
                OrderApplicationItemPK orderApplicationItemPK = new OrderApplicationItemPK();

                int clientNumber = Integer.parseInt(clientNo[i]);
                int orderApplicationNumber = orderApplicationList.get(j).getOrderClient().getClientNo();

                if(clientNumber == orderApplicationNumber) {
                    orderApplication.setOrderApplicationNo(orderApplicationList.get(j).getOrderApplicationNo());
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

    public List<FranchiseOrderListDTO> selectFranchiseOrderList(int memberNo, String memberDivision, String officeDivision) {

        List<FranchiseOrder> franchiseOrderList = new ArrayList<>();
        List<FranchiseOrder> franchiseOrderListByCompany = new ArrayList<>();
        List<FranchiseOrderListDTO> franchiseOrderListDTOList = new ArrayList<>();
        List<OrderFranchiseAccount> franchiseAccountList = new ArrayList<>();

        List<OrderFranchiseInfo> franchiseNoList = new ArrayList<>();

        if("본사".equals(memberDivision)) {

            franchiseNoList = orderFranchiseInfoRepository.findByHeadOfficeSupervisor_MemberNo(memberNo);

            for(int i = 0; i < franchiseNoList.size(); i++) {

                List<OrderFranchiseAccount> orderFranchiseAccountList = orderFranchiseAccountRepository.findByFranchiseInfo_FranchiseRepresentativeNo(franchiseNoList.get(i).getFranchiseRepresentativeNo());

                for(int j = 0; j < orderFranchiseAccountList.size(); j++) {
                    franchiseAccountList.add(orderFranchiseAccountList.get(j));
                }

            }

            franchiseNoList.forEach(System.out::println);

            franchiseOrderList = franchiseOrderRepository.findAll(Sort.by(Sort.Direction.DESC, "franchiseOrderNo"));

            franchiseOrderListDTOList = setFranchiseOrderList(franchiseOrderList, franchiseNoList, franchiseAccountList);

            return franchiseOrderListDTOList;

        } else if("가맹점".equals(memberDivision)) {

            if("대표자".equals(officeDivision)) {

                OrderFranchiseInfo orderFranchiseInfo = orderFranchiseInfoRepository.findById(memberNo).get();

                franchiseOrderList = franchiseOrderRepository.findByMember_MemberNoOrderByFranchiseOrderApplicationDateDesc(memberNo);

                franchiseOrderListDTOList = setFranchiseOrderListByFranchise(franchiseOrderList, orderFranchiseInfo);
            } else {

                OrderFranchiseAccount orderFranchiseAccount = orderFranchiseAccountRepository.findById(memberNo).get();

                franchiseOrderList = franchiseOrderRepository.findByMember_MemberNoOrderByFranchiseOrderApplicationDateDesc(orderFranchiseAccount.getFranchiseInfo().getFranchiseRepresentativeNo());

                franchiseOrderListDTOList = setFranchiseOrderListByFranchise(franchiseOrderList, orderFranchiseAccount.getFranchiseInfo(), orderFranchiseAccount);
            }

        }

        return franchiseOrderListDTOList;
    }


    public List<FranchiseOrderDetailDTO> selectFranchiseOrderDetail(int franchiseOrderNo) {

        FranchiseOrder franchiseOrder = franchiseOrderRepository.findById(franchiseOrderNo).get();

        List<FranchiseOrderDetailDTO> franchiseOrderDetailList = new ArrayList<>();

        for(FranchiseOrderItem order : franchiseOrder.getFranchiseOrderItemList()) {

            FranchiseOrderDetailDTO franchiseOrderDetail = new FranchiseOrderDetailDTO();
            franchiseOrderDetail.setItemName(order.getFranchiseOrderItem().getFranchiseOrderableItem().getFranchiseOrderableItem().getOrderItemInfo().getItemInfoName());
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

    @Transactional
    public void updateFranchiseOrderStatus(int memberNo, int franchiseOrderNo, String orderStatus, String rejectMessage) {

        FranchiseOrder franchiseOrder = franchiseOrderRepository.findById(franchiseOrderNo).get();
        franchiseOrder.setFranchiseOrderStatus(orderStatus);
        franchiseOrder.setFranchiseOrderStatusDate(new Date(System.currentTimeMillis()));
        franchiseOrder.setFranchiseOrderStatusRejectionContent(rejectMessage);

        OrderCompanyAccount orderCompanyAccount = new OrderCompanyAccount();
        orderCompanyAccount.setMemberNo(memberNo);

        FranchiseOrderStatusHistory franchiseOrderStatusHistory = new FranchiseOrderStatusHistory();
        franchiseOrderStatusHistory.setFranchiseOrderNo(franchiseOrderNo);
        franchiseOrderStatusHistory.setOrderCompanyAccount(orderCompanyAccount);
        franchiseOrderStatusHistory.setFranchiseOrderStatus(orderStatus);
        franchiseOrderStatusHistory.setFranchiseOrderStatusHistoryDate(new Date(System.currentTimeMillis()));

        franchiseOrderStatusHistoryRepository.save(franchiseOrderStatusHistory);

    }

    public String selectRejectContent(int franchiseOrderNo) {

        FranchiseOrder franchiseOrder = franchiseOrderRepository.findById(franchiseOrderNo).get();

        String rejectContent = franchiseOrder.getFranchiseOrderStatusRejectionContent();

        return rejectContent;
    }

    public void updateCompanyOrderHistory(String[] itemAmount, String[] clientItemNo, String[] itemInfoNo, String[] clientNo, int memberNo, int companyOrderHistoryNo) {

        List<CompanyOrderItem> deleteCompanyOrderItemList = companyOrderItemRepository.findByCompanyOrderHistoryNo(companyOrderHistoryNo);

        List<OrderApplication> deleteOrderApplicationList = orderApplicationRepository.findByCompanyOrderHistory_CompanyOrderHistoryNo(companyOrderHistoryNo);

        for(int i = 0; i < deleteOrderApplicationList.size(); i++) {

            List<OrderApplicationItem> deleteOrderApplicationItemList = orderApplicationItemRepository.findByOrderApplicationNo(deleteOrderApplicationList.get(i).getOrderApplicationNo());

            for(int j = 0; j < deleteOrderApplicationItemList.size(); j++) {

                orderApplicationItemRepository.delete(deleteOrderApplicationItemList.get(j));
            }
        }

        for(int i = 0; i < deleteOrderApplicationList.size(); i++) {

            orderApplicationRepository.delete(deleteOrderApplicationList.get(i));

        }

        for(int i = 0; i < deleteCompanyOrderItemList.size(); i++) {
            companyOrderItemRepository.delete(deleteCompanyOrderItemList.get(i));
        }

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

        iter = orderItemInfo.keySet().iterator();

        while(iter.hasNext()) {

            int key = iter.next();

            insertCompanyOrderItem(companyOrderHistoryNo, key, orderItemInfo.get(key));

        }

        insertOrderApplication(companyOrderHistoryNo, clientList);

        insertOrderApplicationItem(clientList, clientItemNo, clientNo, itemAmount);

    }

    public List<FranchiseOrderableItemDTO> selectFranchiseOrderableItemList() {

        List<FranchiseOrderableItem> franchiseOrderableItemList = franchiseOrderableItemRepository.findAll();

        return franchiseOrderableItemList.stream().map(franchiseOrderableItem -> modelMapper.map(franchiseOrderableItem, FranchiseOrderableItemDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public void insertFranchiseOrder(int memberNo, int[] itemInfoNo, int[] itemAmount) {

        Random random = new Random();
        String orderNumber = "";

        List<FranchiseOrder> franchiseOrderList = franchiseOrderRepository.findAll();

        List<String> orderNumberList = new ArrayList<>();

        for(int i = 0; i < franchiseOrderList.size(); i++) {

            String subStringOrderNumber = franchiseOrderList.get(i).getFranchiseOrderOrderNumber().substring(0, 4);

            orderNumberList.add(subStringOrderNumber);
        }

        for(int i = 0; i < 4; i++) {

            String ran = Integer.toString((int)((Math.random()*10000)%10));

            orderNumber += ran;

            if(orderNumber.length() == 4) {

                checkDuplicationOrderNumber:
                for(int j = 0; j < orderNumberList.size(); j++) {

                    if(orderNumber.equals(orderNumberList.get(j))) {

                        orderNumber = "";
                        i = 0;
                        break checkDuplicationOrderNumber;
                    }

                }
            }
        }

        java.sql.Date today = new Date(System.currentTimeMillis());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String todayFormat = dateFormat.format(today);

        String[] splitToday = todayFormat.split("-");

        for(int i = 0; i < splitToday.length; i++) {

            orderNumber += splitToday[i];

        }

        Member member = new Member();
        member.setMemberNo(memberNo);

        FranchiseOrder franchiseOrder = setFranchiseOrder(today, orderNumber, member);

        franchiseOrderRepository.save(franchiseOrder);

        int franchiseOrderNo = franchiseOrderRepository.selectSequenceNo();

        List<FranchiseOrderItem> franchiseOrderItemList = setFranchiseOrderItem(itemInfoNo, itemAmount, franchiseOrderNo);

        for(int i = 0; i < franchiseOrderItemList.size(); i++) {

            franchiseOrderItemRepository.save(franchiseOrderItemList.get(i));
        }

        FranchiseOrderStatusHistory franchiseOrderStatusHistory = new FranchiseOrderStatusHistory();
        franchiseOrderStatusHistory.setFranchiseOrderNo(franchiseOrderNo);
        franchiseOrderStatusHistory.setFranchiseOrderStatus("BEFORE");
        franchiseOrderStatusHistory.setFranchiseOrderStatusHistoryDate(new Date(System.currentTimeMillis()));

        franchiseOrderStatusHistoryRepository.save(franchiseOrderStatusHistory);
    }

    private FranchiseOrder setFranchiseOrder(java.sql.Date today, String orderNumber, Member member) {

        FranchiseOrder franchiseOrder = new FranchiseOrder();
        franchiseOrder.setFranchiseOrderApplicationDate(today);
        franchiseOrder.setFranchiseOrderOrderNumber(orderNumber);
        franchiseOrder.setFranchiseOrderStatus("BEFORE");
        franchiseOrder.setMember(member);

        return franchiseOrder;
    }

    private List<FranchiseOrderItem> setFranchiseOrderItem(int[] itemInfoNo, int[] itemAmount, int franchiseOrderNo) {

        List<FranchiseOrderItem> franchiseOrderItemList = new ArrayList<>();

        for(int i = 0; i < itemInfoNo.length; i++) {

            OrderItemInfo orderItemInfo = new OrderItemInfo();
            orderItemInfo.setItemInfoNo(itemInfoNo[i]);

            FranchiseOrderableItemPK franchiseOrderableItemPK = new FranchiseOrderableItemPK();
            franchiseOrderableItemPK.setOrderItemInfo(orderItemInfo);

            FranchiseOrderableItem franchiseOrderableItem = new FranchiseOrderableItem();
            franchiseOrderableItem.setFranchiseOrderableItem(franchiseOrderableItemPK);

            FranchiseOrder franchiseOrder = new FranchiseOrder();
            franchiseOrder.setFranchiseOrderNo(franchiseOrderNo);

            FranchiseOrderItemPK franchiseOrderItemPK = new FranchiseOrderItemPK();
            franchiseOrderItemPK.setFranchiseOrderableItem(franchiseOrderableItem);
            franchiseOrderItemPK.setFranchiseOrder(franchiseOrder);

            FranchiseOrderItem franchiseOrderItem = new FranchiseOrderItem();
            franchiseOrderItem.setFranchiseOrderItemAmount(itemAmount[i]);
            franchiseOrderItem.setFranchiseOrderItem(franchiseOrderItemPK);

            franchiseOrderItemList.add(franchiseOrderItem);
        }


        return franchiseOrderItemList;
    }

    private List<FranchiseOrderListDTO> setFranchiseOrderList(List<FranchiseOrder> franchiseOrderList, List<OrderFranchiseInfo> franchiseInfoList, List<OrderFranchiseAccount> franchiseAccountList) {

        List<FranchiseOrderListDTO> franchiseOrderListDTOList = new ArrayList<>();

        List<FranchiseOrderDTO> franchiseOrderDTOList = franchiseOrderList.stream().map(franchiseOrder -> modelMapper.map(franchiseOrder, FranchiseOrderDTO.class)).collect(Collectors.toList());  //전체 개망점 발주 목록
        List<OrderFranchiseInfoDTO> franchiseInfoDTOList = franchiseInfoList.stream().map(orderFranchiseInfo -> modelMapper.map(orderFranchiseInfo, OrderFranchiseInfoDTO.class)).collect(Collectors.toList()); //담당중인 가맹점 대표자 목록
        List<OrderFranchiseAccountDTO> franchiseAccountDTOList = franchiseAccountList.stream().map(franchiseAccount -> modelMapper.map(franchiseAccount, OrderFranchiseAccountDTO.class)).collect(Collectors.toList()); //매니저 목록

        for(int i = 0; i < franchiseOrderDTOList.size(); i++) {

            for(int j = 0; j < franchiseInfoDTOList.size(); j++) {

                int orderMemberNo = franchiseOrderDTOList.get(i).getMember().getMemberNo();
                int representativeNo = franchiseInfoDTOList.get(j).getFranchiseRepresentativeNo();

                if(orderMemberNo == representativeNo) {

                    FranchiseOrderListDTO franchiseOrderListDTO = new FranchiseOrderListDTO();
                    franchiseOrderListDTO.setFranchiseOrderItemList(franchiseOrderDTOList.get(i).getFranchiseOrderItemList());
                    franchiseOrderListDTO.setOrderFranchiseInfo(franchiseInfoDTOList.get(j));
                    franchiseOrderListDTO.setFranchiseOrderNo(franchiseOrderDTOList.get(i).getFranchiseOrderNo());
                    franchiseOrderListDTO.setFranchiseOrderOrderNumber(franchiseOrderDTOList.get(i).getFranchiseOrderOrderNumber());
                    franchiseOrderListDTO.setFranchiseOrderStatusHistoryList(franchiseOrderDTOList.get(i).getFranchiseOrderStatusHistoryList());
                    franchiseOrderListDTO.setFranchiseOrderStatus(franchiseOrderDTOList.get(i).getFranchiseOrderStatus());
                    franchiseOrderListDTO.setFranchiseOrderApplicationDate(franchiseOrderDTOList.get(i).getFranchiseOrderApplicationDate());
                    franchiseOrderListDTO.setMember(franchiseOrderDTOList.get(i).getMember());

                    if(franchiseOrderList.get(i).getFranchiseOrderStatusDate() != null) {

                        franchiseOrderListDTO.setFranchiseOrderStatusDate(franchiseOrderDTOList.get(i).getFranchiseOrderStatusDate());
                        franchiseOrderListDTO.setFranchiseOrderStatusRejectionContent(franchiseOrderDTOList.get(i).getFranchiseOrderStatusRejectionContent());
                    }

                    franchiseOrderListDTOList.add(franchiseOrderListDTO);
                }

            }

            for(int k = 0; k < franchiseAccountDTOList.size(); k++) {

                int orderMemberNo = franchiseOrderDTOList.get(i).getMember().getMemberNo();
                int managerNo = franchiseAccountDTOList.get(k).getFranchiseManagerNo();

                if(orderMemberNo == managerNo) {

                    FranchiseOrderListDTO franchiseOrderListDTO = new FranchiseOrderListDTO();
                    franchiseOrderListDTO.setFranchiseOrderItemList(franchiseOrderDTOList.get(i).getFranchiseOrderItemList());
                    franchiseOrderListDTO.setOrderFranchiseAccountDTO(franchiseAccountDTOList.get(k));
                    franchiseOrderListDTO.setFranchiseOrderNo(franchiseOrderDTOList.get(i).getFranchiseOrderNo());
                    franchiseOrderListDTO.setFranchiseOrderOrderNumber(franchiseOrderDTOList.get(i).getFranchiseOrderOrderNumber());
                    franchiseOrderListDTO.setFranchiseOrderStatusHistoryList(franchiseOrderDTOList.get(i).getFranchiseOrderStatusHistoryList());
                    franchiseOrderListDTO.setFranchiseOrderStatus(franchiseOrderDTOList.get(i).getFranchiseOrderStatus());
                    franchiseOrderListDTO.setFranchiseOrderApplicationDate(franchiseOrderDTOList.get(i).getFranchiseOrderApplicationDate());
                    franchiseOrderListDTO.setMember(franchiseOrderDTOList.get(i).getMember());
                    franchiseOrderListDTO.setOrderFranchiseInfo(franchiseAccountDTOList.get(k).getFranchiseInfo());

                    if(franchiseOrderList.get(i).getFranchiseOrderStatusDate() != null) {

                        franchiseOrderListDTO.setFranchiseOrderStatusDate(franchiseOrderDTOList.get(i).getFranchiseOrderStatusDate());
                        franchiseOrderListDTO.setFranchiseOrderStatusRejectionContent(franchiseOrderDTOList.get(i).getFranchiseOrderStatusRejectionContent());
                    }

                    franchiseOrderListDTOList.add(franchiseOrderListDTO);

                }

            }


        }

        return franchiseOrderListDTOList;
    }

    private List<FranchiseOrderListDTO> setFranchiseOrderListByFranchise(List<FranchiseOrder> franchiseOrderList, OrderFranchiseInfo orderFranchiseInfo) {

        List<FranchiseOrderListDTO> franchiseOrderListDTOList = new ArrayList<>();

        List<FranchiseOrderDTO> orderList = franchiseOrderList.stream().map(franchiseOrder -> modelMapper.map(franchiseOrder, FranchiseOrderDTO.class)).collect(Collectors.toList());
        OrderFranchiseInfoDTO orderFranchiseInfoDTO = modelMapper.map(orderFranchiseInfo, OrderFranchiseInfoDTO.class);

        for(int i = 0; i < orderList.size(); i++) {

            FranchiseOrderListDTO franchiseOrderListDTO = new FranchiseOrderListDTO();
            franchiseOrderListDTO.setFranchiseOrderItemList(orderList.get(i).getFranchiseOrderItemList());
            franchiseOrderListDTO.setOrderFranchiseInfo(orderFranchiseInfoDTO);
            franchiseOrderListDTO.setFranchiseOrderNo(orderList.get(i).getFranchiseOrderNo());
            franchiseOrderListDTO.setFranchiseOrderOrderNumber(orderList.get(i).getFranchiseOrderOrderNumber());
            franchiseOrderListDTO.setFranchiseOrderStatusHistoryList(orderList.get(i).getFranchiseOrderStatusHistoryList());
            franchiseOrderListDTO.setFranchiseOrderStatus(orderList.get(i).getFranchiseOrderStatus());
            franchiseOrderListDTO.setFranchiseOrderApplicationDate(orderList.get(i).getFranchiseOrderApplicationDate());
            franchiseOrderListDTO.setMember(orderList.get(i).getMember());

            if(franchiseOrderList.get(i).getFranchiseOrderStatusDate() != null) {

                franchiseOrderListDTO.setFranchiseOrderStatusDate(orderList.get(i).getFranchiseOrderStatusDate());
                franchiseOrderListDTO.setFranchiseOrderStatusRejectionContent(orderList.get(i).getFranchiseOrderStatusRejectionContent());
            }

            franchiseOrderListDTOList.add(franchiseOrderListDTO);

        }

        return franchiseOrderListDTOList;
    }

    private List<FranchiseOrderListDTO> setFranchiseOrderListByFranchise(List<FranchiseOrder> franchiseOrderList, OrderFranchiseInfo orderFranchiseInfo, OrderFranchiseAccount orderFranchiseAccount) {

        List<FranchiseOrderListDTO> franchiseOrderListDTOList = new ArrayList<>();

        List<FranchiseOrderDTO> orderList = franchiseOrderList.stream().map(franchiseOrder -> modelMapper.map(franchiseOrder, FranchiseOrderDTO.class)).collect(Collectors.toList());
        OrderFranchiseInfoDTO orderFranchiseInfoDTO = modelMapper.map(orderFranchiseInfo, OrderFranchiseInfoDTO.class);
        OrderFranchiseAccountDTO orderFranchiseAccountDTO = modelMapper.map(orderFranchiseAccount, OrderFranchiseAccountDTO.class);

        for(int i = 0; i < orderList.size(); i++) {

            FranchiseOrderListDTO franchiseOrderListDTO = new FranchiseOrderListDTO();
            franchiseOrderListDTO.setFranchiseOrderItemList(orderList.get(i).getFranchiseOrderItemList());
            franchiseOrderListDTO.setOrderFranchiseInfo(orderFranchiseInfoDTO);
            franchiseOrderListDTO.setFranchiseOrderNo(orderList.get(i).getFranchiseOrderNo());
            franchiseOrderListDTO.setFranchiseOrderOrderNumber(orderList.get(i).getFranchiseOrderOrderNumber());
            franchiseOrderListDTO.setFranchiseOrderStatusHistoryList(orderList.get(i).getFranchiseOrderStatusHistoryList());
            franchiseOrderListDTO.setFranchiseOrderStatus(orderList.get(i).getFranchiseOrderStatus());
            franchiseOrderListDTO.setFranchiseOrderApplicationDate(orderList.get(i).getFranchiseOrderApplicationDate());
            franchiseOrderListDTO.setMember(orderList.get(i).getMember());
            franchiseOrderListDTO.setOrderFranchiseAccountDTO(orderFranchiseAccountDTO);

            if(franchiseOrderList.get(i).getFranchiseOrderStatusDate() != null) {

                franchiseOrderListDTO.setFranchiseOrderStatusDate(orderList.get(i).getFranchiseOrderStatusDate());
                franchiseOrderListDTO.setFranchiseOrderStatusRejectionContent(orderList.get(i).getFranchiseOrderStatusRejectionContent());
            }

            franchiseOrderListDTOList.add(franchiseOrderListDTO);

        }

        return franchiseOrderListDTOList;
    }

}
