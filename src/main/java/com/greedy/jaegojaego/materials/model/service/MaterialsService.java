package com.greedy.jaegojaego.materials.model.service;

import com.greedy.jaegojaego.materials.model.dto.*;
import com.greedy.jaegojaego.materials.model.entity.*;
import com.greedy.jaegojaego.materials.model.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MaterialsService {

    private final MaterialsRepository materialsRepository;
    private final ModelMapper modelMapper;
    private final MaterialsClientContractItemRepository clientContractItemRepository;
    private final MaterialsClientContractItemMaterialRepository clientContractItemMaterialRepository;
    private final MaterialsClientUpdateRepository materialsClientUpdateRepository;
    private final MaterialsCategoryRepository materialsCategoryRepository;

    @Autowired
    public MaterialsService(MaterialsRepository materialsRepository, ModelMapper modelMapper, MaterialsClientContractItemRepository clientContractItemRepository, MaterialsClientContractItemMaterialRepository clientContractItemMaterialRepository,
                            MaterialsClientUpdateRepository materialsClientUpdateRepository, MaterialsCategoryRepository materialsCategoryRepository){
        this.materialsRepository = materialsRepository;
        this.modelMapper = modelMapper;
        this.clientContractItemRepository = clientContractItemRepository;
        this.clientContractItemMaterialRepository = clientContractItemMaterialRepository;
        this.materialsClientUpdateRepository = materialsClientUpdateRepository;
        this.materialsCategoryRepository = materialsCategoryRepository;
    }

    public List<MaterialsDTO> findMaterialsList() {

        List<Materials> materialsList = materialsRepository.findAllProductList();

        return materialsList.stream().map(materials -> modelMapper.map(materials, MaterialsDTO.class)).collect(Collectors.toList());
    }

    public Map<String, Object> findMaterialsByCode(int itemInfoNo) {

        Map<String, Object> productAllList = new HashMap<>();

        Materials materials = materialsRepository.findByMaterialsByCode(itemInfoNo);

        MaterialsDTO materialsDTO = modelMapper.map(materials, MaterialsDTO.class);

        List<ClientContractItem> clientList =  clientContractItemRepository.findAllClientList(itemInfoNo);

        List<ClientContractItemDTO> clientContractItemDTO = clientList.stream().map(clientContractItem -> modelMapper.map(clientContractItem, ClientContractItemDTO.class)).collect(Collectors.toList());

        for (ClientContractItemDTO list: clientContractItemDTO
             ) {
            System.out.println("언제 돼!" + list);
        }

        productAllList.put("materialsDTO", materialsDTO);
        productAllList.put("clientContractItemDTO", clientContractItemDTO);

        return productAllList;
    }


    public List<ClientContractItemMaterialDTO> findClientList() {

        List<ClientContractItemMaterial> clientMaterialList = clientContractItemMaterialRepository.findClientList();

        return clientMaterialList.stream().map(clientMaterial -> modelMapper.map(clientMaterial, ClientContractItemMaterialDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public void updateMapping(/*ClientContractItemMaterialDTO clientContractItemMaterialDTO*/ ClientMaterialUpdateDTO clientMaterialUpdateDTO) {

        ClientMaterialUpdate clientMaterialUpdate = materialsClientUpdateRepository.findUpdate(clientMaterialUpdateDTO.getClientItemNo());
        clientMaterialUpdate.setItemInfoNo(clientMaterialUpdateDTO.getItemInfoNo());
    }

    @Transactional
    public void materialModify(MaterialDTO materialDTO) {

        System.out.println("test1");
        MaterialsCategoryDTO materialsCategoryDTO = new MaterialsCategoryDTO();
        MaterialsCategory category = materialsCategoryRepository.findByMaterialCategoryName(materialDTO.getMaterialsCategory().getMaterialCategoryName());
        System.out.println("category = " + category);

        System.out.println("teste2");
        System.out.println("materialsDTO.getItemInfoNo() = " + materialDTO.getItemInfoNo());
        Materials materials = materialsRepository.findById(materialDTO.getItemInfoNo()).get();
        System.out.println("teste3");
        System.out.println("materialsDTO.getMaterialsCategory().getMaterialCategoryName() = " + materialDTO.getMaterialsCategory().getMaterialCategoryName());

        System.out.println("teste4");
        //        MaterialsCategory materialsCategory = materialsCategoryRepository.findByName(MaterialsDTO.getMaterialsCategory()).get();
        materials.setItemInfoNo(materialDTO.getItemInfoNo());
        materials.setItemInfoName(materialDTO.getItemInfoName());
        materials.setItemSerialNo(materialDTO.getItemSerialNo());
        materials.setMaterialCategory(category);
        materials.setSubdivisionUnit(materialDTO.getSubdivisionUnit());
        materials.setSubdivisionYN(materialDTO.getSubdivisionYN());
        materials.setItemPrice(materialDTO.getItemPrice());
    }
}

