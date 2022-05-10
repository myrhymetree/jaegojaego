<<<<<<< HEAD
=======
package com.greedy.jaegojaego.client.model.service;

import com.greedy.jaegojaego.client.model.dto.*;
import com.greedy.jaegojaego.client.model.entity.*;
import com.greedy.jaegojaego.client.model.repository.*;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMemoRepository clientMemoRepository;
    private final ClientBusinessTypeRepository clientBusinessTypeRepository;
    private final ClientBusinessItemRepository clientBusinessItemRepository;
    private final ClientMemberRepository clientMemberRepository;
    private final ClientBusinessItemDivisionRepository clientBusinessItemDivisionRepository;
    private final ClientBusinessTypeDivisionRepository clientBusinessTypeDivisionRepository;
    private final ClientContractInfoRepository clientContractInfoRepository;
    private final ClientContractItemRepository clientContractItemRepository;

    private final ClientContractItemAttachmentFileRepository clientContractItemAttachmentFileRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientMemoRepository clientMemoRepository, ClientBusinessTypeRepository clientBusinessTypeRepository, ClientBusinessItemRepository clientBusinessItemRepository, ClientMemberRepository clientMemberRepository, ClientBusinessItemDivisionRepository clientBusinessItemDivisionRepository, ClientBusinessTypeDivisionRepository clientBusinessTypeDivisionRepository, ClientContractInfoRepository clientContractInfoRepository, ClientContractItemRepository clientContractItemRepository, ClientContractItemAttachmentFileRepository clientContractItemAttachmentFileRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.clientMemoRepository = clientMemoRepository;
        this.clientBusinessTypeRepository = clientBusinessTypeRepository;
        this.clientBusinessItemRepository = clientBusinessItemRepository;
        this.clientMemberRepository = clientMemberRepository;
        this.clientBusinessItemDivisionRepository = clientBusinessItemDivisionRepository;
        this.clientBusinessTypeDivisionRepository = clientBusinessTypeDivisionRepository;
        this.clientContractInfoRepository = clientContractInfoRepository;
        this.clientContractItemRepository = clientContractItemRepository;
        this.clientContractItemAttachmentFileRepository = clientContractItemAttachmentFileRepository;
        this.modelMapper = modelMapper;
    }

    public Page<ClientDTO> findClientSearchList(String searchCondition, String searchValue, Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("clientNo").descending());

        Page<Client> clientList = null;

