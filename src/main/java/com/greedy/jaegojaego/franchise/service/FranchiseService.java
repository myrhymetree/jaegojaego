package com.greedy.jaegojaego.franchise.service;

import com.greedy.jaegojaego.franchise.dto.FranchiseContractUpdatedRecordDTO;
import com.greedy.jaegojaego.franchise.dto.FranchiseInfoDTO;
import com.greedy.jaegojaego.franchise.entity.FranchiseContractUpdatedRecord;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
import com.greedy.jaegojaego.franchise.repository.FranchiseContractRepository;
import com.greedy.jaegojaego.franchise.repository.FranchiseRepository;
import com.greedy.jaegojaego.member.model.entity.MemberRole;
import com.greedy.jaegojaego.member.model.entity.MemberRolePK;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
import com.greedy.jaegojaego.member.model.repository.MemberRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FranchiseService {

    private final FranchiseRepository franchiseReopsitory;
    private final FranchiseContractRepository franchiseContractRepository;
    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FranchiseService(FranchiseRepository franchiseReopsitory, FranchiseContractRepository franchiseContractRepository, MemberRepository memberRepository, MemberRoleRepository memberRoleRepository, ModelMapper modelMapper) {
        this.franchiseReopsitory = franchiseReopsitory;
        this.franchiseContractRepository = franchiseContractRepository;
        this.memberRepository = memberRepository;
        this.memberRoleRepository = memberRoleRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void registFranchise(FranchiseInfoDTO franchiseInfo, FranchiseContractUpdatedRecordDTO franchiseContractUpdatedRecordDTO) {

        franchiseInfo.setOfficeDivision("대표자");

        FranchiseInfo franchise = modelMapper.map(franchiseInfo, FranchiseInfo.class);

        FranchiseInfo result = memberRepository.save(franchise);

        System.out.println("프렌차이즈는 : " + result);
        System.out.println("프렌차이즈는 : " + result);
        System.out.println("프렌차이즈는 : " + result);
        System.out.println("프렌차이즈는 : " + result);
        System.out.println("프렌차이즈는 : " + result);


        MemberRolePK memberRolePK = new MemberRolePK();
        memberRolePK.setAuthorityCode(3);
        memberRolePK.setMemberNo(franchise.getMemberNo());
        MemberRole memberRole = new MemberRole();
        memberRole.setMemberRolePK(memberRolePK);

        memberRoleRepository.save(memberRole);

        System.out.println("result.getMemberNo() = " + result.getMemberNo());
        System.out.println("result.getMemberNo() = " + result.getMemberNo());
        System.out.println("result.getMemberNo() = " + result.getMemberNo());
        System.out.println("result.getMemberNo() = " + result.getMemberNo());
        System.out.println("result.getMemberNo() = " + result.getMemberNo());

        franchiseContractUpdatedRecordDTO.setFranchiseRepresentativeNo(result.getMemberNo());
        System.out.println("franchiseContractUpdatedRecordDTO = " + franchiseContractUpdatedRecordDTO);
        System.out.println("franchiseContractUpdatedRecordDTO = " + franchiseContractUpdatedRecordDTO);
        System.out.println("franchiseContractUpdatedRecordDTO = " + franchiseContractUpdatedRecordDTO);
        System.out.println("franchiseContractUpdatedRecordDTO = " + franchiseContractUpdatedRecordDTO);
        System.out.println("franchiseContractUpdatedRecordDTO = " + franchiseContractUpdatedRecordDTO);
        System.out.println("franchiseContractUpdatedRecordDTO = " + franchiseContractUpdatedRecordDTO);

        FranchiseContractUpdatedRecord franchiseContractUpdatedRecord = modelMapper.map(franchiseContractUpdatedRecordDTO, FranchiseContractUpdatedRecord.class);

        System.out.println("franchiseContractUpdatedRecord는 " + franchiseContractUpdatedRecord);
        System.out.println("franchiseContractUpdatedRecord는 " + franchiseContractUpdatedRecord);
        System.out.println("franchiseContractUpdatedRecord는 " + franchiseContractUpdatedRecord);
        System.out.println("franchiseContractUpdatedRecord는 " + franchiseContractUpdatedRecord);
        System.out.println("franchiseContractUpdatedRecord는 " + franchiseContractUpdatedRecord);
        System.out.println("franchiseContractUpdatedRecord는 " + franchiseContractUpdatedRecord);


        franchiseContractRepository.save(franchiseContractUpdatedRecord);
    }
}
