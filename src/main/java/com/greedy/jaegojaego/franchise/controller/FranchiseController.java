package com.greedy.jaegojaego.franchise.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.franchise.dto.*;
import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.franchise.repository.FranchiseAttachmentRepository;
import com.greedy.jaegojaego.franchise.service.FranchiseService;
import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.service.MemberService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <pre>
 * Class : FranchiseController
 * Comment : 가맹점 계정 관련 컨트롤러 메소드를 모아놓은 Controller 클래스 입니다.
 * History
 * 2022.05.13 (박성준)
 * </pre>
 * @version 1.1
 * @author 박성준
 */
@Controller
@RequestMapping("/franchise")
@Log4j2
public class FranchiseController {

    private final FranchiseService franchiseService;
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @Value("${com.greedy.jaegojaego.upload.path}")
    private String uploadPath;

    @Autowired
    ResourceLoader resourceLoader;

    /**
     * Instantiates a new Franchise controller.
     *
     * @param franchiseService the franchise service
     * @param memberService    the member service
     * @param passwordEncoder  the password encoder
     */
    @Autowired
    public FranchiseController(FranchiseService franchiseService, MemberService memberService, PasswordEncoder passwordEncoder) {
        this.franchiseService = franchiseService;
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 가맹점 대표자 계정 생성 메소드
     *
     * @return 가맹점 계정생성 페이지
     */
    @GetMapping("/regist")
    public String sendRegistView() {


        return "/franchise/regist";
    }


    /**
     * 가맹점 계정 생성 메소드
     *
     * @param request                  날짜 정보를 받기 위한 HttpServletRequest
     * @param franchise                가맹점 계정 정보
     * @return 가맹점 대표자 계정 생성 페이지 redirect
     */
    @PostMapping("/regist")
    public String registMember(HttpServletRequest request, @ModelAttribute FranchiseInfoDTO franchise) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        LocalDateTime startDate = LocalDateTime.parse(request.getParameter("franchiseContractStartedDate1"), formatter);
        LocalDateTime expiredDate = LocalDateTime.parse(request.getParameter("franchiseContractExpiredDate1"), formatter);

        franchise.setFranchiseContractStartedDate(startDate);
        franchise.setFranchiseContractExpiredDate(expiredDate);
        franchise.setOfficeDivision("대표자");

        System.out.println("startDate = " + startDate);

        Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();

        CustomUser loginUser = (CustomUser) authentication1.getPrincipal();

        FranchiseContractUpdatedRecordDTO franchiseContractUpdatedRecordDTO = new FranchiseContractUpdatedRecordDTO();
        franchiseContractUpdatedRecordDTO.setFranchiseContractStatus(franchise.getFranchiseContractStatus());
        franchiseContractUpdatedRecordDTO.setFranchiseContractStartedDate(franchise.getFranchiseContractStartedDate());
        franchiseContractUpdatedRecordDTO.setFranchiseContractExpiredDate(franchise.getFranchiseContractExpiredDate());

        franchise.setMemberPwd(passwordEncoder.encode(franchise.getMemberPwd()));
        franchise.setMemberCreatedDate(LocalDateTime.now());
        franchise.setMemberPwdInitStatus("Y");
        franchise.setMemberRemoveStatus("Y");
        franchise.setMemberDivision("가맹점");
        franchise.setWritedMemberNo(loginUser.getMemberNo());

        franchiseService.registFranchise(franchise, franchiseContractUpdatedRecordDTO);

        return "redirect:/franchise/regist";
    }

    /**
     * 검색 조건에 따른 가맹점 대표자 계정 목록 조회 메소드
     *
     * @param mv         세션에 전달할 값 입력 및 포워딩 주소 입력
     * @param searchWord 검색어
     * @return the model and view 세션에 값 전달 및 도메인 포워딩 값 전달
     */
    @GetMapping("/list")
    public ModelAndView findFranchiseList(ModelAndView mv,  String searchWord) {

        FranchiseListDTO franchiseList = franchiseService.findFranchiseList(searchWord);

        mv.addObject("franchiseList", franchiseList.getFranchiseList());
        mv.addObject("removedFranchiseList", franchiseList.getRemovedFranchiseList());
        mv.setViewName("franchise/list");

        return mv;
    }

    /**
     * 가맹점 직원 계정 생성 페이지 이동 메소드
     *
     * @return 가맹점 직원 계정 생성 페이지
     */
    @GetMapping("/manager")
    public String sendRegistManagerView() {

        return "/franchise/registManager";
    }

    /**
     * 가맹점 직원 계정 생성 메소드
     *
     * @param manager 가맹점 직원 계정 정보
     * @return 가맹점 직원 계정 생성 페이지 리다이렉트
     */
    @PostMapping("/manager")
    public String registManager(FranchiseAccountDTO manager) {

        franchiseService.registManager(manager);

        return "redirect:/franchise/manager";
    }

    /**
     * 디렉토리 생성 메소드
     *
     * @return folderPath 폴더 생성 경로 반환
     */
    private String makeFolder() {

        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        String folderPath = str.replace("/", File.separator);

        // 플더 만들기
        File uploadPathFolder = new File(uploadPath, folderPath);

        if(uploadPathFolder.exists() == false) {
            uploadPathFolder.mkdirs();
        }

        return folderPath;
    }

