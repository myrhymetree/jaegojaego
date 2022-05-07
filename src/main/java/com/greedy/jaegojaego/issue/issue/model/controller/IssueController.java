package com.greedy.jaegojaego.issue.issue.model.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDTO;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDetailDTO;
import com.greedy.jaegojaego.issue.issue.model.service.IssueService;
import com.greedy.jaegojaego.order.order.model.dto.franchise.FranchiseOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping(value = "/detail", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectIssueDetail(HttpServletRequest request) {

        int issueNo = Integer.parseInt(request.getParameter("issueNo"));

        IssueDTO issue = issueService.selectIssueDetail(issueNo);

        Gson gson = new Gson();

        return gson.toJson(issue);
    }

    @GetMapping("/regist")
    public ModelAndView registIssue(ModelAndView mv) {

        mv.setViewName("/issue/issueRegist");

        return mv;
    }

    @GetMapping(value = "/selectissueorder", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String selectIssueOrder(Authentication authentication) {

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        List<FranchiseOrderDTO> franchiseOrderList = issueService.selectIssueOrderList(customUser);

        Gson gson = new Gson();

        return gson.toJson(franchiseOrderList);
    }

}
