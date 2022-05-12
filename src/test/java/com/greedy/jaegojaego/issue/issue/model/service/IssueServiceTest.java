package com.greedy.jaegojaego.issue.issue.model.service;

import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.issue.attachement.model.entity.IssueAttachmentFile;
import com.greedy.jaegojaego.issue.attachement.model.repository.IssueAttachmentFileRepository;
import com.greedy.jaegojaego.issue.company.model.entity.IssueCompanyAccount;
import com.greedy.jaegojaego.issue.company.model.repository.IssueCompanyAccountRepository;
import com.greedy.jaegojaego.issue.franchise.model.dto.IssueFranchiseAccountDTO;
import com.greedy.jaegojaego.issue.franchise.model.dto.IssueFranchiseInfoDTO;
import com.greedy.jaegojaego.issue.franchise.model.entity.IssueFranchiseAccount;
import com.greedy.jaegojaego.issue.franchise.model.entity.IssueFranchiseInfo;
import com.greedy.jaegojaego.issue.franchise.model.repository.IssueFranchiseAccountRepository;
import com.greedy.jaegojaego.issue.franchise.model.repository.IssueFranchiseInfoRepository;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDTO;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDetailDTO;
import com.greedy.jaegojaego.issue.issue.model.entity.Issue;
import com.greedy.jaegojaego.issue.issue.model.entity.IssueHistory;
import com.greedy.jaegojaego.issue.issue.model.entity.IssueItem;
import com.greedy.jaegojaego.issue.issue.model.repository.IssueHistoryRepository;
import com.greedy.jaegojaego.issue.issue.model.repository.IssueItemRepository;
import com.greedy.jaegojaego.issue.issue.model.repository.IssueRepository;
import com.greedy.jaegojaego.issue.outWarehouse.model.entity.IssueOutWarehouse;
import com.greedy.jaegojaego.issue.outWarehouse.model.repository.IssueOutWarehouseRepository;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.order.order.model.entity.franchise.FranchiseOrder;
import com.greedy.jaegojaego.order.order.model.repository.franchise.FranchiseOrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class, JaegojaegoApplication.class})
class IssueServiceTest {

    @Autowired
    private IssueFranchiseInfoRepository issueFranchiseInfoRepository;

    @Autowired
    private IssueFranchiseAccountRepository issueFranchiseAccountRepository;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FranchiseOrderRepository franchiseOrderRepository;

    @Autowired
    private IssueOutWarehouseRepository issueOutWarehouseRepository;

    @Autowired
    private IssueItemRepository issueItemRepository;

    @Autowired
    private IssueAttachmentFileRepository issueAttachmentFileRepository;

    @Autowired
    private IssueHistoryRepository issueHistoryRepository;

    @Autowired
    private IssueCompanyAccountRepository issueCompanyAccountRepository;

