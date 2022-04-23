package com.greedy.jaegojaego.menu.service;

import com.greedy.jaegojaego.menu.dto.MenuDTO;
import com.greedy.jaegojaego.menu.dto.MenuMaterialsDTO;
import com.greedy.jaegojaego.menu.dto.RawMaterialDTO;
import com.greedy.jaegojaego.menu.entity.Menu;
import com.greedy.jaegojaego.menu.entity.MenuMaterial;
import com.greedy.jaegojaego.menu.entity.RawMaterial;
import com.greedy.jaegojaego.menu.repository.MenuMaterialRepository;
import com.greedy.jaegojaego.menu.repository.MenuRepository;
import com.greedy.jaegojaego.menu.repository.RawMaterialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : MenuService
 * Comment : Menu관련 메소드를 모아놓은 Service입니다.
 * History
 * 2022/04/18 (이소현) MenuService 기본 설정 작성
 * 2022/04/20 (이소현) 매뉴 목록 조회 , 메뉴 상세 조회
 * 2022/04/21 (이소현) 매뉴 상세 조회 비동기 페이징
 * 2022/04/22 (이소현) 매뉴 등록용 자재 리스트 조회
 * 2022/04/23 (이소현) 메뉴 등록
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see MenuRepository, RawMaterialRepository, MenuController
 * */
@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RawMaterialRepository rawMaterialRepository;
    private final ModelMapper modelMapper;
    private final MenuMaterialRepository menuMaterialRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository, RawMaterialRepository rawMaterialRepository, ModelMapper modelMapper, MenuMaterialRepository menuMaterialRepository) {
        this.menuRepository = menuRepository;
        this.rawMaterialRepository = rawMaterialRepository;
        this.modelMapper = modelMapper;
        this.menuMaterialRepository = menuMaterialRepository;
    }


    public List<MenuDTO> selectMenuList() {

        List<Menu> menuList = menuRepository.findAll();
        System.out.println("menuList : " + menuList);

        return menuList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());

    }

    public List<RawMaterialDTO> selectOneMenu(int menuNo) {

        List<RawMaterial> test = rawMaterialRepository.selectOneMenu(menuNo);
        test.forEach(System.out::println);
        System.out.println("오긴옴? : " + test);

//        List<String> stringList = rawMaterialRepository.selectStringList(menuNo);
//        List<Integer> intList = rawMaterialRepository.selectintList(menuNo);
//
//        List<RawMaterial> rawMaterialList = new ArrayList<>();
//        for(int i = 0;  i < stringList.size(); i++) {
//
//            RawMaterial rawMaterial = new RawMaterial();
//
//            rawMaterial.setRawMaterialName(stringList.get(i));
//            rawMaterial.setRawMaterialCapacity(intList.get(i));
//
//            rawMaterialList.add(rawMaterial);
//        }

        return test.stream().map(rawMaterial -> modelMapper.map(rawMaterial, RawMaterialDTO.class)).collect(Collectors.toList());
    }

    /* 비동기(ajax) 페이징 */
//    public Page<RawMaterialDTO> selectOneMenuForPaging(int menuNo, Pageable pageable) {
//
//        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
//                pageable.getPageSize(),
//                Sort.by("rawMaterialName").descending());
//
//        Page<RawMaterial> oneMenuList = rawMaterialRepository.findAll(pageable);
//
//        return oneMenuList.map(rawMaterial -> modelMapper.map(rawMaterial, RawMaterialDTO.class));
//    }

    public List<MenuMaterialsDTO> findRawMaterialList() {

        List<MenuMaterial> rawMaterialList = menuMaterialRepository.findAll();

        rawMaterialList.forEach(System.out::println);

        return rawMaterialList.stream().map(menuMaterial -> modelMapper.map(menuMaterial, MenuMaterialsDTO.class)).collect(Collectors.toList());
    }
}
