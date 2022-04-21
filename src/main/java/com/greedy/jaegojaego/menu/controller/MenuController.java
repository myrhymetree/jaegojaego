package com.greedy.jaegojaego.menu.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.menu.dto.MenuDTO;
import com.greedy.jaegojaego.menu.dto.RawMaterialDTO;
import com.greedy.jaegojaego.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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


}
