package com.greedy.jaegojaego.member.model.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.dto.DepartmentDTO;
import com.greedy.jaegojaego.member.model.repository.CompanyAccountRepository;
import com.greedy.jaegojaego.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public void memberLoginForm() {

    }

    @GetMapping("/regist")
    public ModelAndView sendRegistView(ModelAndView mv, Model model, Authentication authentication) {

        mv.setViewName("/member/regist");

        return mv;
    }

    @PostMapping("/regist")
    public ModelAndView registMember(ModelAndView mv, CompanyAccountDTO newMember, RedirectAttributes rttr) {

        newMember.setMemberPwd(passwordEncoder.encode(newMember.getMemberPwd()));
        newMember.setMemberCreatedDate(LocalDateTime.now());
        newMember.setMemberPwdInitStatus("Y");
        newMember.setMemberRemoveStatus("Y");
        newMember.setOfficeDivision("직원");
        newMember.setMemberDivision("본사");

        System.out.println("NewMember" + newMember);

        memberService.registNewMember(newMember);

        rttr.addFlashAttribute("registSuccessMessage", "회원가입에 성공하셨습니다.");
        mv.setViewName("redirect:/member/regist");

        return mv;
    }

    @GetMapping(value = "/department", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<DepartmentDTO> findAllDepartment() {

        return memberService.findDepartmentAll();
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

    @GetMapping(value = "/loginMemberInformation", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Object findMemberInformation(Authentication authentication, Model model) {

        if(authentication.getPrincipal() != null) {
            CustomUser customUser = (CustomUser) authentication.getPrincipal();

            Object loginMember = memberService.findLoginMemberInfo(customUser);

            return loginMember;
        }
        return null;
    }

    @PostMapping(value = "/modify")
    public String updateMember(CompanyAccountDTO companyAccount) {

        memberService.updateLoginMemberInfo(companyAccount);

        return "redirect:/";
    }
}
