package com.greedy.jaegojaego.member.model.service;

import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.DepartmentDTO;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.entity.*;
import com.greedy.jaegojaego.member.model.repository.CompanyAccountRepository;
import com.greedy.jaegojaego.member.model.repository.DepartmentRepository;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
import com.greedy.jaegojaego.member.model.repository.MemberRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final DepartmentRepository departmentRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final CompanyAccountRepository companyAccountRepository;
    private final ModelMapper modelMappper;

    @Autowired
    public MemberService(MemberRepository memberRepository, DepartmentRepository departmentRepository, MemberRoleRepository memberRoleRepository, CompanyAccountRepository companyAccountRepository, ModelMapper modelMappper) {
        this.memberRepository = memberRepository;
        this.departmentRepository = departmentRepository;
        this.memberRoleRepository = memberRoleRepository;
        this.companyAccountRepository = companyAccountRepository;
        this.modelMappper = modelMappper;
    }

    public MemberDTO findMemberById(String memberId) {

        Member member = memberRepository.findMemberByMemberId(memberId);

        return modelMappper.map(member, MemberDTO.class);
    }

    @Transactional
    public void registNewMember(CompanyAccountDTO newMember) {

        Department department = departmentRepository.findByDepartmentNo(newMember.getDepartment().getDepartmentNo());

        DepartmentDTO departmentDTO = modelMappper.map(department, DepartmentDTO.class);

        newMember.setDepartment(departmentDTO);

        CompanyAccount member = modelMappper.map(newMember, CompanyAccount.class);

        CompanyAccount registedMember = memberRepository.save(member);

        MemberRolePK memberRolePK  = new MemberRolePK();
        memberRolePK.setAuthorityCode(2);
        memberRolePK.setMemberNo(registedMember.getMemberNo());
        MemberRole memberRole = new MemberRole();
        memberRole.setMemberRolePK(memberRolePK);

        memberRoleRepository.save(memberRole);

//        Member member = new Member();
//        CompanyAccount companyAccount = new CompanyAccount();
//        companyAccount.setMemberNo(modelMappper.map(newMember, Member.class).getMemberNo());
//        memberRepository.save(memberrole);

    }

    public List<DepartmentDTO> findDepartmentAll() {

        List<Department> departmentList = departmentRepository.findAll();

        return departmentList.stream().map(department -> modelMappper.map(department, DepartmentDTO.class)).collect(Collectors.toList());
    }

    public boolean duplicationCheckId(String memberId) {

        boolean status = memberRepository.existsByMemberId(memberId);

        return status;
    }

    public List<CompanyAccountDTO> findMemberList() {

        List<CompanyAccount> memberList = companyAccountRepository.findAll();

        List<CompanyAccountDTO> memberDTOlist =  memberList.stream().map(member -> modelMappper.map(member, CompanyAccountDTO.class)).collect(Collectors.toList());

        return memberDTOlist;

    }

    public Integer countAll() {

        Integer count = companyAccountRepository.countAllBy();

        return count;
    }
}