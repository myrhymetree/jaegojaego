package com.greedy.jaegojaego.member.model.controller;

import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.dto.DepartmentDTO;
import com.greedy.jaegojaego.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView sendRegistView(ModelAndView mv) {


        mv.setViewName("/member/regist");

        return mv;
    }

    @PostMapping("/regist")
    public ModelAndView registMember(ModelAndView mv, MemberDTO newMember, RedirectAttributes rttr) {

        newMember.setMemberPwd(passwordEncoder.encode(newMember.getMemberPwd()));
        newMember.setMemberCreatedDate(LocalDateTime.now());
        newMember.setMemberPwdInitStatus("Y");
        newMember.setMemberRemoveStatus("Y");

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

//    @GetMapping("/list")
//    public ModelAndView findMemberList(ModelAndView mv) {
//
//        mv.setViewName("/member/list");
//
//        return mv;
//    }

//    @GetMapping(name = "/duplication/{memberId}", produces = "text/plain; charset=UTF-8")
//    @ResponseBody
//    public String duplicationIdCheck(ModelAndView mv, @PathVariable String memberId) {
//
//        String resultMessage = "중복아님";
//
//        /* 아이디가 조회되면 true 반환, 중복이라는 의미*/
//        if(memberService.duplicationCheckId(memberId)) {
//            resultMessage = "중복";
//        }
//
//        return resultMessage;
//    }
}
