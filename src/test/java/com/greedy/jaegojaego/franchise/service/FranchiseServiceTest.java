package com.greedy.jaegojaego.franchise.service;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.franchise.dto.FranchiseAccountDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseDetailViewDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseInfoDTO;
import com.greedy.jaegojaego.franchise.entity.*;
import com.greedy.jaegojaego.franchise.repository.*;
import com.greedy.jaegojaego.member.model.entity.MemberRole;
import com.greedy.jaegojaego.member.model.entity.MemberRolePK;
import com.greedy.jaegojaego.member.model.repository.MemberRoleRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class})
class FranchiseServiceTest {

    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private FranchiseDetailViewReposirory franchiseDetailViewReposirory;

    @Autowired
    private FranchiseAccountRepository franchiseAccountRepository;

    @Autowired
    private FranchiseContractRepository franchiseContractRepository;

    @Autowired
    private FranchiseAttachmentRepository attachmentRepository;

    @Autowired
    private MemberRoleRepository memberRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {

    }

    @Test
    @Transactional
    public void 가맹점_대표_계정_생성() {

        FranchiseInfo franchiseInfo = new FranchiseInfo();
        franchiseInfo.setMemberId("gangnam333");
        franchiseInfo.setMemberPwd(passwordEncoder.encode("0000"));
        franchiseInfo.setMemberPwdInitStatus("Y");
        franchiseInfo.setMemberCreatedDate(LocalDateTime.now());
        franchiseInfo.setMemberRemoveStatus("Y");
        franchiseInfo.setMemberDivision("가맹점");
        franchiseInfo.setOfficeDivision("대표자");
        franchiseInfo.setRepresentativeName("박성준");
        franchiseInfo.setBranchName("강남점");
        franchiseInfo.setBusinessRegistrationNo("110-11111-11111");
        franchiseInfo.setAddress("서울특별시 강남구 강남대로1");
        franchiseInfo.setBankAccountNo("1000-000-000000");
        franchiseInfo.setWritedMemberNo(1);

        FranchiseAttachmentFile franchiseAttachmentFile1 = new FranchiseAttachmentFile();
        FranchiseAttachmentFile franchiseAttachmentFile2 = new FranchiseAttachmentFile();
        FranchiseAttachmentFile franchiseAttachmentFile3 = new FranchiseAttachmentFile();

        franchiseAttachmentFile1.setAttachmentFileOriginalName("강남점 가맹계약서.pdf");
        franchiseAttachmentFile1.setAttachmentFileChangedName("강남점 가맹계약서.pdf");
        franchiseAttachmentFile1.setAttachmentFileURL("/");
        franchiseAttachmentFile1.setAttachmentFileDeleteYn("Y");
        franchiseAttachmentFile1.setAttachmentFileCategoryNo(1);
        System.out.println("franchiseAttachmentFile1 = " + franchiseAttachmentFile1);

        franchiseAttachmentFile2.setAttachmentFileOriginalName("강남점 대표자 계좌확인서.pdf");
        franchiseAttachmentFile2.setAttachmentFileChangedName("강남점 대표자 계좌확인서.pdf");
        franchiseAttachmentFile2.setAttachmentFileURL("/");
        franchiseAttachmentFile2.setAttachmentFileDeleteYn("Y");
        franchiseAttachmentFile2.setAttachmentFileCategoryNo(2);
        System.out.println("franchiseAttachmentFile1 = " + franchiseAttachmentFile2);

        franchiseAttachmentFile3.setAttachmentFileOriginalName("강남점 사업자등록증.pdf");
        franchiseAttachmentFile3.setAttachmentFileChangedName("강남점 사업자등록증.pdf");
        franchiseAttachmentFile3.setAttachmentFileURL("/");
        franchiseAttachmentFile3.setAttachmentFileDeleteYn("Y");
        franchiseAttachmentFile3.setAttachmentFileCategoryNo(3);
        System.out.println("franchiseAttachmentFile1 = " + franchiseAttachmentFile3);

        List<FranchiseAttachmentFile> franchiseAttachmentFiles = new ArrayList<>();

        franchiseAttachmentFiles.add(0, franchiseAttachmentFile1);
        franchiseAttachmentFiles.add(1, franchiseAttachmentFile2);
        franchiseAttachmentFiles.add(2, franchiseAttachmentFile3);

        franchiseInfo.setFranchiseAttachmentFiles(franchiseAttachmentFiles);

        franchiseRepository.save(franchiseInfo);
    }

