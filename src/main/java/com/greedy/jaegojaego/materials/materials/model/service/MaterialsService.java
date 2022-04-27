package com.greedy.jaegojaego.materials.model.service;

import com.greedy.jaegojaego.materials.model.dto.MaterialsDTO;
import com.greedy.jaegojaego.materials.model.entity.Materials;
import com.greedy.jaegojaego.materials.model.repository.MaterialsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialsService {

    private final MaterialsRepository materialsRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MaterialsService(MaterialsRepository materialsRepository, ModelMapper modelMapper){
        this.materialsRepository = materialsRepository;
        this.modelMapper = modelMapper;
    }

    public List<MaterialsDTO> findMaterialsList() {

        System.out.println("안들어오나");
        System.out.println("안들어오나");
        System.out.println("안들어오나");

        List<Materials> materialsList = materialsRepository.findAllProductList();

        System.out.println("확인용" + "" + materialsList);
        System.out.println("확인용" + "" + materialsList);
        System.out.println("확인용" + "" + materialsList);
        System.out.println("확인용" + "" + materialsList);
        System.out.println("확인용" + "" + materialsList);

        return materialsList.stream().map(materials -> modelMapper.map(materials, MaterialsDTO.class)).collect(Collectors.toList());
    }

    public MaterialsDTO findMaterialsByCode(int itemInfoNo) {

        Materials materials = materialsRepository.findByMaterialsByCode(itemInfoNo);

        return modelMapper.map(materials, MaterialsDTO.class);
    }

}

