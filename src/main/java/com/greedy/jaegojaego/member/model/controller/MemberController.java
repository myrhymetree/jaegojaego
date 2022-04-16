package com.greedy.jaegojaego.member.model.controller;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public void memberLoginForm() {

    }

    @GetMapping("regist")
    public ModelAndView sendRegistView() {

        return new ModelAndView("/member/regist");
    }

    @PostMapping("/regist")
    public ModelAndView registMember(ModelAndView mv, MemberDTO newMember, RedirectAttributes rttr) {

//        newMember.getPhone();

        memberService.registNewMember(newMember);

        rttr.addFlashAttribute("registSuccessMessage", "회원가입에 성공하셨습니다.");
        mv.setViewName("redirect:/");

        return mv;
    }

    @GetMapping(name = "/duplication/{memberId}", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String duplicationIdCheck(ModelAndView mv, @PathVariable String memberId) {

        String resultMessage = "중복아님";

        /* 아이디가 조회되면 true 반환, 중복이라는 의미*/
        if(memberService.duplicationCheckId(memberId)) {
            resultMessage = "중복";
        }

        return resultMessage;
    }
}