    /**
     * 계정 아이디 중복체크 메소드
     *
     * @param request 비동기 방식으로 전달해준 아이디 값
     * @return the boolean 중복 체크 결과 여부(true/false)
     */
    @GetMapping(value = "/duplication", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public boolean duplicationIdCheck(HttpServletRequest request) {

        String memberId = request.getParameter("memberId");

        boolean status =  memberService.duplicationCheckId(memberId);

        return status;
    }

    /**
     * 가맹점 목록 조회 메소드(비동기)
     * comment : html 페이지 select 요소에서 확인할 목록
     *
     * @return 가맹점 목록
     */
    @GetMapping(value = "/branch", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<FranchiseInfoDTO> findAllFranchise() {

        return franchiseService.findAllFranchise();
    }

    /**
     * 가맹점 직원 계정 정보(개인정보) 수정 메소드
     *
     * @param manager 가맹점 직원 계정 정보
     * @return the string 가맹점 직원 계정 목록 페이지 리다이렉트
     */
    @PostMapping(value = "/modifymanager")
    public String modifyManager(FranchiseAccountDTO manager) {

        System.out.println("매니저계정 = " + manager);

        franchiseService.modifyManagerInfoByMyself(manager);

        return "redirect:/";
    }

    @PostMapping(value = "/updateManager")
    public String updateManager(FranchiseAccountDTO manager) {

        franchiseService.updateManagerInfoByCompany(manager);

        return "redirect:/franchise/managerList";
    }

    /**
     * 가맹점 대표자 개인 정보 수정 메소드
     *
     * @param franchiseInfo 가맹점 대표자 계정 정보
     * @return the string 가맹점 대표자 계정 목록 페이지 리다이렉트
     */
    @PostMapping(value = "/modifyfranchise")
    public String modifyFranchise(FranchiseInfoDTO franchiseInfo) {

        franchiseService.updateFranchiseInfo(franchiseInfo);

        return "redirect:/franchise/list";
    }

    /**
     * 가맹점 대표자 계정 상세정보 조회 비동기 메소드
     *
     * @param memberNo 계정번호(가맹점 번호)
     * @return the string 가맹점 계정 상세정보
     */
    @GetMapping(value = "/franchiseDetail/{memberNo}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String findFranchiseDetailInfo(@PathVariable Integer memberNo) {

        FranchiseDetailViewDTO franchiseDetailInfo = franchiseService.findFranchiseDetailInfo(memberNo);
        System.out.println("franchiseDetailInfo = " + franchiseDetailInfo);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return  gson.toJson(franchiseDetailInfo);
    }

    /**
     * 가맹점 직원 계정 상세정보 조회 비동기 메소드
     *
     * @param memberNo 계정번호(가맹점 직원 계정 번호)
     * @return the string 가맹점 직원 계정 상세정보
     */
    @GetMapping(value = "/managerDetail/{memberNo}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String findManagerDetailInfo(@PathVariable Integer memberNo) {

        FranchiseAccountDTO franchiseAccount = franchiseService.findManagerDetailInfo(memberNo);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(franchiseAccount);
    }

    /**
     * 가맹점 계정 정보 삭제 메소드
     *
     * @param memberNo 계정번호
     * @return the string 가맹점 계정이 대표자 계정일 경우 가맹점 대표자 계정 목록 페이지 반환
     * @return the string 가맹점 계정이 직원 계정일 경우 가맹점 직원 계정 목록 페이지 반환
     */
    @GetMapping("/delete/{memberNo}")
    public String removeMember(@PathVariable Integer memberNo) {

        String result = memberService.removeMember(memberNo);

        if(result.equals("대표자")) {
            return "redirect:/franchise/list";
        } else {
            return "redirect:/franchise/managerList";
        }
    }

    /**
     * 삭제된 가맹점 계정 복구 메소드
     *
     * @param memberNo 계정번호
     * @return the string 가맹점 계정이 대표자 계정일 경우 가맹점 대표자 계정 목록 페이지 반환
     * @return the string 가맹점 계정이 직원 계정일 경우 가맹점 직원 계정 목록 페이지 반환
     */
    @GetMapping("/restore/{memberNo}")
    public String restoreMember(@PathVariable Integer memberNo) {

        String result = memberService.restoreMember(memberNo);

        if(result.equals("대표자")) {
            return "redirect:/franchise/list";
        } else {
            return "redirect:/franchise/managerList";
        }
    }

    /**
     * 검색 조건에 따른 가맹점 직원 계정 목록 조회 메소드
     *
     * @param mv         세션에 전달할 값 입력 및 포워딩 주소 입력
     * @param searchWord 검색어
     * @return the model and view 세션에 값 전달 및 도메인 포워딩 값 전달
     */
    @GetMapping("/managerList")
    public ModelAndView findManagerList(ModelAndView mv, String searchWord) {

        FranchiseListDTO list = franchiseService.findManagerList(searchWord);

        mv.addObject("managerList", list.getManagerList());
        mv.addObject("removedManagerList", list.getRemovedManagerList());
        mv.setViewName("/franchise/managerList");

        return mv;
    }

    /**
     * 가맹점 계정 정보(개인정보) 수정 메소드
     *
     * @param franchiseInfo 가맹점 대표자 계정 정보
     * @return the string 가맹점 대표자 계정 목록 조회 페이지 리다이렉트
     */
    @PostMapping("/updateFranchise")
    public String updateFranchise(FranchiseInfoDTO franchiseInfo) {

        franchiseService.updateFranchiseByCompany(franchiseInfo);

        return "redirect:/franchise/list";
    }

}
