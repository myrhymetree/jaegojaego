package com.greedy.jaegojaego.client.model.service;

import com.greedy.jaegojaego.client.model.dto.ClientDTO;
import com.greedy.jaegojaego.client.model.entity.Client;
import com.greedy.jaegojaego.client.model.repository.ClientRepository;
import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    private final ClientRepository clientRepository;

    private final ModelMapper modelMapper;

    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
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

    public Page<ClientDTO> findClientList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("clientNo").descending());

    return clientRepository.findClientByClientNo(new Integer(1), pageable).map(client -> modelMapper.map(client, ClientDTO.class));




    }
}
