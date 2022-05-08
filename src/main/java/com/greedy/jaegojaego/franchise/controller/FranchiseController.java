package com.greedy.jaegojaego.franchise.controller;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.franchise.dto.FranchiseAccountDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseAttachmentFileDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseContractUpdatedRecordDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseInfoDTO;
import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.franchise.service.FranchiseService;
import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.service.MemberService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public FranchiseController(FranchiseService franchiseService, MemberService memberService, PasswordEncoder passwordEncoder) {
        this.franchiseService = franchiseService;
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/regist")
    public ModelAndView sendRegistView(ModelAndView mv) {

        mv.setViewName("/franchise/regist");

        return mv;
    }


    @PostMapping("/regist")
    public ModelAndView registMember(ModelAndView mv,
                                     HttpServletRequest request, @ModelAttribute FranchiseInfoDTO franchise,
                                     @RequestParam  MultipartFile bankAccountFile, @RequestParam  MultipartFile businessRegistrationFile, @RequestParam MultipartFile contractFile) {

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

        List<FranchiseAttachmentFileDTO> attachmentFiles = new ArrayList<>();

        if(bankAccountFile.getSize() > 0) {

            /* 업로드 된 파일 */
            FranchiseAttachmentFileDTO bankAccountFileDTO = new FranchiseAttachmentFileDTO();

            String bankAccountOriginalName = bankAccountFile.getOriginalFilename();
            System.out.println("bankAccountOriginalName = " + bankAccountOriginalName);

            String bankAccountfileName = bankAccountOriginalName.substring(bankAccountOriginalName.lastIndexOf("."));
            System.out.println("bankAccountfileName = " + bankAccountfileName);

            log.info("bankAccountfileName : " + bankAccountfileName );

            //날짜 폴더 생성
            String folederPath = makeFolder();

            //UUID
            String uuid = UUID.randomUUID().toString();

            //저장할 파일 이름 중간에 "-"를 이용해서 구분
            String bankAccountSaveName = uploadPath + File.separator + folederPath + File.separator + uuid + "_" + bankAccountfileName;

            Path bankAccountSavePath = Paths.get(bankAccountSaveName);

            /* file 정보 저장하여 DTO에 insert */
            bankAccountFileDTO.setAttachmentFileOriginalName(bankAccountOriginalName);
            bankAccountFileDTO.setAttachmentFileChangedName(bankAccountSaveName);
            bankAccountFileDTO.setAttachmentFileURL(folederPath);
            bankAccountFileDTO.setAttachmentFileDeleteYn("Y");
            bankAccountFileDTO.setAttachmentFileCategoryNo(2);

            try {
                bankAccountFile.transferTo(bankAccountSavePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            attachmentFiles.add(0, bankAccountFileDTO);
        }
        if(businessRegistrationFile.getSize() > 0) {

            FranchiseAttachmentFileDTO businessRegistrationFileDTO = new FranchiseAttachmentFileDTO();

            String businessRegistrationFileOriginalName = businessRegistrationFile.getOriginalFilename();
            String businessRegistrationfileName = businessRegistrationFileOriginalName.substring(businessRegistrationFileOriginalName.lastIndexOf("."));

            log.info("businessRegistrationfileName : " + businessRegistrationfileName );

            //날짜 폴더 생성
            String folederPath = makeFolder();

            //UUID
            String uuid = UUID.randomUUID().toString();

            String businessRegistrationSaveName = uploadPath + File.separator + folederPath + File.separator + uuid + "_" + businessRegistrationfileName;

            Path businessRegistrationSavePath = Paths.get(businessRegistrationSaveName);

            businessRegistrationFileDTO.setAttachmentFileOriginalName(businessRegistrationFileOriginalName);
            businessRegistrationFileDTO.setAttachmentFileChangedName(businessRegistrationSaveName);
            businessRegistrationFileDTO.setAttachmentFileURL(folederPath);
            businessRegistrationFileDTO.setAttachmentFileDeleteYn("Y");
            businessRegistrationFileDTO.setAttachmentFileCategoryNo(3);

            try {
                businessRegistrationFile.transferTo(businessRegistrationSavePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            attachmentFiles.add(1, businessRegistrationFileDTO);

        }
        if(contractFile.getSize() > 0) {

            FranchiseAttachmentFileDTO contractFileDTO = new FranchiseAttachmentFileDTO();

            String contractFileOriginalName = contractFile.getOriginalFilename();

            String contractfileName = contractFileOriginalName.substring(contractFileOriginalName.lastIndexOf("."));

            log.info("contractfileName : " + contractfileName );

            //날짜 폴더 생성
            String folederPath = makeFolder();

            //UUID
            String uuid = UUID.randomUUID().toString();

            String contractSaveName = uploadPath + File.separator + folederPath + File.separator + uuid + "_" + contractfileName;

            Path contractSavePath = Paths.get(contractSaveName);

            contractFileDTO.setAttachmentFileOriginalName(contractFileOriginalName);
            contractFileDTO.setAttachmentFileChangedName(contractSaveName);
            contractFileDTO.setAttachmentFileURL(folederPath);
            contractFileDTO.setAttachmentFileDeleteYn("Y");
            contractFileDTO.setAttachmentFileCategoryNo(1);

            try {
                contractFile.transferTo(contractSavePath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            attachmentFiles.add(2, contractFileDTO);
        }

        franchise.setFranchiseAttachmentFiles(attachmentFiles);

        System.out.println("franchise" + franchise);

        franchiseService.registFranchise(franchise, franchiseContractUpdatedRecordDTO);

        mv.setViewName("redirect:/franchise/regist");

        return mv;
    }

    @GetMapping("/list")
    public ModelAndView findFranchiseList(ModelAndView mv,  String searchWord) {

        List<FranchiseInfoDTO> franchiseList = franchiseService.findFranchiseList(searchWord);

        List<FranchiseAccountDTO> managerList = franchiseService.findManagerList(searchWord);

        mv.addObject("franchiseList", franchiseList);
        mv.addObject("managerList", managerList);

        mv.setViewName("franchise/list");

        return mv;
    }

    @GetMapping("/manager")
    public ModelAndView sendRegistManagerView(ModelAndView mv) {

        mv.setViewName("/franchise/registManager");

        return mv;
    }

    @PostMapping("/manager")
    public ModelAndView reistManager(ModelAndView mv, FranchiseAccountDTO manager) {

        franchiseService.registManager(manager);

        mv.setViewName("redirect:/franchise/manager");

        return mv;
    }

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

    @GetMapping(value = "/duplication", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public boolean duplicationIdCheck(HttpServletRequest request) {

        String memberId = request.getParameter("memberId");

        boolean status =  memberService.duplicationCheckId(memberId);

        return status;
    }

    @GetMapping(value = "/branch", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<FranchiseInfoDTO> findAllFranchise() {

        return franchiseService.findAllFranchise();
    }

    @PostMapping(value = "/modifymanager")
    public String updateManager(FranchiseAccountDTO manager) {

        System.out.println("manager = " + manager);
        System.out.println("매니저 비밀번호는 = " + manager.getMemberPwd());

        franchiseService.updateManagerInfo(manager);

        return "redirect:/";
    }

    @PostMapping(value = "/modifyfranchise")
    public String updateFranchise(FranchiseInfoDTO franchiseInfo) {

        franchiseService.updateFranchiseInfo(franchiseInfo);

        return "redirect:/";
    }
}
