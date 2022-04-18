package com.greedy.jaegojaego.backlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("backlog")
public class BacklogController {

   @GetMapping("list")
    public String backlogPage() {

       return "backlog/backlogList";
   }

}
