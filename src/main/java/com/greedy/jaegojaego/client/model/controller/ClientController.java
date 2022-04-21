package com.greedy.jaegojaego.client.model.controller;

import com.greedy.jaegojaego.client.model.dto.ClientDTO;
import com.greedy.jaegojaego.client.model.service.ClientService;
import com.greedy.jaegojaego.common.paging.Pagenation;
import com.greedy.jaegojaego.common.paging.PagingButtonInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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

        mv.addObject("searchCondition", searchCondition);
        mv.addObject("searchValue", searchValue);

        mv.setViewName("/client/clientList");

        return mv;
    }





    @GetMapping("/productlist")
    public ModelAndView clientContractItemList(ModelAndView mv) {

        mv.setViewName("/client/clientContractItemList");

        return mv;
    }

}
