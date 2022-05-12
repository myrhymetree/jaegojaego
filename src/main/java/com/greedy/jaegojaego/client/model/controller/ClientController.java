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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.sql.Date;

@Controller
@RequestMapping("/client")
@ResponseBody
public class ClientController {

    private final ClientService clientService;

    @Value("${jaegojaego.client.upload.path}")
    private String rootLocation;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public ModelAndView clientSelectList(HttpServletRequest request, ModelAndView mv, @PageableDefault Pageable pageable) {

        String searchCondition = request.getParameter("searchCondition");
        String searchValue = request.getParameter("searchValue");

        Page<ClientDTO> clientList = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
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

    @GetMapping("/cbrlist")
    public ModelAndView clientCbrList(HttpServletRequest request, ModelAndView mv, @PageableDefault Pageable pageable) {

        Page<ClientDTO> clientList = null;

        clientList = clientService.findClientList2(pageable); //list로 바꾼다음에
        System.out.println("ㄷㄷ");
        clientList.forEach(System.out::println);

        //이소현이 적은 거 시작
//        List<ClientCbrDTO> clientCbrDTOList = null;
//        ClientCbrDTO clientCbrDTO = null;
//
//        for(int i = 0; i < clientList.getSize(); i++) { //반복이 9번 되요 ㅋㅋㅋ
//
//            System.out.println("반복 몇번?"); //9번 나온다고 ㅋㅋㅋㅋ개빡치네
//            clientCbrDTO.setClientCbrAttachmentNo(clientList.get(i).clientCbrAttachmentNo);
//
//        }
//
//controller에서 clientCbrList를 넣어서 mv.addObject 넣어가지고 그친구 데려오면
//(여기 읽어줘)이소현이 적은 거 끝 ===> 안되는 사유 : clientList를 반복해서 set해서 ClientCbrList를 넣어주고 그걸 add.object뭐시기 할랬는데? get(i)부터가 안되고 , getSIze는 9번함 ㅋㅋㅋ 어이가 없네 이거 안됨 쳐내자 기주형 안ㅡ도ㅔ!

        mv.addObject("clientList", clientList);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(clientList);
        mv.addObject("paging", paging);



        mv.setViewName("/client/clientCbrList");

        return mv;
    }

    @GetMapping(value = "/detail", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String clientSelectDetail(HttpServletRequest request, ModelAndView mv, int clientNo) throws JsonProcessingException {

        List<ClientContractInfoDTO> clientContractInfoList = new ArrayList<>();

        clientContractInfoList = clientService.findClientDetailByClientNo(clientNo);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        System.out.println("상세보기 : " + clientContractInfoList);
        return gson.toJson(clientContractInfoList);
    }

    @GetMapping(value = "/memo", produces = "application/json; charset=UTF-8")
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
    public void registClient(ClientDTO client, ClientContractInfoDTO clientContractInfo, HttpServletRequest request, RedirectAttributes rttr, Locale locale) {

        System.out.println("컨트롤러 도착");
        String clientName = request.getParameter("clientName");
        String clientCbrNo = request.getParameter("clientCbrNo");
        String clientRepresentativeName = request.getParameter("clientRepresentativeName");
        String clientRepresentativePhone = request.getParameter("clientRepresentativePhone");
        String clientRepresentativeEmail = request.getParameter("clientRepresentativeEmail");
        String clientAddress = request.getParameter("clientAddress");
        int clientBusinessItemNo = Integer.parseInt(request.getParameter("clientBusinessItem"));
        int clientBusinessTypeNo = Integer.parseInt(request.getParameter("clientBusinessType"));
        Date clientContractStartDate = Date.valueOf(request.getParameter("clientContractInfoStartDate"));
        Date clientContractEndDate = Date.valueOf(request.getParameter("clientContractInfoEndDate"));


        ClientBusinessItem clientBusinessItem = clientService.findClientBusinessItemNo(clientBusinessItemNo);
        ClientBusinessType clientBusinessType = clientService.findClientBusinessTypeNo(clientBusinessTypeNo);

        System.out.println("clientName : " + clientName);

        Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser1 = (CustomUser) authentication1.getPrincipal();

        System.out.println("customUser1.getMemberNo() = " + customUser1.getMemberNo());

        int memberNo = customUser1.getMemberNo();
        ClientMember loginMember = clientService.findClientLoginNo(memberNo);

        System.out.println("memeberNo : " + memberNo);

        client.setClientName(clientName);
        client.setClientCbrNo(clientCbrNo);
        client.setClientRepresentativeName(clientRepresentativeName);
        client.setClientRepresentativeEmail(clientRepresentativeEmail);
        client.setClientRepresentativePhone(clientRepresentativePhone);
        client.setClientAddress(clientAddress);
        client.setClientMemberNo(loginMember);
        client.setClientBusinessItemNo(clientBusinessItem);
        client.setClientBusinessTypeNo(clientBusinessType);

        clientContractInfo.setClientContractInfoStartDate(clientContractStartDate);
        clientContractInfo.setClientContractInfoEndDate(clientContractEndDate);
        clientContractInfo.setClientContractInfoStatus("계약중");

        clientService.registClient(client, clientContractInfo);


    }

    @GetMapping("/removeclient")
    public void removeClient(HttpServletRequest request, RedirectAttributes rttr) {

        rttr.addFlashAttribute("flashAttribute", "removeclient");
        rttr.addAttribute("attribute", "removeclient");

        int clientNo = Integer.parseInt(request.getParameter("clientNo"));

        clientService.deleteClient(clientNo);
    }

    @GetMapping("/registmemo")
    public void registMemo(HttpServletRequest request, RedirectAttributes rttr) {

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


//    @GetMapping("/itemlist")
//    public ModelAndView clientContractItemSelectList(HttpServletRequest request, ModelAndView mv, @PageableDefault Pageable pageable) {
//
//        String searchCondition = request.getParameter("searchCondition");
//        String searchValue = request.getParameter("searchValue");
//
//        Page<ClientContractItemDTO> clientContractItemList = null;
//
//        if (searchCondition != null && !"".equals(searchCondition)) {
//            clientContractItemList = clientService.findClientItemSearchList(searchCondition, searchValue, pageable);
//        } else {
//            clientContractItemList = clientService.findClientItemList(pageable);
//        }
//
//        mv.addObject("clientContractItemList", clientContractItemList);
//
//        PagingButtonInfo paging = ClientPagenation.getPagingButtonInfo(clientContractItemList);
//        mv.addObject("paging", paging);
//
//        System.out.println("계약상품 : " + clientContractItemList);
//
//        mv.setViewName("/client/clientContractItemList");
//
//        return mv;
//    }

    @GetMapping("/itemlist")
    public ModelAndView clientContractItemSelectList(HttpServletRequest request, ModelAndView mv, @PageableDefault Pageable pageable) {

        List<ClientContractItemDTO> clientContractItem = null;

        clientContractItem = clientService.findClientItemList();

        mv.addObject("clientContractItemList", clientContractItem);
        mv.setViewName("/client/clientContractItemList");

        return mv;

    }




    @GetMapping("/itemregist")
    public ModelAndView sendClientItemRegistForm(ModelAndView mv) {

        List<ClientDTO> client = new ArrayList<>();

        client = clientService.findClient();

        mv.addObject("client", client);
        mv.setViewName("/client/clientContractItemRegistForm");

        return mv;
    }

    @PostMapping("/registclientitem")
    public ModelAndView registClientItem(@AuthenticationPrincipal CustomUser user, @ModelAttribute ClientContractItemDTO clientContractItemDTO, @ModelAttribute ClientDTO clientDTO, @RequestParam("clientItemImage") MultipartFile clientItemImage, ModelAndView mv, RedirectAttributes rttr, Locale locale) {
        System.out.println("clientContractItemDTO = " + clientContractItemDTO);
        System.out.println("clientDTO = " + clientDTO);
        System.out.println("clientItemImage = " + clientItemImage);

        ClientContractInfoDTO clientContractInfo = clientService.findClientContractNoByClientNo(clientDTO.getClientNo());

        System.out.println("registClientContractInfoNo : " + clientContractInfo);



        ClientContractItemDTO clientContractItemList = new ClientContractItemDTO();
        ClientContractItemAttachmentFileDTO clientContractItemAttachmentFileList = new ClientContractItemAttachmentFileDTO();

        String fileUploadDirectory = rootLocation;
        File conversionFileDirectory = new File(fileUploadDirectory);

        String thumbnailPath = "/upload/client/conversion/";

        File uploadDirectory = new File(fileUploadDirectory);
        File thumbnailDirectory = new File(thumbnailPath);

        if (!clientItemImage.isEmpty()) {

            if (!uploadDirectory.exists() || !thumbnailDirectory.exists()) {

                System.out.println("업로드 디렉토리 생성 : " + uploadDirectory.mkdirs());
                System.out.println("썸네일 디렉토리 생성 : " + thumbnailDirectory.mkdirs());

            }
            int memberNo = user.getMemberNo();
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setMemberNo(memberNo);

            System.out.println("멤버넘버 : " + user.getMemberNo());

            clientContractItemList.setClientContractItemName(clientContractItemDTO.getClientContractItemName());
            clientContractItemList.setClientContractItemSupplyPrice(clientContractItemDTO.getClientContractItemSupplyPrice());
            clientContractItemList.setClientContractInfoNo(clientContractInfo);
            clientContractItemList.setMemberNo(memberDTO);

            try {
                if (clientItemImage.getSize() > 0) {

                    String orgName = clientItemImage.getOriginalFilename();
                    String ext = orgName.substring(orgName.lastIndexOf("."));
                    String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                    clientItemImage.transferTo(new File(uploadDirectory + "/thumbnail_" + savedName));

                    clientContractItemAttachmentFileList.setAttachmentFileDeleteYn("N");
                    clientContractItemAttachmentFileList.setAttachmentFileUrl(fileUploadDirectory);
                    clientContractItemAttachmentFileList.setAttachmentFileChangedName(savedName);
                    clientContractItemAttachmentFileList.setAttachmentFileOriginalName(orgName);
                    clientContractItemAttachmentFileList.setAttachmentFileDivision("거래처상품");
                    clientContractItemAttachmentFileList.setAttachmentFileCategoryNo(5);

                    clientContractItemAttachmentFileList.setAttachmentFileThumbnailUrl(thumbnailPath + "thumbnail_" + savedName);
                }

                clientService.registClientContractItemAttachmentFile(clientContractItemList, clientContractItemAttachmentFileList);

            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();

                File deleteFile = new File(uploadDirectory + "/" + clientContractItemAttachmentFileList.getAttachmentFileChangedName());
                boolean isDeleted1 = deleteFile.delete();

                File deleteThumbnail = new File(thumbnailDirectory + "/thumbnail_" + clientContractItemAttachmentFileList.getAttachmentFileChangedName());
                boolean isDeleted2 = deleteThumbnail.delete();

                if (isDeleted1 && isDeleted2) {
                    e.printStackTrace();
                } else {
                    e.printStackTrace();
                }
            }

        }
        mv.setViewName("redirect:/client/itemlist");

        return mv;


//        System.out.println("컨트롤러 도착");
//        String clientItemName = request.getParameter("clientItemName");
//        int clientItemSupplyPrice = Integer.parseInt(request.getParameter("clientItemSupplyPrice"));
//        int clientNo = Integer.parseInt(request.getParameter("clientNo"));
//
//        System.out.println("1 : " + clientItemName);
//        System.out.println("1 : " + clientItemSupplyPrice);
//        System.out.println("1 : " + clientItemImage);
//        System.out.println("1 : " + clientNo);
//
//        ClientContractInfo clientContractInfo = clientService.findClientContractInfoNoByClientNo(clientNo);
//
//        clientContractItem.setClientContractItemName(clientItemName);
//        /*clientContractItem.setClientContractInfoNo();*/
//        clientContractItem.setClientContractItemSupplyPrice(clientItemSupplyPrice);

/*        String fileUploadDirectory = rootLocation;

        File conversionFileDirectory = new File(fileUploadDirectory);

        if (!conversionFileDirectory.exists()) {

            conversionFileDirectory.mkdirs();
        }

        List<MultipartFile> fileList = multirequest.getFiles("clientItemImage");

        List<ClientContractItemAttachmentFileDTO> clientContractItemAttachmentFile = new ArrayList<>();
        List<String> conversionNameList = new ArrayList<>();

        String originalFileName = ""; //원본 파일명
        String conversionFileName = ""; //변경 파일명

        if(fileList.get(0).getSize() > 0) {
            for (MultipartFile mf : fileList) {

                originalFileName = mf.getOriginalFilename();
                String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                conversionFileName = "thumbnail_" + UUID.randomUUID().toString().replace("-", "") + ext;

                if (originalFileName != null && originalFileName.length() != 0) {

                    try {
                        mf.transferTo(new File(fileUploadDirectory + "/" + conversionFileName));

                        conversionNameList.add(fileUploadDirectory + "/" + conversionFileName);

                        String thumbnailPath = "/upload/issue/conversion/" + conversionFileName;

                        ClientContractItemAttachmentFileDTO clientContractItemAttachmentFileList = new ClientContractItemAttachmentFileDTO();
                        clientContractItemAttachmentFileList.setAttachmentFileOriginalName(originalFileName);
                        clientContractItemAttachmentFileList.setAttachmentFileChangedName(conversionFileName);
                        clientContractItemAttachmentFileList.setAttachmentFileDeleteYn("N");
                        clientContractItemAttachmentFileList.setAttachmentFileDivision("이슈");
                        clientContractItemAttachmentFileList.setAttachmentFileUrl(fileUploadDirectory);
                        clientContractItemAttachmentFileList.setAttachmentFileThumbnailUrl(thumbnailPath);

                        clientContractItemAttachmentFile.add(clientContractItemAttachmentFileList);

                    } catch (IllegalStateException | IOException e) {
                        e.printStackTrace();

                        int deleteCnt = 0;

                        for (int i = 0; i < conversionNameList.size(); i++) {

                            File deleteFile = new File(conversionNameList.get(i));
                            boolean isDeleted = deleteFile.delete();

                            if (isDeleted) {
                                deleteCnt++;
                            }

                        }

                        if (fileList.size() == deleteCnt) {
                            System.out.println("업로드 실패한 모든 사진 삭제 완료");
                            e.printStackTrace();
                        } else {
                            e.printStackTrace();
                        }

                        clientService.registClientContractItem(clientContractItem, clientContractItemAttachmentFile);

                    }
                }

            }*/
//        }

    }
}