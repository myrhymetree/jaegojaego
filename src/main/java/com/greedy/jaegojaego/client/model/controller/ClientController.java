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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;

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

/*    @GetMapping(value = "/registclient")
    @ResponseBody
    public void registClient(@ModelAttribute ClientDTO clientDTO, @ModelAttribute ClientBusinessItemDvisionDTO clientBusinessItemDvisionDTO,
                               @ModelAttribute ClientBusinessTypeDvisionDTO clientBusinessTypeDvisionDTO, @ModelAttribute ClientContractInfoDTO clientContractInfoDTO,
                               @ModelAttribute ClientMemberDTO clientMemberDTO, HttpServletRequest request, RedirectAttributes rttr, Locale locale,
                             @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date clientContractInfoStartDate,
                             @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date clientContractInfoEndDate) {

        System.out.println("컨트롤러 도착");
        String clientName = request.getParameter("clientName");
        String clientCbrNo = request.getParameter("clientCbrNo");
        String clientRepresentativeName = request.getParameter("clientRepresentativeName");
        String clientRepresentativePhone = request.getParameter("clientRepresentativePhone");
        String clientRepresentativeEmail = request.getParameter("clientRepresentativeEmail");
        String clientAddress = request.getParameter("clientAddress");
        int clientBusinessItem = Integer.parseInt(request.getParameter("clientBusinessItem"));
        int clientBusinessType = Integer.parseInt(request.getParameter("clientBusinessType"));

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

        int clientInsertNo = clientService.findClientNoByName(clientName);


        clientBusinessItemDvisionDTO.setClientBusinessItemNo(clientBusinessItem);
        System.out.println("업종번호 : " + clientBusinessItem);
        clientBusinessItemDvisionDTO.setClientNo(clientInsertNo);
        System.out.println("거래처번호 : " + clientInsertNo);
        clientService.registClientBusinessItemDevision(clientBusinessItemDvisionDTO);

        clientBusinessTypeDvisionDTO.setClientBusinessTypeNo(clientBusinessType);
        System.out.println("업태번호 : " + clientBusinessType);
        clientBusinessTypeDvisionDTO.setClientNo(clientInsertNo);
        clientService.registClientBusinessTypeDevision(clientBusinessTypeDvisionDTO);

        clientContractInfoDTO.setClientContractInfoStartDate(clientContractInfoStartDate);
        clientContractInfoDTO.setClientContractInfoEndDate(clientContractInfoEndDate);
        clientContractInfoDTO.setClientNo(clientInsertNo);
        clientService.registClientContractInfo(clientContractInfoDTO);

    }*/

    @GetMapping(value = "/registclient")
    @ResponseBody
    public void registClient(@ModelAttribute ClientInsertDTO clientInsert,HttpServletRequest request, RedirectAttributes rttr, Locale locale){

        System.out.println("컨트롤러 도착");
        String clientName = request.getParameter("clientName");
        String clientCbrNo = request.getParameter("clientCbrNo");
        String clientRepresentativeName = request.getParameter("clientRepresentativeName");
        String clientRepresentativePhone = request.getParameter("clientRepresentativePhone");
        String clientRepresentativeEmail = request.getParameter("clientRepresentativeEmail");
        String clientAddress = request.getParameter("clientAddress");
        int clientBusinessItem = Integer.parseInt(request.getParameter("clientBusinessItem"));
        int clientBusinessType = Integer.parseInt(request.getParameter("clientBusinessType"));

        System.out.println("clientName : " + clientName);

        Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser1 = (CustomUser) authentication1.getPrincipal();

        System.out.println("customUser1.getMemberNo() = " + customUser1.getMemberNo());

        int memberNo = customUser1.getMemberNo();
        ClientMember loginMember = clientService.findClientLoginNo(memberNo);

        System.out.println("memeberNo : " + memberNo);

        ClientBusinessItemDvisionDTO clientBusinessItemDvision = new ClientBusinessItemDvisionDTO();
        clientBusinessItemDvision.setClientBusinessItemNo(clientBusinessItem);

/*        ClientBusinessTypeDvisionDTO clientBusinessTypeDvision = new ClientBusinessTypeDvisionDTO();
        clientBusinessTypeDvision.setClientBusinessTypeNo(clientBusinessType);*/


    }

    @GetMapping("/removeclient")
    public void removeClient(HttpServletRequest request, RedirectAttributes rttr) {

        rttr.addFlashAttribute("flashAttribute", "removeclient");
        rttr.addAttribute("attribute","removeclient");

        int clientNo = Integer.parseInt(request.getParameter("clientNo"));

        clientService.deleteClient(clientNo);
    }

    @GetMapping("/registmemo")
    public void registMemo(HttpServletRequest request, RedirectAttributes rttr){

        String clientMemoBody = request.getParameter("clientMemoBody");
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


    @GetMapping("/itemlist")
    public ModelAndView clientContractItemSelectList(HttpServletRequest request, ModelAndView mv, @PageableDefault Pageable pageable) {

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Page<ClientContractItemDTO> clientContractItemList = null;

        if(searchCondition != null && !"".equals(searchCondition)){
            clientContractItemList = clientService.findClientItemSearchList(searchCondition, searchValue, pageable);
        } else {
            clientContractItemList = clientService.findClientItemList(pageable);
        }

        mv.addObject("clientContractItemList", clientContractItemList);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(clientContractItemList);
        mv.addObject("paging", paging);

        System.out.println("계약상품 : " + clientContractItemList);

        mv.setViewName("/client/clientContractItemList");

        return mv;
    }
}
