package com.greedy.jaegojaego.franchise.service;

import com.greedy.jaegojaego.authentification.model.dto.CustomUser;
import com.greedy.jaegojaego.franchise.dto.*;
import com.greedy.jaegojaego.franchise.entity.*;
import com.greedy.jaegojaego.franchise.repository.*;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.member.model.entity.MemberRole;
import com.greedy.jaegojaego.member.model.entity.MemberRolePK;
import com.greedy.jaegojaego.member.model.entity.PasswordUpdatedRecord;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
import com.greedy.jaegojaego.member.model.repository.MemberRoleRepository;
import com.greedy.jaegojaego.member.model.repository.PasswordUpdatedRecordRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : FranchiseService
 * Comment : 가맹점 계정 관련 서비스 메소드를 모아놓은 Service 클래스 입니다.
 * History
 * 2022.05.12 (박성준)
 * </pre>
 * @version 1.0
 * @author 박성준
 */
@Service
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final FranchiseDetailViewReposirory franchiseDetailViewReposirory;
    private final FranchiseAccountRepository franchiseAccountRepository;
    private final FranchiseContractRepository franchiseContractRepository;
    private final FranchiseAttachmentRepository franchiseAttachmentRepository;
    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final PasswordUpdatedRecordRepository passwordUpdatedRecordRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * strictModelMapper : modelMapper Strict 전략을 이용하기 위한 private 메소드
     * @return modelMapper : 매핑 전략을 사용하기 위한 modelMapper 객체 반환
     *
     * @author 박성준
     */
    private ModelMapper strictModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    /**
     * Instantiates a new Franchise service.
     *
     * @param franchiseRepository             the franchise repository
     * @param franchiseDetailViewReposirory   the franchise detail view reposirory
     * @param franchiseAccountRepository      the franchise account repository
     * @param franchiseContractRepository     the franchise contract repository
     * @param franchiseAttachmentRepository   the franchise attachment repository
     * @param memberRepository                the member repository
     * @param memberRoleRepository            the member role repository
     * @param passwordUpdatedRecordRepository the password updated record repository
     * @param modelMapper                     the model mapper
     * @param passwordEncoder                 the password encoder
     */
    @Autowired
    public FranchiseService(FranchiseRepository franchiseRepository, FranchiseDetailViewReposirory franchiseDetailViewReposirory, FranchiseAccountRepository franchiseAccountRepository, FranchiseContractRepository franchiseContractRepository, FranchiseAttachmentRepository franchiseAttachmentRepository, MemberRepository memberRepository, MemberRoleRepository memberRoleRepository, PasswordUpdatedRecordRepository passwordUpdatedRecordRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.franchiseRepository = franchiseRepository;
        this.franchiseDetailViewReposirory = franchiseDetailViewReposirory;
        this.franchiseAccountRepository = franchiseAccountRepository;
        this.franchiseContractRepository = franchiseContractRepository;
        this.franchiseAttachmentRepository = franchiseAttachmentRepository;
        this.memberRepository = memberRepository;
        this.memberRoleRepository = memberRoleRepository;
        this.passwordUpdatedRecordRepository = passwordUpdatedRecordRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 가맹점 대표자 계정 등록 메소드
     *
     * @param franchiseInfo                      가맹점 계정 정보
     * @param franchiseContractUpdatedRecordDTO  가맹점 계약 정보
     * @author 박성준
     */
    @Transactional
    public void registFranchise(FranchiseInfoDTO franchiseInfo, FranchiseContractUpdatedRecordDTO franchiseContractUpdatedRecordDTO) {

        franchiseInfo.setOfficeDivision("대표자");

        FranchiseInfo franchise = strictModelMapper().map(franchiseInfo, FranchiseInfo.class);

        FranchiseInfo result = memberRepository.save(franchise);

        MemberRolePK memberRolePK = new MemberRolePK();
        memberRolePK.setAuthorityCode(3);
        memberRolePK.setMemberNo(franchise.getMemberNo());
        MemberRole memberRole = new MemberRole();
        memberRole.setMemberRolePK(memberRolePK);

        memberRoleRepository.save(memberRole);

        franchiseContractUpdatedRecordDTO.setFranchiseRepresentativeNo(result.getMemberNo());

        FranchiseContractUpdatedRecord franchiseContractUpdatedRecord = strictModelMapper().map(franchiseContractUpdatedRecordDTO, FranchiseContractUpdatedRecord.class);

        franchiseContractRepository.save(franchiseContractUpdatedRecord);
    }

    /**
     * 가맹점 직원 계정 등록 메소드
     *
     * @param manager 가맹점 직원 계정 정보
     * @author 박성준
     */
    @Transactional
    public void registManager(FranchiseAccountDTO manager) {

        System.out.println("manager = " + manager);

        manager.setMemberPwd(passwordEncoder.encode(manager.getMemberPwd()));
        manager.setMemberCreatedDate(LocalDateTime.now());
        manager.setMemberPwdInitStatus("Y");
        manager.setMemberRemoveStatus("Y");
        manager.setOfficeDivision("직원");
        manager.setMemberDivision("가맹점");

        FranchiseAccount convertedManager = strictModelMapper().map(manager, FranchiseAccount.class);

        FranchiseAccount result = memberRepository.save(convertedManager);

        MemberRolePK memberRolePK = new MemberRolePK();
        memberRolePK.setAuthorityCode(4);
        memberRolePK.setMemberNo(result.getMemberNo());
        MemberRole memberRole = new MemberRole();
        memberRole.setMemberRolePK(memberRolePK);

        memberRoleRepository.save(memberRole);

    }

    /**
     * 모든 가맹점 대표자 계정 목록 메소드
     *
     * @return list 모든 가맹점 계정 대표자 목록
     * @author 박성준
     */
    public List<FranchiseInfoDTO> findAllFranchise() {

         List<FranchiseInfo> franchiseInfos = franchiseRepository.findAll();

         return franchiseInfos.stream().map(franchise -> strictModelMapper().map(franchise, FranchiseInfoDTO.class)).collect(Collectors.toList());

    }

    /**
     * 로그인한 가맹점 직원 계정 정보 수정 메소드
     *
     * @param manager 가맹점 직원 계정 정보
     */
    @Transactional
    public void modifyManagerInfoByMyself(FranchiseAccountDTO manager) {

        /* 로그인 인증 정보 가져오기 */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        /* entity타입으로 값 변경 */
        FranchiseAccount franchiseAccount = new FranchiseAccount();

        /* 비밀번호가 바뀔경우 변경된 비밀번호와 변경날짜, 변경상태를 넣어준다 */
        if(!manager.getMemberPwd().isEmpty()) {

            /* 비밀번호 변경이력 추가 */
            PasswordUpdatedRecord passwordUpdatedRecord = new PasswordUpdatedRecord();
            passwordUpdatedRecord.setPasswordUpdatedRecordPwd(customUser.getMemberPwd());
            passwordUpdatedRecord.setPasswordUpdatedRecordDate(LocalDateTime.now());
            passwordUpdatedRecord.setMemberNo(customUser.getMemberNo());

            franchiseAccount.setMemberPwd(passwordEncoder.encode(manager.getMemberPwd()));
            franchiseAccount.setMemberPwdUpdateDate(LocalDateTime.now());
            franchiseAccount.setMemberPwdInitStatus("N");

            passwordUpdatedRecordRepository.save(passwordUpdatedRecord);
        }

        franchiseAccount.setMemberNo(customUser.getMemberNo());
        franchiseAccount.setManagerEmail(manager.getManagerEmail());
        franchiseAccount.setManagerPhone(manager.getManagerPhone());

        franchiseAccountRepository.updateManager(franchiseAccount);

    }

    /**
     * 로그인한 가맹점 대표자 계정 정보 수정 메소드
     *
     * @param franchiseInfo 가맹점 대표자 계정 정보
     * @author 박성준
     */
    @Transactional
    public void updateFranchiseInfo(FranchiseInfoDTO franchiseInfo) {

        /* 로그인 인증 정보 가져오기 */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CustomUser customUser = (CustomUser) authentication.getPrincipal();

        /* entity타입으로 값 변경 */
        FranchiseInfo franchise = new FranchiseInfo();

        /* 비밀번호가 바뀔 경우 변경된 비밀번호와 변경 날짜, 변경상태를 넣어준다 */
        if(!franchiseInfo.getMemberPwd().isEmpty()) {
            /* 비밀번호 변경이력 추가 */
            PasswordUpdatedRecord passwordUpdatedRecord = new PasswordUpdatedRecord();
            passwordUpdatedRecord.setPasswordUpdatedRecordPwd(customUser.getMemberPwd());
            passwordUpdatedRecord.setPasswordUpdatedRecordDate(LocalDateTime.now());
            passwordUpdatedRecord.setMemberNo(customUser.getMemberNo());

            franchise.setMemberPwd(passwordEncoder.encode(franchiseInfo.getMemberPwd()));
            franchise.setMemberPwdUpdateDate(LocalDateTime.now());
            franchise.setMemberPwdInitStatus("N");

            passwordUpdatedRecordRepository.save(passwordUpdatedRecord);
        }

        franchise.setMemberNo(customUser.getMemberNo());
        franchise.setRepresentativeEmail(franchiseInfo.getRepresentativeEmail());
        franchise.setRepresentativePhone(franchiseInfo.getRepresentativePhone());
        franchise.setPhone(franchiseInfo.getPhone());

        franchiseRepository.updateFranchise(franchise);
    }

    /**
     * 가맹점 대표자 계정 목록 상세 정보 수정 메소드
     *
     * @param franchiseInfo 가맹점 대표자 계정 정보
     * @author 박성준
     */
    @Transactional
    public void updateFranchiseByCompany(FranchiseInfoDTO franchiseInfo) {

        /* 로그인 인증 정보 가져오기 */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        CustomUser loginUser = (CustomUser) authentication.getPrincipal();

        /* entity타입으로 값 변경 */
        FranchiseInfo franchise = new FranchiseInfo();

        if(!franchiseInfo.getMemberPwd().isEmpty()) {

            /* 비밀번호 변경할 가맹점 계정의 현재 비밀번호 찾기 */
            Member selectedMember = memberRepository.findMemberByMemberNo(franchiseInfo.getMemberNo());

            /* 비밀번호 변경이력 추가 */
            PasswordUpdatedRecord passwordUpdatedRecord = new PasswordUpdatedRecord();
            passwordUpdatedRecord.setPasswordUpdatedRecordPwd(selectedMember.getMemberPwd());
            passwordUpdatedRecord.setPasswordUpdatedRecordDate(LocalDateTime.now());
            passwordUpdatedRecord.setMemberNo(selectedMember.getMemberNo());

            franchise.setMemberPwd(passwordEncoder.encode(franchiseInfo.getMemberPwd()));
            franchise.setMemberPwdUpdateDate(LocalDateTime.now());
            franchise.setMemberPwdInitStatus("N");

            passwordUpdatedRecordRepository.save(passwordUpdatedRecord);
        }

        /* 빌더에 넣기 위해서 DTO타입을 Entity타입으로 변환 */
//        if(franchiseInfo.getFranchiseInfoUpdatedRecords().size() != 0) {
//            List<FranchiseContractUpdatedRecord> contracts = franchiseInfo.getFranchiseContractUpdatedRecords().stream().map(rep -> modelMapper.map(rep, FranchiseContractUpdatedRecord.class)).collect(Collectors.toList());
//            franchise.setFranchiseContractUpdatedRecords(contracts);
//        }

        franchise =
                FranchiseInfo.builder()
                        .memberNo(franchiseInfo.getMemberNo())
                        .memberPwd(passwordEncoder.encode(franchiseInfo.getMemberPwd()))
                        .branchName(franchiseInfo.getBranchName())
                        .representativeEmail(franchiseInfo.getRepresentativeEmail())
                        .phone(franchiseInfo.getPhone())
                        .representativePhone(franchiseInfo.getRepresentativePhone())
                        .address(franchiseInfo.getAddress())
                        .representativeName(franchiseInfo.getRepresentativeName())
                        .supervisorNo(franchiseInfo.getSupervisorNo())
                        .writedMemberNo(loginUser.getMemberNo())
                        .businessRegistrationNo(franchiseInfo.getBusinessRegistrationNo())
                        .bankAccountNo(franchiseInfo.getBankAccountNo())
                        .build();

        franchiseRepository.updateFranchise(franchise);
    }

    /**
     * 검색 조건에 의한 가맹점 계정 목록 조회 메소드
     *
     * @param searchWord 검색어
     * @return the franchise list dto 검색된 가맹점 계정 목록
     * @author 박성준
     */
    public FranchiseListDTO findFranchiseList(String searchWord) {

        /* 프랜차이즈 대표자 계정 목록 조회 */
        List<FranchiseInfo> franchiseList = franchiseRepository.searchFranchise(searchWord);
        List<FranchiseInfoDTO> franchises = franchiseList.stream().map(franchise -> strictModelMapper().map(franchise, FranchiseInfoDTO.class)).collect(Collectors.toList());

        /* 삭제된 프렌차이즈 대표자 계정 목록 조회 */
        List<FranchiseInfo> removedFranchiseList = franchiseRepository.searchRemovedFranchise(searchWord);
        List<FranchiseInfoDTO> removedFranchises = removedFranchiseList.stream().map(removedFrachise -> strictModelMapper().map(removedFrachise, FranchiseInfoDTO.class)).collect(Collectors.toList());

        /* 컨트롤러에 dto로 전달해주기 위해서 생성한 dto 클래스 */
        FranchiseListDTO franchiseListDTO = new FranchiseListDTO();
        franchiseListDTO.setFranchiseList(franchises);
        franchiseListDTO.setRemovedFranchiseList(removedFranchises);

        return franchiseListDTO;
    }

    /**
     * 가맹점 대표자 계정 상세정보 조회 메소드
     *
     * @param franchiseNo 계정번호(가맹점번호)
     * @return the franchise detail view dto 조회된 가맹점 대표자 계정 상세정보
     * @author 박성준
     */
    public FranchiseDetailViewDTO findFranchiseDetailInfo(Integer franchiseNo) {

        FranchiseDetailView franchiseDetailInfo = franchiseDetailViewReposirory.findByMemberNo(franchiseNo);

        FranchiseContractUpdatedRecord franchiseContractUpdatedRecord = franchiseContractRepository.findByFranchiseRepresentativeNo(franchiseNo);

        franchiseDetailInfo.setFranchiseContractUpdatedRecord(franchiseContractUpdatedRecord);

        System.out.println("franchiseContractUpdatedRecord = " + franchiseContractUpdatedRecord);

        return strictModelMapper().map(franchiseDetailInfo, FranchiseDetailViewDTO.class);
    }

    /**
     * 가맹점 직원 계정 상세정보 조회 메소드
     *
     * @param managerNo 계정번호(직원번호)
     * @return the franchise account dto 조회된 가맹점 직원 계정 상세정보
     * @author 박성준
     */
    public FranchiseAccountDTO findManagerDetailInfo(Integer managerNo) {

        FranchiseAccount managerDetailInfo = franchiseAccountRepository.findByMemberNo(managerNo);

        return strictModelMapper().map(managerDetailInfo, FranchiseAccountDTO.class);
    }

    /**
     * 계약 관련 첨부파일 조회 메소드
     *
     * @param fileNo 첨부파일 번호
     * @return the franchise attachment file dto 계약서 정보
     * @author 박성준
     */
    public FranchiseAttachmentFileDTO findContractFile(Integer fileNo) {

        FranchiseAttachmentFile contractFile = franchiseAttachmentRepository.findByAttachmentNo(fileNo);

        return strictModelMapper().map(contractFile, FranchiseAttachmentFileDTO.class);
    }

    /**
     * 사업자 등록증 첨부파일 조회 메소드
     *
     * @param fileNo 첨부파일 번호
     * @return the franchise attachment file dto 사업자등록증 정보
     * @author 박성준
     */
    public FranchiseAttachmentFileDTO findBusinessRegistration(Integer fileNo) {

        FranchiseAttachmentFile businessRegistrationFile = franchiseAttachmentRepository.findByAttachmentNo(fileNo);

        return strictModelMapper().map(businessRegistrationFile, FranchiseAttachmentFileDTO.class);
    }

    /**
     * 계좌확인서 첨부파일 조회 메소드
     *
     * @param fileNo 첨부파일 번호
     * @return the franchise attachment file dto
     * @author 박성준
     */
    public FranchiseAttachmentFileDTO findBusinesBankAccount(Integer fileNo) {

        FranchiseAttachmentFile bankAccoutFile = franchiseAttachmentRepository.findByAttachmentNo(fileNo);

        return strictModelMapper().map(bankAccoutFile, FranchiseAttachmentFileDTO.class);
    }

    /**
     * 검색결과에 따른 가맹점 직원 계정 목록 조회 메소드
     *
     * @param searchWord 검색어
     * @return the franchise list dto 검색된 가맹점 직원 계정 목록
     * @author 박성준
     */
    public FranchiseListDTO findManagerList(String searchWord) {

        /* 프렌차이즈 매니저 계정 목록 조회 및 dto타입으로 변환 */
        List<FranchiseAccount> managerList = franchiseAccountRepository.searchManager(searchWord);
        List<FranchiseAccountDTO> managers = managerList.stream().map(manager -> strictModelMapper().map(manager, FranchiseAccountDTO.class)).collect(Collectors.toList());

        /* 삭제된 프렌차이즈 매니저 계정 목록 조회 및 dto타입으로 변환 */
        List<FranchiseAccount> removedManagerList = franchiseAccountRepository.searchRemovedManager(searchWord);
        List<FranchiseAccountDTO> removedManagers = removedManagerList.stream().map(removedManager -> strictModelMapper().map(removedManager, FranchiseAccountDTO.class)).collect(Collectors.toList());

        /* 컨트롤러에 dto로 전달해주기 위해서 생성한 dto 클래스 */
        FranchiseListDTO franchiseListDTO = new FranchiseListDTO();
        franchiseListDTO.setManagerList(managers);
        franchiseListDTO.setRemovedManagerList(removedManagers);

        return franchiseListDTO;
    }

    public void updateManagerInfoByCompany(FranchiseAccountDTO manager) {

        franchiseAccountRepository.updateManager(strictModelMapper().map(manager, FranchiseAccount.class));
    }
}
