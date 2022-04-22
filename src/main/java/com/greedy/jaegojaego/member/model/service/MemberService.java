package com.greedy.jaegojaego.member.model.service;

import com.greedy.jaegojaego.member.model.dto.CompanyAccountDTO;
import com.greedy.jaegojaego.member.model.dto.DepartmentDTO;
import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.dto.NewMemberDTO;
import com.greedy.jaegojaego.member.model.entity.*;
import com.greedy.jaegojaego.member.model.repository.DepartmentRepository;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
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
    private final ModelMapper modelMappper;

    @Autowired
    public MemberService(MemberRepository memberRepository, DepartmentRepository departmentRepository, ModelMapper modelMappper) {
        this.memberRepository = memberRepository;
        this.departmentRepository = departmentRepository;
        this.modelMappper = modelMappper;
    }

    public MemberDTO findMemberById(String memberId) {

        Member member = memberRepository.findMemberByMemberId(memberId);

        return modelMappper.map(member, MemberDTO.class);
    }

    @Transactional
    public void registNewMember(CompanyAccountDTO newMember) {

        MemberRolePK memberRolePK = new MemberRolePK();
        memberRolePK.setAuthorityCode(2);

        Department department = departmentRepository.findByDepartmentNo(newMember.getDepartment().getDepartmentNo());
        DepartmentDTO departmentDTO = modelMappper.map(department, DepartmentDTO.class);

        newMember.setDepartment(departmentDTO);
        System.out.println("newMember : " + newMember);
        System.out.println("newMember : " + newMember);
        System.out.println("newMember : " + newMember);
        System.out.println("newMember : " + newMember);

        memberRepository.save(modelMappper.map(newMember, CompanyAccount.class));

//        Member member = new Member();
//        CompanyAccount companyAccount = new CompanyAccount();
//        companyAccount.setMemberNo(modelMappper.map(newMember, Member.class).getMemberNo());
//        memberRepository.save(memberrole);

    }

    public List<DepartmentDTO> findDepartmentAll() {

        List<Department> departmentList = departmentRepository.findAll();

        return departmentList.stream().map(department -> modelMappper.map(department, DepartmentDTO.class)).collect(Collectors.toList());
    }

//    public boolean                                                      duplicationCheckId(String memberId) {
//
//        return memberRepository.duplicationCheckId(memberId) != null;
//    }
}