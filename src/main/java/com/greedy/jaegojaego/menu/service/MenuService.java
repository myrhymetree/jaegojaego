package com.greedy.jaegojaego.menu.service;

import com.greedy.jaegojaego.menu.dto.MenuDTO;
import com.greedy.jaegojaego.menu.dto.RawMaterialDTO;
import com.greedy.jaegojaego.menu.entity.Menu;
import com.greedy.jaegojaego.menu.entity.RawMaterial;
import com.greedy.jaegojaego.menu.repository.MenuRepository;
import com.greedy.jaegojaego.menu.repository.RawMaterialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RawMaterialRepository rawMaterialRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MenuService(MenuRepository menuRepository, RawMaterialRepository rawMaterialRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.rawMaterialRepository = rawMaterialRepository;
        this.modelMapper = modelMapper;
    }


    public List<MenuDTO> selectMenuList() {

        List<Menu> menuList = menuRepository.findAll();
        System.out.println("menuList : " + menuList);

        return menuList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());

    }

    public List<RawMaterialDTO> selectOneMenu(int menuNo) {

        List<String> stringList = rawMaterialRepository.selectStringList(menuNo);
        List<Integer> intList = rawMaterialRepository.selectintList(menuNo);

        List<RawMaterial> rawMaterialList = new ArrayList<>();
        for(int i = 0;  i < stringList.size(); i++) {

            RawMaterial rawMaterial = new RawMaterial();

            rawMaterial.setRawMaterialName(stringList.get(i));
            rawMaterial.setRawMaterialCapacity(intList.get(i));

            rawMaterialList.add(rawMaterial);
        }

        return rawMaterialList.stream().map(rawMaterial -> modelMapper.map(rawMaterial, RawMaterialDTO.class)).collect(Collectors.toList());
    }
}
