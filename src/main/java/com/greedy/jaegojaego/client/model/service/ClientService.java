/**
 * <pre>
 * Class : ClientService
 * Comment : Client(거래처 관리)관련 메소드를 모아놓은 Service입니다.
 * History
 * 2022/04/18 (윤기주) ClientController 기본 설정 작성
 * 2022/04/19 (윤기주) Client 목록 조회 페이지 이동 및 완성
 * 2022/04/21 (윤기주) Client 목록 조회 기능 작성
 * 2022/04/23 (윤기주) Client 상세 조회 기능 작성 및 완성
 * 2020/04/23 (윤기주) ClientMemo 조회 기능 작성 및 완성
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

package com.greedy.jaegojaego.client.model.service;

import com.greedy.jaegojaego.client.model.dto.*;
import com.greedy.jaegojaego.client.model.entity.*;
import com.greedy.jaegojaego.client.model.repository.*;
import com.greedy.jaegojaego.issue.attachement.model.entity.IssueAttachmentFileCategory;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMemoRepository clientMemoRepository;
    private final ClientBusinessTypeRepository clientBusinessTypeRepository;
    private final ClientBusinessItemRepository clientBusinessItemRepository;
    private final ClientMemberRepository clientMemberRepository;
    private final ClientBusinessItemDivisionRepository clientBusinessItemDivisionRepository;
    private final ClientBusinessTypeDivisionRepository clientBusinessTypeDivisionRepository;
    private final ClientContractInfoRepository clientContractInfoRepository;
    private final ClientContractItemRepository clientContractItemRepository;
    private final ClientCbrRepository clientCbrRepository;
    private final ClientContractItemAttachmentFileRepository clientContractItemAttachmentFileRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientMemoRepository clientMemoRepository, ClientBusinessTypeRepository clientBusinessTypeRepository, ClientBusinessItemRepository clientBusinessItemRepository, ClientMemberRepository clientMemberRepository, ClientBusinessItemDivisionRepository clientBusinessItemDivisionRepository, ClientBusinessTypeDivisionRepository clientBusinessTypeDivisionRepository, ClientContractInfoRepository clientContractInfoRepository, ClientContractItemRepository clientContractItemRepository, ClientCbrRepository clientCbrRepository, ClientContractItemAttachmentFileRepository clientContractItemAttachmentFileRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.clientMemoRepository = clientMemoRepository;
        this.clientBusinessTypeRepository = clientBusinessTypeRepository;
        this.clientBusinessItemRepository = clientBusinessItemRepository;
        this.clientMemberRepository = clientMemberRepository;
        this.clientBusinessItemDivisionRepository = clientBusinessItemDivisionRepository;
        this.clientBusinessTypeDivisionRepository = clientBusinessTypeDivisionRepository;
        this.clientContractInfoRepository = clientContractInfoRepository;
        this.clientContractItemRepository = clientContractItemRepository;
        this.clientCbrRepository = clientCbrRepository;
        this.clientContractItemAttachmentFileRepository = clientContractItemAttachmentFileRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * findClientSearchList : Client(거래처) 검색 목록 조회용 메소드(페이지 좌측 영역)
     * @ param searchCondition : 검색 카테고리
     * @ param searchValue : 검색 내용
     * @ param pageable : 페이징 정보
     * return : 거래처 정보
     * */
    public Page<ClientDTO> findClientSearchList(String searchCondition, String searchValue, Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("clientNo").descending());

        Page<Client> clientList = null;

        return clientList.map(client -> modelMapper.map(client, ClientDTO.class));
    }

    /**
     * findClientList : Client(거래처) 목록 조회용 메소드(페이지 좌측 영역)
     * @ param pageable : 페이징 정보
     * return : 거래처 정보
     * */
    public Page<ClientDTO> findClientList(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("clientNo").descending());

    return clientRepository.findAll(pageable).map(client -> modelMapper.map(client, ClientDTO.class));

    }

    /**
     * findClientDetailByClientNo : Client(거래처) 상세조회용 메소드(페이지 우측 영역)
     * @ param clientNo : ClientContractInfo를 조회하기 위한 ClientNo(FK)
     * return : 거래처 계약 정보
     * */
    @Transactional
    public List<ClientContractInfoDTO> findClientDetailByClientNo(int clientNo) {

       List<ClientContractInfo> clientContractInfoList = new ArrayList<>();

       clientContractInfoList = clientContractInfoRepository.findByClient(clientNo);

       return clientContractInfoList.stream().map(clientContractInfo -> modelMapper.map(clientContractInfo, ClientContractInfoDTO.class)).collect(Collectors.toList());
    }

    /**
     * findClientMemoByClientNo : ClientMemo(거래처 메모) 조회용 메소드
     * @ param clientNo : ClientMemo를 조회하기위한 ClientNo(FK)
     * return : 거래처 메모 정보
     * */
    @Transactional
    public List<ClientMemoDTO> findClientMemoByClientNo(int clientNo) {

        List<ClientMemo> clientMemoList = new ArrayList<>();

        clientMemoList = clientMemoRepository.findByClientNo(clientNo);

        return clientMemoList.stream().map(clientMemo -> modelMapper.map(clientMemo, ClientMemoDTO.class)).collect(Collectors.toList());
    }

    /**
     * findClientBusinessType : ClientBusinessType(업종) 목록 조회용 메소드
     * return : 거래처 업종 정보
     * */
    public List<ClientBusinessTypeDTO> findClientBusinessType() {

        List<ClientBusinessType> clientBusinessTypeList = new ArrayList<>();

        clientBusinessTypeList = clientBusinessTypeRepository.findAll();

        return clientBusinessTypeList.stream().map(clientBusinessType -> modelMapper.map(clientBusinessType, ClientBusinessTypeDTO.class)).collect(Collectors.toList());


    }
    /**
     * findClientBusinessType : ClientBusinessItem(업태) 목록 조회용 메소드
     * return : 거래처 업태 정보
     * */
    public List<ClientBusinessItemDTO> findClientBusinessItem() {

        List<ClientBusinessItem> clientBusinessItemList = new ArrayList<>();

        clientBusinessItemList = clientBusinessItemRepository.findAll();

        return clientBusinessItemList.stream().map(clientBusinessItem -> modelMapper.map(clientBusinessItem, ClientBusinessItemDTO.class)).collect(Collectors.toList());
    }

    /**
     * findClientLoginNo : 로그인 회원 조회용 메소드
     * @ param memberNo : 로그인 정보를 조회하기위한 memberNo(PK)
     * return : 로그인 회원 정보
     * */
    public ClientMember findClientLoginNo(int memberNo) {

        ClientMember clientMember = clientMemberRepository.findByClientMemberNo(memberNo);

        return clientMember;
    }
    /**
     * deleteClient : 거래처 삭제용 메소드
     * @ param clientNo : 삭제할 client 데이터의 clientNo(PK)
     * */
    public void deleteClient(int clientNo) {

        clientRepository.deleteById(clientNo);
    }
    /**
     * findClientItemSearchList : 거래처 삭제용 메소드
     * @ param searchCondition : 검색 카테고리
     * @ param searchValue : 검색 내용
     * @ param pageable : 페이징 정보
     * return : 검색된 거래처 계약 상품 정보
     * */
    public Page<ClientContractItemDTO> findClientItemSearchList(String searchCondition, String searchValue, Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("clientContractItemNo").descending());

        Page<ClientContractItem> clientContractItemList = null;

        return clientContractItemList.map(clientContractItem -> modelMapper.map(clientContractItem, ClientContractItemDTO.class));
    }
    /**
     * findClientItemSearchList : 업종 조회용 메소드
     * @ param clientBusinessItemNo : 업종 조회용 clientBusinessItemNo(Pk)
     * return : 해당 업종 정보
     * */
    public ClientBusinessItem findClientBusinessItemNo(int clientBusinessItemNo) {

        ClientBusinessItem clientBusinessItem = clientBusinessItemRepository.findByClientBusinessItemNo(clientBusinessItemNo);

        return clientBusinessItem;
    }
    /**
     * findClientBusinessTypeNo : 업태 조회용 메소드
     * @ param clientBusinessTypeNo : 업태 조회용 clientBusinessTypeNo(PK)
     * */
    public ClientBusinessType findClientBusinessTypeNo(int clientBusinessTypeNo) {

        ClientBusinessType clientBusinessType = clientBusinessTypeRepository.findByClientBusinessTypeNo(clientBusinessTypeNo);

        return clientBusinessType;
    }

    /**
     * findClientBusinessTypeNo : 거래처 등록용 메소드
     * @ param client : 입력받은 더래처 정보
     * @ param clientContractDTO : 입력받은 거래처 계약 정보
     * return : 해당 업태 정보
     * */
    public void registClient(ClientDTO client, ClientContractInfoDTO clientContractInfo) {

        Client newClient = new Client();

        newClient.setClientName(client.getClientName());
        newClient.setClientCbrNo(client.getClientCbrNo());
        newClient.setClientRepresentativeName(client.getClientRepresentativeName());
        newClient.setClientRepresentativePhone(client.getClientRepresentativePhone());
        newClient.setClientRepresentativeEmail(client.getClientRepresentativeEmail());
        newClient.setClientAddress(client.getClientAddress());
        newClient.setClientMember(client.getClientMemberNo());
        newClient.setClientCreatedDate(new Date(System.currentTimeMillis()));
        newClient.setClientPaymentMethod("일시불");

        System.out.println("newClient : " + newClient);

        clientRepository.save(newClient);

        Client clientNo = clientRepository.findByClientName(newClient.getClientName());

        ClientContractInfo newClientContractInfo = new ClientContractInfo();

        newClientContractInfo.setClientContractInfoStatus("계약중");
        newClientContractInfo.setClientContractInfoStartdate(clientContractInfo.getClientContractInfoStartDate());
        newClientContractInfo.setClientContractInfoEnddate(clientContractInfo.getClientContractInfoEndDate());
        newClientContractInfo.setClient(clientNo);

        clientContractInfoRepository.save(newClientContractInfo);

    }

    /**
     * findClient : 거래처 목록 출력용 메소드
     * return : 거래처 정보
     * */
    public List<ClientDTO> findClient() {

        List<Client> clientList = new ArrayList<>();

        clientList = clientRepository.findAll();

        return clientList.stream().map(Client -> modelMapper.map(Client, ClientDTO.class)).collect(Collectors.toList());
    }

    /**
     * findClientContractInfoNoByClientNo : 거래처 정보 조회용 메소드(상세정보)
     * @ param clientNo : 해당 계약정보 조회용 clientNo(FK)
     * return : 거래처 계약 정보
     * */
    public ClientContractInfo findClientContractInfoNoByClientNo(int clientNo) {

        ClientContractInfo clientContractInfo = clientContractItemRepository.findByClient(clientNo);

        return clientContractInfo;
    }

    /**
     * findClientContractNoByClientNo : 거래처 정보 조회용 메소드(상세정보)
     * @ param clientNo : 해당 계약정보 조회용 clientNo(FK)
     * return : 거래처 계약 정보
     * */
    public ClientContractInfoDTO findClientContractNoByClientNo(int clientNo) {

        ClientContractInfo clientContractInfo = clientContractInfoRepository.findClientContractInfoNoByClient_ClientNo(clientNo);

        return modelMapper.map(clientContractInfo, ClientContractInfoDTO.class);
    }
    /**
     * registClientContractItemAttachmentFile : 거래처 상품 및 이미지 저장용 메소드
     * @ param clientContractItemList : 거래처 상품 저장용 DTO
     * @ param clientContractItemAttachmentFileList : 첨부파일 저장용 DTO
     * */
    @Transactional
    public void registClientContractItemAttachmentFile(ClientContractItemDTO clientContractItemList, ClientContractItemAttachmentFileDTO clientContractItemAttachmentFileList) {

        ClientMember clientMember = new ClientMember();
        clientMember.setClientMemberNo(clientContractItemList.getMemberNo().getMemberNo());



        ClientContractItem clientContractItem = new ClientContractItem();
        clientContractItem.setClientContractItemName(clientContractItemList.getClientContractItemName());
        clientContractItem.setClientContractItemCreatedDate(new Date(System.currentTimeMillis()));
        clientContractItem.setClientContractItemSupplyPrice(clientContractItemList.getClientContractItemSupplyPrice());
        clientContractItem.setClientContractInfoNo(clientContractItemList.getClientContractInfoNo().getClientContractInfoNo());
        clientContractItem.setMemberNo(clientMember);


        clientContractItemRepository.save(clientContractItem);

        int clientContractItemNo = clientContractItemRepository.findClientContractItemNoByClientContractItemName();

        ClientContractItem attachmentClientContractItem = new ClientContractItem();
        attachmentClientContractItem.setClientContractItemNo(clientContractItemNo);

        IssueAttachmentFileCategory attachmentFileCategory = new IssueAttachmentFileCategory();
        attachmentFileCategory.setAttachmentFileCategoryNo(clientContractItemAttachmentFileList.getAttachmentFileCategoryNo());

        ClientContractItemAttachmentFile clientContractItemAttachmentFile = new ClientContractItemAttachmentFile();
        clientContractItemAttachmentFile.setClientContractItem(attachmentClientContractItem);
        clientContractItemAttachmentFile.setAttachmentFileDeleteYn(clientContractItemAttachmentFileList.getAttachmentFileDeleteYn());
        clientContractItemAttachmentFile.setAttachmentFileDivision(clientContractItemAttachmentFileList.getAttachmentFileDivision());
        clientContractItemAttachmentFile.setAttachmentFileUrl(clientContractItemAttachmentFileList.getAttachmentFileUrl());
        clientContractItemAttachmentFile.setAttachmentFileChangedName(clientContractItemAttachmentFileList.getAttachmentFileChangedName());
        clientContractItemAttachmentFile.setAttachmentFileOriginalName(clientContractItemAttachmentFileList.getAttachmentFileOriginalName());
        clientContractItemAttachmentFile.setAttachmentFileThumbnailUrl(clientContractItemAttachmentFileList.getAttachmentFileThumbnailUrl());
        clientContractItemAttachmentFile.setIssueAttachmentFileCategory(attachmentFileCategory);

        clientContractItemAttachmentFileRepository.save(clientContractItemAttachmentFile);
       

    }
    /**
     * findClientItemList : 거래처 상품 출력용 메소드
     * return: 거래처 상품 정보
     * */
    public List<ClientContractItemDTO> findClientItemList() {

        List<ClientContractItemDTO> clientContractItemList = clientContractItemRepository.findAll().stream().map(clientContractItem -> modelMapper.map(clientContractItem,ClientContractItemDTO.class)).collect(Collectors.toList());

        for(int i = 0; i < clientContractItemList.size(); i++){
            ClientContractItemAttachmentFile clientContractItemAttachmentFile = clientContractItemAttachmentFileRepository.findByClientContractItem_ClientContractItemNoAndAttachmentFileDeleteYn(clientContractItemList.get(i).getClientContractItemNo(), "N");

            if(clientContractItemAttachmentFile != null ) {
                clientContractItemList.get(i).setFilePath(clientContractItemAttachmentFile.getAttachmentFileThumbnailUrl());
            }
        }
        return clientContractItemList;
    }

    /**
     * findClientList2 : 거래처 사업자 등록증 출력용 메소드
     * @ param pageable : 페이징 정보
     * return: 거래처 , 첨부파일 정보
     * */
    public Page<ClientDTO> findClientList2(Pageable pageable) {

        pageable = PageRequest.of(pageable.getPageNumber() <= 0? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("clientNo").descending());

        return clientRepository.findAll(pageable).map(client -> modelMapper.map(client, ClientDTO.class));

    }
}
