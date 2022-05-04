package com.greedy.jaegojaego.issue.issue.model.service;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.issue.franchise.model.dto.IssueFranchiseAccountDTO;
import com.greedy.jaegojaego.issue.franchise.model.dto.IssueFranchiseInfoDTO;
import com.greedy.jaegojaego.issue.franchise.model.entity.IssueFranchiseAccount;
import com.greedy.jaegojaego.issue.franchise.model.entity.IssueFranchiseInfo;
import com.greedy.jaegojaego.issue.franchise.model.repository.IssueFranchiseAccountRepository;
import com.greedy.jaegojaego.issue.franchise.model.repository.IssueFranchiseInfoRepository;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDTO;
import com.greedy.jaegojaego.issue.issue.model.dto.IssueDetailDTO;
import com.greedy.jaegojaego.issue.issue.model.entity.Issue;
import com.greedy.jaegojaego.issue.issue.model.repository.IssueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueService {

    private final IssueFranchiseInfoRepository issueFranchiseInfoRepository;
    private final IssueFranchiseAccountRepository issueFranchiseAccountRepository;
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IssueService(IssueFranchiseInfoRepository issueFranchiseInfoRepository, IssueFranchiseAccountRepository issueFranchiseAccountRepository
            , IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueFranchiseInfoRepository = issueFranchiseInfoRepository;
        this.issueFranchiseAccountRepository = issueFranchiseAccountRepository;
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
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
}
