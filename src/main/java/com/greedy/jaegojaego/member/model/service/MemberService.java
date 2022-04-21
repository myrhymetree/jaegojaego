package com.greedy.jaegojaego.member.model.service;

import com.greedy.jaegojaego.member.model.dto.MemberDTO;
import com.greedy.jaegojaego.member.model.entity.Member;
import com.greedy.jaegojaego.member.model.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMappper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMappper) {
        this.memberRepository = memberRepository;
        this.modelMappper = modelMappper;
    }

    public MemberDTO findMemberById(String memberId) {

        Member member = memberRepository.findMemberByMemberId(memberId);

        return modelMappper.map(member, MemberDTO.class);
    }

    @Transactional
    public void registNewMember(MemberDTO newMember) {

        memberRepository.save(modelMappper.map(newMember, Member.class));
    }

//    public boolean                                                      duplicationCheckId(String memberId) {
//
//        return memberRepository.duplicationCheckId(memberId) != null;
//    }
}
