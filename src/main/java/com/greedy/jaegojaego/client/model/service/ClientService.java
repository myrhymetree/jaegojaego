package com.greedy.jaegojaego.client.model.service;

import com.greedy.jaegojaego.client.model.dto.ClientDTO;
import com.greedy.jaegojaego.client.model.dto.ClientDetailDTO;
import com.greedy.jaegojaego.client.model.dto.ClientMemoDTO;
import com.greedy.jaegojaego.client.model.entity.Client;
import com.greedy.jaegojaego.client.model.entity.ClientMemo;
import com.greedy.jaegojaego.client.model.repository.ClientMemoRepository;
import com.greedy.jaegojaego.client.model.repository.ClientRepository;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMemoRepository clientMemoRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientMemoRepository clientMemoRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.clientMemoRepository = clientMemoRepository;
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
    public ClientDetailDTO findClientDetailByClientNo(int clientNo) {

       Client client = clientRepository.findById(clientNo).get();

        return modelMapper.map(client, ClientDetailDTO.class);
    }

    @Transactional
    public List<ClientMemoDTO> findClientMemoByClientNo(int clientNo) {
        System.out.println("메모 서비스 도착");
        System.out.println("clientNo : " + clientNo);

        List<ClientMemo> clientMemoList = new ArrayList<>();

        clientMemoList = clientMemoRepository.findByClientNo(clientNo);

        System.out.println("clientMemoList : " + clientMemoList);

        return clientMemoList.stream().map(clientMemo -> modelMapper.map(clientMemo, ClientMemoDTO.class)).collect(Collectors.toList());
    }
}