    @Test
    @DisplayName("이슈 목록 조회")
    @Transactional
    public void selectIssueList() {

        //given
        String companyMemberDivision = "본사";
        int companyNo = 107;

        //when
        List<Issue> issueList = new ArrayList<>();
        List<IssueFranchiseAccount> franchiseAccountList = new ArrayList<>();
        List<IssueDetailDTO> issueDetailList = new ArrayList<>();

        if("본사".equals(companyMemberDivision)) {

            List<IssueFranchiseInfo> issueFranchiseInfoList = issueFranchiseInfoRepository.findByHeadOfficeSupervisor_MemberNo(companyNo);

            for(int i = 0; i < issueFranchiseInfoList.size(); i++) {

                List<IssueFranchiseAccount> issueFranchiseAccountList = issueFranchiseAccountRepository.findByFranchiseInfo_FranchiseRepresentativeNo(issueFranchiseInfoList.get(i).getFranchiseRepresentativeNo());

                for(int j = 0; j < issueFranchiseAccountList.size(); j++) {

                    franchiseAccountList.add(issueFranchiseAccountList.get(j));

                }

            }

            issueList = issueRepository.findAll(Sort.by(Sort.Direction.DESC, "franchiseIssueNo"));

            issueDetailList = setIssueDetail(issueList, issueFranchiseInfoList, franchiseAccountList);

        } else if("가맹점".equals(companyMemberDivision)) {

            if("대표자".equals(companyMemberDivision)) {

                IssueFranchiseInfo issueFranchiseInfo = issueFranchiseInfoRepository.findById(companyNo).get();

                List<IssueFranchiseAccount> issueFranchiseAccountList = issueFranchiseAccountRepository.findByFranchiseInfo_FranchiseRepresentativeNo(issueFranchiseInfo.getFranchiseRepresentativeNo());

                issueList = issueRepository.findByFranchiseIssuePresenter_MemberNoOrderByFranchiseIssueCreatedDateDesc(companyNo);

                for(int i = 0; i < issueFranchiseAccountList.size(); i++) {

                    List<Issue> accountIssueList = issueRepository.findByFranchiseIssuePresenter_MemberNoOrderByFranchiseIssueCreatedDateDesc(issueFranchiseAccountList.get(i).getFranchiseManagerNo());

                    for(int j = 0; j < accountIssueList.size(); j++) {

                        issueList.add(accountIssueList.get(j));
                    }
                }

                issueDetailList = setIssueDetailByFranchise(issueList, issueFranchiseInfo, issueFranchiseAccountList);

            } else {

                IssueFranchiseAccount issueFranchiseAccount = issueFranchiseAccountRepository.findById(companyNo).get();

                IssueFranchiseInfo issueFranchiseInfo = issueFranchiseInfoRepository.findById(issueFranchiseAccount.getFranchiseInfo().getFranchiseRepresentativeNo()).get();

                List<IssueFranchiseAccount> issueFranchiseAccountList = issueFranchiseAccountRepository.findByFranchiseInfo_FranchiseRepresentativeNo(issueFranchiseInfo.getFranchiseRepresentativeNo());

                issueList = issueRepository.findByFranchiseIssuePresenter_MemberNoOrderByFranchiseIssueCreatedDateDesc(issueFranchiseInfo.getFranchiseRepresentativeNo());

                for(int i = 0; i < issueFranchiseAccountList.size(); i++) {

                    List<Issue> accountIssueList = issueRepository.findByFranchiseIssuePresenter_MemberNoOrderByFranchiseIssueCreatedDateDesc(issueFranchiseAccountList.get(i).getFranchiseManagerNo());

                    for(int j = 0; j < accountIssueList.size(); j++) {

                        issueList.add(accountIssueList.get(j));
                    }
                }

                issueDetailList = setIssueDetailByFranchise(issueList, issueFranchiseInfo, issueFranchiseAccountList);

            }

        }

        //then
        assertNotNull(issueDetailList);

    }

    private List<IssueDetailDTO> setIssueDetailByFranchise(List<Issue> issueList, IssueFranchiseInfo issueFranchiseInfo, List<IssueFranchiseAccount> issueFranchiseAccountList) {

        List<IssueDetailDTO> issueDetailList = new ArrayList<>();

        List<IssueDTO> issueDTOList = issueList.stream().map(issue -> modelMapper.map(issue, IssueDTO.class)).collect(Collectors.toList());
        IssueFranchiseInfoDTO issueFranchiseInfoDTO = modelMapper.map(issueFranchiseInfo, IssueFranchiseInfoDTO.class);
        List<IssueFranchiseAccountDTO> issueFranchiseAccountDTOList = issueFranchiseAccountList.stream().map(issueFranchiseAccount -> modelMapper.map(issueFranchiseAccount, IssueFranchiseAccountDTO.class)).collect(Collectors.toList());

        for(int i = 0; i < issueDTOList.size(); i++) {

            int issuePresenterNo = issueDTOList.get(i).getFranchiseIssuePresenter().getMemberNo();
            int representativeNo = issueFranchiseInfoDTO.getFranchiseRepresentativeNo();

            IssueDetailDTO issueDetail = new IssueDetailDTO();
            issueDetail.setFranchiseIssueNo(issueDTOList.get(i).getFranchiseIssueNo());
            issueDetail.setFranchiseIssueTitle(issueDTOList.get(i).getFranchiseIssueTitle());
            issueDetail.setFranchiseIssueBody(issueDTOList.get(i).getFranchiseIssueBody());
            issueDetail.setFranchiseIssuePresenter(issueDTOList.get(i).getFranchiseIssuePresenter());
            issueDetail.setFranchiseIssueCreatedDate(issueDTOList.get(i).getFranchiseIssueCreatedDate());
            issueDetail.setFranchiseIssueStatus(issueDTOList.get(i).getFranchiseIssueStatus());
            issueDetail.setIssueFranchiseInfo(issueFranchiseInfoDTO);

            if(issuePresenterNo != representativeNo) {

                for(int j = 0; j < issueFranchiseAccountDTOList.size(); j++) {

                    int managerNo = issueFranchiseAccountDTOList.get(j).getFranchiseManagerNo();

                    if(issuePresenterNo == managerNo) {

                        issueDetail.setIssueFranchiseAccount(issueFranchiseAccountDTOList.get(j));

                    }
                }
            }

            if(issueDTOList.get(i).getFranchiseIssueCompleter() != null) {
                issueDetail.setFranchiseIssueCompleter(issueDTOList.get(i).getFranchiseIssueCompleter());
                issueDetail.setFranchiseIssueStatusFinishDate(issueDTOList.get(i).getFranchiseIssueStatusFinishDate());
            }

            issueDetailList.add(issueDetail);

        }

        return issueDetailList;
    }

