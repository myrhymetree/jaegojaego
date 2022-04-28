package com.greedy.jaegojaego.franchise.service;

import com.greedy.jaegojaego.franchise.dto.FranchiseInfoDTO;
import com.greedy.jaegojaego.franchise.entity.FranchiseInfo;
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
    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FranchiseService(FranchiseRepository franchiseReopsitory, MemberRepository memberRepository, MemberRoleRepository memberRoleRepository, ModelMapper modelMapper) {
        this.franchiseReopsitory = franchiseReopsitory;
        this.memberRepository = memberRepository;
        this.memberRoleRepository = memberRoleRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void registFranchise(FranchiseInfoDTO franchiseInfo) {

        FranchiseInfo franchise = modelMapper.map(franchiseInfo, FranchiseInfo.class);

        memberRepository.save(franchise);

        MemberRolePK memberRolePK = new MemberRolePK();
        memberRolePK.setAuthorityCode(3);
        memberRolePK.setMemberNo(franchise.getMemberNo());
        MemberRole memberRole = new MemberRole();
        memberRole.setMemberRolePK(memberRolePK);

        memberRoleRepository.save(memberRole);
    }
}
