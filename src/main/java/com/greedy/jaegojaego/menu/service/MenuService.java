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
 * 2022/04/25 (이소현) 메뉴 등록
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

        List<RawMaterial> selectOneMenu = rawMaterialRepository.selectOneMenu(menuNo);
        selectOneMenu.forEach(System.out::println);

        return selectOneMenu.stream().map(rawMaterial -> modelMapper.map(rawMaterial, RawMaterialDTO.class)).collect(Collectors.toList());
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

        /* 1. 메뉴 insert */
        Menu insertMenu = menuRepository.save(modelMapper.map(menu, Menu.class)); //성공시

        String[] rawMaterialList = materialNameAndCapacityList.split(","); // -> 루누아나원두1kg/60g  , 000원두1kg/50 , 000원두1kg/40 으로 나누어짐
        List<String[]> stringList = new ArrayList<>(); // [0] -> 루누아나 원두1kg // [1] -> 60g


        System.out.println("menuMaterial : " + menuMaterial);

        if(insertMenu != null) {

            Menu menuNo = menuRepository.selectMenuByMenuName(menu.getMenuName()); //메뉴 번호
            System.out.println("나오냐? : " + menuNo); //메뉴번호 받아왔음


            for(int i = 0; i < rawMaterialList.length; i++) { //3개로 나누느 것
                String[] oneRawMaterial = rawMaterialList[i].split("/");
                stringList.add(oneRawMaterial);

//                Menu menuNo = menuRepository.selectMenuByMenuName(menu.getMenuName()); //메뉴 번호
//                System.out.println("나오냐? : " + menuNo); //메뉴번호 받아왔음(여따가 해주도 뜨네 .. 하)

                for(String[] array : stringList) { //stringList = 2

                    String menuName = array[0];
                    String menuCapacity = array[1];
                    System.out.println("메뉴이름 : " + menuName);
                    System.out.println("메뉴용량 : " + menuCapacity);

                    MenuMaterial menuInfo = menuMaterialRepository.selectMenuMaterialBymenuName(menuName);
                    System.out.println("나오려나 ?: " + menuInfo);

                    RawMaterial rawMaterial = new RawMaterial();
                    RawMaterialPK rawMaterialPK = new RawMaterialPK();

                    rawMaterialPK.setMenuNoforRaw(menuNo);
                    rawMaterialPK.setItemInfoNo(menuInfo);
                    rawMaterial.setRawMaterialPK(rawMaterialPK);

                    rawMaterial.setRawMaterialName(menuName);
                    rawMaterial.setRawMaterialCapacity(menuCapacity);

                    System.out.println("완성품  : " + rawMaterial);
                    rawMaterialRepository.save(rawMaterial); //제발 되라!

                }
            }

        }





    }
}