    private List<IssueDetailDTO> setIssueDetail(List<Issue> issueList, List<IssueFranchiseInfo> issueFranchiseInfoList, List<IssueFranchiseAccount> franchiseAccountList) {

        List<IssueDetailDTO> issueDetailList = new ArrayList<>();

        List<IssueDTO> issueDTOList = issueList.stream().map(issue -> modelMapper.map(issue, IssueDTO.class)).collect(Collectors.toList());
        List<IssueFranchiseInfoDTO> issueFranchiseInfoDTOList = issueFranchiseInfoList.stream().map(issueFranchiseInfo -> modelMapper.map(issueFranchiseInfo, IssueFranchiseInfoDTO.class)).collect(Collectors.toList());
        List<IssueFranchiseAccountDTO> issueFranchiseAccountDTOList = franchiseAccountList.stream().map(issueFranchiseAccount -> modelMapper.map(issueFranchiseAccount, IssueFranchiseAccountDTO.class)).collect(Collectors.toList());

        for(int i = 0; i < issueDTOList.size(); i++) {

            for(int j = 0; j < issueFranchiseInfoDTOList.size(); j++) {

                int issuePresenterNo = issueDTOList.get(i).getFranchiseIssuePresenter().getMemberNo();
                int representativeNo = issueFranchiseInfoDTOList.get(j).getFranchiseRepresentativeNo();

                if(issuePresenterNo == representativeNo) {

                    IssueDetailDTO issueDetail = new IssueDetailDTO();
                    issueDetail.setFranchiseIssueNo(issueDTOList.get(i).getFranchiseIssueNo());
                    issueDetail.setFranchiseIssueTitle(issueDTOList.get(i).getFranchiseIssueTitle());
                    issueDetail.setFranchiseIssueBody(issueDTOList.get(i).getFranchiseIssueBody());
                    issueDetail.setFranchiseIssuePresenter(issueDTOList.get(i).getFranchiseIssuePresenter());
                    issueDetail.setFranchiseIssueCreatedDate(issueDTOList.get(i).getFranchiseIssueCreatedDate());
                    issueDetail.setFranchiseIssueStatus(issueDTOList.get(i).getFranchiseIssueStatus());
                    issueDetail.setIssueFranchiseInfo(issueFranchiseInfoDTOList.get(j));

                    if(issueDTOList.get(i).getFranchiseIssueCompleter() != null) {
                        issueDetail.setFranchiseIssueCompleter(issueDTOList.get(i).getFranchiseIssueCompleter());
                        issueDetail.setFranchiseIssueStatusFinishDate(issueDTOList.get(i).getFranchiseIssueStatusFinishDate());
                    }

                    issueDetailList.add(issueDetail);
                }

            }

            for(int k = 0; k < issueFranchiseAccountDTOList.size(); k++) {

                int issuePresenterNo = issueDTOList.get(i).getFranchiseIssuePresenter().getMemberNo();
                int managerNo = issueFranchiseAccountDTOList.get(k).getFranchiseManagerNo();

                if(issuePresenterNo == managerNo) {

                    IssueDetailDTO issueDetail = new IssueDetailDTO();
                    issueDetail.setFranchiseIssueNo(issueDTOList.get(i).getFranchiseIssueNo());
                    issueDetail.setFranchiseIssueTitle(issueDTOList.get(i).getFranchiseIssueTitle());
                    issueDetail.setFranchiseIssueBody(issueDTOList.get(i).getFranchiseIssueBody());
                    issueDetail.setFranchiseIssuePresenter(issueDTOList.get(i).getFranchiseIssuePresenter());
                    issueDetail.setFranchiseIssueCreatedDate(issueDTOList.get(i).getFranchiseIssueCreatedDate());
                    issueDetail.setFranchiseIssueStatus(issueDTOList.get(i).getFranchiseIssueStatus());
                    issueDetail.setIssueFranchiseAccount(issueFranchiseAccountDTOList.get(k));
                    issueDetail.setIssueFranchiseInfo(issueFranchiseAccountDTOList.get(k).getFranchiseInfo());

                    if(issueDTOList.get(i).getFranchiseIssueCompleter() != null) {
                        issueDetail.setFranchiseIssueCompleter(issueDTOList.get(i).getFranchiseIssueCompleter());
                        issueDetail.setFranchiseIssueStatusFinishDate(issueDTOList.get(i).getFranchiseIssueStatusFinishDate());
                    }

                    issueDetailList.add(issueDetail);

                }

            }

        }

        return issueDetailList;
    }

