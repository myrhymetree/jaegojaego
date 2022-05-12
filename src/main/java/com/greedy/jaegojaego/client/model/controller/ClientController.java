/**
 * <pre>
 * Class : ClientController
 * Comment : Client(거래처 관리)관련 메소드를 모아놓은 Controller입니다.
 * History
 * 2022/04/18 (윤기주) ClientController 기본 설정 작성
 * 2022/04/19 (윤기주) Client 목록 조회 페이지 이동 및 완성
 * 2022/04/21 (윤기주) Client 목록 조회 기능 작성
 * 2022/04/23 (윤기주) Client 상세 조회 기능 작성 및 완성
 * 2020/04/23 (윤기주) Client 메모 조회 기능 작성 및 완성
 * 2022/04/24 (윤기주) Client 등록 기능 작성
 * 2022/04/25 (윤기주) Client 삭제 기능 작성 및 완성
 * 2022/04/26 (윤기주) Client 목록 조회 기능 수정(JOIN TABLE 조회 추가) 및 완성
 * 2022/04/27 (윤기주) Client 등록 기능 1차 수정
 * 2022/04/29 (윤기주) Client 등록 기능 2차 수정
 * 2022/04/30 (윤기주) Client 등록 기능 3차 수정 및 완성
 * 2020/05/01 (윤기주) ClientContractItem 목록 조회 페이지 이동 및 완성
 * 2022/05/01 (윤기주) ClientContractItem 목록 조회 기능 작성 및 완성
 * 2020/05/03 (윤기주) ClientContractItem 목록 등록 기능 작성 및 완성
 * 2020/05/04 (윤기주) ClientContractItem 목록 조회 기능 수정(JOIN TABLE 조회 추가) 및 완성
 * 2020/05/06 (윤기주) ClientContractItem 목록 등록 기능 1차 수정
 * 2020/05/07 (윤기주) ClientContractItem 목록 이미지 등록 기능 작성
 * 2020/05/08 (윤기주) ClientContractItem 목록 등록 기능 1차 수정
 * 2020/05/09 (윤기주) ClientContractItem 목록 등록 기능 2차 수정 및 완성
 * 2020/05/10 (윤기주) ClientContractItem 목록 이미지 및 썸네일 경로 기능 작성
 * 2020/05/11 (윤기주) ClientContractItem 첨부파일 등록 기능 작성
 * 2020/05/11 (윤기주) ClientContractItem 첨부파일 등록 기능 1차 수정(미완성)
 * </pre>
 * @version 11
 * @author 윤기주
 */


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

    /**
     * clientSelectList : Client 조회 페이지 이동 및 목록 출력 메소드
     * @ param searchCondition : 검색 카테고리
     * @ param searchValue : 검색 내용
     * @ return : 페이징을 포함한 목록 데이터, 화면 경로
     * */
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

        mv.setViewName("/client/clientList");

        return mv;
    }
    /**
     * clientCbrList : Client 사업자 등록증 조회 페이지 이동 및 목록 출력 메소드
     * @ return : 페이징을 포함한 목록 데이터, 화면 경로
     * 기능 미완성
     * */
    @GetMapping("/cbrlist")
    public ModelAndView clientCbrList(HttpServletRequest request, ModelAndView mv, @PageableDefault Pageable pageable) {

        Page<ClientDTO> clientList = null;

        clientList = clientService.findClientList2(pageable);
        System.out.println("ㄷㄷ");
        clientList.forEach(System.out::println);

        mv.addObject("clientList", clientList);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(clientList);
        mv.addObject("paging", paging);



        mv.setViewName("/client/clientCbrList");

        return mv;
    }

    /**
     * clientSelectDetail : Client 상세 조회 페이지 이동 및 목록 출력 메소드
     * @ return : 상세조회 목록 데이터
     * */
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

    /**
     * clientMemo : Client 메모조회 페이지 이동 및 목록 출력 메소드
     * @ param clientNo : 해당 메모가 저장되어있는 ClientNo(PK)
     * @ return : 메모 목록 데이터
     * */
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
    /**
     * sendClientRegistForm : Client 등록 화면 전환 메소드
     * @ return : Client 등록 화면 경로
     * */
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
    /**
     * registClient : Client 등록 메소드
     * @ param clientName : 입력받은 clientName
     * @ param clientCbrNo : 입력받은 clientCbrNo
     * @ param clientRepresentativeName : 입력받은 clientRepresentativeName
     * @ param clientRepresentativePhone : 입력받은 clientRepresentativePhone
     * @ param clientRepresentativePhone : 입력받은 clientRepresentativePhone
     * @ param clientRepresentativeEmail : 입력받은 clientRepresentativeEmail
     * @ param clientBusinessItemNo : ClientBusinessItem 목록에서 입력받은 clientBusinessItem의 clientBusinessItemNo
     * @ param clientBusinessTypeNo : ClientBusinessType 목록에서 입력받은 clientBusinessType의 clientBusinessTypeNo
     * @ param clientContractStartDate : 입력받은 clientContractStartDate
     * @ param clientContractEndDate : 입력받은 clientContractEndDate
     * */
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
    /**
     * removeClient : Client 삭제 메소드
     * @ param clientNo : 삭제하기위한 Client 데이터의 clientNo(PK)
     * */
    @GetMapping("/removeclient")
    public void removeClient(HttpServletRequest request, RedirectAttributes rttr) {

        rttr.addFlashAttribute("flashAttribute", "removeclient");
        rttr.addAttribute("attribute", "removeclient");

        int clientNo = Integer.parseInt(request.getParameter("clientNo"));

        clientService.deleteClient(clientNo);
    }
    /**
     * registMemo : Client 등록 메소드
     * @ param clientMemoBody : 입력받은 clientMemoBody
     * @ param clientNo : 입력할 clientMemo의 clientNo(FK)
     * 기능 미완성
     * */
    @GetMapping("/registmemo")
    public void registMemo(HttpServletRequest request, RedirectAttributes rttr) {

        String clientMemoBody = request.getParameter("clientMemoBody");
    }

    /**
     * clientContractItemSelectList : Client 조회 페이지 이동 및 목록 출력 메소드
     * @ param searchCondition : 검색 카테고리
     * @ param searchValue : 검색 내용
     * @ return : 페이징을 포함한 목록 데이터, 화면 경로
     * */
    @GetMapping("/itemlist")
    public ModelAndView clientContractItemSelectList(HttpServletRequest request, ModelAndView mv, @PageableDefault Pageable pageable) {

        List<ClientContractItemDTO> clientContractItem = null;

        clientContractItem = clientService.findClientItemList();

        mv.addObject("clientContractItemList", clientContractItem);
        mv.setViewName("/client/clientContractItemList");

        return mv;
    }
    /**
     * registClientItem : 거래처 계약 상품 등록 및 이미지 등록, 써네일 경로 등록
     * @ param clientContractItemDTO : 로그인되어있는 id 번호
     * @ param clientDTO : 검색 내용
     * @ return : 페이징을 포함한 목록 데이터, 화면 경로
     * */
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