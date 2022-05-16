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

/**
 * <pre>
 * Class : MaterialsController
 * Comment : 자재관련 메소드를 모아놓은 Controller입니다.
 *           자재생성, 수정, 삭제, 거래처와의 매핑, 상세보기 , 거래처 목록, 자재 목록
 *           이 있습니다.
 *
 * History
 * 2022/04/19 (김영광) MaterialsController 뷰 완성 후 시범 동작
 * 2022/04/20 ~ 4/21 (김영광) 자재 목록 조회
 * 2022/04/24 자재 상세 페이지 조회
 * 2022/04/26 매핑 자재 비동기 목록 조회
 * 2022/04/27 매핑 자재 비동기 목록 조회
 * 2022/04/28 자재 매핑 등록
 * 2022/04/29 자재 매핑 등록
 * 2022/05/01 자재 매핑 등록
 * 2022/05/02 매핑 거래처 비동기 목록 조호;
 * 2022/05/03 매핑 거래처 비동기 목록 조호;
 * 2022/05/04 거래처 매핑 등록;
 * 2022/05/05 거래처 자재 매핑 매치;
 * 2022/05/06 거래처 자재 매핑 매치;
 * 2022/05/08 자재 수정;
 * 2022/05/09 자재 수정;
 * 2022/05/10 자재 삭제
 * 2022/05/11 자재 생성
 * 2022/05/12 사진 파일 업로드 등록
 *
 * </pre>
 * @version 18
 * @author 김영광
 */
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

    /**
     * selectMenuList : 자재 목록 조회
     *
     * @return mv : 자재 목록
     * */
    @GetMapping("/product/list")
    public ModelAndView MaterialsList(ModelAndView mv) {

        List<MaterialsDTO> materialsList = materialsService.findMaterialsList();

        for(MaterialsDTO list : materialsList) {
            System.out.println("list : " + list);
        }

        mv.addObject("materialsList", materialsList);
        mv.setViewName("materials/productList");

        return mv;
    }

    /**
     * findMaterialsByCode : 선택한 자재 상세 조회 번호
     * @param itemInfoNo : 선택한 자재의 번호
     *
     * @return mv : 선택한 자재 상세
     * */
    @GetMapping("/{itemInfoNo}")
    public ModelAndView findMaterialsByCode(ModelAndView mv, @PathVariable int itemInfoNo) {

        Map<String, Object> productAllList = materialsService.findMaterialsByCode(itemInfoNo);

        MaterialsDTO materials = (MaterialsDTO)productAllList.get("materialsDTO");
        List<ClientContractItemDTO> clientList =  (List<ClientContractItemDTO>)productAllList.get("clientContractItemDTO");
        
        mv.addObject("materials", materials);
        mv.addObject("clientList", clientList);
        mv.setViewName("materials/productDetail");

        return mv;
    }

    /**
     * removeMaterial : 선택한 자재 삭제 번호
     * @param itemInfoNo : 선택한 자재의 번호
     *
     * @return mv : 자재 목록 조회
     * */
    @GetMapping("/delete/{itemInfoNo}")
    public ModelAndView removeMaterialNo(ModelAndView mv, @PathVariable int itemInfoNo, RedirectAttributes rttr) {

        materialsService.removeMaterial(itemInfoNo);

        String successMessage = "삭제 성공하셨습니다.";

        rttr.addFlashAttribute("successMessage", successMessage);

        mv.setViewName("redirect:/materials/product/list");

        return mv;
    }

    /**
     *  자재 거래처 매핑 등록 뷰 요청
     *
     * @return mv : 자재 거래처 매핑 뷰 반환
     * */
    @GetMapping("/regist")
    public ModelAndView productMaterials(ModelAndView mv) {

        mv.setViewName("/materials/productRegist");

        return mv;
    }

    /**
     * findMaterialCount : 자재 목록 총 수 조회
     * findCategory : 카테고리 목록 조회
     * 
     * @return mv : 자재 생성 뷰 반환
     * */
    @GetMapping("/item/regist")
    public ModelAndView itemRegist(ModelAndView mv) {

        Integer materialCount =  materialsService.findMaterialCount();
        List<MaterialsCategoryDTO> categoryList = materialsService.findCategory();

        mv.addObject("materialCount", materialCount);
        mv.addObject("categoryList", categoryList);
        mv.setViewName("/materials/itemRegist");

        return mv;
    }

    /**
     * updateMapping : 거래처와 자재 정보 매핑 등록
     * @param  parameter : 자재 번호, 거래처 번호
     *
     * @return mv : 자재, 거래처 매핑 등록 페이지
     * */
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

    /**
     * materialsProductRegist : 자재 생성 정보 등록
     * materialFileRegist : 파일 정보 등록
     * @param material : 자재 생성 정보
     * @param materialItemImage : 사진파일 이미지
     *
     * @return mv : 자재 생성 페이지
     * */
    @PostMapping("/product/register")
    public ModelAndView productRegister(ModelAndView mv ,MaterialProductDTO material, @RequestParam("materialItemImage") MultipartFile materialItemImage, RedirectAttributes rttr, Locale locale) {

        materialsService.materialsProductRegist(material);

        if(materialItemImage.getSize() != 0) {

            MaterialFileDTO materialFileDTO = new MaterialFileDTO();

            String fileUploadDirectory = rootLocation;
            File conversionFileDirectory = new File(fileUploadDirectory);

            String thumbnailPath = "/upload/materials/conversion/";

            File uploadDirectory = new File(fileUploadDirectory);
            File thumbnailDirectory = new File(thumbnailPath);

            if (!materialItemImage.isEmpty()) {

                if (!uploadDirectory.exists() || !thumbnailDirectory.exists()) {

                }

                try {
                    if (materialItemImage.getSize() > 0) {

                        String orgName = materialItemImage.getOriginalFilename();
                        String ext = orgName.substring(orgName.lastIndexOf("."));
                        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                        materialItemImage.transferTo(new File(uploadDirectory + "/thumbnail_" + savedName));

                        materialFileDTO.setFileOriginalName(orgName);
                        materialFileDTO.setFileChangedName(savedName);
                        materialFileDTO.setFileUrl(fileUploadDirectory);
                        materialFileDTO.setDeleteYn("N");
                        materialFileDTO.setMaterialFileCategory(6);
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

            String successMessage = "등록에 성공하셨습니다.";

            rttr.addFlashAttribute("successMessage", successMessage);
            mv.setViewName("redirect:/materials/item/regist");

            return mv;
        }

        String successMessage = "자재 등록에 성공하셨습니다.";

        rttr.addFlashAttribute("successMessage", successMessage);
        mv.setViewName("redirect:/materials/item/regist");

        return mv;
    }

    /**
     * materialModify : 자재 정보 업데이트
     * @param materialDTO : 자재 정보
     *
     * @return mv : 자재 전체 목록
     * */
    @PostMapping("/modify")
    public ModelAndView materialModify(ModelAndView mv, @ModelAttribute MaterialDTO materialDTO ,RedirectAttributes rttr) {

        materialsService.materialModify(materialDTO);

        String successMessage = "수정에 성공하셨습니다.";

        rttr.addFlashAttribute("successMessage", successMessage);
        mv.setViewName("redirect:/materials/product/list");

        return mv;
    }

    /**
     * registList : 매핑등록용 자재목록 조회
     *
     * @return mv : 매핑 자재 목록
     * */
    @GetMapping(value = "/registList", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ModelAndView registproductMaterialsList(ModelAndView mv) {

        List<MaterialsDTO> materialsList = materialsService.findMaterialsList();

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

    /**
     * registClientList : 매핑등록용 거래처 목록 조회
     *
     * @return mv : 매핑 거래처 목록 반환
     * */
    @GetMapping(value = "/registClientList", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ModelAndView registproductClientList(ModelAndView mv) {

        List<ClientContractItemMaterialDTO> clientList =  materialsService.findClientList();

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
