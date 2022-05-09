package com.greedy.jaegojaego.issue.issue.model.service;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.issue.attachement.model.dto.IssueAttachmentFileDTO;
import com.greedy.jaegojaego.issue.attachement.model.entity.IssueAttachmentFile;
import com.greedy.jaegojaego.issue.attachement.model.repository.IssueAttachmentFileRepository;
import com.greedy.jaegojaego.issue.franchise.model.dto.IssueFranchiseAccountDTO;
import com.greedy.jaegojaego.issue.franchise.model.dto.IssueFranchiseInfoDTO;
import com.greedy.jaegojaego.issue.franchise.model.entity.IssueFranchiseAccount;
import com.greedy.jaegojaego.issue.franchise.model.entity.IssueFranchiseInfo;
import com.greedy.jaegojaego.issue.franchise.model.repository.IssueFranchiseAccountRepository;
import com.greedy.jaegojaego.issue.franchise.model.repository.IssueFranchiseInfoRepository;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDTO;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDetailDTO;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueItemDTO;
import com.greedy.jaegojaego.issue.issue.model.entity.Issue;
import com.greedy.jaegojaego.issue.issue.model.entity.IssueHistory;
import com.greedy.jaegojaego.issue.issue.model.entity.IssueItem;
import com.greedy.jaegojaego.issue.issue.model.repository.IssueHistoryRepository;
import com.greedy.jaegojaego.issue.issue.model.repository.IssueItemRepository;
import com.greedy.jaegojaego.issue.issue.model.repository.IssueRepository;
import com.greedy.jaegojaego.issue.outWarehouse.model.entity.IssueOutWarehouse;
import com.greedy.jaegojaego.issue.outWarehouse.model.repository.IssueOutWarehouseRepository;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.order.order.model.dto.franchise.FranchiseOrderDTO;
import com.greedy.jaegojaego.order.order.model.entity.franchise.FranchiseOrder;
import com.greedy.jaegojaego.order.order.model.repository.franchise.FranchiseOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {

    private final IssueFranchiseInfoRepository issueFranchiseInfoRepository;
    private final IssueFranchiseAccountRepository issueFranchiseAccountRepository;
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;
    private final FranchiseOrderRepository franchiseOrderRepository;
    private final IssueOutWarehouseRepository issueOutWarehouseRepository;
    private final IssueItemRepository issueItemRepository;
    private final IssueAttachmentFileRepository issueAttachmentFileRepository;
    private final IssueHistoryRepository issueHistoryRepository;

    @Autowired
    public IssueService(IssueFranchiseInfoRepository issueFranchiseInfoRepository, IssueFranchiseAccountRepository issueFranchiseAccountRepository
            , IssueRepository issueRepository, ModelMapper modelMapper, FranchiseOrderRepository franchiseOrderRepository
            , IssueOutWarehouseRepository issueOutWarehouseRepository, IssueItemRepository issueItemRepository
            , IssueAttachmentFileRepository issueAttachmentFileRepository, IssueHistoryRepository issueHistoryRepository) {
        this.issueFranchiseInfoRepository = issueFranchiseInfoRepository;
        this.issueFranchiseAccountRepository = issueFranchiseAccountRepository;
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
        this.franchiseOrderRepository = franchiseOrderRepository;
        this.issueOutWarehouseRepository = issueOutWarehouseRepository;
        this.issueItemRepository = issueItemRepository;
        this.issueAttachmentFileRepository = issueAttachmentFileRepository;
        this.issueHistoryRepository = issueHistoryRepository;
    }

    public List<IssueDetailDTO> selectIssueList(CustomUser customUser) {

        List<Issue> issueList = new ArrayList<>();
        List<IssueFranchiseAccount> franchiseAccountList = new ArrayList<>();
        List<IssueDetailDTO> issueDetailList = new ArrayList<>();

        if("본사".equals(customUser.getMemberDivision())) {

            List<IssueFranchiseInfo> issueFranchiseInfoList = issueFranchiseInfoRepository.findByHeadOfficeSupervisor_MemberNo(customUser.getMemberNo());

            for(int i = 0; i < issueFranchiseInfoList.size(); i++) {

                List<IssueFranchiseAccount> issueFranchiseAccountList = issueFranchiseAccountRepository.findByFranchiseInfo_FranchiseRepresentativeNo(issueFranchiseInfoList.get(i).getFranchiseRepresentativeNo());

                for(int j = 0; j < issueFranchiseAccountList.size(); j++) {

                    franchiseAccountList.add(issueFranchiseAccountList.get(j));

                }

            }

            issueList = issueRepository.findAll(Sort.by(Sort.Direction.DESC, "franchiseIssueNo"));

            issueDetailList = setIssueDetail(issueList, issueFranchiseInfoList, franchiseAccountList);

            return issueDetailList;

        } else if("가맹점".equals(customUser.getMemberDivision())) {

            if("대표자".equals(customUser.getOfficeDivision())) {

                IssueFranchiseInfo issueFranchiseInfo = issueFranchiseInfoRepository.findById(customUser.getMemberNo()).get();

                List<IssueFranchiseAccount> issueFranchiseAccountList = issueFranchiseAccountRepository.findByFranchiseInfo_FranchiseRepresentativeNo(issueFranchiseInfo.getFranchiseRepresentativeNo());

                issueList = issueRepository.findByFranchiseIssuePresenter_MemberNoOrderByFranchiseIssueCreatedDateDesc(customUser.getMemberNo());

                for(int i = 0; i < issueFranchiseAccountList.size(); i++) {

                    List<Issue> accountIssueList = issueRepository.findByFranchiseIssuePresenter_MemberNoOrderByFranchiseIssueCreatedDateDesc(issueFranchiseAccountList.get(i).getFranchiseManagerNo());

                    for(int j = 0; j < accountIssueList.size(); j++) {

                        issueList.add(accountIssueList.get(j));
                    }
                }

                issueDetailList = setIssueDetailByFranchise(issueList, issueFranchiseInfo, issueFranchiseAccountList);

            } else {

                IssueFranchiseAccount issueFranchiseAccount = issueFranchiseAccountRepository.findById(customUser.getMemberNo()).get();

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

        return issueDetailList;
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

    public IssueDTO selectIssueDetail(int issueNo) {

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

        return issueDTO;
    }

    public List<FranchiseOrderDTO> selectIssueOrderList(CustomUser customUser) {

        List<FranchiseOrder> franchiseOrderList = new ArrayList<>();
        List<FranchiseOrder> detailOrderList = new ArrayList<>();

        if("대표자".equals(customUser.getOfficeDivision())) {

            IssueFranchiseInfo issueFranchiseInfo = issueFranchiseInfoRepository.findById(customUser.getMemberNo()).get();

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

            IssueFranchiseAccount issueFranchiseAccount = issueFranchiseAccountRepository.findById(customUser.getMemberNo()).get();

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

        return detailOrderList.stream().map(franchiseOrder -> modelMapper.map(franchiseOrder, FranchiseOrderDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public void registIssue(CustomUser customUser, List<IssueAttachmentFileDTO> issueAttachmentFileList, IssueDTO issue, int orderNo, List<IssueItemDTO> issueItemList) {

        Issue registIssue = modelMapper.map(issue, Issue.class);

        List<IssueAttachmentFile> registIssueAttachmentFileList = null;

        if(issueAttachmentFileList != null) {
            registIssueAttachmentFileList = issueAttachmentFileList.stream().map(issueAttachmentFile -> modelMapper.map(issueAttachmentFile, IssueAttachmentFile.class)).collect(Collectors.toList());
        }

        List<IssueItem> registIssueItemList = issueItemList.stream().map(issueItem -> modelMapper.map(issueItem, IssueItem.class)).collect(Collectors.toList());

        Member member = new Member();
        member.setMemberNo(customUser.getMemberNo());

        registIssue.setFranchiseIssuePresenter(member);

        issueRepository.save(registIssue);

        int issueNo = issueRepository.selectIssueNo();
        
        Issue itemIssue = new Issue();
        itemIssue.setFranchiseIssueNo(issueNo);

        IssueHistory issueHistory = new IssueHistory();
        issueHistory.setIssue(itemIssue);
        issueHistory.setFranchiseIssueHistoryUpdateMember(member);
        issueHistory.setFranchiseIssueHistoryStatus("BEFORE");
        issueHistory.setFranchiseIssueHistoryDate(new Date(System.currentTimeMillis()));

        issueHistoryRepository.save(issueHistory);

        IssueOutWarehouse issueOutWarehouse = issueOutWarehouseRepository.findByFranchiseOrder_FranchiseOrderNoAndIssueOutWarehouseWorkingStatusName(orderNo, "출고완료");

        for(int i = 0; i < issueItemList.size(); i++) {

            registIssueItemList.get(i).setIssue(itemIssue);
            registIssueItemList.get(i).setIssueOutWarehouse(issueOutWarehouse);

            issueItemRepository.save(registIssueItemList.get(i));

        }

        if(registIssueAttachmentFileList != null) {

            for(int i = 0; i < registIssueAttachmentFileList.size(); i++) {

                registIssueAttachmentFileList.get(i).setIssue(registIssue);

                issueAttachmentFileRepository.save(registIssueAttachmentFileList.get(i));

            }
        }

    }

    @Transactional
    public void updateIssue(CustomUser customUser, List<IssueAttachmentFileDTO> issueAttachmentFileList, IssueDTO issue, int issueOrderNo, List<IssueItemDTO> issueItemList, int imgResetCheck) {

        Issue updateIssue = issueRepository.findById(issue.getFranchiseIssueNo()).get();
        updateIssue.setFranchiseIssueTitle(issue.getFranchiseIssueTitle());
        updateIssue.setFranchiseIssueBody(issue.getFranchiseIssueBody());

        List<IssueItem> issueItems = issueItemRepository.findByIssue_FranchiseIssueNo(issue.getFranchiseIssueNo());

        for(int i = 0; i < issueItems.size(); i++) {
            issueItemRepository.delete(issueItems.get(i));
        }

        Member member = new Member();
        member.setMemberNo(customUser.getMemberNo());

        IssueHistory issueHistory = new IssueHistory();
        issueHistory.setIssue(updateIssue);
        issueHistory.setFranchiseIssueHistoryUpdateMember(member);
        issueHistory.setFranchiseIssueHistoryStatus("BEFORE");
        issueHistory.setFranchiseIssueHistoryDate(new Date(System.currentTimeMillis()));

        issueHistoryRepository.save(issueHistory);

        IssueOutWarehouse issueOutWarehouse = issueOutWarehouseRepository.findByFranchiseOrder_FranchiseOrderNoAndIssueOutWarehouseWorkingStatusName(issueOrderNo, "출고완료");

        List<IssueItem> updateIssueItemList = issueItemList.stream().map(issueItem -> modelMapper.map(issueItem, IssueItem.class)).collect(Collectors.toList());

        for(int i = 0; i < issueItemList.size(); i++) {

            updateIssueItemList.get(i).setIssue(updateIssue);
            updateIssueItemList.get(i).setIssueOutWarehouse(issueOutWarehouse);

            issueItemRepository.save(updateIssueItemList.get(i));
        }

        if(imgResetCheck == 1) {

            List<IssueAttachmentFile> deleteIssueAttachmentFileList = issueAttachmentFileRepository.findByIssue_FranchiseIssueNoAndAttachmentFileDeleteYn(updateIssue.getFranchiseIssueNo(), "N");

            for(int i = 0; i < deleteIssueAttachmentFileList.size(); i++) {
                deleteIssueAttachmentFileList.get(i).setAttachmentFileDeleteYn("Y");
            }
        }

        List<IssueAttachmentFile> updateIssueAttachmentFileList = null;

        if(issueAttachmentFileList != null) {
            updateIssueAttachmentFileList = issueAttachmentFileList.stream().map(issueAttachmentFile -> modelMapper.map(issueAttachmentFile, IssueAttachmentFile.class)).collect(Collectors.toList());
        }

        if(updateIssueAttachmentFileList != null) {

            for(int i = 0; i < updateIssueAttachmentFileList.size(); i++) {

                updateIssueAttachmentFileList.get(i).setIssue(updateIssue);

                issueAttachmentFileRepository.save(updateIssueAttachmentFileList.get(i));

            }
        }

    }
}
