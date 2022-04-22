package com.greedy.jaegojaego.menu.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.common.paging.Pagenation;
import com.greedy.jaegojaego.common.paging.PagingButtonInfo;
import com.greedy.jaegojaego.menu.dto.MenuDTO;
import com.greedy.jaegojaego.menu.dto.RawMaterialDTO;
import com.greedy.jaegojaego.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <pre>
 * Class : MenuController
 * Comment : Menu관련 메소드를 모아놓은 Controller입니다.
 * History
 * 2022/04/18 (이소현) MenuController 기본 설정 작성
 * 2022/04/19 (이소현) 메뉴 관리 페이지 이동
 * 2022/04/20 (이소현) 메뉴 목록 조회, 메뉴 상세 조회
 * 2022/04/21 (이소현) 메뉴 상세 조회 비동기 페이징
 * </pre>
 * @version ㄱㄷ
 * @author 이소현
 * @see MenuDTO, MenuService, MenuRepository, RawMaterialRepository 등
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public ModelAndView moveMenu(ModelAndView mv) {

        List<MenuDTO> menuList = menuService.selectMenuList();

        mv.addObject("menuList", menuList);
        mv.setViewName("menu/menuList");

       return mv;
   }


//   @GetMapping(value = "/selectonemenu", produces = "application/json; charset=UTF-8")
//    @ResponseBody
//    public String selectOneMenu(int menuNo) {
//
//        /* 각 메뉴의 원재료 상세조회 */
//        List<RawMaterialDTO> rawMaterialList = menuService.selectOneMenu(menuNo);
//
//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd")
//                .setPrettyPrinting()
//                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
//                .serializeNulls()
//                .disableHtmlEscaping()
//                .create();
//
//        return gson.toJson(rawMaterialList);
//   }

   /* 비동기방식(ajax) 페이징 */
    @GetMapping(value = "/selectonemenu", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ModelAndView selectOneMenu(ModelAndView mv, int menuNo, @PageableDefault Pageable pageable) {

        //나중에 페이징 시도(ajax때매 mv.addObejct) 이거떄매 음
        Page<RawMaterialDTO> rawMaterialList = menuService.selectOneMenuForPaging(menuNo, pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(rawMaterialList);

        mv.addObject("paging", paging);
        mv.addObject("rawMaterialList", rawMaterialList);
        mv.setViewName("menu/menuList");

        System.out.println("============================");
        System.out.println(rawMaterialList);
        System.out.println(paging);

        return mv;
   }

}
