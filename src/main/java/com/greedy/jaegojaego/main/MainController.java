package com.greedy.jaegojaego.main;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private final MemberService memberService;

    public MainController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping({"/","/main"})
    public String loginView(Authentication authentication, Model model) {

        if(authentication != null) {
            CustomUser customUser = (CustomUser) authentication.getPrincipal();

            System.out.println("customUser.getMemberDivision() = " + customUser.getMemberDivision());

            model.addAttribute("memberDivision", customUser.getMemberDivision());
            model.addAttribute("officeDivision", customUser.getOfficeDivision());

            if(customUser.getMemberDivision().equals("본사")) {
                Object loginMember = memberService.findLoginMemberInfo(customUser);

//                model.addAttribute("officePhoneNumber", loginMember.getOfficePhoneNumber());
            }

        }

        return "main/main";
    }

    @PostMapping(value = "/")
    public String redirectMain() {

        return "redirect:/";
    }

}
