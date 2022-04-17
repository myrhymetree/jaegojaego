package com.greedy.jaegojaego.client.controller;

import com.greedy.jaegojaego.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/client")
public class ClientController {

    @GetMapping("/list")
    public ModelAndView clientList(ModelAndView mv) {

        mv.setViewName("/client/clientList");

        return mv;
    }

}
