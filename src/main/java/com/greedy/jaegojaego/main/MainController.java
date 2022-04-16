package com.greedy.jaegojaego.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping({"/", "/main"})
    public String mainView() {

        return "main/main";
    }

    @PostMapping(value = "/")
    public String redirectMain() {

        return "redirect:/";

    }
}
