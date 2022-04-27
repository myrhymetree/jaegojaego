package com.greedy.jaegojaego.client.model.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.client.model.dto.*;
import com.greedy.jaegojaego.client.model.entity.*;
import com.greedy.jaegojaego.client.model.service.ClientService;
import com.greedy.jaegojaego.common.paging.Pagenation;
import com.greedy.jaegojaego.common.paging.PagingButtonInfo;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;
import java.util.*;

@Controller
@RequestMapping("/client")
@ResponseBody
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public ModelAndView clientSelectList(HttpServletRequest request, ModelAndView mv, @PageableDefault Pageable pageable) {

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Page<ClientDTO> clientList = null;

        if(searchCondition != null && !"".equals(searchCondition)){
            clientList = clientService.findClientSearchList(searchCondition, searchValue, pageable);
        } else {
            clientList = clientService.findClientList(pageable);
        }

        mv.addObject("clientList", clientList);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(clientList);
        mv.addObject("paging", paging);

/*        mv.addObject("searchCondition", searchCondition);
        mv.addObject("searchValue", searchValue);*/

        mv.setViewName("/client/clientList");

        return mv;
    }

    @GetMapping(value ="/detail", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String clientSelectDetail(HttpServletRequest request, ModelAndView mv, int clientNo) throws JsonProcessingException {

        ClientDetailDTO clientDetail = clientService.findClientDetailByClientNo(clientNo);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(clientDetail);
    }

    @GetMapping(value ="/memo", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String clientMemo(HttpServletRequest request, ModelAndView mv, int clientNo) throws JsonProcessingException {

        List<ClientMemoDTO> clientMemoList = new ArrayList<>();

        clientMemoList = clientService.findClientMemoByClientNo(clientNo);

        System.out.println("clientMemoList : " + clientMemoList);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        return gson.toJson(clientMemoList);
    }

    @GetMapping("/regist")
    public ModelAndView sendClientRegistForm(ModelAndView mv) {

        List<ClientBusinessTypeDTO> clientBusinessType = new ArrayList<>();
        List<ClientBusinessItemDTO> clientBusinessItem = new ArrayList<>();

        clientBusinessType = clientService.findClientBusinessType();
        clientBusinessItem = clientService.findClientBusinessItem();

        mv.addObject("clientBusinessType", clientBusinessType);
        mv.addObject("clientBusinessItem", clientBusinessItem);
        mv.setViewName("/client/clientRegistForm");

        System.out.println("clientBusinessType : " + clientBusinessType);

        return mv;
    }

    @GetMapping(value = "/registclient", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ModelAndView registClient(@ModelAttribute ClientDTO clientDTO, @ModelAttribute ClientBusinessItemDTO clientBusinessItemDTO,
                               @ModelAttribute ClientBusinessTypeDTO clientBusinessTypeDTO, @ModelAttribute ClientContractInfoDTO clientContractInfoDTO,
                               @ModelAttribute ClientMemberDTO clientMemberDTO, HttpServletRequest request, RedirectAttributes rttr, Locale locale, ModelAndView mv)
            throws JsonProcessingException {

        String clientName = request.getParameter("clientName");
        String clientCbrNo = request.getParameter("clientCbrNo");
        String clientRepresentativeName = request.getParameter("clientRepresentativeName");
        String clientRepresentativePhone = request.getParameter("clientRepresentativePhone");
        String clientRepresentativeEmail = request.getParameter("clientRepresentativeEmail");
        String clientAddress = request.getParameter("clientAddress");
        java.sql.Date clientContractInfoStartDate;
        Date clientContractInfoEndDate;
        int clientBusinessItem;
        int clientBusinessType;

        System.out.println("clientName : " + clientName);

        Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser1 = (CustomUser) authentication1.getPrincipal();

        System.out.println("customUser1.getMemberNo() = " + customUser1.getMemberNo());

        int memberNo = customUser1.getMemberNo();
        ClientMember loginMember = clientService.findClientLoginNo(memberNo);



        System.out.println("memeberNo : " + memberNo);

        clientDTO.setClientName(clientName);
        clientDTO.setClientCbrNo(clientCbrNo);
        clientDTO.setClientRepresentativeName(clientRepresentativeName);
        clientDTO.setClientRepresentativePhone(clientRepresentativePhone);
        clientDTO.setClientRepresentativeEmail(clientRepresentativeEmail);
        clientDTO.setClientMemberNo(loginMember);

        System.out.println("clientDTO : " + clientDTO);

        clientService.registClient(clientDTO);

        mv.setViewName("client/list");

        return mv;

    }

    @GetMapping("/removeclient")
    @ResponseBody
    public String removeClient(HttpServletRequest request, RedirectAttributes rttr, Locale locale) {

        int clientNo = Integer.parseInt(request.getParameter("clientNo"));

        clientService.deleteClient(clientNo);

        return "redirect:/client/list";
    }



//    @GetMapping(value ="/businesstypeoption", produces = "application/json; charset=UTF-8")
//    @ResponseBody
//    public String clientBusinessType(HttpServletRequest request, ModelAndView mv) throws JsonProcessingException{
//
//        List<ClientBusinessTypeDTO> clientBusinessType = new ArrayList<>();
//
//        clientBusinessType = clientService.findClientBusinessType();
//
//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd")
//                .setPrettyPrinting()
//                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
//                .serializeNulls()
//                .disableHtmlEscaping()
//                .create();
//
//        return gson.toJson(clientBusinessType);
//
//
//
//    }


/*    @GetMapping("/productlist")
    public ModelAndView clientContractItemList(ModelAndView mv) {

        mv.setViewName("/client/clientContractItemList");

        return mv;
    }*/

}
