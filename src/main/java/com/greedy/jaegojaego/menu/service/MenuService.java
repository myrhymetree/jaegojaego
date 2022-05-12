package com.greedy.jaegojaego.menu.service;

import com.greedy.jaegojaego.menu.dto.MenuDTO;
import com.greedy.jaegojaego.menu.dto.MenuMaterialsDTO;
import com.greedy.jaegojaego.menu.dto.RawMaterialDTO;
import com.greedy.jaegojaego.menu.entity.Menu;
import com.greedy.jaegojaego.menu.entity.MenuMaterial;
import com.greedy.jaegojaego.menu.entity.RawMaterial;
import com.greedy.jaegojaego.menu.entity.RawMaterialPK;
import com.greedy.jaegojaego.menu.repository.MenuMaterialRepository;
import com.greedy.jaegojaego.menu.repository.MenuRepository;
import com.greedy.jaegojaego.menu.repository.RawMaterialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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
 * 2022/04/25 (이소현) 메뉴 등록
 * 2022/04/26 (이소현) 메뉴 등록(리팩토링)
 * 2022/04/27 (이소현) 메뉴 수정
 * 2022/04/28 (이소현) 메뉴 삭제
 * 2022/04/30 (이소현) 메뉴 삭제
 * </pre>
 * @version 10
 * @author 이소현
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


    /**
     * findAll : 메뉴 전체 리스트 조회
     * @ return : 메뉴 전체 리스트
     * */
    public List<MenuDTO> selectMenuList() {

        List<Menu> menuList = menuRepository.findAll();

        return menuList.stream().map(menu -> modelMapper.map(menu, MenuDTO.class)).collect(Collectors.toList());

    }

    /**
     * selectOneMenu : 선택한 메뉴 목록 내용 조회
     * @ param menuNo : 선택한 메뉴의 메뉴번호
     * @ return : 선택한 메뉴 목록 내용
     * */
    public List<RawMaterialDTO> selectOneMenu(int menuNo) {

        List<RawMaterial> selectOneMenu = rawMaterialRepository.selectOneMenu(menuNo);

        return selectOneMenu.stream().map(rawMaterial -> modelMapper.map(rawMaterial, RawMaterialDTO.class)).collect(Collectors.toList());
    }

    /**
     * findAll : 자재 전체 리스트 조회
     * @ return : 자재 전체 리스트
     * */
    public List<MenuMaterialsDTO> findRawMaterialList() {

        List<MenuMaterial> rawMaterialList = menuMaterialRepository.findAll();

        return rawMaterialList.stream().map(menuMaterial -> modelMapper.map(menuMaterial, MenuMaterialsDTO.class)).collect(Collectors.toList());
    }

    /**
     * save : 메뉴 등록
     * @ param menu : 등록할 메뉴의 내용들
     *
     * selectMenuByMenuName : 특정 메뉴 이름에 맞는 메뉴 리스트 조회
     * @ param menu.getMenuName() : 특정 메뉴 이름
     *
     * selectMenuMaterialBymenuName : 특정 메뉴 이름에 맞는 자재 리스트 조회
     * @ param menuName : 특정 메뉴 이름
     *
     * save : 원재료 등록
     * @ param rawMaterial : 등록할 원재료의 내용들
     * */
    @Transactional
    public void registMenu(MenuDTO menu, MenuMaterialsDTO menuMaterial, String[] materialNameAndCapacityList) {

        /** 1. 완제품 메뉴 등록 */
        Menu insertMenu = menuRepository.save(modelMapper.map(menu, Menu.class));

        /** 분리 (3개가 들어올 경우 3개로) */
        String[] rawMaterialList = materialNameAndCapacityList;
        List<String> nameList = new ArrayList<>();
        List<Integer> capacityList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String menuName = "";
        String menuCapacity = "";

        /** 메뉴이름, 용량 구분한 뒤 소분단위(g) 붙임 */
        for (int i = 0; i < rawMaterialList.length; i++) {
            String[] oneRawMaterial = rawMaterialList[i].split("/");

            nameList.add(oneRawMaterial[0]);
            capacityList.add(Integer.parseInt(oneRawMaterial[1].replace("g", "")));
        }

        /** 메뉴이름 중복여부에 따라 다르게 용량 표기 */
        for (int i = 0; i < nameList.size(); i++) {

            /** 중복 안된 경우 */
            if (!map.containsKey(nameList.get(i))) {
                map.put(nameList.get(i), capacityList.get(i));
            } else {
                /** 중복 된 경우 */
                map.put(nameList.get(i), map.get(nameList.get(i)) + capacityList.get(i));
            }
        }

        /** 메뉴DB 저장 */
        if (insertMenu != null) {
            Menu menuNo = menuRepository.selectMenuByMenuName(menu.getMenuName());

            Iterator<String> keys = map.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                menuName = key;
                menuCapacity = String.valueOf(map.get(key) + "g");

                MenuMaterial menuInfoNo = menuMaterialRepository.selectMenuMaterialBymenuName(menuName);

                RawMaterial rawMaterial = new RawMaterial();
                RawMaterialPK rawMaterialPK = new RawMaterialPK();

                rawMaterialPK.setMenuNoforRaw(menuNo);
                rawMaterialPK.setItemInfoNo(menuInfoNo);
                rawMaterial.setRawMaterialPK(rawMaterialPK);

                rawMaterial.setRawMaterialName(menuName);
                rawMaterial.setRawMaterialCapacity(menuCapacity);

                rawMaterialRepository.save(rawMaterial);
                }
            }

        }

    /**
     * findById : 특정 메뉴 조회
     * @ param menu.getMenuNo() : 특정 메뉴 조회할 메뉴의 번호
     *
     * deleteRawMaterialByMenuNo : 특정 메뉴 번호에 따른 원재료 목록 삭제
     * @ param selectMenu.getMenuNo() : 특정 원재료를 삭제할 메뉴의 번호
     *
     * //ㄱㄷ
     * selectMenuByMenuName : 특정 메뉴 이름에 따른 특정 메뉴 조회
     * @ param menu.getMenuName() : 특정 메뉴 이름
     *
     * selectMenuMaterialBymenuName : 특정 메뉴 이름에 따른 특정 자재 조회
     * @ param menuName : 특정 메뉴 이름
     *
     * save : 원재료 등록
     * @ param rawMaterial : 등록할 원재료의 내용들
     * */
    @Transactional
    public void modifyMenu(MenuDTO menu, MenuMaterialsDTO menuMaterial, String[] materialNameAndCapacityList) {

        Menu selectMenu = menuRepository.findById(menu.getMenuNo()).get();
        rawMaterialRepository.deleteRawMaterialByMenuNo(selectMenu.getMenuNo());

        selectMenu.setMenuName(menu.getMenuName());
        selectMenu.setMenuPrice(menu.getMenuPrice());
        selectMenu.setMenuOrderableStatus(menu.getMenuOrderableStatus());


        /** 분리 (3개가 들어올 경우 3개로) */
        String[] rawMaterialList = materialNameAndCapacityList;
        List<String> nameList = new ArrayList<>();
        List<Integer> capacityList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String menuName = "";
        String menuCapacity = "";

        for (int i = 0; i < rawMaterialList.length; i++) {
            String[] oneRawMaterial = rawMaterialList[i].split("/");

            nameList.add(oneRawMaterial[0]);
            capacityList.add(Integer.parseInt(oneRawMaterial[1].replace("g", "")));
        }

        for (int i = 0; i < nameList.size(); i++) {

            if (!map.containsKey(nameList.get(i))) {
                map.put(nameList.get(i), capacityList.get(i));
            } else {
                map.put(nameList.get(i), map.get(nameList.get(i)) + capacityList.get(i));
            }
        }

        if (selectMenu != null) {
            Menu menuNo = menuRepository.selectMenuByMenuName(menu.getMenuName());

            Iterator<String> keys = map.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next(); // key = key값 , value = map.get(key)
                menuName = key;
                menuCapacity = String.valueOf(map.get(key) + "g");

                MenuMaterial menuInfoNo = menuMaterialRepository.selectMenuMaterialBymenuName(menuName);

                RawMaterial rawMaterial = new RawMaterial();
                RawMaterialPK rawMaterialPK = new RawMaterialPK();

                rawMaterialPK.setMenuNoforRaw(menuNo);
                rawMaterialPK.setItemInfoNo(menuInfoNo);
                rawMaterial.setRawMaterialPK(rawMaterialPK);

                rawMaterial.setRawMaterialName(menuName);
                rawMaterial.setRawMaterialCapacity(menuCapacity);

                rawMaterialRepository.save(rawMaterial);
            }
        }
    }

    /**
     * deleteById : 특정 메뉴 번호에 따른 특정 메뉴 삭제
     * @ param menuNo : 특정 메뉴 번호
     * */
    public void deleteMenu(int menuNo) {

        menuRepository.deleteById(menuNo);

    }
}