    @Test
    @DisplayName("이슈 상세 조회 메소드 테스트")
    @Transactional
    public void selectIssueDetail() {

        //given
        int issueNo = 81;

        //when
        Issue issue = issueRepository.findById(issueNo).get();

        List<IssueAttachmentFile> attachmentFileList = issueAttachmentFileRepository.findByIssue_FranchiseIssueNoAndAttachmentFileDeleteYn(issueNo, "N");
        List<String> fileList = new ArrayList<>();

        IssueDTO issueDTO = modelMapper.map(issue, IssueDTO.class);

        if(attachmentFileList != null) {
            for(int i = 0; i < attachmentFileList.size(); i++) {

                fileList.add(attachmentFileList.get(i).getAttachmentFileThumbnailUrl());
            }

            issueDTO.setIssueFileList(fileList);
        }

        //then
        assertNotNull(issueDTO);

    }

    @Test
    @DisplayName("이슈 등록 발주 목록 조회 메소드 테스트")
    public void selectIssueOrderList() {

        //given
        String officeDivision = "대표자";
        int memberNo = 3;

        //when
        List<FranchiseOrder> franchiseOrderList = new ArrayList<>();
        List<FranchiseOrder> detailOrderList = new ArrayList<>();

        if("대표자".equals(officeDivision)) {

            IssueFranchiseInfo issueFranchiseInfo = issueFranchiseInfoRepository.findById(memberNo).get();

            List<IssueFranchiseAccount> issueFranchiseAccountList = issueFranchiseAccountRepository.findByFranchiseInfo_FranchiseRepresentativeNo(issueFranchiseInfo.getFranchiseRepresentativeNo());

            franchiseOrderList = franchiseOrderRepository.findByMember_MemberNo(issueFranchiseInfo.getFranchiseRepresentativeNo());

            for(int i = 0; i < issueFranchiseAccountList.size(); i++) {

                List<FranchiseOrder> franchiseOrderListByManager = franchiseOrderRepository.findByMember_MemberNo(issueFranchiseAccountList.get(i).getFranchiseManagerNo());

                for(int j = 0; j < franchiseOrderListByManager.size(); j++) {

                    franchiseOrderList.add(franchiseOrderListByManager.get(j));

                }

            }

            for(int i = 0; i < franchiseOrderList.size(); i++) {

                IssueOutWarehouse issueOutWarehouse = issueOutWarehouseRepository.findByFranchiseOrder_FranchiseOrderNoAndIssueOutWarehouseWorkingStatusName(franchiseOrderList.get(i).getFranchiseOrderNo(), "출고완료");

                if(issueOutWarehouse != null) {

                    detailOrderList.add(franchiseOrderList.get(i));
                }
            }

        } else {

            IssueFranchiseAccount issueFranchiseAccount = issueFranchiseAccountRepository.findById(memberNo).get();

            IssueFranchiseInfo issueFranchiseInfo = issueFranchiseInfoRepository.findById(issueFranchiseAccount.getFranchiseInfo().getFranchiseRepresentativeNo()).get();

            List<IssueFranchiseAccount> issueFranchiseAccountList = issueFranchiseAccountRepository.findByFranchiseInfo_FranchiseRepresentativeNo(issueFranchiseInfo.getFranchiseRepresentativeNo());

            franchiseOrderList = franchiseOrderRepository.findByMember_MemberNo(issueFranchiseInfo.getFranchiseRepresentativeNo());

            for(int i = 0; i < issueFranchiseAccountList.size(); i++) {

                List<FranchiseOrder> franchiseOrderListByManager = franchiseOrderRepository.findByMember_MemberNo(issueFranchiseAccountList.get(i).getFranchiseManagerNo());

                for(int j = 0; j < franchiseOrderListByManager.size(); j++) {

                    franchiseOrderList.add(franchiseOrderListByManager.get(j));

                }

            }

            for(int i = 0; i < franchiseOrderList.size(); i++) {

                IssueOutWarehouse issueOutWarehouse = issueOutWarehouseRepository.findByFranchiseOrder_FranchiseOrderNoAndIssueOutWarehouseWorkingStatusName(franchiseOrderList.get(i).getFranchiseOrderNo(), "출고완료");

                if(issueOutWarehouse != null) {

                    detailOrderList.add(franchiseOrderList.get(i));
                }
            }

        }

        //then
        assertNotNull(detailOrderList);

    }

