package com.greedy.jaegojaego.asset.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/asset")
public class AssetController {

    @GetMapping(value = {"/assetpage", "/", ""})
    public ModelAndView viewAsset(ModelAndView mv) {

        mv.setViewName("assetMain");

        return mv;
    }
}
