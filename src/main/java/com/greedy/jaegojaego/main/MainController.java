package com.greedy.jaegojaego.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping("/")
    public String loginView(HttpServletRequest request) {

        System.out.println("session : " + request.getSession().getAttribute("loginMember"));

        if(request.getSession().getAttribute("loginMember") == null) {

            return "member/login";

        } else {

            return "main/main";
        }
    }

    @PostMapping(value = "/")
    public String redirectMain() {

        return "redirect:/";
    }

}
