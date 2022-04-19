package com.greedy.jaegojaego.menu.controller;

import com.greedy.jaegojaego.menu.dto.MenuDTO;
import com.greedy.jaegojaego.menu.dto.RawMaterialDTO;
import com.greedy.jaegojaego.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

   @GetMapping("/selectonemenu")
   @ResponseBody
   public ModelAndView selectOneMenu(ModelAndView mv, @PathVariable int menuNo) {

        /* 각 메뉴의 원재료 상세조회 */
        List<RawMaterialDTO> rawMaterialList = menuService.selectOneMenu();
       System.out.println("menuNo : " + menuNo);

        return mv;
   }



}
