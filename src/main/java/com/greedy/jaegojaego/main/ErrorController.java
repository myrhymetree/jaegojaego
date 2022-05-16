package com.greedy.jaegojaego.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @PostMapping("/login")
    public void loinFailed() {

    }

    @RequestMapping("/denied")
    public void acessDenied() {

    }
}
