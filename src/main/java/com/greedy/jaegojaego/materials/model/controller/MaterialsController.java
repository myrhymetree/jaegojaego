package com.greedy.jaegojaego.materials.model.controller;

import com.greedy.jaegojaego.materials.model.dto.ClientContractItemDTO;
import com.greedy.jaegojaego.materials.model.dto.MaterialsDTO;
import com.greedy.jaegojaego.materials.model.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/materials")
public class MaterialsController {

    private final MaterialsService materialsService;

    @Autowired
    public MaterialsController(MaterialsService materialsService) {
        this.materialsService = materialsService;
    }

    @GetMapping("/productList")
    public ModelAndView MaterialsList(ModelAndView mv) {

        System.out.println("안되나");
        System.out.println("안되나");
        System.out.println("안되나");
        System.out.println("안되나");
        List<MaterialsDTO> materialsList = materialsService.findMaterialsList();

        for(MaterialsDTO list : materialsList) {
            System.out.println("list : " + list);
        }

        mv.addObject("materialsList", materialsList);
        mv.setViewName("materials/productList");

        return mv;
    }

    @GetMapping("/{itemInfoNo}")
    public ModelAndView findMaterialsByCode(ModelAndView mv, @PathVariable int itemInfoNo) {

        System.out.println("들어오나! 숫자" + itemInfoNo);
        System.out.println("들어오나! 숫자" + itemInfoNo);
        System.out.println("들어오나! 숫자" + itemInfoNo);

//        MaterialsDTO materials = materialsService.findMaterialsByCode(itemInfoNo);

        Map<String, Object> productAllList = materialsService.findMaterialsByCode(itemInfoNo);

        System.out.println("상세조회" + " " + productAllList);
        System.out.println("상세조회" + " " + productAllList);
        System.out.println("상세조회" + " " + productAllList);

        MaterialsDTO materials = (MaterialsDTO)productAllList.get("materialsDTO");
        List<ClientContractItemDTO> clientList =  (List<ClientContractItemDTO>)productAllList.get("clientContractItemDTO");

        System.out.println("상세조회2" + " " + materials);
        System.out.println("상세조회2" + " " + materials);
        System.out.println("상세조회3" + " " + clientList);
        System.out.println("상세조회3" + " " + clientList);


        mv.addObject("materials", materials);
        mv.addObject("clientList", clientList);
        mv.setViewName("materials/productDetail");

        return mv;
    }

    @GetMapping("/regist")
    public ModelAndView productMaterials(ModelAndView mv) {

        mv.setViewName("/materials/productRegist");

        return mv;
    }
}
