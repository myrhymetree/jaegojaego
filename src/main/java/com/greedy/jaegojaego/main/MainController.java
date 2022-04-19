package com.greedy.jaegojaego.main;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping({"/","/main"})
    public String loginView() {

            return "main/main";
    }

    @PostMapping(value = "/")
    public String redirectMain() {

        return "redirect:/";
    }

}
