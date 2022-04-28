package com.greedy.jaegojaego.franchise.service;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.config.BeanConfiguration;
import com.greedy.jaegojaego.config.JaegojaegoApplication;
import com.greedy.jaegojaego.config.JpaConfiguration;
import com.greedy.jaegojaego.franchise.entity.FranchiseAccount;
import com.greedy.jaegojaego.franchise.entity.FranchiseAttachmentFile;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.franchise.repository.FranchiseRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, JaegojaegoApplication.class, BeanConfiguration.class})
class FranchiseServiceTest {

    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void initTest() {

    }

    @Test
    public void 계정생성() {

        FranchiseInfo franchiseInfo = new FranchiseInfo();
        franchiseInfo.setMemberId("gangnam333");
        franchiseInfo.setMemberPwd(passwordEncoder.encode("0000"));
        franchiseInfo.setMemberPwdInitStatus("Y");
        franchiseInfo.setMemberCreatedDate(LocalDateTime.now());
        franchiseInfo.setMemberRemoveStatus("Y");
        franchiseInfo.setMemberRemoveStatus("Y");
        franchiseInfo.setMemberDivision("가맹점");
        franchiseInfo.setFranchiseDivision("대표자");
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
}