/*        if(searchCondition.equals("clientName")){
            clientList = clientRepository.findByClientNameContainingAnyTypeAndStatus(searchValue, new Integer(1), "Y", pageable);
        } else if(searchCondition.equals("clientRepresentativeNameTypeAndStatus")){
            clientList = clientRepository.findByClientRepresentativeNameContainingTypeAndStatus(searchValue, new Integer(1), "Y", pageable);
        }*/

        return clientList.map(client -> modelMapper.map(client, ClientDTO.class));
    }

    /* 거래처 목록 조회용 메소드 (뷰페이지 좌측 영역) */
    public Page<ClientDTO> findClientList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("clientNo").descending());

    return clientRepository.findAll(pageable).map(client -> modelMapper.map(client, ClientDTO.class));

    }

    /* 거래처 상세 조회용 메소드 (뷰페이지 우측 영역) */
    @Transactional
    public List<ClientContractInfoDTO> findClientDetailByClientNo(int clientNo) {

       List<ClientContractInfo> clientContractInfoList = new ArrayList<>();

       clientContractInfoList = clientContractInfoRepository.findByClient(clientNo);

       return clientContractInfoList.stream().map(clientContractInfo -> modelMapper.map(clientContractInfo, ClientContractInfoDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public List<ClientMemoDTO> findClientMemoByClientNo(int clientNo) {

        List<ClientMemo> clientMemoList = new ArrayList<>();

        clientMemoList = clientMemoRepository.findByClientNo(clientNo);

        return clientMemoList.stream().map(clientMemo -> modelMapper.map(clientMemo, ClientMemoDTO.class)).collect(Collectors.toList());
    }

    public List<ClientBusinessTypeDTO> findClientBusinessType() {

        List<ClientBusinessType> clientBusinessTypeList = new ArrayList<>();

        clientBusinessTypeList = clientBusinessTypeRepository.findAll();

        return clientBusinessTypeList.stream().map(clientBusinessType -> modelMapper.map(clientBusinessType, ClientBusinessTypeDTO.class)).collect(Collectors.toList());


    }


    public List<ClientBusinessItemDTO> findClientBusinessItem() {

        List<ClientBusinessItem> clientBusinessItemList = new ArrayList<>();

        clientBusinessItemList = clientBusinessItemRepository.findAll();

        return clientBusinessItemList.stream().map(clientBusinessItem -> modelMapper.map(clientBusinessItem, ClientBusinessItemDTO.class)).collect(Collectors.toList());
    }

    public ClientMember findClientLoginNo(int memberNo) {

        ClientMember clientMember = clientMemberRepository.findByClientMemberNo(memberNo);

        return clientMember;
    }


/*    public void registClient(ClientDTO clientDTO) {

        Client newClient = new Client();

        newClient.setClientName(clientDTO.getClientName());
        newClient.setClientCbrNo(clientDTO.getClientCbrNo());
        newClient.setClientRepresentativeName(clientDTO.getClientRepresentativeName());
        newClient.setClientRepresentativePhone(clientDTO.getClientRepresentativePhone());
        newClient.setClientRepresentativeEmail(clientDTO.getClientRepresentativeEmail());
        newClient.setClientAddress(clientDTO.getClientAddress());
        newClient.setClientMember(clientDTO.getClientMemberNo());
        newClient.setClientCreatedDate(new Date(System.currentTimeMillis()));
        newClient.setClientPaymentMethod("일시불");

        System.out.println("newClient : " + newClient);

        clientRepository.save(newClient);
    }


    public void registClientBusinessItemDevision(ClientBusinessItemDvisionDTO clientBusinessItemDevisionDTO) {

        ClientBusinessItemDivisionPK newClientBusinessItemDivisionPK = new ClientBusinessItemDivisionPK();
        newClientBusinessItemDivisionPK.setClientNo(clientBusinessItemDevisionDTO.getClientNo());
        newClientBusinessItemDivisionPK.setClientBusinessItemNo(clientBusinessItemDevisionDTO.getClientBusinessItemNo());

        ClientBusinessItemDivision newClientBusinessItemDivision = new ClientBusinessItemDivision();
        newClientBusinessItemDivision.setClientBusinessItemDivisionPK(newClientBusinessItemDivisionPK);

        clientBusinessItemDivisionRepository.save(newClientBusinessItemDivision);
    }


    public void registClientBusinessTypeDevision(ClientBusinessTypeDvisionDTO clientBusinessTypeDvisionDTO) {

        ClientBusinessTypeDivisionPK newClientBusinessTypeDivisionPK = new ClientBusinessTypeDivisionPK();
        newClientBusinessTypeDivisionPK.setClientNo(clientBusinessTypeDvisionDTO.getClientNo());
        newClientBusinessTypeDivisionPK.setClientBusinessTypeNo(clientBusinessTypeDvisionDTO.getClientBusinessTypeNo());

        ClientBusinessTypeDivision newClientBusinessTypeDivision = new ClientBusinessTypeDivision();
        newClientBusinessTypeDivision.setClientBusinessTypeDivisionPK(newClientBusinessTypeDivisionPK);

        clientBusinessTypeDivisionRepository.save(newClientBusinessTypeDivision);
    }

    public void registClientContractInfo(ClientContractInfoDTO clientContractInfoDTO) {

        ClientContractInfo newClientContractInfo = new ClientContractInfo();

        newClientContractInfo.setClientNo(clientContractInfoDTO.getClientNo());
        newClientContractInfo.setClientContractInfoStartdate(clientContractInfoDTO.getClientContractInfoStartDate());
        newClientContractInfo.setClientContractInfoEnddate(clientContractInfoDTO.getClientContractInfoEndDate());
        newClientContractInfo.setClientContractInfoStatus("거래중");

        clientContractInfoRepository.save(newClientContractInfo);

    }

    public int findClientNoByName(String clientName) {

        int clientInsertNo = clientRepository.findClientNoByClientName(clientName);

        return clientInsertNo;
    }*/

    public void deleteClient(int clientNo) {

        clientRepository.deleteById(clientNo);
    }

    public Page<ClientContractItemDTO> findClientItemSearchList(String searchCondition, String searchValue, Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("clientContractItemNo").descending());

        Page<ClientContractItem> clientContractItemList = null;

/*        if(searchCondition.equals("clientName")){
            clientList = clientRepository.findByClientNameContainingAnyTypeAndStatus(searchValue, new Integer(1), "Y", pageable);
        } else if(searchCondition.equals("clientRepresentativeNameTypeAndStatus")){
            clientList = clientRepository.findByClientRepresentativeNameContainingTypeAndStatus(searchValue, new Integer(1), "Y", pageable);
        }*/

        return clientContractItemList.map(clientContractItem -> modelMapper.map(clientContractItem, ClientContractItemDTO.class));
    }


    public Page<ClientContractItemDTO> findClientItemList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("CLIENT_CONTRACT_ITEM_NO").descending());

        Page<ClientContractItemDTO> clientContractItemList = clientContractItemRepository.findAll(pageable).map(clientContractItem -> modelMapper.map(clientContractItem, ClientContractItemDTO.class));

        System.out.println("컨트롤러" + clientContractItemList);
        return clientContractItemList;
    }

    public ClientBusinessItem findClientBusinessItemNo(int clientBusinessItemNo) {

        ClientBusinessItem clientBusinessItem = clientBusinessItemRepository.findByClientBusinessItemNo(clientBusinessItemNo);

        return clientBusinessItem;
    }

    public ClientBusinessType findClientBusinessTypeNo(int clientBusinessTypeNo) {

        ClientBusinessType clientBusinessType = clientBusinessTypeRepository.findByClientBusinessTypeNo(clientBusinessTypeNo);

        return clientBusinessType;
    }

    public void registClient(ClientDTO client, ClientContractInfoDTO clientContractInfo) {

        Client newClient = new Client();

        newClient.setClientName(client.getClientName());
        newClient.setClientCbrNo(client.getClientCbrNo());
        newClient.setClientRepresentativeName(client.getClientRepresentativeName());
        newClient.setClientRepresentativePhone(client.getClientRepresentativePhone());
        newClient.setClientRepresentativeEmail(client.getClientRepresentativeEmail());
        newClient.setClientAddress(client.getClientAddress());
        newClient.setClientMember(client.getClientMemberNo());
        newClient.setClientCreatedDate(new Date(System.currentTimeMillis()));
        newClient.setClientPaymentMethod("일시불");

        System.out.println("newClient : " + newClient);

        clientRepository.save(newClient);

        Client clientNo = clientRepository.findByClientName(newClient.getClientName());

        ClientContractInfo newClientContractInfo = new ClientContractInfo();

        newClientContractInfo.setClientContractInfoStatus("계약중");
        newClientContractInfo.setClientContractInfoStartdate(clientContractInfo.getClientContractInfoStartDate());
        newClientContractInfo.setClientContractInfoEnddate(clientContractInfo.getClientContractInfoEndDate());
        newClientContractInfo.setClient(clientNo);

        clientContractInfoRepository.save(newClientContractInfo);

    }

    public List<ClientDTO> findClient() {

        List<Client> clientList = new ArrayList<>();

        clientList = clientRepository.findAll();

        System.out.println("왜안돼? : " + clientList);

        return clientList.stream().map(Client -> modelMapper.map(Client, ClientDTO.class)).collect(Collectors.toList());
    }


    public ClientContractInfo findClientContractInfoNoByClientNo(int clientNo) {

        ClientContractInfo clientContractInfo = clientContractItemRepository.findByClient(clientNo);

        return clientContractInfo;
    }

    @Transactional
    public void registClientContractItem(ClientContractItemDTO clientContractItem, List<ClientContractItemAttachmentFileDTO> clientContractItemAttachmentFile) {
/*
    ClientContractItem registClientContractItem = modelMapper.map(clientContractItem, ClientContractItem.class);

    List<ClientContractItemAttachmentFile> registClientContractItemAttachmentFileList = null;

    if(clientContractItemAttachmentFile != null){
        registClientContractItemAttachmentFileList = clientContractItemAttachmentFile.stream().map(clientContractItemAttachmentFileDTO -> modelMapper.map(clientContractItemAttachmentFile,ClientContractItemAttachmentFile.class)).collect(Collectors.toList());
    }

        ClientContractItem newClientContractItem = new ClientContractItem();

        newClientContractItem.setClientContractItemName(clientContractItem.getClientContractItemName());
        newClientContractItem.setClientContractItemSupplyPrice(clientContractItem.getClientContractItemSupplyPrice());
*//*
        newClientContractItem.setClientContractInfoNo(clientContractItem.getClientContractInfoNo());
*//*
        newClientContractItem.setClientContractItemCreatedDate(new Date(System.currentTimeMillis()));

        clientContractItemRepository.save(newClientContractItem);

    if(registClientContractItemAttachmentFileList != null){

        for(int i = 0; i < registClientContractItemAttachmentFileList.size(); i++){

            registClientContractItemAttachmentFileList.get(i).setClientContractItem(registClientContractItem);

            clientContractItemAttachmentFileRepository.save(registClientContractItemAttachmentFileList.get(i));
        }
    }*/

    }
}
>>>>>>> origin/feature/client-2
