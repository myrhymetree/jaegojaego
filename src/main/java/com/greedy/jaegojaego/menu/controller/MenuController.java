package com.greedy.jaegojaego.menu.controller;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.menu.dto.MenuDTO;
import com.greedy.jaegojaego.menu.dto.MenuMaterialsDTO;
import com.greedy.jaegojaego.menu.dto.RawMaterialDTO;
import com.greedy.jaegojaego.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.util.ArrayList;
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
 * 2022/04/21 (이소현) 메뉴 상세 조회 비동기 페이징 다시 시도
 * 2022/04/23 (이소현) 메뉴 등록
 * 2022/04/25 (이소현) 메뉴 등록
 * 2022/04/26 (이소현) 메뉴 등록(리팩토링)
 * 2022/04/27 (이소현) 메뉴 수정
 * 2022/04/28 (이소현) 메뉴 삭제
 * 2022/04/30 (이소현) 메뉴 삭제
 * </pre>
 * @version 11
 * @author 이소현
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * selectMenuList : 메뉴 목록 조회
     * @ return : 메뉴 목록
     * */
    @GetMapping("/list")
    public ModelAndView moveMenu(ModelAndView mv, Authentication authentication) {

        List<MenuDTO> menuList = menuService.selectMenuList();

        mv.addObject("authentication", authentication.getPrincipal());
        mv.addObject("menuList", menuList);
        mv.setViewName("menu/menuList");

        return mv;
    }

    /**
     * selectOneMenu : 선택한 메뉴 상세 조회
     * @ param : 선택한 메뉴의 번호
     * @ return : 선택한 메뉴 상세
     * */
    @GetMapping(value = "/selectonemenu", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectOneMenu(int menuNo) {

        /** 각 메뉴의 원재료 상세조회 */
        List<RawMaterialDTO> rawMaterialList = menuService.selectOneMenu(menuNo);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(rawMaterialList);
    }

    /**
     * findRawMaterialList : 자재 전체 목록 조회
     * @ return : 자재 전체 목록
     * */
    @GetMapping(value = "/materialcategory", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<MenuMaterialsDTO> findRawMaterialList() {

        return menuService.findRawMaterialList();
    }

    /**
     * registMenu : 메뉴 등록
     * @ param menu : 등록할 메뉴의 내용들
     * @ param menuMaterial : 등록할 자재의 내용들
     * @ param materialNameAndCapacityList : 등록할 자재이름과 용량이 합쳐진 목록 내용들
     * */
    @PostMapping("/regist")
    public ModelAndView registMenu(MenuMaterialsDTO menuMaterial, MenuDTO menu, ModelAndView mv, WebRequest request) {

        String[] materialNameAndCapacityList = request.getParameterValues("materials");

        menuService.registMenu(menu, menuMaterial, materialNameAndCapacityList);

        mv.setViewName("redirect:/menu/list");

        return mv;
    }

    /**
     * modifyMenu : 메뉴 수정
     * @ param menu : 수정할 메뉴의 내용들
     * @ param menuMaterial : 수정할 자재의 내용들
     * @ param materialNameAndCapacityList : 수정할 자재이름과 용량이 합쳐진 목록 내용들
     * */
    @PostMapping("/modify")
    public ModelAndView modifyMenu(MenuMaterialsDTO menuMaterial, MenuDTO menu, ModelAndView mv, WebRequest request) {


        String[] materialNameAndCapacityList = request.getParameterValues("materialsForModify");

        menuService.modifyMenu(menu, menuMaterial, materialNameAndCapacityList);

        mv.setViewName("redirect:/menu/list");

        return mv;

    }

    /**
     * modifyMenu : 메뉴 삭제
     * @ param menuNo : 삭제할 메뉴의 번호
     * */
    @GetMapping("/delete")
    @ResponseBody
    public void deleteMenu(WebRequest request) {

        int menuNo = Integer.parseInt(request.getParameter("menuNo"));

        menuService.deleteMenu(menuNo);

    }

}



