package com.greedy.jaegojaego.menu.controller;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.greedy.jaegojaego.menu.dto.MenuDTO;
import com.greedy.jaegojaego.menu.dto.MenuMaterialsDTO;
import com.greedy.jaegojaego.menu.dto.RawMaterialDTO;
import com.greedy.jaegojaego.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/selectonemenu", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectOneMenu(int menuNo) {

        /* 각 메뉴의 원재료 상세조회 */
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

//   /* 비동기방식(ajax) 페이징 */
//    @GetMapping(value = "/selectonemenu", produces = "application/json; charset=UTF-8")
//    @ResponseBody
//    public ModelAndView selectOneMenu(ModelAndView mv, int menuNo, @PageableDefault Pageable pageable) {
//
//        Page<RawMaterialDTO> rawMaterialList = menuService.selectOneMenuForPaging(menuNo, pageable);
//
//        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(rawMaterialList);
//
//        mv.addObject("paging", paging);
//        mv.addObject("rawMaterialList", rawMaterialList);
//        mv.setViewName("menu/menuList");
//
//        System.out.println("============================");
//        System.out.println(rawMaterialList);
//        System.out.println(paging);
//
//        return mv;
//   }

    @GetMapping(value = "/materialcategory", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<MenuMaterialsDTO> findRawMaterialList() {

        return menuService.findRawMaterialList();
    }

    @PostMapping("/regist")
    public ModelAndView registMenu(MenuMaterialsDTO menuMaterial, MenuDTO menu, ModelAndView mv, HttpServletRequest request) {

        //이름을 넘기는게 아니라 자재의 no를 받아와서 불러와야되는게 맞긴한데 일단 이름으로 진행해보자...!

        String[] materialNameAndCapacityList = request.getParameterValues("materials");
        for(String m : materialNameAndCapacityList) {
            System.out.println("배열로 넘어옴 : " + m);
        }

        menuService.registMenu(menu, menuMaterial, materialNameAndCapacityList);

        mv.setViewName("redirect:/menu/list");

        return mv;
    }

    @PostMapping("/modify")
    public ModelAndView modifyMenu(MenuMaterialsDTO menuMaterial, MenuDTO menu, ModelAndView mv, HttpServletRequest request) {
        //아무것도 안바꿔서 얘가 null이구나
        String[] materialNameAndCapacityList = request.getParameterValues("materialsForModify");
        for(String m : materialNameAndCapacityList) {
            System.out.println("수정의 배열로 넘어옴 : " + m);
        }

        menuService.modifyMenu(menu, menuMaterial, materialNameAndCapacityList);

        mv.setViewName("redirect:/menu/list");

        return mv;

    }

}

//    /* 되지만 1개만 들어옴.. */
//    @PostMapping(value = "/regist", produces = "application/json; charset=UTF-8")
//    @ResponseBody
//    public ModelAndView registMenu(ModelAndView mv, @RequestParam Map<String, Object> itemInfoAndCapacitydata) {
//        List<Map<String, Object>> menuInfoList = new ArrayList<>();
//        menuInfoList = JSONArray.fromObject(itemInfoAndCapacitydata);
//
//        menuInfoList.forEach(System.out::println);
//        System.out.println("나오냐 : " + menuInfoList);
//
//
//        mv.setViewName("redirect:/menu/menuList");
//
//        return mv;
//    }


//    @PostMapping(value = "/regist", produces = "application/json; charset=UTF-8")
//    @ResponseBody
//    public Map<String, Object> registMenu(ModelAndView mv, @RequestParam String itemInfoAndCapacitydata) {
//        Map<String, Object> result = new HashMap<>();
//            /*JSONArray jsonArray = JSONArray.fromObject(paramData);*/
//            List<Map<String,Object>> info = new ArrayList<Map<String,Object>>();
//            info = JSONArray.fromObject(itemInfoAndCapacitydata);
//
//            for (Map<String, Object> menuInfo : info) {
//                System.out.println(menuInfo.get("menuName") + " : " + menuInfo.get("menuPrice")
//                                + menuInfo.get("menuStatus") + menuInfo.get("capacityData") + menuInfo.get("itemInfoData"));
//            }
//            result.put("result", true);
//        return result;
//
//    }


