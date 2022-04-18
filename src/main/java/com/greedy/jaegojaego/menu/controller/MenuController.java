package com.greedy.jaegojaego.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

   @GetMapping("/list")
    public String moveMenuList() {

       System.out.println("이게 나오긴하냐");
       return "menu/menuList";
   }

}
