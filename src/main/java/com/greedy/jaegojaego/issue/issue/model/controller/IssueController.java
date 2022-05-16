package com.greedy.jaegojaego.issue.issue.model.controller;

import com.google.gson.*;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
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

/**
 * <pre>
 * Class : IssueController
 * Comment : 가맹점 이슈(Issue)관련 메소드를 모아놓은 Controller 입니다.
 * History
 * 2022/05/03 (박인근) 이슈 목록 조회, 이슈 등록 발주 목록 조회, 이슈 등록 발주별 물품 목록 조회
 * 2022/05/04 (박인근) 이슈 목록 조회, 이슈 상세 조회
 * 2022/05/06 (박인근) 이슈 등록 발주 목록 조회, 이슈 등록 발주별 물품 목록 조회
 * 2022/05/07 (박인근) 이슈 등록, 이미지 파일 업로드
 * 2022/05/08 (박인근) 이슈 등록, 이슈 상세 조회, 이슈 수정
 * 2022/05/09 (박인근) 이슈 수정, 이슈 삭제
 * 2022/05/10 (박인근) 이슈 삭제, 이슈 처리 상태 변경
 * </pre>
 * @version 7
 * @author 박인근
 */
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

    /**
     * selectIssueList : 가맹점 이슈 목록 조회
     * @param mv : 이슈 목록과 로그인한 사용자 정보, 이동할 페이지의 요청 url을 담을 파라미터
     * @param authentication : 로그인한 사용자의 정보
     * @return : 이슈 내역 목록과 로그인한 사용자의 정보, 이슈 내역 목록 조회 url 로 이동
     */
    @GetMapping("/list")
    public ModelAndView selectIssueList(ModelAndView mv, Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        List<IssueDetailDTO> issueList = issueService.selectIssueList(customUser);

        mv.addObject("issueList", issueList);
        mv.addObject("member", customUser);
        mv.setViewName("/issue/issueList");

        return mv;
    }

    /**
     * selectIssueDetail : 가맹점 이슈 상세 조회
     * @param request : 요청 페이지에서 전달 받은 선택한 이슈 번호를 사용하기 위한 변수
     * @return : 가맹점 이슈 상세 정보
     */
    @GetMapping(value = "/detail", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectIssueDetail(WebRequest request) {

        int issueNo = Integer.parseInt(request.getParameter("issueNo"));

        IssueDTO issue = issueService.selectIssueDetail(issueNo);

        Gson gson = new Gson();

        return gson.toJson(issue);
    }

    /**
     * registIssue : 가맹점 이슈 상세 조회
     * @param multirequest : 요청 페이지에서 전달 받은 파일들의 정보를 사용하기 위한 변수
     * @param request : 요청 페이지에서 전달 받은 선택한 이슈 번호를 사용하기 위한 변수
     * @param authentication : 로그인한 사용자의 정보
     * @return : 가맹점 이슈 목록 url 로 이동
     */
    @PostMapping("/regist")
    public String registIssue(MultipartHttpServletRequest multirequest, WebRequest request, Authentication authentication) {

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

    /**
     * selectIssueOrder : 이슈 신청 해당 가맹점의 발주 목록 조회
     * @param authentication : 로그인한 사용자의 정보
     * @return : 이슈 신청 해당 가맹점의 발주 목록
     */
    @GetMapping(value = "/selectissueorder", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectIssueOrder(Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        List<FranchiseOrderDTO> franchiseOrderList = issueService.selectIssueOrderList(customUser);

        Gson gson = new Gson();

        return gson.toJson(franchiseOrderList);
    }

    /**
     * modifyIssue : 가맹점 이슈 상세 조회
     * @param multirequest : 요청 페이지에서 전달 받은 파일들의 정보를 사용하기 위한 변수
     * @param request : 요청 페이지에서 전달 받은 수정할 이슈 번호를 사용하기 위한 변수
     * @param authentication : 로그인한 사용자의 정보
     * @return : 가맹점 이슈 목록 url 로 이동
     */
    @PostMapping("/modify")
    public String modifyIssue(MultipartHttpServletRequest multirequest, WebRequest request, Authentication authentication) {

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

    /**
     * removeIssue : 가맹점 이슈 삭제
     * @param removeIssueNo : 요청 페이지에서 전달 받은 삭제할 이슈 번호
     * @return : 가맹점 이슈 삭제 성공 여부
     */
    @PostMapping(value = "/remove", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String removeIssue(@RequestBody int removeIssueNo) {

        issueService.deleteIssue(removeIssueNo);

        Gson gson = new Gson();

        return gson.toJson("success");
    }

    /**
     * modifyStatus : 가맹점 이슈 처리 상태 변경
     * @param authentication : 로그인한 사용자의 정보
     * @param statusChangeIssueInfo : 요청 페이지에서 전달 받은 처리 상태 변경할 이슈 정보
     * @return : 가맹점 처리 상태 변경 성공 여부
     */
    @PostMapping(value = "/modifystatus", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String modifyStatus(Authentication authentication, @RequestBody String statusChangeIssueInfo) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(statusChangeIssueInfo);
        int issueNo = Integer.parseInt(jsonElement.getAsJsonObject().get("statusIssueNo").getAsString());
        String status = jsonElement.getAsJsonObject().get("statusName").getAsString();

        issueService.updateIssueStatus(customUser, issueNo, status);

        Gson gson = new Gson();

        return gson.toJson("success");
    }

}
