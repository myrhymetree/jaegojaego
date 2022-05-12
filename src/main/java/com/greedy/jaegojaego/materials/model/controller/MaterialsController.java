package com.greedy.jaegojaego.materials.model.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.materials.model.dto.*;
import com.greedy.jaegojaego.materials.model.entity.Material;
import com.greedy.jaegojaego.materials.model.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/materials")
public class MaterialsController {

    private final MaterialsService materialsService;

    @Value("${jaegojaego.materials.upload.path}")
    private String rootLocation;

    @Autowired
    public MaterialsController(MaterialsService materialsService) {
        this.materialsService = materialsService;
    }

    @GetMapping("/product/list")
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

    @GetMapping("/delete/{itemInfoNo}")
    public ModelAndView removeMaterialNo(ModelAndView mv, @PathVariable int itemInfoNo, RedirectAttributes rttr) {

        materialsService.removeMaterial(itemInfoNo);

        String successMessage = "삭제 성공하셨습니다.";

        rttr.addFlashAttribute("successMessage", successMessage);

        mv.setViewName("redirect:/materials/productList");

        return mv;
    }

    @GetMapping("/regist")
    public ModelAndView productMaterials(ModelAndView mv) {

        mv.setViewName("/materials/productRegist");

        return mv;
    }

    @GetMapping("/item/regist")
    public ModelAndView itemRegist(ModelAndView mv) {

        Integer materialCount =  materialsService.findMaterialCount();
        List<MaterialsCategoryDTO> categoryList = materialsService.findCategory();

        mv.addObject("materialCount", materialCount);
        mv.addObject("categoryList", categoryList);
        mv.setViewName("/materials/itemRegist");

        return mv;
    }

    @PostMapping("/update")
    public ModelAndView itemMapping(ModelAndView mv, @RequestParam Map<String, String> parameter, RedirectAttributes rttr) {
        

        Integer itemInfoNo = Integer.valueOf((parameter.get("itemInfoNo")));
        int clientItemNo = Integer.parseInt(parameter.get("clientItemNo"));

        ClientMaterialUpdateDTO clientMaterialUpdateDTO = new ClientMaterialUpdateDTO();
        clientMaterialUpdateDTO.setItemInfoNo(itemInfoNo);
        clientMaterialUpdateDTO.setClientItemNo(clientItemNo);

        materialsService.updateMapping(clientMaterialUpdateDTO);

        String successMessage = "등록에 성공하셨습니다.";
        rttr.addFlashAttribute("successMessage", successMessage);

        mv.setViewName("redirect:/materials/regist");

       return mv;
    }

    @PostMapping("/product/register")
    public ModelAndView productRegister(ModelAndView mv ,MaterialProductDTO material, @RequestParam("materialItemImage") MultipartFile materialItemImage, RedirectAttributes rttr, Locale locale) {

        System.out.println("첫번째 사진");
        System.out.println("material11" + "" + material);
        System.out.println("material" + "" + material);
        System.out.println("materialItemImage" + "" + materialItemImage);
        System.out.println("materialItemImage" + "" + materialItemImage);

        materialsService.MaterialsProductRegist(material);

        System.out.println("두번째 사진");
        MaterialFileDTO materialFileDTO = new MaterialFileDTO();

        String fileUploadDirectory = rootLocation;
        File conversionFileDirectory = new File(fileUploadDirectory);
        
        System.out.println("세번째 사진");
        
        String thumbnailPath = "/upload/matrials/conversion/";

        File uploadDirectory = new File(fileUploadDirectory);
        File thumbnailDirectory = new File(thumbnailPath);

        if(!materialItemImage.isEmpty()) {

            if (!uploadDirectory.exists() || !thumbnailDirectory.exists()) {

            }

            try {
                if (materialItemImage.getSize() > 0) {

                    String orgName = materialItemImage.getOriginalFilename();
                    String ext = orgName.substring(orgName.lastIndexOf("."));
                    String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                    materialItemImage.transferTo(new File(uploadDirectory + "/thumbnail_" + savedName));

                    materialFileDTO.setMaterialFileCategory(6);
                    materialFileDTO.setDeleteYn("N");
                    materialFileDTO.setFileUrl(fileUploadDirectory);
                    materialFileDTO.setFileChangedName(savedName);
                    materialFileDTO.setFileOriginalName(orgName);
                    materialFileDTO.setFileDivision("자재");
                    materialFileDTO.setItemInfoNo(material.getItemInfoNo());

                    materialFileDTO.setThumbnailUrl(thumbnailPath + "thumbnail_" + savedName);
                }

                materialsService.materialFileRegist(materialFileDTO);

            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();

                File deleteFile = new File(uploadDirectory + "/" + materialFileDTO.getFileChangedName());
                boolean isDeleted1 = deleteFile.delete();

                File deleteThumbnail = new File(thumbnailDirectory + "/thumbnail_" + materialFileDTO.getFileChangedName());
                boolean isDeleted2 = deleteThumbnail.delete();

                if (isDeleted1 && isDeleted2) {
                    e.printStackTrace();
                } else {
                    e.printStackTrace();
                }
            }

        }
            mv.setViewName("redirect:/materials/item/regist");

        return mv;
    }

    @PostMapping("/modify")
    public ModelAndView materialModify(ModelAndView mv, @ModelAttribute MaterialDTO materialDTO ,RedirectAttributes rttr) {

        System.out.println("materialsDTO = " + materialDTO);
        materialsService.materialModify(materialDTO);

        String successMessage = "수정에 성공하셨습니다.";

        rttr.addFlashAttribute("successMessage", successMessage);
        mv.setViewName("redirect:/materials/productList");

        return mv;
    }

    @GetMapping(value = "/registList", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ModelAndView registproductMaterialsList(ModelAndView mv) {

//        if(materialsList.subdivisionUnit = null) {

            List<MaterialsDTO> materialsList = materialsService.findMaterialsList();
//        }
        System.out.println("도달했는가" + "" + materialsList);
        System.out.println("도달했는가" + "" + materialsList);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        mv.addObject("materialsList", gson.toJson(materialsList));
        mv.setViewName("jsonView");

        return mv;
    }

    @GetMapping(value = "/registClientList", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ModelAndView registproductClientList(ModelAndView mv) {

        System.out.println("일단 들어 오는가");
        System.out.println("일단 들어 오는가");
        System.out.println("일단 들어 오는가");

        List<ClientContractItemMaterialDTO> clientList =  materialsService.findClientList();

        System.out.println("도달했는가" + "" + clientList);
        System.out.println("도달했는가" + "" + clientList);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        mv.addObject("clientList", gson.toJson(clientList));
        mv.setViewName("jsonView");

        return mv;
    }
}
