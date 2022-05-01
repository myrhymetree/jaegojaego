package com.greedy.jaegojaego.materials.model.service;

import com.greedy.jaegojaego.materials.model.dto.ClientContractItemDTO;
import com.greedy.jaegojaego.materials.model.dto.MaterialsDTO;
import com.greedy.jaegojaego.materials.model.entity.ClientContractItem;
import com.greedy.jaegojaego.materials.model.entity.Materials;
import com.greedy.jaegojaego.materials.model.repository.ClientContractItemRepository;
import com.greedy.jaegojaego.materials.model.repository.MaterialsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MaterialsService {

    private final MaterialsRepository materialsRepository;
    private final ModelMapper modelMapper;
    private final ClientContractItemRepository clientContractItemRepository;

    @Autowired
    public MaterialsService(MaterialsRepository materialsRepository, ModelMapper modelMapper, ClientContractItemRepository clientContractItemRepository){
        this.materialsRepository = materialsRepository;
        this.modelMapper = modelMapper;
        this.clientContractItemRepository = clientContractItemRepository;
    }

    public List<MaterialsDTO> findMaterialsList() {

        List<Materials> materialsList = materialsRepository.findAllProductList();

        return materialsList.stream().map(materials -> modelMapper.map(materials, MaterialsDTO.class)).collect(Collectors.toList());
    }

    public Map<String, Object> findMaterialsByCode(int itemInfoNo) {

        Map<String, Object> productAllList = new HashMap<>();

        Materials materials = materialsRepository.findByMaterialsByCode(itemInfoNo);

        MaterialsDTO materialsDTO = modelMapper.map(materials, MaterialsDTO.class);

        System.out.println("여기까지는 되나" + " " + materialsDTO);
        System.out.println("여기까지는 되나" + " " + materialsDTO);
        System.out.println("여기까지는 되나" + " " + materialsDTO);

        List<ClientContractItem> clientList =  clientContractItemRepository.findAllClientList(itemInfoNo);

        System.out.println("여기까지는 되나22" + " " + clientList);
        System.out.println("여기까지는 되나22" + " " + clientList);
        System.out.println("여기까지는 되나22" + " " + clientList);

        List<ClientContractItemDTO> clientContractItemDTO = clientList.stream().map(clientContractItem -> modelMapper.map(clientContractItem, ClientContractItemDTO.class)).collect(Collectors.toList());

        System.out.println("여기까지는 되나33" + " " + clientContractItemDTO);
        System.out.println("여기까지는 되나33" + " " + clientContractItemDTO);
        System.out.println("여기까지는 되나33" + " " + clientContractItemDTO);

        for (ClientContractItemDTO list: clientContractItemDTO
             ) {
            System.out.println("언제 돼!" + list);
        }

        productAllList.put("materialsDTO", materialsDTO);
        productAllList.put("clientContractItemDTO", clientContractItemDTO);

        return productAllList;
    }

}