    @Test
    @DisplayName("이슈 삭제 메소드 테스트")
    @Transactional
    public void deleteIssue() {

        //given
        int removeIssueNo = 81;

        //when
        Issue deleteIssue = issueRepository.findById(removeIssueNo).get();
        List<IssueItem> deleteIssueItemList = issueItemRepository.findByIssue_FranchiseIssueNo(removeIssueNo);
        List<IssueHistory> deleteIssueHistoryList = issueHistoryRepository.findByIssue_FranchiseIssueNo(removeIssueNo);
        List<IssueAttachmentFile> deleteIssueAttachmentFileList = issueAttachmentFileRepository.findByIssue_FranchiseIssueNo(removeIssueNo);

        for(int i = 0; i < deleteIssueAttachmentFileList.size(); i++) {

            issueAttachmentFileRepository.delete(deleteIssueAttachmentFileList.get(i));
        }


        for(int i = 0; i < deleteIssueHistoryList.size(); i++) {

            issueHistoryRepository.delete(deleteIssueHistoryList.get(i));
        }


        for(int i = 0; i < deleteIssueItemList.size(); i++) {

            issueItemRepository.delete(deleteIssueItemList.get(i));

        }

        issueRepository.delete(deleteIssue);

        //then
        assertNotNull(issueRepository.findById(removeIssueNo));

    }

    @Test
    @DisplayName("이슈 처리 상태 변경")
    @Transactional
    public void updateIssueStatus() {

        //given
        int issueNo = 81;
        String status = "COMPLETE";

        Member member = new Member();
        member.setMemberNo(107);

        //when
        Issue issue = issueRepository.findById(issueNo).get();
        issue.setFranchiseIssueStatus(status);

        IssueHistory issueHistory = new IssueHistory();
        issueHistory.setIssue(issue);
        issueHistory.setFranchiseIssueHistoryUpdateMember(member);
        issueHistory.setFranchiseIssueHistoryStatus(status);
        issueHistory.setFranchiseIssueHistoryDate(new Date(System.currentTimeMillis()));

        IssueCompanyAccount issueCompanyAccount = null;

        if("COMPLETE".equals(status)) {

            issueCompanyAccount = issueCompanyAccountRepository.findById(member.getMemberNo()).get();

            issue.setFranchiseIssueCompleter(issueCompanyAccount);
            issue.setFranchiseIssueStatusFinishDate(new Date(System.currentTimeMillis()));

            issueHistory.setFranchiseIssueHistoryCompleter(issueCompanyAccount);
        }

        //then
        assertNotNull(issueCompanyAccount);
        assertNotNull(issue);
        assertTrue(issueHistory.getFranchiseIssueHistoryCompleter() == issueCompanyAccount);


    }
}