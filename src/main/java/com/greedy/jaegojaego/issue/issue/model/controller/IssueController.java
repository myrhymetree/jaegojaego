package com.greedy.jaegojaego.issue.issue.model.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.issue.attachement.model.dto.IssueAttachmentFileCategoryDTO;
import com.greedy.jaegojaego.issue.attachement.model.dto.IssueAttachmentFileDTO;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDTO;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDetailDTO;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueItemDTO;
import com.greedy.jaegojaego.issue.issue.model.service.IssueService;
import com.greedy.jaegojaego.order.item.model.dto.OrderItemInfoDTO;
import com.greedy.jaegojaego.order.order.model.dto.franchise.FranchiseOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/issue")
public class IssueController {

    private final IssueService issueService;
    @Value("${jaegojaego.issue.upload.path}")
    private String rootLocation;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/list")
    public ModelAndView selectIssueList(ModelAndView mv, Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        List<IssueDetailDTO> issueList = issueService.selectIssueList(customUser);

        mv.addObject("issueList", issueList);
        mv.addObject("member", customUser);
        mv.setViewName("/issue/issueList");

        return mv;
    }

    @GetMapping(value = "/detail", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectIssueDetail(HttpServletRequest request) {

        int issueNo = Integer.parseInt(request.getParameter("issueNo"));

        IssueDTO issue = issueService.selectIssueDetail(issueNo);

        Gson gson = new Gson();

        return gson.toJson(issue);
    }

    @PostMapping("/regist")
    public String registIssue(MultipartHttpServletRequest multirequest, HttpServletRequest request, Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        String issueTitle = request.getParameter("issueTitle");
        String issueBody = request.getParameter("issueBody");
        String[] issueItemNo = request.getParameterValues("itemNo");
        String[] issueItemAmount = request.getParameterValues("issueItemAmount");
        int orderNo = Integer.parseInt(request.getParameter("issueOrderNo"));

        IssueDTO issue = new IssueDTO();
        issue.setFranchiseIssueTitle(issueTitle);
        issue.setFranchiseIssueBody(issueBody);
        issue.setFranchiseIssueStatus("BEFORE");
        issue.setFranchiseIssueCreatedDate(new Date(System.currentTimeMillis()));

        List<IssueItemDTO> issueItemList = new ArrayList<>();

        for(int i = 0; i < issueItemNo.length; i++) {

            OrderItemInfoDTO orderItemInfo = new OrderItemInfoDTO();
            orderItemInfo.setItemInfoNo(Integer.parseInt(issueItemNo[i]));

            IssueItemDTO issueItem = new IssueItemDTO();
            issueItem.setIssueItemAmount(Integer.parseInt(issueItemAmount[i]));
            issueItem.setOrderItemInfoDTO(orderItemInfo);

            issueItemList.add(issueItem);
        }

        String fileUploadDirectory = rootLocation;

        File conversionFileDirectory = new File(fileUploadDirectory);

        if (!conversionFileDirectory.exists()) {

            conversionFileDirectory.mkdirs();
        }

        List<MultipartFile> fileList = multirequest.getFiles("uploadImages");

        List<IssueAttachmentFileDTO> issueAttachmentFileList = new ArrayList<>();
        List<String> conversionNameList = new ArrayList<>();

        String originalFileName = ""; //원본 파일명
        String conversionFileName = ""; //변경 파일명

        if(fileList.get(0).getSize() > 0) {
            for(MultipartFile mf : fileList) {

                originalFileName = mf.getOriginalFilename();
                String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                conversionFileName = "thumbnail_" + UUID.randomUUID().toString().replace("-", "") + ext;

                IssueAttachmentFileCategoryDTO issueAttachmentFileCategory = new IssueAttachmentFileCategoryDTO();
                issueAttachmentFileCategory.setAttachmentFileCategoryNo(4);

                if(originalFileName != null && originalFileName.length() != 0) {

                    try {
                        mf.transferTo(new File(fileUploadDirectory + "/" + conversionFileName));

                        conversionNameList.add(fileUploadDirectory + "/" + conversionFileName);

                        String thumbnailPath = "/upload/issue/conversion/" + conversionFileName;

                        IssueAttachmentFileDTO issueAttachmentFile = new IssueAttachmentFileDTO();
                        issueAttachmentFile.setAttachmentFileOriginalName(originalFileName);
                        issueAttachmentFile.setAttachmentFileChangedName(conversionFileName);
                        issueAttachmentFile.setAttachmentFileDeleteYn("N");
                        issueAttachmentFile.setAttachmentFileDivision("이슈");
                        issueAttachmentFile.setAttachmentFileUrl(fileUploadDirectory);
                        issueAttachmentFile.setIssueAttachmentFileCategory(issueAttachmentFileCategory);
                        issueAttachmentFile.setAttachmentFileThumbnailUrl(thumbnailPath);

                        issueAttachmentFileList.add(issueAttachmentFile);

                    } catch (IllegalStateException | IOException e) {
                        e.printStackTrace();

                        int deleteCnt = 0;

                        for(int i = 0; i < conversionNameList.size(); i++) {

                            File deleteFile = new File(conversionNameList.get(i));
                            boolean isDeleted = deleteFile.delete();

                            if(isDeleted) {
                                deleteCnt++;
                            }

                        }

                        if(fileList.size() == deleteCnt) {
                            System.out.println("업로드 실패한 모든 사진 삭제 완료");
                            e.printStackTrace();
                        } else {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }

        issueService.registIssue(customUser, issueAttachmentFileList, issue, orderNo, issueItemList);

        return "redirect:/issue/list";
    }

    @GetMapping(value = "/selectissueorder", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectIssueOrder(Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        List<FranchiseOrderDTO> franchiseOrderList = issueService.selectIssueOrderList(customUser);

        Gson gson = new Gson();

        return gson.toJson(franchiseOrderList);
    }

    @PostMapping("/modify")
    public String modifyIssue(MultipartHttpServletRequest multirequest, HttpServletRequest request, Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        String issueTitle = request.getParameter("issueTitle");
        String issueBody = request.getParameter("issueBody");
        String[] issueItemNo = request.getParameterValues("itemNo");
        String[] issueItemAmount = request.getParameterValues("issueItemAmount");
        int imgResetCheck = Integer.parseInt(request.getParameter("imgResetCheck"));
        int issueNo = Integer.parseInt(request.getParameter("issueNo"));
        int issueOrderNo = Integer.parseInt(request.getParameter("issueOrderNo"));

        IssueDTO issue = new IssueDTO();
        issue.setFranchiseIssueNo(issueNo);
        issue.setFranchiseIssueTitle(issueTitle);
        issue.setFranchiseIssueBody(issueBody);

        List<IssueItemDTO> issueItemList = new ArrayList<>();

        for(int i = 0; i < issueItemNo.length; i++) {

            OrderItemInfoDTO orderItemInfo = new OrderItemInfoDTO();
            orderItemInfo.setItemInfoNo(Integer.parseInt(issueItemNo[i]));

            IssueItemDTO issueItem = new IssueItemDTO();
            issueItem.setIssueItemAmount(Integer.parseInt(issueItemAmount[i]));
            issueItem.setOrderItemInfoDTO(orderItemInfo);

            issueItemList.add(issueItem);
        }

        String fileUploadDirectory = rootLocation;

        File conversionFileDirectory = new File(fileUploadDirectory);

        if (!conversionFileDirectory.exists()) {

            conversionFileDirectory.mkdirs();
        }

        List<MultipartFile> fileList = multirequest.getFiles("uploadImages");

        List<IssueAttachmentFileDTO> issueAttachmentFileList = new ArrayList<>();
        List<String> conversionNameList = new ArrayList<>();

        String originalFileName = ""; //원본 파일명
        String conversionFileName = ""; //변경 파일명

        if(fileList.get(0).getSize() > 0) {
            for(MultipartFile mf : fileList) {

                originalFileName = mf.getOriginalFilename();
                String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                conversionFileName = "thumbnail_" + UUID.randomUUID().toString().replace("-", "") + ext;

                IssueAttachmentFileCategoryDTO issueAttachmentFileCategory = new IssueAttachmentFileCategoryDTO();
                issueAttachmentFileCategory.setAttachmentFileCategoryNo(4);

                if(originalFileName != null && originalFileName.length() != 0) {

                    try {
                        mf.transferTo(new File(fileUploadDirectory + "/" + conversionFileName));

                        conversionNameList.add(fileUploadDirectory + "/" + conversionFileName);

                        String thumbnailPath = "/upload/issue/conversion/" + conversionFileName;

                        IssueAttachmentFileDTO issueAttachmentFile = new IssueAttachmentFileDTO();
                        issueAttachmentFile.setAttachmentFileOriginalName(originalFileName);
                        issueAttachmentFile.setAttachmentFileChangedName(conversionFileName);
                        issueAttachmentFile.setAttachmentFileDeleteYn("N");
                        issueAttachmentFile.setAttachmentFileDivision("이슈");
                        issueAttachmentFile.setAttachmentFileUrl(fileUploadDirectory);
                        issueAttachmentFile.setIssueAttachmentFileCategory(issueAttachmentFileCategory);
                        issueAttachmentFile.setAttachmentFileThumbnailUrl(thumbnailPath);

                        issueAttachmentFileList.add(issueAttachmentFile);

                    } catch (IllegalStateException | IOException e) {
                        e.printStackTrace();

                        int deleteCnt = 0;

                        for(int i = 0; i < conversionNameList.size(); i++) {

                            File deleteFile = new File(conversionNameList.get(i));
                            boolean isDeleted = deleteFile.delete();

                            if(isDeleted) {
                                deleteCnt++;
                            }

                        }

                        if(fileList.size() == deleteCnt) {
                            System.out.println("업로드 실패한 모든 사진 삭제 완료");
                            e.printStackTrace();
                        } else {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }

        issueService.updateIssue(customUser, issueAttachmentFileList, issue, issueOrderNo, issueItemList, imgResetCheck);

        return "redirect:/issue/list";
    }

}
