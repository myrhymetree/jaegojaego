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
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void registMenu(MenuDTO menu, MenuMaterialsDTO menuMaterial, String materialNameAndCapacityList) {

        String[] rawMaterialList = materialNameAndCapacityList.split(",");
        // rawMaterialList[0] = 루누아나 원두 1kg/60g
        List<String[]> stringList = new ArrayList<>();
        // stringList[0] = 루누아나 원두
        // stringList[1] = 60g

        //그 원두3개잖아? 3개당 자재번호도 3개네 그럼
        //


        for(int i = 0; i < rawMaterialList.length; i++) { //3개
            String[] oneRawMaterial = rawMaterialList[i].split("/");

            stringList.add(oneRawMaterial);
        }

        for(String[] array : stringList) { //stringList = 2

            System.out.println("제발 : " + array[0]);
            System.out.println("제발 : " + array[1]);
        }

        System.out.println("menu : " + menu);
        System.out.println("menuMaterial : " + menuMaterial);

        RawMaterialDTO rawMaterial = new RawMaterialDTO();


        //총 2가지 insert가 필요!
        //1. menuRepository.save(menu);
        //2. 그 메뉴에 해당하는 -> itemInfo(자재번호) / 메뉴재료이름 / 용량(용량은 받아와야하는게 맞는데) / 메뉴번호(만들어진거 갖고올거고)

    }
}
