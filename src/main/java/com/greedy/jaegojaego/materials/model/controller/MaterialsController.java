package com.greedy.jaegojaego.materials.model.controller;

import com.greedy.jaegojaego.materials.model.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/materials")
public class MaterialsController {

    private final MaterialsService materialsService;

    @Autowired
    public MaterialsController(MaterialsService materialsService) {
        this.materialsService = materialsService;
    }

    @GetMapping("/productlist")
    public ModelAndView MaterialsList(ModelAndView mv) {

        mv.setViewName("materials/productList");

        return mv;
    }
}
