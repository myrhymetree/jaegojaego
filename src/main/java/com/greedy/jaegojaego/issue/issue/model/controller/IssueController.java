package com.greedy.jaegojaego.issue.issue.model.controller;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDTO;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDetailDTO;
import com.greedy.jaegojaego.issue.issue.model.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/issue")
public class IssueController {

    private final IssueService issueService;

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

}
