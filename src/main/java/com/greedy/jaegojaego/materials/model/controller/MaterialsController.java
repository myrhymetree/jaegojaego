//package com.greedy.jaegojaego.materials.model.controller;
//
//<<<<<<< HEAD
//=======
//import com.greedy.jaegojaego.materials.model.dto.MaterialsDTO;
//import com.greedy.jaegojaego.materials.model.entity.Materials;
//>>>>>>> origin/feature/materials
//import com.greedy.jaegojaego.materials.model.service.MaterialsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/materials")
//public class MaterialsController {
//
//    private final MaterialsService materialsService;
//
//    @Autowired
//    public MaterialsController(MaterialsService materialsService) {
//        this.materialsService = materialsService;
//    }
//
//    @GetMapping("/productList")
//    public ModelAndView MaterialsList(ModelAndView mv) {
//
//        List<MaterialsDTO> materialsList = materialsService.findMaterialsList();
//
//        mv.addObject("materialsList", materialsList);
//        mv.setViewName("materials/productList");
//
//        return mv;
//    }
//}
