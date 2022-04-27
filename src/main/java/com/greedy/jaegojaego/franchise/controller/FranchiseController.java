package com.greedy.jaegojaego.franchise.controller;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.franchise.dto.FranchiseAttachmentFileDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseInfoDTO;
import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.DepartmentDTO;
import com.greedy.jaegojaego.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/franchise")
public class FranchiseController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FranchiseController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/regist")
    public ModelAndView sendRegistView(ModelAndView mv) {

        mv.setViewName("/franchise/regist");

        return mv;
    }

    @PostMapping("/regist")
    public ModelAndView registMember(ModelAndView mv, FranchiseInfoDTO franchise,
                                     @RequestParam  MultipartFile inputGroupFile01, @RequestParam  MultipartFile inputGroupFile02, @RequestParam  MultipartFile inputGroupFile03) {

        franchise.setMemberPwd(passwordEncoder.encode(franchise.getMemberPwd()));
        franchise.setMemberCreatedDate(LocalDateTime.now());
        franchise.setMemberPwdInitStatus("Y");
        franchise.setMemberRemoveStatus("Y");
        franchise.setMemberDivision("가맹점");

        /* 업로드 된 파일 */
        FranchiseAttachmentFileDTO attachmentFile = new FranchiseAttachmentFileDTO();




//        franchise.setFranchiseAttachmentFiles();

        System.out.println("franchise" + franchise);



        mv.setViewName("redirect:/member/regist");

        return mv;
    }

    @GetMapping("/list")
    public ModelAndView findMemberList(ModelAndView mv, HttpServletRequest request) {

        String searchWord = request.getParameter("searchWord");

        List<CompanyAccountDTO> memberList = memberService.findMemberList(searchWord);

        Integer count = memberService.countAll();

        mv.addObject("memberList", memberList);

        mv.addObject("count", count);

        mv.setViewName("/member/list");

        return mv;
    }

    @GetMapping(value = "/duplication", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public boolean duplicationIdCheck(HttpServletRequest request) {

        String memberId = request.getParameter("memberId");

        boolean status =  memberService.duplicationCheckId(memberId);

        return status;
    }
}
