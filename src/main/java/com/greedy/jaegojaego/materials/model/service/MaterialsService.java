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
    private final MaterialFranchiseOrderableItemRepository materialFranchiseOrderableItemRepository;
    private final MaterialRepository materialRepository;
    private final MaterialProductRepository materialProductRepository;
    @Autowired
    public MaterialsService(MaterialsRepository materialsRepository, ModelMapper modelMapper, MaterialsClientContractItemRepository clientContractItemRepository, MaterialsClientContractItemMaterialRepository clientContractItemMaterialRepository,
                            MaterialsClientUpdateRepository materialsClientUpdateRepository, MaterialsCategoryRepository materialsCategoryRepository, MaterialFranchiseOrderableItemRepository materialFranchiseOrderableItemRepository, MaterialRepository materialRepository, MaterialProductRepository materialProductRepository){
        this.materialsRepository = materialsRepository;
        this.modelMapper = modelMapper;
        this.clientContractItemRepository = clientContractItemRepository;
        this.clientContractItemMaterialRepository = clientContractItemMaterialRepository;
        this.materialsClientUpdateRepository = materialsClientUpdateRepository;
        this.materialsCategoryRepository = materialsCategoryRepository;
        this.materialFranchiseOrderableItemRepository = materialFranchiseOrderableItemRepository;
        this.materialRepository = materialRepository;
        this.materialProductRepository = materialProductRepository;
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

        MaterialsCategory category = materialsCategoryRepository.findByMaterialCategoryName(materialDTO.getMaterialsCategory().getMaterialCategoryName());
        FranchiseOrderableItem franchiseOrderableItem = materialFranchiseOrderableItemRepository.findById(materialDTO.getItemInfoNo()).get();
        Material material = materialRepository.findById(materialDTO.getItemInfoNo()).get();

        material.setItemInfoName(materialDTO.getItemInfoName());
        material.setItemSerialNo(materialDTO.getItemSerialNo());
        material.setMaterialCategory(category);
        material.setSubdivisionUnit(materialDTO.getSubdivisionUnit());
        material.setSubdivisionYN(materialDTO.getSubdivisionYN());
        franchiseOrderableItem.setItemPrice(materialDTO.getFranchiseOrderableItem().getItemPrice());
        material.setFranchiseOrderableItem(franchiseOrderableItem);
    }

    public void removeMaterial(int itemInfoNo) {

        Material material = materialRepository.findById(itemInfoNo).get();
        material.setItemStatus("Y");
    }

    public List<MaterialsCategoryDTO> findCategory() {

        List<MaterialsCategory> categoryList = materialsCategoryRepository.findAll();

        return categoryList.stream().map(materialsCategory -> modelMapper.map(materialsCategory, MaterialsCategoryDTO.class)).collect(Collectors.toList());
    }

    public Integer findMaterialCount() {

        Integer materialConut = materialRepository.findByIdCount() + 1;

        System.out.println("테스트 " + materialConut);
        System.out.println("테스트 " + materialConut);
        System.out.println("테스트 " + materialConut);
        return materialConut;
    }

    @Transactional
    public void MaterialsProductRegist(MaterialProductDTO material) {

        System.out.println("여기까지 올거야!");

        System.out.println("들오긴하냐? : " + material);

        MaterialProduct materialRegist = new MaterialProduct();
        FranchiseOrderableItem franchiseOrderableItem = new FranchiseOrderableItem();

//        System.out.println("왜? :" + franchiseOrderableItem);
//        MaterialsCategory materialsCategory = new MaterialsCategory();
          franchiseOrderableItem.setItemInfoNo(material.getItemInfoNo());
          franchiseOrderableItem.setItemPrice(material.getFranchiseOrderableItem().getItemPrice());
//        materialsCategory.setMaterialCategoryNo(material.getMaterialCategory());

        materialRegist.setItemInfoNo(material.getItemInfoNo());
        materialRegist.setItemInfoName(material.getItemInfoName());
        materialRegist.setItemSerialNo(material.getItemSerialNo());
        materialRegist.setMaterialCategory(material.getMaterialCategory());
        materialRegist.setSubdivisionUnit(material.getSubdivisionUnit());
        materialRegist.setSubdivisionYN(material.getSubdivisionYN());
        materialRegist.setItemStatus("N");
        System.out.println("materialRegist" + " " + materialRegist);

        materialProductRepository.save(materialRegist);
        materialFranchiseOrderableItemRepository.save(franchiseOrderableItem);

    }
    @Transactional
    public void materialFileRegist(MaterialFileDTO materialFileDTO) {

        MaterialFile materialFile = new MaterialFile();
        MaterialFileCategory materialFileCategory = new MaterialFileCategory();
        materialFileCategory.setFileCategoryNo(materialFileDTO.getMaterialFileCategory().getFileCategoryNo());

        materialFile.setFileOriginalName(materialFileDTO.getFileOriginalName());
        materialFile.setFileChangedName(materialFileDTO.getFileChangedName());
        materialFile.setFileUrl(materialFileDTO.getFileUrl());
        materialFile.setDeleteYn(materialFileDTO.getDeleteYn());
        materialFile.setThumbnailUrl(materialFileDTO.getThumbnailUrl());
        materialFile.setFileDivision(materialFileDTO.getFileDivision());
        materialFile.setItemInfoNo(materialFileDTO.getItemInfoNo());
        materialFile.setFileCategory(materialFileCategory);

    }
}