    @Test
    @Transactional
    public void 가맹점_직원_계정_생성() {

        FranchiseAccount franchiseAccount = new FranchiseAccount();

        franchiseAccount.setMemberId("undercafe");
        franchiseAccount.setMemberPwd(passwordEncoder.encode("0000"));
        franchiseAccount.setMemberPwdInitStatus("Y");
        franchiseAccount.setMemberCreatedDate(LocalDateTime.now());
        franchiseAccount.setMemberRemoveStatus("Y");
        franchiseAccount.setMemberDivision("가맹점");
        franchiseAccount.setOfficeDivision("직원");

        franchiseAccount.setManagerName("김성준");
        franchiseAccount.setManagerPhone("010-0000-0000");
        franchiseAccount.setManagerEmail("abc@gmail.com");
        franchiseAccount.setRepresentativeNo(1);

        FranchiseAccount account = franchiseAccountRepository.save(franchiseAccount);

        MemberRolePK memberRolePK = new MemberRolePK();
        memberRolePK.setAuthorityCode(3);
        memberRolePK.setMemberNo(account.getMemberNo());
        MemberRole memberRole = new MemberRole();
        memberRole.setMemberRolePK(memberRolePK);

        MemberRole role = memberRoleRepository.save(memberRole);

        assertEquals(account.getManagerName(), franchiseAccount.getManagerName());
        assertEquals(role.getMemberRolePK().getAuthorityCode(), 3);
        assertEquals(role.getAuthority().getAuthorityCode() , account.getMemberNo());
    }

    @Test
    @Transactional
    public void 가맹점_계정_목록_조회() {

        String searchWord = "강남";

        List<FranchiseInfo> franchiseInfos = franchiseRepository.searchFranchise(searchWord);

        List<FranchiseInfoDTO> franchiseInfoDTOS =
                franchiseInfos.stream().map(franchiseInfo -> modelMapper.map(franchiseInfo, FranchiseInfoDTO.class)).collect(Collectors.toList());

        franchiseInfoDTOS.forEach(row -> System.out.println(row));

        assertNotNull(franchiseInfos);

    }

    @Test
    @Transactional
    public void 가맹점_매니저_게정_목록_조회() {

        String searchWord = null;

        List<FranchiseAccount> franchiseAccounts = franchiseAccountRepository.searchManager(searchWord);

        List<FranchiseAccountDTO> franchiseAccountDTOS =
                franchiseAccounts.stream().map(manager -> modelMapper.map(manager, FranchiseAccountDTO.class)).collect(Collectors.toList());

        franchiseAccountDTOS.forEach(row -> System.out.println(row));

        assertNotNull(franchiseAccountDTOS);
    }

    @Test
    public void 가맹점_상세조회() {

        Integer franchiseNo = 429;

        FranchiseDetailView franchise = franchiseDetailViewReposirory.findByMemberNo(franchiseNo);

        FranchiseContractUpdatedRecord record = franchiseContractRepository.findByFranchiseRepresentativeNo(franchiseNo);
        System.out.println("records = " + record);

        franchise.setFranchiseContractUpdatedRecord(record);

        System.out.println("franchise = " + franchise);

        FranchiseDetailViewDTO result = modelMapper.map(franchise, FranchiseDetailViewDTO.class);

        assertEquals(franchiseNo, result.getMemberNo());
    }

    @Test
    public void 가맹점_관련_서류_다운로드() {

        Integer fileNo = 1;

        FranchiseAttachmentFile file = attachmentRepository.findByAttachmentNo(fileNo);

        System.out.println("fileNo = " + fileNo);

        assertEquals(1, file.getAttachmentNo());

    }


}