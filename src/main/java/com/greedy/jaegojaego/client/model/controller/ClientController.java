package com.greedy.jaegojaego.client.model.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greedy.jaegojaego.client.model.dto.ClientDTO;
import com.greedy.jaegojaego.client.model.dto.ClientDetailDTO;
import com.greedy.jaegojaego.client.model.dto.ClientMemoDTO;
import com.greedy.jaegojaego.client.model.entity.Client;
import com.greedy.jaegojaego.client.model.entity.ClientMember;
import com.greedy.jaegojaego.client.model.entity.ClientMemo;
import com.greedy.jaegojaego.client.model.service.ClientService;
import com.greedy.jaegojaego.common.paging.Pagenation;
import com.greedy.jaegojaego.common.paging.PagingButtonInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        System.out.println("clientNo : " + clientNo);
        System.out.println("메모 컨트롤러 도착");

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
    public ModelAndView sendClientRegistForm(){

        return new ModelAndView("/client/clientRegistForm");
    }


    @GetMapping("/productlist")
    public ModelAndView clientContractItemList(ModelAndView mv) {

        mv.setViewName("/client/clientContractItemList");

        return mv;
    }

}
