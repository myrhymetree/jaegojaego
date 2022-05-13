package com.greedy.jaegojaego.materials.model.service;

import com.greedy.jaegojaego.materials.model.dto.*;
import com.greedy.jaegojaego.materials.model.entity.*;
import com.greedy.jaegojaego.materials.model.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * <pre>
 * Class : MaterialsService
 * Comment : 자재관련 메소드를 모아놓은 MaterialsService.
 *           자재생성, 수정, 삭제, 거래처와의 매핑, 상세보기 , 거래처 목록, 자재 목록
 *           이 있습니다.
 *
 * History
 * 2022/04/19 (김영광) MaterialsController 뷰 완성 후 시범 동작
 * 2022/04/20 ~ 4/21 (김영광) 자재 목록 조회
 * 2022/04/24 (김영광) 자재 상세 페이지 조회
 * 2022/04/26 (김영광) 매핑 자재 비동기 목록 조회
 * 2022/04/27 (김영광) 매핑 자재 비동기 목록 조회
 * 2022/04/28 (김영광) 자재 매핑 등록
 * 2022/04/29 (김영광) 자재 매핑 등록
 * 2022/05/01 (김영광) 자재 매핑 등록
 * 2022/05/02 (김영광) 매핑 거래처 비동기 목록 조호;
 * 2022/05/03 (김영광) 매핑 거래처 비동기 목록 조호;
 * 2022/05/04 (김영광) 거래처 매핑 등록;
 * 2022/05/05 (김영광) 거래처 자재 매핑 매치;
 * 2022/05/06 (김영광) 거래처 자재 매핑 매치;
 * 2022/05/08 (김영광) 자재 수정;
 * 2022/05/09 (김영광) 자재 수정;
 * 2022/05/10 (김영광) 자재 삭제
 * 2022/05/11 (김영광) 자재 생성
 * 2022/05/12 (김영광) 사진 파일 업로드 등록
 *
 * </pre>
 * @version 18
 * @author 김영광
 */
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
    private final MaterialFileRepository materialFileRepository;

    private final MaterialAmauntRepository materialAmauntRepository;

    @Autowired
    public MaterialsService(MaterialsRepository materialsRepository, ModelMapper modelMapper, MaterialsClientContractItemRepository clientContractItemRepository, MaterialsClientContractItemMaterialRepository clientContractItemMaterialRepository,
                            MaterialsClientUpdateRepository materialsClientUpdateRepository, MaterialsCategoryRepository materialsCategoryRepository, MaterialFranchiseOrderableItemRepository materialFranchiseOrderableItemRepository, MaterialRepository materialRepository, MaterialProductRepository materialProductRepository, MaterialFileRepository materialFileRepository, MaterialAmauntRepository materialAmauntRepository){
        this.materialsRepository = materialsRepository;
        this.modelMapper = modelMapper;
        this.clientContractItemRepository = clientContractItemRepository;
        this.clientContractItemMaterialRepository = clientContractItemMaterialRepository;
        this.materialsClientUpdateRepository = materialsClientUpdateRepository;
        this.materialsCategoryRepository = materialsCategoryRepository;
        this.materialFranchiseOrderableItemRepository = materialFranchiseOrderableItemRepository;
        this.materialRepository = materialRepository;
        this.materialProductRepository = materialProductRepository;
        this.materialFileRepository = materialFileRepository;
        this.materialAmauntRepository = materialAmauntRepository;
    }

    /**
     * findAllProductList : 자재 목록 전체 리스트 조회
     *
     * @return ml : 메뉴 전체 리스트
     * */
    public List<MaterialsDTO> findMaterialsList() {

        List<Materials> materialsList = materialsRepository.findAllProductList();

        List<MaterialsDTO> ml = new ArrayList<>();
        materialsList.forEach(materials -> {
            MaterialsDTO materialsDTO = modelMapper.map(materials, MaterialsDTO.class);
            materialsDTO.setMaterialsCategory(modelMapper.map(materials.getMaterialCategory(),MaterialsCategoryDTO.class ));
            ml.add(materialsDTO);
        });

        ml.forEach(m ->{
            System.out.println("m.getMaterialsCategory() = " + m.getMaterialsCategory());
        });

        return ml;
    }

    /**
     * findByMaterialsByCode : 선택한 자재 목록 조회
     * findAllClientList : 선택한 자재와 매핑된 거래처 목록 조회
     * @param itemInfoNo : 선택한 자재 번호
     *
     * @return productAllList : 선택한 자재와 매핑된 거래처 목록
     * */
    public Map<String, Object> findMaterialsByCode(int itemInfoNo) {

        Map<String, Object> productAllList = new HashMap<>();

        Materials materials = materialsRepository.findByMaterialsByCode(itemInfoNo);

        MaterialsDTO materialsDTO = modelMapper.map(materials, MaterialsDTO.class);

        List<ClientContractItem> clientList =  clientContractItemRepository.findAllClientList(itemInfoNo);

        List<ClientContractItemDTO> clientContractItemDTO = clientList.stream().map(clientContractItem -> modelMapper.map(clientContractItem, ClientContractItemDTO.class)).collect(Collectors.toList());

        for (ClientContractItemDTO list: clientContractItemDTO
             ) {
            System.out.println("list" + list);
        }

        productAllList.put("materialsDTO", materialsDTO);
        productAllList.put("clientContractItemDTO", clientContractItemDTO);

        return productAllList;
    }

    /**
     * findClientList : 거래처 목록 전체 조회
     *
     * @return : 거래처 목록 리스트
     * */
    public List<ClientContractItemMaterialDTO> findClientList() {

        List<ClientContractItemMaterial> clientMaterialList = clientContractItemMaterialRepository.findClientList();

        return clientMaterialList.stream().map(clientMaterial -> modelMapper.map(clientMaterial, ClientContractItemMaterialDTO.class)).collect(Collectors.toList());
    }

    /**
     * findClientList : 거래처 목록 전체 조회
     *
     * @param clientMaterialUpdateDTO : 거래처와 매핑할 자재 정보
     * @return : 거래처 목록 리스트
     * */
    @Transactional
    public void updateMapping(ClientMaterialUpdateDTO clientMaterialUpdateDTO) {

        ClientMaterialUpdate clientMaterialUpdate = materialsClientUpdateRepository.findUpdate(clientMaterialUpdateDTO.getClientItemNo());
        clientMaterialUpdate.setItemInfoNo(clientMaterialUpdateDTO.getItemInfoNo());
    }

    /**
     * findByMaterialCategoryName : 선택한 카테고리 이름 수정
     * findById : 해당 번호로 자재 가격 조회
     * findById : 해당 번호로 자재 정보 조회
     * @param materialDTO : 수정할 자재 정보
     *
     * @return : 수정된 자재 정보
     *
     * */
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

    /**
     * findById : 선택한 자재 번호로 정보 조회
     * @param itemInfoNo : 삭제할 자재 번호
     * */
    @Transactional
    public void removeMaterial(int itemInfoNo) {

        Material material = materialRepository.findById(itemInfoNo).get();
        material.setItemStatus("Y");
    }

    /**
     * findAll : 카테고리 전체 목록 리스트 조회
     *
     * @return MaterialsCategoryDTO : 카테고리 전체 목록 리스트 반환
     * */
    public List<MaterialsCategoryDTO> findCategory() {

        List<MaterialsCategory> categoryList = materialsCategoryRepository.findAll();

        return categoryList.stream().map(materialsCategory -> modelMapper.map(materialsCategory, MaterialsCategoryDTO.class)).collect(Collectors.toList());
    }

    /**
     * findByIdCount : 등록된 자재 행 갯수 조회
     *
     * @return materialConut : 등록된 자재 행 갯수
     * */
    public Integer findMaterialCount() {

        Integer materialConut = materialRepository.findByIdCount() + 1;

        return materialConut;
    }

    /**
     * save : 등록할 자재 정보
     * save : 등록할 자재 가격
     * @param material : 등록할 자재 정보
     * */
    @Transactional
    public void materialsProductRegist(MaterialProductDTO material) {

        MaterialProduct materialRegist = new MaterialProduct();
        FranchiseOrderableItem franchiseOrderableItem = new FranchiseOrderableItem();
        MaterialItemAmount materialItemAmount = new MaterialItemAmount();

        materialItemAmount.setItemInfoNo(material.getItemInfoNo());
        franchiseOrderableItem.setItemInfoNo(material.getItemInfoNo());
        franchiseOrderableItem.setItemPrice(material.getFranchiseOrderableItem().getItemPrice());

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
        materialAmauntRepository.save(materialItemAmount);

    }

    /**
     * save : 등록할 자재 이미지 정보
     * @param materialFileDTO : 등록할 자재 이미지 정보
     * */
    @Transactional
    public void materialFileRegist(MaterialFileDTO materialFileDTO) {

        MaterialFile materialFile = new MaterialFile();

        materialFile.setFileOriginalName(materialFileDTO.getFileOriginalName());
        materialFile.setFileChangedName(materialFileDTO.getFileChangedName());
        materialFile.setFileUrl(materialFileDTO.getFileUrl());
        materialFile.setDeleteYn(materialFileDTO.getDeleteYn());
        materialFile.setThumbnailUrl(materialFileDTO.getThumbnailUrl());
        materialFile.setFileDivision(materialFileDTO.getFileDivision());
        materialFile.setItemInfoNo(materialFileDTO.getItemInfoNo());
        materialFile.setMaterialFileCategory(materialFileDTO.getMaterialFileCategory());

        materialFileRepository.save(materialFile);

    }
}

